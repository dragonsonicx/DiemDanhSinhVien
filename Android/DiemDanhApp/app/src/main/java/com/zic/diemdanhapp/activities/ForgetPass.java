package com.zic.diemdanhapp.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.adapters.GMailSender;
import com.zic.diemdanhapp.adapters.MethodChung;

import org.json.JSONException;
import org.json.JSONObject;

public class ForgetPass extends AppCompatActivity {

    String ma, url, sdt, email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        getSupportActionBar().hide();

        final EditText editma = findViewById(R.id.editMa);
        final Spinner spin = findViewById(R.id.spinForget);
        final EditText editsdt = findViewById(R.id.editSDT);
        final EditText editemail = findViewById(R.id.editEmail);
        final TextView passforget = findViewById(R.id.editPassForget);
        final TextView labelmk = findViewById(R.id.LabelMK);

        editsdt.setVisibility(View.INVISIBLE);
        editemail.setVisibility(View.INVISIBLE);
        passforget.setVisibility(View.INVISIBLE);
        labelmk.setVisibility(View.INVISIBLE);

        // Sự kiện bấm nút Huỷ
        Button btnhuy = findViewById(R.id.btnHuy);
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(chuyenlayoutMain);
            }
        });

        // Sự kiện bấm nút Tiếp tục
        Button btntieptuc = findViewById(R.id.btnTiep);
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spin.getSelectedItem().toString().isEmpty())
                    Toast.makeText(ForgetPass.this, "Xin mời chọn cách thức lấy lại mật khẩu", Toast.LENGTH_SHORT).show();
                else if (editma.getText().toString().isEmpty())
                    Toast.makeText(ForgetPass.this, "Thiếu thông tin", Toast.LENGTH_SHORT).show();

                url = MethodChung.CreateURL() + "nguoidung/findById/" + editma.getText().toString();
                new HttpAsyncTask().execute(url);
            }
        });


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

                //Hiện\Ẩn EditText, Spinner hoặc TextView tuỳ theo lựa chọn trên
                if (text.equals("SĐT")) {
                    editsdt.setVisibility(View.VISIBLE);
                    editemail.setVisibility(View.INVISIBLE);
                    passforget.setVisibility(View.INVISIBLE);
                    labelmk.setVisibility(View.INVISIBLE);
                } else if (text.equals("Email")) {
                    editsdt.setVisibility(View.INVISIBLE);
                    editemail.setVisibility(View.VISIBLE);
                    passforget.setVisibility(View.INVISIBLE);
                    labelmk.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                editsdt.setVisibility(View.INVISIBLE);
                editemail.setVisibility(View.INVISIBLE);
                passforget.setVisibility(View.INVISIBLE);
                labelmk.setVisibility(View.INVISIBLE);
            }
        });
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return MethodChung.GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            final EditText editsdt = findViewById(R.id.editSDT);
            final EditText editemail = findViewById(R.id.editEmail);
            final TextView passforget = findViewById(R.id.editPassForget);
            final TextView labelmk = findViewById(R.id.LabelMK);

            try {
                JSONObject jsonObj = new JSONObject(result); // convert String to JSONObject
                email = jsonObj.getString("email");
                sdt = jsonObj.getString("sodienthoai");
                pass = jsonObj.getString("matKhau");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (editemail.getVisibility() == View.VISIBLE) {
                if (editemail.getText().toString().equals(email)) {
                    passforget.setText(pass);
                    passforget.setVisibility(View.VISIBLE);
                    labelmk.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(ForgetPass.this, "Sai thông tin", Toast.LENGTH_SHORT).show();
                }
            } else if (editsdt.getVisibility() == View.VISIBLE) {
                if (editsdt.getText().toString().equals(sdt)) {
                    passforget.setText(pass);
                    passforget.setVisibility(View.VISIBLE);
                    labelmk.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(ForgetPass.this, "Sai thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        }


    }

}
