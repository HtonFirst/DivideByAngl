package com.alkozlov.divanitemexperiment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Converter {

    public List<String> getListOfStrings(String str) {
        List<String> strings = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            strings.add(String.valueOf(ch));
        }
        return strings;
    }


    //                    make map to long string

    public String mapToString(Map<Integer, List<String>> map, List<String> productList, String dividend) {
        StringBuilder resBuilder = new StringBuilder(dividend);
//        resBuilder.append("|");

        for (Integer i : map.keySet()) {

            if (map.get(i).get(2).isBlank())  {
                continue;
            }
            if (productList.get(i).equals("0")) {
                if (i == productList.size() -1) {
                    resBuilder.append(map.get(i).get(2));
                }
                continue;
            }

            if (i != 0) {
                resBuilder.append(map.get(i).get(0));

            }

            resBuilder.append(map.get(i).get(1));


            if (i == map.size() - 1) {
                resBuilder.append(map.get(i).get(2));
            }


        }
        return resBuilder.toString();

    }



//                   return String for divisorPart recyclerView

    public String getStringForDivisorPart(String dividend, String divisor, String quotient, int length) {
        StringBuilder sb = new StringBuilder(divisor);
        while (sb.length() < dividend.length()) {
            sb.append(" ");

        }


        sb.append(quotient);
        while (sb.length()<dividend.length()*2) {
            sb.append(" ");
        }


        while (sb.length()<length) {
            for (int i = 0; i< dividend.length(); i++) {
                sb.append(" ");
            }

        }

        return sb.toString();


    }

    public List<String> listForDividerPart(List<String> dividendList, List<String> resultList){

        List<String> listForDivider = new ArrayList<>();

        Integer columns = dividendList.size();
        Integer length = resultList.size();

        Integer high = length/columns;
        Integer dividerLength = high*2;
        for (int i = 0; i < dividerLength; i++) {
            listForDivider.add(" ");
        }

        return listForDivider;
    }

    public List<String> getListForAllParts (List<String> dividendList,
            List<String> listOfDividendPart,
            List<String> listOfDivisorPart) {

        List<String> listForAllPart = new ArrayList<>();
        int columns = dividendList.size();
        int lengthOfPart = listOfDividendPart.size();
        System.out.println("div length = " + lengthOfPart);
        System.out.println("divisor length = " + listOfDivisorPart.size());
        int high = lengthOfPart/columns;

        for (int i = 0; i <= high-1; i++) {
            for (int j = 0; j < columns; j++) {
                listForAllPart.add(listOfDividendPart.get(j+(i*columns)));
            }

            for (int b = 0; b < Constants.SPACE; b++) {
                listForAllPart.add(" ");
//            listForAllPart.add(" ");
            }
            for (int c = 0; c < columns; c++) {
                listForAllPart.add(listOfDivisorPart.get(c+(i*columns)));
            }
        }

        return listForAllPart;


    }


}
