package com.example.hdp.Medi_Consult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hdp.R;

public class SymptomsActivity extends AppCompatActivity {

    Button dis;
    Spinner s1, s2, s3, s4, s5, s6, s7;
    String d[] = new String[7];

    String diarrhoea[] = {"Stomach Ache", "Nausea", "Vomiting", "Fever", "Sudden Weight Loss"};
    String malaria[] = {"Fever", "Vomiting", "Sweating", "Muscle And Body Pain", "Headaches"};
    String typhoid[] = {"Fever", "Headaches", "Weakness/Fatigue", "Abdominal Pain", "Muscle Pain", "Dry Cough", "Diarrhoea/Constipation"};
    String diabetes[] = {"Frequent Urination", "Hunger", "Thirsty Than Usual", "Sudden Weight Loss", "Blurred Vision", "Skin Itching"};
    String blood_pressure[] = {"Headaches", "Blurred Vision", "Chest Pain", "Shortness in Breath", "Dizziness", "Nausea", "Vomiting"};
    String cardio_disease[] = {"Shortness in Breath", "Fast Heartbeat", "Indigestion", "Pressure Or Heaviness In Chest", "Anxiety"};
    String common_cold[] = {"Runny or Stuffy Nose", "Sneezing", "Sore Throat", "Coughing", "Mild Headache"};
    String asthma[] = {"Shortness of Breath", "Wheezing", "Chest Tightness", "Coughing, Especially at Night or Early Morning"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        dis = findViewById(R.id.disease);

        s1 = findViewById(R.id.syp1);
        s2 = findViewById(R.id.syp2);
        s3 = findViewById(R.id.syp3);
        s4 = findViewById(R.id.syp4);
        s5 = findViewById(R.id.syp5);
        s6 = findViewById(R.id.syp6);
        s7 = findViewById(R.id.syp7);
        final String name = getIntent().getStringExtra("name");
        final String gender = getIntent().getStringExtra("gender");

        dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int c[] = new int[8];
                d[0] = s1.getSelectedItem().toString();
                d[1] = s2.getSelectedItem().toString();
                d[2] = s3.getSelectedItem().toString();
                d[3] = s4.getSelectedItem().toString();
                d[4] = s5.getSelectedItem().toString();
                d[5] = s6.getSelectedItem().toString();
                d[6] = s7.getSelectedItem().toString();


                for (int i = 0; i < 7; i++) {
                    for (int j = 1; j <= 8; j++) {
                        switch (j) {
                            case 1: {
                                int l = 0;
                                l = diarrhoea.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(diarrhoea[k])) {
                                        c[0]++;
                                    }
                                }
                                break;
                            }

                            case 2: {
                                int l = 0;
                                l = malaria.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(malaria[k])) {
                                        c[1]++;
                                    }
                                }
                                break;
                            }

                            case 3: {
                                int l = 0;
                                l = typhoid.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(typhoid[k])) {
                                        c[2]++;
                                    }
                                }
                                break;
                            }

                            case 4: {
                                int l = 0;
                                l = diabetes.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(diabetes[k])) {
                                        c[3]++;
                                    }
                                }
                                break;
                            }

                            case 5: {
                                int l = 0;
                                l = blood_pressure.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(blood_pressure[k])) {
                                        c[4]++;
                                    }
                                }
                                break;
                            }

                            case 6: {
                                int l = 0;
                                l = cardio_disease.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(cardio_disease[k])) {
                                        c[5]++;
                                    }
                                }
                                break;
                            }

                            // Adding new diseases
                            case 7: { // Common Cold
                                int l = common_cold.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(common_cold[k])) {
                                        c[6]++;
                                    }
                                }
                                break;
                            }

                            case 8: { // Asthma
                                int l = asthma.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(asthma[k])) {
                                        c[7]++;
                                    }
                                }
                                break;
                            }
                            default:
                                Toast.makeText(SymptomsActivity.this, "Didn't find any disease", Toast.LENGTH_SHORT).show();
                                break;

                        }
                    }
                }

                int max = c[0];
                for (int m = 0; m < c.length; m++) {
                    if (c[m] > max)
                        max = c[m];
                }


                Intent dis_page = new Intent(SymptomsActivity.this, DiseaseActivity.class);
                dis_page.putExtra("name", name);
                dis_page.putExtra("gender", gender);
                dis_page.putExtra("max", max);
                dis_page.putExtra("c", c);
                startActivity(dis_page);

            }


        });
    }
}