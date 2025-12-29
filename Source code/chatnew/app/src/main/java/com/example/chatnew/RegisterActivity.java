package com.example.chatnew;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private ImageView ivBack;
    private EditText etPhone, etVerificationCode, etPassword, etConfirmPassword;
    private Button btnGetCode, btnRegister;
    private TextView tvTitle;

    private CountDownTimer countDownTimer;
    private boolean isCounting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        setListeners();
    }

    private void initViews() {
        ivBack = findViewById(R.id.iv_back);
        tvTitle = findViewById(R.id.tv_title);
        etPhone = findViewById(R.id.et_phone);
        etVerificationCode = findViewById(R.id.et_verification_code);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        btnGetCode = findViewById(R.id.btn_get_code);
        btnRegister = findViewById(R.id.btn_register);
    }

    private void setListeners() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCode();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void getCode() {
        if (isCounting) {
            return;
        }

        String phone = etPhone.getText().toString().trim();
        if (phone.isEmpty() || phone.length() != 11) {
            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        // 显示验证码（模拟发送）
        Toast.makeText(this, "验证码已发送：123456", Toast.LENGTH_SHORT).show();

        // 启动倒计时
        startCountdown();
    }

    private void startCountdown() {
        isCounting = true;
        btnGetCode.setEnabled(false);

        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int secondsRemaining = (int) (millisUntilFinished / 1000);
                btnGetCode.setText(secondsRemaining + "秒后重试");
            }

            @Override
            public void onFinish() {
                isCounting = false;
                btnGetCode.setText("获取验证码");
                btnGetCode.setEnabled(true);
            }
        };

        countDownTimer.start();
    }

    private void register() {
        String phone = etPhone.getText().toString().trim();
        String code = etVerificationCode.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if (phone.isEmpty() || phone.length() != 11) {
            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (code.isEmpty()) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!code.equals("123456")) {
            Toast.makeText(this, "验证码错误", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty() || password.length() < 6 || password.length() > 16) {
            Toast.makeText(this, "请设置6-16位密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "注册成功，请登录", Toast.LENGTH_SHORT).show();
        
        // 停止倒计时（如果正在进行）
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        
        // 返回登录页面
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 确保在Activity销毁时取消倒计时
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}