package BonanzaCore.Core;

import BonanzaCore.Core.AbstractLayer.BonanzaPlayerState;
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
        return playerState.harvest(fieldPosition);
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
