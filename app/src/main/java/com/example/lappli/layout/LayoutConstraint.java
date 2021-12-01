package com.example.lappli.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.lappli.R;
import com.example.lappli.utils.Intentation;

public class LayoutConstraint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_constraint);
        // Appel de la méthode pour afficher le titre dans l'activité courante (this)
        Intentation.Titre(this);
    }
}