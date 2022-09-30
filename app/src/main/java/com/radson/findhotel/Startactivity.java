package com.radson.findhotel;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Startactivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        final LinearLayout breakfast =(LinearLayout)findViewById(R.id.breakfastl);
        final LinearLayout lunch =(LinearLayout)findViewById(R.id.lunchl);
        final LinearLayout dinner =(LinearLayout)findViewById(R.id.Dinnerl);
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moven = new Intent(Startactivity.this,MainActivity.class);
                moven.putExtra("t","brk");
                startActivity(moven);
            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moven = new Intent(Startactivity.this,MainActivity.class);
                moven.putExtra("t","lnh");
                startActivity(moven);
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moven = new Intent(Startactivity.this,MainActivity.class);
                moven.putExtra("t","dnr");
                startActivity(moven);
            }
        });
    }
}
