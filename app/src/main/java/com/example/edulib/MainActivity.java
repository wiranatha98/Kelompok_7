package com.example.edulib;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    //DatabaseReference register = FirebaseDatabase.getInstance().getReference().child("register");
// ...
    private EditText first_name;
    private EditText last_name;
    private EditText usernamee;
    private EditText passwordd;
    private EditText confirm_pass;
    private Button signUp;
    private CheckBox accept;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init()
        signUp = findViewById(R.id.login_button);
        accept = findViewById(R.id.checkBox_acc);
//        signUp.setEnabled(false);
//        signUp.setClickable(false);

        //Listener
        accept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                signUp.setClickable(isChecked);
            }

        });


        ActionBar ab = getSupportActionBar();
        ab.hide();

        TextView textView_link = findViewById(R.id.tv_signin);
        textView_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });


    }


    public void onClick(View v) {

        first_name = findViewById(R.id.f_name);
        last_name = findViewById(R.id.l_name);
        usernamee = findViewById(R.id.username);
        passwordd = findViewById(R.id.password);
        confirm_pass = findViewById(R.id.confirm_pass);


        if (!first_name.getText().toString().equals("") && !last_name.getText().toString().equals("") &&
                !usernamee.getText().toString().equals("") && !passwordd.getText().toString().equals("") &&
                !confirm_pass.getText().toString().equals("")) {
//            FirebaseApp.initializeApp(this);
//            FirebaseDatabase database = FirebaseDatabase.getInstance("https://edulib2-970b9.firebaseio.com");
//            DatabaseReference reg = database.getReference("register");
//            String f_name = first_name.getText().toString();
//            String l_name = last_name.getText().toString();
//            String username = usernamee.getText().toString();
//            String password = passwordd.getText().toString();
//            User user = new User(f_name, l_name, username, password);
//            String id = reg.push().getKey();
//            reg.child(id).setValue(user);
//            Intent intent = new Intent(this, Login.class);
//            startActivity(intent);
            mAuth = FirebaseAuth.getInstance();
            //TODO(Register) : Karena daftar itu pake email atau Google, jadi aku akalin pake email.
            mAuth.createUserWithEmailAndPassword(usernamee.getText().toString()+"@"+R.string.emailDummy,passwordd.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                FirebaseUser user = mAuth.getCurrentUser();
                                UserProfileChangeRequest changeRequest = new UserProfileChangeRequest.Builder()
                                        //TODO(Firebase) : untuk Sementara Display name aku gabungin dulu tapi ntar bisa aja dipisahin
                                        .setDisplayName(first_name.getText().toString() + last_name.getText()
                                                .toString()).build();
                                user.updateProfile(changeRequest);
                            }else{
                                Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            Toast.makeText(getApplicationContext(), "Lengkapi Form Dahulu!", Toast.LENGTH_LONG).show();
        }


    }

}
