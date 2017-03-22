package com.app.androidintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioButton r1=null;
    RadioButton r2=null;
    RadioButton r3=null;
    RadioButton r4=null;
    RadioGroup radioGroup=null;
    RadioButton currenRadioButton=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        r1=(RadioButton)findViewById(R.id.a);
        r2=(RadioButton)findViewById(R.id.b);
        r3=(RadioButton)findViewById(R.id.c);
        r4=(RadioButton)findViewById(R.id.d);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==r1.getId()){
                    currenRadioButton=r1;
                }else if (checkedId==r2.getId()){
                    currenRadioButton=r2;
                }else if (checkedId==r3.getId()){
                    currenRadioButton=r3;
                }else if (checkedId==r4.getId()){
                    currenRadioButton=r4;
                }
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,otherActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("checkedId",checkedId);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });
        Button btn_sure=(Button)findViewById(R.id.sure);
        Button btn_cancel=(Button)findViewById(R.id.cancel);
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currenRadioButton.getText().equals("in"))
                    setTitle("答案;正确");
                else
                    setTitle("答案;错误");
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.clearCheck();
                setTitle("");
            }
        });

    }
    protected void onActivityRseult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==0&&resultCode==0){
            Bundle bunde=data.getExtras();
            String checkedId=bunde.getString("checkedId");
        }
    }
}



