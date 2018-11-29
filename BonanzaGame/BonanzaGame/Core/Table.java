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
    private List<Card> deck;
    private List<Card> discardedCards;

    public Table()
    {
        //List<Player> players = Arrays.asList( new Player("Player1", 1), new Player(), new Player(), new Player());
        this.deck = generateCards();
        this.players = new ArrayList<>();
        this.discardedCards = new ArrayList<>();
    }

    public void addPlayer(String name, int position){
        this.players.add(new Player(name, position));
    }

    private List<Card> generateCards(){
        //Generates 104 cards, with maxCardCount of each CardType
        List<Card> cards = new ArrayList<>();

        for (CardTypes cardType : CardTypes.values()){
            for (int i = 0; i < cardType.getMaxCardCount(); i++){
                cards.add(new Card(cardType));
            }
        }

        return cards;
    }

    public boolean fillDrawPileWithDiscardedCards(){
        //Method for filling the DrawPile after the end of a round, the discardPile becomes the new DrawPile
        if (drawPile().isEmpty() && !discardPile().isEmpty()){
            this.deck = this.discardPile();
            return true;
        } else return false;
    }

    public List<Player> playerList()
    {
      return this.players;
    }

    public List<Card> drawPile()
    {
        return this.deck;
    }

    public boolean removeCardFromDrawPile(Card card){
        return this.deck.remove(card);
    }

    public boolean addCardToDiscardPile(List<Card> cards){
        return this.discardedCards.addAll(cards);
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
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
