package com.exam.testpro;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.exam.scanmodule.DataUtil;

public class MainActivity extends AppCompatActivity {

    private TextView mTvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvContent = findViewById(R.id.tv_content);
        mTvContent.setText(new DataUtil().getCurTimeLong() + "");
    }
}
