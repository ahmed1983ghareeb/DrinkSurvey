package com.example.drinksurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.drinksurvey.model.Survey;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
    int[] textViewsTotalIds = {R.id.textViewTotalApple, R.id.textViewTotalOrange, R.id.textViewTotalMango, R.id.textViewTotalCoca,
            R.id.textViewTotalSprite, R.id.textViewTotalSevenUp};
    int[] textViewsPercentageIds = {R.id.textViewPApple, R.id.textViewPOrange, R.id.textViewPMango, R.id.textViewPCoca,
            R.id.textViewPSprite, R.id.textViewPSevenUp};
    TextView[] textViewTotal = new TextView[6];
    int[] total = new int[6];
    ArrayList<Survey> surveys = new ArrayList<Survey>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        surveys = (ArrayList<Survey>) getIntent().getSerializableExtra("tag");
        initialize();

    }

    public void initialize() {
        for(int i = 0;i< surveys.size();i++){
            getJuiceCounter(surveys.get(i).getDrink(),i);
        }

        for(int i = 0 ; i<total.length;i++){
            textViewTotal[i] = findViewById(textViewsTotalIds[i]);
            textViewTotal[i].setText(String.valueOf(total[i]));
        }
    }

    public void getJuiceCounter(String juice, int index) {


        switch (juice) {

            case "Apple":
                total[0] += surveys.get(index).getCupsNumber();
                break;
            case "Orange":
                total[1] += surveys.get(index).getCupsNumber();
                break;
            case "Mango":
                total[2] += surveys.get(index).getCupsNumber();
                break;
            case "Coca":
                total[3] += surveys.get(index).getCupsNumber();
                break;
            case "Sprite":
                total[4] += surveys.get(index).getCupsNumber();
                break;
            case "Seven Up":
                total[5] += surveys.get(index).getCupsNumber();
                break;
        }//end switch

    }

}
