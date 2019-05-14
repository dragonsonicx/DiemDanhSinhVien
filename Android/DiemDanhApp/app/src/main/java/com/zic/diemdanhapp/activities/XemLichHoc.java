package com.zic.diemdanhapp.activities;

import android.app.ProgressDialog;

import android.content.Intent;

import android.graphics.Color;

import android.os.AsyncTask;
import android.os.Handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.adapters.MethodChung;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class XemLichHoc extends AppCompatActivity {

    String ma, status, urlxemlichhoc;

    String monhoc;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_lich_hoc);
        getSupportActionBar().hide();

        // Nhận mã và status
        Intent nhanpass = getIntent();
        ma = nhanpass.getStringExtra("ma");
        status = nhanpass.getStringExtra("status").toString();

        TextView txtviewtitle = findViewById(R.id.txtViewTitle);

        if (status.equals("0")) {
            urlxemlichhoc = MethodChung.CreateURL() + "sinhvien/xemLichDay/" + ma;
            txtviewtitle.setText("XEM LỊCH HỌC");

        } else if (status.equals("1")) {
            urlxemlichhoc = MethodChung.CreateURL() + "giaovien/xemLichDay/" + ma;
            txtviewtitle.setText("XEM LỊCH DẠY");
        }

        //Thực hiện code Json
        new HttpAsyncTaskLichHoc().execute(urlxemlichhoc);

        // Hiện progress bar
        progressDialog = new ProgressDialog(XemLichHoc.this);
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

            }
        }, 1000);


    }

    //Hàm xử lý JSON hiện lich học/dạy
    private class HttpAsyncTaskLichHoc extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return MethodChung.GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            CreateTextView(result);

        }
    }

    // Tạo text view tương ứng
    private void CreateTextView(String result) {

        TableRow row2sang = findViewById(R.id.rowT2Sang);
        TableRow row2chieu = findViewById(R.id.rowT2Chieu);
        TableRow row2toi = findViewById(R.id.rowT2Toi);

        TableRow row3sang = findViewById(R.id.rowT3Sang);
        TableRow row3chieu = findViewById(R.id.rowT3Chieu);
        TableRow row3toi = findViewById(R.id.rowT3Toi);

        TableRow row4sang = findViewById(R.id.rowT4Sang);
        TableRow row4chieu = findViewById(R.id.rowT4Chieu);
        TableRow row4toi = findViewById(R.id.rowT4Toi);

        TableRow row5sang = findViewById(R.id.rowT5Sang);
        TableRow row5chieu = findViewById(R.id.rowT5Chieu);
        TableRow row5toi = findViewById(R.id.rowT5Toi);

        TableRow row6sang = findViewById(R.id.rowT6Sang);
        TableRow row6chieu = findViewById(R.id.rowT6Chieu);
        TableRow row6toi = findViewById(R.id.rowT6Toi);

        TableRow row7sang = findViewById(R.id.rowT7Sang);
        TableRow row7chieu = findViewById(R.id.rowT7Chieu);
        TableRow row7toi = findViewById(R.id.rowT7Toi);

        TableRow row8sang = findViewById(R.id.rowT8Sang);
        TableRow row8chieu = findViewById(R.id.rowT8Chieu);
        TableRow row8toi = findViewById(R.id.rowT8Toi);

        try {
            JSONArray array = new JSONArray(result);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                String thu = obj.getString("thu");
                String tenmonhoc = obj.getString("tenMonHoc");
                String giobatdau = obj.getString("gioBatDau");
                String gioketthuc = obj.getString("gioKetThuc");
                String tenphonghoc = obj.getString("tenPhongHoc");
                String buoihoc = obj.getString("buoiHoc");

                // Kiểm tra thứ
                // Thứ 2
                if (thu.equals("2")) {
                    //Kiểm tra buổi học
                    switch (buoihoc) {
                        case "Sáng":
                            TextView txtView2sang = new TextView(this);
                            CreateTextViewMonHoc(txtView2sang, row2sang, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Chiều":
                            TextView txtView2chieu = new TextView(this);
                            CreateTextViewMonHoc(txtView2chieu, row2chieu, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Tối":
                            TextView txtView2toi = new TextView(this);
                            CreateTextViewMonHoc(txtView2toi, row2toi, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        default:
                            break;
                    }
                }
                // Thứ 3
                else if (thu.equals("3"))
                    //Kiểm tra buổi học
                    switch (buoihoc) {
                        case "Sáng":
                            TextView txtView3sang = new TextView(this);
                            CreateTextViewMonHoc(txtView3sang, row3sang, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Chiều":
                            TextView txtView3chieu = new TextView(this);
                            CreateTextViewMonHoc(txtView3chieu, row3chieu, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Tối":
                            TextView txtView3toi = new TextView(this);
                            CreateTextViewMonHoc(txtView3toi, row3toi, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        default:
                            break;
                    }

                    // Thứ 4
                else if (thu.equals("4"))
                    //Kiểm tra buổi học
                    switch (buoihoc) {
                        case "Sáng":
                            TextView txtView4sang = new TextView(this);
                            CreateTextViewMonHoc(txtView4sang, row4sang, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Chiều":
                            TextView txtView4chieu = new TextView(this);
                            CreateTextViewMonHoc(txtView4chieu, row4chieu, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Tối":
                            TextView txtView4toi = new TextView(this);
                            CreateTextViewMonHoc(txtView4toi, row4toi, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        default:
                            break;
                    }

                    // Thứ 5
                else if (thu.equals("5"))
                    //Kiểm tra buổi học
                    switch (buoihoc) {
                        case "Sáng":
                            TextView txtView5sang = new TextView(this);
                            CreateTextViewMonHoc(txtView5sang, row5sang, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Chiều":
                            TextView txtView5chieu = new TextView(this);
                            CreateTextViewMonHoc(txtView5chieu, row5chieu, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Tối":
                            TextView txtView5toi = new TextView(this);
                            CreateTextViewMonHoc(txtView5toi, row5toi, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        default:
                            break;
                    }

                    // Thứ 6
                else if (thu.equals("6"))
                    //Kiểm tra buổi học
                    switch (buoihoc) {
                        case "Sáng":
                            TextView txtView6sang = new TextView(this);
                            CreateTextViewMonHoc(txtView6sang, row6sang, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Chiều":
                            TextView txtView6chieu = new TextView(this);
                            CreateTextViewMonHoc(txtView6chieu, row6chieu, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Tối":
                            TextView txtView6toi = new TextView(this);
                            CreateTextViewMonHoc(txtView6toi, row6toi, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        default:
                            break;
                    }

                    // Thứ 7
                else if (thu.equals("7"))
                    //Kiểm tra buổi học
                    switch (buoihoc) {
                        case "Sáng":
                            TextView txtView7sang = new TextView(this);
                            CreateTextViewMonHoc(txtView7sang, row7sang, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Chiều":
                            TextView txtView7chieu = new TextView(this);
                            CreateTextViewMonHoc(txtView7chieu, row7chieu, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Tối":
                            TextView txtView7toi = new TextView(this);
                            CreateTextViewMonHoc(txtView7toi, row7toi, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        default:
                            break;
                    }

                    // Chủ nhật
                else if (thu.equals("8"))
                    //Kiểm tra buổi học
                    switch (buoihoc) {
                        case "Sáng":
                            TextView txtView8sang = new TextView(this);
                            CreateTextViewMonHoc(txtView8sang, row8sang, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Chiều":
                            TextView txtView8chieu = new TextView(this);
                            CreateTextViewMonHoc(txtView8chieu, row8chieu, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        case "Tối":
                            TextView txtView8toi = new TextView(this);
                            CreateTextViewMonHoc(txtView8toi, row8toi, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                            break;
                        default:
                            break;
                    }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //Hàm tạo môn học  trên lịch học
    private void CreateTextViewMonHoc(TextView t, TableRow r, String tenmonhoc, String giobatdau, String gioketthuc, String tenphonghoc) {
        t.setWidth(300);
        t.setHeight(200);
        t.setText(tenmonhoc + "\n" + "***********" + "\n" + giobatdau + " - " + gioketthuc + "\n" + "***********" + "\n" + tenphonghoc);
        t.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        t.setTextColor(Color.parseColor("#040750"));
        t.setTextSize(10);
        t.setPadding(5, 5, 5, 5);
        r.addView(t);
    }

}