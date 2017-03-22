package com.app.androidintent;

/**
 * Created by Administrator on 2017/3/22.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class otherActivity extends AppCompatActivity {
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        Bundle bundle=this.getIntent().getExtras();
        int checkedId=bundle.getInt("checkedId");
        String sexText = "";
        if(checkedId==R.id.a){
            sexText="正确";
        }
        else{
            sexText="错误";
        }
        TextView tv1=(TextView)findViewById(R.id.text1);
        tv1.setText("你的答案:"+sexText);
        Button button_back=(Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherActivity.this.setResult(RESULT_OK,intent);
                otherActivity.this.finish();
            }
        });
    }
}

