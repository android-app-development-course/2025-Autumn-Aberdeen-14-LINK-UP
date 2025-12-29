package com.example.chatnew;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyHomeActivity extends AppCompatActivity {
    private ImageView settingsButton;
    private TextView userName, userIdentity, influenceIndex;
    private TextView connectionsCount, activitiesCount, partnersCount, projectsCount;
    private TextView viewAllAchievements;
    
    // Bottom navigation views
    private View tabMatch, tabActivities, tabPartners, tabSpace, tabProfile;
    private ImageView iconMatch, iconActivities, iconPartners, iconSpace, iconProfile;
    private TextView textMatch, textActivities, textPartners, textSpace, textProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_space);

        initViews();
        loadUserProfile();
        setListeners();
    }

    private void initViews() {
        settingsButton = findViewById(R.id.settings_button);
        userName = findViewById(R.id.user_name);
        userIdentity = findViewById(R.id.user_identity);
        influenceIndex = findViewById(R.id.influence_index);
        connectionsCount = findViewById(R.id.connections_count);
        activitiesCount = findViewById(R.id.activities_count);
        partnersCount = findViewById(R.id.partners_count);
        projectsCount = findViewById(R.id.projects_count);
        viewAllAchievements = findViewById(R.id.view_all_achievements);
        
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

    private void loadUserProfile() {
        // Check user type (guest or registered)
        SharedPreferences sharedPreferences = getSharedPreferences("login_prefs", MODE_PRIVATE);
        String userType = sharedPreferences.getString("user_type", "guest");

        if ("guest".equals(userType)) {
            // Load guest profile
            userName.setText("游客123");
            userIdentity.setText("互联网产品经理 · 3年经验");
            influenceIndex.setText("影响力指数：85");
        } else {
            // Load registered user profile (same as guest for now)
            userName.setText("注册用户");
            userIdentity.setText("互联网产品经理 · 3年经验");
            influenceIndex.setText("影响力指数：85");
        }
        
        // Set data counts
        connectionsCount.setText("128");
        activitiesCount.setText("24");
        partnersCount.setText("8");
        projectsCount.setText("5");
    }

    private void setListeners() {
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to settings or edit profile
                startActivity(new Intent(MyHomeActivity.this, EditHomeActivity.class));
            }
        });
        
        viewAllAchievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle view all achievements
                // TODO: Implement achievements activity
            }
        });
        
        // Bottom navigation listeners
        tabMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to match page
                Intent intent = new Intent(MyHomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to activities page
                Intent intent = new Intent(MyHomeActivity.this, ActivityPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabPartners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to partners page
                Intent intent = new Intent(MyHomeActivity.this, PartnerPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to space page
                Intent intent = new Intent(MyHomeActivity.this, SpacePageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        tabProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Already on profile screen, do nothing
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_edit_profile) {
            startActivity(new Intent(MyHomeActivity.this, EditHomeActivity.class));
            return true;
        } else if (id == R.id.action_logout) {
            // Clear login state and go to login screen
            SharedPreferences sharedPreferences = getSharedPreferences("login_prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

            Intent intent = new Intent(MyHomeActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}