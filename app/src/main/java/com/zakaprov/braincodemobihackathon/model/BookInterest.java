package com.zakaprov.braincodemobihackathon.model;

import java.util.Random;

/**
 * Created by konrad on 13.03.15.
 */
public class BookInterest extends Interest {
    private String title;
    private static String[] fancyStrings = {"Look for characters from", "Don't you have enough"};

    public BookInterest(String title) {
        this.title = title;
        int idx = new Random().nextInt(fancyStrings.length);
        String random = (fancyStrings[idx]);
        this.setFancyText(random);
        this.setImageUrl(title + ".jpg");
    }

    @Override
    public AllegroQuery[] getQueries() {
        AllegroQuery tab[] = new AllegroQuery[2];
        tab[0] = new AllegroQuery(this.title + " gadżet", "0", "gadżety");
        tab[1] = new AllegroQuery(this.title + " kubek", "0", "kubki");
        return tab;
    }
}
