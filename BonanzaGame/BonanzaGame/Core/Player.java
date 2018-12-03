package BonanzaGame.Core;

import BonanzaGame.Core.PlayerState;
import BonanzaGame.Core.ReadyState;
import BonanzaGame.Core.PlayerState;
import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Field;
import BonanzaGame.Entities.Reward;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private PlayerState _PlayerState;
    private String name;
    private List<Field> fields;
    private List<Card> hand;
    private int position;
    private List<Card> treasury;
    private List<Card> tradingArea;

    private PlayerState _playerstate;
    private boolean playing = false;
    private List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {

    }

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
        this.fields = new ArrayList<>();
        fields.add(new Field());
        fields.add(new Field());
        this.hand = new ArrayList<>();
        this.treasury = new ArrayList<>();
        this.tradingArea = new ArrayList<>();
        this._PlayerState = new ReadyState(this);
        setPlaying(true);
        for (int i = 1; i <= 12; i++) {
            playlist.add("Track " + i);
        }
    }

    public void changeState(PlayerState playerState) {
        this._PlayerState = playerState;
    }

    public PlayerState get_PlayerStateState() {
        return _PlayerState;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

    public String startPlayback() {
        return "Playing " + playlist.get(currentTrack);
    }


    public void addCardsToHand(List<Card> cards){
        //Cards from GameManager's draw function are put into the player's hand
        System.out.println(name + " receives " + cards.size() + " cards into his hand");
        this.hand.addAll(cards);
    }

    public int getCoinCount(){
        //The amount of coins a player has equals to the amount of cards that were put into his/her treasury
        return treasury.size();
    }

    private boolean isValidFieldPosition(int fieldPosition){
        //Check for valid fieldPosition, when planting or harvesting, valid parameters are only 0,1,2
        if (fieldPosition > 2 || fieldPosition <0){
            return false;
        }
        //If parameter is 2, check if player has bought a third field, otherwise it's also not valid
        if (fieldPosition == 2 && fields.size() < 3){
            return false;
        }
        return true;
    }

    public boolean plant(Card card, int fieldPosition){
        //Check fieldPosition parameter for validity
        if (!isValidFieldPosition(fieldPosition)){
            return false;
        }
        else {
            Field field = this.fields.get(fieldPosition);
            //Check if the specified field at fieldPosition is empty or not
            if (field.getCards().isEmpty()){
                //If the field at fieldPosition is empty, any card is allowed to be planted
                field.addCardToField(card);
                System.out.println(this.name + " added " + card.getCardType() + " to his field " + fieldPosition);
                return true;
            } else {
                //If the field at fieldPosition is not empty check if the CardType of the parameter card matches the fields CardType
                if (field.getCards().get(0).getCardType().equals(card.getCardType())){
                    //CardType of card was correct so the card will be added to the field
                    field.addCardToField(card);
                    System.out.println(this.name + " added " + card.getCardType() + " to his field " + fieldPosition);
                    return true;
                } else return false;
            }
        }
    }

    public List<Card> harvest(int fieldPosition){
        //Check fieldPosition parameter for validity
        if (!isValidFieldPosition(fieldPosition)){
            return new ArrayList<>();
        }
        //Before harvesting check if Bean-Protection-Rule was not violated
        for (Field field : this.fields){
            if (fields.get(fieldPosition).getCards().size() < field.getCards().size()){
                return new ArrayList<>();
            }
        }
        //Harvest cards from field at fieldPosition, if there are no cards in the field return empty harvest
        List<Card> harvestedCards = new ArrayList<>(this.fields.get(fieldPosition).getCards());
        this.fields.set(0,new Field());
        if (harvestedCards.isEmpty()){
            return new ArrayList<>();
        }
        //If there's at least one card check for highest suitable reward for that CardType based on number of cards harvested
        List<Reward> rewardsForHarvestedCardType = harvestedCards.get(0).getRewards();
        int harvestedCardCount = harvestedCards.size();
        Reward highestReward = null;
        for (Reward reward : rewardsForHarvestedCardType){
            if (harvestedCardCount >= reward.getCardCount()){
                highestReward = reward;
            }
        }
        if (highestReward != null){
            //Suitable reward found, now add some cards as coins to the treasury and remove them from the harvested cards pile
            for (int i = 0; i < highestReward.getCoins(); i++){
                this.treasury.add(harvestedCards.remove(i));
            }
            //returns leftover cards after turning some cards into coins
            return harvestedCards;
        }
        //No reward found, therefore no coins will be added to the treasury and all harvestedCards go to the discardPile
        return harvestedCards;
    }

    public boolean buyField(){
        //Check if player has enough coins to buy another field
        if (treasury.size() >= 3){
            //If yes add a new field to this player's Array of fields and remove 3 cards (= coins) from player's treasury
            //todo may need to change this method with other return type cause removed cards from treasury need to be placed into discardPile probably?
            this.fields.add(new Field());
            this.treasury.remove(0);
            this.treasury.remove(0);
            this.treasury.remove(0);
            System.out.println("Player bought a new field");
            return true;
        }
        System.out.println("Player couldn't buy a new field");
        return false;
    }

    public int getPosition() {
        return position;
    }

    public void setTreasury(List<Card> treasury) {
        this.treasury.addAll(treasury);
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void removeFromTadingArea(List<Card> cards){
        this.tradingArea.removeAll(cards);
    }

    public boolean startTrading(boolean playerWantsToTrade){
        System.out.println("Does player want to trade? " + playerWantsToTrade);
        //todo all trading functionality
        return playerWantsToTrade;
    }

    public void addCardsToTradingArea(List<Card> cardsToTrade){
        //When a player draws two cards in his trading phase this method puts them into his trading area
        for (Card card : cardsToTrade){
            System.out.println("Card " + card.getCardType() + " put in trading area");
        }
        this.tradingArea.addAll(cardsToTrade);
    }

    public void plantAnotherCard(boolean playersChoice, int fieldPosition){
        //Method for optional second planting, depending on players choice
        if (playersChoice){
            plant(hand.get(0), fieldPosition);
        } else System.out.println(name + " didn't want to plant another card");
    }

    public List<Card> getTradingArea() {
        return tradingArea;
    }

    public String getName() {
        return name;
    }

    public List<Field> getFields() {
        return fields;
    }
}
