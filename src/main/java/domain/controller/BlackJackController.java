package domain.controller;

import domain.model.BlackJackGame;
import domain.model.user.Player;
import domain.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BlackJackController {

    public static void main(String[] args) {
        List<String> names = InputController.inputPlayerNames();
        BlackJackGame blackJackGame = new BlackJackGame(createPlayerLists(names));
        OutputView.printAllCardsOfDealerAndPlayers(blackJackGame);
    }

    private static List<Player> createPlayerLists(List<String> names) {
        List<Player> playerList = new ArrayList<>();
        for(String name : names){
            int money = InputController.inputPlayerBettingMoney(name);
            Player player = new Player(name, money);
            playerList.add(player);
        }
        return playerList;
    }
}
