package domain.model.user;

import static org.junit.jupiter.api.Assertions.*;

import domain.model.card.Card;
import domain.model.card.Symbol;
import domain.model.card.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("")
    void test1() throws Exception {

        Player player = new Player("one",1000);
        player.addCard(new Card(Symbol.ACE, Type.SPADE));
        player.addCard(new Card(Symbol.THREE, Type.SPADE));
        //then
        assertEquals(3+1,player.getScore());
        assertTrue(player.isHaveAceCard());
    }

}