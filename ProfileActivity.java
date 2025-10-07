package com.example.tuan6;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import com.google.android.material.card.MaterialCardView;

public class ProfileActivity extends AppCompatActivity {

    private TextView txtWelcome, txtUsername, txtEmail, txtPhone, txtMemberSince;
    private ImageView imgSetting, imgBack;
    private MaterialCardView cardEditProfile, cardSecurity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initializeViews();
        setupUserData();
        setupClickListeners();
    }

    private void initializeViews() {
        txtWelcome = findViewById(R.id.txtWelcome);
        txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        txtMemberSince = findViewById(R.id.txtMemberSince);
        imgSetting = findViewById(R.id.imgSetting);
        imgBack = findViewById(R.id.imgBack);
        cardEditProfile = findViewById(R.id.cardEditProfile);
        cardSecurity = findViewById(R.id.cardSecurity);
    }

    private void setupUserData() {
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String memberSince = intent.getStringExtra("memberSince");

        txtWelcome.setText("Trần Sỹ Khánh!");
        txtUsername.setText(username);
        txtEmail.setText(email != null ? email : username + "@example.com");
        txtPhone.setText(phone != null ? phone : "+1 234 567 8900");
        txtMemberSince.setText(memberSince != null ? memberSince : "January 2024");
    }

    private void setupClickListeners() {
        imgSetting.setOnClickListener(v -> navigateToLogin());

        imgBack.setOnClickListener(v -> navigateToLogin());

        cardEditProfile.setOnClickListener(v -> {
            Toast.makeText(this, "Edit Profile feature coming soon!", Toast.LENGTH_SHORT).show();
        });

        cardSecurity.setOnClickListener(v -> {
            Toast.makeText(this, "Security settings coming soon!", Toast.LENGTH_SHORT).show();
        });
    }

    private void navigateToLogin() {
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}