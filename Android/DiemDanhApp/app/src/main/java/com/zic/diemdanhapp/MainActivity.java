package com.zic.diemdanhapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String pass = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        final Intent nhanpass = getIntent();
        final String newpass = nhanpass.getStringExtra("newpass");

        // Sự kiện bấm nút Login
        Button btnlogin = findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtpass = findViewById(R.id.txtPass);
                if (nhanpass.hasExtra("newpass"))
                    pass = newpass;

                Toast toasts = Toast.makeText(getApplicationContext(), newpass, Toast.LENGTH_SHORT);
                toasts.show();


                if (txtpass.getText().toString().equals(pass)) {
                    Intent chuyenlayoutSV = new Intent(getApplicationContext(), ThongTinGiaoVien.class);
                    chuyenlayoutSV.putExtra("oldpass", pass);
                    startActivity((chuyenlayoutSV));
                } else
                    Toast.makeText(getApplicationContext(), "Sai mật khẩu ~", Toast.LENGTH_SHORT).show();
            }
        });

        // Sự kiện bấm nút Quên mật khẩu
        Button btnFor = findViewById(R.id.btnForget);
        btnFor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutForget = new Intent(getApplicationContext(), ForgetPass.class);
                chuyenlayoutForget.putExtra("oldpass", pass);
                startActivity(chuyenlayoutForget);
            }
        });

        // Sự kiện bấm nút Đổi mật khẩu
        Button btnchange = findViewById(R.id.btnChangePass);
        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutChange = new Intent(getApplicationContext(), ChangePass.class);
                chuyenlayoutChange.putExtra("oldpass", pass);
                startActivity(chuyenlayoutChange);
            }
        });


    }
}
