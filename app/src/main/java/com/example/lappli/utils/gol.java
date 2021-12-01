package com.example.lappli.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class gol {
    public static void addLog(Activity activity, String message){
        // Permet  d'afficher le nom de la classe courante, le message que vous voulez voir s'afficher
        Log.i(activity.getClass().getSimpleName(), message);
    }
}
