package com.example.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightInch;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout main1;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt= findViewById(R.id.edtHeightFt);
        edtHeightInch= findViewById(R.id.edtHeightInch);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        main1 = findViewById(R.id.mainLayout);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int inch = Integer.parseInt(edtHeightInch.getText().toString());

                int totalInch = ft*12 + inch;
                double totalCm = totalInch * 2.53;
                double totalM = totalCm/100;

                double BMI = wt/(totalM*totalM);
                if (BMI>25)
                {
                    txtResult.setText(" You're Overweight");
                    main1.setBackgroundColor(getResources().getColor(R.color.colorOW));
                }
                else if(BMI<18)
                {
                    txtResult.setText(" You're Underweight");
                    main1.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }
                else
                {
                    txtResult.setText("  You're Healthy");
                    main1.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });
    }
}