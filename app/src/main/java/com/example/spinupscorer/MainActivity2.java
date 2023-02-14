package com.example.spinupscorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    public static int score = 0;
    public static int tall = 0;
    public static int low = 0;
    public static int roller = 0;
    public static int tile = 0;
    public static int auton = 0;
    public static int diff = 0;
    public static int opponentScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        opponentScore = intent.getIntExtra("opponentScore", score);
        ((TextView) findViewById(R.id.tallNum)).setText(Integer.toString(tall));
        ((TextView) findViewById(R.id.lowNum)).setText(Integer.toString(low));
        ((TextView) findViewById(R.id.rollerNum)).setText(Integer.toString(roller));
        ((TextView) findViewById(R.id.tileNum)).setText(Integer.toString(tile));
        ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
        status();

    }


    public void tallAdd(View v) {
        tall += 1;
        score += 5;
        ((TextView) findViewById(R.id.tallNum)).setText(Integer.toString(tall));
        ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
        status();
    }

    public void lowAdd(View v) {
        low += 1;
        score += 1;
        ((TextView) findViewById(R.id.lowNum)).setText(Integer.toString(low));
        ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
        status();
    }

    public void rollerAdd(View v) {
        if (roller < 4) {
            roller += 1;
            score += 10;
            ((TextView) findViewById(R.id.rollerNum)).setText(Integer.toString(roller));
            ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
        }
        status();
    }

    public void tileAdd(View v) {
        if (tile < 36) {
            tile += 1;
            score += 3;
            ((TextView) findViewById(R.id.tileNum)).setText(Integer.toString(tile));
            ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
        }
        status();
    }

    public void tallMinus(View v) {
        if (tall > 0) {
            tall -= 1;
            score -= 5;
            ((TextView) findViewById(R.id.tallNum)).setText(Integer.toString(tall));
            ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
        }
        status();
    }

    public void lowMinus(View v) {
        if (low > 0) {
            low -= 1;
            score -= 1;
            ((TextView) findViewById(R.id.lowNum)).setText(Integer.toString(low));
            ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
        }
        status();
    }

    public void rollerMinus(View v) {
        if (roller > 0) {
            roller -= 1;
            score -= 10;
            ((TextView) findViewById(R.id.rollerNum)).setText(Integer.toString(roller));
            ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
        }
        status();
    }

    public void tileMinus(View v) {
        if (tile > 0) {
            tile -= 1;
            score -= 3;
            ((TextView) findViewById(R.id.tileNum)).setText(Integer.toString(tile));
            ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
        }
        status();
    }

    public void autonPoints(View v) {
        if (auton == 0) {
            auton += 1;
            score += 10;
            ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
            ((Button) findViewById(R.id.autonStatus)).setText("Won");
        } else if (auton == 1) {
            auton += 1;
            score -= 5;
            ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
            ((Button) findViewById(R.id.autonStatus)).setText("Tied");
        } else if (auton == 2) {
            auton = 0;
            score -= 5;
            ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
            ((Button) findViewById(R.id.autonStatus)).setText("Lost");
        }
        status();
    }

    public void changeTeam(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("opponentScore", score);
        startActivity(intent);
    }

    public void reset(View view) {
        score = 0;
        tall = 0;
        low = 0;
        roller = 0;
        tile = 0;
        auton = 0;
        ((TextView) findViewById(R.id.tallNum)).setText(Integer.toString(tall));
        ((TextView) findViewById(R.id.lowNum)).setText(Integer.toString(low));
        ((TextView) findViewById(R.id.rollerNum)).setText(Integer.toString(roller));
        ((TextView) findViewById(R.id.tileNum)).setText(Integer.toString(tile));
        ((TextView) findViewById(R.id.scoreNum)).setText(Integer.toString(score));
        ((Button) findViewById(R.id.autonStatus)).setText("Lost");
        status();
    }

    public void status() {
        diff = score - opponentScore;
        if (diff == 0) {
            ((TextView) findViewById(R.id.difference)).setText("Tied");
            ((TextView) findViewById(R.id.scoreDiff)).setText("");
        } else if (diff < 0) {
            ((TextView) findViewById(R.id.difference)).setText("Down");
            ((TextView) findViewById(R.id.scoreDiff)).setText(Integer.toString(Math.abs(diff)));
        } else {
            ((TextView) findViewById(R.id.difference)).setText("Up");
            ((TextView) findViewById(R.id.scoreDiff)).setText(Integer.toString(Math.abs(diff)));
        }
    }

}