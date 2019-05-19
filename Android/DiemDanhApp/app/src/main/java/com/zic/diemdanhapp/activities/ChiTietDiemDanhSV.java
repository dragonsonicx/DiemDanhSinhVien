package com.zic.diemdanhapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
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

public class ChiTietDiemDanhSV extends AppCompatActivity {

    String manhanduoc, status, urlmonhoc, urldiemdanh, mamonhoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_diem_danh_sv);
        getSupportActionBar().hide();

        // Nhận mã và status
        Intent nhanpass = getIntent();
        manhanduoc = nhanpass.getStringExtra("ma");
        status = nhanpass.getStringExtra("status").toString();

        final Spinner spinnermonhoc = findViewById(R.id.spinMonHoc);
        final Button btnin = findViewById(R.id.btnIn);
        final Button btntongngayhoc = findViewById(R.id.btnTongNgayHoc);
        final TableLayout table = findViewById(R.id.tableLichHoc);

        btnin.setVisibility(View.INVISIBLE);
        btntongngayhoc.setVisibility(View.INVISIBLE);
        table.setVisibility(View.INVISIBLE);

        final Button btntiep = findViewById(R.id.btnTiep);

        urlmonhoc = MethodChung.CreateURL() + "/sinhvien/getTenMonHoc/" + manhanduoc;
        new HttpAsyncTaskMonHoc().execute(urlmonhoc);

        //Hoạt động khi chọn item trên Spinner Môn học
        spinnermonhoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                btnin.setVisibility(View.INVISIBLE);
                btntongngayhoc.setVisibility(View.INVISIBLE);
                table.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Sự kiện bấm button Tiếp của spinner môn học
        btntiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status.equals("0")) {

                    mamonhoc = spinnermonhoc.getSelectedItem().toString();
                    mamonhoc = ((String) mamonhoc).substring(0, ((String) mamonhoc).indexOf("."));

                    urldiemdanh = MethodChung.CreateURL() + "/sinhvien/xemChiTietDiemDanh/"
                            + manhanduoc + "/" + mamonhoc;
                    new HttpAsyncTaskDiemDanh().execute(urldiemdanh);

                    btnin.setVisibility(View.VISIBLE);
                    btntongngayhoc.setVisibility(View.VISIBLE);
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


    //Hàm xử lý JSON Table điểm danh SV
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

            // Test Scroll, bỏ for( int j=0..... để chạy bình thường
            for (int j = 0; j < 20; j++) {
                try {
                    JSONArray array = new JSONArray(result);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);

                        int stt = tbl.getChildCount();
                        String ngay = obj.getString("ngayDiemDanh");
                        String stat = obj.getString("status");

                        TableRow tr = new TableRow(getApplicationContext());
                        TextView txtSTT = new TextView(getApplicationContext());
                        TextView txtNgay = new TextView(getApplicationContext());
                        TextView txtStat = new TextView(getApplicationContext());


                        CreateRow(tr, txtSTT, stt, txtNgay, ngay, txtStat, stat);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }


        //Hàm tạo Row điểm danh
        private void CreateRow(TableRow tr, TextView txtSTT, int stt, TextView txtNgay, String ngay, TextView txtStat, String stat) {

            TableLayout tbl = findViewById(R.id.tableLichHoc);
            String s = Integer.toString(stt);

            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tr.setBackgroundColor(Color.parseColor("#ffffff"));
            tr.setOrientation(TableRow.VERTICAL);

            txtSTT.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            txtSTT.setBackground(getDrawable(R.drawable.row_xem_lich_white));
            txtSTT.setPadding(10, 10, 10, 10);
            txtSTT.setText(s);
            txtSTT.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
            txtSTT.setTextColor(Color.parseColor("#040750"));
            txtSTT.setTextSize(12);

            txtNgay.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            txtNgay.setBackground(getDrawable(R.drawable.row_xem_lich_white));
            txtNgay.setPadding(10, 10, 10, 10);
            txtNgay.setText(ngay);
            txtNgay.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
            txtNgay.setTextColor(Color.parseColor("#040750"));
            txtNgay.setTextSize(12);

            txtStat.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            txtStat.setBackground(getDrawable(R.drawable.row_xem_lich_white));
            txtStat.setPadding(10, 10, 10, 10);
            txtStat.setText(stat);
            txtStat.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
            txtStat.setTextColor(Color.parseColor("#040750"));
            txtStat.setTextSize(12);

            tr.addView(txtSTT);
            tr.addView(txtNgay);
            tr.addView(txtStat);

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