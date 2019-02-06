package BonanzaCore.Core.TurnState;

import BonanzaCore.Core.AbstractLayer.BonanzaPlayerState;
import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.AbstractLayer.Table;
import BonanzaCore.Core.Entities.Card;

import java.util.ArrayList;
import java.util.List;

public class DrawingState extends BonanzaPlayerState {

    public DrawingState(HumanPlayer player) {
        super(player);
        player.setPlaying(false);
        turnPhase=TurnPhases.DRAWING;
    }
    @Override
    public Boolean onLock() {
        return null;
    }

    @Override
    public Boolean onTrading() {
        return null;
    }


    @Override
    public Boolean onDrawing(Table table, int count) {

        if(table==null || table.drawPile().size()<count) return  null;

        for (int i=0;i<count;i++) {
          Card card= table.drawPile().get(i);
         List<Card> hand= getHumanPlayer().getHand();

         if(hand==null)
         {
             hand=new ArrayList<>();
         }
         int index=0;
         if(hand.size()>0)
         {
             index=hand.size()-1;
         }

         hand.add(index,card);
            getHumanPlayer().setHand(hand);
        }
        return true;
    }

    @Override
    public Boolean onPlanting(int fieldIndex) {
        return null;
    }



}
