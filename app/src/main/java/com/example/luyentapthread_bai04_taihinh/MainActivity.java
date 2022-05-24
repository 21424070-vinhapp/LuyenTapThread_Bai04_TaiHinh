package com.example.luyentapthread_bai04_taihinh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.luyentapthread_bai04_taihinh.databinding.ActivityMainBinding;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();

        addEvent();
    }

    private void addEvent() {
        mainBinding.btnTai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCLickButton();
            }
        });
    }

    private void onCLickButton() {
        ImageTask imageTask=new ImageTask();
        imageTask.execute("https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2021/5/15/909514/Pham-Huong.jpg");
    }

    private void addControl() {
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Thong bao");
        progressDialog.setMessage("Dang tai hinh, vui long cho...");
    }


    class ImageTask extends AsyncTask<String,Void, Bitmap>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            progressDialog.dismiss();
            mainBinding.imgHinh.setImageBitmap(bitmap);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url=new URL(strings[0]);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                Bitmap bitmap= BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                return bitmap;
            }
            catch (Exception ex){
                Log.e("BBB", "doInBackground: "+ex.toString());
            };
            return null;

        }
    }
}