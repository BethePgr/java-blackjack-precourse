package domain.model.user;

import domain.model.card.Card;

import domain.model.card.Symbol;
import domain.model.card.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {

    private final List<Card> cards = new ArrayList<>();
    private int score = 0;
    private boolean haveAceCard;
    private int benefit = 0;

    public Dealer() {
    }

    public void addCard(Card card) {
        cards.add(card);
        addScore(card);
        haveAceCard = aceCard();
    }

    // TODO 추가 기능 구현
    public List<Card> getCards() {
        return cards;
    }

    private void addScore(Card card){
        score+= card.getSymbol().getScore();
    }

    private boolean aceCard(){
        return cards.stream().anyMatch(card -> card.getSymbol() == Symbol.ACE);
    }

    public int getScore(){
        if(isHaveAceCard() && score<=11){
            return score+10;
        }
        return score;
    }
    public boolean isHaveAceCard(){
        return haveAceCard;
    }

    public int getBenefit(){
        return benefit;
    }
}
