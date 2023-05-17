package domain.model.user;

import domain.model.card.Card;

import domain.model.card.Symbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {
    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();
    private int score = 0;
    private boolean haveAceCard;
    private int benefit;

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void addCard(Card card) {
        cards.add(card);
        addScore(card);
        haveAceCard = aceCard();
    }

    // TODO 추가 기능 구현
    public List<Card> getCards(){
        return cards;
    }

    public String getName(){
        return name;
    }

    private void addScore(Card card){
        score+= card.getSymbol().getScore();
    }

    private boolean aceCard(){
        return cards.stream().anyMatch(card -> card.getSymbol() == Symbol.ACE);
    }

    public int getScore(){
        return score;
    }

    public boolean isHaveAceCard(){
        return haveAceCard;
    }
}
