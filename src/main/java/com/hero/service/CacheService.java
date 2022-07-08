package com.hero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;

public class CacheService {
    @Autowired
    CacheManager cacheManager;

    public void evictAllCaches() {
        cacheManager.getCacheNames().stream()
          .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }

    @Scheduled(fixedRateString = "PT23H")
    public void evictAllcachesAtIntervals() {
        evictAllCaches();
        cacheManager.getCache("").clear();
    }

}
