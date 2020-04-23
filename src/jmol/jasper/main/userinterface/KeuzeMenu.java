package jmol.jasper.main.userinterface;

import jmol.jasper.main.logic.actions.PrintPlayerStatus;
import jmol.jasper.main.logic.actions.playeractions.BuyHousesAction;
import jmol.jasper.main.logic.actions.playeractions.PlayerAction;
import jmol.jasper.main.logic.actions.playeractions.SellHouseBoardSpaceAction;

public class KeuzeMenu {
    private String[] optionsBeforeTurn;
    private String[] optionsAfterTurn;
    private String startMenu = "Wat wil je doen?";
    private final String DOBBELSTEEN_GOOIEN = "Dobbelsteen gooien";
    private final String HUIZEN_KOPEN = "Huizen kopen";
    private final String HUIZEN_VERKOPEN = "Huizen verkopen";
    private final String PRINT_OVERZICHT = "Bekijk bezittingen";
    private final String EINDE_BEURT = "Einde beurt";

    public KeuzeMenu() {
        optionsBeforeTurn = new String[] {
                DOBBELSTEEN_GOOIEN,
                HUIZEN_KOPEN,
                HUIZEN_VERKOPEN,
                PRINT_OVERZICHT
        };

        optionsAfterTurn = new String[] {
                HUIZEN_KOPEN,
                HUIZEN_VERKOPEN,
                PRINT_OVERZICHT,
                EINDE_BEURT
        };
    }
    public PlayerAction getChoiceBeforeTurn() {
        int choice = ExpressionProvider.getInstance().getOption(optionsBeforeTurn, startMenu);
        return getChoice(optionsBeforeTurn[choice]);
    }

    public PlayerAction getChoiceAfterTurn() {
        int choice = ExpressionProvider.getInstance().getOption(optionsAfterTurn, startMenu);
        return getChoice(optionsAfterTurn[choice]);
    }

    private PlayerAction getChoice(String choice) {
        switch (choice) {
            case HUIZEN_KOPEN:
                return new BuyHousesAction();
            case HUIZEN_VERKOPEN:
                return new SellHouseBoardSpaceAction();
            case PRINT_OVERZICHT:
                return new PrintPlayerStatus();
            default:
                return null;
        }
    }
}
