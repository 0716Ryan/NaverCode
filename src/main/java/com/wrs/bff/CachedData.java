package com.wrs.bff;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    private Map<String,Object> cache = new HashMap<>();


    Object processCachedData(String key){
        lock.readLock().lock();
        Object value = null;
        try {
            value = cache.get(key);
            if (value == null) {
                lock.readLock().unlock();
                lock.writeLock().lock();
                try {
                    if (value == null){
                        System.out.println("无缓存，读取数据库");
                        value = "DBData";
                        cache.put(key,value);
                    }
                }finally {
                    lock.writeLock().unlock();
                }
                lock.readLock().lock();
            } else {
                System.out.println("走缓存");
                return value;
            }
        } finally {
            lock.readLock().unlock();
        }
        return value;


        }
    }


