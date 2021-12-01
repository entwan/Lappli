package com.example.lappli.media;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import com.example.lappli.R;

import java.util.Timer;
import java.util.TimerTask;

public class Audio_Control extends AppCompatActivity {

    public void reception(){
        Intent intent = getIntent();
        String titre = intent.getStringExtra("Titre");
        // On change le titre de l'activité
        setTitle(titre);
    }

    /**  Création du mediaplayer dans le main pour qu'il soit global **/
    MediaPlayer mediaPlayer;

     /** Méthode pour lancer la chanson Play **/
    public void Play(View view){
        mediaPlayer.start();
    }
     /** Méthode pour arréter la lecture Stop **/
    public void Pause(View view){
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_audio_control);

        reception();

        /** On associe notre mediaplayer au titre que l'on veut jouer
                                  dans l'app (contexte) avec le lien vers notre fichier **/
        mediaPlayer = MediaPlayer.create(this, R.raw.mp_audio_uptown_funk);

        /*********** Gestion du Volume *******/
        // On associe la vue au code
        SeekBar controleDuVolume = (SeekBar) findViewById(R.id.seekBar_Volume);
        // Initialisation du manager en tant que service ne pas oublier le cast
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Définition du volumeMax en fonction du terminal utilisé
        int maxVolumeDuTerminal = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // On définit le volume maximum de notre seekBar en fonction du volume max du terminal
        controleDuVolume.setMax(maxVolumeDuTerminal);

        // Définition du volume courant (celui qui est réglé dans le terminal au moment ou se lance l'app)
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        // On positionne le curseur de la seekbar en fonction du volume du terminal
        controleDuVolume.setProgress(currentVolume);

        // On ajoute un listener sur la seekBar
        controleDuVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Quand il ya un changement dans la position du curseur de la seekBar
                Log.i("TAG onProgressChanged: ", Integer.toString(progress));
                // Association de la position du curseur de la seekBar en fonction du volume du terminal
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Utiliser quand l'utilisateur commence à toucher la seekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Utiliser quand l'utilisateur relache la seekBar
            }
        });

        /********** Gestion de la postion dans le morceau de musique ****/
        // On associe la vue au code
        SeekBar controleDeLaPosition = (SeekBar) findViewById(R.id.seekBar_Position);
        // Définition de la valeur Max de la durée de la chanson
        controleDeLaPosition.setMax(mediaPlayer.getDuration());

        // De la même façon que pour le volume on ajoute un listener
        controleDeLaPosition.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("TAG position : ", Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // On met en pause le morceau lorsque l'on touche la seekBar pour éviter d'entendre
                // le son lorsque l'on déplace le curseur
                Pause(controleDeLaPosition);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // On relance la lecture lorsque l'on relache le curseur
                Play(controleDeLaPosition);
                // On récupère la position lors du relachement pour éviter un effet d'echo lors de l'écoute
                mediaPlayer.seekTo(controleDeLaPosition.getProgress());
            }
        });

        // On ajoute un timer pour suivre le déplacement du curseur en fonction de la lecture
        new Timer().scheduleAtFixedRate(new TimerTask() {
            // La routine à exécuter
            @Override
            public void run() {
                // On veut faire bouger le curseur de la seekBar position en fonction de l'emplacement dans le morceau
                controleDeLaPosition.setProgress(mediaPlayer.getCurrentPosition());
            }
            // On ajoute un délai (delay) pour décaler le départ de la routine, ici dès le début 0
        }, 0,
                // l'intervalle de rafraîchissemnt ici 1/3 de seconde (~300 millis)
                300);
        }

}