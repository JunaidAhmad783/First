package com.example.firstproject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.example.firstproject.Activity.MainActivity;
import com.example.firstproject.Models.User;
import com.example.firstproject.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;
import io.paperdb.Paper;

public class Successfullylogin extends AppCompatActivity {
EditText name,email;
CircleImageView profile;
Button logout;
    private DatabaseReference mDatabase;
// ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfullylogin);
        Paper.init(getApplicationContext());
        mDatabase = FirebaseDatabase.getInstance().getReference();
        profile=findViewById(R.id.profile_image);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        logout=findViewById(R.id.logout);
        User  user1=Paper.book().read("user");
        name.setText(user1.getUsername());
        email.setText(user1.getEmail());
        Glide.with(this).load(user1.getUrl()).into(profile);

       /* GoogleSignInAccount googleSignInAccount= GoogleSignIn.getLastSignedInAccount(this);
        name.setText(googleSignInAccount.getDisplayName());
        email.setText(googleSignInAccount.getEmail());

        Glide.with(this).load(googleSignInAccount.getPhotoUrl()).into(profile);
        writeNewUser(name.getText().toString(),email.getText().toString(),googleSignInAccount.getPhotoUrl().toString());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });*/
    }
    public void writeNewUser(String name, String email, String Url) {
        User user = new User(name, email,Url);

        mDatabase.child("users").setValue(user);
    }
}