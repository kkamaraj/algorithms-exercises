package com.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by kkama4 on 9/17/16.
 */
public class MergeSortedList {
    public static void main(String args[]) {
        MergeSortedList merge = new MergeSortedList();
        int i = 0;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Random r = new Random();
        while (i < 5) {
            l1.add(r.nextInt((i+2)*2));
            l2.add(r.nextInt((i+2)*2));
            i++;
        }
        System.out.println(merge.buildSortedListWithLen(l1.subList(0, 2), l2.subList(0, 4), 4));
    }

    List<Integer> buildSortedListWithLen(List<Integer> a, List<Integer> b, int len) {
        List<Integer> sortedList = new ArrayList<>(len);
        if (a == null || b == null) {
            return null;
        }
        System.out.println(a);
        System.out.println(b);

        int i = 0, j = 0;
        while (sortedList.size() < len) {
            if (i < a.size() && j < b.size())
                if (a.get(i) <= b.get(j)) {
                    sortedList.add(a.get(i++));
                } else {
                    sortedList.add(b.get(j++));
            } else if (j < b.size()) {
                sortedList.add(b.get(j++));
            } else if (i < a.size()){
                sortedList.add(a.get(i++));
            }
        }
        return sortedList;
    }
}