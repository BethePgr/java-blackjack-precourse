package domain.model;

import static org.junit.jupiter.api.Assertions.*;

import domain.model.card.Card;
import domain.model.card.CardFactory;
import domain.model.user.Player;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackJackGameTest {

    @Test
    @DisplayName("사람이 한 명일때 카드가 플레이어한테 잘 들어가고 전체 덱에서는 그 카드가 잘 사라지는가")
    void test1() throws Exception {
        Player player = new Player("one", 10000);
        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        BlackJackGame blackJackGame = new BlackJackGame(playerList);

        assertEquals(2,player.getCards().size());
        assertEquals(CardFactory.create().size()-2,blackJackGame.getCardDeck().size());
        assertFalse(blackJackGame.getCardDeck().containsAll(player.getCards()));
        assertTrue(player.getCards().stream().noneMatch(card -> blackJackGame.getCardDeck().contains(card)));
    }

    @Test
    @DisplayName("사람이 두 명일때 카드가 플레이어한테 잘 들어가고 전체 덱에서는 그 카드가 잘 사라지는가")
    void test2() throws Exception {
        Player player = new Player("one", 10000);
        Player player2 = new Player("two",20000);
        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        playerList.add(player2);
        BlackJackGame blackJackGame = new BlackJackGame(playerList);

        assertEquals(2,player.getCards().size());
        assertEquals(2,player2.getCards().size());
        assertEquals(CardFactory.create().size()-4,blackJackGame.getCardDeck().size());
        assertFalse(blackJackGame.getCardDeck().containsAll(player.getCards()));
        assertFalse(blackJackGame.getCardDeck().containsAll(player2.getCards()));
        assertTrue(player.getCards().stream().noneMatch(card -> blackJackGame.getCardDeck().contains(card)));
        assertTrue(player2.getCards().stream().noneMatch(card -> blackJackGame.getCardDeck().contains(card)));

        for(Card card : blackJackGame.getCardDeck()){
            System.out.println(card.toString());
        }
        System.out.println("======");
        for(Card card : player.getCards()){
            System.out.println(card.toString());
        }
        System.out.println("====");
        for(Card card : player2.getCards()){
            System.out.println(card.toString());
        }
    }
}