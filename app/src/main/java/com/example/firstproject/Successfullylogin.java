package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

public class Successfullylogin extends AppCompatActivity {
EditText name,email;
CircleImageView profile;
Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfullylogin);
        profile=findViewById(R.id.profile_image);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        logout=findViewById(R.id.logout);
        GoogleSignInAccount googleSignInAccount= GoogleSignIn.getLastSignedInAccount(this);
        name.setText(googleSignInAccount.getDisplayName());
        email.setText(googleSignInAccount.getEmail());
        Glide.with(this).load(googleSignInAccount.getPhotoUrl()).into(profile);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }
}