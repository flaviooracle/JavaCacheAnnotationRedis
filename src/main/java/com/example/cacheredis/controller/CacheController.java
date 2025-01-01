package com.example.cacheredis.controller;


import com.example.cacheredis.service.CacheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/limpar")
    public ResponseEntity<String> limparCache(@RequestParam(name="cacheName") String cacheName){
        cacheService.evictAllCacheValues(cacheName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
