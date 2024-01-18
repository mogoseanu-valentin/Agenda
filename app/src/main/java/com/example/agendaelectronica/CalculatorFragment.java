package com.example.agendaelectronica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class CalculatorFragment extends Fragment {

    private TextView display;
    private String currentNumber = "";
    private String operator = "";
    private double result = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        display = view.findViewById(R.id.display);

        int[] numberIds = new int[]{R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
        for (int id : numberIds) {
            view.findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button b = (Button) v;
                    currentNumber += b.getText().toString();
                    display.setText(currentNumber);
                }
            });
        }

        int[] operatorIds = new int[]{R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide};
        for (int id : operatorIds) {
            view.findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button b = (Button) v;
                    operator = b.getText().toString();
                    result = Double.parseDouble(currentNumber);
                    currentNumber = "";
                }
            });
        }

        view.findViewById(R.id.btnEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator.equals("+")) {
                    result += Double.parseDouble(currentNumber);
                } else if (operator.equals("-")) {
                    result -= Double.parseDouble(currentNumber);
                } else if (operator.equals("*")) {
                    result *= Double.parseDouble(currentNumber);
                } else if (operator.equals("/")) {
                    result /= Double.parseDouble(currentNumber);
                }
                operator = "";
                currentNumber = Double.toString(result);
                display.setText(currentNumber);
            }
        });

        view.findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = "";
                operator = "";
                result = 0;
                display.setText("");
            }
        });

        return view;
    }
}
