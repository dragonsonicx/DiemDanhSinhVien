package com.zic.diemdanhapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;
import com.zic.diemdanhapp.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ThongTinSinhVien extends AppCompatActivity{

    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_sinh_vien);
        getSupportActionBar().hide();

        Intent nhanpass = getIntent();
        pass = nhanpass.getStringExtra("oldpass");

        // Sự kiện bấm nút Đăng xuất
        Button btnlogoutsv = findViewById(R.id.btnLogoutSV);
        btnlogoutsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutMain = new Intent(getApplicationContext(), MainActivity.class);
                chuyenlayoutMain.putExtra("newpass", pass);
                startActivity(chuyenlayoutMain);
            }
        });

        // Sự kiện bấm nút Xem lịch học
        Button btnxemlichhoc = findViewById(R.id.btnXemLichSV);
        btnxemlichhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutxemlichhoc = new Intent(getApplicationContext(), XemLichHoc.class);
                chuyenlayoutxemlichhoc.putExtra("newpass", pass);
                startActivity(chuyenlayoutxemlichhoc);
            }
        });

        // Sự kiện bấm nút Quét mã QR
        Button btnqr = findViewById(R.id.btnQRSV);
        btnqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),QuetMaQR.class));
            }
        });
    }


}
