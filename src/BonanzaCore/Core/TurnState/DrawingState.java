package BonanzaCore.Core.TurnState;

import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.AbstractLayer.Table;
import BonanzaCore.Core.Entities.Card;

import java.util.ArrayList;
import java.util.List;

public class DrawingState extends PlayerState {

    public DrawingState(HumanPlayer player) {
        super(player);
        player.setPlaying(false);
    }
    @Override
    public String onLock() {
        return null;
    }

    @Override
    public String onTrading() {
        return null;
    }

    @Override
    public String onDrawing(Table table, int count) {

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
        return "1";
    }

    @Override
    public String onPlanting(int fieldIndex) {
        return null;
    }

}
