package com.example.lappli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lappli.utils.gol;

import static com.example.lappli.utils.gol.addLog;

public class Accueil extends AppCompatActivity  {

    Class destination;

    private static final String TAG = "Accueil";
    
    // Déclaration des Variables de la classe
    String TAG_btn = "Bouton pressé "; // Variables des TAG des logs
    // NB Toutes les variables des éléments n'ont pas besoin d'êter déclarées car elles le sont
    // automatiquement dans la méthode onClick

    // le texte de l'item sélectionné pour le passé au titre de l'activité qu isera lancée
    String nomBoutonPourTitre;

    // Méthode onClick associer à la vue
    public void btn_Clic(View view) throws ClassNotFoundException {
        // Récupération des informations pour la gestion du clic sur les boutons
        // Quel bouton vient d'être pressé dans la vue ?
        Button boutonPresse = (Button) view;
        // Son texte pour l'affecté au titre l'activité de destination avec putExtra
        String nomBoutonPourTitre = boutonPresse.getText().toString();
        // Son tag pour créer la chaîne de caractères de la classe de destiniation
        String tagBouton = boutonPresse.getTag().toString();
        // Son Id pour l'afficher dans les log
        int idBouton = boutonPresse.getId();


        String ClasseFromTag = boutonPresse.getTag().getClass().getName();
        // Pour transformer un String en class il faut le nom complet du package donc
        String nomClasseDestination = "com.example.lappli." + tagBouton;
        // Transformation du string nomClasseDestination en classe pour l'injecter dans l'intent
        destination = Class.forName(nomClasseDestination);

        // Gestion des logs 
        addLog(this, "Les informations du bouton cliqué : ");
        addLog(this,  "Le texte : " + nomBoutonPourTitre);
        addLog(this, "L'ID : " + idBouton);
        addLog(this, "Le tag : " + tagBouton);
        addLog(this, "La classe de l'acivité de destination : " + ClasseFromTag);
        addLog(this, "La classe de l'acivité de destination : " + destination);

        Intent intent = new Intent(Accueil.this, destination);
        intent.putExtra("Intentation", nomBoutonPourTitre);
        startActivity(intent);
    }

    // Gestion de l'ouverture d'une autre app
    public void autreApp(View view){
        Button bouton_presse = (Button) view;
        Intent i;

        try {
            PackageManager packageManager = getPackageManager();
            i = packageManager.getLaunchIntentForPackage("com.dam.listes");
            Log.i(TAG, "autreApp: i : " + i);
            //i = getPackageManager().getLaunchIntentForPackage("com.dam.musicplayer");

            if (i == null)
                throw new PackageManager.NameNotFoundException();

            i.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(i);
        } catch (PackageManager.NameNotFoundException e) {
            // affiche que l'appli n'est pas présente sur le tel
            Log.i(TAG, "autreApp: " + e.toString());
        }
    }

//    // Gestion du spinner
//    Spinner spinnerXmlJava;
//    private void ControleSpinner() {
//        // Création du lien entre la vue et le code
//        spinnerXmlJava = (Spinner) findViewById(R.id.spinner_View);
//        // Définition de notre tableau local
//        String[] listeDesViewsDepuisValuesString;
//        // Récupération des données du tableau du dossier string et initialisation dans un tableau local
//        listeDesViewsDepuisValuesString = getResources().getStringArray(R.array.liste_views_array);
//        // Création de l'adapter
//        ArrayAdapter<String> adapterPourListeValueString = new ArrayAdapter<String>(
//                //le contexte -          le modèle de l'adapter        - les données
//                this, android.R.layout.simple_list_item_1, listeDesViewsDepuisValuesString);
//        // Association de l'adapter à notre spinner
//        spinnerXmlJava.setAdapter(adapterPourListeValueString);
//

//        spinnerXmlJava.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                //Toast.makeText(getApplicationContext(), spinnerXmlJava.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
//                // On récupère la valeur du spinner sélectionné et on la passe dans le switch pour l'intent
//                String choixSpinnerListeView = spinnerXmlJava.getSelectedItem().toString();
//                Log.i("TAG Choix du Listener ", choixSpinnerListeView);
//                switch (choixSpinnerListeView){
//                    case "Spinner des différents listView":
//                        break;
//                    case "ListView simple 1 Item":
//                        destination = ListView_1_item.class;
//                        nomBoutonPourTitre = "ListView simple 1 Item";
//                        break;
////                    case "ListView simple 2 Item":
////                        destination = ListView_2_item.class;
////                        text_item_to_titre = "ListView simple 2 Item";
////                        break;
//                    case "RecycleView":
//                        destination = Recycle_View.class;
//                        nomBoutonPourTitre = "Recycleview";
//                        break;
//                }
//                if (destination!=null) Intentation();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // Quelle action effectuer s'il ne se passe rien
//
//            }
//        });
//    }



    // Démarrage de l'app avec la méthode onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        setTitle("L'appli");
//        ControleSpinner();

    }

}