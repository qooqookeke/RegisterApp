package com.qooke.registerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editPassword;
    EditText editPassword2;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editPassword2 = findViewById(R.id.editPassword2);
        btnRegister = findViewById(R.id.btnRegister);


        // 회원 가입 버튼 눌렀을때 실행될 활동
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                String password2 = editPassword2.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty() || password2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

                // 이메일에 '@'가 포함되어 있지 않으면 에러창 보냄
                if (email.contains("@") == false) {
                    Snackbar.make(btnRegister, "이메일을 바르게 입력하세요", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                // 패스워드 길이 체크
                if (password.length() < 4 || password.length() > 12) {
                    Snackbar.make(btnRegister, "비밀번호 길이를 확인하세요", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                // 패스워드 일치 확인
                if (password.equals(password2) == false) {
                    Snackbar.make(btnRegister, "비밀번호가 일치하지 않습니다", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                // 모두 정상이니까 두번째 액티비티를 실행한다.
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);

                // 해당 액티비티 종료
                finish();
            }
        });
    }
}