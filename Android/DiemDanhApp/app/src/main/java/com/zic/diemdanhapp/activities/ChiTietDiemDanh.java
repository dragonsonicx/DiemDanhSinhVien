package com.zic.diemdanhapp.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.adapters.MethodChung;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChiTietDiemDanh extends AppCompatActivity {

    String manhanduoc, status, urlmonhoc, urlngayhoc, mamonhoc;

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

        // Sự kiện bấm button Go của spinner môn học
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

        // Sự kiện bấm button Go của spinner ngày học
        btngongay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status.equals("1")) {

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

//    //Hàm xử lý onListener của spinner ngày
//    private class MyProcessEventNgay implements AdapterView.OnItemSelectedListener {
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            Object item = parent.getItemAtPosition(position).toString();
//            //Nếu spinner trống
//            if (((String) item).isEmpty()) {
//                Toast.makeText(ChiTietDiemDanh.this, "Lỗi ~", Toast.LENGTH_SHORT).show();
//                TableLayout table = findViewById(R.id.tableLichHoc);
//                table.setVisibility(View.INVISIBLE);
//                Spinner spinnerngay = findViewById(R.id.spinNgay);
//                spinnerngay.setVisibility(View.VISIBLE);
//                Button btnin = findViewById(R.id.btnInDiemDanh);
//                btnin.setVisibility(View.INVISIBLE);
//                Button btncommit = findViewById(R.id.btnCommit);
//                btncommit.setVisibility(View.INVISIBLE);
//            } else {
//                Spinner spinnerngay = findViewById(R.id.spinNgay);
//                spinnerngay.setVisibility(View.VISIBLE);
//                ((String) item).substring(((String) item).indexOf("{") + 1);
//                ((String) item).substring(0, ((String) item).indexOf("}"));
//                mamonhoc = item.toString();
//                Toast.makeText(ChiTietDiemDanh.this, mamonhoc, Toast.LENGTH_SHORT).show();
//                new HttpAsyncTaskNgay().execute(MethodChung.CreateURL() + manhanduoc + "/" + mamonhoc);
//            }
//
//        }
//
//        //Nếu không chọn gì cả
//        public void onNothingSelected(AdapterView<?> arg0) {
//
//        }
//    }


    //    //Hàm xử lý onListener của spinner môn học
//    private class MyProcessEventMonHoc implements AdapterView.OnItemSelectedListener {
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            Object item = parent.getItemAtPosition(position).toString();
//            //Nếu spinner trống
//            if (((String) item).isEmpty()) {
//                Toast.makeText(ChiTietDiemDanh.this, "Lỗi ~", Toast.LENGTH_SHORT).show();
//                TableLayout table = findViewById(R.id.tableLichHoc);
//                table.setVisibility(View.INVISIBLE);
//                Spinner spinnerngay = findViewById(R.id.spinNgay);
//                spinnerngay.setVisibility(View.INVISIBLE);
//                Button btnin = findViewById(R.id.btnInDiemDanh);
//                btnin.setVisibility(View.INVISIBLE);
//                Button btncommit = findViewById(R.id.btnCommit);
//                btncommit.setVisibility(View.INVISIBLE);
//            } else {
//                Spinner spinnerngay = findViewById(R.id.spinNgay);
//                spinnerngay.setVisibility(View.VISIBLE);
//            }
//
//        }
//
//        //Nếu không chọn gì cả
//        public void onNothingSelected(AdapterView<?> arg0) {
//
//        }
//    }

}
