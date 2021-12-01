package com.example.lappli.layoutFromJava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lappli.R;
import com.example.lappli.utils.Intentation;

public class RelativeFromJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Noter que pour les quatres exemples de layout construit depuis le Java nous utilisons le même layout
        // Dans lequel nous peuplons le même constraintLayout à chaque fois.
        setContentView(R.layout.activity_linear_from_java);

        // Appel de la méthode pour afficher le titre dans l'activité courante (this)
        Intentation.Titre(this);

        setRelative();
    }

    @SuppressLint("ResourceType") // Permet d'ignorer les warning pour le nommage des ids
    private void setRelative(){
        // Création d'un nouveau RelativeLayout dans notre activté
        RelativeLayout rlayout = new RelativeLayout(this);

        // Création paramètres généraux que l'on pourra modifier en fonction de chaque TextView
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // Création du TewtView1
        TextView tv1 = new TextView(this);
        // Ajout de l'id
        tv1.setId(1);
        // Ajout du texte
        tv1.setText("textView1");

        // Création du TewtView1
        TextView tv2 = new TextView(this);
        // Gestion de la position
        params2.addRule(RelativeLayout.RIGHT_OF, tv1.getId());
        tv2.setId(2);
        tv2.setText("textView2");

        // Création du TewtView1
        TextView tv3 = new TextView(this);
        // Gestion de la position
        params3.addRule(RelativeLayout.BELOW, tv1.getId());
        tv3.setId(3);
        tv3.setText("textView3");

        // Création du TewtView1
        TextView tv4 = new TextView(this);
        // Gestion de la position
        params4.addRule(RelativeLayout.RIGHT_OF, tv3.getId());
        params4.addRule(RelativeLayout.ALIGN_BOTTOM, tv3.getId());
        tv4.setId(4);
        tv4.setText("textView4");

        // Associations des TextView au layout en fonction des TextView et des  paramétres généraux
        rlayout.addView(tv1, params1);
        rlayout.addView(tv2, params2);
        rlayout.addView(tv3, params3);
        rlayout.addView(tv4, params4);

        // Application des modifications au layout en question
        setContentView(rlayout);
    }
}
