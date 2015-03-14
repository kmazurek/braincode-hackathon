package com.zakaprov.braincodemobihackathon.model;

/**
 * Created by konrad on 13.03.15.
 */
public class BookInterest extends Interest
{
    public BookInterest(String title)
    {
        super(title);
    }

    @Override
    public AllegroQuery[] getQueries() {
        AllegroQuery tab[] = new AllegroQuery[2];
        tab[0] = new AllegroQuery(this.title + " gadżet", "0", "gadżety");
        tab[1] = new AllegroQuery(this.title + " kubek", "0", "kubki");
        return tab;
    }
}
