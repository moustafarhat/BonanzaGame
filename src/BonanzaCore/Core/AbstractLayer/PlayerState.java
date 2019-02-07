package BonanzaCore.Core.AbstractLayer;

import BonanzaCore.Core.Entities.Reward;
import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.Entities.Field;
import BonanzaCore.Core.Enums.TurnPhases;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerState
{
   protected HumanPlayer player;
   public TurnPhases turnPhase;
    public PlayerState(HumanPlayer player)
    {
        this.player=player;
        turnPhase=TurnPhases.LOCKED;
    }

    public PlayerState() {

    }

    public HumanPlayer getHumanPlayer(){return player;}

    public TurnPhases getTurnPhase(){return turnPhase;}

    public void setHumanPlayer(HumanPlayer player){this.player=player;}

    public static void giveGift(HumanPlayer player, List<Card> giftCards)
    {
        //implementation here
    }

    public boolean buyField(){
        //Check if player has enough coins to buy another field
        if (getHumanPlayer().treasury.size() >= 3){
            //If yes add a new field to this player's Array of fields and remove 3 cards (= coins) from player's treasury
            //todo may need to change this method with other return type cause removed cards from treasury need to be placed into discardPile probably?
            this.getHumanPlayer().fields.add(new Field());
            this.getHumanPlayer().treasury.remove(0);
            this.getHumanPlayer().treasury.remove(0);
            this.getHumanPlayer().treasury.remove(0);
            System.out.println("GamePlayer bought a new field");
            return true;
        }
        System.out.println("GamePlayer couldn't buy a new field");
        return false;
    }

    private boolean isValidFieldPosition(int fieldPosition){
        //Check for valid fieldPosition, when planting or harvesting, valid parameters are only 0,1,2
        if (fieldPosition > 2 || fieldPosition <0){
            return false;
        }
        //If parameter is 2, check if player has bought a third field, otherwise it's also not valid
        if (fieldPosition == 2 && player.fields.size() < 3){
            return false;
        }
        return true;
    }

    public List<Card> harvest(int fieldPosition) {
        //Check fieldPosition parameter for validity
        if (!isValidFieldPosition(fieldPosition)){
            return new ArrayList<>();
        }
        //Before harvesting check if Bean-Protection-Rule was not violated
        for (Field field : player.fields){
            if (player.fields.get(fieldPosition).getCards().size() < field.getCards().size()){
                return new ArrayList<>();
            }
        }
        //Harvest cards from field at fieldPosition, if there are no cards in the field return empty harvest
        List<Card> harvestedCards = new ArrayList<>(player.fields.get(fieldPosition).getCards());
        player.fields.set(fieldPosition,new Field());
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
                player.treasury.add(harvestedCards.remove(0));
            }
            //returns leftover cards after turning some cards into coins
            return harvestedCards;
        }
        //No reward found, therefore no coins will be added to the treasury and all harvestedCards go to the discardPile
        return harvestedCards;
    }




}
