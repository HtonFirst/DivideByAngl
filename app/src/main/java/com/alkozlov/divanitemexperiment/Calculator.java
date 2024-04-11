package com.alkozlov.divanitemexperiment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {




    //                   Get map  Method last version


    public Map<Integer, List<String>> getResultStrings(String dividend, List<String> products) {


        Map<Integer, List<String>> resMap = new HashMap<>();
        StringBuilder operationDividend = new StringBuilder(dividend);

        int zeroCounter = 0;

        for (int i = 0; i < products.size(); i++) {

            StringBuilder productStringBuilder = new StringBuilder();


            StringBuilder differenceStringBuilder = new StringBuilder();


            StringBuilder comparativeDividend = new StringBuilder();
            char[] dividendChars = operationDividend.toString().toCharArray();



            Integer productInt =Integer.parseInt(products.get(i));


            for (int j = 0; j < operationDividend.length(); j++) {


                comparativeDividend.append(dividendChars[j]);
                Integer divInt = Integer.parseInt(comparativeDividend.toString());


                if (divInt >= productInt) {


                    productStringBuilder.append(products.get(i));
                    Integer diff = divInt - productInt;
                    differenceStringBuilder.append(diff.toString());

//                            Add spaces before numbers

//                    Add spaces before difference if compareDividend is longer

                    while (differenceStringBuilder.length() < comparativeDividend.length()){
                        differenceStringBuilder.insert(0, " ");
                    }

//                    Add spaces before product if compareDividend is longer

                    while (productStringBuilder.length()< comparativeDividend.length()){
                        productStringBuilder.insert(0, " ");
                    }

                    int operationSpacesLength = 0;


//                    for (int d = 0; d<operationDividend.length(); d++) {
//                        if (operationDividend.toString().startsWith("0")) {
//
//                        }
//                    }

                    int beforeSpaces = dividend.length() - operationDividend.length();

//                    if (beforeSpaces == 0 && operationDividend.toString().startsWith("0")){
//                        differenceStringBuilder.insert(0, " ");
//
//                    }


                    for (int c=0; c<beforeSpaces; c++) {
                        productStringBuilder.insert(0, " ");
                        differenceStringBuilder.insert(0, " ");
                        comparativeDividend.insert(0, " ");

                    }

                    operationDividend.replace(0, j+1, diff.toString());

//                           Add spaces after numbers

                    while (productStringBuilder.length()<dividend.length()){
                        productStringBuilder.append(" ");
                    }

                    while (differenceStringBuilder.length()<dividend.length()) {
                        differenceStringBuilder.append(" ");
                    }
                    while (comparativeDividend.length()<dividend.length()) {
                        comparativeDividend.append(" ");
                    }


                    List<String> listToMap = new ArrayList<>();
                    listToMap.add(comparativeDividend.toString());
                    listToMap.add(productStringBuilder.toString());
                    listToMap.add(differenceStringBuilder.toString());

                    resMap.put(i, listToMap);

                    comparativeDividend.setLength(0);
                    break;

                }
            }
        }


        return  resMap;
    }

//                        end of last version method

//                            Get Product List


    public List<String> getProductList(String dividend, String divisor) {
        Long quotient = Long.parseLong(dividend) / Long.parseLong(divisor);
        List<String> productList = new ArrayList<>();

        String quotientStr = String.valueOf(quotient);
        char[] chars = quotientStr.toCharArray();

        for (char ch : chars) {

            Integer chInt = Integer.parseInt(String.valueOf(ch));
            Integer product = Integer.parseInt(divisor) * chInt;
            productList.add(String.valueOf(product));

        }
        return productList;
    }


}
