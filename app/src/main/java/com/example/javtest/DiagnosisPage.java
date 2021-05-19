package com.example.javtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;

public class DiagnosisPage extends AppCompatActivity {
    float x7, x8, y7, y8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis_page);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setMovementMethod(new ScrollingMovementMethod());


    }

    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x7 = touchEvent.getX();
                y7 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x8 = touchEvent.getX();
                y8 = touchEvent.getY();
                if (x7 < x8) {
                    Intent l = new Intent(DiagnosisPage.this, CentersPage.class);
                    startActivity(l);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

                } else if (x7 > x8) {
                    Intent l = new Intent(DiagnosisPage.this, MainActivity.class);
                    startActivity(l);
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
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}


