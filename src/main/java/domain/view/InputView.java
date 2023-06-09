package domain.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPlayersName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return scanner.next();
    }

    public static String inputPlayerBettingMoney(String name) {
        System.out.println(name + "의 배팅 금액은?");
        return scanner.next();
    }

    public static String inputPlayerContinueGame(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y,아니오는 n)");
        return scanner.next();
    }
}
