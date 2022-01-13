package com.wrs.bff;

public class MyArrQueue {

    private Integer[] array;
    private Integer currentSize;
    private Integer first;
    private Integer last;


    public MyArrQueue() {
    }

    public MyArrQueue(Integer size){
        if (size < 0){
            throw new RuntimeException("设置队列值不小于0");
        }
        array = new Integer[size];
        currentSize = 0;
        first = 0;
        last = 0;
    }

    public void push(Integer num) {
        if (currentSize == array.length) {
            throw new RuntimeException("队列已满");
        }
        array[last] = num;
        currentSize++;
        if (last == array.length - 1) {
            last = 0;
        } else {
            last++;
        }
    }

    public Integer poll() {
        if (currentSize == 0) {
            throw new RuntimeException("队列为空");
        }
        int tempIndex = first;
       currentSize--;
        if (first == array.length - 1) {
            first = 0;
        } else {
            first++;
        }
        return array[tempIndex];
    }

    public Integer peek(){
        if (currentSize == 0){
            return null;
        }
        return array[first];
    }

    public void empty(){
        array = new Integer[array.length];
        currentSize = 0;
        first = 0;
        last = 0;
    }


    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }

    public Integer getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(Integer currentSize) {
        this.currentSize = currentSize;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }
}
