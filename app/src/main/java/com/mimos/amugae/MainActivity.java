package com.mimos.amugae;

import android.content.res.Configuration;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {                                               //하위버전을 지원

    private ActionBarDrawerToggle drawerToggle;                                                     //액션바 토글
    private String[] drawerList ={"Home","Mypage","Reward","Setting"};                              //드로어 배열



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //툴바는 setContentView 다음에 지정
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);                                     // 툴바 선언

        setSupportActionBar(toolbar);                                                               //툴바를 액션바처럼 사용

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);                                      //드로어 버튼 표시
        getSupportActionBar().setHomeButtonEnabled(true);                                           // ?

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);                 //  드로어 레이아웃 선언
        ListView drawer = (ListView) findViewById(R.id.drawer);                                     // 드로어 선언
        DrawerAdapter adapter = new DrawerAdapter();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,drawerList);// 어댑터
        drawer.setAdapter(adapter);                                                                 // 드로어에 어댑터 적용

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.app_name);              // 드로어 토글 할당
        drawerLayout.addDrawerListener(drawerToggle);                                               // 드로어 레이아웃에 리스너 추가

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);


        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                final View v = findViewById(R.id.action_noti);

                if (v != null) {
                    v.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            return false;
                        }
                    });
                }
            }
        });

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                final View v = findViewById(R.id.action_search);

                if (v != null) {
                    v.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            return false;
                        }
                    });
                }
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        drawerToggle.syncState();
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;

        }else if(id == R.id.action_noti){
            return true;

        }else if(id == R.id.action_search){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public  static  class PlaceholderFragment extends  Fragment{
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment(){

        }

        public  static PlaceholderFragment newInstance(int sectionNumber){
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER,sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanseState){

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText("Hello"+getArguments().getInt(ARG_SECTION_NUMBER));
            return rootView;

        }
    }
    public class SectionPagerAdapter extends FragmentPagerAdapter{

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "관심 있는";
                case 1:
                    return "인기 있는";
                case 2:
                    return "새로운";
            }
            return null;
        }
    }

}
