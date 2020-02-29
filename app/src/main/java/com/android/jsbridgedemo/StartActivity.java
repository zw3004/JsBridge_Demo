package com.android.jsbridgedemo;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class StartActivity extends Activity implements OnClickListener {
    Button btnReturnToA;
    Button btnReturnToC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        setContentView(R.layout.activity_start);
        btnReturnToA=(Button) findViewById(R.id.btnReturnToA);
        btnReturnToC=(Button) findViewById(R.id.btnReturnToC);
        btnReturnToA.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(StartActivity.this,MainActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //intent.setAction("com.android.jsbridgedemo.MainActivity");
                startActivity(intent);
            }
        });
        btnReturnToC.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(StartActivity.this,Main2Activity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //intent.setAction("com.android.jsbridgedemo.MainActivity");


                startActivity(intent);
            }
        });

    }
    @Override
    public void onClick(View v) {}
}
