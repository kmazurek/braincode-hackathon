package com.zakaprov.braincodemobihackathon.model;

/**
 * Created by kacper on 13.03.15.
 */
public class BandInterest extends Interest
{
    public BandInterest(String title)
    {
        super(title);
    }

    @Override
    public AllegroQuery[] getQueries() {
        AllegroQuery tab[] = new AllegroQuery[5];
        tab[0] = new AllegroQuery(this.title + " koszulki", "0", "koszulki");
        tab[1] = new AllegroQuery(this.title + " kostka", "0", "kostki");
        tab[2] = new AllegroQuery(this.title + " bilet", "0", "bilety");
        tab[3] = new AllegroQuery(this.title + " płyta winylowa", "0", "płyta");
        tab[4] = new AllegroQuery(this.title + " kubek", "0", "kubki");
        return tab;
    }
}
