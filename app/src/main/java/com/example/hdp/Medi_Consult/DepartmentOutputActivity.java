package com.example.hdp.Medi_Consult;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.hdp.R;

public class DepartmentOutputActivity extends AppCompatActivity {

    TextView head;
    TextView info[] = new TextView[2];
    CardView dis_content;
    ImageView im[] = new ImageView[7];

    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        head = findViewById(R.id.card_head);
        dis_content = findViewById(R.id.cardView);
        im[0] = findViewById(R.id.content_disease1);
        im[1] = findViewById(R.id.content_disease2);
        info[0] = findViewById(R.id.info1);
        info[1] = findViewById(R.id.info2);

        String name = getIntent().getStringExtra("name");
        String gender = getIntent().getStringExtra("gender");
        int max = getIntent().getIntExtra("max", 0);
        int[] c = getIntent().getIntArrayExtra("c");
        head.setText(gender + " " + name + getString(R.string.you_may_have));

        int i = 0;

        if (max == c[0]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.cardio));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=cardiology+department&rlz=1C1CHNY_enIN1021IN1021&oq=cardiology&gs_lcrp=EgZjaHJvbWUqDQgEEAAYgwEYsQMYgAQyBggAEEUYOTIHCAEQABiABDIKCAIQABixAxiABDIHCAMQABiABDINCAQQABiDARixAxiABDIHCAUQABiABDIHCAYQABiABDIHCAcQABiABDIHCAgQABiABDIHCAkQABiABNIBCTExODA1ajBqN6gCALACAA&sourceid=chrome&ie=UTF-8"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[1]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.neuro));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=neurology+&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBiI2Fs1nRCA6NIuL4B-zwPAoJtcuQ%3A1692620032890&ei=AFXjZJ3uNcjc1e8P3puEmAI&ved=0ahUKEwid7rL-3O2AAxVIbvUHHd4NASMQ4dUDCA8&uact=5&oq=neurology+&gs_lp=Egxnd3Mtd2l6LXNlcnAiCm5ldXJvbG9neSAyBxAjGIoFGCcyChAAGIAEGAIYywEyCBAAGIAEGLEDMgUQABiABDIHEAAYigUYQzIFEAAYgAQyCxAAGIAEGLEDGIMBMgUQABiABDIFEAAYgAQyBRAAGIAESLMNULkBWOIIcAF4AZABAJgB2QGgAdQIqgEFMC41LjG4AQPIAQD4AQHCAgoQABhHGNYEGLADwgIKEAAYigUYsAMYQ8ICCxAuGIAEGMcBGK8BwgIKEAAYgAQYFBiHAuIDBBgAIEGIBgGQBgo&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[2]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.otolaryngology));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=e.n.t&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBirLQeVm6d9MlU9qK-uJCycS4dmmA%3A1692620039766&ei=B1XjZJauLtOlhwPA4LCgBg&ved=0ahUKEwjWzdaB3e2AAxXT0mEKHUAwDGQQ4dUDCA8&uact=5&oq=e.n.t&gs_lp=Egxnd3Mtd2l6LXNlcnAiBWUubi50MgoQABiABBgUGIcCMgUQABiABDIFEAAYgAQyBRAAGIAEMgUQABiABDIFEAAYgAQyBRAAGIAEMgUQABiABDIIEAAYgAQYywEyBRAAGIAESL4YUOcGWOkPcAF4AZABAJgB2wGgAbkHqgEFMC4zLjK4AQPIAQD4AQGoAhPCAgcQIxjqAhgnwgIHEC4Y6gIYJ8ICEBAAGIoFGOoCGLQCGEPYAQHCAgcQABiKBRhDwgILEAAYgAQYsQMYgwHCAgsQLhiABBixAxiDAcICCBAAGIoFGJECwgIFEC4YgATiAwQYACBBiAYBugYGCAEQARgB&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[3]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.internal_medicine_dept));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=community+medicine&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBhoU9GmLgBjZNd8M8Wcw1C96v4MCQ%3A1692621353565&ei=KVrjZIKWItCB1e8PnZ-DgAg&oq=comm&gs_lp=Egxnd3Mtd2l6LXNlcnAiBGNvbW0qAggCMgcQIxiKBRgnMgQQIxgnMggQABiKBRiRAjIIEAAYigUYkQIyBxAAGIoFGEMyBxAAGIoFGEMyDRAuGIoFGMcBGNEDGEMyBxAAGIoFGEMyBxAAGIoFGEMyBxAAGIoFGENIxSlQlghYwQ5wAXgBkAEAmAH3AaAB0gaqAQUwLjEuM7gBA8gBAPgBAagCEcICBxAjGOoCGCfCAgcQLhjqAhgnwgIQEAAYigUY6gIYtAIYQ9gBAcICExAuGIoFGMgDGOoCGLQCGEPYAQLCAgsQABiABBixAxiDAcICCxAAGIoFGLEDGIMBwgIOEAAYigUYsQMYgwEYkQLCAg0QLhiKBRjHARivARhD4gMEGAAgQYgGAboGBggBEAEYAboGBggCEAEYCA&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[4]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.gynocology));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=gynaecology&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBiO30gOE4uMUJyAA8hE4lnc5M3nXg%3A1692621364691&ei=NFrjZIXhKdX_wAOO1anYBw&oq=gyn&gs_lp=Egxnd3Mtd2l6LXNlcnAiA2d5bioCCAAyCxAAGIoFGLEDGJECMg0QABiKBRixAxiDARhDMhAQABiKBRixAxiDARjJAxhDMggQABiKBRiSAzIKEAAYigUYsQMYQzIHEAAYigUYQzIHEAAYigUYQzINEAAYigUYsQMYgwEYQzIKEAAYigUYsQMYQzINEAAYigUYsQMYgwEYQ0jfGVD2B1inD3ABeAGQAQCYAe8BoAH5BKoBBTAuMS4yuAEDyAEA-AEBqAIUwgIHECMY6gIYJ8ICBxAuGOoCGCfCAhAQABiKBRjqAhi0AhhD2AEBwgIQEC4YigUY6gIYtAIYQ9gBAcICBxAuGIoFGCfCAgQQIxgnwgITEC4YigUYsQMYgwEYxwEY0QMYQ8ICCxAAGIAEGLEDGIMBwgILEC4YgwEYsQMYgATCAgsQABiKBRixAxiDAcICBRAuGIAEwgIUEC4YigUYlwUY3AQY3gQY4ATYAQLCAggQABiKBRiRAuIDBBgAIEGIBgG6BgYIARABGAG6BgYIAhABGBQ&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[5]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.opthamology));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=ophthalmology&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBgXOFobccht979T9i19Ly1d9Ik43w%3A1692621481073&ei=qVrjZPaPBPLt1e8Pn_692AQ&oq=opth&gs_lp=Egxnd3Mtd2l6LXNlcnAiBG9wdGgqAggAMgoQABiKBRixAxhDMg0QABiKBRixAxjJAxhDMggQABiKBRiSAzINEAAYigUYsQMYgwEYQzINEAAYgAQYsQMYgwEYCjINEAAYgAQYsQMYgwEYCjIKEAAYgAQYsQMYCjIKEAAYgAQYsQMYCjIKEAAYgAQYsQMYCjIKEAAYgAQYsQMYCkiQI1CgBFjTEXABeAGQAQGYAfgDoAGJC6oBCTItMi4xLjAuMbgBA8gBAPgBAagCFMICBxAjGOoCGCfCAgcQLhjqAhgnwgIQEAAYigUY6gIYtAIYQ9gBAcICBxAAGIoFGEPCAgcQLhiKBRgnwgIHECMYigUYJ8ICBxAuGIoFGEPCAhQQLhiKBRiXBRjcBBjeBBjgBNgBAuIDBBgAIEGIBgG6BgYIARABGAG6BgYIAhABGBQ&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[6]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.psychology));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=psychology&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBhRYFVO9g45CA1XK5dittKYP1wnOg%3A1692622368868&ei=IF7jZJjTNIjWhwPH843wBA&ved=0ahUKEwiY46PY5e2AAxUI62EKHcd5A04Q4dUDCA8&uact=5&oq=psychology&gs_lp=Egxnd3Mtd2l6LXNlcnAiCnBzeWNob2xvZ3kyChAAGIAEGBQYhwIyCBAAGIAEGLEDMgsQABiABBixAxiDATILEC4YgAQYsQMYgwEyBRAAGIAEMgsQABiABBixAxiDATIFEAAYgAQyChAAGIAEGAIYywEyCBAAGIAEGLEDMgUQABiABEiQY1CABliyX3ADeAGQAQCYAbUCoAH-E6oBBzAuNS42LjG4AQPIAQD4AQGoAhTCAgcQIxjqAhgnwgIHEC4Y6gIYJ8ICFhAuGAMYjwEY6gIYtAIYjAMY5QLYAQHCAhYQABgDGI8BGOoCGLQCGIwDGOUC2AEBwgIHECMYigUYJ8ICBBAjGCfCAgcQABiKBRhDwgIKEAAYigUYsQMYQ8ICDRAAGIoFGLEDGIMBGEPCAggQABiKBRiRAsICCxAAGIoFGLEDGJECwgIKEAAYgAQYsQMYCsICEBAAGIAEGLEDGIMBGMkDGArCAggQABiKBRiSA8ICDRAAGIAEGLEDGIMBGArCAgcQABiABBgKwgIQEAAYigUYsQMYgwEYyQMYQ8ICCBAuGIAEGLED4gMEGAAgQYgGAboGBggBEAEYCw&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[7]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.surgery));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=surgery&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBjhbNmy_87EZxRvhTRs70FDr3DbZg%3A1692622704945&ei=cF_jZKenObvQ1e8P27q94A4&oq=surgery&gs_lp=Egxnd3Mtd2l6LXNlcnAiB3N1cmdlcnkqAggAMgsQABiKBRixAxiRAjIIEAAYigUYkQIyDhAAGIoFGLEDGIMBGJECMgsQABiKBRixAxiRAjIFEAAYgAQyCBAAGIoFGJECMgUQABiABDIKEAAYgAQYAhjLATIFEAAYgAQyBRAAGIAESPMiUJ4FWJIXcAF4AZABAJgB3wGgAewIqgEFMC42LjG4AQPIAQD4AQGoAhTCAgcQIxjqAhgnwgIHEC4Y6gIYJ8ICEBAAGIoFGOoCGLQCGEPYAQHCAgcQABiKBRhDwgIHEC4YigUYQ8ICCxAAGIAEGLEDGIMBwgILEC4YgAQYsQMYgwHCAgsQLhiKBRixAxiDAcICBBAjGCfCAgoQABiKBRixAxhDwgINEAAYigUYsQMYgwEYQ8ICCBAAGIAEGLEDwgINEAAYigUYsQMYyQMYQ8ICCBAAGIoFGJID4gMEGAAgQYgGAboGBggBEAEYAQ&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[8]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.pulmonology));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=pulmonology&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBgMSAHxDOafdaOCtK9CSx4MXNXhdg%3A1692627804410&ei=XHPjZLPRGPXQ1e8PtMqy8As&oq=pul&gs_lp=Egxnd3Mtd2l6LXNlcnAiA3B1bCoCCAAyBxAAGIoFGEMyEBAAGIoFGLEDGIMBGMkDGEMyCBAAGIoFGJIDMggQABiKBRiSAzIHEAAYigUYQzIHEAAYigUYQzIKEAAYigUYsQMYQzILEAAYgAQYsQMYgwEyCBAAGIAEGLEDMgsQABiABBixAxiDAUilF1DAB1i4C3ABeAGQAQCYAaECoAHhBaoBAzItM7gBA8gBAPgBAagCEMICBxAjGOoCGCfCAhAQABiKBRjqAhi0AhhD2AEBwgIHECMYigUYJ8ICDRAAGIoFGLEDGIMBGEPCAggQLhixAxiABMICCBAuGIAEGLED4gMEGAAgQYgGAboGBggBEAEYAQ&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[9]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.endocrinology));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=endocrinology&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBhKwyirsD2bX1vqJOcqBWIUITdsog%3A1692627751374&ei=J3PjZIS_FsHi-Aap0Kf4Dg&oq=end&gs_lp=Egxnd3Mtd2l6LXNlcnAiA2VuZCoCCAAyChAAGIoFGLEDGEMyEBAAGIoFGLEDGIMBGMkDGEMyCBAAGIoFGJIDMggQABiKBRiSAzIHEAAYigUYQzINEAAYigUYsQMYgwEYQzINEAAYigUYsQMYgwEYQzINEAAYigUYsQMYgwEYQzIIEAAYgAQYsQMyCxAAGIAEGLEDGIMBSNYTUMAFWLgIcAF4AZABAJgBmQGgAcADqgEDMC4zuAEDyAEA-AEBqAIUwgIHECMY6gIYJ8ICFhAAGAMYjwEY6gIYtAIYjAMY5QLYAQHCAhYQLhgDGI8BGOoCGLQCGIwDGOUC2AEBwgIHECMYigUYJ8ICBBAjGCfCAgUQABiABMICCxAuGIAEGLEDGIMB4gMEGAAgQYgGAboGBggBEAEYCw&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }

        if (max == c[10]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.dermatology));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=dermatology&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBiDJypUAXi4brh1wUbpfvRE9wi0-g%3A1692627696043&ei=8HLjZLmlAuvn1e8Pw7a_8Ak&ved=0ahUKEwi53bzE-e2AAxXrc_UHHUPbD54Q4dUDCA8&uact=5&oq=dermatology&gs_lp=Egxnd3Mtd2l6LXNlcnAiC2Rlcm1hdG9sb2d5Mg0QABiKBRixAxiDARhDMgsQABiABBixAxiDATINEAAYigUYsQMYgwEYQzIFEAAYgAQyBRAAGIAEMgsQABiABBixAxiDATIFEAAYgAQyBRAAGIAEMgUQABiABDIFEAAYgARI7StQvAVY3ClwAXgBkAEAmAHZAaABvQ6qAQYwLjEwLjG4AQPIAQD4AQGoAhTCAgcQIxjqAhgnwgIWEAAYAxiPARjqAhi0AhiMAxjlAtgBAcICFhAuGAMYjwEY6gIYtAIYjAMY5QLYAQHCAgcQIxiKBRgnwgIEECMYJ8ICBxAAGIoFGEPCAgsQABiKBRixAxiDAcICCxAuGIoFGLEDGIMBwgIHEC4YigUYQ8ICDRAAGIoFGLEDGMkDGEPCAggQABiKBRiSA8ICChAAGIoFGLEDGEPCAggQABiABBixA-IDBBgAIEGIBgG6BgYIARABGAs&sclient=gws-wiz-serp#cobssid=s"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }

        if (max == c[11]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.orthopedic));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=orthopedic&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBhcF5y0G4har_K6mPllbFxWeexivQ%3A1692627647268&ei=v3LjZO2AEMmI-QbUjYGIBQ&oq=ort&gs_lp=Egxnd3Mtd2l6LXNlcnAiA29ydCoCCAAyDRAAGIoFGLEDGIMBGEMyBxAAGIoFGEMyChAAGIoFGLEDGEMyChAAGIoFGLEDGEMyBxAAGIoFGEMyDRAAGIoFGLEDGMkDGEMyCBAAGIoFGJIDMgoQABiKBRixAxhDMg0QABiKBRixAxiDARhDMgcQABiKBRhDSNkVUO4FWOMJcAF4AZABAJgB1AGgAdIEqgEFMC4yLjG4AQPIAQD4AQGoAhTCAgcQIxjqAhgnwgIWEAAYAxiPARjqAhi0AhiMAxjlAtgBAcICFhAuGAMYjwEY6gIYtAIYjAMY5QLYAQHCAgcQIxiKBRgnwgIHEC4YigUYJ8ICBBAjGCfiAwQYACBBiAYBugYGCAEQARgL&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }

        if (max == c[12]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.urology));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=urology&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBjmG0HpvZJSL2XtbcSxtWUqraruFg%3A1692627583824&ei=f3LjZJr3Mcrl1e8P9siNoAE&oq=urolo&gs_lp=Egxnd3Mtd2l6LXNlcnAiBXVyb2xvKgIIADINEAAYigUYsQMYgwEYQzIQEAAYigUYsQMYgwEYyQMYQzIIEAAYigUYkgMyCBAAGIoFGJIDMgsQABiABBixAxiDATIQEAAYgAQYFBiHAhixAxiDATIKEAAYgAQYAhjLATIFEAAYgAQyBRAAGIAEMgUQABiABEjLF1DvBljcDXABeAGQAQCYAYwCoAG8CKoBBTAuMi4zuAEDyAEA-AEBqAIUwgIHECMY6gIYJ8ICFhAAGAMYjwEY6gIYtAIYjAMY5QLYAQHCAhYQLhgDGI8BGOoCGLQCGIwDGOUC2AEBwgIEECMYJ8ICBxAjGIoFGCfCAgcQABiKBRhDwgIREC4YgAQYsQMYgwEYxwEY0QPCAgsQLhiABBixAxiDAcICCBAAGIAEGLEDwgIIEC4YgAQYsQPiAwQYACBBiAYBugYGCAEQARgL&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[13]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.gastroenlogy));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=gastroenterology&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBhL87UfL2jykNt2ADdGyGO2jcgbmw%3A1692627523284&ei=Q3LjZND9EMSohwPv25XIAw&oq=gastr&gs_lp=Egxnd3Mtd2l6LXNlcnAiBWdhc3RyKgIIADINEAAYigUYsQMYgwEYQzIQEAAYigUYsQMYgwEYyQMYQzIIEAAYigUYkgMyCBAAGIoFGJIDMg0QABiKBRixAxiDARhDMg0QABiKBRixAxiDARhDMgoQABiKBRixAxhDMg0QABiKBRixAxiDARhDMgsQABiABBixAxiDATIKEAAYigUYsQMYQ0jGIFC6Blj4FHABeAGQAQCYAdMBoAGAB6oBBTAuNC4xuAEDyAEA-AEBqAIUwgIHECMY6gIYJ8ICFhAAGAMYjwEY6gIYtAIYjAMY5QLYAQHCAhYQLhgDGI8BGOoCGLQCGIwDGOUC2AEBwgIHECMYigUYJ8ICBxAuGIoFGCfCAgQQIxgnwgIHEAAYigUYQ8ICERAuGIAEGLEDGIMBGMcBGNEDwgILEC4YgwEYsQMYgATiAwQYACBBiAYBugYGCAEQARgL&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[14]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.nephrology));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=nephrology&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBiyYXpkm6LTFB8sR8SlBUj6RG8EEg%3A1692627465844&ei=CXLjZJGEM8qnoATij6vwCw&oq=nephr&gs_lp=Egxnd3Mtd2l6LXNlcnAiBW5lcGhyKgIIADIKEAAYigUYsQMYQzINEAAYigUYsQMYgwEYQzIIEAAYgAQYsQMyBxAAGIoFGEMyCBAAGIAEGLEDMggQABiABBixAzIKEAAYgAQYAhjLATIIEAAYgAQYsQMyBxAAGIoFGEMyCBAAGIAEGLEDSO0hUPAFWJcXcAF4AZABAJgBzwGgAZAHqgEFMC40LjG4AQPIAQD4AQGoAhTCAgcQIxjqAhgnwgIWEAAYAxiPARjqAhi0AhiMAxjlAtgBAcICFhAuGAMYjwEY6gIYtAIYjAMY5QLYAQHCAgcQIxiKBRgnwgILEAAYigUYsQMYgwHCAgsQABiABBixAxiDAcICCBAuGIAEGLEDwgIFEAAYgATCAggQABiKBRixA-IDBBgAIEGIBgG6BgYIARABGAs&sclient=gws-wiz-serp#cobssid=s"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[15]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.oncology));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=oncology&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBi8p9YZGKk8zjIKXD1yuYhxsmMMdQ%3A1692627412330&ei=1HHjZN3aE5KF-Qb2-JL4Dg&oq=onc&gs_lp=Egxnd3Mtd2l6LXNlcnAiA29uYyoCCAAyChAAGIoFGLEDGEMyDRAAGIoFGLEDGIMBGEMyCBAAGIAEGLEDMgsQABiABBixAxiDATILEAAYgAQYsQMYgwEyCBAAGIAEGLEDMgUQLhiABDIFEAAYgAQyDhAuGIAEGLEDGMcBGNEDMgsQABiABBixAxiDAUjdGVCvBVjmDHABeAGQAQCYAZoBoAHEA6oBAzAuM7gBA8gBAPgBAagCFMICBxAjGOoCGCfCAhAQABiKBRjqAhi0AhhD2AEBwgISEAAYigUY6gIYtAIYChhD2AEBwgIHECMYigUYJ8ICBxAuGIoFGCfCAgcQABiKBRhDwgIREC4YgAQYsQMYgwEYxwEY0QPCAggQLhiABBjlBMICCxAAGIoFGLEDGIMB4gMEGAAgQYgGAboGBggBEAEYAQ&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }
        if (max == c[16]) {
            im[i].setImageDrawable(getResources().getDrawable(R.drawable.pediatrics));

            info[i].setVisibility(View.VISIBLE);
            info[i].setMovementMethod(LinkMovementMethod.getInstance());
            info[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                    browserIntent.setData(Uri.parse("https://www.google.com/search?q=paediatrics&sca_esv=558740822&rlz=1C1CHNY_enIN1021IN1021&sxsrf=AB5stBjt-qmOUh3WFxydz20QyYD0lD7JHA%3A1692626612677&ei=tG7jZMf4KIfVhwPqp4iwBg&oq=paed&gs_lp=Egxnd3Mtd2l6LXNlcnAiBHBhZWQqAggBMgcQABiKBRhDMg4QABiKBRixAxiDARiRAjIHEAAYigUYQzIHEAAYigUYQzIHEAAYigUYQzIHEAAYigUYQzILEAAYgAQYsQMYgwEyBxAAGIoFGEMyCxAAGIAEGLEDGIMBMg0QABiABBixAxiDARgKSLwlUJoGWKYQcAF4AZABAJgB0gGgAdoFqgEFMC4yLjK4AQPIAQD4AQGoAhTCAgcQIxjqAhgnwgIWEAAYAxiPARjqAhi0AhiMAxjlAtgBAcICFhAuGAMYjwEY6gIYtAIYjAMY5QLYAQHCAgcQIxiKBRgnwgITEC4YigUYsQMYgwEYxwEY0QMYQ8ICChAAGIAEGBQYhwLCAgUQABiABOIDBBgAIEGIBgG6BgYIARABGAs&sclient=gws-wiz-serp"));
                    startActivity(browserIntent);
                }
            });

            i++;
        }


    }
}