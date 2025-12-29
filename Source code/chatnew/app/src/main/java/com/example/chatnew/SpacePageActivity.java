package com.example.chatnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SpacePageActivity extends AppCompatActivity {
    private RecyclerView recyclerViewPosts;
    private PostAdapter postAdapter;
    private List<PostItem> postList;
    private Button btnNewPublish;
    private ImageView btnEditProfile;
    
    // Bottom navigation views
    private View tabMatch, tabActivities, tabPartners, tabSpace, tabProfile;
    private ImageView iconMatch, iconActivities, iconPartners, iconSpace, iconProfile;
    private TextView textMatch, textActivities, textPartners, textSpace, textProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_page);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("个人空间");
        }

        initViews();
        setupRecyclerView();
        loadDefaultData();
        setListeners();
    }

    private void initViews() {
        recyclerViewPosts = findViewById(R.id.recycler_view_posts);
        btnNewPublish = findViewById(R.id.btn_new_publish);
        btnEditProfile = findViewById(R.id.btn_edit_profile);
        
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
        postList = new ArrayList<>();
        // Enable navigation to user space from the personal space page
        postAdapter = new PostAdapter(this, postList, true);
        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPosts.setAdapter(postAdapter);
    }

    private void loadDefaultData() {
        postList.clear();
        postList.add(new PostItem("张三", "1小时前", "分享一款超好用的产品设计工具，效率提升50%！", R.drawable.richang1, 28, 5, 3));
        postList.add(new PostItem("李四", "3小时前", "数据分析入门避坑指南，新手必看", 0, 45, 12, 8));
        postList.add(new PostItem("王五", "昨天", "用户调研的3个核心技巧，亲测有效！", R.drawable.richang2, 36, 8, 6));
        postList.add(new PostItem("游客123", "2天前", "新手求带，有没有数据分析的小伙伴交流下？", 0, 12, 3, 1));
        postList.add(new PostItem("赵六", "3天前", "产品经理必备的沟通技巧，建议收藏！", R.drawable.richang1, 58, 15, 10));
        postAdapter.notifyDataSetChanged();
    }

    private void setListeners() {
        btnNewPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to post activity
                startActivity(new Intent(SpacePageActivity.this, PostActivity.class));
            }
        });
        
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to edit profile
                startActivity(new Intent(SpacePageActivity.this, EditHomeActivity.class));
            }
        });
        
        // Bottom navigation listeners
        tabMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to match page
                Intent intent = new Intent(SpacePageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to activities page
                Intent intent = new Intent(SpacePageActivity.this, ActivityPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabPartners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to partners page
                Intent intent = new Intent(SpacePageActivity.this, PartnerPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Already on space screen, do nothing
            }
        });
        
        tabProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to my profile
                Intent intent = new Intent(SpacePageActivity.this, MyHomeActivity.class);
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