package jmol.jasper.main.data.miscellaneous;

import jmol.jasper.main.logic.actions.ActionType;

public class Card {
    private String message;
    private ActionType actionType;
    private int amtToPayOrRecieve;
    private Integer nextBoardspaceNr;
    private boolean payRecFromOthers;
    private boolean isGetOutOfJailCard;

    protected Card(String message, ActionType actionType, int amtToPayOrRecieve,
                   Integer nextBoardspaceNr, boolean payRecFromOthers, boolean isGetOutOfJailCard) {
        this.message = message;
        this.actionType = actionType;
        this.amtToPayOrRecieve = amtToPayOrRecieve;
        this.nextBoardspaceNr = nextBoardspaceNr;
        this.payRecFromOthers = payRecFromOthers;
        this.isGetOutOfJailCard = isGetOutOfJailCard;
    }

    public String getMessage() {
        return message;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public int getAmtToPayOrRecieve() {
        return amtToPayOrRecieve;
    }


    public boolean isPayRecFromOthers() {
        return payRecFromOthers;
    }

    public boolean isGetOutOfJailCard() {
        return isGetOutOfJailCard;
    }
}

