package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Space extends AppCompatActivity {
    String category, username;


    /**
     * Saves Current state
     */

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //Variables that came from the first activity
        savedInstanceState.putString("typed_name", username);
        savedInstanceState.putString("selected_category", category);

        //First question state
        EditText firstQuestion = findViewById(R.id.spaceQ1);
        savedInstanceState.putString("First_Question_Selection", firstQuestion.getText().toString());

        //Second question state
        RadioGroup secondQuestion = findViewById(R.id.spaceQ2);
        savedInstanceState.putInt("Second_Question_Selection", secondQuestion.getCheckedRadioButtonId());

        //Third question state
        CheckBox planet1 = findViewById(R.id.planet1),
                planet2 = findViewById(R.id.planet2),
                planet3 = findViewById(R.id.planet3),
                notPlanet1 = findViewById(R.id.notPlanet1),
                notPlanet2 = findViewById(R.id.notPlanet2),
                notPlanet3 = findViewById(R.id.notPlanet3);
        savedInstanceState.putBoolean("First_Q3_Checkbox", planet1.isChecked());
        savedInstanceState.putBoolean("Second_Q3_Checkbox", planet2.isChecked());
        savedInstanceState.putBoolean("Third_Q3_Checkbox", planet3.isChecked());
        savedInstanceState.putBoolean("Fourth_Q3_Checkbox", notPlanet1.isChecked());
        savedInstanceState.putBoolean("Fifth_Q3_Checkbox", notPlanet2.isChecked());
        savedInstanceState.putBoolean("Sixth_Q3_Checkbox", notPlanet3.isChecked());

        //Fourth question state
        EditText fourthQuestion = findViewById(R.id.spaceQ4);
        savedInstanceState.putString("Fourth_Question_Selection", fourthQuestion.getText().toString());

        //Fifth question state
        CheckBox moon1 = findViewById(R.id.moon1),
                moon2 = findViewById(R.id.moon2),
                moon3 = findViewById(R.id.moon3),
                notMoon1 = findViewById(R.id.notMoon1),
                notMoon2 = findViewById(R.id.notMoon2),
                notMoon3 = findViewById(R.id.notMoon3);
        savedInstanceState.putBoolean("First_Q5_Checkbox", moon1.isChecked());
        savedInstanceState.putBoolean("Second_Q5_Checkbox", moon2.isChecked());
        savedInstanceState.putBoolean("Third_Q5_Checkbox", moon3.isChecked());
        savedInstanceState.putBoolean("Fourth_Q5_Checkbox", notMoon1.isChecked());
        savedInstanceState.putBoolean("Fifth_Q5_Checkbox", notMoon2.isChecked());
        savedInstanceState.putBoolean("Sixth_Q5_Checkbox", notMoon3.isChecked());

        //Sixth question state
        RadioGroup sixthQuestion = findViewById(R.id.spaceQ6);
        savedInstanceState.putInt("Sixth_Question_Selection", sixthQuestion.getCheckedRadioButtonId());


        super.onSaveInstanceState(savedInstanceState);

    }

    /**
     * Restore saved state
     */

    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);

        if (saveInstanceState != null) {
            //Variables that came from the first activity
            category = saveInstanceState.getString("selected_category");
            username = saveInstanceState.getString("typed_name");

            //First question state
            EditText firstQuestion = findViewById(R.id.spaceQ1);
            firstQuestion.setText(saveInstanceState.getString("First_Question_Selection"));

            //Second question state
            RadioGroup secondQuestion = findViewById(R.id.spaceQ2);
            secondQuestion.check(saveInstanceState.getInt("Second_Question_Selection"));


            //Third question state
            CheckBox planet1 = findViewById(R.id.planet1),
                    planet2 = findViewById(R.id.planet2),
                    planet3 = findViewById(R.id.planet3),
                    notPlanet1 = findViewById(R.id.notPlanet1),
                    notPlanet2 = findViewById(R.id.notPlanet2),
                    notPlanet3 = findViewById(R.id.notPlanet3);
            planet1.setChecked(saveInstanceState.getBoolean("First_Q3_Checkbox"));
            planet2.setChecked(saveInstanceState.getBoolean("Second_Q3_Checkbox"));
            planet3.setChecked(saveInstanceState.getBoolean("Third_Q3_Checkbox"));
            notPlanet1.setChecked(saveInstanceState.getBoolean("Fourth_Q3_Checkbox"));
            notPlanet2.setChecked(saveInstanceState.getBoolean("Fifth_Q3_Checkbox"));
            notPlanet3.setChecked(saveInstanceState.getBoolean("Sixth_Q3_Checkbox"));

            //Fourth question state
            EditText fourthQuestion = findViewById(R.id.spaceQ4);
            fourthQuestion.setText(saveInstanceState.getString("Fourth_Question_Selection"));

            //Fifth question state
            CheckBox moon1 = findViewById(R.id.moon1),
                    moon2 = findViewById(R.id.moon2),
                    moon3 = findViewById(R.id.moon3),
                    notMoon1 = findViewById(R.id.notMoon1),
                    notMoon2 = findViewById(R.id.notMoon2),
                    notMoon3 = findViewById(R.id.notMoon3);
            moon1.setChecked(saveInstanceState.getBoolean("First_Q5_Checkbox"));
            moon2.setChecked(saveInstanceState.getBoolean("Second_Q5_Checkbox"));
            moon3.setChecked(saveInstanceState.getBoolean("Third_Q5_Checkbox"));
            notMoon1.setChecked(saveInstanceState.getBoolean("Fourth_Q5_Checkbox"));
            notMoon2.setChecked(saveInstanceState.getBoolean("Fifth_Q5_Checkbox"));
            notMoon3.setChecked(saveInstanceState.getBoolean("Sixth_Q5_Checkbox"));

            //Sixth question state
            RadioGroup sixthQuestion = findViewById(R.id.spaceQ6);
            sixthQuestion.check(saveInstanceState.getInt("Sixth_Question_Selection"));


        }

    }

    /**
     * Check the answers and calculate result
     */
    private int calculateResult() {
        int result = 0;
        RadioGroup secondQuestion = findViewById(R.id.spaceQ2),
                sixthQuestion = findViewById(R.id.spaceQ6);

        EditText firstQuestion = findViewById(R.id.spaceQ1),
                fourthQuestion = findViewById(R.id.spaceQ4);

        CheckBox planet1 = findViewById(R.id.planet1),
                planet2 = findViewById(R.id.planet2),
                planet3 = findViewById(R.id.planet3),
                notPlanet1 = findViewById(R.id.notPlanet1),
                notPlanet2 = findViewById(R.id.notPlanet2),
                notPlanet3 = findViewById(R.id.notPlanet3),
                moon1 = findViewById(R.id.moon1),
                moon2 = findViewById(R.id.moon2),
                moon3 = findViewById(R.id.moon3),
                notMoon1 = findViewById(R.id.notMoon1),
                notMoon2 = findViewById(R.id.notMoon2),
                notMoon3 = findViewById(R.id.notMoon3);
        RadioButton secondQuestionSelected = findViewById(secondQuestion.getCheckedRadioButtonId()),
                sixthQuestionSelected = findViewById(sixthQuestion.getCheckedRadioButtonId());
        ;

        if (secondQuestionSelected.getText().toString() == getString(R.string.spaceQ2CorrectAnswer)) {
            result++;
        }

        if (sixthQuestionSelected.getText().toString() == getString(R.string.spaceQ6CorrectAnswer)) {
            result++;
        }

        if (firstQuestion.getText().toString().toLowerCase().equals(getString(R.string.spaceQ1CorrectAnswer))) {
            result++;

        }

        if (fourthQuestion.getText().toString().toLowerCase().equals(getString(R.string.spaceQ4CorrectAnswer))) {
            result++;

        }

        if (planet1.isChecked() && planet2.isChecked() && planet3.isChecked() && !notPlanet1.isChecked() && !notPlanet2.isChecked() && !notPlanet3.isChecked()) {
            result++;
        }

        if (moon1.isChecked() && moon2.isChecked() && moon3.isChecked() && !notMoon1.isChecked() && !notMoon2.isChecked() && !notMoon3.isChecked()) {
            result++;
        }
        return result;
    }


    /**
     * Check if all Questions are Answered
     */

    private Boolean AllQuestionsAnsweredCheck() {
        Boolean allQuestionsAnswered = true;

        RadioGroup secondQuestion = findViewById(R.id.spaceQ2),
                sixthQuestion = findViewById(R.id.spaceQ6);

        EditText firstQuestion = findViewById(R.id.spaceQ1),
                fourthQuestion = findViewById(R.id.spaceQ4);

        CheckBox planet1 = findViewById(R.id.planet1),
                planet2 = findViewById(R.id.planet2),
                planet3 = findViewById(R.id.planet3),
                notPlanet1 = findViewById(R.id.notPlanet1),
                notPlanet2 = findViewById(R.id.notPlanet2),
                notPlanet3 = findViewById(R.id.notPlanet3),
                moon1 = findViewById(R.id.moon1),
                moon2 = findViewById(R.id.moon2),
                moon3 = findViewById(R.id.moon3),
                notMoon1 = findViewById(R.id.notMoon1),
                notMoon2 = findViewById(R.id.notMoon2),
                notMoon3 = findViewById(R.id.notMoon3);


        //Check if RadioGroup views are answered
        if (secondQuestion.getCheckedRadioButtonId() == -1 || sixthQuestion.getCheckedRadioButtonId() == -1) {
            allQuestionsAnswered = false;
        }
        //Check if EditText views are answered
        if (firstQuestion.getText().toString().length() == 0 || fourthQuestion.getText().toString().length() == 0) {
            allQuestionsAnswered = false;
        }

        //Check if CheckBox views are answered
        if (
                (!planet1.isChecked() && !planet2.isChecked() && !planet3.isChecked() && !notPlanet1.isChecked() && !notPlanet2.isChecked() && !notPlanet3.isChecked()) ||
                        (!moon1.isChecked() && !moon2.isChecked() && !moon3.isChecked() && !notMoon1.isChecked() && !notMoon2.isChecked() && !notMoon3.isChecked())
                ) {
            allQuestionsAnswered = false;
        }

        return allQuestionsAnswered;
    }

    public void submitSpace(View view) {
        if (AllQuestionsAnsweredCheck()) {
            Intent result = new Intent(this, Result.class);
            result.putExtra("EXTRA_SELECTED_CATEGORY", category);
            result.putExtra("EXTRA_TYPED_NAME", username);
            result.putExtra("EXTRA_RESULT", Integer.toString(calculateResult()));
            startActivity(result);
        } else {
            Toast toast = Toast.makeText(this, R.string.answerAllQuestions, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);
        category = getIntent().getStringExtra("EXTRA_SELECTED_CATEGORY");
        username = getIntent().getStringExtra("EXTRA_TYPED_NAME");
    }
}
