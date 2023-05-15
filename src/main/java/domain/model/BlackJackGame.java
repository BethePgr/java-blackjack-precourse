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

    private final Dealer dealer;
    private final List<Player> players;
    private final List<Card> cardDeck;
    private final Set<Integer> set = new HashSet<>();

    public BlackJackGame(List<Player> players) {
        dealer = new Dealer();
        this.players = players;
        cardDeck = new ArrayList<>(CardFactory.create());
        addCardToDealer(dealer);
        giveTwoCardsToEachPlayer();
    }

    private void giveTwoCardsToEachPlayer() {
        for (Player player : players) {
            addCardToPlayer(player);
        }
    }

    private void addCardToDealer(Dealer dealer) {
        for (int i = 0; i < 2; i++) {
            Card card = selectOneCard();
            dealer.addCard(card);
        }
    }

    private void addCardToPlayer(Player player) {
        for (int i = 0; i < 2; i++) {
            Card card = selectOneCard();
            player.addCard(card);
        }
    }

    private Card selectOneCard() {

        int index = (int) (Math.random() * cardDeck.size());
        if (!set.contains(index)) {
            set.add(index);
            return cardDeck.remove(index);
        }
        return selectOneCard();
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
