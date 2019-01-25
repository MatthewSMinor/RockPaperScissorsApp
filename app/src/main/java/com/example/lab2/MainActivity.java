package com.example.lab2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Weapon pChoice;
    private Weapon cChoice;
    private int pWinCount;
    private int cWinCount;
    private TextView weaponView;
    private TextView resultView;
    private TextView winCountView;


    //method to pick computer choice
    private void computerPick(){
        Weapon pick;
        Random r = new Random();
        int num = r.nextInt((3 - 1) + 1) + 1;

        switch(num){
            case 1:
                pick = Weapon.ROCK;
                break;
            case 2:
                pick = Weapon.PAPER;
                break;
            default:
                pick = Weapon.SCISSORS;
                break;

        }
        cChoice = pick;

    }


    //method to see who wins
    private void whoWon(Weapon pChoice){
        computerPick();
        String roundWinner = "";
        switch(pChoice){
            case ROCK:
                if(cChoice == Weapon.ROCK){
                    resultView.setText("Tie");
                }
                else if(cChoice == Weapon.PAPER){
                    roundWinner = "Computer";
                    cWinCount++;
                    resultView.setText("Computer Wins");
                }
                else if(cChoice == Weapon.SCISSORS){
                    roundWinner = "Player";
                    pWinCount++;
                    resultView.setText("Player Wins");
                }
                break;
            case PAPER:
                if(cChoice == Weapon.PAPER){
                    resultView.setText("Tie");
                }
                else if(cChoice == Weapon.SCISSORS){
                    roundWinner = "Computer";
                    cWinCount++;
                    resultView.setText("Computer Wins");
                }
                else if(cChoice == Weapon.ROCK){
                    roundWinner = "Player";
                    pWinCount++;
                    resultView.setText("Player Wins");
                }
                break;
            default:
                if(cChoice == Weapon.SCISSORS){
                    resultView.setText("Tie");
                }
                else if(cChoice == Weapon.ROCK){
                    roundWinner = "Computer";
                    cWinCount++;
                    resultView.setText("Computer Wins");
                }
                else if(cChoice == Weapon.PAPER){
                    roundWinner = "Player";
                    pWinCount++;
                    resultView.setText("Player Wins");
                }
                break;
        }


        //change text field of pWinCount or cWinCount
        StringBuilder s = new StringBuilder();
        s.append("Player: ");s.append(pWinCount);s.append("\nComputer: ");s.append(cWinCount);
        winCountView.setText(s.toString());

        //change text field of weapon choices
        StringBuilder weaponString = new StringBuilder();
        weaponString.append("Player Weapon: "); weaponString.append(pChoice);
        weaponString.append("\nComputer Weapon: "); weaponString.append((cChoice));
        weaponView.setText(weaponString.toString());


    }


    //onclick for rock
    public void rockClick(View v){
        pChoice = Weapon.ROCK;
        whoWon(pChoice);

    }

    //onclick for paper
    public void paperClick(View v){
        pChoice = Weapon.PAPER;
        whoWon(pChoice);
    }


    //onclick for scissors
    public void scissorClick(View v){
        pChoice = Weapon.SCISSORS;
        whoWon(pChoice);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        weaponView = findViewById(R.id.weaponView);
        resultView = findViewById(R.id.resultView);
        winCountView = findViewById(R.id.winCountView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");

        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

    };
}
