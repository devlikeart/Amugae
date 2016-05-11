package com.mimos.amugae;

import android.content.res.Configuration;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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


}
