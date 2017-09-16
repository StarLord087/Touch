package com.singh.shekhar.touch;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

    }


    public void multiplayer(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);



    }

    public void single(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);

    }

    public void highscoreac(View view){
        Intent intent = new Intent(this,high_score.class);
        startActivity(intent);
    }

}
