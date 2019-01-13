package BonanzaGame.Core;

import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Field;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractPlayer {

    public PlayerState _PlayerState;
    public String name;
    public List<Field> fields;
    public List<Card> treasury;
    public PlayerState _playerstate;
    public boolean playing = false;

    protected AbstractPlayer() {
        this.fields = new ArrayList<>();
        this.treasury = new ArrayList<>();
    }

    public String getName() { return name; }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Field> getFields() { return fields; }

    public int getCoinCount() {
        //The amount of coins a player has equals to the amount of cards that were put into his/her treasury
        return treasury.size();
    };

    public void changeState(PlayerState playerState) {
        this._PlayerState = playerState;
    }

    public PlayerState get_PlayerState() {
        return _PlayerState;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void setTreasury(List<Card> treasury) {
        this.treasury.addAll(treasury);
    }

    public List<Card> getTreasury() { return treasury; }
}
