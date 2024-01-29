package com.example.hdp.Login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.hdp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class RegistrationActivity extends AppCompatActivity {

    ImageView userPhoto;
    static int PreReqCode = 1;
    static int REQUESCODE = 1;
    Uri pickedImgUri;

    EditText userFullName, userEmail, userPassword, userConfirmPassword,userPhone;
    Button registerBtn;
    ProgressBar loadingProgress;
    TextView backtologin;

    FirebaseFirestore fStore;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

backtologin=findViewById(R.id.alreadyText);
        userFullName = findViewById(R.id.edit_text_fullname);
        userEmail = findViewById(R.id.edit_text_email);
        userPassword = findViewById(R.id.edit_text_password);
        userConfirmPassword = findViewById(R.id.edit_text_confirm_password);
        registerBtn = findViewById(R.id.btn_register);
        userPhone = findViewById(R.id.edit_text_phone);


        loadingProgress = findViewById(R.id.regProgressBar);
        loadingProgress.setVisibility(View.INVISIBLE);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadingProgress.setVisibility(View.VISIBLE);
                final String email = userEmail.getText().toString();
                final String password = userPassword.getText().toString();
                final String password2 = userConfirmPassword.getText().toString();
                final String name = userFullName.getText().toString();
                final String image = userPhoto.getDrawable().toString();
                final String phone = userPhone.getText().toString();

                if (image.isEmpty() || email.isEmpty() || name.isEmpty() || password.isEmpty() || !password.equals(password2)|| phone.isEmpty() ){


                    // something goes wrong : all fields must be filled
                    // we need to display an error message
                    showMessage("Please Verify all fields");
                    loadingProgress.setVisibility(View.INVISIBLE);

                } else {
                    // everything is ok and all fields are filled now we can start creating user account
                    // CreateUserAccount method will try to create the user if the email is valid

                    CreateUserAccount(email, name, password,phone);
                }
            }
        });

        userPhoto = findViewById(R.id.regUserPhoto);
        userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 22) {
                    checkAndReqForPermission();
                } else {
                    openGalery();
                }
            }
        });

    }

    private void CreateUserAccount(String email, String name, String password,String phone) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // user account created successfully
                            showMessage("Account created");
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("user_profile").document(userID);

                            Map<String, Object> user = new HashMap<>();
                            user.put("Name", name);
                            user.put("Email", email);
                            user.put("Password", password);
                            user.put("Phone Number",phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    showMessage("Register Complete");
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });
                            // after we created user account we need to update his profile picture and name
                            //check user photo is picked or not
                            if (pickedImgUri != null) {
                                updateUserInfo(name, pickedImgUri, mAuth.getCurrentUser());

                            } else {
                                updateUserInfoWithoutPhoto(name, mAuth.getCurrentUser());
                            }
                        } else {
                            // account creation failed
                            showMessage("account creation failed" + task.getException().getMessage());
                            loadingProgress.setVisibility(View.INVISIBLE);

                        }
                    }
                });
    }


    private void updateUserInfo(String name, Uri pickedImgUri, FirebaseUser currentUser) {
        // first we need to upload user photo to firebase storage and get url

        StorageReference mStorage = FirebaseStorage.getInstance().getReference().child("users_photos");
        final StorageReference imageFilePath = mStorage.child(pickedImgUri.getLastPathSegment());
        imageFilePath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                // image uploaded succesfully
                // now we can get our image url

                imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        // uri contain user image url
                        UserProfileChangeRequest profleUpdate = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name)
                                .setPhotoUri(uri)
                                .build();

                        currentUser.updateProfile(profleUpdate)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        if (task.isSuccessful()) {
                                            // user info updated successfully
                                            showMessage("Register Complete");

                                            startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                                            finish();
                                        }

                                    }
                                });

                    }
                });
            }
        });
    }


    //without image

    private void updateUserInfoWithoutPhoto(String name, FirebaseUser currentUser) {
        // first we need to upload user photo to firebase storage and get url

        UserProfileChangeRequest profleUpdate = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build();

        currentUser.updateProfile(profleUpdate)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            // user info updated successfully
                            showMessage("Register Complete");

                            startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                            finish();
                        }
                    }
                });

    }




    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private void openGalery() {
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, REQUESCODE);

    }

    private void checkAndReqForPermission() {
        if (ContextCompat.checkSelfPermission(RegistrationActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(RegistrationActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(RegistrationActivity.this, "Please accept for required permission", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(RegistrationActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PreReqCode);
            }
        } else {
            openGalery();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null) {
            // the user has successfully picked an image
            // we need to save its reference to a Uri variable
            pickedImgUri = data.getData();
            userPhoto.setImageURI(pickedImgUri);

        }

    }

    public void gotologinpage(View view) {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}