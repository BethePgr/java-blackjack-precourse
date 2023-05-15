package domain.card;

import domain.model.card.Card;
import domain.model.card.CardFactory;
import domain.model.card.Symbol;
import domain.model.card.Type;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {
    @Test
    @DisplayName("")
    void testCard() throws Exception {
        //given
        Card card1 = new Card(Symbol.ACE, Type.DIAMOND);
        Card card2 = new Card(Symbol.ACE,Type.DIAMOND);
        Card card3 = new Card(Symbol.TWO,Type.CLUB);
        Card card4 = new Card(Symbol.THREE,Type.CLUB);

        //when
        System.out.println("card1 == card2 = " + card1.equals(card2));
        System.out.println("card1 : " + card1.toString());
        System.out.println("card2 : " + card2.toString());
        System.out.println("card1.hash : " + card1.hashCode());
        System.out.println("card2.hash : " + card2.hashCode());
        System.out.println("card3.hash : " + card3.hashCode());
        System.out.println("card4.hash : " + card4.hashCode());
    }

    @Test
    @DisplayName("")
    void cardFactoryTest() throws Exception {
        List<Card> cards = CardFactory.create();
        for(Card card : cards){
            System.out.println("card : " + card.toString());
            System.out.println("card.hashCode : " + card.hashCode());
            System.out.println();
        }
    }
}