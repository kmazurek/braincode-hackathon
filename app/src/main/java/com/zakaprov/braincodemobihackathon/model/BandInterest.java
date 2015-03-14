package com.zakaprov.braincodemobihackathon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kacper on 13.03.15.
 */
public class BandInterest extends Interest
{
    public BandInterest(String title)
    {
        super(title);
        categories.put("20761", "Autografy");
        categories.put("92734", "Biżuteria");
        categories.put("98697", "Breloki");
        categories.put("20762", "Kalendarze");
        categories.put("20763", "Kubki");
        categories.put("20764", "Naszywki, znaczki, przypinki");
        categories.put("20765", "Plakaty i zdjęcia");
        categories.put("98696", "Poduszki i poszewki");
        categories.put("98699", "Torby i plecaki");
        categories.put("20766", "T-shirty, bluzy, czapki");
        categories.put("98698", "Zegary i zegarki");
        categories.put("20767", "Pozostałe");
    }

}
