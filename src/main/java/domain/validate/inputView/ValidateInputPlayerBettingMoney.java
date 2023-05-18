package domain.validate.inputView;

public class ValidateInputPlayerBettingMoney {

    public static int validateBettingMoney(String input) {
        int money = onlyNumber(input);
        MoneyIsMoreThan1000(money);
        MoneyCanDivideBy1000(money);
        return money;
    }

    private static int onlyNumber(String input) {
        String reg = "^[0-9]+$";
        if (input.matches(reg)) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
    }

    private static void MoneyIsMoreThan1000(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 배팅 금액은 천원 이상이여야 합니다.");
        }
    }

    private static void MoneyCanDivideBy1000(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 배팅 금액은 천원 단위로 나누어 떨어져야 합니다.");
        }
    }
}
