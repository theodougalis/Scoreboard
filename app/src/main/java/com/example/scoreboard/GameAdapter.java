package com.example.scoreboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class GameAdapter extends ArrayAdapter<Game>
{
    public GameAdapter(Context context,List<Game> games)
    {
        super(context,0,games);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Game game = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.game_cell,parent,false);

        TextView oldGame = convertView.findViewById(R.id.cellGame);
        TextView teamNameA = convertView.findViewById(R.id.cellTeamNameA);
        TextView scoreA = convertView.findViewById(R.id.cellScoreA);
        TextView teamNameB = convertView.findViewById(R.id.cellTeamNameB);
        TextView scoreB = convertView.findViewById(R.id.cellScoreB);

        oldGame.setText(game.getOldGame());
        teamNameA.setText(game.getTeamNameA());
        scoreA.setText(game.getScoreA());
        teamNameB.setText(game.getTeamNameA());
        scoreB.setText(game.getScoreB());


        return convertView;
    }
}
