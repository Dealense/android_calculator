package com.example.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    private static final String SHESANAXI = "shesanaxi";
    private TextView formula, pasuxi;
    private Integer number = 0;
    private String operation = "", manamde = "0";
    private String[] operations = { "+", "-", "%", "*"};
    private String[] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getnum(View v){
        formula = findViewById(R.id.formula);
        pasuxi = findViewById(R.id.pasuxi);
        String test = (String) formula.getText();
        TextView clickedTextView = (TextView) v;
        String shemosuli = (String) clickedTextView.getText().toString();
        if (Arrays.asList(operations).contains(shemosuli)) {
            operation = shemosuli;
            number = Integer.parseInt(manamde);
            if((String) pasuxi.getText() == "" || pasuxi.getText() == null) {
                number = Integer.parseInt(manamde);
            }else{
                number = Integer.parseInt((String) pasuxi.getText());
            }
            manamde = "0";
            formula.setText(test + shemosuli);
        }else if(operation != "" && Arrays.asList(numbers).contains(shemosuli)){
            if(manamde == "0"){
                manamde = shemosuli;
            }else{
                manamde = manamde + shemosuli;
            }
            if(operation.equals("+")){
                int test1 = (int) number + Integer.parseInt(manamde);
                pasuxi.setText(String.valueOf(test1));
            }else if(operation.equals("-")){
                int test1 = (int) number - Integer.parseInt(manamde);
                pasuxi.setText(String.valueOf(test1));
            }else if(operation.equals("*")) {
                int test1 = (int) number * Integer.parseInt(manamde);
                pasuxi.setText(String.valueOf(test1));
            }else if(operation.equals("%")) {
                int test1 = (int) number / Integer.parseInt(manamde);
                pasuxi.setText(String.valueOf(test1));
            }
            formula.setText(test + shemosuli);
        }else if(Arrays.asList(numbers).contains(shemosuli)){
            if(manamde == "0"){
                manamde = shemosuli;
            }else{
                manamde = manamde + shemosuli;
            }
            formula.setText(test + shemosuli);
        }else if(shemosuli.equals("CE")) {
            SharedPreferences.Editor sharededitor = getSharedPreferences(SHESANAXI, MODE_PRIVATE).edit();
            sharededitor.putString("wina", String.valueOf(pasuxi.getText()));
            sharededitor.putString("winaformula", String.valueOf(formula.getText()));
            sharededitor.apply();
            pasuxi.setText("");
            formula.setText("");
        }else if(shemosuli.equals("წინა")){
            SharedPreferences sharedload = getSharedPreferences(SHESANAXI, MODE_PRIVATE);
            formula.setText(sharedload.getString("winaformula", ""));
            pasuxi.setText(sharedload.getString("wina", ""));

        }
        }
}
