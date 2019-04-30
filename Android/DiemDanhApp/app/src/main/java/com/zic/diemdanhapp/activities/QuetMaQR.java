package com.zic.diemdanhapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;
import com.zic.diemdanhapp.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class QuetMaQR extends AppCompatActivity  implements ZXingScannerView.ResultHandler{

    private ZXingScannerView zXingScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        zXingScannerView = new ZXingScannerView(this);
        setContentView(zXingScannerView);
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
        Toast.makeText(this,result.getText(), Toast.LENGTH_LONG).show();

        // Nếu từ màn hình giáo viên qua thì check mã sinh viên
        //Nếu từ màn hình sinh viên qua thì check mã phòng học
        // Nếu mã sai thì hiện thông báo lên màn hình kèm âm thanh cảm báo

        onBackPressed();
    }

    @Override
    protected void onResume(){
        super.onResume();
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }
}
