package com.example.chatnew;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditHomeActivity extends AppCompatActivity {
    private ImageView imageViewAvatar;
    private EditText editTextNickname, editTextTags, editTextBio;
    private Button btnSave;
    private TextView tvSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_home);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initViews();
        loadCurrentProfile();
        setListeners();
    }

    private void initViews() {
        imageViewAvatar = findViewById(R.id.image_view_avatar);
        editTextNickname = findViewById(R.id.et_nickname);
        editTextTags = findViewById(R.id.et_tags);
        editTextBio = findViewById(R.id.et_bio);
        btnSave = findViewById(R.id.btn_save);
        tvSave = findViewById(R.id.tv_save);
    }

    private void loadCurrentProfile() {
        // Load current profile data
        SharedPreferences sharedPreferences = getSharedPreferences("login_prefs", MODE_PRIVATE);
        String userType = sharedPreferences.getString("user_type", "guest");

        if ("guest".equals(userType)) {
            // Load guest profile
            editTextNickname.setText("游客123");
            editTextTags.setText("数据分析");
            editTextBio.setText("新手求带");
        } else {
            // Load registered user profile (same as guest for now)
            editTextNickname.setText("注册用户");
            editTextTags.setText("数据分析");
            editTextBio.setText("新手求带");
        }
    }

    private void setListeners() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfile();
            }
        });
        
        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfile();
            }
        });
    }

    private void saveProfile() {
        String name = editTextNickname.getText().toString().trim();
        String tags = editTextTags.getText().toString().trim();
        String bio = editTextBio.getText().toString().trim();

        if (name.isEmpty()) {
            Toast.makeText(this, "请输入姓名", Toast.LENGTH_SHORT).show();
            return;
        }

        if (tags.isEmpty()) {
            Toast.makeText(this, "请输入技能标签", Toast.LENGTH_SHORT).show();
            return;
        }

        if (bio.isEmpty()) {
            Toast.makeText(this, "请输入个人简介", Toast.LENGTH_SHORT).show();
            return;
        }

        // In a real app, you would save this data somewhere
        // For now, we'll just show a success message
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        
        // Go back to MyHomeActivity
        Intent intent = new Intent(EditHomeActivity.this, MyHomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
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