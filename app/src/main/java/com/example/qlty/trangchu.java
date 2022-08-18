package com.example.qlty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.qlty.Model.Users;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class trangchu extends AppCompatActivity  {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        ScheduleFragment scheduleFragment = new ScheduleFragment();

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            Users user = (Users) bundle.get("Users");
            if(user!=null)
            {
                Bundle bundleClient = new Bundle();
                bundleClient.putSerializable("Client",user);
                scheduleFragment.setArguments(bundleClient);
                Log.e("error",user.getID()+"");
            }

        }
        bottomNavigationView = findViewById(R.id.bnv_Main);
        replace (new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replace (new HomeFragment());
                    break;
                case R.id.calender:
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame,scheduleFragment);
                    transaction.commit();
                    break;
            case R.id.person:
                            replace (new PersonFragment());
                    break;
            }
            return true;

        });

    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
    }


}