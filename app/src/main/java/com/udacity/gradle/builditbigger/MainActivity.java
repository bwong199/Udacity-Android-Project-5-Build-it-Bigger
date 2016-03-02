package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.benwong.androidjokelibrary.JokeActivity;
import com.example.Joker;


public class MainActivity extends ActionBarActivity {

    Button getJokesGCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getJokesGCE = (Button) findViewById(R.id.getJokes);

        getJokesGCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJokesFromGCE();
            }
        });
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

    public void tellJoke(View view){
        Joker myJoker = new Joker();

        Toast.makeText(this, myJoker.getJoke(), Toast.LENGTH_SHORT).show();
    }


    public void launchLibraryActivity(View view){
        Joker myJoker = new Joker();
        Intent myIntent = new Intent(this, JokeActivity.class);
        myIntent.putExtra("JOKE", "This joke was passed from one android library to another");
        startActivity(myIntent);
    }

    public void getJokesFromGCE(){
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, ""));
    }

}
