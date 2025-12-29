package com.example.chatnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PartnerPageActivity extends AppCompatActivity {
    private Button btnRefresh;
    private ImageView iconBack, iconSearch, iconSettings;
    private RecyclerView recyclerViewPartners;
    private PartnerAdapter partnerAdapter;
    private List<PartnerItem> partnerList;
    
    // Bottom navigation views
    private View tabMatch, tabActivities, tabPartners, tabSpace, tabProfile;
    private ImageView iconMatch, iconActivities, iconPartners, iconSpace, iconProfile;
    private TextView textMatch, textActivities, textPartners, textSpace, textProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partner_page);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("找搭子");
        }

        initViews();
        setupRecyclerView();
        loadDefaultData();
        setListeners();
    }

    private void initViews() {
        btnRefresh = findViewById(R.id.btn_refresh);
        iconBack = findViewById(R.id.icon_back);
        iconSearch = findViewById(R.id.icon_search);
        iconSettings = findViewById(R.id.icon_settings);
        recyclerViewPartners = findViewById(R.id.recycler_view_partners);
        
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
        partnerList = new ArrayList<>();
        partnerAdapter = new PartnerAdapter(this, partnerList);
        recyclerViewPartners.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPartners.setAdapter(partnerAdapter);
    }

    private void loadDefaultData() {
        partnerList.clear();
        partnerList.add(new PartnerItem(
                "张三",
                "高级产品经理",
                "项目搭子",
                85,
                75,
                "你们都在互联网行业工作，且对用户体验设计有浓厚兴趣",
                "用户调研、爬山"
        ));
        
        partnerList.add(new PartnerItem(
                "李四",
                "数据分析师",
                "学习搭子",
                90,
                80,
                "你们都有Python编程经验和机器学习背景",
                "数据分析、游泳"
        ));
        
        partnerList.add(new PartnerItem(
                "王五",
                "UI设计师",
                "饭搭子",
                70,
                85,
                "你们都喜欢川菜和日料，且都在望京附近工作",
                "美食、摄影"
        ));
        
        partnerAdapter.notifyDataSetChanged();
    }

    private void setListeners() {
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PartnerPageActivity.this, "刷新推荐列表", Toast.LENGTH_SHORT).show();
                // In a real app, you would fetch new data from server
            }
        });
        
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PartnerPageActivity.this, "搜索功能占位", Toast.LENGTH_SHORT).show();
            }
        });
        
        iconSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PartnerPageActivity.this, "设置功能占位", Toast.LENGTH_SHORT).show();
            }
        });
        
        // Bottom navigation listeners
        tabMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to match page
                Intent intent = new Intent(PartnerPageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to activities page
                Intent intent = new Intent(PartnerPageActivity.this, ActivityPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabPartners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Already on partners screen, do nothing
            }
        });
        
        tabSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to space page
                Intent intent = new Intent(PartnerPageActivity.this, SpacePageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to my profile
                Intent intent = new Intent(PartnerPageActivity.this, MyHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
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