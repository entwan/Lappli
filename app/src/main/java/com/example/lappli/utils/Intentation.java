package com.example.lappli.utils;

import android.app.Activity;
import android.content.Intent;

public class Intentation {
    public static void Titre(Activity activity) {
        Intent intent = activity.getIntent();
        String titre = intent.getStringExtra("Intentation");
        // On change le titre de l'activité
        activity.setTitle(titre);
    }
}
