package com.zic.diemdanhapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

import com.zic.diemdanhapp.R;

public class ForgetPass extends AppCompatActivity {

    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        getSupportActionBar().hide();

        Intent nhanpass = getIntent();
        pass = nhanpass.getStringExtra("oldpass");

        //Lấy item vào spinner "cách lấy lại mật khẩu" từ app\res\values\strings.xml
        Spinner spinFor = findViewById(R.id.spinForget);
        ArrayAdapter<CharSequence> spinArrayFor = ArrayAdapter.createFromResource(this, R.array.spinForget, android.R.layout.simple_spinner_item);
        spinArrayFor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinFor.setAdapter(spinArrayFor);
        spinFor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //Sự kiện chạy khi có item được chọn trên spinner "cách lấy lại mật khẩu"
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = (String) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

                EditText editsdt = findViewById(R.id.editSDT);
                EditText editemail = findViewById(R.id.editEmail);
                TextView txtch = findViewById(R.id.txtCH);
                Spinner spinch = findViewById(R.id.spinCH);
                EditText editch = findViewById(R.id.editCTL);

                //Hiện\Ẩn EditText, Spinner hoặc TextView tuỳ theo lựa chọn trên
                if (text.equals("SĐT")) {
                    editsdt.setVisibility(view.VISIBLE);
                    editemail.setVisibility(view.INVISIBLE);
                    txtch.setVisibility(view.INVISIBLE);
                    spinch.setVisibility(view.INVISIBLE);
                    editch.setVisibility(view.INVISIBLE);
                } else if (text.equals("Email")) {
                    editsdt.setVisibility(view.INVISIBLE);
                    editemail.setVisibility(view.VISIBLE);
                    txtch.setVisibility(view.INVISIBLE);
                    spinch.setVisibility(view.INVISIBLE);
                    editch.setVisibility(view.INVISIBLE);
                } else {
                    editsdt.setVisibility(view.INVISIBLE);
                    editemail.setVisibility(view.INVISIBLE);
                    txtch.setVisibility(view.VISIBLE);
                    spinch.setVisibility(view.VISIBLE);
                    editch.setVisibility(view.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Lấy item vào spinner "câu hỏi bí mật" từ app\res\values\strings.xml
        Spinner spinCauHoi = findViewById(R.id.spinCH);
        ArrayAdapter<CharSequence> spinArrayCH = ArrayAdapter.createFromResource(this, R.array.spinCH, android.R.layout.simple_spinner_item);
        spinArrayCH.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCauHoi.setAdapter(spinArrayCH);
        spinCauHoi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override //Sự kiện chạy khi có item được chọn trên spinner "câu hỏi bí mật"
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinch1 = findViewById(R.id.spinCH);
                if (spinch1.getVisibility() == view.VISIBLE) {
                    String text = (String) parent.getItemAtPosition(position);
                    Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Sự kiện bấm nút Huỷ
        Button btnhuy = findViewById(R.id.btnHuy);
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutMain = new Intent(getApplicationContext(), MainActivity.class);
                chuyenlayoutMain.putExtra("newpass", pass);
                startActivity(chuyenlayoutMain);
            }
        });

        // Sự kiện bấm nút Tiếp tục
        Button btntieptuc = findViewById(R.id.btnTiep);
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editnewpass = findViewById(R.id.editNewPassForget);
                if (editnewpass.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Chưa nhập mật khẩu mới kìa ~", Toast.LENGTH_SHORT).show();
                } else {
                    Intent chuyenlayoutMain = new Intent(getApplicationContext(), MainActivity.class);
                    chuyenlayoutMain.putExtra("newpass", editnewpass.getText().toString());

                    startActivity((chuyenlayoutMain));
                }
            }
        });

    }


}
