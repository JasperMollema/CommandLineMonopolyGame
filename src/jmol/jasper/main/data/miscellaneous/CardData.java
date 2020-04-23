package jmol.jasper.main.data.miscellaneous;

import jmol.jasper.MonopolyGame.Actions.ActionType;

public class CardData {
    private static CardBuilder cardBuilder = new CardBuilder();

    public static final Card[] communityChestCards = new Card[] {
            cardBuilder.setMessage("U ontvangt rente van 7% preferente aandelen 25 euro").setActionType(ActionType.PAY).setAmtToPayOrReceive(25).build(),
            cardBuilder.setMessage("Lijfrente vervalt, u ontvangt 100 euro").setActionType(ActionType.PAY).setAmtToPayOrReceive(100).build(),
            cardBuilder.setMessage("Restitutie inkomstenbelasting, u ontvangt ƒ 20").setActionType(ActionType.PAY).setAmtToPayOrReceive(20).build(),
            cardBuilder.setMessage("U erft ƒ 100").setActionType(ActionType.PAY).setAmtToPayOrReceive(100).build(),
            cardBuilder.setMessage("Een vergissing van de bank in uw voordeel, u ontvangt ƒ 200").setActionType(ActionType.PAY).setAmtToPayOrReceive(200).build(),
            cardBuilder.setMessage("Betaal het hospitaal ƒ 100").setActionType(ActionType.PAY).setAmtToPayOrReceive(-100).build(),
            cardBuilder.setMessage("U hebt de tweede prijs in een schoonheidswedstrijd gewonnen en ontvangt ƒ 10").setActionType(ActionType.PAY).setAmtToPayOrReceive(10).build(),
            cardBuilder.setMessage("Betaal uw doktersrekening ƒ 50").setActionType(ActionType.PAY).setAmtToPayOrReceive(-50).build(),
            cardBuilder.setMessage("Betaal uw verzekeringspremie ƒ 50").setActionType(ActionType.PAY).setAmtToPayOrReceive(-50).build(),
            cardBuilder.setMessage("U bent jarig en ontvangt van iedere speler ƒ 10").setActionType(ActionType.PAY).setAmtToPayOrReceive(10).setPayRecFromOthers(true).build(),
            cardBuilder.setMessage("Ga verder naar 'Start'").setActionType(ActionType.GO_TO_BOARDSPACE_REGULAR).setNextBoardspaceNr(MonopolyBoardData.SPACENR_START).build(),
            cardBuilder.setMessage("Ga terug naar Dorpsstraat (Ons Dorp)").setActionType(ActionType.GO_TO_BOARDSPACE_DIRECT).setNextBoardspaceNr(MonopolyBoardData.SPACENR_DORPSSTRAAT).build(),
            cardBuilder.setMessage("Ga direct naar de gevangenis. Ga niet langs 'Start', u ontvangt geen ƒ 200").setActionType(ActionType.GO_TO_JAIL).build(),
            cardBuilder.setMessage("Door verkoop van effecten ontvangt u ƒ 50").setActionType(ActionType.PAY).setAmtToPayOrReceive(50).build(),
            cardBuilder.setMessage("Verlaat de gevangenis zonder betalen").setActionType(ActionType.NO_PLAYER_ACTION).setGetOutOfJailCard(true).build(),
            cardBuilder.setMessage("Betaal ƒ 10 boete of neem een Kanskaart").setActionType(ActionType.PAY_OR_DRAW_CHANCE_CARD).setAmtToPayOrReceive(-10).build()
    };

    public static final Card[] chanceCards = new Card[]{
            cardBuilder.setMessage("Ga verder naar Barteljorisstraat. Indien u langs \"Start\" komt, ontvangt u ƒ 200").setActionType(ActionType.PAY).setAmtToPayOrReceive(200).build(),
            cardBuilder.setMessage("Reis naar station \"West\" en indien u langs \"Start\" komt, ontvangt u ƒ 200").setActionType(ActionType.GO_TO_BOARDSPACE_REGULAR).setNextBoardspaceNr(MonopolyBoardData.SPACENR_STATION_WEST).build(),
            cardBuilder.setMessage("Ga verder naar \"Start\"").setActionType(ActionType.GO_TO_BOARDSPACE_REGULAR).setNextBoardspaceNr(MonopolyBoardData.SPACENR_START).build(),
            cardBuilder.setMessage("Ga drie plaatsen terug").setActionType(ActionType.GO_THREE_SPACES_BACK).build(),
            cardBuilder.setMessage("Ga verder naar Kalverstraat").setActionType(ActionType.GO_TO_BOARDSPACE_REGULAR).setNextBoardspaceNr(MonopolyBoardData.SPACENR_KALVERSTRAAT).build(),
            cardBuilder.setMessage("Ga verder naar de Herestraat. Indien u langs \"Start\" komt ontvangt u ƒ 200").setActionType(ActionType.GO_TO_BOARDSPACE_REGULAR).setNextBoardspaceNr(MonopolyBoardData.SPACENR_HEERESTRAAT).build(),
            cardBuilder.setMessage("De bank betaalt u ƒ 50 dividend").setActionType(ActionType.PAY).setAmtToPayOrReceive(50).build(),
            cardBuilder.setMessage("U hebt een kruiswoordpuzzel gewonnen en ontvangt ƒ 100").setActionType(ActionType.PAY).setAmtToPayOrReceive(100).build(),
            cardBuilder.setMessage("Boete voor te snel rijden ƒ 15").setActionType(ActionType.PAY).setAmtToPayOrReceive(-15).build(),
            cardBuilder.setMessage("Betaal schoolgeld ƒ 150").setActionType(ActionType.PAY).setAmtToPayOrReceive(-150).build(),
            cardBuilder.setMessage("Uw bouwverzekering vervalt, u ontvangt ƒ 150").setActionType(ActionType.PAY).setAmtToPayOrReceive(150).build(),
            cardBuilder.setMessage("Aangehouden wegens dronkenschap ƒ 20 boete").setActionType(ActionType.PAY).setAmtToPayOrReceive(-20).build(),
            cardBuilder.setMessage("Verlaat de gevangenis zonder te betalen").setActionType(ActionType.NO_PLAYER_ACTION).setGetOutOfJailCard(true).build(),
            cardBuilder.setMessage("Repareer uw huizen. Betaal voor elk huis ƒ 25, betaal voor elk hotel ƒ 100").setActionType(ActionType.PAY_FOR_HOUSES_CARD).build(),
            cardBuilder.setMessage("Ga direct naar de gevangenis. Ga niet langs 'Start'. U ontvangt geen ƒ 200").setActionType(ActionType.GO_TO_JAIL).build(),
            cardBuilder.setMessage("U wordt aangeslagen voor straatgeld. ƒ 40 per huis, ƒ 115 per hotel").setActionType(ActionType.PAY_FOR_HOUSES_CARD).build(),
    };
}
