package com.example.javtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class DoctorsPage extends AppCompatActivity {
    //Assigning float variables for swipe navigation
    float x3, x4, y3, y4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_page);
    }

    //Creating a sub-class for implementing swipe navigation
    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x3 = touchEvent.getX();
                y3 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x4 = touchEvent.getX();
                y4 = touchEvent.getY();
                if (x3 < x4) {
                    Intent j = new Intent(DoctorsPage.this, HospitalsPage.class);
                    startActivity(j);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                } else if (x3 > x4) {
                    Intent j = new Intent(DoctorsPage.this, CentersPage.class);
                    startActivity(j);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                break;
        }
        return false;
    }

    //overriding the finish activity with a slide left animation
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }
    //overriding the back button to switch back to the home-page
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}