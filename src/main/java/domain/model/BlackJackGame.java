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
    private final List<Card> cardDeck;

    public BlackJackGame(List<Player> players){
        dealer = new Dealer();
        this.players = players;
        cardDeck = new ArrayList<>(CardFactory.create());
        addCardToDealer(dealer);
        giveTwoCardsToEachPlayer();
    }

    private void giveTwoCardsToEachPlayer(){
        for(Player player : players){
            addCardToPlayer(player);
        }
    }

    private void addCardToDealer(Dealer dealer){
        for(int i = 0;i<2;i++){
            Card card = selectOneCard();
            dealer.addCard(card);
        }
    }

    private void addCardToPlayer(Player player) {
        for(int i = 0;i<2;i++) {
            Card card = selectOneCard();
            player.addCard(card);
        }
    }

    private Card selectOneCard(){
        int size = cardDeck.size();
        int index = (int) (Math.random() * size);
        return cardDeck.remove(index);
    }

    public List<Card> getCardDeck(){
        return cardDeck;
    }

    public Dealer getDealer(){
        return dealer;
    }

    public List<Player> getPlayers(){
        return players;
    }
}
