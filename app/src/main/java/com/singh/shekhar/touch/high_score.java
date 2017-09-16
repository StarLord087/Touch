package com.singh.shekhar.touch;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.api.GoogleApiClient;


public class high_score extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        TextView textView = (TextView) findViewById(R.id.first_score);
        TextView textView2 = (TextView) findViewById(R.id.first_score2);



        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);

        int high_score = settings.getInt("HIGH_SCORE", 0);
        int avg = settings.getInt("AVG",0);

        textView.setText("Clicks: "+high_score);
        textView2.setText("Average Click/Sec: "+avg);


    }


}
