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

public class Sports extends AppCompatActivity {
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
        RadioGroup firstQuestion = findViewById(R.id.sportsQ1);
        savedInstanceState.putInt("First_Question_Selection", firstQuestion.getCheckedRadioButtonId());

        //Second question state
        EditText secondQuestion = findViewById(R.id.sportsQ2);
        savedInstanceState.putString("Second_Question_Selection", secondQuestion.getText().toString());

        //Third question state
        CheckBox olympic1 = findViewById(R.id.olympic1),
                olympic2 = findViewById(R.id.olympic2),
                olympic3 = findViewById(R.id.olympic3),
                notOlympic1 = findViewById(R.id.notOlympic1),
                notOlympic2 = findViewById(R.id.notOlympic2),
                notOlympic3 = findViewById(R.id.notOlympic3);
        savedInstanceState.putBoolean("First_Q3_Checkbox", olympic1.isChecked());
        savedInstanceState.putBoolean("Second_Q3_Checkbox", olympic2.isChecked());
        savedInstanceState.putBoolean("Third_Q3_Checkbox", olympic3.isChecked());
        savedInstanceState.putBoolean("Fourth_Q3_Checkbox", notOlympic1.isChecked());
        savedInstanceState.putBoolean("Fifth_Q3_Checkbox", notOlympic2.isChecked());
        savedInstanceState.putBoolean("Sixth_Q3_Checkbox", notOlympic3.isChecked());

        //Fourth question state
        EditText fourthQuestion = findViewById(R.id.sportsQ4);
        savedInstanceState.putString("Fourth_Question_Selection", fourthQuestion.getText().toString());

        //Fifth question state
        RadioGroup fifthQuestion = findViewById(R.id.sportsQ5);
        savedInstanceState.putInt("Fifth_Question_Selection", fifthQuestion.getCheckedRadioButtonId());

        //Sixth question state
        CheckBox name1 = findViewById(R.id.name1),
                name2 = findViewById(R.id.name2),
                name3 = findViewById(R.id.name3),
                name4 = findViewById(R.id.name4),
                notName1 = findViewById(R.id.notName1),
                notName2 = findViewById(R.id.notName2);
        savedInstanceState.putBoolean("First_Q6_Checkbox", name1.isChecked());
        savedInstanceState.putBoolean("Second_Q6_Checkbox", name2.isChecked());
        savedInstanceState.putBoolean("Third_Q6_Checkbox", name3.isChecked());
        savedInstanceState.putBoolean("Fourth_Q6_Checkbox",name4.isChecked());
        savedInstanceState.putBoolean("Fifth_Q6_Checkbox", notName1.isChecked());
        savedInstanceState.putBoolean("Sixth_Q6_Checkbox", notName2.isChecked());

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
            RadioGroup firstQuestion = findViewById(R.id.sportsQ1);
            firstQuestion.check(saveInstanceState.getInt("First_Question_Selection"));

            //Second question state
            EditText secondQuestion = findViewById(R.id.sportsQ2);
            secondQuestion.setText(saveInstanceState.getString("Second_Question_Selection"));

            //Third question state
            CheckBox olympic1 = findViewById(R.id.olympic1),
                    olympic2 = findViewById(R.id.olympic2),
                    olympic3 = findViewById(R.id.olympic3),
                    notOlympic1 = findViewById(R.id.notOlympic1),
                    notOlympic2 = findViewById(R.id.notOlympic2),
                    notOlympic3 = findViewById(R.id.notOlympic3);
            olympic1.setChecked(saveInstanceState.getBoolean("First_Q3_Checkbox"));
            olympic2.setChecked(saveInstanceState.getBoolean("Second_Q3_Checkbox"));
            olympic3.setChecked(saveInstanceState.getBoolean("Third_Q3_Checkbox"));
            notOlympic1.setChecked(saveInstanceState.getBoolean("Fourth_Q3_Checkbox"));
            notOlympic2.setChecked(saveInstanceState.getBoolean("Fifth_Q3_Checkbox"));
            notOlympic3.setChecked(saveInstanceState.getBoolean("Sixth_Q3_Checkbox"));

            //Fourth question state
            EditText fourthQuestion = findViewById(R.id.sportsQ4);
            fourthQuestion.setText(saveInstanceState.getString("Fourth_Question_Selection"));

            //Fifth question state
            RadioGroup fifthQuestion = findViewById(R.id.sportsQ5);
            fifthQuestion.check(saveInstanceState.getInt("Fifth_Question_Selection"));

