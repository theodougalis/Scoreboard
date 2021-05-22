package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OldGamesActivity extends AppCompatActivity
{

    private ListView gameListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_games);
        initWidgets();
        setGameAdapter();
    }

    private void setGameAdapter() {
        GameAdapter gameAdapter = new GameAdapter(getApplicationContext(),Game.gameArrayList);
        gameListView.setAdapter(gameAdapter);
    }

    private void initWidgets() {
        gameListView = findViewById(R.id.gameListView);
    }


    public void newGame(View view)
    {
        Intent newGameIntent = new Intent(this, MainActivity.class);
        startActivity(newGameIntent);
    }
}
