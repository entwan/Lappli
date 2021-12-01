package com.example.lappli.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.lappli.R;

public class AnimationLoading extends AppCompatActivity {

    public void reception(){
        Intent intent = getIntent();
        String titre = intent.getStringExtra("titreApp");
        // On change le titre de l'activité
        setTitle(titre);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_loading);

        reception();

        // On fait le lien entre vue et code
        ImageView imageView_Loading = (ImageView) findViewById(R.id.imageView_Loading);
        // On anime l'iamge
        // On fait un fade pour faire apparaitre notre image et on la fait tourner en même temps
        imageView_Loading.animate().alpha(1).rotation(3600).setDuration(2000);
    }
}