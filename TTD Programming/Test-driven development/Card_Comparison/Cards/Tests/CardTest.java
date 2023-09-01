package Card_Comparison.Cards.Tests;

import Last_Seen.LastSeen.src.Card;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardTest {

    private final Card fiveOfDiamond = new Card(Card.Ranks.Five, Card.Suits.Diamonds);
    private final Card threeOfClubs = new Card(Card.Ranks.Three, Card.Suits.Clubs);
    private final Card anotherFiveOfDiamond = new Card(Card.Ranks.Five, Card.Suits.Diamonds);

    @Test
    public void verifyingGreaterCard() {
        assertTrue(fiveOfDiamond.compareTo(threeOfClubs) > 0);
    }

    @Test
    public void comparingBothCardsEqual() {
        assertEquals(0, fiveOfDiamond.compareTo((anotherFiveOfDiamond)));
    }
}

