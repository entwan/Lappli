package com.example.lappli.media;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.example.lappli.R;
import com.example.lappli.utils.Intentation;

public class Audio_Auto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_audio_auto);

        Intentation.Titre(this);

        // Création du médiaplayer            dans l'app (contexte) avec le lien vers notre chanson
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.mp_audio_uptown_funk);
        // Lancement du mediaplayer
        mediaPlayer.start();



    }
}