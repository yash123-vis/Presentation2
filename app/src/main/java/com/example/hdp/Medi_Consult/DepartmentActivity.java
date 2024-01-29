package com.example.hdp.Medi_Consult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hdp.R;

public class DepartmentActivity extends AppCompatActivity {

    Button dis;
    Spinner s1, s2, s3, s4, s5, s6, s7;
    String d[] = new String[7];

    String cardiologist[] = {"Chest Pain", "Shortness of Breath", "Irregular Heartbeat", "Fatigue", "Dizziness", "Swelling in Ankles or Legs", "Nausea"};
    String neurologist[] = {"Headaches", "Numbness or Tingling", "Seizures", "Difficulty Speaking", "Vision Problems", "Weakness in Limbs", "Memory Problems"};
    String entSpecialist[] = {"Ear Pain or Discharge", "Nasal Congestion", "Sore Throat", "Difficulty Hearing", "Tinnitus", "Sinus Pain", "Voice Changes"};
    String internalMedSpecialist[] = {"Fatigue", "Unexplained Weight Loss", "Fever", "Chronic Pain", "Digestive Problems", "Skin Changes", "Swollen Lymph Nodes"};
    String obGynSpecialist[] = {"Irregular Menstrual Cycles", "Pelvic Pain", "Vaginal Bleeding between Periods", "Painful Periods", "Pain during Intercourse", "Abnormal Vaginal Discharge", "Missed Periods"};
    String ophthalmologist[] = {"Blurred Vision", "Eye Pain", "Redness or Irritation", "Dry Eyes", "Double Vision", "Sensitivity to Light", "Gradual Loss of Peripheral Vision"};
    String psychologist[] = {"Depressed Mood", "Anxiety or Excessive Worry", "Changes in Sleep Patterns", "Loss of Interest or Pleasure", "Changes in Appetite or Weight", "Fatigue", "Difficulty Concentrating"};
    String surgeon[] = {"Acute Abdominal Pain", "Swelling or Lump in Abdomen", "Bowel or Urinary Changes", "Unexplained Weight Loss", "Severe Injury Requiring Surgery", "Appendicitis Symptoms", "Hernia Symptoms"};
    String tbChestSpecialist[] = {"Chronic Cough", "Coughing up Blood", "Chest Pain", "Fatigue", "Night Sweats", "Unintentional Weight Loss", "Fever"};
    String endocrinologist[] = {"Fatigue", "Unexplained Weight Gain or Loss", "Excessive Thirst and Urination", "Changes in Skin", "Hair Loss", "Mood Swings", "Irregular Menstrual Cycles"};
    String dermatologist[] = {"Skin Rash or Hives", "Itching or Pruritus", "Acne or Pimples", "Skin Discoloration or Pigmentation Issues", "Unexplained Skin Growths or Moles", "Excessive Sweating", "Dry or Flaky Skin"};
    String orthopedicSurgeon[] = {"Joint Pain", "Limited Range of Motion", "Fractures", "Back Pain", "Muscle Weakness", "Swelling", "Bone Deformities"};
    String urologist[] = {"Frequent Urination", "Painful Urination", "Blood in Urine", "Kidney Stones", "Erectile Dysfunction", "Urinary Tract Infections", "Incontinence"};
    String gastroenterologist[] = {"Abdominal Pain", "Nausea", "Vomiting", "Bloating", "Diarrhea", "Constipation", "Blood in Stool"};
    String nephrologist[] = {"Swelling (Edema)", "High Blood Pressure", "Changes in Urination", "Fatigue", "Kidney Stones", "Proteinuria", "Anemia"};
    String oncologist[] = {"Unexplained Weight Loss", "Persistent Fatigue", "Lumps or Masses", "Changes in Skin (Moles)", "Persistent Pain", "Changes in Bowel or Bladder Habits", "Difficulty Swallowing"};
    String pediatrician[] = {"Fever", "Cough", "Runny Nose", "Vomiting", "Diarrhea", "Skin Rash", "Irritability"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        dis = findViewById(R.id.department);

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

                int c[] = new int[17];
                d[0] = s1.getSelectedItem().toString();
                d[1] = s2.getSelectedItem().toString();
                d[2] = s3.getSelectedItem().toString();
                d[3] = s4.getSelectedItem().toString();
                d[4] = s5.getSelectedItem().toString();
                d[5] = s6.getSelectedItem().toString();
                d[6] = s7.getSelectedItem().toString();


                for (int i = 0; i < 7; i++) {
                    for (int j = 1; j <= 17; j++) {
                        switch (j) {
                            case 1: {
                                int l = 0;
                                l = cardiologist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(cardiologist[k])) {
                                        c[0]++;
                                    }
                                }
                                break;
                            }

                            case 2: { // Neurologist
                                int l = neurologist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(neurologist[k])) {
                                        c[1]++;
                                    }
                                }
                                break;
                            }

