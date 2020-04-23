package jmol.jasper.main.logic.actions.boardspaceactions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Property;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.Player.Logic.Player;


public class PayRentBoardSpaceAction implements BoardSpaceAction {

    @Override
    public void handleAction(Player player) {
        Property property = (Property) MonopolyBoardData.getBoardspace(player.getBoardspaceNr());
        Player owner = property.getOwner();
        if (player.equals(owner)) {
            System.out.println(player.getName() + " is eigendom van " + property.getName());
            return;
        }
        int rent = property.calculateRent();
        int payedRent = player.payMoney(rent);
        owner.receiveMoney(payedRent);
        if (!(rent == payedRent)) {
            System.out.println(player.getName() + " kan de huur niet betalen!");
        }
        System.out.println(player.getName() + " betaald " + payedRent + " euro aan " + owner.getName());
    }
}
