package com.example.edulib;

import android.content.Context;
import android.hardware.input.InputManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ChatRoom extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference ref;
    private String room;
    List<Chat>chatList = new ArrayList<>();

    ListView listView;
    TextView pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        room = getIntent().getStringExtra("room-name").toString();
        pesan = findViewById(R.id.edChat);

        //SetTitle
        getSupportActionBar().setTitle(room);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.listChat);

        ChatAdapter chatAdapter = new ChatAdapter(chatList,ChatRoom.this);
        mAuth = FirebaseAuth.getInstance();
        listView.setAdapter(chatAdapter);
        ref = FirebaseDatabase.getInstance().getReference().child("chat").child(room);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                append(dataSnapshot);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        pesan.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == event.ACTION_DOWN){
                    if (keyCode==event.KEYCODE_ENTER){
                        kirimPesan();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public void send(View view){
        kirimPesan();
    }

    public void kirimPesan(){
        if (boleh()){
            Map<String, Object> map = new HashMap<>();
            String temp_key = ref.push().getKey();

            ref.updateChildren(map);
            DatabaseReference msg_root = ref.child(temp_key);

            Map<String,Object> map2 = new HashMap<>();
            map2.put("id",mAuth.getUid());
            map2.put("pesan",pesan.getText().toString());
            map2.put("DisplayName",mAuth.getCurrentUser().getDisplayName());

            msg_root.updateChildren(map2);

        }
        closeKEyboard();

    }

    private void closeKEyboard(){
        View view = this.getCurrentFocus();
        if (view!=null){
            pesan.setText("");
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    public boolean boleh(){
        if (pesan.getText().toString().equals("")){
            return false;
        }
        int count=0;
        for (int i = 0; i < pesan.getText().length(); i++) {
            if (pesan.getText().charAt(i)==' '){
                count++;
            }
        }
        if (count==pesan.getText().length()){
            return false;
        }
        return true;
    }

    String isiPesan,who, id;
    public void append(DataSnapshot dataSnapshot){
        Log.d("DATABASE",dataSnapshot.getKey()+"===="+dataSnapshot.getValue());
        Iterator i = dataSnapshot.getChildren().iterator();
        while(i.hasNext()){
            who = ((DataSnapshot) i.next()).getValue().toString();
            id = ((DataSnapshot) i.next()).getValue().toString();
            isiPesan = ((DataSnapshot) i.next()).getValue().toString();
            if (id.equals(mAuth.getUid())){
                ChatAdapter adapter = new ChatAdapter(chatList, getApplicationContext());
                listView.setAdapter(adapter);

                Chat chat = new Chat(who,isiPesan,true);
                chatList.add(chat);
            }else{
                ChatAdapter adapter = new ChatAdapter(chatList, getApplicationContext());
                listView.setAdapter(adapter);

                Chat chat = new Chat(who,isiPesan,false);
                chatList.add(chat);
            }
        }
    }
}
