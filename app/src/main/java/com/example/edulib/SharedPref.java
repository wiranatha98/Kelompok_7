package com.example.edulib;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    SharedPreferences pref;
    SharedPreferences.Editor edit;

    public SharedPref(Context context){
        pref = context.getSharedPreferences("sharedPrefModul5",Context.MODE_PRIVATE);
    }

    public void setMode(Boolean state) {
        edit = pref.edit();
        edit.putBoolean("NightMode", state);
        edit.commit();
    }

    public void setFont(Boolean state) {
        edit = pref.edit();
        edit.putBoolean("BigFont", state);
        edit.commit();
    }

    public Boolean loadMode() {
        Boolean state = pref.getBoolean("NightMode", false);
        return state;
    }

    public Boolean loadFont() {
        Boolean state = pref.getBoolean("BigFont", false);
        return state;
    }
}
