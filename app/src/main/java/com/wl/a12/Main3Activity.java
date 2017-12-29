package com.wl.a12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void clickok(View v)
    {
        EditText ed4;
        ed4 = findViewById(R.id.editText4);
        Intent it=new Intent();
        it.putExtra("myresult",ed4.getText().toString()); //第一個引數為參照用(可改)，將第二個引數為內容
        setResult(RESULT_OK,it);
        /*setResult 回傳第一個引數resultCode(可能是RESULT_CANCELED or RESULT_OK) 到原來的activity 也就是給onActivityResult
                回傳的內容為第二個引數*/
        finish();//結束且關閉這個activity
    }

    public void clickcancel(View v)
    {
        finish();//結束且關閉這個activity
    }
}
