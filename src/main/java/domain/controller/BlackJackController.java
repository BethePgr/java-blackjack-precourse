package domain.controller;

import domain.model.BlackJackGame;
import domain.model.BlackJackResult;
import domain.model.user.Player;
import domain.service.BlackJackService;
import domain.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BlackJackController {

    public static void main(String[] args) {

        List<Player> playerLists = createPlayers();
        BlackJackService blackJackService = new BlackJackService(playerLists);
        OutputView.printAllCardsOfDealerAndPlayers(blackJackService);
        for(Player player : playerLists){
            continuePlayerAddCard(blackJackService,player);
        }
        printIfDealerScoreUnder16(blackJackService);
        printResultOfGame(blackJackService);
    }

    private static void continuePlayerAddCard(BlackJackService blackJackService,Player player){
        String input;
        do{
            input = InputController.inputPlayerContinueGame(player.getName());
            blackJackService.addOneMoreCardToPlayer(player,input);
            if(blackJackService.isPlayerScoreOver21(player)){
                OutputView.showPlayerCards(player);
                OutputView.alreadyScoreOver21(player);
                break;
            }
            if(input.equals("y")) {
                OutputView.showPlayerCards(player);
            }
        }while(input.equals("y"));
    }

    private static void printResultOfGame(BlackJackService blackJackService){
        OutputView.printAllCardsAndScoreOfDealerAndPlayers(blackJackService);
        blackJackService.makeResult();
        OutputView.showAllResult(blackJackService);
    }

    private static void printIfDealerScoreUnder16(BlackJackService blackJackService){
        if(blackJackService.isDealerScoreUnder16()) {
            blackJackService.addOneMoreCardToDealer();
            OutputView.dealerAddOneMoreCard();
        }
    }

    private static List<Player> createPlayers(){
        List<String> names = InputController.inputPlayerNames();
        return createStringToPlayerLists(names);
    }


    private static List<Player> createStringToPlayerLists(List<String> names) {
        List<Player> playerList = new ArrayList<>();
        for(String name : names){
            int money = InputController.inputPlayerBettingMoney(name);
            Player player = new Player(name, money);
            playerList.add(player);
        }
        return playerList;
    }
}
