package com.turbo.app.turbovpnpro.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataItems {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableDetailList = new HashMap<String, List<String>>();

        // As we are populating List of fruits, vegetables and nuts, using them here
        // We can modify them as per our choice.
        // And also choice of fruits/vegetables/nuts can be changed
        List<String> fruits = new ArrayList<String>();
        fruits.add("City 1");
        fruits.add("City 2");
        fruits.add("City 3");
        fruits.add("City 4");


        List<String> vegetables = new ArrayList<String>();
        vegetables.add("City 1");
        vegetables.add("City 2");
        vegetables.add("City 3");
        vegetables.add("City 4");


        List<String> nuts = new ArrayList<String>();
        nuts.add("City 1");
        nuts.add("City 2");
        nuts.add("City 3");
        nuts.add("City 4");

        List<String> Country4 = new ArrayList<String>();
        Country4.add("City 1");
        Country4.add("City 2");
        Country4.add("City 3");
        Country4.add("City 4");


        // Fruits are grouped under Fruits Items. Similarly the rest two are under
        // Vegetable Items and Nuts Items respectively.
        // i.e. expandableDetailList object is used to map the group header strings to
        // their respective children using an ArrayList of Strings.
        expandableDetailList.put("Country 01", fruits);
        expandableDetailList.put("Country 02", vegetables);
        expandableDetailList.put("Country 03", nuts);
        expandableDetailList.put("Country 04", Country4);
        return expandableDetailList;
    }
}