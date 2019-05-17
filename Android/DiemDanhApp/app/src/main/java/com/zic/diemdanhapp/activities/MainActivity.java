package com.zic.diemdanhapp.activities;

import android.app.ProgressDialog;
import android.os.Handler;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.adapters.MethodChung;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String ma, pass, status;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        final TextView txtname = findViewById(R.id.txtName);
        final EditText txtpass = findViewById(R.id.txtPass);

        // Sự kiện bấm nút Login
        Button btnlogin = findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra đã nhập chưa
                if (txtname.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập mã SV/GV ~", Toast.LENGTH_SHORT).show();
                else if (txtpass.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập mật khẩu ~", Toast.LENGTH_SHORT).show();
                else {
                    String urldangnhap = "nguoidung/" + "dangNhap/" + txtname.getText().toString() + "/" + txtpass.getText().toString();

                    // Thực hiện code Json
                    new HttpAsyncTask().execute(MethodChung.CreateURL() + urldangnhap);

                    // Hiện progress bar
                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setMessage("Loading..."); // Setting Message
                    progressDialog.setTitle("Đang kiểm tra ~"); // Setting Title
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                    progressDialog.show(); // Display Progress Dialog
                    progressDialog.setCancelable(false);
                    new Thread(new Runnable() {
                        public void run() {
                        }
                    }).start();

                    //Delay 1s
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Tắt progress bar
                            progressDialog.dismiss();

                        }
                    }, 1000);
                }
            }
        });

        // Sự kiện bấm nút Quên mật khẩu
        TextView btnFor = findViewById(R.id.btnForget);
        btnFor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chuyenlayoutForget = new Intent(getApplicationContext(), ForgetPass.class);
                startActivity(chuyenlayoutForget);
            }
        });
    }


//    //Hàm kiểm tra kết nối mạng
//    public boolean isConnected() {
//        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(MainActivity.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//        if (networkInfo != null && networkInfo.isConnected())
//            return true;
//        else
//            return false;
//    }


    //Hàm xử lý JSON
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return MethodChung.GET(urls[0]);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            EditText txtpass = findViewById(R.id.txtPass);

            try {
                JSONObject jsonObj = new JSONObject(result); // convert String to JSONObject
                ma = jsonObj.getString("maNguoiDung");
                pass = jsonObj.getString("matKhau");
                status = jsonObj.getString("status");

                // Chuyển layout tương ứng nếu pass đúng
                if (txtpass.getText().toString().equals(pass)) {
                    if (status.equals("1")) {
                        Intent chuyenlayoutGV = new Intent(getApplicationContext(), ThongTinGiaoVien.class);
                        chuyenlayoutGV.putExtra("ma", ma);
                        startActivity((chuyenlayoutGV));
                    } else if (status.equals("0")) {
                        Intent chuyenlayoutSV = new Intent(getApplicationContext(), ThongTinSinhVien.class);
                        chuyenlayoutSV.putExtra("ma", ma);
                        startActivity((chuyenlayoutSV));
                    }
                } else
                    Toast.makeText(MainActivity.this, "Sai mật khẩu ~", Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}