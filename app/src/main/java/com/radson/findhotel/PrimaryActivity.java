package com.radson.findhotel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PrimaryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences shadPreferences = getSharedPreferences("shp", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = shadPreferences.edit();
        editor.putString("vinith"," " );
        editor.putInt("haha",1);
        editor.commit();
        final Button submit1 = (Button)findViewById(R.id.Submit);
        submit1.setVisibility(Button.GONE);
        ListView lv = (ListView) findViewById(R.id.listtv);
        final TextView Title = (TextView)findViewById(R.id.textview);
        String dist_name[] = {"Ariyalur","Chennai","Coimbatore","Cuddalore","Dharmapuri","Dindigul","Erode","Kanchipuram","Kanyakumari","Karur","Krishnagiri","Madurai","Nagapattinam","Namakkal","The Nilgiris","Perambalur","Pudukkottai","Ramanathapuram","Salem","Sivaganga","Thanjavur","Theni","Thoothukudi","Trichy","Tirunelveli","Tiruppur","Tiruvallur","Tiruvannamalai","Tiruvarur","Vellore","Viluppuram","Virudhunagar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.ameee, dist_name);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewc, int position, long id) {
                TextView textview = (TextView) viewc;
                Intent abcd =new Intent(PrimaryActivity.this,Nextactivity.class);
                startActivity(abcd);
            }
        });
            }
}

