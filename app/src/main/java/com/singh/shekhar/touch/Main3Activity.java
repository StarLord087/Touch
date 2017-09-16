package com.singh.shekhar.touch;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main3Activity extends AppCompatActivity {
    int click_p1_single, count_single = 0, i = 0;
    MediaPlayer button_sound, finish_sound;
    int[] array_colors = {Color.argb(255, 0, 217, 211), Color.argb(255, 184, 0, 221), Color.argb(255, 221, 122, 0), Color.argb(255, 158, 221, 0), Color.argb(255, 221, 214, 0), Color.argb(255, 221, 0, 85), Color.argb(255, 221, 96, 0), Color.argb(255, 11, 221, 0), Color.argb(255, 0, 48, 221), Color.argb(255, 81, 21, 21), Color.argb(255, 0, 255, 55), Color.argb(255, 255, 0, 13), Color.argb(255, 255, 0, 255), Color.argb(255, 255, 255, 0), Color.argb(255, 255, 123, 0), Color.argb(255, 0, 157, 255), Color.argb(255, 255, 0, 111), Color.argb(255, 170, 0, 255), Color.argb(255, 238, 255, 0), Color.argb(255, 173, 178, 102), Color.argb(255, 10, 119, 131)};

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);


        TextView highdisplay = (TextView) findViewById(R.id.high);
        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int high_score1 = settings.getInt("HIGH_SCORE", 0);

        highdisplay.setText("HighScore " + high_score1);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }

    public void single_player(View v) {
        if (count_single == 0) {
            click_p1_single = 0;


        } else {

            click_p1_single++;
            save_score();

            TextView textView = (TextView) findViewById(R.id.score_single);
            textView.setText("Clicks :" + click_p1_single);

            ImageButton imageButton = (ImageButton) findViewById(R.id.image_button_single);
            imageButton.setBackgroundColor(array_colors[i]);
            i++;


            if (i == array_colors.length) {
                i = 0;
                imageButton.setBackgroundColor(array_colors[i]);
                i++;
            }

        }
    }


    public void start(View V) {

        click_p1_single = 0;
        count_single = 0;

        button_sound = MediaPlayer.create(this, R.raw.beep);
        button_sound.start();
        finish_sound = MediaPlayer.create(this, R.raw.b);

        final Button button = (Button) findViewById(R.id.start_single);
        int cx = button.getWidth() / 2;
        int cy = button.getHeight() / 2;
        float initialRadius = (float) Math.hypot(cx, cy);
// create the animation (the final radius is zero)
        Animator anim = ViewAnimationUtils.createCircularReveal(button, cx, cy, initialRadius, 0);

        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                button.setVisibility(View.INVISIBLE);
            }
        });

// start the animation
        anim.start();
//----------------------other button---------------------------------

        final Button button1 = (Button) findViewById(R.id.start_again);
        int cx1 = button1.getWidth() / 2;
        int cy1 = button1.getHeight() / 2;
        float initialRadius1 = (float) Math.hypot(cx1, cy1);
// create the animation (the final radius is zero)
        Animator anim1 = ViewAnimationUtils.createCircularReveal(button1, cx1, cy1, initialRadius1, 0);

        // make the view invisible when the animation is done
        anim1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                button1.setVisibility(View.INVISIBLE);
            }
        });

// start the animation
        anim1.start();
//----------------end---------------------------------------------------------------------------
        TextView textView = (TextView) findViewById(R.id.score_single);
        textView.setText("Clicks :" + click_p1_single);


        new CountDownTimer(4000, 1000) {

            TextView textView = (TextView) findViewById(R.id.count_text_single);

            public void onTick(long millisUntilFinished) {


                textView.setText("" + ((millisUntilFinished / 1000)));
                button_sound.start();

            }


            public void onFinish() {
                finish_sound.start();
                textView.setVisibility(View.INVISIBLE);
                main_timer_single();
                count_single++;
            }

        }.start();

    }

    public void main_timer_single() {
        new CountDownTimer(10000, 1000) {

            TextView textView = (TextView) findViewById(R.id.timer_single);

            public void onTick(long millisUntilFinished) {
                textView.setText("Time:" + ((millisUntilFinished / 1000)));
                textView.setTextSize(25);
            }

            public void onFinish() {
                count_single = 0;
                textView.setText("Time:0");
                finish_sound.start();
                win_single();
                save_score();
                ImageButton button = (ImageButton) findViewById(R.id.image_button_single);
                button.setBackgroundColor(Color.argb(255, 41, 121, 200));


            }

        }.start();
    }

    public void win_single() {

        TextView textView = (TextView) findViewById(R.id.count_text_single);
        textView.setVisibility(View.VISIBLE);
        textView.setText("Average Clicks/sec :" + (click_p1_single / 10));

        Button button = (Button) findViewById(R.id.start_again);
        // get the center for the clipping circle
        int cx = button.getWidth() / 2;
        int cy = button.getHeight() / 2;

// get the final radius for the clipping circle
        float finalRadius = (float) Math.hypot(cx, cy);

// create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(button, cx, cy, 0, finalRadius);

// make the view visible and start the animation
        button.setVisibility(View.VISIBLE);
        anim.start();


    }

    public void save_score() {


        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int high_score = settings.getInt("HIGH_SCORE", 0);
        int max_avg = settings.getInt("AVG", 0);


        if (click_p1_single >= high_score && click_p1_single / 10 >= max_avg) {
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", click_p1_single);
            if(click_p1_single >=70)
            {

            }
            editor.putInt("AVG", click_p1_single / 10);
            editor.commit();

            TextView textView = (TextView) findViewById(R.id.high);
            textView.setText("HighScore " + high_score);
        }

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main3 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        finish();
    }


}
