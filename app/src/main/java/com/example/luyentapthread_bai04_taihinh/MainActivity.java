package com.example.luyentapthread_bai04_taihinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.luyentapthread_bai04_taihinh.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();

    }

    private void addControl() {
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
    }
}