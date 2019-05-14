package com.zic.diemdanhapp.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.adapters.MethodChung;

import org.json.JSONException;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class QuetMaQR extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView zXingScannerView;

    String manhanduoc, status, pass, urlqr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        zXingScannerView = new ZXingScannerView(this);
        setContentView(zXingScannerView);
        getSupportActionBar().hide();

        // Nhận mã và status
        Intent nhanpass = getIntent();
        manhanduoc = nhanpass.getStringExtra("ma");
        status = nhanpass.getStringExtra("status").toString();
        pass = nhanpass.getStringExtra("pass").toString();

    }

    @Override
    public void onPause() {
        super.onPause();
        // Stop camera on pause
        zXingScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        //hiện kết quả quét được lên màn hình
        Toast.makeText(this, result.getText(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, manhanduoc, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();

        if (status.equals("1"))
            urlqr = MethodChung.CreateURL() + "giaovien/quetQRDiemDanh/" + result.toString() +
                    "/" + manhanduoc + "/" + pass;
        else if (status.equals("0"))
            urlqr = MethodChung.CreateURL() + "sinhvien/quetQRDiemDanh/" + result.toString() +
                    "/" + manhanduoc + "/" + pass;

        new HttpAsyncTask().execute(urlqr);
        // Nếu từ màn hình giáo viên qua thì check mã sinh viên
        //Nếu từ màn hình sinh viên qua thì check mã phòng học

        onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
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

        }
    }
}
