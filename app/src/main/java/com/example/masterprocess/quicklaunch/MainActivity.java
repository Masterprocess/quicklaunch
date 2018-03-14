package com.example.masterprocess.quicklaunch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button secondActivityBtn = (Button)findViewById(R.id.secondActivityBtn);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivity = new Intent(getApplicationContext(), SecondActivity.class);
                Calendar calendar = Calendar.getInstance();
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();

                newActivity.putExtra("DayOfWeek", calendar.get(Calendar.DAY_OF_WEEK));
                newActivity.putExtra("Year", calendar.get(Calendar.YEAR));
                newActivity.putExtra("Month", calendar.get(Calendar.MONTH));
                newActivity.putExtra("Day", calendar.get(Calendar.DAY_OF_MONTH));
                newActivity.putExtra("Time", dateFormat.format(date).toString());

                startActivity(newActivity);
            }
        });

        Button googleSearchBtn = (Button)findViewById(R.id.googleSearchBtn);
        googleSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri website = Uri.parse(google);

                Intent googleIntent = new Intent(Intent.ACTION_VIEW, website);
                if (googleIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(googleIntent);
                }
            }
        });
    }
}
