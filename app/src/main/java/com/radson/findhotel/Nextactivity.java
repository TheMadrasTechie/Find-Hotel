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


public class Nextactivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences shadPreferences = getSharedPreferences("shp", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = shadPreferences.edit();
        final Button submit1 = (Button)findViewById(R.id.Submit);
        submit1.setVisibility(Button.GONE);
        ListView lv = (ListView) findViewById(R.id.listtv);
        final TextView Title = (TextView)findViewById(R.id.textview);
        Title.setText("Select Hotel");
        String dist_name[] = {"Saravana Bhavan","Chettinad Restaurant","Adayar Anandha Bhavan","The Grand Chola","Hotel MahaRaja","Annapoorna","The Grand Buddapest","Aryaas","Gowri Krishna","Anjappar","Kongu parota stall","Hotel Ginger","Amudhappar","Nalas Aappa Kadai","Sasi Briyani","Vasantha Bhavan","Swaad Mantra","Hotel Angel","Ramanas","Gowri Sankar","Hotel Kuppana","Poppys","Dindugal Thalappakathi Briyani","Mangala Vilas" ,"Velan Hotel","Amudhappar","GopiNivas","Punjabi Dhaabi","Uduppi","SeaShore","Sigree","Krishna Vilas","Green Spices","Tea Country","Nature's own Hotel","Emel Dwilings"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.ameee, dist_name);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewc, int position, long id) {

                TextView textview = (TextView)viewc;
                editor.putString("hotel",textview.getText().toString());
                editor.commit();
                Intent abcd =new Intent(Nextactivity.this,Startactivity.class);
                startActivity(abcd);
            }
        });

    }
}