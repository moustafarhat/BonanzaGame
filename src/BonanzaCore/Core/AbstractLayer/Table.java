package BonanzaCore.Core.AbstractLayer;

import BonanzaCore.Core.Enums.CardTypes;
import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.HumanPlayer;

import java.util.ArrayList;
import java.util.List;

public class Table {

    protected List<Player> players;
    protected List<HumanPlayer> humanPlayers;
    protected List<Card> deck;
    protected List<Card> discardedCards;
    protected int maxPlayerCount;

    protected Table(){
        //List<GamePlayer> players = Arrays.asList( new GamePlayer("Player1", 1), new GamePlayer(), new GamePlayer(), new GamePlayer());
        this.deck = generateCards();
        this.players = new ArrayList<>();
        this.discardedCards = new ArrayList<>();
        this.humanPlayers = new ArrayList<>();
    }

    public void addPlayer(String name, int position, int fieldCount) {
        if (players.size()>= maxPlayerCount){
            return;
        }
        this.players.add(new HumanPlayer(name, position, fieldCount));
        this.humanPlayers.add(new HumanPlayer(name, position));
    }

    public boolean addCardToDiscardPile(List<Card> cards){
        if (cards.size() == 0){
            return true;
        } else return this.discardedCards.addAll(cards);
    }

    public List<Card> generateCards(){
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

    public List<HumanPlayer> getHumanPlayers(){ return this.humanPlayers; }
    public void setDeck(List<Card> deck) { this.deck = deck; }
    public boolean removeCardFromDrawPile(Card card){
        for (Card oneCard : this.deck){
            if (oneCard.getCardType().equals(card.getCardType())){
                return this.deck.remove(oneCard);
            }
        }
        return false;
    }
    public List<Card> drawPile() { return this.deck; }
    public List<Player> playerList() { return this.players; }
    public List<Card> discardPile() { return this.discardedCards; }
}
