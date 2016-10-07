package com.samples;

import java.io.*;
import java.util.Scanner;

public class CountInversions {

    static int[] input, aux;
    static long total = 0;
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("/Users/kkama4/Downloads/IntegerArray.txt"));
            //sc = new Scanner(new File("/Users/kkama4/Downloads/SampleArray.txt"));
        } catch (FileNotFoundException e) {
            return;
        }

        input = new int[100000];
        aux = new int[100000];
        int index = 0;
        while (sc.hasNext()) {
            input[index] = sc.nextInt();
            index++;
        }
        countInversion();
        System.out.println(total);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("/Users/kkama4/Downloads/IntegerArray1.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < input.length; i++) {
            writer.println(input[i]);
        }
        writer.close();


    }

    private static void countInversion() {
        countAndSort(0, input.length - 1);
    }

    private static void countAndSort(int lo, int hi) {
        //System.out.println("lo: " + lo + " hi: " + hi);
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        if (lo < hi) {
            countAndSort(lo, mid);
            countAndSort(mid + 1, hi);
            merge(lo, mid, hi);
        }
    }

    private static void merge(int lo, int mid, int hi) {
        //System.out.println("lo: " + lo + " mid: " + mid + " hi: " + hi);
        for (int k = lo; k <= hi; k++ ) {
            aux[k] = input[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) input[k] = aux[j++];
            else if (j > hi) input[k] = aux[i++];
            else if (aux[j] < aux[i]) {
                input[k] = aux[j++];
                //System.out.println("i: " + i + " mid: " + mid + " j: " + j);
                total += (mid - i + 1);
            } else {
                input[k] = aux[i++];
            }

        }
    }
}
