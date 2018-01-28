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
        CheckBox god1 = findViewById(R.id.god1),
                god2 = findViewById(R.id.god2),
                god3 = findViewById(R.id.god3),
                notGod1 = findViewById(R.id.notGod1),
                notGod2 = findViewById(R.id.notGod2),
                notGod3 = findViewById(R.id.notGod3);
        savedInstanceState.putBoolean("First_Q3_Checkbox", god1.isChecked());
        savedInstanceState.putBoolean("Second_Q3_Checkbox", god2.isChecked());
        savedInstanceState.putBoolean("Third_Q3_Checkbox", god3.isChecked());
        savedInstanceState.putBoolean("Fourth_Q3_Checkbox", notGod1.isChecked());
        savedInstanceState.putBoolean("Fifth_Q3_Checkbox", notGod2.isChecked());
        savedInstanceState.putBoolean("Sixth_Q3_Checkbox", notGod3.isChecked());

        //Fourth question state
        EditText fourthQuestion = findViewById(R.id.sportsQ4);
        savedInstanceState.putString("Fourth_Question_Selection", fourthQuestion.getText().toString());

        //Fifth question state
        RadioGroup fifthQuestion = findViewById(R.id.sportsQ5);
        savedInstanceState.putInt("Fifth_Question_Selection", fifthQuestion.getCheckedRadioButtonId());

        //Sixth question state
        CheckBox eng1 = findViewById(R.id.eng1),
                eng2 = findViewById(R.id.eng2),
                eng3 = findViewById(R.id.eng3),
                eng4 = findViewById(R.id.eng4),
                notEng1 = findViewById(R.id.notEng1),
                notEng2 = findViewById(R.id.notEng2);
        savedInstanceState.putBoolean("First_Q6_Checkbox", eng1.isChecked());
        savedInstanceState.putBoolean("Second_Q6_Checkbox", eng2.isChecked());
        savedInstanceState.putBoolean("Third_Q6_Checkbox", eng3.isChecked());
        savedInstanceState.putBoolean("Fourth_Q6_Checkbox", eng4.isChecked());
        savedInstanceState.putBoolean("Fifth_Q6_Checkbox", notEng1.isChecked());
        savedInstanceState.putBoolean("Sixth_Q6_Checkbox", notEng2.isChecked());

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
            CheckBox god1 = findViewById(R.id.god1),
                    god2 = findViewById(R.id.god2),
                    god3 = findViewById(R.id.god3),
                    notGod1 = findViewById(R.id.notGod1),
                    notGod2 = findViewById(R.id.notGod2),
                    notGod3 = findViewById(R.id.notGod3);
            god1.setChecked(saveInstanceState.getBoolean("First_Q3_Checkbox"));
            god2.setChecked(saveInstanceState.getBoolean("Second_Q3_Checkbox"));
            god3.setChecked(saveInstanceState.getBoolean("Third_Q3_Checkbox"));
            notGod1.setChecked(saveInstanceState.getBoolean("Fourth_Q3_Checkbox"));
            notGod2.setChecked(saveInstanceState.getBoolean("Fifth_Q3_Checkbox"));
            notGod3.setChecked(saveInstanceState.getBoolean("Sixth_Q3_Checkbox"));

            //Fourth question state
            EditText fourthQuestion = findViewById(R.id.sportsQ4);
            fourthQuestion.setText(saveInstanceState.getString("Fourth_Question_Selection"));

            //Fifth question state
            RadioGroup fifthQuestion = findViewById(R.id.sportsQ5);
            fifthQuestion.check(saveInstanceState.getInt("Fifth_Question_Selection"));

            //Sixth question state
            CheckBox eng1 = findViewById(R.id.eng1),
                    eng2 = findViewById(R.id.eng2),
                    eng3 = findViewById(R.id.eng3),
                    eng4 = findViewById(R.id.eng4),
                    notEng1 = findViewById(R.id.notEng1),
                    notEng2 = findViewById(R.id.notEng2);
            eng1.setChecked(saveInstanceState.getBoolean("First_Q6_Checkbox"));
            eng2.setChecked(saveInstanceState.getBoolean("Second_Q6_Checkbox"));
            eng3.setChecked(saveInstanceState.getBoolean("Third_Q6_Checkbox"));
            eng4.setChecked(saveInstanceState.getBoolean("Fourth_Q6_Checkbox"));
            notEng1.setChecked(saveInstanceState.getBoolean("Fifth_Q6_Checkbox"));
            notEng2.setChecked(saveInstanceState.getBoolean("Sixth_Q6_Checkbox"));
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

        CheckBox god1 = findViewById(R.id.god1),
                god2 = findViewById(R.id.god2),
                god3 = findViewById(R.id.god3),
                notGod1 = findViewById(R.id.notGod1),
                notGod2 = findViewById(R.id.notGod2),
                notGod3 = findViewById(R.id.notGod3),
                eng1 = findViewById(R.id.eng1),
                eng2 = findViewById(R.id.eng2),
                eng3 = findViewById(R.id.eng3),
                eng4 = findViewById(R.id.eng4),
                notEng1 = findViewById(R.id.notEng1),
                notEng2 = findViewById(R.id.notEng2);
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

        if (god1.isChecked() && god2.isChecked() && god3.isChecked() && !notGod1.isChecked() && !notGod2.isChecked() && !notGod3.isChecked()) {
            result++;
        }

        if (eng1.isChecked() && eng2.isChecked() && eng3.isChecked() && eng4.isChecked() && !notEng1.isChecked() && !notEng2.isChecked()) {
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

        CheckBox god1 = findViewById(R.id.god1),
                god2 = findViewById(R.id.god2),
                god3 = findViewById(R.id.god3),
                notGod1 = findViewById(R.id.notGod1),
                notGod2 = findViewById(R.id.notGod2),
                notGod3 = findViewById(R.id.notGod3),
                eng1 = findViewById(R.id.eng1),
                eng2 = findViewById(R.id.eng2),
                eng3 = findViewById(R.id.eng3),
                eng4 = findViewById(R.id.eng4),
                notEng1 = findViewById(R.id.notEng1),
                notEng2 = findViewById(R.id.notEng2);


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
                (!god1.isChecked() && !god2.isChecked() && !god3.isChecked() && !notGod1.isChecked() && !notGod2.isChecked() && !notGod3.isChecked()) ||
                        (!eng1.isChecked() && !eng2.isChecked() && !eng3.isChecked() && !eng4.isChecked() && !notEng1.isChecked() && !notEng2.isChecked())
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
        setContentView(R.layout.activity_sports);
        category = getIntent().getStringExtra("EXTRA_SELECTED_CATEGORY");
        username = getIntent().getStringExtra("EXTRA_TYPED_NAME");
    }
}
