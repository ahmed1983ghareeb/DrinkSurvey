package com.example.drinksurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.drinksurvey.model.Survey;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button btnAdd, btnNew, btnResults;
    EditText editTextClientNumber, editTextCupsNumber;
    Spinner spinnerType;
    RadioGroup rgJuice, rgSoft;
    ArrayList<Survey> surveys = new ArrayList<Survey>();
    private int clientNumberCounter=1;
    private int clientNumber,cupsNumber;
    private String drink,drinkType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        btnAdd = findViewById(R.id.btnAdd);
        btnNew = findViewById(R.id.btnNew);
        btnResults = findViewById(R.id.btnResults);
        btnResults.setOnClickListener(this);
        btnNew.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        editTextClientNumber = findViewById(R.id.editTextClientNumber);
        editTextClientNumber.setText(String.valueOf(clientNumberCounter));
        editTextCupsNumber = findViewById(R.id.editTextCupsNumbers);
        spinnerType = findViewById(R.id.spinnerDrinkType);
        rgJuice = findViewById(R.id.rBGJuice);
        rgSoft = findViewById(R.id.rBGSoftDrinks);
        rgSoft.setVisibility(RadioGroup.INVISIBLE);
        rgJuice.setVisibility(RadioGroup.INVISIBLE);
        spinnerType.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnNew:
                clearLayout();
                clientNumberCounter++;
                editTextClientNumber.setText(String.valueOf(clientNumberCounter));
                break;
            case R.id.btnAdd:
                setVariables();
                surveys.add(new Survey( clientNumber,  cupsNumber,  drink, drinkType));
                clearLayout();
                break;
            case R.id.btnResults:
                Intent intent = new Intent(this,ResultsActivity.class);
                intent.putExtra("tag",surveys);
                startActivity(intent);
                break;
        }

    }

    public void clearLayout(){
        editTextClientNumber.setText("");
        editTextCupsNumber.setText("");
        rgJuice.clearCheck();
        rgSoft.clearCheck();
    }

    public void setVariables(){
        clientNumber = Integer.valueOf(editTextClientNumber.getText().toString());
        cupsNumber = Integer.valueOf(editTextCupsNumber.getText().toString());

        switch (spinnerType.getSelectedItem().toString()) {
            case "Juice":
                int juice = 0;
                int rbJuiceId = rgJuice.getCheckedRadioButtonId();
                switch (rbJuiceId) {
                    case R.id.rbApple:
                        drink = "Apple";
                        break;
                    case R.id.rbOrange:
                        drink = "Orange";
                        break;
                    case R.id.rbMango:
                        drink = "Mango";
                        break;
                }//end switch(rbId)
                break;
            case "Soft Drink":
                int softDrink = 0;
                int rbSoftDrinkId = rgSoft.getCheckedRadioButtonId();
                switch (rbSoftDrinkId) {
                    case R.id.rbCoca:
                        drink = "Coca";
                        break;
                    case R.id.rbSprite:
                        drink = "Sprite";
                        break;
                    case R.id.rbSevenUp:
                        drink = "Seven Up";
                        break;
                }//end switch(rbId)
                break;
        }//end of switch

        drinkType = spinnerType.getSelectedItem().toString();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView SpinnerData = (TextView)view;

        switch (SpinnerData.getText().toString()){
        case "Juice":
            rgJuice.setVisibility(RadioGroup.VISIBLE);
            rgSoft.setVisibility(RadioGroup.INVISIBLE);
            break;
            case "Soft Drink":
            rgJuice.setVisibility(RadioGroup.INVISIBLE);
            rgSoft.setVisibility(RadioGroup.VISIBLE);
            break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
