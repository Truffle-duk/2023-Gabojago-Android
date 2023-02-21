package com.example.gabojago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    //하단바
    private BottomNavigationView bottomNavigationView;

    //프레그먼트
    private FragmentManager fragmentManager;
    private MainFragment mainFragment;
    private FragmentTransaction transaction;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프레그먼트
        fragmentManager=getSupportFragmentManager();

        mainFragment=new MainFragment();

        transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.container, mainFragment).commit();


        //하단바 탭 이동
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                switch (item.getItemId()){
                    case R.id.tab_home:
                        currentFragment=fragmentManager.findFragmentById(R.id.container);
                        ft.remove(currentFragment);
                        ft.add(R.id.container, new MainFragment()).commit();
                        break;
                    case R.id.tab_input:
                        break;
                    case R.id.tab_thismonth:
                        break;
                    case R.id.tab_compare:
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}