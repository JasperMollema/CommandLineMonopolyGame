package jmol.jasper.main.logic.actions;

public enum ActionType {
    BUY_PROPERTY("grond kopen"),
    BUY_HOUSES("huizen kopen"),
    SELL_HOUSES("huizen verkopen"),
    PAY_RENT("huur betalen"),
    GO_TO_JAIL("naar de gevangenis"),
    NO_PLAYER_ACTION("Geen actie"),
    PRINT_STATUS("Print status"),
    GO_TO_BOARDSPACE_REGULAR("Kaart actie"),
    GO_TO_BOARDSPACE_DIRECT(""),
    GO_THREE_SPACES_BACK(""),
    PAY(""),
    PAY_FOR_HOUSES_CARD(""),
    PAY_OR_DRAW_CHANCE_CARD("");

    /**
     * Message that describes the player action. The entire message that is displayed
     * when this action is chosen should be like: "Wil je [actionMessage]" .
     */
    private String actionMessage;

    private ActionType(String actionMessage) {this.actionMessage = actionMessage;}

    public String getActionMessage(){return actionMessage;}
}

