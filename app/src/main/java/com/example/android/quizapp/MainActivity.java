package com.example.android.quizapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    //Definition of global variables
    String category, username;

    /**
     * Saves Current state
     */

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Spinner spinner = findViewById(R.id.categories);
        savedInstanceState.putInt("selected_category", spinner.getSelectedItemPosition());

        EditText name =  findViewById(R.id.name);
        username = name.getText().toString();
        savedInstanceState.putString("typed_name", username);

        super.onSaveInstanceState(savedInstanceState);

    }

    /**
     * Restore saved state
     */

    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);

        if (saveInstanceState != null) {

            username = saveInstanceState.getString("typed_name");

            EditText name = (EditText) findViewById(R.id.name);
            name.setText(username);

            Spinner spinner = findViewById(R.id.categories);
            spinner.setSelection(saveInstanceState.getInt("selected_category", 0));
        }

    }



    /**
     * When the user click "Get started" button
     *
     * 1. Check if the players name is set
     *
     * 2. Gets the selected category
     *
     * 3. If no category is selected, it will will pass the first category of
     * the string array "categories"
     *
     * 4. Starts the next activity and passes the needed global vars on it.
     *
     * */
    public void GetStarted(View view) {

        EditText name =  findViewById(R.id.name);
        username = name.getText().toString();
        //1.
        if(username.length()>0) {
            //2.
            Spinner start = (Spinner) findViewById(R.id.categories);
            category = start.getSelectedItem().toString();
            //3.
            if (category == null) {
                Resources res = getResources();
                String[] categories = res.getStringArray(R.array.Categories);
                category = categories[0];
            }

            //4.
            String activityToStart = "com.example.android.quizapp." + category;
            try {
                Class<?> chosenCategory = Class.forName(activityToStart);
                Intent intent = new Intent(this, chosenCategory);
                intent.putExtra("EXTRA_SELECTED_CATEGORY", category);
                intent.putExtra("EXTRA_TYPED_NAME", username);
                startActivity(intent);
            } catch (ClassNotFoundException ignored) {
                 Log.e("MainActivity", "Class not found");
            }
        } else {
            Toast getName = Toast.makeText(this,R.string.namecheck,Toast.LENGTH_LONG);
            getName.show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
}
