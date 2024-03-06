package com.qooke.registerapp;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class ThirdActivity extends AppCompatActivity {

    TextView txtWelcome;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_third);

            txtWelcome = findViewById(R.id.txtWelcome);

            String email = getIntent().getStringExtra("email");

            // 데이터를 한번에 받아오지 않고 순서대로 데이터를 주고 받고 주고 받아와야 함
            txtWelcome.setText(email + " 님 회원가입을 축하합니다.");

            getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
                @Override
                public void handleOnBackPressed() {
                    finish();
                }
            });

        }
    }