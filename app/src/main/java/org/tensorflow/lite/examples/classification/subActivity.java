package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class subActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();

        TextView textViewName = (TextView) findViewById(R.id.textViewName) ;
        String name = intent.getStringExtra("name");
        textViewName.setText(name) ;

        try{
            // getResources().openRawResource()로 raw 폴더의 원본 파일을 가져온다.
            // txt 파일을 InpuStream에 넣는다. (open 한다)
            InputStream in = getResources().openRawResource(R.raw.mytext);

            if(in != null){

                InputStreamReader stream = new InputStreamReader(in, "utf-8");
                BufferedReader buffer = new BufferedReader(stream);

                String read;
                StringBuilder sb = new StringBuilder("");

                while((read=buffer.readLine())!=null){
                    sb.append(read);
                }

                in.close();

                // id : textView01 TextView를 불러와서
                //메모장에서 읽어온 문자열을 등록한다.
                TextView textView = (TextView)findViewById(R.id.textView01);
                textView.setText(sb.toString());
            }

        }catch(Exception e){
            e.printStackTrace();
        }


    }



}


