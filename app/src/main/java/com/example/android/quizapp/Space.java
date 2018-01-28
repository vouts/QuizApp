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
        EditText firstQuestion = findViewById(R.id.natureQ1);
        savedInstanceState.putString("First_Question_Selection", firstQuestion.getText().toString());

        //Second question state
        RadioGroup secondQuestion = findViewById(R.id.natureQ2);
        savedInstanceState.putInt("Second_Question_Selection", secondQuestion.getCheckedRadioButtonId());

        //Third question state
        CheckBox mammal1 = findViewById(R.id.mammal1),
                mammal2 = findViewById(R.id.mammal2),
                mammal3 = findViewById(R.id.mammal3),
                notMammal1 = findViewById(R.id.notMammal1),
                notMammal2 = findViewById(R.id.notMammal2),
                notMammal3 = findViewById(R.id.notMammal3);
        savedInstanceState.putBoolean("First_Q3_Checkbox", mammal1.isChecked());
        savedInstanceState.putBoolean("Second_Q3_Checkbox", mammal2.isChecked());
        savedInstanceState.putBoolean("Third_Q3_Checkbox", mammal3.isChecked());
        savedInstanceState.putBoolean("Fourth_Q3_Checkbox", notMammal1.isChecked());
        savedInstanceState.putBoolean("Fifth_Q3_Checkbox", notMammal2.isChecked());
        savedInstanceState.putBoolean("Sixth_Q3_Checkbox", notMammal3.isChecked());

        //Fourth question state
        EditText fourthQuestion = findViewById(R.id.natureQ4);
        savedInstanceState.putString("Fourth_Question_Selection", fourthQuestion.getText().toString());

        //Fifth question state
        CheckBox fruit1 = findViewById(R.id.fruit1),
                fruit2 = findViewById(R.id.fruit2),
                fruit3 = findViewById(R.id.fruit3),
                notFruit1 = findViewById(R.id.notFruit1),
                notFruit2 = findViewById(R.id.notFruit2),
                notFruit3 = findViewById(R.id.notFruit3);
        savedInstanceState.putBoolean("First_Q5_Checkbox", fruit1.isChecked());
        savedInstanceState.putBoolean("Second_Q5_Checkbox", fruit2.isChecked());
        savedInstanceState.putBoolean("Third_Q5_Checkbox", fruit3.isChecked());
        savedInstanceState.putBoolean("Fourth_Q5_Checkbox", notFruit1.isChecked());
        savedInstanceState.putBoolean("Fifth_Q5_Checkbox", notFruit2.isChecked());
        savedInstanceState.putBoolean("Sixth_Q5_Checkbox", notFruit3.isChecked());

        //Sixth question state
        RadioGroup sixthQuestion = findViewById(R.id.natureQ6);
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
            EditText firstQuestion = findViewById(R.id.natureQ1);
            firstQuestion.setText(saveInstanceState.getString("First_Question_Selection"));

            //Second question state
            RadioGroup secondQuestion = findViewById(R.id.natureQ2);
            secondQuestion.check(saveInstanceState.getInt("Second_Question_Selection"));


            //Third question state
            CheckBox mammal1 = findViewById(R.id.mammal1),
                    mammal2 = findViewById(R.id.mammal2),
                    mammal3 = findViewById(R.id.mammal3),
                    notMammal1 = findViewById(R.id.notMammal1),
                    notMammal2 = findViewById(R.id.notMammal2),
                    notMammal3 = findViewById(R.id.notMammal3);
            mammal1.setChecked(saveInstanceState.getBoolean("First_Q3_Checkbox"));
            mammal2.setChecked(saveInstanceState.getBoolean("Second_Q3_Checkbox"));
            mammal3.setChecked(saveInstanceState.getBoolean("Third_Q3_Checkbox"));
            notMammal1.setChecked(saveInstanceState.getBoolean("Fourth_Q3_Checkbox"));
            notMammal2.setChecked(saveInstanceState.getBoolean("Fifth_Q3_Checkbox"));
            notMammal3.setChecked(saveInstanceState.getBoolean("Sixth_Q3_Checkbox"));

            //Fourth question state
            EditText fourthQuestion = findViewById(R.id.natureQ4);
            fourthQuestion.setText(saveInstanceState.getString("Fourth_Question_Selection"));

            //Fifth question state
            CheckBox fruit1 = findViewById(R.id.fruit1),
                    fruit2 = findViewById(R.id.fruit2),
                    fruit3 = findViewById(R.id.fruit3),
                    notFruit1 = findViewById(R.id.notFruit1),
                    notFruit2 = findViewById(R.id.notFruit2),
                    notFruit3 = findViewById(R.id.notFruit3);
            fruit1.setChecked(saveInstanceState.getBoolean("First_Q5_Checkbox"));
            fruit2.setChecked(saveInstanceState.getBoolean("Second_Q5_Checkbox"));
            fruit3.setChecked(saveInstanceState.getBoolean("Third_Q5_Checkbox"));
            notFruit1.setChecked(saveInstanceState.getBoolean("Fourth_Q5_Checkbox"));
            notFruit2.setChecked(saveInstanceState.getBoolean("Fifth_Q5_Checkbox"));
            notFruit3.setChecked(saveInstanceState.getBoolean("Sixth_Q5_Checkbox"));

            //Sixth question state
            RadioGroup sixthQuestion = findViewById(R.id.natureQ6);
            sixthQuestion.check(saveInstanceState.getInt("Sixth_Question_Selection"));


        }

    }

    /**
     * Check the answers and calculate result
     */
    private int calculateResult() {
        int result = 0;
        RadioGroup secondQuestion = findViewById(R.id.natureQ2),
                sixthQuestion = findViewById(R.id.natureQ6);

        EditText firstQuestion = findViewById(R.id.natureQ1),
                fourthQuestion = findViewById(R.id.natureQ4);

        CheckBox fruit1 = findViewById(R.id.fruit1),
                fruit2 = findViewById(R.id.fruit2),
                fruit3 = findViewById(R.id.fruit3),
                notFruit1 = findViewById(R.id.notFruit1),
                notFruit2 = findViewById(R.id.notFruit2),
                notFruit3 = findViewById(R.id.notFruit3),
                mammal1 = findViewById(R.id.mammal1),
                mammal2 = findViewById(R.id.mammal2),
                mammal3 = findViewById(R.id.mammal3),
                notMammal1 = findViewById(R.id.notMammal1),
                notMammal2 = findViewById(R.id.notMammal2),
                notMammal3 = findViewById(R.id.notMammal3);
        RadioButton secondQuestionSelected = findViewById(secondQuestion.getCheckedRadioButtonId()),
                sixthQuestionSelected = findViewById(sixthQuestion.getCheckedRadioButtonId());
        ;

        if (secondQuestionSelected.getText().toString() == getString(R.string.natureQ2CorrectAnswer)) {
            result++;
        }

        if (sixthQuestionSelected.getText().toString() == getString(R.string.natureQ6CorrectAnswer)) {
            result++;
        }

        if (firstQuestion.getText().toString().toLowerCase().equals(getString(R.string.natureQ1CorrectAnswer))) {
            result++;

        }

        if (fourthQuestion.getText().toString().toLowerCase().equals(getString(R.string.natureQ4CorrectAnswer))) {
            result++;

        }

        if (fruit1.isChecked() && fruit2.isChecked() && fruit3.isChecked() && !notFruit1.isChecked() && !notFruit2.isChecked() && !notFruit3.isChecked()) {
            result++;
        }

        if (mammal1.isChecked() && mammal2.isChecked() && mammal3.isChecked() && !notMammal1.isChecked() && !notMammal2.isChecked() && !notMammal3.isChecked()) {
            result++;
        }
        return result;
    }


    /**
     * Check if all Questions are Answered
     */

    private Boolean AllQuestionsAnsweredCheck() {
        Boolean allQuestionsAnswered = true;

        RadioGroup secondQuestion = findViewById(R.id.natureQ2),
                sixthQuestion = findViewById(R.id.natureQ6);

        EditText firstQuestion = findViewById(R.id.natureQ1),
                fourthQuestion = findViewById(R.id.natureQ4);

        CheckBox fruit1 = findViewById(R.id.fruit1),
                fruit2 = findViewById(R.id.fruit2),
                fruit3 = findViewById(R.id.fruit3),
                notFruit1 = findViewById(R.id.notFruit1),
                notFruit2 = findViewById(R.id.notFruit2),
                notFruit3 = findViewById(R.id.notFruit3),
                mammal1 = findViewById(R.id.mammal1),
                mammal2 = findViewById(R.id.mammal2),
                mammal3 = findViewById(R.id.mammal3),
                notMammal1 = findViewById(R.id.notMammal1),
                notMammal2 = findViewById(R.id.notMammal2),
                notMammal3 = findViewById(R.id.notMammal3);


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
                (!fruit1.isChecked() && !fruit2.isChecked() && !fruit3.isChecked() && !notFruit1.isChecked() && !notFruit2.isChecked() && !notFruit3.isChecked()) ||
                        (!mammal1.isChecked() && !mammal2.isChecked() && !mammal3.isChecked() && !notMammal1.isChecked() && !notMammal2.isChecked() && !notMammal3.isChecked())
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
            result.putExtra("EXTRA_RESULT", calculateResult());
            startActivity(result);
        } else {
            Toast toast = Toast.makeText(this, R.string.answerAllQuestions, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);
        category = getIntent().getStringExtra("EXTRA_SELECTED_CATEGORY");
        username = getIntent().getStringExtra("EXTRA_TYPED_NAME");
    }
}
