package com.example.edulib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SoalAdapter extends RecyclerView.Adapter<SoalAdapter.ViewHolder> {

    private RecyclerView rvSoal;
    private Context context;
    private List<SoalModel> sList;
    private SoalModel sm;
    private ArrayList<String> jawaban = new ArrayList<>();
    private int noSoal = 0;
    private String KJ;

    public SoalAdapter(RecyclerView rvSoal, Context context, List<SoalModel> sList) {
        this.rvSoal = rvSoal;
        this.context = context;
        this.sList = sList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_soal, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SoalModel sm = sList.get(i);
        viewHolder.bindTo(sm);
    }

    @Override
    public int getItemCount() {
        return sList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivSoal;
        TextView tvJurusan, tvSoal;
        Button button_next;
        RadioButton rbA, rbB, rbC, rbD, rbSkip;
        RadioGroup rbAns;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivSoal = itemView.findViewById(R.id.ivSoal);
            tvJurusan = itemView.findViewById(R.id.tvJurusan);
            tvSoal = itemView.findViewById(R.id.tvSoal);
            button_next = itemView.findViewById(R.id.button_next);
            rbA = itemView.findViewById(R.id.rbA);
            rbB = itemView.findViewById(R.id.rbB);
            rbC = itemView.findViewById(R.id.rbC);
            rbD = itemView.findViewById(R.id.rbD);
            rbSkip = itemView.findViewById(R.id.rbSkip);
            rbAns = itemView.findViewById(R.id.rbAns);

            rbAns.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.rbA :
                            jawaban.add("A");
                            break;
                        case R.id.rbB :
                            jawaban.add("B");
                            break;
                        case R.id.rbC :
                            jawaban.add("C");
                            break;
                        case R.id.rbD :
                            jawaban.add("D");
                            break;
                        default :
                            jawaban.add("Nyerah");
                            break;
                    }
                }
            });

            button_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(jawaban.isEmpty()) {
                        Toast.makeText(context,"Pilih Jawaban!",Toast.LENGTH_SHORT)
                                .show();
                        return;
                    }



                    FirebaseDatabase.getInstance().getReference("skor")
                            .child(tvJurusan.getText().toString())
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child(String.valueOf(noSoal))
                            .setValue(jawaban.get(getAdapterPosition()).toUpperCase().equals(KJ.toUpperCase())?"1":"0");
                    noSoal++;

                    if(getAdapterPosition() == sList.size() - 1) {
                        Intent i = new Intent(new Intent(v.getContext(),SkorActivity.class));
                        i.putExtra("jurusan",tvJurusan.getText().toString());
                        v.getContext().startActivity(i);
                        ((Activity)context).finish();
                    } else {
                        rvSoal.scrollToPosition(getAdapterPosition()+1);
                    }
                }
            });
        }

        void bindTo(SoalModel sm) {
            tvJurusan.setText(sm.getJurusan());
            tvSoal.setText(sm.getTextSoal());
            rbA.setText(sm.getOpsiA());
            rbB.setText(sm.getOpsiB());
            rbC.setText(sm.getOpsiC());
            rbD.setText(sm.getOpsiD());

            KJ = sm.getKunciJawaban();

            if(sm.getImagepath().equals("null")) {
                ivSoal.setVisibility(View.GONE);
            } else {
                Picasso.with(context).load(sm.getImagepath()).into(ivSoal);
            }
        }
    }
}
