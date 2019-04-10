package com.bmi_nishankhadka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvoutput;
    private EditText txtheight, txtweight;
    private Button btncalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvoutput = findViewById(R.id.tvoutput);
        txtheight = findViewById(R.id.txtheight);
        txtweight = findViewById(R.id.txtweight);
        btncalculate = findViewById(R.id.btncalculate);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    CalculateBMI result = new CalculateBMI();
                    double height = Double.parseDouble(txtheight.getText().toString());
                    double weight = Double.parseDouble(txtweight.getText().toString());
                    double bmi = result.calculateBMI(height, weight);
                    tvoutput.setText(Double.toString(bmi));

                    if(bmi<18.5)
                    {
                      Toast newtoast = Toast.makeText(MainActivity.this, "Underweight", Toast.LENGTH_LONG);
                      newtoast.show();

                    }
                    else if(bmi>=18.5 && bmi<=24.9)
                    {
                    Toast newtoast1 = Toast.makeText(MainActivity.this,"Normal",Toast.LENGTH_LONG);
                    newtoast1.show();
                    }
                    else if(bmi>=25&&bmi<=29.9)
                    {
                        Toast newtoast2 = Toast.makeText(MainActivity.this,"Overweight",Toast.LENGTH_LONG);
                        newtoast2.show();
                    }
                    else if(bmi >=30)
                    {
                        Toast newtoast3 = Toast.makeText(MainActivity.this,"obesity",Toast.LENGTH_LONG);
                        newtoast3.show();
                    }


                }
            }
        });


    }

    private boolean validate() {
        if (TextUtils.isEmpty(txtheight.getText().toString())) {
            txtheight.setError("Enter your height");
            txtheight.requestFocus();
            return false;
        } else if (TextUtils.isEmpty((txtweight.getText().toString()))) {
            txtweight.setError("Enter your weight");
            txtweight.requestFocus();
            return false;
        }
        return true;

    }
}
