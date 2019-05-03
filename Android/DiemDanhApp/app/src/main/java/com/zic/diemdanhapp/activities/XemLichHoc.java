package com.zic.diemdanhapp.activities;

import android.app.ProgressDialog;

import android.content.Intent;

import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
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

public class XemLichHoc extends AppCompatActivity {

    String ma, status, urlxemlichhoc;

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

        //Kiểm tra coi có kết nối mạng hay không
        if (isConnected()) {
            Toast.makeText(this, "Is connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "nope", Toast.LENGTH_SHORT).show();
        }

        if (status.equals("0"))
            urlxemlichhoc = MethodChung.CreateURL() + "giaovien/xemLichDay/" + ma;
        else if (status.equals("1"))
            urlxemlichhoc = MethodChung.CreateURL() + "sinhvien/xemLichDay/" + ma;

        //Thực hiện code Json
        new HttpAsyncTask().execute(urlxemlichhoc);


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
        }, 2000);


    }

    //Hàm kiểm tra kết nối mạng
    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(XemLichHoc.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
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

            CreateTextView(result);

        }
    }


    // Tạo text view tương ứng
    private void CreateTextView(String result) {
        TableRow row2 = findViewById(R.id.row2);
        TableRow row3 = findViewById(R.id.row3);
        TableRow row4 = findViewById(R.id.row4);
        TableRow row5 = findViewById(R.id.row5);
        TableRow row6 = findViewById(R.id.row6);
        TableRow row7 = findViewById(R.id.row7);
        TableRow rowCN = findViewById(R.id.rowCN);


        try {
            JSONArray array = new JSONArray(result);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                String thu = obj.getString("thu");
                String tenmonhoc = obj.getString("tenMonHoc");
                String giobatdau = obj.getString("gioBatDau");
                String gioketthuc = obj.getString("gioKetThuc");
                String tenphonghoc = obj.getString("tenPhongHoc");

                switch (thu) {
                    case "2":
                        TextView txtView2 = new TextView(this);
                        CreateTextViewMonHoc(txtView2, row2, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                        break;

                    case "3":
                        TextView txtView3 = new TextView(this);
                        CreateTextViewMonHoc(txtView3, row3, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                        break;

                    case "4":
                        TextView txtView4 = new TextView(this);
                        CreateTextViewMonHoc(txtView4, row4, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                        break;

                    case "5":
                        TextView txtView5 = new TextView(this);
                        CreateTextViewMonHoc(txtView5, row5, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                        break;

                    case "6":
                        TextView txtView6 = new TextView(this);
                        CreateTextViewMonHoc(txtView6, row6, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                        break;

                    case "7":
                        TextView txtView7 = new TextView(this);
                        CreateTextViewMonHoc(txtView7, row7, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
                        break;

                    case "CN":
                        TextView txtViewCN = new TextView(this);
                        CreateTextViewMonHoc(txtViewCN, rowCN, tenmonhoc, giobatdau, gioketthuc, tenphonghoc);
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
        t.setWidth(500);
        t.setHeight(300);
        t.setText(tenmonhoc + "\n" + "***********" + "\n" + giobatdau + " - " + gioketthuc + "\n" + "***********" + "\n" + tenphonghoc);
        t.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        t.setTextColor(Color.parseColor("#040750"));
        t.setTextSize(18);
        t.setPadding(2, 2, 2, 2);
        r.addView(t);
    }

}
