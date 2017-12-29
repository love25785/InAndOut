package com.wl.a12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tv2 = findViewById(R.id.textView2);
        Intent it = getIntent();//定義一個 取得intent的物件
        String str = it.getStringExtra("data");//getStringExtra 取string資料 與 putExtra搭配用
        tv2.setText(str);
    }

}
