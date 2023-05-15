package domain.controller;

import domain.model.BlackJackGame;
import domain.model.user.Player;
import java.util.List;

public class BlackJackController {

    BlackJackGame blackJackGame = new BlackJackGame();

    public void run(){
        List<String> names = InputController.inputPlayerNames();
        createPlayerLists(names);
    }

    private void createPlayerLists(List<String> names) {
        for(String name : names){
            int money = InputController.inputPlayerBettingMoney(name);
            Player player = new Player(name, money);
            blackJackGame.addPlayer(player);
        }
    }
}
