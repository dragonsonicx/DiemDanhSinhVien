package com.zic.diemdanhapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zic.diemdanhapp.R;
import com.zic.diemdanhapp.adapters.MethodChung;

import org.json.JSONException;
import org.json.JSONObject;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChinhSuaSV extends AppCompatActivity {

    EditText etResponse;
    TextView tvIsConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinh_sua_sv);
        getSupportActionBar().hide();

        // get reference to the views
        etResponse = (EditText) findViewById(R.id.etResponse);
        tvIsConnected = (TextView) findViewById(R.id.tvIsConnected);

        // check if you are connected or not
        if (isConnected()) {
            tvIsConnected.setBackgroundColor(0xFF00CC00);
            Toast.makeText(this, "Is connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "nope", Toast.LENGTH_SHORT).show();
        }

        // call AsynTask to perform network operation on separate thread
        new HttpAsyncTask().execute(MethodChung.CreateURL() + "nguoidung/findById/15022571");

    }

    //Hàm kiểm tra kết nối
    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(MainActivity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
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
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            try {
                JSONObject jsonObj = new JSONObject(result); // convert String to JSONObject
                if (jsonObj.has("tenNguoiDung"))
                    etResponse.setText(jsonObj.getString("tenNguoiDung"));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
