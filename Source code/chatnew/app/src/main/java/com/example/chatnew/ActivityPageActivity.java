package com.example.chatnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ActivityPageActivity extends AppCompatActivity {
    private TextView tabAll, tabOnline, tabOffline, tabLatest, tabPopular;
    private RecyclerView recyclerViewActivities;
    private ActivityAdapter activityAdapter;
    private List<ActivityItem> activityList;
    
    // Bottom navigation views
    private View tabMatch, tabActivities, tabPartners, tabSpace, tabProfile;
    private ImageView iconMatch, iconActivities, iconPartners, iconSpace, iconProfile;
    private TextView textMatch, textActivities, textPartners, textSpace, textProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("热门活动");
        }

        initViews();
        setupRecyclerView();
        loadDefaultData();
        setListeners();
    }

    private void initViews() {
        tabAll = findViewById(R.id.tab_all);
        tabOnline = findViewById(R.id.tab_online);
        tabOffline = findViewById(R.id.tab_offline);
        tabLatest = findViewById(R.id.tab_latest);
        tabPopular = findViewById(R.id.tab_popular);
        recyclerViewActivities = findViewById(R.id.recycler_view_activities);
        
        // Bottom navigation tabs
        tabMatch = findViewById(R.id.tab_match);
        tabActivities = findViewById(R.id.tab_activities);
        tabPartners = findViewById(R.id.tab_partners);
        tabSpace = findViewById(R.id.tab_space);
        tabProfile = findViewById(R.id.tab_profile);
        
        // Icons
        iconMatch = findViewById(R.id.icon_match);
        iconActivities = findViewById(R.id.icon_activities);
        iconPartners = findViewById(R.id.icon_partners);
        iconSpace = findViewById(R.id.icon_space);
        iconProfile = findViewById(R.id.icon_profile);
        
        // Texts
        textMatch = findViewById(R.id.text_match);
        textActivities = findViewById(R.id.text_activities);
        textPartners = findViewById(R.id.text_partners);
        textSpace = findViewById(R.id.text_space);
        textProfile = findViewById(R.id.text_profile);
    }

    private void setupRecyclerView() {
        activityList = new ArrayList<>();
        activityAdapter = new ActivityAdapter(this, activityList);
        recyclerViewActivities.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewActivities.setAdapter(activityAdapter);
    }

    private void loadDefaultData() {
        activityList.clear();
        activityList.add(new ActivityItem("产品设计思维分享会", "2025-12-20 19:00", "线上直播", "98人", R.drawable.fabuhui1));
        activityList.add(new ActivityItem("数据分析实战训练营", "2025-12-22 10:00", "线下（北京）", "65人", R.drawable.fabuhui2));
        activityList.add(new ActivityItem("用户调研方法论交流", "2025-12-28 15:00", "线上腾讯会议", "82人", R.drawable.fabuhui3));
        activityList.add(new ActivityItem("产品经理职业规划沙龙", "2026-01-05 14:00", "线下（上海）", "105人", R.drawable.fabuhui4));
        activityAdapter.notifyDataSetChanged();
    }

    private void setListeners() {
        tabAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // UI only change, no actual filtering
                resetTabColors();
                tabAll.setTextColor(getResources().getColor(R.color.primary_dark_blue));
            }
        });

        tabOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // UI only change, no actual filtering
                resetTabColors();
                tabOnline.setTextColor(getResources().getColor(R.color.primary_dark_blue));
            }
        });

        tabOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // UI only change, no actual filtering
                resetTabColors();
                tabOffline.setTextColor(getResources().getColor(R.color.primary_dark_blue));
            }
        });

        tabLatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // UI only change, no actual filtering
                resetTabColors();
                tabLatest.setTextColor(getResources().getColor(R.color.primary_dark_blue));
            }
        });

        tabPopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // UI only change, no actual filtering
                resetTabColors();
                tabPopular.setTextColor(getResources().getColor(R.color.primary_dark_blue));
            }
        });
        
        // Bottom navigation listeners
        tabMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to match page
                Intent intent = new Intent(ActivityPageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Already on activities screen, do nothing
            }
        });
        
        tabPartners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to partners page
                Intent intent = new Intent(ActivityPageActivity.this, PartnerPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to space page
                Intent intent = new Intent(ActivityPageActivity.this, SpacePageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to my profile
                Intent intent = new Intent(ActivityPageActivity.this, MyHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void resetTabColors() {
        tabAll.setTextColor(getResources().getColor(R.color.text_dark));
        tabOnline.setTextColor(getResources().getColor(R.color.text_dark));
        tabOffline.setTextColor(getResources().getColor(R.color.text_dark));
        tabLatest.setTextColor(getResources().getColor(R.color.text_dark));
        tabPopular.setTextColor(getResources().getColor(R.color.text_dark));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}