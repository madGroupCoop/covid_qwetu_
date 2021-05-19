package com.example.javtest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning variables to the Buttons
        Button doctorsPage1 = (Button) findViewById(R.id.doctors1);
        Button hospitals1 = (Button) findViewById(R.id.hospitals1);
        Button centers1 = (Button) findViewById(R.id.centers1);
        Button diagnosis1 = (Button) findViewById(R.id.diagnosis1);
        Button callNow1 = (Button) findViewById(R.id.callNow1);
        Button sendSMS1 = (Button) findViewById(R.id.sendSMS1);

        //Setting the buttons clickable to switch activities
        doctorsPage1.setOnClickListener(v -> {
            Intent int1 = new Intent(MainActivity.this,DoctorsPage.class);
            startActivity(int1);
        });

        hospitals1.setOnClickListener(v -> {
            Intent int2 = new Intent(MainActivity.this,HospitalsPage.class);
            startActivity(int2);
        });

        centers1.setOnClickListener(v -> {
            Intent int3 = new Intent(MainActivity.this,CentersPage.class);
            startActivity(int3);
        });

        diagnosis1.setOnClickListener(v -> {
            Intent int4 = new Intent(MainActivity.this,DiagnosisPage.class);
            startActivity(int4);
        });

        callNow1.setOnClickListener(v -> {
            Intent int5 = new Intent(Intent.ACTION_DIAL);
            int5.setData(Uri.parse("tel:+254796408082"));
            startActivity(int5);
        });

        sendSMS1.setOnClickListener(v -> {
            Uri uri = Uri.parse("smsto:+254796408082");
            Intent int6 = new Intent(Intent.ACTION_SENDTO,uri);
            int6.putExtra("sms_body","Help! Feeling unwell with covid 19 symptoms");
            startActivity(int6);
        });

    }

    //Overriding the back-button to end application at home-page
    @Override
    public void onBackPressed() {
       Intent close = new Intent(Intent.ACTION_MAIN);
       close.addCategory(Intent.CATEGORY_HOME);
       close.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       startActivity(close);
    }
}
