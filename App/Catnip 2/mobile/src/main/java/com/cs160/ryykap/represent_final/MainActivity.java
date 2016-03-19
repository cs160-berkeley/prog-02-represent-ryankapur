package com.cs160.ryykap.represent_final;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Wearable;

public class MainActivity extends Activity {
    // when the buttons are pressed, they start
    //the PhoneToWatchService with the cat name passed in.

    private Button fLocationButton;
    private Button mLexyButton;
    private static final String START_ACTIVITY = "/start_activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGoogleApiClient();

        //set action bar color
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#CFD8DC")));

        //set Action Bar's background to black and white flag image
        ActionBar actionBar = getActionBar();
        Drawable d=getResources().getDrawable(R.drawable.flag_black);
        getActionBar().setBackgroundDrawable(d);
        actionBar.setTitle(Html.fromHtml("<font color='#FBE9E7'>Represent </font>"));


        //put logo on LHS
        //http://stackoverflow.com/questions/21178860/how-to-add-imageview-on-right-hand-side-of-action-bar
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ImageView imageView = new ImageView(actionBar.getThemedContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.logo);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, Gravity.LEFT
                | Gravity.CENTER_VERTICAL);
        layoutParams.leftMargin = 0;
        imageView.setLayoutParams(layoutParams);
        actionBar.setCustomView(imageView);


//        fLocationButton = (Button) findViewById(R.id.fred_btn);
//        mLexyButton = (Button) findViewById(R.id.lexy_btn);
//
//        fLocationButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //sending fred to the watch
//                Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
//                sendIntent.putExtra("CAT_NAME", "Fred");
//                startService(sendIntent);
//            }
//        });
//
//        mLexyButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //sending lexy to the watch
//                Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
//                sendIntent.putExtra("CAT_NAME", "Lexy");
//                startService(sendIntent);
//            }
//        });
    }

    //Switch to Congressional view based upon inputted zip code
    public void goToCongressional(View view) {

        EditText zip = (EditText) findViewById(R.id.zip_enter);

        if(zip.getText().toString().isEmpty() || zip.getText().toString().length() != 5) {
            //editText is empty, display short invalid input msg
            Toast.makeText(this.getBaseContext(), "Zip code invalid", Toast.LENGTH_SHORT).show();
        } else {
            // editText is not empty
            String zip_str = " ";
            zip_str = zip.getText().toString();
            Intent startNewActivity = new Intent(this, CongressionalActivity.class);
            startNewActivity.putExtra("inputted_zipcode", zip_str.toString());
//
//            //Sending ZIP to Wear
//            Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
//            sendIntent.putExtra("zip", zip_str);
//            startService(sendIntent);


            startActivity(startNewActivity);
        }
    }

    //Switch to Congressional view based upon GPS coordinates
    public void goToGeoCongressional(View view) {
        EditText zip = (EditText) findViewById(R.id.zip_enter);
        String zip_str = zip.getText().toString();
        Intent startNewActivity = new Intent(this, CongressionalActivity.class);
        startNewActivity.putExtra("inputted_zipcode", "94704"); //DUMMY
//
//        //Sending ZIP to Wear
//        Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
//        sendIntent.putExtra("zip", "97005");
//        startService(sendIntent);


        startActivity(startNewActivity);
    }

    private void initGoogleApiClient() {
        GoogleApiClient mApiClient = new GoogleApiClient.Builder( this )
                .addApi( Wearable.API )
                .build();
        mApiClient.connect();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
