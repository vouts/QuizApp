package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {
    String category, username;
    int result;
    public void Reset(View view){
        Intent reset = new Intent(this, MainActivity.class);
        startActivity(reset);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageView img = findViewById(R.id.resultImage);
        TextView txt = findViewById(R.id.resultText),
                title = findViewById(R.id.resultTitle);

        category = getIntent().getStringExtra("EXTRA_SELECTED_CATEGORY");
        username = getIntent().getStringExtra("EXTRA_TYPED_NAME");
        result = Integer.parseInt(getIntent().getStringExtra("EXTRA_RESULT"));
        if(result == 6){
            title.setText(R.string.shadowTitle);
            img.setImageResource(R.drawable.shadow);
            txt.setText(String.format(getString(R.string.shadowOutro),username,category));;
        } else {
            title.setText(R.string.demonTitle);
            img.setImageResource(R.drawable.demon);
            txt.setText(String.format(getString(R.string.demonOutro),username,category));
        }
        Toast printResult = Toast.makeText(this,String.format(getString(R.string.toastMsg),result),Toast.LENGTH_LONG);
        printResult.show();
    }
}
