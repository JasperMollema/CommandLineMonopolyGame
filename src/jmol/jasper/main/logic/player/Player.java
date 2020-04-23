package jmol.jasper.main.logic.player;

import jmol.jasper.MonopolyBoard.BoardSpaces.Property;

import java.util.*;

public class Player {
    private String name;
    private int amountOfMoney;
    private int boardspaceNr;
    private Random dice;
    private List<Property> properties;
    private Map<String, Integer> propertyMap;
    private boolean isGameOver;
    private int nrGetOutOfJailCards;

    public Player(String name){
        this.name = name;
        this.amountOfMoney = 1500;
        this.boardspaceNr = 0;
        properties = new ArrayList<>();
        dice = new Random();
        propertyMap = new HashMap<>();
    }

    public int throwDice() {
        int am = dice.nextInt(5) +1;
        return am;
    }

    public void buyProperty(Property property){
        properties.add(property);
        payMoney(property.VALUE);
    }

    public void moveToBoardspace(int boardspaceNr) {
        this.boardspaceNr = boardspaceNr;
    }

    public boolean receiveMoney(int amount) {
        if (amount < 0) {
            return false;
        }
        amountOfMoney += amount;
        return true;
    }

    public int payMoney(int amount) {
        int payedAmount;
        if (amount < 0) {
            return 0;
        }
        if (!canAffordPayment(amount)) {
            payedAmount = amountOfMoney;
            amountOfMoney = 0;
        } else {
            payedAmount = amount;
            amountOfMoney -= amount;
        }
        return payedAmount;
    }

    public boolean canAffordPayment(int amtToPay) {
        return amountOfMoney >= amtToPay;
    }

    @Override
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public int getBoardspaceNr() {
        return boardspaceNr;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void playGetOutOfJailCard() {
        nrGetOutOfJailCards -= 1;
    }

    public boolean hasGetOutOfJailCard() {
        return nrGetOutOfJailCards > 0;
    }
}

