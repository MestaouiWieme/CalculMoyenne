package com.example.calculmoyenne;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText dc, ds, tp;
    TextView result;
    String res;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dc = findViewById(R.id.notedc);
        ds = findViewById(R.id.noteds);
        tp = findViewById(R.id.notetp);
        result = findViewById(R.id.result);


    }

    public double pourc(double note, double pour) {
        return (note * pour) / 100;
    }


    public void CalculerMoyenne(View view) {



        double ndc = Double.parseDouble(dc.getText().toString());
        double nds = Double.parseDouble(ds.getText().toString());
        double ntp = Double.parseDouble(tp.getText().toString());

        if((ndc>=0 && ndc<=20) && (nds>=0 && nds<=20) && (ntp>=0 && ntp<=20)) {

            double ndcf = pourc(ndc, 20);
            double ndsf = pourc(nds, 60);
            double ntpf = pourc(ntp, 20);

            
            double moyenne = ndcf + ntpf + ndsf;

            res = "Votre Moyenne est: " + moyenne;

            result.setText(res);
            dc.getText().clear();
            ds.getText().clear();
            tp.getText().clear();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Les notes doivent etre entre 0 et 20...", Toast.LENGTH_SHORT).show();
        }
    }
    }

