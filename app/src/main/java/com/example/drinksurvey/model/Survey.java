package com.example.drinksurvey.model;

import java.io.Serializable;

public class Survey implements Serializable {
    private int clientNumber,cupsNumber;
    private String drink,drinkType;

    public Survey(int clientNumber, int cupsNumber, String drink, String drinkType) {
        this.clientNumber = clientNumber;
        this.cupsNumber = cupsNumber;
        this.drink = drink;
        this.drinkType = drinkType;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public int getCupsNumber() {
        return cupsNumber;
    }

    public String getDrink() {
        return drink;
    }

    public String getDrinkType() {
        return drinkType;
    }


}
