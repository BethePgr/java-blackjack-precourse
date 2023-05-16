package domain.service;

import domain.model.BlackJackGame;
import domain.model.user.Dealer;
import domain.model.user.Player;
import java.util.List;

public class BlackJackService {

    private final BlackJackGame blackJackGame;

    public BlackJackService(List<Player> playerList){
        blackJackGame = new BlackJackGame(playerList);
    }

    public void addOneMoreCardToPlayer(Player player,String input){
        if(input.equals("y")){
            blackJackGame.addOneCardToPlayer(player);
        }
//        if(player.getScore() > 21){
//            playerBomb();
//        }
    }

    public boolean isDealerScoreUnder16(){
        Dealer dealer = blackJackGame.getDealer();
        return dealer.getScore() <= 16;
    }

    public void addOneMoreCardToDealer(){
        Dealer dealer = blackJackGame.getDealer();
        blackJackGame.addOneCardToDealer(dealer);
    }

    public BlackJackGame getBlackJackGame(){
        return blackJackGame;
    }
}
