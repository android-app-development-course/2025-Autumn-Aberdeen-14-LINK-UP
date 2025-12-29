package com.example.chatnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OtherSpaceActivity extends AppCompatActivity {
    private ImageView avatarImage;
    private TextView userNameText;
    private TextView userTitleText;
    private TextView connectionsCountText;
    private TextView activitiesCountText;
    private TextView partnersCountText;
    private ImageView backButton;
    private TextView pageTitle;
    
    private RecyclerView recyclerViewPosts;
    private PostAdapter postAdapter;
    private List<PostItem> postList;
    
    private String currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_space);

        initViews();
        setupRecyclerView();
        
        // Get user data from intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String identity = intent.getStringExtra("identity");
        int connections = intent.getIntExtra("connections", 0);
        int activities = intent.getIntExtra("activities", 0);
        int partners = intent.getIntExtra("partners", 0);
        
        currentUser = username;
        
        // Set user data
        if (username != null) {
            userNameText.setText(username);
            pageTitle.setText(username + "的空间");
        }
        
        if (identity != null) {
            userTitleText.setText(identity);
        }
        
        connectionsCountText.setText(String.valueOf(connections));
        activitiesCountText.setText(String.valueOf(activities));
        partnersCountText.setText(String.valueOf(partners));

        loadDefaultData();
        setListeners();
    }

    private void initViews() {
        avatarImage = findViewById(R.id.user_avatar);
        userNameText = findViewById(R.id.user_name);
        userTitleText = findViewById(R.id.user_title);
        connectionsCountText = findViewById(R.id.connections_count);
        activitiesCountText = findViewById(R.id.activities_count);
        partnersCountText = findViewById(R.id.partners_count);
        backButton = findViewById(R.id.back_button);
        pageTitle = findViewById(R.id.page_title);
        recyclerViewPosts = findViewById(R.id.recycler_view_posts);
    }
    
    private void setupRecyclerView() {
        postList = new ArrayList<>();
        // Disable navigation to user space from other user space pages to prevent circular navigation
        postAdapter = new PostAdapter(this, postList, false);
        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPosts.setAdapter(postAdapter);
    }
    
    private void loadDefaultData() {
        postList.clear();
        // Add posts only for the current user
        if (currentUser != null) {
            postList.add(new PostItem(currentUser, "1小时前", "这是我最近的学习心得分享", R.drawable.ic_launcher_foreground, 28, 5, 3));
            postList.add(new PostItem(currentUser, "3小时前", "今天完成了一个重要项目", 0, 45, 12, 8));
            postList.add(new PostItem(currentUser, "昨天", "分享一些工作中的思考", R.drawable.ic_launcher_foreground, 36, 8, 6));
        }
        postAdapter.notifyDataSetChanged();
    }

    private void setListeners() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back
                finish();
            }
        });
    }
}