package com.example.android.quizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Definition of global variables
    String category;

    /**
     * Saves Current state
     */

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("selected_category", category);


    }

    /**
     * Restore saved state
     */

    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);

        category = saveInstanceState.getString("selected_category");

    }

    /**
     * When the user click "Get started" button
     *
     * 1. Gets the selected category
     *
     * 2. If no category is selected, it will will pass the first category of
     * the string array "categories"
     *
     * 3. Starts the next activity and passes the needed global vars on it.
     *
     * */
    public void GetStarted(View view) {
        //1.
        Spinner start = (Spinner) findViewById(R.id.categories);
        category = start.getSelectedItem().toString();
        //2.
        if (category == null){
            Resources res = getResources();
            String[] categories = res.getStringArray(R.array.Categories);
            category = categories[0];
        }

        //3.
        String activityToStart = "com.example.android.quizapp." + category;
        try {
            Class<?> chosenCategory = Class.forName(activityToStart);
            Intent intent = new Intent(this, chosenCategory);
            intent.putExtra("EXTRA_SELECTED_CATEGORY", category);
            startActivity(intent);
        } catch (ClassNotFoundException ignored) {
            Toast toast = Toast.makeText(this, "class not found", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
