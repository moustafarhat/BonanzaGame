package BonanzaGame.Core.AbstractLayer;

import BonanzaGame.Core.Enums.CardTypes;
import BonanzaGame.Core.Player;
import BonanzaGame.Entities.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTable {

    protected List<AbstractPlayer> players;
    protected List<AbstractHumanPlayer> humanPlayers;
    protected List<Card> deck;
    protected List<Card> discardedCards;
    protected int maxPlayerCount;

    protected AbstractTable(){
        //List<Player> players = Arrays.asList( new Player("Player1", 1), new Player(), new Player(), new Player());
        this.deck = generateCards();
        this.players = new ArrayList<>();
        this.discardedCards = new ArrayList<>();
        this.humanPlayers = new ArrayList<>();
    }

    public void addPlayer(String name, int position, int fieldCount) {
        if (players.size()>= maxPlayerCount){
            return;
        }
        this.players.add(new Player(name, position, fieldCount));
        this.humanPlayers.add(new Player(name, position));
    }

    public boolean addCardToDiscardPile(List<Card> cards){
        if (cards.size() == 0){
            return true;
        } else return this.discardedCards.addAll(cards);
    }

    protected List<Card> generateCards(){
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

    public List<AbstractHumanPlayer> getHumanPlayers(){ return this.humanPlayers; }
    public void setDeck(List<Card> deck) { this.deck = deck; }
    public boolean removeCardFromDrawPile(Card card){ return this.deck.remove(card); }
    public List<Card> drawPile() { return this.deck; }
    public List<AbstractPlayer> playerList() { return this.players; }
    public List<Card> discardPile() { return this.discardedCards; }
}
