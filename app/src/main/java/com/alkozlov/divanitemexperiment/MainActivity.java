package com.alkozlov.divanitemexperiment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //               Class Fields

    private Converter converter;
    private Calculator calculator;

    //                    Fields

    private String dividend;
    private String divisor;
    private String quotient;

    private int space;

    int resultStringLength;


    //              Lists   Fields

    private  List<String> dividendNumberList;
    private List<String> resultList;
    private List<String> productList;

    private List<String> listForDivider;

    private List<String> listForDivisorPart;
    public Map<Integer, List<String>> resultMap;

    private List<String> listForAllParts;


    //              View Fields

    private RecyclerView numbersListRecyclerView;
    private RecyclerView divisorPartRecyclerView;

    private RecyclerView dividerRecyclerView;

    private ListOfNumbersAdapter listOfNumbersAdapter;
    private DivisorPartAdapter partOfDivisorAdapter;

    private DividerAdapter dividerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        dividend = "10000";
//        divisor = "1";

        dividend = "5623845";
        divisor = "51";


//        dividend = "182400";
//        divisor = "500";

//        dividend = "23156238454456";
//        divisor = "5";


        quotient =String.valueOf(Long.parseLong(dividend)/Long.parseLong(divisor));

//                     Initialization class fields

        converter = new Converter();
        calculator = new Calculator();

//                      Get results for RecyclerView

        dividendNumberList = converter.getListOfStrings(dividend);

        productList = calculator.getProductList(dividend, divisor);

        resultMap = calculator.getResultStrings(dividend, productList);

        String resultString = converter.mapToString(resultMap, productList, dividend);
        resultList = converter.getListOfStrings(resultString);
        resultStringLength = resultString.length();

        listForDivider = converter.listForDividerPart(dividendNumberList, resultList);

        String stringForDivisorPart =
                converter.getStringForDivisorPart(dividend, divisor, quotient, resultStringLength);
        listForDivisorPart = converter.getListOfStrings(stringForDivisorPart);

        listForAllParts = converter.getListForAllParts(dividendNumberList,
                resultList,
                listForDivisorPart);







//                           Dividend Part

        numbersListRecyclerView = findViewById(R.id.rv_number_line);







        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager( listForAllParts.size(), 1);
        staggeredGridLayoutManager.setSpanCount((dividendNumberList.size()*2 + Constants.SPACE));

        numbersListRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        numbersListRecyclerView.setHasFixedSize(true);

        listOfNumbersAdapter =
                new ListOfNumbersAdapter(listForAllParts.size(),
                        (dividendNumberList.size()*2 + Constants.SPACE),
                        listForAllParts);
        numbersListRecyclerView.setAdapter(listOfNumbersAdapter);






//
////                           Divider Part
//
//        dividerRecyclerView = findViewById(R.id.rv_divider_line);
//
//
//        GridLayoutManager gridLayoutManagerForDivider =
//                new GridLayoutManager(this, listForDivider.size());
//        gridLayoutManagerForDivider.setSpanCount(2);
//
//        dividerRecyclerView.setLayoutManager(gridLayoutManagerForDivider);
//        dividerRecyclerView.setHasFixedSize(true);
//
//        dividerAdapter = new DividerAdapter(listForDivider.size(), 2,listForDivider);
//        dividerRecyclerView.setAdapter(dividerAdapter);
//
////                           Divisor Part
//
//        divisorPartRecyclerView = findViewById(R.id.rv_divisor_part);
//
//
//        GridLayoutManager gridLayoutManager =
//                new GridLayoutManager(this, listForDivisorPart.size());
//        gridLayoutManager.setSpanCount(dividendNumberList.size());
//
////        StaggeredGridLayoutManager staggeredGridLMDivisorPart =
////                new StaggeredGridLayoutManager( listForDivisorPart.size(), 1);
////        staggeredGridLayoutManager.setSpanCount(dividendNumberList.size());
//
//        divisorPartRecyclerView.setLayoutManager(gridLayoutManager);
//        divisorPartRecyclerView.setHasFixedSize(true);
//
//        partOfDivisorAdapter =
//                new DivisorPartAdapter(listForDivisorPart.size()
//                        , dividendNumberList.size()
//                        , listForDivisorPart);
//
//        divisorPartRecyclerView.setAdapter(partOfDivisorAdapter);


















    }
}