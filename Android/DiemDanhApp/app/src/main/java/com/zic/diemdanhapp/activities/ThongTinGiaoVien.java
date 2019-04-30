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
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.adapters.MethodChung;

import org.json.JSONException;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ThongTinGiaoVien extends AppCompatActivity{

    String manhanduoc;

    String ma, ten, hinh, ngaysinh, gioitinh, trinhdo, chucvu, tenkhoa;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_giao_vien);
        getSupportActionBar().hide();

        final TextView txtma = findViewById(R.id.txtViewMaGV);
        final TextView txtten = findViewById(R.id.txtViewTenGV);
        //hinh
        final TextView txtngaysinh = findViewById(R.id.txtViewNgaySinhGV);
        final TextView txtgioitinh = findViewById(R.id.txtViewGioiTinhGV);
        final TextView txttrinhdo = findViewById(R.id.txtViewTrinhDoGV);
        final TextView txtchucvu = findViewById(R.id.txtViewChucVuGV);
        final TextView txttenkhoa = findViewById(R.id.txtViewKhoaGV);

        // Nhận mã GV từ phần đăng nhập
        Intent nhanpass = getIntent();
        manhanduoc = nhanpass.getStringExtra("ma");

        // Lấy thông tin GV theo mã
        String urlthongtingiaovien = "nguoidung/findById/" + manhanduoc;
        new HttpAsyncTask().execute(urlthongtingiaovien);

        // Hiện progress bar
        progressDialog = new ProgressDialog(ThongTinGiaoVien.this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("Đang kiểm tra ~"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
            }
        }).start();

        //Delay 1.5s để lấy dữ liệu ( phòng trường hợp mạng yếu )
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Tắt progress bar
                progressDialog.dismiss();

            }
        }, 1500);

        txtma.setText(ma);
        txtten.setText(ten);
        //hinh
        txtngaysinh.setText(ngaysinh);
        txtgioitinh.setText(gioitinh);
        txttrinhdo.setText(trinhdo);
        txtchucvu.setText(chucvu);
        txttenkhoa.setText(tenkhoa);

        // Sự kiện bấm nút Đăng xuất
        Button btnlogoutgv = findViewById(R.id.btnLogoutGV);
        btnlogoutgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(chuyenlayoutMain);
            }
        });

        // Sự kiện bấm nút Sửa danh sách
        Button btnchinhsuagv = findViewById(R.id.btnChinhSuaGV);
        btnchinhsuagv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutchinhsua = new Intent(getApplicationContext(), ChinhSuaSV.class);
                startActivity(chuyenlayoutchinhsua);
            }
        });

        // Sự kiện bấm nút Bảng điểm danh
        Button btnctddanh = findViewById(R.id.btnBangDiemDanh);
        btnctddanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutbangdiemdanh = new Intent(getApplicationContext(), ChiTietDiemDanh.class);
                startActivity(chuyenlayoutbangdiemdanh);
            }
        });

        // Sự kiện bấm nút Xem lịch học
        Button btnxemlichhoc = findViewById(R.id.btnXemLichGV);
        btnxemlichhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutxemlichhoc = new Intent(getApplicationContext(), XemLichHoc.class);
                startActivity(chuyenlayoutxemlichhoc);
            }
        });

        // Sự kiện bấm nút Quét mã QR
        Button btnqr = findViewById(R.id.btnQRGV);
        btnqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),QuetMaQR.class));
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
                ten = jsonObj.getString("matKhau");
                hinh = jsonObj.getString("hinh");
                ngaysinh = jsonObj.getString("ngaySinh");
                gioitinh = jsonObj.getString("gioiTinh");
                trinhdo = jsonObj.getString("trinhDo");
                chucvu = jsonObj.getString("chucVu");
                tenkhoa = jsonObj.getString("tenKhoa");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
