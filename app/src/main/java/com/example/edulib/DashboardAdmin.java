package com.example.edulib;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);
        ActionBar ab = getSupportActionBar();
        ab.hide();
<<<<<<< Updated upstream
    }

    public void saran(View view){
        startActivity(new Intent(DashboardAdmin.this, DaftarSaran.class));
=======
        mAuth = FirebaseAuth.getInstance();
        admin = findViewById(R.id.admin);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                PopupMenu menu = new PopupMenu(v.getContext(), admin);
                menu.getMenuInflater()
                        .inflate(R.menu.admin, menu.getMenu());
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.logout:
                                mAuth.signOut();
                                startActivity(new Intent(v.getContext(), LoginAs.class));
                                finish();
                                break;

                        }
                        return true;
                    }
                });
                menu.show();
            }
        });
    }

    public void daftarUser(View view){
        Intent intent = new Intent(getApplicationContext(), DaftarUser.class);
        startActivity(intent);
    }

    public void keluhan(View view) {
        Intent intent = new Intent(getApplicationContext(), Admin_Keluhan.class);
        startActivity(intent);
         }

    public void saran(View view) {
        Intent intent = new Intent(getApplicationContext(), Admin_Saran.class);
        startActivity(intent);
>>>>>>> Stashed changes
    }

    public void keluhan(View view){
        startActivity(new Intent(DashboardAdmin.this, Admin.class));
    }
}
