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

    public BlackJackGame(){
        dealer = new Dealer();
        players = new ArrayList<>();
        CardDeck = CardFactory.create();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

}
