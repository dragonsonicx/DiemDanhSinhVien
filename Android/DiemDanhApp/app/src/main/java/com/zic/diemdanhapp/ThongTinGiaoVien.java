package com.zic.diemdanhapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThongTinGiaoVien extends AppCompatActivity {

    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_giao_vien);
        getSupportActionBar().hide();

        Intent nhanpass = getIntent();
        pass = nhanpass.getStringExtra("oldpass");

        // Sự kiện bấm nút Đăng xuất
        Button btnlogoutgv = findViewById(R.id.btnLogoutGV);
        btnlogoutgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutMain = new Intent(getApplicationContext(), MainActivity.class);
                chuyenlayoutMain.putExtra("newpass", pass);
                startActivity(chuyenlayoutMain);
            }
        });

        // Sự kiện bấm nút Sửa danh sách
        Button btnchinhsuagv = findViewById(R.id.btnChinhSuaGV);
        btnchinhsuagv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutchinhsua = new Intent(getApplicationContext(), ChinhSuaSV.class);
                chuyenlayoutchinhsua.putExtra("newpass", pass);
                startActivity(chuyenlayoutchinhsua);
            }
        });

        // Sự kiện bấm nút Bảng điểm danh
        Button btnctddanh = findViewById(R.id.btnBangDiemDanh);
        btnctddanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutbangdiemdanh = new Intent(getApplicationContext(), ChiTietDiemDanh.class);
                chuyenlayoutbangdiemdanh.putExtra("newpass", pass);
                startActivity(chuyenlayoutbangdiemdanh);
            }
        });

        // Sự kiện bấm nút Xem lịch học
        Button btnxemlichhoc = findViewById(R.id.btnXemLichGV);
        btnxemlichhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutxemlichhoc = new Intent(getApplicationContext(), XemLichHoc.class);
                chuyenlayoutxemlichhoc.putExtra("newpass", pass);
                startActivity(chuyenlayoutxemlichhoc);
            }
        });

        // Sự kiện bấm nút Quét mã QR
        Button btnqr = findViewById(R.id.btnQRGV);
        btnqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutqr = new Intent(getApplicationContext(), QuetMaQR.class);
                chuyenlayoutqr.putExtra("newpass", pass);
                startActivity(chuyenlayoutqr);
            }
        });
    }
}
