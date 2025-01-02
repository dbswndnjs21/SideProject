package com.sideproject.config;

import com.sideproject.filter.LoginFilter;
import com.sideproject.jwt.CustomLogoutFilter;
import com.sideproject.jwt.JWTFilter;
import com.sideproject.jwt.JWTUtil;
import com.sideproject.repository.RefreshRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
//    private final JwtTokenProvider jwtTokenProvider;
    //AuthenticationManager가 인자로 받을 AuthenticationConfiguraion 객체 생성자 주입
    private final AuthenticationConfiguration authenticationConfiguration;
    private final JWTUtil jwtUtil;
    private final RefreshRepository refreshRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // HTTP Basic 인증 비활성화
                .httpBasic(AbstractHttpConfigurer::disable)
                // form 로그인 비활성화
                .formLogin(AbstractHttpConfigurer::disable)
                // CSRF 비활성화
                .csrf(AbstractHttpConfigurer::disable)
                // 세션 사용 안 함
                .sessionManagement(sessionManagementConfigurer ->
                        sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 인증 및 권한 설정
                .authorizeHttpRequests(authorizeRequestsConfigurer ->
                        authorizeRequestsConfigurer
                                .requestMatchers("/login", "/", "/join").permitAll()
                                .requestMatchers("/members/sign-in").permitAll()
                                .requestMatchers("/members/sign-up").permitAll()
                                .requestMatchers("/members/test").hasRole("USER")
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .requestMatchers("/reissue").permitAll()
                                .requestMatchers("/index.html").permitAll()
                                // test용 html
                                .requestMatchers("/test.html").permitAll()
                                .requestMatchers("/ws/**", "/app/**", "/topic/**").permitAll()
                                .anyRequest().authenticated())
//                                .anyRequest().permitAll())
                // JWT 필터 추가
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
//                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTFilter(jwtUtil), LoginFilter.class)
                .addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil,refreshRepository), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new CustomLogoutFilter(jwtUtil, refreshRepository), LogoutFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt Encoder 사용2
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //AuthenticationManager Bean 등록
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }


}