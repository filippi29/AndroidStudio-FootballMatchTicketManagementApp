package com.example.septemvris_2023lisi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GameList gList = new GameList();
        gList.addGame(new Game("Hearts - PAOK", 18000, 2500));
        gList.addGame(new Game("Olympiakos - Cukaricki", 23000, 10000));
        gList.addGame(new Game("Antwerp - AEK", 19500, 6500));
        gList.addGame(new Game("Braga - Panathinaikos", 29800, 12000));

        TextView tx = (TextView) findViewById(R.id.textView);    //δημιουργω αντικειμενο textview
        tx.setText(gList.gamesList.get(0).getTeams());

        Button btnRandom = (Button) findViewById(R.id.btn_random);   //δημιουργω αντικειμενο btn
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //οτι γράψω εδω μέσα το κάνει το κουμπί όταν το πατήσω

                Random rnd = new java.util.Random();   //δημιουργώ αντικείμενο random
                Integer randomNum =0;                 //κανω ιντ για να βαζω τον τυχχαιο αριθμο

                randomNum = rnd.nextInt(gList.gamesList.size());  //βαζει μεσα τυχαιο αριθμο ΜΕΧΡΙ ΚΑΙ ΟΡΙΟ size
                tx.setText(gList.gamesList.get(randomNum).getTeams());  //εμφανιζει


            }
        });

        //για το άλλο κουμπι
        Button btnShow = (Button) findViewById(R.id.btn_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keimeno = (String) tx.getText();  //metavliti gia na PAREI to keimeno to TextView
                Toast.makeText(MainActivity.this, "The ammount of tickets is " + gList.calculateTickets(keimeno), Toast.LENGTH_LONG).show();
            }
        });


    }


}