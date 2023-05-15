package domain.controller;

import domain.model.BlackJackGame;
import domain.model.user.Player;
import java.util.ArrayList;
import java.util.List;

public class BlackJackController {

    public void run(){
        List<String> names = InputController.inputPlayerNames();
        new BlackJackGame(createPlayerLists(names));
    }

    private List<Player> createPlayerLists(List<String> names) {
        List<Player> playerList = new ArrayList<>();
        for(String name : names){
            int money = InputController.inputPlayerBettingMoney(name);
            Player player = new Player(name, money);
            playerList.add(player);
        }
        return playerList;
    }
}
