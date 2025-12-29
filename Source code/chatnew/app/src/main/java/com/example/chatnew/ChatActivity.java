package com.example.chatnew;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMessages;
    private EditText editTextMessage;
    private ImageButton buttonSend, buttonEmoji, buttonAttachment;
    private ImageView ivBack, imageViewAvatar, buttonCall, buttonVideo;
    private TextView tvTitle, tvStatus;
    private String partnerName;
    private int partnerAvatar;
    private List<ChatMessage> chatMessages;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Get data from intent
        partnerName = getIntent().getStringExtra("name");
        partnerAvatar = getIntent().getIntExtra("avatar", R.drawable.ic_launcher_foreground);

        initViews();
        setupRecyclerView();
        loadDefaultMessages();
        setListeners();
    }

    private void initViews() {
        recyclerViewMessages = findViewById(R.id.recycler_view_messages);
        editTextMessage = findViewById(R.id.et_message);
        buttonSend = findViewById(R.id.btn_send);
        buttonEmoji = findViewById(R.id.btn_emoji);
        buttonAttachment = findViewById(R.id.btn_attachment);
        ivBack = findViewById(R.id.iv_back);
        imageViewAvatar = findViewById(R.id.image_view_avatar);
        buttonCall = findViewById(R.id.btn_call);
        buttonVideo = findViewById(R.id.btn_video);
        tvTitle = findViewById(R.id.tv_title);
        tvStatus = findViewById(R.id.tv_status);
    }

    private void setupRecyclerView() {
        chatMessages = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatMessages);
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessages.setAdapter(chatAdapter);
    }

    private void loadDefaultMessages() {
        // Set partner name in toolbar
        tvTitle.setText(partnerName);
        
        // Set partner avatar
        imageViewAvatar.setImageResource(partnerAvatar);
        
        chatMessages.add(new ChatMessage(partnerName, "你好，我是【" + partnerName + "】，擅长【数据分析】", true));
        chatMessages.add(new ChatMessage("我", "你好，想找你聊聊相关的内容", false));
        chatMessages.add(new ChatMessage(partnerName, "随时可以交流，一起进步！", true));
        
        chatAdapter.notifyDataSetChanged();
        scrollToBottom();
    }

    private void scrollToBottom() {
        if (chatMessages.size() > 0) {
            recyclerViewMessages.scrollToPosition(chatMessages.size() - 1);
        }
    }

    private void setListeners() {
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
        
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        buttonEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatActivity.this, "表情功能占位", Toast.LENGTH_SHORT).show();
            }
        });
        
        buttonAttachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatActivity.this, "附件功能占位", Toast.LENGTH_SHORT).show();
            }
        });
        
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatActivity.this, "电话通话功能占位", Toast.LENGTH_SHORT).show();
            }
        });
        
        buttonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatActivity.this, "视频通话功能占位", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendMessage() {
        String message = editTextMessage.getText().toString().trim();
        if (!message.isEmpty()) {
            chatMessages.add(new ChatMessage("我", message, false));
            chatAdapter.notifyItemInserted(chatMessages.size() - 1);
            scrollToBottom();
            editTextMessage.setText("");
        }
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