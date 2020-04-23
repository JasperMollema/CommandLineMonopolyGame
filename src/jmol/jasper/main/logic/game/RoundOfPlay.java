package jmol.jasper.main.logic.game;

import jmol.jasper.Player.Logic.Player;

public class RoundOfPlay {
    private Player player;
    private int totalThrow;
    private boolean isDoubleTrow;
    private int nrOfThrows;

    public RoundOfPlay(Player player) {
        this.player = player;
    }

    public void play() {
        throwDice();
    }

    public boolean shouldBePrisoned() {
        boolean shouldBeJailed = nrOfThrows == 3 && isDoubleTrow;
        if (shouldBeJailed) {
            System.out.println(player + " heeft drie keer dubbel gegooid en moet naar de gevangenis!");
        }
        return shouldBeJailed;
    }

    public boolean canThrowAgain() {
        return isDoubleTrow && !shouldBePrisoned();
    }

    public boolean canBeReleasedFromPrison() {
        return isDoubleTrow;
    }

    private void throwDice() {
        int firstThrow = player.throwDice();
        int secondThrow = player.throwDice();
        isDoubleTrow = firstThrow == secondThrow;
        totalThrow = firstThrow + secondThrow;
        nrOfThrows ++;
        System.out.println(player + " heeft " + firstThrow + " en " + secondThrow + " gegooid!");
    }

    public int getTotalThrow() {
        return totalThrow;
    }
}
