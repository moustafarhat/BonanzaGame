package Extensions.Mafia.Core;

import BonanzaGame.Core.AbstractHumanPlayer;
import BonanzaGame.Core.AbstractPlayer;
import BonanzaGame.Core.Enums.GameStates;
import BonanzaGame.Core.Enums.TurnPhases;
import BonanzaGame.Core.GameSettings;
import BonanzaGame.Core.Table;
import BonanzaGame.Entities.Card;
import Extensions.Mafia.Interface.IMafiaExtension;
import io.bitbucket.plt.sdp.bohnanza.gui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MafiaExtension implements IMafiaExtension, Runnable {

    private AlCabohneExtensionTable _table;
    private Random _randomizer;
    private int _roundCount;
    private GameStates _gameState;
    private GameSettings _gameSettings;
    private TurnPhases _currentTurnPhase;
    private int maxRoundCount;
    private final GUI gui;
    @SuppressWarnings("unused")
    private final String[] args;

    public MafiaExtension (GUI gui, String[] args) {
        super();
        this.gui = gui;
        this.args = args;
    }

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
        initializeGame();
        run();
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

    private boolean initializeGame()
    {
        try {
            //gameSettings.getSettingValue("Round Count");
            maxRoundCount = 1; //todo here needs to be a setting
            _randomizer = new Random();
            this._table = new AlCabohneExtensionTableSolo();
            this.shuffle(_table.drawPile());
            _table.addPlayer("Human Player", 1);
            for (AbstractHumanPlayer player : _table.getHumanPlayers()){
                player.addCardsToHand(draw(7));
            }
            return true;
        } catch (Exception ex){
            System.out.println("GameManager could not initialize the game");
            ex.printStackTrace();
            return false;
        }

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

    @Override
    public void run() {
        int x = 0;
        int y = 0;
        for (CardType cardType : CardType.values()) {
            //gui.addCard(cardType, new Coordinate(x, y)).flip();
            x += 80;
            if (x > 920) {
                x = 0;
                y += 80;
            }
            if (y > 720) {
                y = 0;
                x = 0;
            }
        }

        //--------- Karten Stapel / Draw Pile -------------

        Compartment drawPile = gui.addCompartment(new Coordinate(280, 250), new Size(150, 130), "Kartenstapel");
        //gui.addCard(CardType.BLAUE_BOHNE, new Coordinate(310, 275));
        for (Card card : this._table.drawPile()){
            gui.addCard(card.getCardType().get_libraryCardType(), new Coordinate(310, 275));
        }

        //--------- Ablage Stapel / Discard Pile -------------
        Compartment discardPile = gui.addCompartment(new Coordinate(600, 250), new Size(150, 130), "Ablagestapel");
        gui.addCard(CardType.BLAUE_BOHNE, new Coordinate(470, 275));

        //--------- Münzen der Mafia -------------
        gui.addCompartment(new Coordinate(440, 250), new Size(150, 130), "Mafia Münzen");
        gui.addCard(CardType.BLAUE_BOHNE, new Coordinate(620, 275));

        //--------- Bohnen Felder des Spielers -------------

        Compartment vDistCompartment = gui.addCompartment(new Coordinate(200, 410), new Size(150, 170), "BohnenFeld1", "BOHNENFELD_3");
        gui.addButton("arrange", new Coordinate(200, 483), new Size(50, 25), new ButtonHandler() {

            @Override
            public void buttonPressed(Button button) {
                vDistCompartment.distributeVertical(gui.getCardObjectsInCompartment(vDistCompartment));
            }
        });

        Compartment hDistCompartment = gui.addCompartment(new Coordinate(425, 410), new Size(150, 170), "BohnenFeld2", "BOHNENFELD_3");
        gui.addButton("arrange", new Coordinate(425, 483), new Size(50, 25), new ButtonHandler() {

            @Override
            public void buttonPressed(Button button) {
                hDistCompartment.distributeHorizontal(gui.getCardObjectsInCompartment(hDistCompartment));
            }
        });

        Compartment vCentCompartment = gui.addCompartment(new Coordinate(650, 410), new Size(150, 170), "BohnenFeld3", "BOHNENFELD_3");
        gui.addButton("arrange", new Coordinate(650, 483), new Size(50, 25), new ButtonHandler() {

            @Override
            public void buttonPressed(Button button) {
                vCentCompartment.centerVertical(gui.getCardObjectsInCompartment(vCentCompartment));
            }
        });


        //--------- Handkarten des Spielers -------------
        int handCardX = 200;
        int handCardY = 645;
        Compartment playerHand = gui.addCompartment(new Coordinate(100, 600), new Size(800, 200), "Handkarten des Spielers");
        for (int i = 0; i < 7 ; i++){
            gui.addCard(CardType.AUGEN_BOHNE, new Coordinate(handCardX, handCardY));
            handCardX += 90;
        }
        gui.addButton("arange cards", new Coordinate(450, 600), new Size(99, 25), new ButtonHandler() {

            @Override
            public void buttonPressed(Button button) {
                playerHand.distributeHorizontal(gui.getCardObjectsInCompartment(playerHand));
                playerHand.centerVertical(gui.getCardObjectsInCompartment(playerHand));
            }
        });

        //--------- Bohnen Felder der Mafia -------------

        gui.addCompartment(new Coordinate(1, 200), new Size(300, 200), "Bohnenfeld_Al_Cabohne", "AL_CABOHNE");
        gui.addCompartment(new Coordinate(700, 200), new Size(300, 200), "Bohnenfeld_Don_Corlebohne", "DON_CORLEBOHNE");
        gui.addCompartment(new Coordinate(350, 20), new Size(300, 200), "Bohnenfeld_Joe_Bohnano", "JOE_BOHNANO");


        ////--------- Buttons -------------
        gui.addButton("Exit", new Coordinate(880, 20), new Size(50, 25), new ButtonHandler() {

            @Override
            public void buttonPressed(Button button) {
                gui.stop();
            }
        });

        gui.addButton("Start New Game", new Coordinate(780, 20), new Size(100, 25), new ButtonHandler() {

            @Override
            public void buttonPressed(Button button) {

            }
        });

        final Label label = gui.addLabel(new Coordinate(350, 0), " ");
        gui.setCardDnDHandler(new CardDnDHandler() {

            @Override
            public Coordinate cardDraggedAndDropped(CardObject card, Coordinate mouseCoordinate, Coordinate newCoordinate) {
                card.flip();
                label.updateLabel(card.toString());
                return newCoordinate;
//                if (gui.getCardAtPosition(mouseCoordinate) != null) {
//                    card.flip();
//                    return new Coordinate((newCoordinate.x / 10) * 10, (newCoordinate.y / 10) * 10);
//                }
//                else {
//                    return null;
//                }
            }
        });
    }
}
