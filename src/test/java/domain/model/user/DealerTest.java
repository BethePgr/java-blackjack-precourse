package domain.model.user;

import static org.junit.jupiter.api.Assertions.*;

import domain.model.card.Card;
import domain.model.card.Symbol;
import domain.model.card.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {

    @Test
    @DisplayName("")
    void test1() throws Exception {
        //given
        Dealer dealer = new Dealer();
        //when
        dealer.addCard(new Card(Symbol.ACE, Type.SPADE));
        dealer.addCard(new Card(Symbol.THREE, Type.SPADE));
        //then
        assertEquals(3+1,dealer.getScore());
        assertTrue(dealer.isHaveAceCard());
    }

}