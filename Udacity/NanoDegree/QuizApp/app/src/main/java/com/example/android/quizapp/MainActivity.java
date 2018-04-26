package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Answers the intent to exit the app on Answers and Questions Activity.
        (https://stackoverflow.com/questions/3226495/how-to-exit-from-the-application-and-show-the-home-screen "Lazy Ninja")*/
        if( getIntent().getBooleanExtra("Exit", false)){
            finish();
        }
    }

    public void start(View view) {
        // Create a new intent to open the {Questions Activity}
        Intent questionsIntent = new Intent(MainActivity.this, Questions.class);

        startActivity(questionsIntent);
    }
}