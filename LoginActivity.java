package com.example.tuan6;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText edtUsername, edtPassword;
    private Button btnLogin;
    private CheckBox cbRemember;
    private TextView txtForgotPassword, txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        cbRemember = findViewById(R.id.cbRemember);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        txtSignUp = findViewById(R.id.txtSignUp);
    }

    private void setupClickListeners() {
        btnLogin.setOnClickListener(v -> handleLogin());

        txtForgotPassword.setOnClickListener(v -> {
            Toast.makeText(this, "Forgot Password feature coming soon!", Toast.LENGTH_SHORT).show();
        });

        txtSignUp.setOnClickListener(v -> {
            Toast.makeText(this, "Sign Up feature coming soon!", Toast.LENGTH_SHORT).show();
        });
    }

    private void handleLogin() {
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simulate successful login
        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("email", username.contains("@") ? username : username + "@example.com");
        intent.putExtra("phone", "+1 234 567 8900");
        intent.putExtra("memberSince", "January 2024");
        startActivity(intent);
        finish();
    }
}