package com.example.lappli.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lappli.R;
import com.example.lappli.utils.Intentation;

public class LayoutRelative extends AppCompatActivity {

    /** Méthode pour la gestion de l'affichage des Toasts lors du clic sur les textViews **/
    public void tv_Clic(View view) {
        // On crée une variable de type TextView qui prend comme valeur le TextView cliqué
        TextView textView_presse = (TextView) view;
        // On récupère son Tag
        String texteDuToast = textView_presse.getTag().toString();
        // On affiche le Tag dans le Toast
        Toast.makeText(this, "Vous avez cliqué sur "+ texteDuToast, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_relative);

        // Appel de la méthode pour afficher le titre dans l'activité courante (this)
        Intentation.Titre(this);
    }
}