package com.cs160.ryykap.represent_final;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//WEAR

public class MainActivity extends Activity {

    private TextView mTextView;
    private Button mFeedBtn;
    private TextView zip;


    public void goToVote(View v) {
//        Button moreInfo = (Button) findViewById(R.id.main_zip_btn);
//        String info = moreInfo.getText().toString();
        Intent startNewActivity = new Intent(this, VoteActivity.class);
        startActivity(startNewActivity);
//        startNewActivity.putExtra("something", "97005"); //DUMMY
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_main);


        final GridViewPager g = (GridViewPager) findViewById(R.id.pager);
        g.setAdapter(new SampleGridPageAdapter(this));

        //zip = (TextView) findViewById(R.id.zip);
//        mFeedBtn = (Button) findViewById(R.id.pager);



        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
//            String z = "xxx";
//            z = extras.getString("zip");
//

            //REP NAME
            String name = "no name";
            name = extras.getString("person");
            int row = 0;

            if (name.equals("Jeff Merkley")) {
                row = 0;
            } if (name.equals("Rob Wyden")) {
                row = 1;
            } else{
                row = 2;
            }
            final int rowF = row;


            g.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                @Override
                public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    g.setCurrentItem(rowF, 1);
                    g.getAdapter().notifyDataSetChanged();
                    g.removeOnLayoutChangeListener(this);
                }
            });


            String catName = extras.getString("CAT_NAME");
//            mFeedBtn.setText("Feed " + catName);
//            zip.setText(z);
        }



//        mFeedBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent(getBaseContext(), WatchToPhoneService.class);
//                startService(sendIntent);
//            }
//        });
    }
}
