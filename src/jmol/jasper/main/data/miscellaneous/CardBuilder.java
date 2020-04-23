package jmol.jasper.main.data.miscellaneous;

import jmol.jasper.MonopolyGame.Actions.ActionType;

public class CardBuilder {
    private String message;
    private ActionType actionType;
    private int amtToPayOrReceive;
    private Integer nextBoardspaceNr;
    private boolean payRecFromOthers;
    private boolean isGetOutOfJailCard;

    public Card build() {
        return new Card(message, actionType, amtToPayOrReceive,
                nextBoardspaceNr, payRecFromOthers, isGetOutOfJailCard);
    }

    public CardBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public CardBuilder setActionType(ActionType actionType) {
        this.actionType = actionType;
        return this;
    }

    public CardBuilder setAmtToPayOrReceive(int amtToPayOrReceive) {
        this.amtToPayOrReceive = amtToPayOrReceive;
        return this;
    }

    public CardBuilder setNextBoardspaceNr(Integer nextBoardspaceNr) {
        this.nextBoardspaceNr = nextBoardspaceNr;
        return this;
    }

    public CardBuilder setPayRecFromOthers(boolean payRecFromOthers) {
        this.payRecFromOthers = payRecFromOthers;
        return this;
    }

    public CardBuilder setGetOutOfJailCard(boolean getOutOfJailCard) {
        isGetOutOfJailCard = getOutOfJailCard;
        return this;
    }
}
