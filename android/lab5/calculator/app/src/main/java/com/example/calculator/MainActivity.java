package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    TextView t1;
    int num1, num2;
    String s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //method to get the input numbers
    public boolean getNumbers() {

        e1 = (EditText) findViewById(R.id.num1);

        e2 = (EditText) findViewById(R.id.num2);

        t1 = (TextView) findViewById(R.id.result);

        s1 = e1.getText().toString();

        s2 = e2.getText().toString();

        // condition to check if box is not empty
        if ((s1.equals(null) || s2.equals(null))
                || (s1.equals("") || s2.equals(""))) {

            String result = "Please enter a value";
            t1.setText(result);

            return false;
        } else {
            num1 = Integer.parseInt(e1.getText().toString());
            num2 = Integer.parseInt(e2.getText().toString());
        }
        return true;
    }

    public void doSum(View view) {
        if (getNumbers()) {
            int sum = num1 + num2;
            t1.setText(Integer.toString(sum));
        }
    }

    public void doSub(View view) {
        if (getNumbers()) {
            int sum = num1 - num2;
            t1.setText(Integer.toString(sum));
        }
    }

    public void doMul(View view) {
        if (getNumbers()) {
            int sum = num1 * num2;
            t1.setText(Integer.toString(sum));
        }

    }

    public void doDiv(View view) {
        if (getNumbers()) {
            double sum = num1 / (num2 * 1.0);
            t1.setText(Double.toString(sum));
        }
    }

    public void doReset(View view) {
        e1.setText("");
        e2.setText("");
        t1.setText("");

    }
}