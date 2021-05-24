package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class ActiveGameActivity extends AppCompatActivity {

    private ConstraintLayout parent2;
    private TextView txtTitle, txtScore1, txtScore2, txtTeam1, txtTeam2;
    private EditText edtScore1, edtScore2;
    private Button btnEditScores, btnFinish;
    private int score1, score2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_game);

        //Getting the user's inputs from Main Activity to this one
        Bundle bundle = getIntent().getExtras();
        initializeViews();
        txtTitle.setText(bundle.getString("edtGameTitle"));
        txtTeam1.setText(bundle.getString("edtTeamAName") + ":");
        txtTeam2.setText(bundle.getString("edtTeamBName") + ":");
        score1=0;
        score2=0;

        btnEditScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editScores();
                //Hide the keyboard
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishSnackbar();
            }
        });


    }


    //Warn the user that he is about to save the game and save it if he presses Save and Exit, go back to main activity
    private void finishSnackbar(){
        Snackbar.make(parent2 , "This game will be saved to be shown only and not editable.", Snackbar.LENGTH_INDEFINITE)
                .setAction("Save and Exit", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO save game in the database
                    }
                }).show();
    }

    //Edit scores if the input is valid
    private void editScores(){

        //Make sure that if "-" exists in input, it's only once and the first character
        if (edtScore1.getText().toString().lastIndexOf("-")!=edtScore1.getText().toString().indexOf("-") || (edtScore1.getText().toString().lastIndexOf("-")==edtScore1.getText().toString().indexOf("-") && edtScore1.getText().toString().indexOf("-")!=0 && edtScore1.getText().toString().indexOf("-")!=-1)){
            edtScore1.setText("");
        }
        if (edtScore2.getText().toString().lastIndexOf("-")!=edtScore2.getText().toString().indexOf("-") || (edtScore2.getText().toString().lastIndexOf("-")==edtScore2.getText().toString().indexOf("-") && edtScore2.getText().toString().indexOf("-")!=0 && edtScore2.getText().toString().indexOf("-")!=-1)){
            edtScore2.setText("");
        }
        //Make sure tha input is not blank or just "-"
        if (!edtScore1.getText().toString().equals("") && !edtScore1.getText().toString().equals("-")){
            score1+=Integer.parseInt(edtScore1.getText().toString());
            txtScore1.setText(String.valueOf(score1));
        }
        if (!edtScore2.getText().toString().equals("") && !edtScore2.getText().toString().equals("-")){
            score2+=Integer.parseInt(edtScore2.getText().toString());
            txtScore2.setText(String.valueOf(score2));
        }
        edtScore1.setText("");
        edtScore2.setText("");
    }

    //Initialize all the views needed
    private void initializeViews(){

        parent2 = findViewById(R.id.parent2);

        txtTitle = findViewById(R.id.txtTitle);
        txtScore1 = findViewById(R.id.txtScore1);
        txtScore2 = findViewById(R.id.txtScore2);
        txtTeam1 = findViewById(R.id.txtTeam1);
        txtTeam2 = findViewById(R.id.txtTeam2);

        edtScore1 = findViewById(R.id.edtScore1);
        edtScore2 = findViewById(R.id.edtScore2);

        btnEditScores = findViewById(R.id.btnEditScores);
        btnFinish = findViewById(R.id.btnFinish);

        txtScore1.setText("0");
        txtScore2.setText("0");

    }
}