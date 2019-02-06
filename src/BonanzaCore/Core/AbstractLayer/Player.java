package BonanzaCore.Core.AbstractLayer;

import BonanzaCore.Core.Entities.Reward;
import BonanzaCore.Core.TurnState.LockedState;
import BonanzaCore.Core.TurnState.PlantingState;
import BonanzaCore.Core.TurnState.PlayerState;
import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.Entities.Field;

import java.util.ArrayList;
import java.util.List;

  public abstract class Player {

    protected PlayerState playerState;
    public String name;
    public List<Field> fields;
    public List<Card> treasury;
    public boolean playing = false;
      private Reward highestReward;

    protected Player() {
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
        this.playerState = playerState;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void setTreasury(List<Card> treasury) {
        this.treasury.addAll(treasury);
    }

    public List<Card> getTreasury() { return treasury; }

    public abstract List<Card> harvest(int fieldPosition);

  }
