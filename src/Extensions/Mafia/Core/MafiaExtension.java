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
import java.util.Collections;
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
        long seed = System.nanoTime();
        Collections.shuffle(_table.drawPile(), new Random(seed));
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
            _table.addPlayer("Human Player", 1,3);
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
                Card topCard = _table.drawPile().get(_table.drawPile().size()-1);
                hand.add(topCard);
                _table.removeCardFromDrawPile(topCard);
            }
        }
        return hand;
    }

    @Override
    public void run() {

        AbstractHumanPlayer player = _table.getHumanPlayers().get(0);

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
        //gui.addCard(CardType.BLAUE_BOHNE, new Coordinate(470, 275));

        //--------- Münzen der Mafia -------------
        gui.addCompartment(new Coordinate(440, 250), new Size(150, 130), "Mafia Münzen");
        //gui.addCard(CardType.BLAUE_BOHNE, new Coordinate(620, 275));

        //--------- Münzen des Spielers -------------
        Compartment playerTreasury = gui.addCompartment(new Coordinate(25, 430), new Size(150, 130), "Spieler Münzen");
        Button playerTreasuryButton = gui.addButton("arrange", new Coordinate(25, 450), new Size(50, 25), new ButtonHandler() {

            @Override
            public void buttonPressed(Button button) {
                playerTreasury.centerVertical(gui.getCardObjectsInCompartment(playerTreasury));
                playerTreasury.distributeHorizontal(gui.getCardObjectsInCompartment(playerTreasury));
            }
        });
        //gui.addCard(CardType.BLAUE_BOHNE, new Coordinate(620, 275));

        //--------- Bohnen Felder des Spielers -------------
        Compartment field1 = gui.addCompartment(new Coordinate(200, 410), new Size(150, 170), "BohnenFeld1", "BOHNENFELD_3");
        gui.addButton("harvest", new Coordinate(200, 483), new Size(50, 25), new ButtonHandler() {

            @Override
            public void buttonPressed(Button button) {
                _table.addCardToDiscardPile(_table.getHumanPlayers().get(0).harvest(0));
                for (CardObject object : gui.getCardObjectsInCompartment(field1)){
                    gui.removeCard(object);
                }
                updateDiscardPile(discardPile);
                updateTreasury(playerTreasury);
                playerTreasuryButton.buttonHandler.buttonPressed(playerTreasuryButton);
                //vDistCompartment.distributeVertical(gui.getCardObjectsInCompartment(vDistCompartment));
            }
        });
        Button arrangeField1Button = gui.addButton("arrange", new Coordinate(200, 508), new Size(50, 25), new ButtonHandler() {
            @Override
            public void buttonPressed(Button button) {
                field1.distributeVertical(gui.getCardObjectsInCompartment(field1));
                field1.centerHorizontal(gui.getCardObjectsInCompartment(field1));
            }
        });

        Compartment field2 = gui.addCompartment(new Coordinate(425, 410), new Size(150, 170), "BohnenFeld2", "BOHNENFELD_3");
        gui.addButton("harvest", new Coordinate(425, 483), new Size(50, 25), new ButtonHandler() {
            @Override
            public void buttonPressed(Button button) {
                _table.addCardToDiscardPile(_table.getHumanPlayers().get(0).harvest(1));
                for (CardObject object : gui.getCardObjectsInCompartment(field2)){
                    gui.removeCard(object);
                }
                updateDiscardPile(discardPile);
                updateTreasury(playerTreasury);
                playerTreasuryButton.buttonHandler.buttonPressed(playerTreasuryButton);
            }
        });
        Button arrangeField2Button = gui.addButton("arrange", new Coordinate(425, 508), new Size(50, 25), new ButtonHandler() {
            @Override
            public void buttonPressed(Button button) {
                field2.distributeVertical(gui.getCardObjectsInCompartment(field2));
                field2.centerHorizontal(gui.getCardObjectsInCompartment(field2));
            }
        });

        Compartment vCentCompartment = gui.addCompartment(new Coordinate(650, 410), new Size(150, 170), "BohnenFeld3", "BOHNENFELD_3");
        gui.addButton("harvest", new Coordinate(650, 483), new Size(50, 25), new ButtonHandler() {

            @Override
            public void buttonPressed(Button button) {
                vCentCompartment.centerVertical(gui.getCardObjectsInCompartment(vCentCompartment));
            }
        });


        //--------- Handkarten des Spielers -------------

        int handCardX = 200;
        int handCardY = 645;
        Compartment playerHand = gui.addCompartment(new Coordinate(100, 600), new Size(800, 200), "Handkarten des Spielers");
        for (Card card : _table.getHumanPlayers().get(0).getHand()){
            gui.addCard(card.getCardType().get_libraryCardType(), new Coordinate(handCardX, handCardY)).flip();
            //handCardX += 90;
        }
        System.out.println(gui.getCardObjectsInCompartment(playerHand).length);

        Button playerHandButton = gui.addButton("arrange", new Coordinate(450, 600), new Size(100, 25), new ButtonHandler() {

            @Override
            public void buttonPressed(Button button) {
                playerHand.distributeHorizontal(gui.getCardObjectsInCompartment(playerHand));
                playerHand.centerVertical(gui.getCardObjectsInCompartment(playerHand));
            }
        });
        playerHandButton.buttonHandler.buttonPressed(playerHandButton);


        //--------- Bohnen Felder der Mafia -------------

        gui.addCompartment(new Coordinate(1, 20), new Size(300, 200), "Bohnenfeld_Al_Cabohne", "AL_CABOHNE");
        gui.addCompartment(new Coordinate(700, 20), new Size(300, 200), "Bohnenfeld_Joe_Bohnano", "JOE_BOHNANO");
        gui.addCompartment(new Coordinate(350, 20), new Size(300, 200), "Bohnenfeld_Don_Corlebohne", "DON_CORLEBOHNE");


        ////--------- Buttons -------------
        /*

        gui.addButton("Exit", new Coordinate(880, 300), new Size(50, 25), new ButtonHandler() {

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
         */

        final Label label = gui.addLabel(new Coordinate(350, 0), " ");

        gui.setCardDnDHandler(new CardDnDHandler() {

            @Override
            public Coordinate cardDraggedAndDropped(CardObject card, Coordinate mouseCoordinate, Coordinate newCoordinate) {
                card.flip();
                label.updateLabel(card.toString());
                if (cardWasInHand(card) && movedToFirstField(newCoordinate)){
                    player.plant(player.getHand().get(player.getHand().size()-1),0);
                    System.out.println("Card was in Hand and planted into first Field");
                    updatePlayerHand(playerHand);
                    playerHandButton.buttonHandler.buttonPressed(playerHandButton);
                    updateField1(field1);
                    arrangeField1Button.buttonHandler.buttonPressed(arrangeField1Button);
                }
                if (cardWasInHand(card) && movedToSecondField(newCoordinate)){
                    player.plant(player.getHand().get(player.getHand().size()-1),1);
                    System.out.println("Card was in Hand and planted into second Field");
                    updatePlayerHand(playerHand);
                    playerHandButton.buttonHandler.buttonPressed(playerHandButton);
                    updateField2(field2);
                    arrangeField2Button.buttonHandler.buttonPressed(arrangeField2Button);
                }
                if (cardWasInDrawPile(card) && movedToHand(newCoordinate)){
                    System.out.println("Card was in DrawPile and moved to Hand");
                    player.addCardsToHand(draw(1));
                    updatePlayerHand(playerHand);
                    playerHandButton.buttonHandler.buttonPressed(playerHandButton);
                    updateDrawPile(drawPile);
                }
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

    private boolean cardWasInHand(CardObject cardObject){
        return cardObject.getX() >= 100 && cardObject.getX() <= 900 && cardObject.getY() >= 600 && cardObject.getY() <= 800;
    }

    private boolean cardWasInDrawPile(CardObject cardObject){
        return cardObject.getX() >= 280 && cardObject.getX() <= 430 && cardObject.getY() >= 250 && cardObject.getY() <= 380;
    }

    private boolean movedToFirstField(Coordinate coordinate) {
        return coordinate.x >= 200 && coordinate.x <= 350 && coordinate.y >= 410 && coordinate.y <= 580;
    }

    private boolean movedToSecondField(Coordinate coordinate) {
        return coordinate.x >= 425 && coordinate.x <= 575 && coordinate.y >= 410 && coordinate.y <= 580;
    }

    private boolean movedToHand(Coordinate coordinate) {
        return coordinate.x >= 100 && coordinate.x <= 900 && coordinate.y >= 600 && coordinate.y <= 800;
    }

    private void updatePlayerHand(Compartment playerHand){
        for (CardObject object : gui.getCardObjectsInCompartment(playerHand)){
            gui.removeCard(object);
        }
        AbstractHumanPlayer player = _table.getHumanPlayers().get(0);
        for (Card card : player.getHand()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(150, 650)).flip();
        }
    }

    private void updateField1(Compartment field1){
        for (CardObject object : gui.getCardObjectsInCompartment(field1)){
            gui.removeCard(object);
        }
        AbstractHumanPlayer player = _table.getHumanPlayers().get(0);
        for (Card card : player.getFields().get(0).getCards()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(200, 460)).flip();
        }
    }

    private void updateField2(Compartment field2){
        for (CardObject object : gui.getCardObjectsInCompartment(field2)){
            gui.removeCard(object);
        }
        AbstractHumanPlayer player = _table.getHumanPlayers().get(0);
        for (Card card : player.getFields().get(1).getCards()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(450, 460)).flip();
        }
    }

    private void updateDrawPile(Compartment drawPile){
        for (CardObject object : gui.getCardObjectsInCompartment(drawPile)){
            gui.removeCard(object);
        }
        for (Card card : _table.drawPile()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(310, 275));
        }
    }

    private void updateDiscardPile(Compartment discardPile){
        for (CardObject object : gui.getCardObjectsInCompartment(discardPile)){
            gui.removeCard(object);
        }
        for (Card card : _table.discardPile()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(630, 275)).flip();
        }
    }

    private void updateTreasury(Compartment treasury){
        for (CardObject object : gui.getCardObjectsInCompartment(treasury)){
            gui.removeCard(object);
        }
        AbstractHumanPlayer player = _table.getHumanPlayers().get(0);
        for (Card card : player.getTreasury()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(25, 430));
        }
    }
}
