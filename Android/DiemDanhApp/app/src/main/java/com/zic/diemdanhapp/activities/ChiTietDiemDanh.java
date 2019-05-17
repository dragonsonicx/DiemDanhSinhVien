package com.zic.diemdanhapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.adapters.MethodChung;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChiTietDiemDanh extends AppCompatActivity {

    String manhanduoc, status, urlmonhoc, urlngayhoc, urldiemdanh, mamonhoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_diem_danh);
        getSupportActionBar().hide();

        // Nhận mã và status
        Intent nhanpass = getIntent();
        manhanduoc = nhanpass.getStringExtra("ma");
        status = nhanpass.getStringExtra("status").toString();

        // Ân mọi thứ trừ logo và spinner chọn môn học
        final Spinner spinnermonhoc = findViewById(R.id.spinMonHoc);
        spinnermonhoc.setVisibility(View.VISIBLE);
        final TableLayout table = findViewById(R.id.tableLichHoc);
        table.setVisibility(View.INVISIBLE);
        final Spinner spinnerngay = findViewById(R.id.spinNgay);
        spinnerngay.setVisibility(View.INVISIBLE);
        final Button btnin = findViewById(R.id.btnInDiemDanh);
        btnin.setVisibility(View.INVISIBLE);
        final Button btncommit = findViewById(R.id.btnCommit);
        btncommit.setVisibility(View.INVISIBLE);

        final Button btngomonhoc = findViewById(R.id.btnGoTenMonHoc);
        final Button btngongay = findViewById(R.id.btnGoNgay);

        btngongay.setVisibility(View.INVISIBLE);

        if (status.equals("1")) {
            urlmonhoc = "giaovien/getTenMonHoc/" + manhanduoc;
            new HttpAsyncTaskMonHoc().execute(MethodChung.CreateURL() + urlmonhoc);
        }

        spinnermonhoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                btngongay.setVisibility(View.INVISIBLE);
                spinnerngay.setVisibility(View.INVISIBLE);

                btnin.setVisibility(View.INVISIBLE);
                btncommit.setVisibility(View.INVISIBLE);
                table.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Sự kiện bấm button Tiếp của spinner môn học
        btngomonhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status.equals("1")) {
                    mamonhoc = spinnermonhoc.getSelectedItem().toString();
                    mamonhoc = ((String) mamonhoc).substring(0, ((String) mamonhoc).indexOf("."));

                    urlngayhoc = MethodChung.CreateURL() + "giaovien/getNgayHoc/" + manhanduoc + "/" + mamonhoc;
                    new HttpAsyncTaskNgay().execute(urlngayhoc);

                    btngongay.setVisibility(View.VISIBLE);
                    spinnerngay.setVisibility(View.VISIBLE);

                    btnin.setVisibility(View.INVISIBLE);
                    btncommit.setVisibility(View.INVISIBLE);
                    table.setVisibility(View.INVISIBLE);
                }
            }
        });

        // Sự kiện bấm button Tiếp của spinner ngày học
        btngongay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status.equals("1")) {

                    mamonhoc = spinnermonhoc.getSelectedItem().toString();
                    mamonhoc = ((String) mamonhoc).substring(0, ((String) mamonhoc).indexOf("."));

                    urldiemdanh = MethodChung.CreateURL() + "/giaovien/xemChiTietDiemDanh/"
                            + mamonhoc + "/" + spinnerngay.getSelectedItem().toString();
                    new HttpAsyncTaskDiemDanh().execute(urldiemdanh);

                    btnin.setVisibility(View.VISIBLE);
                    btncommit.setVisibility(View.VISIBLE);
                    table.setVisibility(View.VISIBLE);




                }
            }
        });
    }

    //Hàm xử lý JSON môn học
    private class HttpAsyncTaskMonHoc extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return MethodChung.GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            ArrayList<String> listtenmonhoc = new ArrayList<>();

            Spinner spinnermonhoc = findViewById(R.id.spinMonHoc);

            try {
                JSONArray array = new JSONArray(result);

                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    String tenmonhoc = obj.getString("tenMonHoc");
                    String mamonhoc1 = obj.getString("maMonHoc");
                    listtenmonhoc.add(mamonhoc1 + ". " + tenmonhoc);
                }

                //Thêm môn hoc vào spinner tên môn học
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listtenmonhoc);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnermonhoc.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    //Hàm xử lý JSON ngày
    private class HttpAsyncTaskNgay extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return MethodChung.GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            ArrayList<String> listngayhoc = new ArrayList<>();

            Spinner spinnerngayhoc = findViewById(R.id.spinNgay);

            try {
                JSONArray array = new JSONArray(result);
                for (int i = 0; i < array.length(); i++) {
                    String ngay = array.get(i).toString();

                    listngayhoc.add(ngay);
                }

                //Thêm môn hoc vào spinner tên môn học
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ChiTietDiemDanh.this, android.R.layout.simple_spinner_item, listngayhoc);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerngayhoc.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


    //Hàm xử lý JSON Table điểm danh
    private class HttpAsyncTaskDiemDanh extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return MethodChung.GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            TableLayout tbl = findViewById(R.id.tableLichHoc);

            cleanTable(tbl);

            Spinner spinnerngayhoc = findViewById(R.id.spinNgay);

            // Test Scroll, bỏ dòng for( int j=0..... để chạy bình thường
            for (int j = 0; j < 10; j++) {
                try {
                    JSONArray array = new JSONArray(result);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        String ten = obj.getString("tenSinhVien");
                        String ma = obj.getString("maSinhVien");

                        TableRow tr = new TableRow(getApplicationContext());
                        TextView txtTen = new TextView(getApplicationContext());
                        TextView txtMa = new TextView(getApplicationContext());
                        LinearLayout ln = new LinearLayout(getApplicationContext());
                        CheckBox cb = new CheckBox(getApplicationContext());

                        CreateRow(tr, txtTen, ten, txtMa, ma, ln, cb);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        //Hàm tạo Row điểm danh
        private void CreateRow(TableRow tr, TextView txtTen, String ten, TextView txtMa, String ma, LinearLayout ln, CheckBox cb) {

            TableLayout tbl = findViewById(R.id.tableLichHoc);

            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tr.setBackgroundColor(Color.parseColor("#ffffff"));
            tr.setOrientation(TableRow.VERTICAL);

            txtTen.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            txtTen.setBackground(getDrawable(R.drawable.row_xem_lich_white));
            txtTen.setPadding(10, 10, 10, 10);
            txtTen.setText(ten);
            txtTen.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
            txtTen.setTextColor(Color.parseColor("#040750"));
            txtTen.setTextSize(12);

            txtMa.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            txtMa.setBackground(getDrawable(R.drawable.row_xem_lich_white));
            txtMa.setPadding(10, 10, 10, 10);
            txtMa.setText(ma);
            txtMa.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
            txtMa.setTextColor(Color.parseColor("#040750"));
            txtMa.setTextSize(12);

            ln.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            ln.setBackground(getDrawable(R.drawable.row_xem_lich_white));
            ln.setGravity(Gravity.CENTER);

            cb.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            cb.setText(null);



            tr.addView(txtTen);
            tr.addView(txtMa);

            ln.addView(cb);

            tr.addView(ln);

            tbl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    //Clear Table Điểm danh
    private void cleanTable(TableLayout table) {

        int childCount = table.getChildCount();

        // Remove all rows except the first one
        if (childCount > 1) {
            table.removeViews(1, childCount - 1);
        }
    }


}