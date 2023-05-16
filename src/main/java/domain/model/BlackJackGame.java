package domain.model;

import domain.model.card.Card;
import domain.model.card.CardFactory;
import domain.model.user.Dealer;
import domain.model.user.Player;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlackJackGame {

    private final Dealer dealer = new Dealer();;
    private final List<Player> players;
    private final List<Card> cardDeck = new ArrayList<>(CardFactory.create());;

    public BlackJackGame(List<Player> players) {
        this.players = players;
        addTwoCardsToDealer(dealer);
        giveTwoCardsToEachPlayer();
    }

    private void giveTwoCardsToEachPlayer() {
        for (Player player : players) {
            addTwoCardsToPlayer(player);
        }
    }

    private void addTwoCardsToDealer(Dealer dealer) {
        for (int i = 0; i < 2; i++) {
            addOneCardToDealer(dealer);
        }
    }

    public void addOneCardToDealer(Dealer dealer) {
        Card card = selectOneCard();
        dealer.addCard(card);
    }

    private void addTwoCardsToPlayer(Player player) {
        for (int i = 0; i < 2; i++) {
            addOneCardToPlayer(player);
        }
    }

    public void addOneCardToPlayer(Player player) {
        Card card = selectOneCard();
        player.addCard(card);
    }

    private Card selectOneCard(){
        int size = cardDeck.size();
        int index = (int) (Math.random() * size);
        return cardDeck.remove(index);
    }

    public List<Card> getCardDeck() {
        return cardDeck;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
