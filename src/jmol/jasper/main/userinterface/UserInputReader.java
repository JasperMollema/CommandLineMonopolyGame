package jmol.jasper.main.userinterface;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class which takes input from the user.
 */

public class UserInputReader {
    private String input;
    private String formattedInput;
    private Scanner scanner;
    private List<String> validBooleans;
    private int dataType;
    private final int INTEGER = 0;
    private final int CHARACTER = 1;
    private final int BOOLEAN = 2;
    private final int STRING = 3;
    private final int INVALID_CHOICE = -1;

    public UserInputReader(){
        scanner = new Scanner(System.in);
        validBooleans = Arrays.asList(new String[]{"yes", "y", "ja", "j", "no", "n", "nee"});
    }

    public String getString(){
        if (!getInputFromUser(STRING)) {
            return null;
        }
        return input;
    }

    public Character getCharacter(){
        if (!getInputFromUser(CHARACTER)) {
            return null;
        }
        return input.charAt(0);
    }

    public Integer getInteger(){
        if (!getInputFromUser(INTEGER)) {
            return null;
        }
        return Integer.parseInt(input);
    }

    public Integer getIntegerWithBoundary(int lowerBound, int upperBound) {
        if (!getInputFromUser(INTEGER)) {
            return null;
        }
        Integer answer = Integer.parseInt(input);
        if (answer < lowerBound || answer > upperBound) {
            return null;
        }
        return answer;
    }

    public Boolean getBoolean() {
        if (!getInputFromUser(BOOLEAN)) {
            return null;
        }
        return input.contains("y") || input.contains("j");
    }

    public Integer getMultipleChoiceAnswer(String[] options) {
        if (!getInputFromUser(STRING)) {
            return null;
        }
        // Check if the answer is a valid option.
        Integer choice = getChoiceFromArray(formatStringArray(options));
        if (choice == INVALID_CHOICE) {
            return null;
        }
        return choice;
    }

    private boolean getInputFromUser(int requestedDataType) {
        dataType = requestedDataType;
        try {
            input = scanner.nextLine();
            formatInput();
            return checkIfInputIsValid();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean checkIfInputIsValid() {
        final int dataTypeToBeChecked = dataType;
        switch (dataTypeToBeChecked) {
            case INTEGER:
                return checkInputForInteger();
            case CHARACTER:
                return checkInputForCharacter();
            case BOOLEAN:
                return checkInputForBoolean();
            case STRING:
                return checkInputForString();
            default: return false;
        }
    }

    private Integer getChoiceFromArray (String[] formattedOptions) {
        Integer choice = INVALID_CHOICE;
        for (int i = 0; i < formattedOptions.length; i++) {
            if (formattedInput.equals(formattedOptions[i])) {
            choice = i;
            }
        }
        return choice;
    }

    private boolean checkInputForInteger (){
        try {
            Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private boolean checkInputForCharacter (){
        if (formattedInput.length() != 1){
            return false;
        }
        return true;
    }

    private boolean checkInputForBoolean(){
        if (!validBooleans.contains(formattedInput)) {
            return false;
        }
        return true;
    }

    private boolean checkInputForString() {
        if (input.equals("")) {
            return false;
        }
        int whiteSpaces = 0;
        for (int i = 0; i < formattedInput.length(); i++) {
            if (formattedInput.charAt(i) == ' ') {
                whiteSpaces ++;
            }
        }
        return whiteSpaces != formattedInput.length();
    }

    private String[] formatStringArray(String[] strings) {
        String[] formattedStrings = new String[strings.length];
        for (int i=0; i<strings.length; i++) {
            String formattedString = strings[i].trim().toLowerCase();
            formattedStrings[i] = formattedString;
        }
        return formattedStrings;
    }

    private void formatInput () {
        formattedInput = input.toLowerCase().trim();
    }
}
