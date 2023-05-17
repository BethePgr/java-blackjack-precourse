package domain.model;

import domain.model.user.Dealer;
import domain.model.user.Player;
import java.util.List;

public class BlackJackResult {

    private final BlackJackGame blackJackGame;
    private final List<Player> playerList;
    private final Dealer dealer;

    public BlackJackResult(List<Player> playerList){
        blackJackGame = new BlackJackGame(playerList);
        this.playerList = playerList;
        dealer = blackJackGame.getDealer();
    }

    /**
     * -블랙잭이 존재하는 경우
     *      1.딜러와 특정 플레이어가 블랙잭인 경우
     *      2.딜러는 아니지만 특정 플레이어만 블랙잭인 경우
     *      3.딜러만 블랙잭인 경우
     * -블랙잭이 존재하지 않는 경우
     *      각각의 플레이어의 점수와 딜러의 점수를 비교하기
     */

    public void gameResult(){
        dealerAndPlayerBlackJack();
        onlyPlayerBlackJack();
        onlyDealerBlackJack();
        noBlackJack();
    }

    private void dealerAndPlayerBlackJack() {
        if(isDealerBlackJack() && isAnyPlayerBlackJack()){

        }
    }

    private void onlyPlayerBlackJack() {
        if(!isDealerBlackJack() && isAnyPlayerBlackJack()){

        }
    }

    private void onlyDealerBlackJack(){
        if(isDealerBlackJack() && !isAnyPlayerBlackJack()){

        }
    }

    private void noBlackJack(){
        if(!isDealerBlackJack() && !isAnyPlayerBlackJack()){
            calculateNoBlackJack();
        }
    }

    private void calculateNoBlackJack(){
        for(Player player : playerList){
            if(dealer.getScore() > player.getScore()){
                dealer.addBenefit(player.getBettingMoney());
                player.minusBenefit(player.getBettingMoney());
            }
            if(dealer.getScore() < player.getScore()){
                dealer.minusBenefit(player.getBettingMoney());
                player.addBenefit(player.getBettingMoney());
            }
        }
    }

    private boolean isDealerBlackJack(){
        Dealer dealer = blackJackGame.getDealer();
        return dealer.getCards().size() == 2 && dealer.getScore() == 21;
    }

    private boolean isAnyPlayerBlackJack(){
        return playerList.stream().anyMatch(player -> player.getCards().size() == 2 && player.getScore() == 21);
    }

}
