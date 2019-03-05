package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    //DatabaseReference register = FirebaseDatabase.getInstance().getReference().child("register");
// ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab = getSupportActionBar();
        ab.hide();

        TextView textView_link=findViewById(R.id.tv_signin);
        textView_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });


    }


    public void onClick(View v) {


        EditText first_name = findViewById(R.id.f_name);
        EditText last_name = findViewById(R.id.l_name);
        EditText usernamee = findViewById(R.id.username);
        EditText passwordd = findViewById(R.id.password);
        EditText confirm_pass = findViewById(R.id.confirm_pass);



        if (!first_name.getText().toString().equals("") && !last_name.getText().toString().equals("") &&
                !usernamee.getText().toString().equals("") && !passwordd.getText().toString().equals("") &&
                !confirm_pass.getText().toString().equals("")){
            FirebaseApp.initializeApp(this);
            FirebaseDatabase database = FirebaseDatabase.getInstance("https://edulib2-970b9.firebaseio.com");
            DatabaseReference reg = database.getReference("register");
            String f_name = first_name.getText().toString();
            String l_name= last_name.getText().toString();
            String username = usernamee.getText().toString();
            String password = passwordd.getText().toString();
            User user = new User(f_name,l_name,username,password);
            String id = reg.push().getKey();
            reg.child(id).setValue(user);
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"Lengkapi Form Dahulu!",Toast.LENGTH_LONG).show();
        }


    }

}
