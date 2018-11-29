package BonanzaGame.Core;

import BonanzaGame.Core.Enums.GameState;
import BonanzaGame.Core.Enums.TurnPhases;
import BonanzaGame.Core.Interfaces.IGameManager;
import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Player;

import java.util.*;

public class GameManager implements IGameManager {
    private Table _table;
    private Random randomizer;
    private int roundCount;
    private GameState gameState;
    private GameSettings gameSettings;
    private TurnPhases currentTurnPhase;
    private int maxRoundCount;

    @Override
    public void shuffle(List<Card> cards) {
        //Glaube wir brauchen kein shuffle, da wir einfach bei draw eine zufällige Karte ausgeben können
    }

    @Override
    public void newRound() {
     //implementation here
    }

    @Override
    public void finishGame() {
     //implementation here
        if (getWinner()==null){
            System.out.println();
            System.out.println("The Game is over and nobody has won");
            for (Player player : _table.playerList()){
                System.out.println(player.getName() + " has earned " + player.getCoinCount() + " coins");
            }
            System.out.println();
            return;
        }
        else System.out.println();
        System.out.println("The winner is " + getWinner().getName() + " with " + getWinner().getCoinCount() + " coins in his treasury");
        System.out.println();
    }

    @Override
    public Turn newTurn() {
        return null;
    }

    @Override
    public void startNewGame() {
        //GameInitializer sets up table, players, player cards
        GameInitializer();
        System.out.println("Cards in deck left: " + _table.drawPile().size());
        for (Player player : _table.playerList()){
            System.out.println(player.getName() + " hand size is " + player.getHand().size());
        }
        //Now the game starts, the game lasts for maxRoundCount rounds
        for (roundCount = 0; roundCount < maxRoundCount; roundCount++){
            //One round lasts until the drawPile is emptied
            while (_table.drawPile().size() != 0){
                //Each player goes through the TurnPhases
                for (Player player : _table.playerList()){
                    if (_table.drawPile().size() < 2){
                        break;
                    }
                    // 1. plants up to two cards
                    System.out.println();
                    System.out.println(player.getName() + "'s turn");
                    currentTurnPhase = TurnPhases.PLANTING;
                    System.out.println("---------- Planting Phase ----------");
                    if (!player.plant(player.getHand().get(0), 0)){
                        _table.addCardToDiscardPile(player.harvest(0));
                        System.out.println("DiscardPile size is " + _table.discardPile().size());
                        player.plant(player.getHand().get(0),0);
                    }
                    player.plantAnotherCard(false, 0);
                    // 2. draws two trade cards and either trades or plants them
                    currentTurnPhase = TurnPhases.TRADING;
                    System.out.println("---------- Trading Phase ----------");
                    player.addCardsToTradingArea(draw(2));
                    System.out.println("Cards in deck left: " + _table.drawPile().size());
                    //todo if startTrading is false, trade cards must be planted and cards on that field harvested
                    player.startTrading(false);
                    //Player doesnt trade so his tradingArea must be planted
                    if (!player.getTradingArea().isEmpty()){
                        List<Card> cardsToBeRemovedFromTradingArea = new ArrayList<>();
                        for (Card card : player.getTradingArea()){
                            if (!player.plant(card,0 )) {
                                _table.addCardToDiscardPile(player.harvest(0));
                                System.out.println("Player harvested and the DiscardPile size is now " + _table.discardPile().size());
                                player.plant(card,0);
                            }
                            cardsToBeRemovedFromTradingArea.add(card);
                        }
                        player.removeFromTadingArea(cardsToBeRemovedFromTradingArea);
                    }
                    // 3. draws another 3 cards and ends his/her turn
                    currentTurnPhase = TurnPhases.DRAWING;
                    System.out.println("---------- Drawing Phase ----------");
                    player.addCardsToHand(draw(3));
                    System.out.println("Cards in deck left: " + _table.drawPile().size());
                }
            }
            //DrawPile is now empty, second round begins and so on
        }
        finishGame();
    }

    private boolean GameInitializer()
    {
        try {
            //gameSettings.getSettingValue("Round Count");
            maxRoundCount = 1; //todo here needs to be a setting
            gameState = GameState.STARTED;
            randomizer = new Random();
            this._table = new Table();
            this.shuffle(_table.drawPile());
            //todo maybe Console Input for Player names and automatic position
            _table.addPlayer("Player1", 1);
            _table.addPlayer("Player2", 2);
            _table.addPlayer("Player3", 3);
            _table.addPlayer("Player4", 4);
            for (Player player : _table.playerList()){
                player.addCardsToHand(draw(5));
            }
            return true;
        } catch (Exception ex){
            System.out.println("GameManager could not initialize the game");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Player getWinner() {
        if (gameOver()){
            Player currentWinner = _table.playerList().get(0);
            for (Player player : _table.playerList()){
                if (player.getCoinCount() > currentWinner.getCoinCount()){
                    currentWinner = player;
                }
            }
            if (currentWinner.getCoinCount() == 0){
                return null;
            }
            return currentWinner;
        } else return null;
    }

    private boolean gameOver(){
        return true;
        //return roundCount == maxRoundCount;//Integer.parseInt(gameSettings.getSettingValue("Round Count"));
    }

    @Override
    public void endTurn(Turn currentTurn) {
    //implementation here
    }

    @Override
    public List<Card> draw(int count) {
        List<Card> hand = new ArrayList<>();
        if (count >= _table.drawPile().size()){
            _table.setDeck(new ArrayList<>());
            return hand;
        }
        for (int i = 0; i < count; i++) {
            if (_table.drawPile().size()> 0){
                Card randomCard = _table.drawPile().get(randomizer.nextInt(_table.drawPile().size()));
                hand.add(randomCard);
                _table.removeCardFromDrawPile(randomCard);
            }
        }
        return hand;
    }
}