package com.zic.diemdanhapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zic.diemdanhapp.R;

public class XemLichHoc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_lich_hoc);
        getSupportActionBar().hide();
    }
}