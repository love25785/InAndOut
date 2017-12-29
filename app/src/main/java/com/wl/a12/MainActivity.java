package com.wl.a12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_PAGE_3 = 123;
    final int REQUEST_PAGE_4 = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click1(View v) {


        EditText ed1 = (EditText) findViewById(R.id.editText1);
        EditText ed2 = (EditText) findViewById(R.id.editText2);
        int q1 = Integer.valueOf(ed1.getText().toString());
        int q2 = Integer.valueOf(ed2.getText().toString());
        int ans = q1 + q2;
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText(String.valueOf(ans));
    }

    public void click2(View v) //到別的分頁 ,並傳資料過去
    {
        EditText ed3=findViewById(R.id.editText3);
        Intent it=new Intent(MainActivity.this,Main2Activity.class);
        //宣告一個intent物件 想要從自己這頁.this，到別的那頁.class
        it.putExtra("data",ed3.getText().toString()); // putExtra傳資料用 與getStringExtra搭配用
        startActivity(it); //啟動這個intent 物件,
    }

    public void click3(View v)
    {
        Intent it =new Intent(MainActivity.this,Main3Activity.class);
        startActivityForResult(it,REQUEST_PAGE_3);
        //startActivity傳 但不能接收，而startActivityForResult能傳 且能接收，與onActivityResult搭配用，如直接按BACK也會閃退
        //第二個引數是傳requestCode到所在class，之後會在回傳requestCode
    }

    public void click4(View v)
    {
        Intent it =new Intent(MainActivity.this,Main4Activity.class);
        startActivityForResult(it,REQUEST_PAGE_4);
    }

    @Override  //onActivityResult接收回傳，與startActivityForResult搭配用
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);//requestCode是決定誰傳來的  由startActivityForResult送出時決定，resultCode是內容
        TextView tv3 = (TextView) findViewById(R.id.textView3);
        TextView tv4 = (TextView) findViewById(R.id.textView4);

       if(requestCode==REQUEST_PAGE_3)//這個if是看誰傳來的
       {
           if (resultCode == RESULT_OK)
           /*這個IF，否則 當cancel時 或 back時， 因為clickok裡 有setResult 會回傳resultCode為:RESULT_OK 可執行下面方法
                    但cllickcancel沒setResult，傳回參照不是RESULT_OK而是RESULT_CANCELED回來，而該裡面沒myresult這個intent data可以用下面方法，會出錯*/
           {
               tv3.setText(data.getStringExtra("myresult"));//這個"myresult" 是 第三個引數 Intent data
           }
       }
       if(requestCode==REQUEST_PAGE_4)
       {
           if (resultCode == RESULT_OK)
           {
               tv4.setText(data.getStringExtra("myresult"));
           }
       }
    }


}