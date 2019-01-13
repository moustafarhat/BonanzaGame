package BonanzaGame.Core;

import BonanzaGame.Core.AbstractLayer.AbstractHumanPlayer;
import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Field;
import BonanzaGame.Entities.Reward;

import java.util.ArrayList;
import java.util.List;

public class Player extends AbstractHumanPlayer {

    public Player(String name, int position) {
        super();
        this.name = name;
        this.position = position;
        this.fields.add(new Field());
        this.fields.add(new Field());
        this._PlayerState = new ReadyState(this);
        setPlaying(true);

    }

    public Player(String name, int position, int fieldCount) {
        super();
        this.name = name;
        this.position = position;
        for (int i = 0; i < fieldCount; i++){
            fields.add(new Field());
        }
        this._PlayerState = new ReadyState(this);
        setPlaying(true);

    }
    public void addCardsToHand(List<Card> cards){
        //Cards from GameManager's draw function are put into the player's hand
        System.out.println(name + " receives " + cards.size() + " cards into his hand");
        List<Card> handCurrent = List.copyOf(hand);
        hand.clear();
        hand.addAll(cards);
        hand.addAll(handCurrent);
        System.out.println(name + " has "+ hand.size() + " cards in his hand");
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
        if (!isValidFieldPosition(fieldPosition) || card == null){
            return false;
        }
        else {
            Field field = this.fields.get(fieldPosition);
            //Check if the specified field at fieldPosition is empty or not
            if (field.getCards().size() == 0){
                //If the field at fieldPosition is empty, any card is allowed to be planted
                field.addCardToField(card);
                hand.remove(card);
                System.out.println(this.name + " added " + card.getCardType() + " to his field " + fieldPosition);
                return true;
            } else {
                //If the field at fieldPosition is not empty check if the CardType of the parameter card matches the fields CardType
                if (field.getCards().get(0).getCardType().equals(card.getCardType())){
                    //CardType of card was correct so the card will be added to the field
                    field.addCardToField(card);
                    hand.remove(card);
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
        this.fields.set(fieldPosition,new Field());
        if (harvestedCards.size() == 0){
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
                this.treasury.add(harvestedCards.remove(0));
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

    public boolean startTrading(boolean playerWantsToTrade){
        System.out.println("Does player want to trade? " + playerWantsToTrade);
        //todo all trading functionality
        return playerWantsToTrade;
    }

    public void plantAnotherCard(boolean playersChoice, int fieldPosition){
        //Method for optional second planting, depending on players choice
        if (playersChoice){
            plant(hand.get(0), fieldPosition);
        } else System.out.println(name + " didn't want to plant another card");
    }

}
