package com.rweqx.pushthepig;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Load XML associated with the activity.

        //Add Listeners
        Button button = findViewById(R.id.play_button);
        button.setOnClickListener(myClickListener);
        button = findViewById(R.id.stats_button);
        button.setOnClickListener(myClickListener);


        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navView = findViewById(R.id.nav_view); //The Navigation's buttons
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem){
                        menuItem.setChecked(true);
                        //mDrawerLayout.closeDrawers();

                        //Update the UI based on the item selected. ie, swap UI fragments
                        switch(menuItem.getItemId()){
                            case R.id.nav_play:
                                startGame();
                                break;

                            case R.id.nav_stats:
                                showStats();
                                break;
                        }

                        return true;
                    }
                }
        );


    }

    private View.OnClickListener myClickListener = new View.OnClickListener(){
        public void onClick(View v){
            Log.d("TAG", String.valueOf(v.getId()));
            switch(v.getId()){
                case R.id.play_button:
                    startGame();
                    break;
                case R.id.stats_button:
                    showStats();
                    break;

            }
        }
    };

    public void showStats(){
        Intent intent = new Intent(this, NavActivityTest.class);
        startActivity(intent);
    }
    /**
     * Try to use intent to run another Activity
     */
    public void startGame(){
        Intent intent = new Intent(this, GameActivity.class);
        //intent.putExtra("name", "thing");
        startActivity(intent);
    }

}
