package com.wrs.bff;

import java.util.HashMap;
import java.util.Map;

public class Test {


    public static void main(String[] args) {
        int[] first = {1,2,3,4,5};
        int[] last = {3,2,3,6,5};
        Map<String, Integer> sum = sum(first, last);
    }

    public static Map<String,Integer> sum(int[] arrayFirst, int[] arrayLast){
        int sum = 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i < arrayFirst.length; i++) {
            sum += arrayFirst[i] * arrayLast[i];
            int multi = arrayFirst[i] * arrayLast[i];
            if (multi > max){
                max = multi;
                index = i;
            }
        }
        HashMap<String,Integer> result = new HashMap<>();
        result.put("index",index);
        result.put("max",max);
        result.put("sum",sum);
        return result;
    }
}
