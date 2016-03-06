package com.cs160.ryykap.represent_final;

/**
 * Created by ryykap on 2/29/16.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class CongressionalActivity extends Activity {

    String[] reps;
    String[] description1;

    //declaring dummy data
    int[] images = {R.drawable.merkley, R.drawable.wyden, R.drawable.s_bonamici};
    String[] types = {"Senator", "Senator", "Representative"};
    String[] tweets = {"83 y/ago (1933) FDR appoints Frances Perkins Secretary of Labor—the 1st female cabinet secretary #WomensHistoryMonth ", "Want information about Oregon Senator Ron Wyden's campaign? Follow us at @WydenForOregon. Thanks!", "Turn on the Telly at 9pm today on KFOX to see Suzy's campaign!" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congressional);
        TextView header = (TextView) findViewById(R.id.zip_header);

        Intent intent = getIntent();
        String zip = intent.getStringExtra("inputted_zipcode");
        header.setText("Zip: " + zip); //set the header's text to inputted zip
        Resources res = getResources();
        reps = res.getStringArray(R.array.titles); //TODO: dont use XML strings; use an array to ease into part C
        description1 = res.getStringArray(R.array.descriptions);

        final ListView l = (ListView) findViewById(R.id.congressionalListView);
        cAdapter adpt = new cAdapter(this, reps, images, description1, tweets, types);
        l.setAdapter(adpt);

        //Go to Detailed view based on this onClick listener of the list view
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                //Find item text
                String name = "Jeff Merkley";
                name = (String) l.getItemAtPosition(position);
                Log.d("T", "the name " + name);

                //Intent --> Detailed Activity
                Intent intentToGoDetailed = new Intent(view.getContext(), DetailedActivity.class);
                //intentToGoDetailed.putExtra("name",data);
                intentToGoDetailed.putExtra("person",name);


                //TODO: fix
                //SEND PERSON/REP'S NAME TO MOBILE WEAR
                Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
                sendIntent.putExtra("person", name);
                Log.d("T", "heree " + sendIntent.toString());
                startService(sendIntent);


                view.getContext().startActivity(intentToGoDetailed);

            }
        });
    }

    //Go to detailed view of clicked rep
    public void goToDetailed(View view) {
//        Intent intentToGoDetailed = new Intent(view.getContext(), DetailedActivity.class);
//        intentToGoDetailed.putExtra("name", "Ryan Kapur");
////        intentToGoDetailed.putExtra("rep", jeff);
//        view.getContext().startActivity(intentToGoDetailed);
//
//        //EditText zip = (EditText) findViewById(R.id.zip_enter);
    }
}

class cAdapter extends ArrayAdapter<String>{
    Context cnxt; int[] images; String[] titleArray; String[] partyArray; String[] tweetArray; String[] typeArray;
    cAdapter(Context c, String[] titles, int imgs[],  String[] parties, String[] tweets, String[] types){
        super(c, R.layout.custom_row, R.id.name, titles);
        this.cnxt = c;
        this.images = imgs;
        this.titleArray = titles;
        this.partyArray = parties;
        this.tweetArray = tweets;
        this.typeArray = types;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.custom_row, parent, false);
        ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
        TextView myName = (TextView) row.findViewById(R.id.name);
        TextView myParty = (TextView) row.findViewById(R.id.party);
        TextView myType = (TextView) row.findViewById(R.id.type);
        TextView myEmail = (TextView) row.findViewById(R.id.email);
        TextView mySite = (TextView) row.findViewById(R.id.website);
        TextView myTweets = (TextView) row.findViewById(R.id.tweets);



        //Setting XML components to corresponding data/dummy data
        myImage.setImageResource(images[position]);
        myName.setText(titleArray[position]);
        myParty.setText(partyArray[position]);
        myType.setText(typeArray[position]);
        String dummyMail = titleArray[position] + "@dummy.net";
        String dummySite = titleArray[position] + ".com";
        myEmail.setText(dummyMail.replaceAll("\\s+",""));
        mySite.setText(dummySite.replaceAll("\\s+", ""));
        myTweets.setText(tweetArray[position]);




        return row;
    }

}