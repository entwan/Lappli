package com.example.lappli.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lappli.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Widgets_Spinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
                                                        // Implementatation de AdapterView.OnItemSelectedListener pour l'ajout
                                                        // automatique du CallBack (voir en bas de la méthode spinnerJavaJava)
    // Gestion du spinner
    public void spinnerXmlJava() {
        // Création du lien entre la vue et le code
        Spinner spinnerXmlJava = (Spinner) findViewById(R.id.spinner_Xml_Java);
        // Récupération des données du tableau du fichier dossier string et initialisation dans un tableau local
        String[] listeDesViewsDepuisValuesString = getResources().getStringArray(R.array.liste_views_array);
        // Création de l'adapter                                                 le contexte -            le modèle          - les données
        ArrayAdapter<String> adapterPourListeValueString = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listeDesViewsDepuisValuesString);
        // Association de l'adapter à notre spinner
        spinnerXmlJava.setAdapter(adapterPourListeValueString);

        // Ajout du listener en s'appuyant sur l'implémentation AdapterView.OnItemSelectedListener
        // directement ajouter à la classe de l'activité
        spinnerXmlJava.setOnItemSelectedListener(this);
    }

    // Création du tableau qui va peupler le spinnerJavaJava
    String[] listeDesViewsLocal = { "ListView_1_item simple 1 item",
            "ListeView simple Plusieurs Item", "Recycle_View"};
    private void spinnerJavaJava(){
        // Lien entre le code et la vue spinner
        Spinner spinnerJavaJava = (Spinner) findViewById(R.id.spinner_Java_Java);
        // Instanciation du ArrayAdapter pour l'affichage des données du tableau listeView
        ArrayAdapter<String> adapterPourListeLocal = new ArrayAdapter<String>(
             // le contexte             le modèle                   les données
                this, android.R.layout.simple_list_item_1, listeDesViewsLocal);
        // Ajout du layout simple à chaque élément (item) du spinner
        adapterPourListeLocal.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        // Association des données de l'Array (listeView) résupérer dans l'Adapter
        // (adapterPourListeLocal) au spinner (spinnerJavaJava)
        spinnerJavaJava.setAdapter(adapterPourListeLocal);
        // Ajout du listener en s'appuyant sur l'implémentation AdapterView.OnItemSelectedListener
        // directement ajouter à la classe de l'activité
        spinnerJavaJava.setOnItemSelectedListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_spinner);

        spinnerXmlJava();

        spinnerJavaJava();

    }

    // Le callback de l'AdapterView.OnItemClickListener pour qu'il soit valable sur tout les spinners
    // Déclaration du Toast en dehors des méthodes pour l'utilisé quand il se passe et quand il ne se passe rien
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Ici on ajoute un Toast mais on peut très bien y ajouter la gestion des Intent via un switch
        // On affiche le nom du spinner et la valeur sélectionner dans un Toast
        final Toast myToast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
        switch(parent.getId()){
            case R.id.spinner_Xml_Java:
                myToast.setText("Spinner XML & Java "+listeDesViewsLocal[position]);
                myToast.show();
                break;
            case R.id.spinner_Java_Java:
                myToast.setText("Spinner only Java "+listeDesViewsLocal[position]);
                myToast.show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Quelle action effectuer s'il ne se passe rien
        final Toast myToast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
        myToast.cancel();
    }
}


