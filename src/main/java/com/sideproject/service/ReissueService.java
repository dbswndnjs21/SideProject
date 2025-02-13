package com.sideproject.service;

import com.sideproject.entity.RefreshEntity;
import com.sideproject.jwt.JWTUtil;
import com.sideproject.repository.RefreshRepository;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReissueService {

    private final JWTUtil jwtUtil;
    private final RefreshRepository refreshRepository;

    public ResponseEntity<?> reissue(HttpServletRequest request, HttpServletResponse response) {
        // Get refresh token
        String refresh = getRefreshTokenFromCookies(request);

        if (refresh == null) {
            return new ResponseEntity<>("refresh token null", HttpStatus.BAD_REQUEST);
        }

        // Expired check
        try {
            jwtUtil.isExpired(refresh);
        } catch (ExpiredJwtException e) {
            System.out.println("refresh 토큰 만료");
            return new ResponseEntity<>("refresh token expired", HttpStatus.UNAUTHORIZED);
        }

        // 토큰이 refresh 인지 확인 (발급시 페이로드에 명시)
        if (!isRefreshToken(refresh)) {
            return new ResponseEntity<>("invalid refresh token", HttpStatus.BAD_REQUEST);
        }

        //DB에 저장되어 있는지 확인
        if (!refreshRepository.existsByRefresh(refresh)) {
            return new ResponseEntity<>("invalid refresh token", HttpStatus.BAD_REQUEST);
        }

        // Generate new tokens
        String username = jwtUtil.getUsername(refresh);
        String role = jwtUtil.getRole(refresh);
        String newAccess = jwtUtil.createJwt("access", username, role, 600000L);
        String newRefresh = jwtUtil.createJwt("refresh", username, role, 86400000L);

        // Update DB
        refreshRepository.deleteByRefresh(refresh);
        saveRefreshToken(username, newRefresh, 86400000L);

        // Set response
        setResponse(response, newAccess, newRefresh);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String getRefreshTokenFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("refresh")) {
                return cookie.getValue();
            }
        }

        return null;
    }

    private boolean isRefreshToken(String token) {
        String category = jwtUtil.getCategory(token);
        return category.equals("refresh");
    }

    private void saveRefreshToken(String username, String refresh, Long expiredMs) {
        Date expirationDate = new Date(System.currentTimeMillis() + expiredMs);

        RefreshEntity refreshEntity = RefreshEntity.builder()
                .username(username)
                .refresh(refresh)
                .expiration(expirationDate.toString())
                .build();

        refreshRepository.save(refreshEntity);
    }

    private void setResponse(HttpServletResponse response, String newAccess, String newRefresh) {
        response.setHeader("access", newAccess);
        response.addCookie(createHttpOnlyCookie("refresh", newRefresh));
    }

    private Cookie createHttpOnlyCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setHttpOnly(true);
        return cookie;
    }
}
