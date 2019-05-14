package com.zic.diemdanhapp.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.adapters.MethodChung;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChiTietDiemDanh extends AppCompatActivity {

    String manhanduoc, status, urlmonhoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_diem_danh);
        getSupportActionBar().hide();

        // Nhận mã và status
        Intent nhanpass = getIntent();
        manhanduoc = nhanpass.getStringExtra("ma");
        status = nhanpass.getStringExtra("status").toString();

        urlmonhoc ="";

        new HttpAsyncTaskMonHoc().execute(MethodChung.CreateURL() + urlmonhoc);


    }

    //Hàm xử lý JSON
    private class HttpAsyncTaskMonHoc extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return MethodChung.GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            ArrayList<String> list = new ArrayList<>();

            Spinner spinnermonhoc = findViewById(R.id.spinMonHoc);

            try {
                JSONArray array = new JSONArray(result);

                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    String monhoc = obj.getString("monHoc");
                    list.add(monhoc.toString());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnermonhoc.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
