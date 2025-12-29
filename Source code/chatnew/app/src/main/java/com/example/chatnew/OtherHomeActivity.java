package com.example.chatnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class OtherHomeActivity extends AppCompatActivity {
    private ImageView imageViewCover, imageViewAvatar;
    private TextView textViewName, textViewTags, textViewBio;
    private Button buttonMessage;
    private ImageView ivBack;
    private String name, tag;
    private int matchPercentage, avatarResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_home);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Get data from intent
        name = getIntent().getStringExtra("name");
        matchPercentage = getIntent().getIntExtra("match_percentage", 0);
        tag = getIntent().getStringExtra("tag");
        avatarResource = getIntent().getIntExtra("avatar", R.drawable.ic_launcher_foreground);

        initViews();
        populateData();
        setListeners();
    }

    private void initViews() {
        imageViewCover = findViewById(R.id.image_view_cover);
        imageViewAvatar = findViewById(R.id.image_view_avatar);
        textViewName = findViewById(R.id.text_view_name);
        textViewTags = findViewById(R.id.text_view_tags);
        textViewBio = findViewById(R.id.text_view_bio);
        buttonMessage = findViewById(R.id.button_message);
        ivBack = findViewById(R.id.iv_back);
    }

    private void populateData() {
        // Set user-specific data
        textViewName.setText(name);
        
        // Set tag
        textViewTags.setText(tag);
        
        // Generate user-specific bio based on tag
        String bio = generateBioBasedOnTag(tag);
        textViewBio.setText(bio);
        
        // Set avatar (in a real app, this would come from actual user data)
        imageViewAvatar.setImageResource(avatarResource);
        
        // Set cover image (could be user-specific in a real app)
        imageViewCover.setImageResource(R.drawable.ic_launcher_background);
    }
    
    private String generateBioBasedOnTag(String tag) {
        switch (tag) {
            case "产品设计":
                return "专注于用户体验和产品创新，拥有5年以上的产品设计经验。热衷于研究新兴技术和设计趋势，喜欢参与开源项目和设计社区活动。";
            case "数据分析":
                return "数据科学专家，擅长Python和机器学习，致力于用数据驱动业务决策。喜欢分享技术知识，经常在技术会议上发表演讲。";
            case "用户调研":
                return "资深用户研究员，专注于用户行为分析和市场洞察。善于通过定性和定量研究方法挖掘用户需求，帮助企业优化产品和服务。";
            default:
                // Generate a random bio for other tags
                String[] defaultBios = {
                    "热爱技术，喜欢探索新技术和解决方案。",
                    "经验丰富的问题解决者，专注于提供高质量的服务。",
                    "持续学习者，致力于不断提升自己的专业技能。",
                    "团队合作爱好者，乐于与他人分享知识和经验。"
                };
                Random random = new Random();
                return defaultBios[random.nextInt(defaultBios.length)];
        }
    }

    private void setListeners() {
        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start chat activity
                Intent intent = new Intent(OtherHomeActivity.this, ChatActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("avatar", avatarResource);
                startActivity(intent);
            }
        });
        
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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