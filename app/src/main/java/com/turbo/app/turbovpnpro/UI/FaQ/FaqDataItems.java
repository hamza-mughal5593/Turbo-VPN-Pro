package com.turbo.app.turbovpnpro.UI.FaQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FaqDataItems {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableDetailList = new HashMap<String, List<String>>();

        // As we are populating List of fruits, vegetables and nuts, using them here
        // We can modify them as per our choice.
        // And also choice of fruits/vegetables/nuts can be changed
        List<String> faq1 = new ArrayList<String>();
        faq1.add("VPN is virtual private network. It allows you to stay  private stay secure, and access any online content you  want -no matter where you are.");



        List<String> faq2 = new ArrayList<String>();
        faq2.add("VPN is virtual private network. It allows you to stay  private stay secure, and access any online content you  want -no matter where you are.");



        List<String> faq3 = new ArrayList<String>();
        faq3.add("VPN is virtual private network. It allows you to stay  private stay secure, and access any online content you  want -no matter where you are.");


        List<String> faq4 = new ArrayList<String>();
        faq4.add("VPN is virtual private network. It allows you to stay  private stay secure, and access any online content you  want -no matter where you are.");



        List<String> faq5 = new ArrayList<String>();
        faq5.add("VPN is virtual private network. It allows you to stay  private stay secure, and access any online content you  want -no matter where you are.");


        List<String> faq6 = new ArrayList<String>();
        faq6.add("VPN is virtual private network. It allows you to stay  private stay secure, and access any online content you  want -no matter where you are.");


        List<String> faq7 = new ArrayList<String>();
        faq7.add("VPN is virtual private network. It allows you to stay  private stay secure, and access any online content you  want -no matter where you are.");



        // Fruits are grouped under Fruits Items. Similarly the rest two are under
        // Vegetable Items and Nuts Items respectively.
        // i.e. expandableDetailList object is used to map the group header strings to
        // their respective children using an ArrayList of Strings.
        expandableDetailList.put("Why I need a VPN?", faq1);
        expandableDetailList.put("Is it safe?", faq2);
        expandableDetailList.put("How to use Turbo VPN?", faq3);
        expandableDetailList.put("How to disconnect Turbo VPN?", faq4);
        expandableDetailList.put("How to switch server location?", faq5);
        expandableDetailList.put("Can't find the server you want?", faq6);
        expandableDetailList.put("Can't connect,  not stable or speed is slow?", faq7);

        return expandableDetailList;
    }
}