                            case 3: { // ENT Specialist
                                int l = entSpecialist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(entSpecialist[k])) {
                                        c[2]++;
                                    }
                                }
                                break;
                            }

                            case 4: { // Internal Medicine Specialist
                                int l = internalMedSpecialist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(internalMedSpecialist[k])) {
                                        c[3]++;
                                    }
                                }
                                break;
                            }

                            case 5: { // OB/GYN Specialist
                                int l = obGynSpecialist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(obGynSpecialist[k])) {
                                        c[4]++;
                                    }
                                }
                                break;
                            }

                            case 6: { // Ophthalmologist
                                int l = ophthalmologist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(ophthalmologist[k])) {
                                        c[5]++;
                                    }
                                }
                                break;
                            }

                            case 7: { // Psychologist
                                int l = psychologist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(psychologist[k])) {
                                        c[6]++;
                                    }
                                }
                                break;
                            }

                            case 8: { // Surgeon
                                int l = surgeon.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(surgeon[k])) {
                                        c[7]++;
                                    }
                                }
                                break;
                            }


                            case 9: { // TB/Chest Specialist
                                int l = tbChestSpecialist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(tbChestSpecialist[k])) {
                                        c[8]++;
                                    }
                                }
                                break;
                            }

                            case 10: { // Endocrinologist
                                int l = endocrinologist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(endocrinologist[k])) {
                                        c[9]++;
                                    }
                                }
                                break;
                            }

                            case 11: { // Dermatologist
                                int l = dermatologist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(dermatologist[k])) {
                                        c[10]++;
                                    }
                                }
                                break;
                            }

                            case 12: { // Orthopedic Surgeon
                                int l = orthopedicSurgeon.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(orthopedicSurgeon[k])) {
                                        c[11]++;
                                    }
                                }
                                break;
                            }

                            case 13: { // Urologist
                                int l = urologist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(urologist[k])) {
                                        c[12]++;
                                    }
                                }
                                break;
                            }

                            case 14: { // Gastroenterologist
                                int l = gastroenterologist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(gastroenterologist[k])) {
                                        c[13]++;
                                    }
                                }
                                break;
                            }

                            case 15: { // Nephrologist
                                int l = nephrologist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(nephrologist[k])) {
                                        c[14]++;
                                    }
                                }
                                break;
                            }

                            case 16: { // Oncologist
                                int l = oncologist.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(oncologist[k])) {
                                        c[15]++;
                                    }
                                }
                                break;
                            }


                            case 17: { // Pediatrician
                                int l = pediatrician.length;
                                for (int k = 0; k < l; k++) {
                                    if (d[i].equals(pediatrician[k])) {
                                        c[16]++;
                                    }
                                }
                                break;
                            }

                            default:
                                Toast.makeText(DepartmentActivity.this, "Didn't find any disease", Toast.LENGTH_SHORT).show();
                                break;

                        }
                    }
                }

                int max = c[0];
                for (int m = 0; m < c.length; m++) {
                    if (c[m] > max)
                        max = c[m];
                }


                Intent dis_page = new Intent(DepartmentActivity.this, DepartmentOutputActivity.class);
                dis_page.putExtra("name", name);
                dis_page.putExtra("gender", gender);
                dis_page.putExtra("max", max);
                dis_page.putExtra("c", c);
                startActivity(dis_page);

            }


        });
    }
}