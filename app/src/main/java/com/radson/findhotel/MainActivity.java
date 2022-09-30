package com.radson.findhotel;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent wegot = getIntent();
        final  String order_dishes[] = {};
        final SharedPreferences shadPreferences = getSharedPreferences("shp", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = shadPreferences.edit();
        final Button submit1 = (Button)findViewById(R.id.Submit);
        final  ListView lv = (ListView) findViewById(R.id.listtv);
        final  TextView title = (TextView)findViewById(R.id.textview);
        title.setText("Select Dishes");
        String brk[] = {"Idly", "Vada", "Dosa","Uthappam","Roast","Ghee Roast","Rava Roast", "Onion Roast", "Kesari","Puri","Chappathi","Onion Uthappam","Pongal", "Kichadi", "Uppuma","Rava Uppuma","Onion Rava Idly","Masal Dosa","Semiya", "Paneer Roast", "Mushroom Roast","Appam","Kuli Paniyaram","Cauliflower Roast","Rava Kichadi","Kichadi","Rava Uthappam",};
        if(wegot.getStringExtra("t").equals("brk"))
        {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.ameee, brk);
            editor.putString("time","Break Fast");
            editor.commit();
            lv.setAdapter(adapter);
        }
        String lnh[] ={"Sambar Rice","Lemon Rice","Meals","Rajasthani  Meals","Variety Rice","Curdd Rice","Veg Briyani","Veg pulao","Mushroom Briyani","Panneer Noodles","Mushroom Noodles","Baby Corn Noodles","Panneer Munchurian","Mushroom Munchurian","Gobi Muncchurian","Babay Corn Munchurian","Finger Panneer","Panneer 65","Gobi 65","Golden Corn fry"};
        if(wegot.getStringExtra("t").equals("lnh"))
        {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.ameee, lnh);
            editor.putString("time","Lunch");
            editor.commit();
            lv.setAdapter(adapter);
        }

        String dnr[] ={"Veg Soup","Tomato Soup","Baby Corn Soup","Mushrooom Soup","Sweet Corn Cream Soup","Butter Corn Soup","Naan","Butter Naan","Roti","Butter Roti","Romali Roti","Chappathi","Panneer Butter Masala","Mushroom Masala","Malai Koftha","Chenna Masala","Panneer Koftha","Butter Kulcha","Mushroom Kulcha","Babby Corn Masala","Cauli Flower Masala","Navarathna Masala","Dahi Panneer Masala","Panneer Munchurian","Mushroom Munchurian","Gobi Muncchurian","Babay Corn Munchurian","Finger Panneer","Panneer 65","Gobi 65","Golden Corn fry","Panneer Tikka","Panneer Kabab","Veg Noodles","Panneer Noodles","Mushroom Noodles","Baby Corn Noodles","Parotha","Chilli Parotha","Mushroom Parotha","Panner Parotha","Chapathi"};
        if(wegot.getStringExtra("t").equals("dnr"))
        {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.ameee, dnr);
            editor.putString("time","Dinner");
            editor.commit();
            lv.setAdapter(adapter);
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewc, int position, long id) {
                final TextView textview = (TextView) viewc;
               /* LayoutInflater li = LayoutInflater.from(getApplicationContext());
                View promtView = li.inflate(R.layout.ameee , null);
                AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
                alert.setView(promtView);
                alert.setCancelable(false);*/
                String msg =  textview.getText().toString();
                editor.putString("food",textview.getText().toString());
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                editor.putString("order", textview.getText().toString());
                editor.putInt("haha",shadPreferences.getInt("haha",0)+1);
                editor.putString("vinith",shadPreferences.getString("vinith","")+"\n"+shadPreferences.getInt("haha",0)+" "+textview.getText().toString());
                editor.commit();

            }

        });
        /*lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String web = shadPreferences.getString("hotel"," ");
                Intent intnet = new Intent(Intent.ACTION_VIEW, Uri.parse("https//:www.google.com"));
                startActivity(intnet);
                return false;
            }

        });*/
final Button billl = (Button)findViewById(R.id.Submit);

submit1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

       final Intent emailIntent = new Intent( android.content.Intent.ACTION_SEND);
        emailIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        emailIntent.setType("plain/text");

        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                new String[] { shadPreferences.getString("hotel","").toUpperCase()+"@HoTeL.MaIl.CoM" });
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                shadPreferences.getString("time"," "));
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                shadPreferences.getString("vinith",""));
emailIntent.setPackage("com.gmail");
        startActivity(Intent.createChooser(
                emailIntent, "Send mail..."));
    }
});
        }
}
