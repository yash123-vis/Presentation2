package com.example.hdp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hdp.ml.CovidModel;
import com.google.firebase.database.annotations.Nullable;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;

public class CovidActivity extends AppCompatActivity {

    Button selectBtn, predict;
    ImageView brainImage;
    TextView output, refresh, adviceText, bText;
    LinearLayout linearL;
    private Bitmap img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);

        selectBtn = findViewById(R.id.select_btn);
        predict = findViewById(R.id.predict_btn);
        output = findViewById(R.id.prediction_result);
        brainImage = findViewById(R.id.brainImage);
        refresh = findViewById(R.id.refresh);
        linearL = findViewById(R.id.linear);
        adviceText = findViewById(R.id.advice_text);
        bText = findViewById(R.id.b_text);


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshAll();
            }
        });



        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 100);
                predict.setVisibility(View.VISIBLE);
                selectBtn.setVisibility(View.GONE);
                bText.setVisibility(View.GONE);
            }
        });


        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(img!=null) {
                    img=Bitmap.createScaledBitmap(img, 64, 64, true);
                    try {
                        CovidModel model = CovidModel.newInstance(getApplicationContext());

                        // Creates inputs for reference.
                        TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 64, 64, 3}, DataType.FLOAT32);

                        TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
                        tensorImage.load(img);
                        ByteBuffer byteBuffer = tensorImage.getBuffer();


                        inputFeature0.loadBuffer(byteBuffer);

                        // Runs model inference and gets result.
                        CovidModel.Outputs outputs = model.process(inputFeature0);
                        TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
                        if(outputFeature0.getFloatArray()[0]==1.0){
                            output.setText("No, COVID is Not found");
                            output.setTextColor(Color.parseColor("#00A36C"));
                            Animation blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
                            output.startAnimation(blinkAnimation);
                            adviceText.setText("Prevent COVID");
                            adviceText.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(CovidActivity.this, CovidPrevention.class));
                                }
                            });

                            refresh.setVisibility(View.VISIBLE);
                            linearL.setVisibility(View.VISIBLE);
                        }
                        else{
                            output.setText("yes COVID is Found!");
                            output.setTextColor(Color.parseColor("#ee445f"));
                            Animation blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
                            output.startAnimation(blinkAnimation);
                            adviceText.setText("Treatment COVID");
                            adviceText.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(CovidActivity.this, CovidTreatment.class));
                                }
                            });

                            refresh.setVisibility(View.VISIBLE);
                            linearL.setVisibility(View.VISIBLE);
                        }
//                    output.setText(outputFeature0.getFloatArray()[0]+ "\n"+ outputFeature0.getFloatArray()[0]);

                        // Releases model resources if no longer used.
                        model.close();
                    } catch (IOException e) {
                        // TODO Handle the exception
                    }


                }

                else{
                    Toast.makeText(CovidActivity.this, "Please Select Image First", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    private void refreshAll(){
        output.setText(R.string.covid_hint);
        output.setTextColor(Color.parseColor("#000000"));
        brainImage.setImageResource(R.drawable.ct_scan);
        output.clearAnimation();
        refresh.setVisibility(View.GONE);
        linearL.setVisibility(View.GONE);
        predict.setVisibility(View.GONE);
        bText.setVisibility(View.VISIBLE);
        selectBtn.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            brainImage.setImageURI(data.getData());

            Uri uri = data.getData();

            try {
                img= MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}