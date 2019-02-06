package BonanzaCore.Core;

import BonanzaCore.Core.AbstractLayer.Player;
import BonanzaCore.Core.AbstractLayer.PlayerState;
import BonanzaCore.Core.Entities.Field;
import BonanzaCore.Core.Entities.Reward;
import BonanzaCore.Core.Enums.GameMode;
import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.TurnState.*;
import Extension.Mafia.MafiaTurnState.MafiaPhaseChanger;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer extends Player {

    protected List<Card> hand;
    protected List<Card> tradingArea;
    protected int position;
    public TurnPhases turnPhase;
    private GameMode gameMode;

    protected HumanPlayer(){
        this.hand = new ArrayList<>();
        this.tradingArea = new ArrayList<>();
    }

    public HumanPlayer(String name, int position) {
        super();

        this.name = name;
        this.position = position;
        this.fields.add(new Field());
        this.fields.add(new Field());
        this.playerState = new LockedState(this);
        setPlaying(true);

        this.gameMode = GameMode.BonanzaGame;

    }

    public HumanPlayer(String name, int position, int fieldCount) {
        super();
        this.name = name;
        this.position = position;
        for (int i = 0; i < fieldCount; i++){
            fields.add(new Field());
        }
        this.playerState = new LockedState(this);
        setPlaying(true);

        this.gameMode = GameMode.BonanzaGame;

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


    public GameMode getGameMode(){return gameMode;}
    public void setGameMode(GameMode gameMode){
        this.gameMode= gameMode;
    }

    public PlayerState nextState()
    {
        if(gameMode==GameMode.BonanzaGame) {
            return PhaseChanger.phaseChanger(new GamePhaseChanger(), this);
        }
        else
        {
            return PhaseChanger.phaseChanger(new MafiaPhaseChanger(), this);
        }

    }


    @Override
    public List<Card> harvest(int fieldPosition) {
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

    public TurnPhases getTurnPhase(){ return turnPhase;}
     public void setTurnPhase(TurnPhases turnPhase){ this.turnPhase= turnPhase;}



    //-------- Methods for the GamePlayer's handcards ----------
    public List<Card> getHand() { return hand; }

     public void setHand(List<Card> cards){hand=cards;}

    //-------- Methods for the GamePlayer's trading area ----------
    public void addCardsToTradingArea(List<Card> cardsToTrade){
        //When a player e.g draws two cards in his trading phase this method puts them into his trading area
        for (Card card : cardsToTrade){
            System.out.println("Card " + card.getCardType() + " put in trading area");
        }
        this.tradingArea.addAll(cardsToTrade);
    }

    public void removeFromTadingArea(List<Card> cards){
        this.tradingArea.removeAll(cards);
    }

    public List<Card> getTradingArea() { return tradingArea; }

    public int getPosition() { return position; }

    public boolean startTrading(boolean playerWantsToTrade)
    {
        System.out.println("Does player want to trade? " + playerWantsToTrade);
        //todo all trading functionality
        return playerWantsToTrade;
    }

}
