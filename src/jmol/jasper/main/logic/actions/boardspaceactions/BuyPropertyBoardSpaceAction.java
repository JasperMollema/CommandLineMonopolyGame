package jmol.jasper.main.logic.actions.boardspaceactions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Property;
import jmol.jasper.MonopolyBoard.Data.Bank;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

public class BuyPropertyBoardSpaceAction implements BoardSpaceAction {

    @Override
    public void handleAction(Player player) {
        Bank bank = new Bank();
        Property property = (Property) MonopolyBoardData.getBoardspace(player.getBoardspaceNr());

        // Ask if player wants to buy the property:
        if (!ExpressionProvider.getInstance().
                getBoolean(("Wil je " + property.getName() + " kopen? Het kost " +
                        property.VALUE + " euro."))){
            return;
        }

        // Check if the player can buy the property;
        if (!player.canAffordPayment(property.VALUE)){
            System.out.println("Je hebt niet genoeg geld!");
            return;
        }

        // Buy the property
        bank.buyPropertyFromBank(player, property);
        player.buyProperty(property);
        property.buyProperty(player);

        System.out.println(player.getName() + " is nu eigendom van: " + property.getName());
    }
}
