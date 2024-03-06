package com.qooke.registerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.camera2.CameraManager;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity {

    ImageView imgAvata;
    Button btnRabbit;
    Button btnTurtle;
    Button btnOK;

    String email;


    // 아바타 선택이 안된 것으로 셋팅하고 누르면 바뀌는 것으로 셋팅
    Boolean isSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imgAvata = findViewById(R.id.imgAvata);
        btnRabbit = findViewById(R.id.btnRabbit);
        btnTurtle = findViewById(R.id.btnTurtle);
        btnOK = findViewById(R.id.btnOK);

        // 데이터 받아주기
        email = getIntent().getStringExtra("email");


        btnRabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAvata.setImageResource(R.drawable.rabbit);
                isSelected = true;
            }
        });

        btnTurtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAvata.setImageResource(R.drawable.turtle);
                isSelected = true;
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelected == false) {
                    Snackbar.make(btnOK, "먼저 아바타를 선택하세요.", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                // 알러트 다이얼로그 띄운다.(실행)
                showAlertDialog();
            }
        });
    }

    // 알러트 다이얼로그 클래스
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
        builder.setCancelable(false);
        builder.setTitle("회원 가입 완료");
        builder.setMessage("완료하시겠습니까?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // todo: 다음 액티비티 실행
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                // 데이터 전달하기
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // todo : 앱 종료, 딱 이 액티비티만 종료
                finish();
            }
        });
        builder.show();
    }
}