package com.enpassio.jokingo.freemium;

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
        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-6697507015098409/8796911875");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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
