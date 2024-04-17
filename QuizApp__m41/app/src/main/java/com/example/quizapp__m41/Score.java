package com.example.quizapp__m41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends AppCompatActivity {

    Button bLogout,bTry;
    ProgressBar progressBar;
    TextView tvScore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        bLogout = (Button) findViewById(R.id.bLogout);
        bTry = (Button) findViewById(R.id.bTry);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tvScore = (TextView) findViewById(R.id.tvScore);

        Intent intent=getIntent();
        score=intent.getIntExtra("score",0) ;

        progressBar.setProgress(100*score/5);
        tvScore.setText(100*score/5+" %");

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Merci pour votre Participation !", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Score.this,MainActivity.class));
                finish();
            }
        });

        bTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Score.this,Quiz1.class));
            }
        });


    }
}