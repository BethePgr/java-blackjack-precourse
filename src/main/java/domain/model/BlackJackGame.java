package domain.model;

import domain.model.card.Card;
import domain.model.card.CardFactory;
import domain.model.user.Dealer;
import domain.model.user.Player;
import java.util.ArrayList;
import java.util.List;

public class BlackJackGame {

    private final Dealer dealer;
    private final List<Player> players;
    private final List<Card> CardDeck;

    public BlackJackGame(List<Player> players){
        dealer = new Dealer();
        this.players = players;
        CardDeck = CardFactory.create();
        giveTwoCardsToEachPlayer();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    private void giveTwoCardsToEachPlayer(){
        for(Player player : players){
            addCardToPlayer(player);
        }
    }

    private void addCardToPlayer(Player player) {
        for(int i = 0;i<2;i++) {
            int size = CardDeck.size();
            int index = (int) (Math.random() * size);
            Card card = CardDeck.remove(index);
            player.addCard(card);
        }
    }
}
