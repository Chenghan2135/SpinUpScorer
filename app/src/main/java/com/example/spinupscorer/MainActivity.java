package com.example.spinupscorer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
public static int score = 0;
public static int tall = 0;
public static int low = 0;
public static int roller = 0;
public static int tile = 0;
public static int auton = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void tallAdd(View v){
        tall += 1;
        score += 5;
        ((TextView)findViewById(R.id.tallNum)).setText(Integer.toString(tall));
        ((TextView)findViewById(R.id.scoreNum)).setText(Integer.toString(score));
    }

    public void lowAdd(View v){
        low += 1;
        score += 1;
        ((TextView)findViewById(R.id.lowNum)).setText(Integer.toString(low));
        ((TextView)findViewById(R.id.scoreNum)).setText(Integer.toString(score));
    }

    public void rollerAdd(View v){
        roller += 1;
        score += 10;
        ((TextView)findViewById(R.id.rollerNum)).setText(Integer.toString(roller));
        ((TextView)findViewById(R.id.scoreNum)).setText(Integer.toString(score));
    }

    public void tileAdd(View v){
        tile += 1;
        score += 3;
        ((TextView)findViewById(R.id.tileNum)).setText(Integer.toString(tile));
        ((TextView)findViewById(R.id.scoreNum)).setText(Integer.toString(score));
    }

    public void tallMinus(View v){
        tall -= 1;
        score -= 5;
        ((TextView)findViewById(R.id.tallNum)).setText(Integer.toString(tall));
        ((TextView)findViewById(R.id.scoreNum)).setText(Integer.toString(score));
    }

    public void lowMinus(View v){
        low -= 1;
        score -= 1;
        ((TextView)findViewById(R.id.lowNum)).setText(Integer.toString(low));
        ((TextView)findViewById(R.id.scoreNum)).setText(Integer.toString(score));
    }

    public void rollerMinus(View v){
        roller -= 1;
        score -= 10;
        ((TextView)findViewById(R.id.rollerNum)).setText(Integer.toString(roller));
        ((TextView)findViewById(R.id.scoreNum)).setText(Integer.toString(score));
    }

    public void tileMinus(View v){
        tile -= 1;
        score -= 3;
        ((TextView)findViewById(R.id.tileNum)).setText(Integer.toString(tile));
        ((TextView)findViewById(R.id.scoreNum)).setText(Integer.toString(score));
    }

    public void autonPoints(View v){
        if (auton == 0){
            auton += 1;
            score += 10;
            ((TextView)findViewById(R.id.scoreNum)).setText(Integer.toString(score));
            ((Button)findViewById(R.id.autonStatus)).setText("Won");
        }
        else if (auton == 1){
            auton += 1;
            score -= 5;
            ((TextView)findViewById(R.id.scoreNum)).setText(Integer.toString(score));
            ((Button)findViewById(R.id.autonStatus)).setText("Tied");
        }
        else if (auton == 2){
            auton = 0;
            score -= 5;
            ((TextView)findViewById(R.id.scoreNum)).setText(Integer.toString(score));
            ((Button)findViewById(R.id.autonStatus)).setText("Lost");
        }
    }

}