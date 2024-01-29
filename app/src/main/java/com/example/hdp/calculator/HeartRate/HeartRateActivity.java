package com.example.hdp.calculator.HeartRate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hdp.R;

import java.io.PrintStream;

public class HeartRateActivity extends AppCompatActivity {

    public static int HRmax;
    public static int age;
    public static double ans_heart_rate;
    public static int avg_resting_rate;
    public static double lower_rate1;
    public static double lower_rate10;
    public static double lower_rate2;
    public static double lower_rate3;
    public static double lower_rate4;
    public static double lower_rate5;
    public static double lower_rate6;
    public static double lower_rate7;
    public static double lower_rate8;
    public static double lower_rate9;
    public static int max_resting_rate;
    public static double target_heart_rate50;
    public static double target_heart_rate55;
    public static double target_heart_rate60;
    public static double target_heart_rate65;
    public static double target_heart_rate70;
    public static double target_heart_rate75;
    public static double target_heart_rate80;
    public static double target_heart_rate85;
    public static double target_heart_rate90;
    public static double target_heart_rate95;
    String TAG = getClass().getSimpleName();
    //    AdView adView;
    EditText et_age;
    EditText et_heart_rate;
    ImageView iv_back;
    TextView tv_heartrate;
    TextView tv_search_heart_rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate);

        this.tv_search_heart_rate = (TextView) findViewById(R.id.tv_search_heart_rate);
        this.et_age = (EditText) findViewById(R.id.et_age);
        this.et_heart_rate = (EditText) findViewById(R.id.et_heart_rate);
