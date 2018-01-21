package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class History extends AppCompatActivity {
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
        RadioGroup firstQuestion = findViewById(R.id.historyQ1);
        savedInstanceState.putInt("First_Question_Selection", firstQuestion.getCheckedRadioButtonId());

        //Second question state
        EditText secondQuestion =  findViewById(R.id.historyQ2);
        savedInstanceState.putString("Second_Question_Selection", secondQuestion.getText().toString() );

        //Third question state
        CheckBox god1 = findViewById(R.id.god1),
                god2 = findViewById(R.id.god2),
                god3 = findViewById(R.id.god3),
                notGod1 = findViewById(R.id.notGod1),
                notGod2 = findViewById(R.id.notGod2),
                notGod3 = findViewById(R.id.notGod3);
        savedInstanceState.putBoolean("First_Q3_Checkbox", god1.isChecked());
        savedInstanceState.putBoolean("Second_Q3_Checkbox", god2.isChecked());
        savedInstanceState.putBoolean("third_Q3_Checkbox", god3.isChecked());
        savedInstanceState.putBoolean("Fourth_Q3_Checkbox", notGod1.isChecked());
        savedInstanceState.putBoolean("Fifth_Q3_Checkbox", notGod2.isChecked());
        savedInstanceState.putBoolean("Sixth_Q3_Checkbox", notGod3.isChecked());

        //Fourth question state
        EditText fourthQuestion =  findViewById(R.id.historyQ4);
        savedInstanceState.putString("Fourth_Question_Selection", fourthQuestion.getText().toString() );

        //Fifth question state
        RadioGroup fifthQuestion = findViewById(R.id.historyQ5);
        savedInstanceState.putInt("Fifth_Question_Selection", fifthQuestion.getCheckedRadioButtonId());

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
            RadioGroup firstQuestion = findViewById(R.id.historyQ1);
            firstQuestion.check(saveInstanceState.getInt("First_Question_Selection"));

            //Second question state
            EditText secondQuestion =  findViewById(R.id.historyQ2);
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
            EditText fourthQuestion =  findViewById(R.id.historyQ4);
            fourthQuestion.setText(saveInstanceState.getString("Fourth_Question_Selection"));

            //Fifth question state
            RadioGroup fifthQuestion = findViewById(R.id.historyQ1);
            fifthQuestion.check(saveInstanceState.getInt("Fifth_Question_Selection"));
        }

    }

    private int calculateResult (){
        int result = 0;

        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        category = getIntent().getStringExtra("EXTRA_SELECTED_CATEGORY");
        username = getIntent().getStringExtra("EXTRA_TYPED_NAME");

    }
}
