package jmol.jasper.main.userinterface;

public class ExpressionProvider {
    private static volatile ExpressionProvider instance;
    private UserInputReader userInputReader;
    private String defaultErrorMessage;

    private ExpressionProvider() {
        userInputReader = new UserInputReader();
        defaultErrorMessage = "Dat is geen geldige invoer.";
    }

    public static ExpressionProvider getInstance() {
        if (instance == null) {
            synchronized (ExpressionProvider.class) {
                if (instance == null) {
                    instance = new ExpressionProvider();
                }
            }
        }
        return instance;
    }

    /**
     * Gets a String from the user. A specific length can be specified. When both upper and
     * lowerbound are null, any String is returned.
     * @param question Question to be asked.
     * @param lowerBound Minimum length of the requested String.
     * @param upperBound Maximum length of the requested String.
     * @param errorMessage Message displayed when the user does not enter a String within the given boundaries.
     *                     When null, the default error message is displayed
     * @return
     */
    public String getString(String question, Integer lowerBound, Integer upperBound, String errorMessage) {
        System.out.println(question);
        String answer = userInputReader.getString();
        boolean isValidString = ExpressionValidator.getInstance().isValidStringWithBoundaries(answer, lowerBound, upperBound);
        while (!isValidString) {
            if (errorMessage == null) {
                System.out.println(defaultErrorMessage);
            }
            else {
                System.out.println(errorMessage);
            }
            System.out.println(question);
            answer = userInputReader.getString();
            isValidString = ExpressionValidator.getInstance().isValidStringWithBoundaries(answer, lowerBound, upperBound);
        }
        return answer;
    }

    public Integer getNumberWithinBoundary(String question, int lowerBound, int upperBound, String errorMessage) {
        System.out.println(question);
        Integer number = userInputReader.getIntegerWithBoundary(lowerBound, upperBound);
        boolean isValidInteger = ExpressionValidator.getInstance().isValidInteger(number);
        while (!isValidInteger) {
            System.out.println(errorMessage);
            System.out.println(question);
            number = userInputReader.getIntegerWithBoundary(lowerBound, upperBound);
            isValidInteger = ExpressionValidator.getInstance().isValidInteger(number);
        }
        return number;
    }

    /**
     * Gets a number from the user.
     * @param question The question.
     * @return the number chosen.
     */
    public Integer getNumber(String question) {
        System.out.println(question);
        Integer number = userInputReader.getInteger();
        boolean isValidInteger = ExpressionValidator.getInstance().isValidInteger(number);
        while (!isValidInteger) {
            System.out.println(defaultErrorMessage);
            System.out.println(question);
            number = userInputReader.getInteger();
            isValidInteger = ExpressionValidator.getInstance().isValidInteger(number);
        }
        return number;
    }

    /**
     *  Presents an x number of options and let the user choose one.
     * @param options The options from which the user can choose.
     * @return the index of the option chosen.
     */
    public Integer getOption(String[] options, String question) {
        System.out.println(question);
        for (int i=0; i<options.length; i++) {
            int option = i + 1;
            System.out.println("Kies " + option + ": " + options[i]);
        }
        Integer choice = userInputReader.getIntegerWithBoundary(1, options.length);
        boolean isValidChoice = ExpressionValidator.getInstance().isValidInteger(choice);
        while (!isValidChoice) {
            System.out.println(defaultErrorMessage);
            System.out.println(question);
            choice = userInputReader.getIntegerWithBoundary(1, options.length);
            isValidChoice =  ExpressionValidator.getInstance().isValidInteger(choice);
        }
        return choice - 1;
    }

    /**
     * Gets a yes or no answer from the user.
     * @param question The question from which you want a yes or no answer.
     * @return The answer from the user.
     */
    public Boolean getBoolean(String question) {
        System.out.println(question);
        Boolean userResponse = userInputReader.getBoolean();
        while (!ExpressionValidator.getInstance().isValidBoolean(userResponse)) {
            System.out.println(question);
            System.out.println("Voer ja, j, yes, y voor ja en nee, no, n voor nee");
            userResponse = userInputReader.getBoolean();
        }
        return userResponse;
    }
}
