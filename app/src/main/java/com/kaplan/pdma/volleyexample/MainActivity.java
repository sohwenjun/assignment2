package com.kaplan.pdma.volleyexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://api.fixer.io/latest?base=SGD";
        final Button button = (Button) findViewById(R.id.button);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final TextView textView5 = (TextView) findViewById(R.id.textView5);
        final TextView textView6 = (TextView) findViewById(R.id.textView6);
        final TextView textView4 = (TextView) findViewById(R.id.textView4);
        final TextView textView3 = (TextView) findViewById(R.id.textView3);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        final JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {


                        try {
                            JSONObject rates = response.getJSONObject("rates");

                            double sin = Double.parseDouble(editText.getText().toString());
                            double aud = rates.getDouble("AUD");
                            double myr = rates.getDouble("MYR");
                            double jpy = rates.getDouble("JPY");
                            double cny = rates.getDouble("CNY");

                            double usd = rates.getDouble("USD");
                            StringBuilder sp = new StringBuilder();
                            StringBuilder sb = new StringBuilder();
                            StringBuilder so = new StringBuilder();
                            StringBuilder sq = new StringBuilder();
                            sb.append("\n"+"Austarlia Dollar      :" + sin*aud +"\n");
                            sb.append("Chinese Yuan RMB :" + sin*cny +"\n");
                            sb.append("Japanese Yen        :" + sin*jpy +"\n");
                            sb.append("Malaysia Ringgit    :" + sin*myr +"\n");
                            sb.append("US Dollar             :" + sin*usd +"\n");

                            textView.setText(sb.toString());
                            textView2.setText(sp.toString());
                            textView3.setText(so.toString());
                            textView4.setText(sq.toString());

                        } catch (JSONException e) {
                            textView.setText(e.getMessage());
                            textView2.setText(e.getMessage());
                            textView3.setText(e.getMessage());
                            textView4.setText(e.getMessage());
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

// Access the RequestQueue through your singleton class.
        //MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, setting.class);
                startActivity(intent);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);
            }
        });
        //read data from phone storage
        String sin = sp.getString("sin", null);
         String aud = sp.getString("aud", null);
        String myr = sp.getString("myr", null);
         String rmb = sp.getString("cny", null);
        String usd = sp.getString("usd", null);
        final SharedPreferences sharedPreferences = getPreferences(MODE_APPEND);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Date dt=new Date();





        CharSequence s  = DateFormat.format("MMMM d, yyyy ", dt.getTime());



        int dates=dt.getDate();
        int hours = dt.getHours();
        int minutes = dt.getMinutes();
        int seconds = dt.getSeconds();
        long millis = sharedPreferences.getLong("THE_DATE", 0L);
        Date theDate = new Date(millis);
        String curTime = theDate +"";
        if(sin != null ) {

            textView5.setText(curTime);
            textView6.setText( "Singapore Dollar    :"+sin+""+aud+""+myr+""+rmb+""+usd);
        } else {
            textView6.setText("not yet input currencies");
        }
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sin = editText.getText().toString();
                String aud = textView.getText().toString();
                String myr = textView2.getText().toString();
                String rmb = textView3.getText().toString();
                String usd = textView4.getText().toString();
                if (sin.length() > 0) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("sin", sin);
                    editor.putString("aud", aud);
                    editor.putString("myr", myr);
                    editor.putString("cny", rmb);
                    editor.putString("usd", usd);

                    editor.putLong("THE_DATE", dt.getTime());
                    editor.commit();


                    Date dt = new Date();
                    CharSequence s = DateFormat.format("MMMM d, yyyy ", dt.getTime());

                    int dates = dt.getDate();
                    int hours = dt.getHours();
                    int minutes = dt.getMinutes();
                    int seconds = dt.getSeconds();

                    long millis = sharedPreferences.getLong("THE_DATE", 0L);
                    Date theDate = new Date(millis);
                    if (sin != "") {
                        Toast.makeText(MainActivity.this, "saved",
                                Toast.LENGTH_SHORT).show();
                        String curTime = theDate + "";
                        textView5.setText(curTime);
                        textView6.setText( "Singapore Dollar: "+sin+aud+myr+rmb+usd);

                    } else {
                        Toast.makeText(MainActivity.this, "please input currency",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }});
    }
}
