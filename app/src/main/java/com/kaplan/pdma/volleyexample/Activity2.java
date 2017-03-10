package com.kaplan.pdma.volleyexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Button button3=(Button) findViewById(R.id.button3);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText2.getText().toString();
                int rating = (int) ratingBar.getRating();
                Intent intent = new Intent(Activity2.this, activity3.class);
                intent.putExtra("name", name);
                intent.putExtra("rating", rating);
                startActivity(intent);
            }
        });
    }
}
