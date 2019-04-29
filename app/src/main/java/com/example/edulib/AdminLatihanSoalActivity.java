package com.example.edulib;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class AdminLatihanSoalActivity extends AppCompatActivity {

    private Spinner spinJurusan;
    private EditText etSoal, etA, etB, etC, etD, etKJ;
    private ImageView gambarSoal;
    private Button btnSubmit;
    private FirebaseDatabase fdb;
    private FirebaseStorage fs;
    private Uri imgUri;

    private String jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_latihan_soal);

        initFirebase();
        initViews();
        spinAdapter(spinJurusan);

        gambarSoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(i,1);
            }
        });
    }

    private void spinAdapter(Spinner spinJurusan) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getApplicationContext(),
                R.array.spinJurusan,
                android.R.layout.simple_spinner_item
                );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinJurusan.setAdapter(adapter);
        spinJurusan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jurusan = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    void initFirebase() {
        fdb = FirebaseDatabase.getInstance();
        fs = FirebaseStorage.getInstance();
    }

    void initViews() {
        spinJurusan = findViewById(R.id.spinner_jurusan);
        etSoal = findViewById(R.id.etSoal);
        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        etC = findViewById(R.id.etC);
        etD = findViewById(R.id.etD);
        etKJ = findViewById(R.id.etKJ);
        btnSubmit = findViewById(R.id.btnSubmit);
        gambarSoal = findViewById(R.id.gambar_soal);
    }

    public void submitSoal(View view) {

        if(imgUri != null) {
            final StorageReference sr = FirebaseStorage.getInstance().getReference().child("gambar-soal/" + UUID.randomUUID().toString());
            sr.putFile(imgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    sr.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            populateModel(jurusan,uri.toString());
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        } else {
            populateModel(jurusan,"null");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 1 && resultCode == RESULT_OK && data.getData() != null) {
            imgUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imgUri);
                gambarSoal.setImageBitmap(bitmap);
            } catch (IOException e) {

            }
        }
    }

    void populateModel(String jurusan, String imagepath) {

        SoalModel sm = new SoalModel(
                UUID.randomUUID().toString(),
                jurusan,
                imagepath,
                etSoal.getText().toString(),
                etA.getText().toString(),
                etB.getText().toString(),
                etC.getText().toString(),
                etD.getText().toString(),
                etKJ.getText().toString()
        );

        fdb.getReference("soal").child(sm.getJurusan()).child(sm.getSID()).setValue(sm);
        startActivity(new Intent(AdminLatihanSoalActivity.this,DashboardAdmin.class));
        finish();
    }

    public void chooseImage(View view) {
    }
}
