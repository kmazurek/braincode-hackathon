package com.zakaprov.braincodemobihackathon.model;

import java.util.Random;

/**
 * Created by konrad on 13.03.15.
 */
public class GameInterest extends Interest {
    private String title;
    private static String[] fancyStrings = {"Get some gadgets from", "Check what's available for", "Don't you have enough"};

    public GameInterest(String title) {
        this.title = title;
        int idx = new Random().nextInt(fancyStrings.length);
        String random = (fancyStrings[idx]);
        this.setFancyText(random);
        this.setImageUrl(title + ".png");
    }

    @Override
    public AllegroQuery[] getQueries() {
        AllegroQuery tab[] = new AllegroQuery[4];
        tab[0] = new AllegroQuery(this.title + " plakat", "0", "plakaty");
        tab[1] = new AllegroQuery(this.title + " OST", "0", "soundtracki");
        tab[2] = new AllegroQuery(this.title + " gadżet", "0", "gadżety");
        tab[3] = new AllegroQuery(this.title + " kubek", "0", "kubki");
        return tab;
    }
}
