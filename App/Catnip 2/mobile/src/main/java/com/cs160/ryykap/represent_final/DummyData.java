package com.cs160.ryykap.represent_final;

/**
 * Created by ryykap on 3/4/16.
 */
public class DummyData {

    static Data d = new Data();

    static String[] rand_bills = {"Obama Stimulus Package (2008)", "Medicare/Prescription Drug Act (2003)"};
    static String[] rand_commitees = {"Senate Finance", "Senate Energy"};
    static Data.Rep jeff = d.new Rep("Jeff Merkley", "Democrat", "Senator", "End of Term: 02-06-2020","R.drawable.merkley", rand_bills, rand_commitees);
    static Data.Rep john = d.new Rep("Rob Wyden", "Democrat", "Senator", "End of Term: 06-06-2018", "R.drawable.wyden", rand_bills, rand_commitees);
    static Data.Rep suzanne = d.new Rep("Suzanne Bonamici", "Democrat", "Representative", "End of Term: 06-06-2018", "R.drawable.s_bonamici", rand_bills, rand_commitees);

    public DummyData() {}

}
