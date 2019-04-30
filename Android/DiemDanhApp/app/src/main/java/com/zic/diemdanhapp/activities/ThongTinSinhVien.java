package com.zic.diemdanhapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.adapters.MethodChung;

import org.json.JSONException;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ThongTinSinhVien extends AppCompatActivity {

    String manhanduoc;

    String ma, ten, hinh, ngaysinh, gioitinh, sdt, email, tenlop, trinhdo, chucvu, tenkhoa;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_sinh_vien);
        getSupportActionBar().hide();

        final TextView txtma = findViewById(R.id.txtViewMaSV);
        final TextView txtten = findViewById(R.id.txtViewTenSV);
        //hinh
        final TextView txtngaysinh = findViewById(R.id.txtViewNgaySinhSV);
        final TextView txtgioitinh = findViewById(R.id.txtViewGioiTinhSV);
        final TextView txtsdt = findViewById(R.id.txtViewSDTSV);
        final TextView txtemail = findViewById(R.id.txtViewEmailSV);
        final TextView txttenlop = findViewById(R.id.txtViewTenLopSV);
        final TextView txttrinhdo = findViewById(R.id.txtViewTrinhDoSV);
        final TextView txtchucvu = findViewById(R.id.txtViewChucVuSV);
        final TextView txttenkhoa = findViewById(R.id.txtViewKhoaSV);

        // Nhận mã SV từ phần đăng nhập
        Intent nhanpass = getIntent();
        manhanduoc = nhanpass.getStringExtra("ma");

        // Lấy thông tin GV theo mã
        String urlthongtinsinhvien = "nguoidung/findById/" + manhanduoc;
        new HttpAsyncTask().execute(MethodChung.CreateURL() + urlthongtinsinhvien);

        // Hiện progress bar
        progressDialog = new ProgressDialog(ThongTinSinhVien.this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("Đang kiểm tra ~"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
            }
        }).start();

        //Delay 2s để lấy dữ liệu ( phòng trường hợp mạng yếu )
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Tắt progress bar
                progressDialog.dismiss();

                txtma.setText(ma);
                txtten.setText(ten);
                //hinh
                txtngaysinh.setText(ngaysinh);
                txtgioitinh.setText(gioitinh);
                txtsdt.setText(sdt);
                txtemail.setText(email);
                txttenlop.setText(tenlop);
                txttrinhdo.setText(trinhdo);
                txtchucvu.setText(chucvu);
                txttenkhoa.setText(tenkhoa);
                Toast.makeText(ThongTinSinhVien.this, ma, Toast.LENGTH_SHORT).show();

            }
        }, 2000);

        // Sự kiện bấm nút Đăng xuất
        Button btnlogoutsv = findViewById(R.id.btnLogoutSV);
        btnlogoutsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(chuyenlayoutMain);
            }
        });

        // Sự kiện bấm nút Xem lịch học
        Button btnxemlichhoc = findViewById(R.id.btnXemLichSV);
        btnxemlichhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutxemlichhoc = new Intent(getApplicationContext(), XemLichHoc.class);
                startActivity(chuyenlayoutxemlichhoc);
            }
        });

        // Sự kiện bấm nút Quét mã QR
        Button btnqr = findViewById(R.id.btnQRSV);
        btnqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), QuetMaQR.class));
            }
        });
    }

    // Không cho bấm nút Back quay lại màn hình Đăng nhập
    @Override
    public void onBackPressed() {

    }

    //Hàm xử lý JSON
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return MethodChung.GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject jsonObj = new JSONObject(result); // convert String to JSONObject
                ma = jsonObj.getString("maNguoiDung");
                ten = jsonObj.getString("tenNguoiDung");
                hinh = jsonObj.getString("hinh");
                ngaysinh = jsonObj.getString("ngaySinh");
                gioitinh = jsonObj.getString("gioiTinh");
                sdt = jsonObj.getString("sodienthoai");
                email = jsonObj.getString("email");
                tenlop = jsonObj.getString("tenLop");
                trinhdo = jsonObj.getString("trinhDo");
                chucvu = jsonObj.getString("chucVu");
                tenkhoa = jsonObj.getString("tenKhoa");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


}
