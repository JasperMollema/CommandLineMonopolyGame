package jmol.jasper.main.logic.actions.playeractions;

public enum TransactionType {
    ONE_HOUSE("1 huis"), TWO_HOUSES("2 huizen"), HOTEL("een hotel"), HOUSE_AND_HOTEL("een hotel en een huis"), NO_TRANSACTION("");

    private String message;

    TransactionType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
