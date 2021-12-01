package com.example.lappli.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.lappli.R;

public class Video_Control extends AppCompatActivity {

    // Définition de la VideoView en mode globale
    private VideoView videoView_Control;

    // Variable pour le TAG des logs, raccourci logt
    private static final String TAG = "Video_Control";

    // Définition du mediaController
    private MediaController mediaController;

    // Définition de la variable pour stocker la position de la vidéo avant la rotation de l'écran
    // ou le fait qu'une autre activité prenne le focus
    private int position;

    public void reception(){
        Intent intent = getIntent();
        String titre = intent.getStringExtra("Intentation");
        // On change le titre de l'activité
        setTitle(titre);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_video_control);

        reception();

        // ********* Lecture automatique au on Create de l'activité
        // On lie le design et le code
        videoView_Control =  (VideoView) findViewById(R.id.videoView_Control);
        // On ajoute le chemin vers la vidéo
        //                  le dossier racine   + le package source + le dossier + le nom de la vidéo
        String uriPath = ("android.resource://" + getPackageName() + "/raw/" + R.raw.mp_video_ts_drunk);
        // On peux aussi utiliser directement un Url
        //String uriPath = "https://vimeo.com/262186786";

        Uri uri = Uri.parse(uriPath);
        videoView_Control.setVideoURI(uri);


        // Création d'un nouvel objet MediaController que l'on associe à notre vue (this)
        if (this.mediaController == null) {
            this.mediaController = new MediaController(Video_Control.this);
        }

        // Association à notre videoView, en l'accrochant en bas
        mediaController.setAnchorView(videoView_Control);
        // On donne l'autorisation de controler notre video au MediaController
        videoView_Control.setMediaController(mediaController);

        // Lancement automatique de la vidéo au démarrage
        videoView_Control.start();

        // Vérification de la valeur de savedInstanceState si non null alors
        // la vidéo reprend à la position avant la mise en pause
        if (savedInstanceState != null) {
            // Valorisation de l'intéger qui gère la position de la vidéo
            position = savedInstanceState.getInt("CurrentPosition");
            Log.i(TAG, "onRestoreInstanceState: " + String.valueOf(position));
            videoView_Control.seekTo(position);
        }
    }

    // Enregistrement de la position avant la mise en pause se fait dans la méthode onPause
    @Override
    protected void onPause() {
        position = videoView_Control.getCurrentPosition();
        super.onPause();
    }

    @Override
    protected void onStop() {
//        position = videoView_Control.getCurrentPosition();
        super.onStop();
    }

    // Gestion de la rotation écran
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Enregistrement de la valeur de position dans le Bundle
        outState.putInt("CurrentPosition", position);
        // La vidéo est mise en pause pendant la rotation
        videoView_Control.pause();
    }

}
