package com.enpassio.jokingo.premium;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.enpassio.jokesandroidlibrary.JokeActivity;
import com.enpassio.jokingo.EndpointAsyncTask;
import com.enpassio.jokingo.R;


public class MainActivity extends AppCompatActivity {

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        ;
    }

    public void ok(View view) {
        new EndpointAsyncTask().execute(new EndpointAsyncTask.OnEventListener() {
            @Override
            public void onEvent(String joke) {
                Intent jokeIntent = new Intent(MainActivity.this, JokeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("jokeString", joke);
                jokeIntent.putExtra("jokeBundle", bundle);
                startActivity(jokeIntent);
            }
        });
    }
}
