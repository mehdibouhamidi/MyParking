package com.example.myparking.userlogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.SharedPreferences.Editor;

public class SaveSharedPreference {
    static final String PREF_USER_Name="username";

    static SharedPreferences getSharedPreferences(Context ctx){
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }
    public static void setUserName(Context ctx ,String userName){
        Editor editor =getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_Name,userName);
        editor.commit();
    }
    public static String getUserName(Context ctx){
        return getSharedPreferences(ctx).getString(PREF_USER_Name,"");
    }
}
