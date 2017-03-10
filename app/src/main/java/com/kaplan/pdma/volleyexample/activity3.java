package com.kaplan.pdma.volleyexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView12 = (TextView) findViewById(R.id.textView12);
        Button button8=(Button) findViewById(R.id.button8);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int rating = intent.getIntExtra("rating", 0);
        textView12.setText("Thank you for your rating");
        textView.setText(name + "," + rating + " star(s)");



        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
