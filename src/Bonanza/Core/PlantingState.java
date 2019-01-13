package Bonanza.Core;

import Bonanza.Game.Player;

public class PlantingState extends PlayerState {

    PlantingState(Player player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        return null;
    }

    @Override
    public String onReady() {
        return null;
    }

    @Override
    public String onTrading() {
        return null;
    }

    @Override
    public String onDrawing() {
        return null;
    }

    @Override
    public String onPlanting() {
        return null;
    }

    public void plant(int fieldPosition)
    {
        //implementation here
    }
}
