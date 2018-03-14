package com.example.masterprocess.quicklaunch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String[] days = {"Saturday", "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday"};
    String[] months = {"January", "February", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("DayOfWeek")) {
            TextView tv = findViewById(R.id.textView_dayofweek);
            int dayOfWeek = getIntent().getExtras().getInt("DayOfWeek");
            tv.setText(days[dayOfWeek]);
        }

        if (getIntent().hasExtra("Month")) {
            TextView tv = findViewById(R.id.textView_month);
            int month = getIntent().getExtras().getInt("Month");
            tv.setText(months[month]);
        }

        if (getIntent().hasExtra("Day")) {
            TextView tv = findViewById(R.id.textView_day);
            TextView tv2 = findViewById(R.id.textView_suffix);
            int day = getIntent().getExtras().getInt("Day");
            int suffix = day % 10;
            tv.setText(day + "");
            switch (suffix) {
                case 1:
                    tv2.setText("st");
                    break;
                case 2:
                    tv2.setText("nd");
                    break;
                case 3:
                    tv2.setText("rd");
                    break;
                default:
                    tv2.setText("th");
            }
        }

        if (getIntent().hasExtra("Year")) {
            TextView tv = findViewById(R.id.textView_year);
            int year = getIntent().getExtras().getInt("Year");
            tv.setText(year + "");
        }

        if (getIntent().hasExtra("Time")) {
            TextView tv = findViewById(R.id.textView_time);
            String time = getIntent().getExtras().getString("Time");
            tv.setText(time);
        }
    }
}
