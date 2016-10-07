package com.samples;

/**
 * Created by kkama4 on 9/17/16.
 */
public class ConvertToEnglish {
    String[] numbers = new String[] {" One", " Two", " Three", " Four", " Five",
                                    " Six", " Seven", " Eight", " Nine"};

    String[] numbers10 = new String[] {" Ten", " Twenty", " Thirty", " Forty", " Fifty",
            " Sixty", " Seventy", " Eighty", " Ninety"};

    String[] metrics = new String[] {" Hundred", " Thousand", " Million", " Billion"};
    public static void main(String[] args) {
        ConvertToEnglish c = new ConvertToEnglish();
        System.out.println(c.convertToEnglishRep(Integer.valueOf(args[0])));
    }

    String convertToEnglishRep(int num) {
        StringBuilder rep = new StringBuilder();
        if (num == 0) {
            return "Zero";
        } else if (num < 100) {
            return rep.append(numbers10[(num/10) - 1])
                    .append(numbers[(num%10) - 1]).toString();
        } else if (num < 1000) {
            return rep.append(convertLess1000ToEnglishRep(num)).toString();
        } else if (num < 10000) {
            return "";
        }
        return "";
    }

    String convertLess1000ToEnglishRep(int num) {
        StringBuilder rep = new StringBuilder();
        return rep.append(numbers[(num/100) - 1]).append(metrics[0]).append(" and")
                .append(numbers10[((num/10)%10) - 1])
                .append(numbers[(num%10) - 1]).toString();
    }
}
