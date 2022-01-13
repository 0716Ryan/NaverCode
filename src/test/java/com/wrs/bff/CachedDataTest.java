package com.wrs.bff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CachedDataTest {

    @Test
    void processCachedData() {
        CachedData cachedData = new CachedData();
        cachedData.processCachedData("wrs");
        cachedData.processCachedData("wrs");

    }
}