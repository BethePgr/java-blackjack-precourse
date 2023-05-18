package domain.validate.inputView;

public class ValidateInputPlayerContinueGame {

    public static void validateContinue(String input) {
        if (!input.equals("y") && !input.equals("n")) {
            throw new IllegalArgumentException("[ERROR] y나 n만 입력해주세요.");
        }
    }

}
