package com.rweqx.pushthepig;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class GameActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navView = findViewById(R.id.nav_view); //The Navigation's buttons
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem){
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        //Update the UI based on the item selected. ie, swap UI fragments
                        switch(menuItem.getItemId()){
                            case R.id.nav_play:
                                startGame();
                        }

                        return true;
                    }
                }
        );
    }

    public void startGame(){
        Intent intent = new Intent(this, GameActivity.class);
        //intent.putExtra("name", "thing");
        startActivity(intent);
    }
}
