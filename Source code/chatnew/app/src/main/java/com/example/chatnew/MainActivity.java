package com.example.chatnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    private ImageView iconSearch, iconMessage;
    private ViewPager2 viewPagerRecommendations;
    private TextView tvViewAllActivities;
    
    // Bottom navigation views
    private View tabMatch, tabActivities, tabPartners, tabSpace, tabProfile;
    private ImageView iconMatch, iconActivities, iconPartners, iconSpace, iconProfile;
    private TextView textMatch, textActivities, textPartners, textSpace, textProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupViewPager();
        setListeners();
    }

    private void initViews() {
        iconSearch = findViewById(R.id.icon_search);
        iconMessage = findViewById(R.id.icon_message);
        viewPagerRecommendations = findViewById(R.id.viewPager_recommendations);
        tvViewAllActivities = findViewById(R.id.tv_view_all_activities);
        
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

    private void setupViewPager() {
        // Create sample recommendation data
        RecommendationItem[] recommendations = {
                new RecommendationItem("张伟", 85, "产品经理 · 用户体验设计"),
                new RecommendationItem("李娜", 78, "数据分析师 · Python专家"),
                new RecommendationItem("王强", 82, "前端工程师 · React专家")
        };

        // Set up the ViewPager with adapter
        RecommendationAdapter adapter = new RecommendationAdapter(recommendations);
        viewPagerRecommendations.setAdapter(adapter);
    }

    private void setListeners() {
        // Top icons
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle search icon click
            }
        });

        iconMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle message icon click
            }
        });

        // View all activities
        tvViewAllActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to activities page
                Intent intent = new Intent(MainActivity.this, ActivityPageActivity.class);
                startActivity(intent);
            }
        });

        // Bottom navigation listeners
        tabMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Already on match screen, do nothing
            }
        });

        tabActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to activities page
                Intent intent = new Intent(MainActivity.this, ActivityPageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tabPartners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to partners page
                Intent intent = new Intent(MainActivity.this, PartnerPageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tabSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to space page
                Intent intent = new Intent(MainActivity.this, SpacePageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tabProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to profile page
                Intent intent = new Intent(MainActivity.this, MyHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}