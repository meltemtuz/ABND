package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Questions extends AppCompatActivity {

    RadioButton q1_a1_Troy, q1_b1_Rlyeh, q1_c1_Mu, q1_d1_Atlantis;
    CheckBox q2_a2_phileas_fogg, q2_b2_michel_ardan, q2_c2_lidenbrock, q2_d2_francis_cromarty, q2_e2_arne_saknussem;
    EditText q3_a3_your_answer;
    RadioButton q4_a4_v_iceland, q4_b4_v_newzealand, q4_c4_m_paris, q4_d4_north_pole;
    String a3a = "Cannonball";
    String a3b = "Cannon ball";
    String a3c = "Projectile";
    String a3d = "Columbiad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //Find values from layout.
        q1_a1_Troy = (RadioButton) findViewById(R.id.q1_a1_Troy);
        q1_b1_Rlyeh = (RadioButton) findViewById(R.id.q1_b1_Rlyeh);
        q1_c1_Mu = (RadioButton) findViewById(R.id.q1_c1_Mu);
        q1_d1_Atlantis = (RadioButton) findViewById(R.id.q1_d1_Atlantis);
        q2_a2_phileas_fogg = (CheckBox) findViewById(R.id.q2_a2_phileas_fogg);
        q2_b2_michel_ardan = (CheckBox) findViewById(R.id.q2_b2_michel_ardan);
        q2_c2_lidenbrock = (CheckBox) findViewById(R.id.q2_c2_lidenbrock);
        q2_d2_francis_cromarty = (CheckBox) findViewById(R.id.q2_d2_francis_cromarty);
        q2_e2_arne_saknussem = (CheckBox) findViewById(R.id.q2_e2_arne_saknussem);
        q3_a3_your_answer = (EditText) findViewById(R.id.q3_a3_your_answer);
        q4_a4_v_iceland = (RadioButton) findViewById(R.id.q4_a4_v_iceland);
        q4_b4_v_newzealand = (RadioButton) findViewById(R.id.q4_b4_v_newzealand);
        q4_c4_m_paris = (RadioButton) findViewById(R.id.q4_c4_m_paris);
        q4_d4_north_pole = (RadioButton) findViewById(R.id.q4_d4_north_pole);
    }

    public void submit(View view) {

        hideSoftKeyboard();
        int score = 0;

        //Checks the correct answer for Question 1.(Radio Buttons)
        if (q1_d1_Atlantis.isChecked()) score++;

        //Checks the correct answers for Question 2.(Checkboxes)
        if (!q2_a2_phileas_fogg.isChecked() && q2_b2_michel_ardan.isChecked()
                && q2_c2_lidenbrock.isChecked() && !q2_d2_francis_cromarty.isChecked()
                    && q2_e2_arne_saknussem.isChecked()) score += 3;

        //Checks the correct answer for Question 3.(EditText)
        String answer3 = q3_a3_your_answer.getText().toString();
        if (answer3.equalsIgnoreCase(a3a) || answer3.equalsIgnoreCase(a3b)
                || answer3.equalsIgnoreCase(a3c) || answer3.equalsIgnoreCase(a3d)) score += 5;

        //Checks the correct answer for Question 4.(Radio Buttons)
        if (q4_a4_v_iceland.isChecked()) score++;

        //Create a toast message for Score.
        Toast.makeText(getApplicationContext(), "You Score is: " + score + " out of 10.", Toast.LENGTH_LONG).show();

        //Create a toast message.
        if (score < 10)
            Toast.makeText(getApplicationContext(), "Would you like to try again?", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), "Awesome Job!", Toast.LENGTH_LONG).show();
    }

    /*for hiding keyboard.
    (https://stackoverflow.com/questions/4005728/hide-default-keyboard-on-click-in-android?noredirect=1&lq=1 "nv__")*/
    private void hideSoftKeyboard() {
        if (getCurrentFocus() != null && getCurrentFocus() instanceof EditText) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(q3_a3_your_answer.getWindowToken(), 0);
        }
    }

    // Create a new intent to open the {Answers Activity}.
    public void answers(View view) {
        startActivity(new Intent(getApplicationContext(), Answers.class));
    }

    /* Create a new intent to exit the app.
     (https://stackoverflow.com/questions/3226495/how-to-exit-from-the-application-and-show-the-home-screen "Lazy Ninja")*/
    public void quit(View view) {
        Intent intent = new Intent(Questions.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Exit", true);
        startActivity(intent);
        finish();
    }
}