package com.example.chatnew;

import android.os.Bundle;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {

    private EditText editTextContent;
    private TextView btnCancel;
    private TextView btnPost;
    private TextView textVisibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        editTextContent = findViewById(R.id.edit_text_content);
        btnCancel = findViewById(R.id.btn_cancel);
        btnPost = findViewById(R.id.btn_post);
        textVisibility = findViewById(R.id.text_visibility);
    }

    private void setupClickListeners() {
        // 取消按钮点击事件
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 关闭当前页面，返回上一页
            }
        });

        // 发表按钮点击事件 - 默认为灰色，输入内容后变亮
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editTextContent.getText().toString().trim();
                if (!content.isEmpty()) {
                    // 这里可以添加发布逻辑
                    finish(); // 发布后返回上一页
                }
            }
        });

        // 监听输入框内容变化，以控制发表按钮状态
        editTextContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updatePostButtonState();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // 位置选项点击事件
        findViewById(R.id.option_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理位置选择逻辑
            }
        });

        // 提醒谁看点击事件
        findViewById(R.id.option_mention).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理提醒谁看逻辑
            }
        });

        // 可见性设置点击事件
        findViewById(R.id.option_visibility).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理可见性设置逻辑
            }
        });
    }

    private void updatePostButtonState() {
        String content = editTextContent.getText().toString().trim();
        if (!content.isEmpty()) {
            btnPost.setTextColor(getResources().getColor(R.color.morandi_blue)); // 设置为可用状态颜色
        } else {
            btnPost.setTextColor(getResources().getColor(R.color.morandi_gray)); // 设置为不可用状态颜色
        }
    }
}