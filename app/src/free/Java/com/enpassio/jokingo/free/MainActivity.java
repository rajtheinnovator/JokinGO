package com.enpassio.jokingo.free;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.enpassio.jokesandroidlibrary.JokeActivity;
import com.enpassio.jokingo.EndpointAsyncTask;
import com.enpassio.jokingo.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        MobileAds.initialize(this,
                "ca-app-pub-6697507015098409/9528605270");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void ok(View view) {
        new EndpointAsyncTask().execute(new EndpointAsyncTask.OnEventListener() {
            @Override
            public void onEvent(String joke) {
                //interface code referenced from: https://stackoverflow.com/a/18585099/5770629
                Intent jokeIntent = new Intent(MainActivity.this, JokeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("jokeString", joke);
                jokeIntent.putExtra("jokeBundle", bundle);
                startActivity(jokeIntent);
            }
        });
    }
}