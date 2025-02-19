package com.fawez.news.config;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class RateLimiterConfig {

    private final Map<String, Bucket> cache = new ConcurrentHashMap<>();

    public Bucket resolveBucket(String ipAddress) {
        return cache.computeIfAbsent(ipAddress, this::newBucket);
    }

    private Bandwidth newBandwidth() {
        return Bandwidth.classic(20, Refill.intervally(20, Duration.ofMinutes(5)));
    }

    private Bucket newBucket(String apiKey) {
        return Bucket.builder()
                .addLimit(newBandwidth())
                .build();
    }
}