package domain.controller;

import domain.model.BlackJackGame;
import domain.model.user.Player;
import domain.service.BlackJackService;
import domain.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BlackJackController {

    public static void main(String[] args) {
        List<String> names = InputController.inputPlayerNames();
        List<Player> playerLists = createPlayerLists(names);
        BlackJackService blackJackService = new BlackJackService(playerLists);
        OutputView.printAllCardsOfDealerAndPlayers(blackJackService.getBlackJackGame());
        for(Player player : playerLists){
            String input;
            do{
                input = InputController.inputPlayerContinueGame(player.getName());
                blackJackService.addOneMoreCardToPlayer(player,input);
                if(input.equals("y")) {
                    OutputView.showPlayerCards(player);
                }
            }while(input.equals("y"));
        }
        if(blackJackService.isDealerScoreUnder16()) {
            blackJackService.addOneMoreCardToDealer();
            OutputView.dealerAddOneMoreCard();
        }
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
