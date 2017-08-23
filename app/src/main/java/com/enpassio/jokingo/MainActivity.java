package com.enpassio.jokingo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;

import com.enpassio.jokesandroidlibrary.JokeActivity;

public class MainActivity extends AppCompatActivity implements EndpointAsyncTask.OnEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ok(View view) {
        new EndpointAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
    }

    //interface code referenced from: https://stackoverflow.com/a/18585099/5770629
    @Override
    public void onEvent(String joke) {
        Intent jokeIntent = new Intent(MainActivity.this, JokeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("jokeString", joke);
        jokeIntent.putExtra("jokeBundle", bundle);
        startActivity(jokeIntent);
    }
}
