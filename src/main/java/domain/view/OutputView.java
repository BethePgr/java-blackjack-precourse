package domain.view;

import domain.model.BlackJackGame;
import domain.model.card.Card;
import domain.model.user.Dealer;
import domain.model.user.Player;
import java.util.List;

public class OutputView {

    public static void printAllCardsOfDealerAndPlayers(BlackJackGame blackJackGame){
        System.out.println("딜러와 " + playerNamesString(blackJackGame.getPlayers()) + "에게 2장을 나누었습니다.");
        showDealerCards(blackJackGame.getDealer());
        for(Player player : blackJackGame.getPlayers()){
            showPlayerCards(player);
        }
    }

    private static void showDealerCards(Dealer dealer){
        System.out.println("딜러: " + showCardsDetail(dealer.getCards()));
    }

    private static void showPlayerCards(Player player){
        System.out.println(player.getName()+ "카드: " + showCardsDetail(player.getCards()));
    }

    private static String playerNamesString(List<Player> players){
        StringBuilder str = new StringBuilder();
        for(Player player : players){
            str.append(player.getName()).append(",");
        }
        return str.deleteCharAt(str.length()-1).toString();
    }

    private static String showCardsDetail(List<Card> cards){
        StringBuilder str = new StringBuilder();
        for(Card card : cards){
            str.append(card.getSymbol().getScore()).append(card.getType().getName()).append(",");
        }
        return str.deleteCharAt(str.length() - 1).toString();
    }
}
