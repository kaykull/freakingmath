package com.example.hoang_tuan_thanh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndGame extends AppCompatActivity {
    TextView score,current,so1,so2,result,best;
    View icon;
    Button replay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Intent intent = getIntent();

        score = findViewById(R.id.end_score);
        String data = intent.getStringExtra("score");
        score.setText(data);

        current = findViewById(R.id.current_result);
        current.setText(data);

        so1 = findViewById(R.id.num1);
        so2 = findViewById(R.id.num2);
        result = findViewById(R.id.end_result);
        icon = findViewById(R.id.icon);
        int soHang1 = intent.getIntExtra("so1",0);
        so1.setText(""+soHang1);
        int soHang2 = intent.getIntExtra("so2",0);
        so2.setText(""+soHang2);
        int kq = intent.getIntExtra("result",0);
        result.setText(""+kq);
        if (soHang1 + soHang2 == kq){
            icon.setBackground(this.getResources().getDrawable(R.drawable.true_icon));
        }else{
            icon.setBackground(this.getResources().getDrawable(R.drawable.false_icon));
        }


        best = findViewById(R.id.best_result);
        SharedPreferences preferences = getSharedPreferences("score_data", MODE_PRIVATE);
        int diemcao = Integer.parseInt(preferences.getString("diem_cao","0" ));
        int diemht = Integer.parseInt(score.getText().toString());
        if (diemcao < diemht){
            best.setText(""+diemht);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("diem_cao", ""+diemht);
            editor.apply();
        }
        else best.setText(""+diemcao);

        replay = findViewById(R.id.btnreplay);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndGame.this, GamePlay.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
