package com.wl.a12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void clickok2(View v)
    {
        EditText ed5;
        ed5 = findViewById(R.id.editText5);
        Intent it = new Intent();
        it.putExtra("myresult",ed5.getText().toString());
        setResult(RESULT_OK , it);
        finish();
    }



}
