package com.example.antinet.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.utils.BottomNavigationViewHelper;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TableLayout;

import com.example.antinet.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mContext = MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: starting");
        setUpBottonNavigationView();
        setupViewPager();
    }

    private void setupViewPager(){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new MessageFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);
        TabLayout tableLayout = (TabLayout) findViewById(R.id.tabs);
        tableLayout.setupWithViewPager(viewPager);
        tableLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tableLayout.getTabAt(1).setIcon(R.drawable.ic_camera);
        tableLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);
    }
    //setting up a bottom navigation view
    private void setUpBottonNavigationView(){

        Log.d(TAG, "setUpBottonNavigationView: setting up BottomNavigationView");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(MainActivity.this,bottomNavigationView);
    }
}
