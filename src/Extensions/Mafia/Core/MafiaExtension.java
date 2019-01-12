package Extensions.Mafia.Core;

import BonanzaGame.Core.AbstractPlayer;
import BonanzaGame.Core.Enums.GameStates;
import BonanzaGame.Core.Enums.TurnPhases;
import BonanzaGame.Core.GameSettings;
import BonanzaGame.Core.Table;
import BonanzaGame.Entities.Card;
import Extensions.Mafia.Interface.IMafiaExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MafiaExtension implements IMafiaExtension {

    private AlCabohneExtensionTable _table;
    private Random _randomizer;
    private int _roundCount;
    private GameStates _gameState;
    private GameSettings _gameSettings;
    private TurnPhases _currentTurnPhase;
    private int maxRoundCount;

    @Override
    public void shuffle(List<Card> cards) {

    }

    @Override
    public void newRound() {

    }

    @Override
    public void finishGame() {

    }

    @Override
    public void startNewGame() {

    }

    @Override
    public List<AbstractPlayer> getWinner() {

        if (gameOver()) {
            if (_table.getHumanPlayers().size() == 1) {
                //If the table is a solo table:
                //Counts the player's coins and the mafia's coins (all boss players coins added together)
                //If the player has more coins than the mafia -> the Player wins otherwise the mafia wins
                int playerCoins = _table.getHumanPlayers().get(0).getCoinCount();
                int bossPlayersCoins = 0;
                for (AbstractBossPlayer bossPlayer : _table.getBossPlayerList()) {
                    bossPlayersCoins += bossPlayer.getCoinCount();
                }
                ArrayList<AbstractPlayer> winners = new ArrayList<>();
                if (playerCoins > bossPlayersCoins) {
                    winners.add(_table.getHumanPlayers().get(0));
                    return winners;
                } else return new ArrayList<AbstractPlayer>(_table.getBossPlayerList());
            }
            if (_table.getHumanPlayers().size() == 2) {
                //If the table is a duo table:
                //Counts each player's coins and the mafia's coins (all boss players coins added together)
                //If a player has more coins than the mafia he wins otherwise the mafia wins
                int bossPlayersCoins = 0;
                for (AbstractBossPlayer bossPlayer : _table.getBossPlayerList()) {
                    bossPlayersCoins += bossPlayer.getCoinCount();
                }
                AbstractPlayer currentWinner = _table.getHumanPlayers().get(0);
                if (currentWinner.getCoinCount() == _table.getHumanPlayers().get(1).getCoinCount()){
                    //If both players have the same coins and Mafia has more coins, Mafia wins
                    if (bossPlayersCoins > currentWinner.getCoinCount()){
                        return new ArrayList<>(_table.getBossPlayerList());
                    }
                    ArrayList<AbstractPlayer> winners = new ArrayList<>();
                    //If both players have the same coins and Mafia has less coins, both players win
                    if (bossPlayersCoins < currentWinner.getCoinCount()){
                        winners.add(currentWinner);
                        winners.add(_table.getHumanPlayers().get(1));
                        return winners;
                    }
                    //If both players have the same coins and Mafia has the same coins, it's a draw between all participants
                    if (bossPlayersCoins == currentWinner.getCoinCount()){
                        winners.addAll(_table.getBossPlayerList());
                        winners.add(currentWinner);
                        winners.add(_table.getHumanPlayers().get(1));
                        return winners;
                    }
                }
                //If Player1 has less coins than Player2, Player2 is the winner out of them and is checked against mafia
                if (currentWinner.getCoinCount() < _table.getHumanPlayers().get(1).getCoinCount()){
                    currentWinner = _table.getHumanPlayers().get(1);
                }
                //If the Mafia has more coins, the Mafia wins
                if (bossPlayersCoins > currentWinner.getCoinCount()){
                    return new ArrayList<>(_table.getBossPlayerList());
                }
                ArrayList<AbstractPlayer> winners = new ArrayList<>();
                //If Mafia has less coins, currentWinner wins
                if (bossPlayersCoins < currentWinner.getCoinCount()){
                    winners.add(currentWinner);
                    return winners;
                }
                //If Mafia has equal coins it's a draw between Mafia and the currentWinner
                if (bossPlayersCoins == currentWinner.getCoinCount()){
                    winners.addAll(_table.getBossPlayerList());
                    winners.add(currentWinner);
                    return winners;
                }
            }
        } return new ArrayList<>();
    }

    private boolean gameOver(){
        //Game is over when maxRoundCount from the settings is reached
        return true;
        //return roundCount == maxRoundCount;//Integer.parseInt(gameSettings.getSettingValue("Round Count"));
    }

    @Override
    public List<Card> draw(int count) {
        List<Card> hand = new ArrayList<>();
        //If there are not enough cards to draw normally, set the deck to 0 and finish the game
        // todo this is a special setting for just one round, for multiple rounds the drawPile needs to be filled here
        if (count >= _table.drawPile().size()){
            _table.setDeck(new ArrayList<>());
            return hand;
        }
        //Else give out an ArrayList of cards with count-amount of cards in it
        for (int i = 0; i < count; i++) {
            if (_table.drawPile().size()> 0){
                Card randomCard = _table.drawPile().get(_randomizer.nextInt(_table.drawPile().size()));
                hand.add(randomCard);
                _table.removeCardFromDrawPile(randomCard);
            }
        }
        return hand;
    }
}
