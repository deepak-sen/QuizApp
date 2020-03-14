package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {
    private Button submitButton;
    private int score;
    private String[] quizResult = new String[6];
    private RadioGroup RadioGroupOne;
    private RadioGroup RadioGroupTwo;
    private RadioGroup RadioGroupThree;
    private RadioGroup RadioGroupFour;
    private RadioGroup RadioGroupFive;
    private EditText editText;


    private CheckBox dwayneCheckbox;
    private CheckBox sherpaCheckbox;
    private CheckBox hillaryCheckbox;
    private CheckBox pramitCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submitButton = findViewById(R.id.submit_button);

        dwayneCheckbox = findViewById(R.id.dwayne_checkbox);
        sherpaCheckbox = findViewById(R.id.sherpa_checkbox);
        hillaryCheckbox = findViewById(R.id.hillary_checkbox);
        pramitCheckbox = findViewById(R.id.pramit_checkbox);

        RadioGroupOne = findViewById(R.id.radio_group_one);
        RadioGroupTwo = findViewById(R.id.radio_group_two);
        RadioGroupThree = findViewById(R.id.radio_group_three);
        RadioGroupFour = findViewById(R.id.radio_group_four);
        RadioGroupFive = findViewById(R.id.radio_group_five);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = 0;

                if(RadioGroupOne.getCheckedRadioButtonId() == R.id.george_radiobutton){
                    score += 1;
                }

                if(RadioGroupTwo.getCheckedRadioButtonId() == R.id.oneninefive_radiobutton){
                    score += 1;
                }

                if(RadioGroupThree.getCheckedRadioButtonId() == R.id.italy_radiobutton){
                    score += 1;
                }

                if(RadioGroupFour.getCheckedRadioButtonId() == R.id.niel_radiobutton){
                    score += 1;
                }

                if(RadioGroupFive.getCheckedRadioButtonId() == R.id.buzz_radiobutton){
                    score += 1;
                }


                if(sherpaCheckbox.isChecked() && hillaryCheckbox.isChecked() && !dwayneCheckbox.isChecked()
                        && !pramitCheckbox.isChecked()){
                    score += 1;
                }

                Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                intent.putExtra("SCORE", score+"/6");
                startActivity(intent);

            }
        });
    }
}
