package com.enpassio.jokesandroidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ABHISHEK RAJ on 8/23/2017.
 */

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Bundle bundle = savedInstanceState.getBundle("jokeBundle");
        String joke = bundle.getString("jokeString");
        TextView jokeTextView = (TextView) findViewById(R.id.joke_display_textview);
        jokeTextView.setText(joke);

    }
}
