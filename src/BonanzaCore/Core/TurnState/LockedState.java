package BonanzaCore.Core.TurnState;


import BonanzaGame.GamePlayer;

public class LockedState extends PlayerState {

    LockedState(GamePlayer gamePlayer) {
        super(gamePlayer);
        gamePlayer.setPlaying(false);
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
}
