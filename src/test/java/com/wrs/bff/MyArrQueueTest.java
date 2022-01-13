package com.wrs.bff;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MyArrQueueTest {
    public static MyArrQueue queue;
    private Integer[] arr;


    @Test
    void push() {
        queue = new MyArrQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        Integer[] array = queue.getArray();
        assertArrayEquals(array, new Integer[]{1, 2, 3, 4, 5});


    }

    @Test
    void poll() {
        queue = new MyArrQueue(5);
        assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                queue.poll();
            }
        });
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        Integer[] array = queue.getArray();
        Integer poll = queue.poll();
        assertEquals(poll,1);
    }

    @Test
    void peek() {
        queue = new MyArrQueue(5);
        assertTrue(queue.peek() == null);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        Integer peek = queue.peek();
        assertEquals(peek,1);
    }

    @Test
    void empty() {
        queue = new MyArrQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.empty();
        assertTrue(queue.getCurrentSize()==0);
    }
}