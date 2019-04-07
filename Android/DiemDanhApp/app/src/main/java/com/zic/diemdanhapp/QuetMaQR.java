package com.zic.diemdanhapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class QuetMaQR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quet_ma_qr);
        getSupportActionBar().hide();

//        // mở activity quét qrcode của thư viện
//        private void openScannerActivity() {
//            IntentIntegrator integrator = new IntentIntegrator(this);
//            integrator.setPrompt("Quét mã QR");// hướng dẫn
//            integrator.setOrientationLocked(false);
//            integrator.setTimeout(30000);//giới hạn thời gian quét
//            integrator.initiateScan();
//        }
//
//// xử lý kết quả trả về
//        @Override
//        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//            if (result != null) {
//                if (result.getContents() == null) {
//// không quét đc mã QR hoặc không được cấp phép truy cập CAMERA
//                }
//                else {
//                    String content=result.getContents();// nội dung mã QR
//                    String format=result.getFormatName();//định dạng của mã QR
//                }
//            } else {
//                super.onActivityResult(requestCode, resultCode, data);
//            }
//        }
    }
}
