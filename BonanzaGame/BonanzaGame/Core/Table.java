package BonanzaGame.Core;

import BonanzaGame.Core.Enums.CardTypes;
import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The class 'Table' describes the model of a real game table including the cards that are on
 * the table (the deck and discard pile), the players sitting around the table and manages these instances
 * @version 1
 * @author Arthur K
 */
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

    /**
     * Method addPlayer creates and adds a Player object to the Table instance at the given position with the given name
     * @param name the player's name who wants to participate at the game
     * @param position the player's position who wants to participate at the game
     */
    public void addPlayer(String name, int position){
        this.players.add(new Player(name, position));
    }

    /**
     * Method generateCards creates all cards needed for the game based on the maxCardCount-variable of a cards CardType enumeration eg. 20 BlueBeans
     * @return returns a list with all created cards representing a deck, standard amount is 104 cards in a deck
     */
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

    /**
     * Method fillDrawPileWithDiscardedCards for refilling the draw pile after the end of a round
     * So that the discard pile becomes the new draw pile
     * @return true if deck was successfully refilled else otherwise
     */
    public boolean fillDrawPileWithDiscardedCards(){
        //
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
