package com.zic.diemdanhapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.adapters.MethodChung;

import org.json.JSONException;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ThongTinSinhVien extends AppCompatActivity {

    String manhanduoc;

    String ma, ten, hinh, ngaysinh, gioitinh, sdt, email, tenlop, trinhdo, chucvu, tenkhoa, pass;

    ProgressDialog progressDialog;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_sinh_vien);
        getSupportActionBar().hide();

        // Nhận mã SV từ phần đăng nhập
        Intent nhanpass = getIntent();
        manhanduoc = nhanpass.getStringExtra("ma");

        // Lấy thông tin GV theo mã
        String urlthongtinsinhvien = "nguoidung/findById/" + manhanduoc;
        new HttpAsyncTask().execute(MethodChung.CreateURL() + urlthongtinsinhvien);

        drawerLayout = findViewById(R.id.drawerlayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        final NavigationView navigationView = findViewById(R.id.navigationview);
        toggle.syncState();
        ImageView toolbar = findViewById(R.id.btnmenu);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(navigationView);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);

//        // Hiện progress bar
//        progressDialog = new ProgressDialog(ThongTinSinhVien.this);
//        progressDialog.setMessage("Loading..."); // Setting Message
//        progressDialog.setTitle("Đang kiểm tra ~"); // Setting Title
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
//        progressDialog.show(); // Display Progress Dialog
//        progressDialog.setCancelable(false);
//        new Thread(new Runnable() {
//            public void run() {
//            }
//        }).start();
//
//        //Delay 1s
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // Tắt progress bar
//                progressDialog.dismiss();
//
//            }
//        }, 1000);

        // Sự kiện bấm nút Quét mã QR
        Button btnqr = findViewById(R.id.btnQRSV);
        btnqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentqr = new Intent(ThongTinSinhVien.this, QuetMaQR.class);
                intentqr.putExtra("ma", manhanduoc);
                intentqr.putExtra("status", "0");
                intentqr.putExtra("pass", pass);
                startActivity(intentqr);

            }
        });
    }

    public void selectItemDrawer(MenuItem menuItem) {
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.bangDiemDanh:
                Intent intentb = new Intent(ThongTinSinhVien.this, ChiTietDiemDanh.class);
                intentb.putExtra("ma", manhanduoc);
                intentb.putExtra("status", "0");
                startActivity(intentb);
                break;
            case R.id.xemLichDay:
                Intent intentb1 = new Intent(ThongTinSinhVien.this, XemLichHoc.class);
                intentb1.putExtra("ma", manhanduoc);
                intentb1.putExtra("status", "0");
                startActivity(intentb1);
                break;
            case R.id.doiMatKhau:
                Intent intentb2 = new Intent(ThongTinSinhVien.this, ChangePass.class);
                intentb2.putExtra("ma", manhanduoc);
                intentb2.putExtra("status", "0");
                startActivity(intentb2);
                break;
            case R.id.dangXuat:
                Intent intentb3 = new Intent(ThongTinSinhVien.this, MainActivity.class);
                startActivity(intentb3);
                break;
            default:
                fragmentClass = ThongTinSinhVien.class;
        }

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectItemDrawer(menuItem);
                return true;
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

            TextView tenNavi = findViewById(R.id.txtViewTenNavi);
            TextView lopNavi = findViewById(R.id.txtViewLopNavi);
            TextView maNavi = findViewById(R.id.txtViewMaNavi);

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
                pass = jsonObj.getString("matKhau");

                tenNavi.setText(ten);
                lopNavi.setText(tenlop);
                maNavi.setText(ma);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


}
