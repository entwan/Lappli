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

public class Grid2FromJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Noter que pour les quatres exemples de layout construit depuis le Java nous utilisons le même layout
        // Dans lequel nous peuplons le même constraintLayout à chaque fois.
        setContentView(R.layout.activity_linear_from_java);

        // Appel de la méthode pour afficher le titre dans l'activité courante (this)
        Intentation.Titre(this);

        setGrid2();
    }

    private void setGrid2(){
        GridLayout gLayout = new GridLayout(this);
        gLayout.removeAllViews();

        GridLayout.LayoutParams paramGrid = new GridLayout.LayoutParams();
        paramGrid.height = GridLayout.LayoutParams.MATCH_PARENT;
        paramGrid.width = GridLayout.LayoutParams.MATCH_PARENT;
        gLayout.setLayoutParams (paramGrid);

        int total = 10;
        int column = 2;
        int row = total / column;
        gLayout.setColumnCount(column);
        gLayout.setRowCount(row + 1);
        for(int i =0, c = 0, r = 0; i < total; i++, c++)
        {
            if(c == column)
            {
                c = 0;
                r++;
            }

//            GridLayout.LayoutParams paramTousLesBoutons = new GridLayout.LayoutParams();
//            paramTousLesBoutons.rightMargin = 5;
//            paramTousLesBoutons.topMargin = 5;
//            paramTousLesBoutons.setGravity(Gravity.FILL);
//            paramTousLesBoutons.columnSpec = GridLayout.spec(c);
//            paramTousLesBoutons.rowSpec = GridLayout.spec(r);
//
//            Button btn1 = new Button(this);
//            btn1.setText("Bouton 1");
//            Button btn2 = new Button(this);
//            btn2.setText("Bouton 2");
//            Button btn3 = new Button(this);
//            btn3.setText("Bouton 3");
//            Button btn4 = new Button(this);
//            btn4.setText("Bouton 4");
//            Button btn5 = new Button(this);
//            btn5.setText("Bouton 5");
//            Button btn6 = new Button(this);
//            btn6.setText("Bouton 6");
//            Button btn7 = new Button(this);
//            btn7.setText("Bouton 7");
//            Button btn8 = new Button(this);
//            btn8.setText("Bouton 8");
//
//            gLayout.addView(btn1, paramTousLesBoutons);
//            gLayout.addView(btn2, paramTousLesBoutons);
//            gLayout.addView(btn3, paramTousLesBoutons);
//            gLayout.addView(btn4, paramTousLesBoutons);
//            gLayout.addView(btn5, paramTousLesBoutons);
//            gLayout.addView(btn6, paramTousLesBoutons);
//            gLayout.addView(btn7, paramTousLesBoutons);
//            gLayout.addView(btn8, paramTousLesBoutons);

            setContentView(gLayout);
        }

    }

}
