package com.machinacyfrowa.electriainapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity implements View.OnClickListener {
    private Button buttonAdd, btn_count1;
    private EditText editText1, editText2, editText3, editText4;
    private TextView textView;
    private double weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonAdd = findViewById(R.id.btn_count);
        btn_count1 = findViewById(R.id.btn_count1);
        editText1 = findViewById(R.id.number1);
        editText2 = findViewById(R.id.number2);
        editText3 = findViewById(R.id.number3);
        editText4 = findViewById(R.id.editText4);
        textView = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        btn_count1.setOnClickListener(this);
    }

    public double getDoubleFromEditText(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Wprowadz liczbe", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Double.parseDouble(editText.getText().toString());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_count:
                double num1 = getDoubleFromEditText(editText1);
                double num2 = getDoubleFromEditText(editText2);
                double num3 = getDoubleFromEditText(editText3);
                double density = 8.96;
                double area = num2 / 1000;
                double volume = area * num1;
                double width = num3;

                double densityInGramsPerCubicMeter = density * 1000;
                weight = volume * densityInGramsPerCubicMeter * width;

                textView.setText("Kabel ma  " + weight + " gramow miedzi ");
                break;

            case R.id.btn_count1:
                String copperPriceText = editText4.getText().toString();
                if (copperPriceText.isEmpty()) {
                    Toast.makeText(this, "Wprowadz cene miedzi ", Toast.LENGTH_SHORT).show();
                } else {
                    double copperPrice = Double.parseDouble(copperPriceText);

                    double kilogram = weight / 1000;

                    double valueInPLN = kilogram * copperPrice;

                    textView.setText("Za miedz otrzymasz : " + valueInPLN + "Zł ");
                }
                break;
        }
    }
}
