package BonanzaGame.Core;

import BonanzaGame.Core.Enums.CardTypes;
import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table
{
    private List<Player> players;
    private List<Card> cards;
    private List<Card> discardedCards;

    public Table()
    {
        List<Player> players = Arrays.asList( new Player(), new Player(), new Player(), new Player());
        this.cards = generateCards();
        this.players = players;
        this.discardedCards = new ArrayList<>();
    }

    private List<Card> generateCards(){

        List<Card> cards = new ArrayList<>();

        for (CardTypes cardType : CardTypes.values()){
            for (int i = 0; i < cardType.getMaxCardCount(); i++){
                cards.add(new Card(cardType));
            }
        }

        return cards;
    }

    public List<Player> playerList()
    {
      return this.players;
    }

    public List<Card> drawPile()
    {
        return this.cards;
    }

    public List<Card> discardPile()
    {
        return this.discardedCards;
    }

    @Override
    public String toString() {
        return "Table Class";
    }
}
