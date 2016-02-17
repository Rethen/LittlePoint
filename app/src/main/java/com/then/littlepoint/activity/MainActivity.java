package com.then.littlepoint.activity;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.then.littlepoint.R;
import com.then.littlepoint.databinding.ActivityMainBinding;
import com.then.littlepoint.fragment.FragmentListView;
import com.then.littlepoint.fragment.FragmentViewPagerView;


public class MainActivity extends BaseActivity {


    private ActivityMainBinding binding;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        binding.drawerLayout.setDrawerListener(toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open_drawer, R.string.close_drawer));
        NavigationView.OnNavigationItemSelectedListener listener = new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_listview:
                        fragment = new FragmentListView();
                        break;
                    case R.id.action_viewpager:
                        fragment = new FragmentViewPagerView();
                        break;
                    default:
                        binding.drawerLayout.closeDrawers();
                        return false;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, fragment)
                        .commit();
                menuItem.setChecked(true);
                binding.drawerLayout.closeDrawers();
                return true;
            }
        };


        binding.navView.setNavigationItemSelectedListener(listener);
        if (savedInstanceState == null) {
            listener.onNavigationItemSelected(binding.navView.getMenu().getItem(0));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return toggle.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

}
