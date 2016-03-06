package com.cs160.ryykap.represent_final;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ryykap on 3/2/16.
 */
public class DetailedActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        //find XML components
        ImageView picture = (ImageView) findViewById(R.id.picture);
        TextView name = (TextView) findViewById(R.id.detailedHeader);
        TextView party = (TextView) findViewById(R.id.d_party);
        TextView type = (TextView) findViewById(R.id.type);
        TextView endDate = (TextView) findViewById(R.id.enddate);
        TextView committees = (TextView) findViewById(R.id.committees);
        TextView bills = (TextView) findViewById(R.id.bills); //TODO: bill start day

        //dummies
        Data.Rep jeff = DummyData.jeff;
        Data.Rep john = DummyData.john;
        Data.Rep suzanne = DummyData.suzanne;
        Data.Rep currRep;

        //get data from Congressional View for a person
        Intent intent = getIntent();
        String person = intent.getStringExtra("person");


        //dummies
        if (person.equals(DummyData.jeff.getName())){
            currRep = jeff;
            picture.setImageResource(R.drawable.merkley);
        } else if (person.equals(DummyData.john.getName())){
            currRep = john;
            picture.setImageResource(R.drawable.wyden);
        } else {
            currRep = suzanne;
            picture.setImageResource(R.drawable.s_bonamici);

        }


        //set XML components
        name.setText(person); //set the header's text to inputted zip
        party.setText(currRep.getParty());
        type.setText(currRep.getType());
        endDate.setText(currRep.getEndDate());


        //dummy data; string[] --> string for committees and bills
        String[] strArr = currRep.getCommitties();
        StringBuilder strBuilderCommittees = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            strBuilderCommittees.append(strArr[i]);
            strBuilderCommittees.append("\n");
        }
        String[] c = currRep.getBills();
        StringBuilder billz = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            billz.append(c[i]);
            billz.append("\n");
        }
        String committeesFinal = strBuilderCommittees.toString();
        committees.setText(committeesFinal);
        String billsFinal = billz.toString();
        bills.setText(billsFinal);



    }
}