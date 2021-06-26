package com.example.hoang_tuan_thanh;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GamePlay extends AppCompatActivity {
    TextView so1, so2, result, score;
    Button dung,sai;
    CountDownTimer Timer;
    ProgressBar viewloader;

    int tong, n1, n2, tg;

    private void end_game() {
        Intent intent = new Intent(GamePlay.this, EndGame.class);
        intent.putExtra("score",score.getText().toString());
        intent.putExtra("so1",n1);
        intent.putExtra("so2",n2);
        intent.putExtra("result",tong);
        startActivity(intent);
        finish();
    }
    public void next_round() {
        n1 = new Random().nextInt(40) + 1;
        n2 = new Random().nextInt(40) + 1;
        this.so1.setText(""+n1);
        this.so2.setText(""+n2);
        tg = new Random().nextInt(4) + 1;
        if(n1 % 2 == 0){
            tong = n1 + n2;
        }
        else //phep sai
            tong= n1 + n2 + tg;
        this.result.setText(""+tong);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        so1 = findViewById(R.id.num1);
        so2 = findViewById(R.id.num2);
        result = findViewById(R.id.play_result);
        score = findViewById(R.id.play_score);
        viewloader = findViewById(R.id.time_view);
        dung = findViewById(R.id.right);
        sai = findViewById(R.id.wrong);
        next_round();
        Timer = new CountDownTimer(3000, 10) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
            }
        }.start();
        dung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n1 + n2 == tong){
                    score.setText(""+(Integer.parseInt(score.getText().toString()) +1));
                    next_round();
                    Timer.cancel();
                    Timer = new CountDownTimer(3000, 5) {
                        public void onTick(long millisUntilFinished) {
                            viewloader.setProgress((int) (millisUntilFinished/5));
                        }

                        public void onFinish() {
                            Timer.cancel();
                            end_game();
                        }
                    }.start();
                }
                else {
                    Intent intent = new Intent(GamePlay.this, EndGame.class);
                    startActivity(intent);
                    finish();
                    end_game();
                }
            }

        });
        sai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n1 + n2 == tong){
                    Timer.cancel();
                    end_game();
                }
                else {

                    score.setText(""+(Integer.parseInt(score.getText().toString()) +1));
                    next_round();
                    Timer.cancel();
                    Timer = new CountDownTimer(3000, 10) {
                        public void onTick(long millisUntilFinished) {
                            viewloader.setProgress((int) (millisUntilFinished/5));
                        }

                        public void onFinish() {
                            end_game();
                        }
                    }.start();

                }
            }
        });
    }



}