package com.zakaprov.braincodemobihackathon.model;

/**
 * Created by konrad on 13.03.15.
 */
public class GameInterest extends Interest
{
    public GameInterest(String title)
    {
        super(title);
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