//        this.adView = (AdView) findViewById(R.id.adView);
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        this.tv_search_heart_rate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HeartRateActivity.this.et_age.getText().toString().trim().equals("")) {
                    HeartRateActivity.this.et_age.setError(HeartRateActivity.this.getString(R.string.Enter_Age));
                } else if (HeartRateActivity.this.et_heart_rate.getText().toString().trim().equals("")) {
                    HeartRateActivity.this.et_heart_rate.setError(HeartRateActivity.this.getString(R.string.Enter_Heart_Rate));
                } else {
                    HeartRateActivity.age = Integer.parseInt(HeartRateActivity.this.et_age.getText().toString().trim());
                    HeartRateActivity.avg_resting_rate = Integer.parseInt(HeartRateActivity.this.et_heart_rate.getText().toString().trim());
                    int random = ((int) (Math.random() * 2.0d)) + 1;
                    PrintStream printStream = System.out;
                    StringBuilder sb = new StringBuilder();
                    sb.append("random_number==>");
                    sb.append(random);
                    printStream.println(sb.toString());
                    HeartRateActivity.this.calculate();
                
//                    else {
//                        HeartRateActivity.this.calculate();
//                    }
                }
            }
        });
    }

    public void calculate() {
        HRmax = 220 - age;
        StringBuilder sb = new StringBuilder();
        sb.append("HRmax");
        sb.append(HRmax);
        Log.d("HRmax", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("age");
        sb2.append(age);
        Log.d("age", sb2.toString());
        max_resting_rate = HRmax - avg_resting_rate;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("max_resting_rate");
        sb3.append(max_resting_rate);
        Log.d("max_resting_rate", sb3.toString());
        double d = (double) max_resting_rate;
        Double.isNaN(d);
        double d2 = d * 0.5d;
        double d3 = (double) avg_resting_rate;
        Double.isNaN(d3);
        lower_rate1 = d2 + d3;
        double d4 = (double) max_resting_rate;
        Double.isNaN(d4);
        double d5 = d4 * 0.55d;
        double d6 = (double) avg_resting_rate;
        Double.isNaN(d6);
        lower_rate2 = d5 + d6;
        double d7 = (double) max_resting_rate;
        Double.isNaN(d7);
        double d8 = d7 * 0.6d;
        double d9 = (double) avg_resting_rate;
        Double.isNaN(d9);
        lower_rate3 = d8 + d9;
        double d10 = (double) max_resting_rate;
        Double.isNaN(d10);
        double d11 = d10 * 0.65d;
        double d12 = (double) avg_resting_rate;
        Double.isNaN(d12);
        lower_rate4 = d11 + d12;
        double d13 = (double) max_resting_rate;
        Double.isNaN(d13);
        double d14 = d13 * 0.7d;
        double d15 = (double) avg_resting_rate;
        Double.isNaN(d15);
        lower_rate5 = d14 + d15;
        double d16 = (double) max_resting_rate;
        Double.isNaN(d16);
        double d17 = d16 * 0.75d;
        double d18 = (double) avg_resting_rate;
        Double.isNaN(d18);
        lower_rate6 = d17 + d18;
        double d19 = (double) max_resting_rate;
        Double.isNaN(d19);
        double d20 = d19 * 0.8d;
        double d21 = (double) avg_resting_rate;
        Double.isNaN(d21);
        lower_rate7 = d20 + d21;
        double d22 = (double) max_resting_rate;
        Double.isNaN(d22);
        double d23 = d22 * 0.85d;
        double d24 = (double) avg_resting_rate;
        Double.isNaN(d24);
        lower_rate8 = d23 + d24;
        double d25 = (double) max_resting_rate;
        Double.isNaN(d25);
        double d26 = d25 * 0.9d;
        double d27 = (double) avg_resting_rate;
        Double.isNaN(d27);
        lower_rate9 = d26 + d27;
        double d28 = (double) max_resting_rate;
        Double.isNaN(d28);
        double d29 = d28 * 0.95d;
        double d30 = (double) avg_resting_rate;
        Double.isNaN(d30);
        lower_rate10 = d29 + d30;
        ans_heart_rate = (((((((((lower_rate1 + lower_rate2) + lower_rate3) + lower_rate4) + lower_rate5) + lower_rate6) + lower_rate7) + lower_rate8) + lower_rate9) + lower_rate10) / 10.0d;
        double d31 = (double) (220 - age);
        Double.isNaN(d31);
        target_heart_rate50 = d31 * 0.5d;
        double d32 = (double) (220 - age);
        Double.isNaN(d32);
        target_heart_rate55 = d32 * 0.55d;
        double d33 = (double) (220 - age);
        Double.isNaN(d33);
        target_heart_rate60 = d33 * 0.6d;
        double d34 = (double) (220 - age);
        Double.isNaN(d34);
        target_heart_rate65 = d34 * 0.65d;
        double d35 = (double) (220 - age);
        Double.isNaN(d35);
        target_heart_rate70 = d35 * 0.7d;
        double d36 = (double) (220 - age);
        Double.isNaN(d36);
        target_heart_rate75 = d36 * 0.75d;
        double d37 = (double) (220 - age);
        Double.isNaN(d37);
        target_heart_rate80 = d37 * 0.8d;
        double d38 = (double) (220 - age);
        Double.isNaN(d38);
        target_heart_rate85 = d38 * 0.85d;
        double d39 = (double) (220 - age);
        Double.isNaN(d39);
        target_heart_rate90 = d39 * 0.9d;
        double d40 = (double) (220 - age);
        Double.isNaN(d40);
        target_heart_rate95 = d40 * 0.95d;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("target_heart_rate50");
        sb4.append(target_heart_rate50);
        Log.d("target_heart_rate50", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("lower_rate50");
        sb5.append(lower_rate5);
        Log.d("lower_rate5", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("ans_heart_rate");
        sb6.append(ans_heart_rate);
        Log.d("ans_heart_rate", sb6.toString());
        startActivity(new Intent(this, Heart_Rate_Result.class));
    }


    public void onBackPressed() {
//        this.adView.setVisibility(8);
        ActivityCompat.finishAfterTransition(this);
    }
}