package com.zic.diemdanhapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePass extends AppCompatActivity {

    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);
        getSupportActionBar().hide();

        Intent nhanpass = getIntent();
        pass = nhanpass.getStringExtra("oldpass");

        // Sự kiện bấm nút Huỷ
        Button btnhuychange = findViewById(R.id.btnHuyChange);
        btnhuychange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutMain = new Intent(getApplicationContext(), MainActivity.class);
                chuyenlayoutMain.putExtra("newpass", pass);
                startActivity(chuyenlayoutMain);
            }
        });

        // Sự kiện bấm nút Tiếp tục
        Button btntieptucchange = findViewById(R.id.btnTiepChange);
        btntieptucchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editoldpass = findViewById(R.id.editOldPass);
                EditText editnewpass1 = findViewById(R.id.editNewPass1);
                EditText editnewpass2 = findViewById(R.id.editNewPass2);

                if (!editoldpass.getText().toString().equals(pass))
                    Toast.makeText(getApplicationContext(), "Mật khẩu cũ không đúng", Toast.LENGTH_SHORT).show();
                else if (!editnewpass2.getText().toString().equals(editnewpass1.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Nhập lại mật khẩu sai", Toast.LENGTH_SHORT).show();
                else if (editnewpass1.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "Bạn phải nhập mật khẩu mới", Toast.LENGTH_SHORT).show();
                else if (!editnewpass2.getText().toString().isEmpty() && editoldpass.getText().toString().equals(pass) && editnewpass2.getText().toString().equals(editnewpass1.getText().toString())) {
                    Intent chuyenpassmoi = new Intent(getApplicationContext(), MainActivity.class);
                    chuyenpassmoi.putExtra("newpass", editnewpass2.getText().toString());

                    startActivity(chuyenpassmoi);
                }
            }
        });
    }
}
