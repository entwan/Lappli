package com.example.lappli.layoutFromJava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lappli.R;
import com.example.lappli.utils.Intentation;

public class LinearFromJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Noter que pour les quatres exemples de layout construit depuis le Java nous utilisons le même layout
        // Dans lequel nous peuplons le même constraintLayout à chaque fois.
        setContentView(R.layout.activity_linear_from_java);

        // Appel de la méthode pour afficher le titre dans l'activité courante (this)
        Intentation.Titre(this);

        setLinear();
    }

    private void setLinear() {
        // Création d'un nouveau LinearLayout dans notre activté
        LinearLayout llayout = new LinearLayout(this);
        // Parza
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        // On ajuste la postion des éléments avec gravity
        llayout.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        // On crée un TextView
        TextView tv = new TextView(this);
        // On crée des contraintes qui pourront être utilisés pour plusieurs TextView
        LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        // On lui assigne son texte
        tv.setText("Création du Layout depuis le Java.");
        // Association des paramètres au textView
        tv.setLayoutParams(lpView);
        // Ajout du TextView au layout
        llayout.addView(tv);
        // Application des modifications au layout en question
        setContentView(llayout);
    }

}