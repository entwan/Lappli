package com.example.lappli.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lappli.R;

public class ListView_1_item extends AppCompatActivity {

    public ListView myListView;

//    /** Méthode 1 un tableau dans le Java **/
//    private String[] stagiaires = new String[]{
//            "Paul","Malika",
//            "Suzanne","Yann","Charles","Achille","Tarak","Patrice","Sadrak","Dominique",
//            "Michael","Rattelise","François","Luc"
//    };

    public void AffichageDuListView(){
        //Le lien entre design et vue
        myListView = (ListView) findViewById(R.id.my_listView_1_item);
        /** Méthode 2 insertion du tableau depuis un fichier string xml **/
        // Récupération des données du tableau du fichier dossier string et initialisation dans un tableau local
        String[] listeDesStagairesDepuisValuesString = getResources().getStringArray(R.array.liste_stagiaires_array);
        // Définition du l'adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                // Le contexte     La mise en forme utilisée              Les données à afficher
                this, android.R.layout.simple_list_item_1, listeDesStagairesDepuisValuesString);
        // Aassociation de la ListeView à l'array
        myListView.setAdapter(adapter);
        // Création du onItemClickListener
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Récupération de la valeur de l'item cliqué
                String valeurItem = (String) myListView.getItemAtPosition(position);
                // Insertion d'un Toast lors du clic
                Toast.makeText(getApplicationContext(), "Le stagiaire sélectionné est "+valeurItem,
                        Toast.LENGTH_LONG).show();
                // Autre méthode Toast on récupère les données du TextView qui est utilisé pour l'afficahge du texte
                // Toast.makeText(getApplicationContext(), "Vous avez choisi " + stagiaires.toString(),
                // Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_view_1_item);
            AffichageDuListView();
    }
}

