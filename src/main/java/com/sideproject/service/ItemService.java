package com.sideproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final int MAX_COUNT = 10;
    private final RecentViewService recentViewService;

    public void addViewItem(Long userId, Long itemId) {
        // 우리 프로젝트에서는 유저에 userId가 아닌 username을 담아놔서 변환 필요
        recentViewService.addPostRecentView(userId, itemId);
    }

    public Set<Long> getViewItems(Long userId) {
        return recentViewService.getViewsData(userId, MAX_COUNT);
    }
}
