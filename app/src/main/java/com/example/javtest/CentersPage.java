package com.example.javtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class CentersPage extends AppCompatActivity {

    //Assigning float variables for swipe navigation
    float x5, x6, y5, y6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centers_page);
    }

    //Creating a sub-class for implementing swipe navigation with animation
    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x5 = touchEvent.getX();
                y5 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x6 = touchEvent.getX();
                y6 = touchEvent.getY();
                if (x5 < x6) {
                    Intent k = new Intent(CentersPage.this, DoctorsPage.class);
                    startActivity(k);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                } else if (x5 > x6) {
                    Intent k = new Intent(CentersPage.this, DiagnosisPage.class);
                    startActivity(k);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                break;
        }
        return false;
    }
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
