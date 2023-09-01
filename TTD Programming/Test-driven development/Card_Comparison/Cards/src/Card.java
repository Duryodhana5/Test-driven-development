package Card_Comparison.Cards.src;

public class Card implements Comparable<Card>
{
    public enum Suits {Diamonds, Spades, Hearts, Clubs}
    public enum Ranks {Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace}

    private final Ranks rankValue;
    private final Suits suitValue;

    public Card(Ranks rankValue, Suits suitValue) {
        this.rankValue = rankValue;
        this.suitValue = suitValue;
    }

    @Override
    public int compareTo(Card other) {
        if (rankValue == other.rankValue)
           return suitValue.compareTo(other.suitValue);
        return rankValue.compareTo(other.rankValue);
    }

    @Override
    public boolean equals(Object other)
    {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!this.getClass().getName().equals(other.getClass().getName()))
            return false;
        return  equals(other);
    }
}