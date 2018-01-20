package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class History extends AppCompatActivity {
    String category, username;

    /**
     * Saves Current state
     */

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("typed_name", username);
        savedInstanceState.putString("selected_category", category);

        super.onSaveInstanceState(savedInstanceState);

    }

    /**
     * Restore saved state
     */

    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);

        if (saveInstanceState != null) {

            category = saveInstanceState.getString("selected_category");
            username = saveInstanceState.getString("typed_name");

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        category = getIntent().getStringExtra("EXTRA_SELECTED_CATEGORY");
        username = getIntent().getStringExtra("EXTRA_TYPED_NAME");

    }
}
