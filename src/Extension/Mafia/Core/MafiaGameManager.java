package Extension.Mafia.Core;

import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.AbstractLayer.Player;
import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.Enums.GameStates;
import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.TurnState.DrawingState;
import BonanzaCore.Core.TurnState.PlayerState;
import Extension.Mafia.Core.AbstractLayer.BossPlayer;
import Extension.Mafia.Core.AbstractLayer.MafiaTable;
import Extension.Mafia.Core.Tables.MafiaTableFactory;
import Extension.Mafia.Enum.Tables;
import Extension.Mafia.Interface.IMafiaGameManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MafiaGameManager implements IMafiaGameManager{

    public MafiaTable _mafiaTable;
    private Random _randomizer;
    private int _roundCount;
    private GameStates _gameState;
    private TurnPhases _currentTurnPhase;
    private int maxRoundCount;
    @SuppressWarnings("unused")

    public MafiaGameManager() {
        super();
    }

    public void shuffle(List<Card> cards) {
        long seed = System.nanoTime();
        Collections.shuffle(_mafiaTable.drawPile(), new Random(seed));
    }

    @Override
    public void newRound() { }

    @Override
    public void finishGame() { }

    @Override
    public boolean startNewGame() {
        try {

            //gameSettings.getSettingValue("Round Count");
            maxRoundCount = 1; //todo here needs to be a setting
            _randomizer = new Random();
            this._mafiaTable = MafiaTableFactory.CreateTable(Tables.SOLO);
            this.shuffle(_mafiaTable.drawPile());
            _mafiaTable.addPlayer("Human GamePlayer", 1,3);
            for (HumanPlayer player : _mafiaTable.getHumanPlayers()){
                //player.addCardsToHand(draw(7));
                PlayerState playerState=new DrawingState(player);
                playerState.onDrawing(_mafiaTable,7);
            }
            return true;
        } catch (Exception ex){
            System.out.println("GameManager could not initialize the game");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Player> getWinner() {

        if (gameOver()) {
            if (_mafiaTable.getHumanPlayers().size() == 1) {
                //If the table is a solo table:
                //Counts the player's coins and the mafia's coins (all boss players coins added together)
                //If the player has more coins than the mafia -> the GamePlayer wins otherwise the mafia wins
                int playerCoins = _mafiaTable.getHumanPlayers().get(0).getCoinCount();
                int bossPlayersCoins = 0;
                for (BossPlayer bossPlayer : _mafiaTable.getBossPlayerList()) {
                    bossPlayersCoins += bossPlayer.getCoinCount();
                }
                ArrayList<Player> winners = new ArrayList<>();
                if (playerCoins > bossPlayersCoins) {
                    winners.add(_mafiaTable.getHumanPlayers().get(0));
                    return winners;
                } else return new ArrayList<Player>(_mafiaTable.getBossPlayerList());
            }
            if (_mafiaTable.getHumanPlayers().size() == 2) {
                //If the table is a duo table:
                //Counts each player's coins and the mafia's coins (all boss players coins added together)
                //If a player has more coins than the mafia he wins otherwise the mafia wins
                int bossPlayersCoins = 0;
                for (BossPlayer bossPlayer : _mafiaTable.getBossPlayerList()) {
                    bossPlayersCoins += bossPlayer.getCoinCount();
                }
                Player currentWinner = _mafiaTable.getHumanPlayers().get(0);
                if (currentWinner.getCoinCount() == _mafiaTable.getHumanPlayers().get(1).getCoinCount()){
                    //If both players have the same coins and Mafia has more coins, Mafia wins
                    if (bossPlayersCoins > currentWinner.getCoinCount()){
                        return new ArrayList<>(_mafiaTable.getBossPlayerList());
                    }
                    ArrayList<Player> winners = new ArrayList<>();
                    //If both players have the same coins and Mafia has less coins, both players win
                    if (bossPlayersCoins < currentWinner.getCoinCount()){
                        winners.add(currentWinner);
                        winners.add(_mafiaTable.getHumanPlayers().get(1));
                        return winners;
                    }
                    //If both players have the same coins and Mafia has the same coins, it's a draw between all participants
                    if (bossPlayersCoins == currentWinner.getCoinCount()){
                        winners.addAll(_mafiaTable.getBossPlayerList());
                        winners.add(currentWinner);
                        winners.add(_mafiaTable.getHumanPlayers().get(1));
                        return winners;
                    }
                }
                //If Player1 has less coins than Player2, Player2 is the winner out of them and is checked against mafia
                if (currentWinner.getCoinCount() < _mafiaTable.getHumanPlayers().get(1).getCoinCount()){
                    currentWinner = _mafiaTable.getHumanPlayers().get(1);
                }
                //If the Mafia has more coins, the Mafia wins
                if (bossPlayersCoins > currentWinner.getCoinCount()){
                    return new ArrayList<>(_mafiaTable.getBossPlayerList());
                }
                ArrayList<Player> winners = new ArrayList<>();
                //If Mafia has less coins, currentWinner wins
                if (bossPlayersCoins < currentWinner.getCoinCount()){
                    winners.add(currentWinner);
                    return winners;
                }
                //If Mafia has equal coins it's a draw between Mafia and the currentWinner
                if (bossPlayersCoins == currentWinner.getCoinCount()){
                    winners.addAll(_mafiaTable.getBossPlayerList());
                    winners.add(currentWinner);
                    return winners;
                }
            }
        } return new ArrayList<>();
    }

    @Override
    public boolean gameOver(){
        //BonanzaGame is over when maxRoundCount from the settings is reached
        return true;
        //return roundCount == maxRoundCount;//Integer.parseInt(gameSettings.getSettingValue("Round Count"));
    }

   /* @Override
    public List<Card> draw(int count) {
        List<Card> hand = new ArrayList<>();
        //If there are not enough cards to draw normally, set the deck to 0 and finish the game
        // todo this is a special setting for just one round, for multiple rounds the drawPile needs to be filled here
        if (count >= _mafiaTable.drawPile().size()){
            _mafiaTable.setDeck(new ArrayList<>());
            return hand;
        }
        //Else give out an ArrayList of cards with count-amount of cards in it
        for (int i = 0; i < count; i++) {
            if (_mafiaTable.drawPile().size()> 0){
                Card topCard = _mafiaTable.drawPile().get(_mafiaTable.drawPile().size()-1);
                hand.add(topCard);
                _mafiaTable.removeCardFromDrawPile(topCard);
            }
        }
        return hand;
    }*/
}
