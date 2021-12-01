package com.example.lappli.layoutFromJava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lappli.R;
import com.example.lappli.utils.Intentation;

public class GridFromJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Noter que pour les quatres exemples de layout construit depuis le Java nous utilisons le même layout
        // Dans lequel nous peuplons le même constraintLayout à chaque fois.
        setContentView(R.layout.activity_linear_from_java);

        // Appel de la méthode pour afficher le titre dans l'activité courante (this)
        Intentation.Titre(this);

        setGrid();
    }

    private void setGrid() {
        // Création d'un nouveau GridLayout dans notre activté
        GridLayout gLayout = new GridLayout(this);
        // Suppression de toutes les vues présentent
        gLayout.removeAllViews();
        // Création de la variable nbre_total_de_cases
        int nbre_total_de_cases = 10;
        // Création du nombre de colonnes
        int colonnes = 5;
        int row = nbre_total_de_cases / colonnes;
        // Assignation du nombre de colonnes au GridLayout
        gLayout.setColumnCount(colonnes);
        // Assignation du nombre de lignes au GridLayout avec gestion si le nombre est impair
        gLayout.setRowCount(row + 1);
        // Boucle pour afficher le nombre total de cases
        for(int i =0, c = 0, r = 0; i < nbre_total_de_cases; i++, c++)
        {
            if(c == colonnes)
            {
                c = 0;
                r++;
            }
            // Création de l'élément button qui remplira chaque case
            Button button = new Button(this);
            // Initialiasation des paramètres de LayoutParams
            GridLayout.LayoutParams param =new GridLayout.LayoutParams();
            // Paramètre de la hauteur
            param.height = GridLayout.LayoutParams.WRAP_CONTENT;
            // Paramètre de la largeur
            param.width = GridLayout.LayoutParams.WRAP_CONTENT;
            // Paramètre de la marge
            param.leftMargin = 4;
            param.rightMargin = 4;
            param.topMargin = 8;

            // Paramètre de Gravity
            param.setGravity(Gravity.CENTER);
            // Placement des paramètres en fonction de la ligne et de la colonne
            // Identique à la bataille navale ou aux échecs
            // i.e. colonne 1 ligne 2 - la première colonne//ligne est notée en 0
            param.columnSpec = GridLayout.spec(c);
            param.rowSpec = GridLayout.spec(r);

            // Association des paramètres au bouton
            button.setLayoutParams (param);
            // Ajout du bouton au layout
            gLayout.addView(button);
            // Application des modifications au layout en question
            setContentView(gLayout);
        }
    }
}