package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this,drawer, toolbar, R.string.navigation_drawe_open, R.string.navigation_drawe_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
         if(savedInstanceState == null){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container, new MessageFragement()).commit();
        navigationView.setCheckedItem(R.id.nav_message);}
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){

            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container, new MessageFragement()).commit();
                break;

            case R.id.nav_editmessage:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container, new EditFragement()).commit();
                break;

            case R.id.nav_view:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container, new ViewFragement()).commit();
                break;
            case R.id.nav_changepassword:
                Toast.makeText(this, getString(R.string.changed), Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_changeprofile:
                Toast.makeText(this, getString(R.string.profile_change), Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
