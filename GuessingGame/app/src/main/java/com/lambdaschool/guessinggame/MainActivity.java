package com.lambdaschool.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    EditText userInput;
    Button resetButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random generator = new Random();
        final int num = generator.nextInt(101);

        userInput = findViewById(R.id.input_text);
        submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String response = String.valueOf(userInput.getText().toString());
                Log.i("Demo", response);
                int value = Integer.parseInt(response);
                String res = checkGuess(value, num);
                updateUI(res);
            }
        });

        resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random generator = new Random();
                final int num = generator.nextInt(101);
            }
        });
    }


    public static String checkGuess(int guess, int num) {
        String result;
        if(guess == num) {
            result = "Congratulations! You guessed the correct number!";
        }
        else if(guess < num) {
            result = "Your guess was too low.";
        }
        else if(guess > num) {
            result = "Your guess was too high.";
        }
            //case RESET:
             //   result = "Guess a number between 1 and 100.";
        else {
            result = "You must choose a number between 1 and 100.";
        }
        return result;
    }

    public void updateUI(String result) {
        TextView textResponse = findViewById(R.id.text_response);
        textResponse.setText(result);
    }
    
}
