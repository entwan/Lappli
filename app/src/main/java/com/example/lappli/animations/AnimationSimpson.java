package com.example.lappli.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.lappli.R;

public class AnimationSimpson extends AppCompatActivity {

    public void reception() {
        Intent intent = getIntent();
        String titre = intent.getStringExtra("titreApp");
        // On change le titre de l'activité
        setTitle(titre);
    }

    // Déclartion des var
    ImageButton imageButton_Les_Simpson;
    ImageView imageView_Bart;
    ImageView imageView_Homer;

    // On fait le lien entre la vue et le code
    public void init() {
        imageButton_Les_Simpson = (ImageButton) findViewById(R.id.imageButton_Les_Simpson);
        imageView_Bart = (ImageView) findViewById(R.id.imageView_Bart);
        imageView_Homer = (ImageView) findViewById(R.id.imageView_Homer);
    }

    public void Anim(View view) {
        // On fait un fade pour faire apparaitre notre image et on la fait tourner en même temps
        imageButton_Les_Simpson.animate().alpha(0).rotation(3600).setDuration(2000);
        imageView_Bart.animate().translationXBy(-3000).setDuration(4000);
        imageView_Homer.animate().translationXBy(-3000).setDuration(5000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_simpson);
        init();
        reception();

    }
}