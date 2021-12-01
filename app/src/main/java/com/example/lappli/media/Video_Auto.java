package com.example.lappli.media;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import com.example.lappli.R;

public class Video_Auto extends AppCompatActivity {

    public void reception(){
        Intent intent = getIntent();
        String titre = intent.getStringExtra("Intentation");
        // On change le titre de l'activité
        setTitle(titre);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_video_auto);

        reception();

        // ********* Lecture automatique au on Create de l'activité
        // On lie le design et le code
        VideoView videoView_Auto =  (VideoView) findViewById(R.id.videoView_Auto);
        // On ajoute le chemin vers la vidéo
        //                  le dossier racine   + le package source + le dossier + le nom de la vidéo
        String uriPath = ("android.resource://" + getPackageName() + "/raw/" + R.raw.mp_video_ts_drunk);
        Uri uri = Uri.parse(uriPath);
        videoView_Auto.setVideoURI(uri);
        // On lance simplement la vidéo
        videoView_Auto.start();

    }
}