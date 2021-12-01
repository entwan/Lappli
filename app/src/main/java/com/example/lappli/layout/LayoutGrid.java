package com.example.lappli.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lappli.R;
import com.example.lappli.utils.Intentation;

public class LayoutGrid extends AppCompatActivity {

    public void PlaySound(View v){
        // On crée une variable de type Button à partir du bouton cliqué
        Button bouton_presse = (Button) v;
        // On récupére le Tag et on le transforme en String
        String phrase = bouton_presse.getTag().toString();
        // On affiche un log pour la vérification
        Log.i("PlaySound: ", phrase);

        // Initialisation de la classe MediaPlayer
        // Normalement on initialise le média player de cette façon :
        // MediaPlayer mediaPlayer = MediaPlayer.create(R.id.NomId);
        // Mais comme on utilise le Tag comme point d'accroche
        MediaPlayer mediaPlayer = MediaPlayer.create(this,
                getResources().getIdentifier(phrase, "raw", getPackageName()));
        // On lance le mediaplayer
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_grid);

        // Appel de la méthode pour afficher le titre dans l'activité courante (this)
        Intentation.Titre(this);
    }
}