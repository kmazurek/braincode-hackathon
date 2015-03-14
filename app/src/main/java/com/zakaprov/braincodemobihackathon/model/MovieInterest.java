package com.zakaprov.braincodemobihackathon.model;

/**
 * Created by konrad on 13.03.15.
 */
public class MovieInterest extends Interest {

    public MovieInterest(String title) {
        super(title);
        categories.put("100127", "Autografy");
        categories.put("100130", "Figurki");
        categories.put("100132", "Kalendarze");
        categories.put("100129", "Kubki");
        categories.put("100131", "Naszywki, znaczki, przypinki");
        categories.put("100135", "Odzież");
        categories.put("100128", "Plakaty, zdjęcia");
        categories.put("100133", "Pudełka, okładki, case’y");
        categories.put("100134", "Regały, półki, stojaki");
        categories.put("100136", "Pozostałe");

        fancyStrings = new String[] {"See what you can get for", "Check what Allegro has in store for", "Check out the fan gadgets from"};

        generateFancyText();

    }

}
