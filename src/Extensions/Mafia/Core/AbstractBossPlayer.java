package Extensions.Mafia.Core;

import BonanzaGame.Core.AbstractPlayer;
import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Field;
import BonanzaGame.Entities.Reward;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractBossPlayer extends AbstractPlayer {

    //Each boss has a coin harvest threshold (eine Schwelle) at which he automatically harvests his field
    protected int harvestThreshold;
    protected Reward highestReward;

    protected boolean checkBossFieldIfReadyForHarvest() {
        //The Bean-Mafia harvest their fields when they can be sold for a determined value.
        // for example “Al Cabohne” harvests his field as soon as it is worth three coins.

        List<Card> cardsToCheck = new ArrayList<>(this.fields.get(0).getCards());
        //If there's at least one card check for highest suitable reward for that CardType based on number of cards harvested
        if (cardsToCheck.size() == 0){
            return false;
        }
        List<Reward> rewardsForCardType = cardsToCheck.get(0).getRewards();
        int amountOfSameCardType = cardsToCheck.size();
        Reward highestReward = null;
        for (Reward reward : rewardsForCardType){
            if (amountOfSameCardType >= reward.getCardCount()){
                highestReward = reward;
            }
        }
        if (highestReward != null && highestReward.getCoins() >= harvestThreshold) {
            //Suitable reward found, now add some cards as coins to the treasury and remove them from the harvested cards pile
            this.highestReward = highestReward;
            return true;
        }
        //No reward found, therefore no coins will be added to the treasury and all harvestedCards go to the discardPile
        return false;
    }

    public List<Card> harvest() {
        if (highestReward == null) {
            checkBossFieldIfReadyForHarvest();
        }
        if (highestReward != null) {
            List<Card> harvestedCards = new ArrayList<>(this.fields.get(0).getCards());
            this.fields.remove(0);
            this.fields.add(new Field());
            for (int i = 0; i < this.highestReward.getCoins(); i++) {
                this.treasury.add(harvestedCards.remove(0));
            }
            return harvestedCards;
        }
        return new ArrayList<>();
    }

    protected boolean plant(Card card) {
        Field field = fields.get(0);
        if (field.getCards().size() == 0){
            field.addCardToField(card);
            return true;
        }
        if (field.getCards().get(0).getCardType().equals(card.getCardType())){
            //CardType of card was correct so the card will be added to the field
            field.addCardToField(card);
            System.out.println(this.name + " added " + card.getCardType() + " to his field.");
            return true;
        } else return false;
    }

}
