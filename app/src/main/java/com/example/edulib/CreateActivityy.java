package com.example.edulib;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CreateActivityy extends AppCompatActivity {

    TextView judul, author, isi;
    Button postbutton;
    SQLite sql;
    Context context = this;
    ImageView tanggal, jam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createe);

        judul = findViewById(R.id.title_edit);
        isi = findViewById(R.id.desc_edit);
        tanggal = findViewById(R.id.tanggal);
        jam = findViewById(R.id.jam);

        sql = new SQLite(this);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        final Spinner spinner = findViewById(R.id.spinner);
        String[] dropdown = new String[]{"Sangat Penting", "Penting", "Normal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dropdown);
        spinner.setAdapter(adapter);


        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView tanggalB = findViewById(R.id.tanggalB);
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        tanggalB.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
                    }
                }, year,month,day);
                dialog.getWindow();
                dialog.show();
            }
        });

        jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView jamB =findViewById(R.id.jamB);
                Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR_OF_DAY);
                int mMinute = c.get((Calendar.MINUTE));
                int mSecond = c.get((Calendar.SECOND));

                final TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        jamB.setText(String.valueOf(hourOfDay) +":"+String.valueOf(minute) );
                    }
                }, mHour,mMinute,true);
                timePickerDialog.show();
            }
        });

        postbutton = findViewById(R.id.postbutton);
        //final String finalPrioritas = prioritas;
        postbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pengingatmodel art = new Pengingatmodel();
                String prior= spinner.getSelectedItem().toString();
                String prioritas = "";
                if (prior.equals("Sangat Penting")){
                    prioritas = "Sangat Penting";
                    art.setPriority(prioritas);
                }
                else if (prior.equals("Penting")){
                    prioritas = "Penting";
                    art.setPriority(prioritas);
                }
                else if (prior.equals("Normal")){
                    prioritas = "Normal";
                    art.setPriority(prioritas);
                }


                final TextView tanggalB = findViewById(R.id.tanggalB);
                final TextView jamB =findViewById(R.id.jamB);
                art.setTitle(judul.getText().toString());
                art.setTanggal(tanggalB.getText().toString());
                art.setJam(jamB.getText().toString());
                art.setDesc(isi.getText().toString());
                sql.tambahKegiatan(art);
                Intent intent= new Intent(getApplicationContext(), DashboardPengingat.class);
                startActivity(intent);
                Toast.makeText(CreateActivityy.this, "Pengingat Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void berandaClick(View view) {
        Intent intent= new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
    }

    public void materiClick(View view) {
        Intent intent= new Intent(getApplicationContext(), Materi.class);
        startActivity(intent);
    }

    public void diskusiClick(View view) {
        Intent intent= new Intent(getApplicationContext(), Diskusi.class);
        startActivity(intent);
    }


}