            //Sixth question state
            CheckBox name1 = findViewById(R.id.name1),
                    name2 = findViewById(R.id.name2),
                    name3 = findViewById(R.id.name3),
                    name4 = findViewById(R.id.name4),
                    notName1 = findViewById(R.id.notName1),
                    notName2 = findViewById(R.id.notName2);
            name1.setChecked(saveInstanceState.getBoolean("First_Q6_Checkbox"));
            name2.setChecked(saveInstanceState.getBoolean("Second_Q6_Checkbox"));
            name3.setChecked(saveInstanceState.getBoolean("Third_Q6_Checkbox"));
            name4.setChecked(saveInstanceState.getBoolean("Fourth_Q6_Checkbox"));
            notName1.setChecked(saveInstanceState.getBoolean("Fifth_Q6_Checkbox"));
            notName2.setChecked(saveInstanceState.getBoolean("Sixth_Q6_Checkbox"));
        }

    }

    /**
     * Check the answers and calculate result
     */
    private int calculateResult() {
        int result = 0;
        RadioGroup firstQuestion = findViewById(R.id.sportsQ1),
                fifthQuestion = findViewById(R.id.sportsQ5);

        EditText secondQuestion = findViewById(R.id.sportsQ2),
                fourthQuestion = findViewById(R.id.sportsQ4);

        CheckBox olympic1 = findViewById(R.id.olympic1),
                olympic2 = findViewById(R.id.olympic2),
                olympic3 = findViewById(R.id.olympic3),
                notOlympic1 = findViewById(R.id.notOlympic1),
                notOlympic2 = findViewById(R.id.notOlympic2),
                notOlympic3 = findViewById(R.id.notOlympic3),
                name1 = findViewById(R.id.name1),
                name2 = findViewById(R.id.name2),
                name3 = findViewById(R.id.name3),
                name4 = findViewById(R.id.name4),
                notName1 = findViewById(R.id.notName1),
                notName2 = findViewById(R.id.notName2);
        RadioButton firstQuestionSelected = findViewById(firstQuestion.getCheckedRadioButtonId()),
                fifthQuestionSelected = findViewById(fifthQuestion.getCheckedRadioButtonId());
        ;

        if (firstQuestionSelected.getText().toString() == getString(R.string.sportsQ1CorrectAnswer)) {
            result++;
        }

        if (fifthQuestionSelected.getText().toString() == getString(R.string.sportsQ5CorrectAnswer)) {
            result++;
        }

        if (secondQuestion.getText().toString().toLowerCase().equals(getString(R.string.sportsQ2CorrectAnswer))) {
            result++;

        }

        if (  Integer.parseInt(fourthQuestion.getText().toString()) == Integer.parseInt(getString(R.string.sportsQ4CorrectAnswer))){
            result++;

        }

        if (olympic1.isChecked() && olympic2.isChecked() && olympic3.isChecked() && !notOlympic1.isChecked() && !notOlympic2.isChecked() && !notOlympic3.isChecked()) {
            result++;
        }

        if (name1.isChecked() && name2.isChecked() && name3.isChecked() && name4.isChecked() && !notName1.isChecked() && !notName2.isChecked()) {
            result++;
        }
        return result;
    }


    /**
     * Check if all Questions are Answered
     */

    private Boolean AllQuestionsAnsweredCheck() {
        Boolean allQuestionsAnswered = true;

        RadioGroup firstQuestion = findViewById(R.id.sportsQ1),
                fifthQuestion = findViewById(R.id.sportsQ5);

        EditText secondQuestion = findViewById(R.id.sportsQ2),
                fourthQuestion = findViewById(R.id.sportsQ4);

        CheckBox olympic1 = findViewById(R.id.olympic1),
                olympic2 = findViewById(R.id.olympic2),
                olympic3 = findViewById(R.id.olympic3),
                notOlympic1 = findViewById(R.id.notOlympic1),
                notOlympic2 = findViewById(R.id.notOlympic2),
                notOlympic3 = findViewById(R.id.notOlympic3),
                name1 = findViewById(R.id.name1),
                name2 = findViewById(R.id.name2),
                name3 = findViewById(R.id.name3),
                name4 = findViewById(R.id.name4),
                notName1 = findViewById(R.id.notName1),
                notName2 = findViewById(R.id.notName2);


        //Check if RadioGroup views are answered
        if (firstQuestion.getCheckedRadioButtonId() == -1 || fifthQuestion.getCheckedRadioButtonId() == -1) {
            allQuestionsAnswered = false;
        }
        //Check if EditText views are answered
        if (secondQuestion.getText().toString().length() == 0 || fourthQuestion.getText().toString().length() == 0) {
            allQuestionsAnswered = false;
        }

        //Check if CheckBox views are answered
        if (
                (!olympic1.isChecked() && !olympic2.isChecked() && !olympic3.isChecked() && !notOlympic1.isChecked() && !notOlympic2.isChecked() && !notOlympic3.isChecked()) ||
                        (!name1.isChecked() && !name2.isChecked() && !name3.isChecked() && !name4.isChecked() && !notName1.isChecked() && !notName2.isChecked())
                ) {
            allQuestionsAnswered = false;
        }

        return allQuestionsAnswered;
    }

    public void submitSports(View view) {
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
        setContentView(R.layout.activity_sports);
        category = getIntent().getStringExtra("EXTRA_SELECTED_CATEGORY");
        username = getIntent().getStringExtra("EXTRA_TYPED_NAME");
    }
}
