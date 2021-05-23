package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtTitleWarning, txtANameWarning, txtBNameWarning;
    private EditText edtTeamAName, edtTeamBName, edtGameTitle;
    private Button btnStart, btnOldGames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetWarnings();
                if (checkInputs()) {

                    resetWarnings();
                    btnStart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(MainActivity.this, ActiveGameActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("edtGameTitle", edtGameTitle.getText().toString());
                            bundle.putString("edtTeamAName", edtTeamAName.getText().toString());
                            bundle.putString("edtTeamBName", edtTeamBName.getText().toString());
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });

                }
            }
        });

        btnOldGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Old Games Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void resetWarnings() {
        txtTitleWarning.setVisibility(View.GONE);
        txtANameWarning.setVisibility(View.GONE);
        txtBNameWarning.setVisibility(View.GONE);
    }

    private boolean checkInputs() {

        if (edtGameTitle.getText().toString().equals("")) {
            txtTitleWarning.setVisibility(View.VISIBLE);
            txtTitleWarning.setText("Game title needed!");
            return false;
        }

        if (edtTeamAName.getText().toString().equals("")) {
            txtANameWarning.setVisibility(View.VISIBLE);
            txtANameWarning.setText("Team A name needed!");
            return false;
        }
        if (edtTeamBName.getText().toString().equals("")) {
            txtBNameWarning.setVisibility(View.VISIBLE);
            txtBNameWarning.setText("Team B name needed!");
            return false;
        }
        if (edtTeamBName.getText().toString().equals(edtTeamAName.getText().toString())) {
            txtBNameWarning.setVisibility(View.VISIBLE);
            txtBNameWarning.setText("Teams can't have the same name!");
            return false;
        }
        return true;
    }

    private void initializeViews() {

        txtTitleWarning = findViewById(R.id.txtTitleWarning);
        txtANameWarning = findViewById(R.id.txtANameWarning);
        txtBNameWarning = findViewById(R.id.txtBNameWarning);

        edtTeamAName = findViewById(R.id.edtTeamAName);
        edtTeamBName = findViewById(R.id.edtTeamBName);
        edtGameTitle = findViewById(R.id.edtGameTitle);

        btnStart = findViewById(R.id.btnStart);
        btnOldGames = findViewById(R.id.btnOldGames);
    }
}