package com.kaplan.pdma.volleyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.pwittchen.swipe.library.Swipe;
import com.github.pwittchen.swipe.library.SwipeListener;

public class swipe extends AppCompatActivity {
    private Swipe swipe;
    @Override


    public boolean dispatchTouchEvent(MotionEvent event) {
        swipe.dispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        final ImageView flag = (ImageView) findViewById(R.id.imageView5);
        final ImageView dollar = (ImageView) findViewById(R.id.imageView6);
        final TextView name=(TextView)findViewById(R.id.textView6);
        swipe = new Swipe();

        swipe.addListener(new SwipeListener() {
            @Override
            public void onSwipingLeft(MotionEvent event) {

            }

            @Override
            public void onSwipedLeft(MotionEvent event) {
                flag.setImageResource(R.drawable.malaysia2);
                dollar.setImageResource(R.drawable.myr);
                name.setText("Malaysia");
            }

            @Override
            public void onSwipedRight(MotionEvent event) {
                flag.setImageResource(R.drawable.england);
                dollar.setImageResource(R.drawable.pound);
                name.setText("England");
            }

            @Override
            public void onSwipedUp(MotionEvent event) {
                flag.setImageResource(R.drawable.china);
                dollar.setImageResource(R.drawable.rmb);
                name.setText("China");
            }

            @Override
            public void onSwipedDown(MotionEvent event) {
                flag.setImageResource(R.drawable.usa);
                dollar.setImageResource(R.drawable.usd);
                name.setText("USA");
            }


            @Override
            public void onSwipingRight(MotionEvent event) {

            }



            @Override
            public void onSwipingUp(MotionEvent event) {

            }



            @Override
            public void onSwipingDown(MotionEvent event) {

            }


        });

    }
}
