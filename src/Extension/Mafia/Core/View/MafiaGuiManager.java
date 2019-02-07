package Extension.Mafia.Core.View;

import BonanzaCore.Core.AbstractLayer.Gui.GuiManager;
import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.TurnState.DrawingState;
import BonanzaCore.Core.TurnState.PlantingState;
import BonanzaCore.Core.AbstractLayer.PlayerState;
import Extension.Mafia.Core.AbstractLayer.MafiaTable;
import Extension.Mafia.Core.MafiaGameManager;
import Extension.Mafia.Interface.IMafiaGameManager;
import io.bitbucket.plt.sdp.bohnanza.gui.*;

import java.util.List;

//View Mafia
public class MafiaGuiManager extends GuiManager {

    private MafiaTable _mafiaTable;
    private IMafiaGameManager _mafiaGameManager;
    private final GUI gui;

    @SuppressWarnings("unused")

    public MafiaGuiManager(GUI gui) {
        super();
        this.gui = gui;
        _mafiaGameManager=new MafiaGameManager();
        _mafiaGameManager.startNewGame();
        _mafiaTable= ((MafiaGameManager) _mafiaGameManager)._mafiaTable;
    }

    @Override
    public void run() {


        HumanPlayer player = _mafiaTable.getHumanPlayers().get(0);

        //--------- Karten Stapel / Draw Pile -------------
        Compartment drawPile = gui.addCompartment(new Coordinate(280, 250), new Size(150, 130), "Kartenstapel");
        //gui.addCard(CardType.BLAUE_BOHNE, new Coordinate(310, 275));
        for (Card card : this._mafiaTable.drawPile()){
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
               List<Card> cards= _mafiaTable.getHumanPlayers().get(0).harvest(0);
                _mafiaTable.addCardToDiscardPile(cards);
                for (CardObject object : gui.getCardObjectsInCompartment(field1)){
                    gui.removeCard(object);
                }
                updateField1(field1);
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
                List<Card> cards= _mafiaTable.getHumanPlayers().get(0).harvest(1);
                _mafiaTable.addCardToDiscardPile(cards);
                for (CardObject object : gui.getCardObjectsInCompartment(field2)){
                    gui.removeCard(object);
                }
                updateField2(field2);
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
        for (Card card : _mafiaTable.getHumanPlayers().get(0).getHand()){
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

        gui.addButton("Start New BonanzaGame", new Coordinate(780, 20), new Size(100, 25), new ButtonHandler() {

            @Override
            public void buttonPressed(Button button) {

            }
        });
         */

        final Label label = gui.addLabel(new Coordinate(350, 0), " ");

        gui.setCardDnDHandler((card, mouseCoordinate, newCoordinate) -> {
            card.flip();
            label.updateLabel(card.toString());
            if (cardWasInHand(card) && movedToFirstField(newCoordinate)){
                //player.plant(player.getHand().get(player.getHand().size()-1),0);
                PlayerState playerState=new PlantingState(player);
                ((PlantingState)playerState).onPlanting(0);
                System.out.println("Card was in Hand and planted into first Field");
                updatePlayerHand(playerHand);
                playerHandButton.buttonHandler.buttonPressed(playerHandButton);
                updateField1(field1);
                arrangeField1Button.buttonHandler.buttonPressed(arrangeField1Button);
            }
            if (cardWasInHand(card) && movedToSecondField(newCoordinate)){
                //player.plant(player.getHand().get(player.getHand().size()-1),1);
                PlayerState playerState=new PlantingState(player);
                ((PlantingState)playerState).onPlanting(1);
                System.out.println("Card was in Hand and planted into second Field");
                updatePlayerHand(playerHand);
                playerHandButton.buttonHandler.buttonPressed(playerHandButton);
                updateField2(field2);
                arrangeField2Button.buttonHandler.buttonPressed(arrangeField2Button);
            }
            if (cardWasInDrawPile(card) && movedToHand(newCoordinate)){
                System.out.println("Card was in DrawPile and moved to Hand");
                //player.addCardsToHand(_mafiaGameManager.draw(1));
                PlayerState playerState=new DrawingState(player);
                ((DrawingState)playerState).onDrawing(_mafiaTable,1);
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
        HumanPlayer player = _mafiaTable.getHumanPlayers().get(0);
        for (Card card : player.getHand()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(150, 650)).flip();
        }
    }

    private void updateField1(Compartment field1){
        for (CardObject object : gui.getCardObjectsInCompartment(field1)){
            gui.removeCard(object);
        }
        HumanPlayer player = _mafiaTable.getHumanPlayers().get(0);
        for (Card card : player.getFields().get(0).getCards()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(200, 460)).flip();
        }
    }

    private void updateField2(Compartment field2){
        for (CardObject object : gui.getCardObjectsInCompartment(field2)){
            gui.removeCard(object);
        }
        HumanPlayer player = _mafiaTable.getHumanPlayers().get(0);
        for (Card card : player.getFields().get(1).getCards()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(450, 460)).flip();
        }
    }

    private void updateDrawPile(Compartment drawPile){
        for (CardObject object : gui.getCardObjectsInCompartment(drawPile)){
            gui.removeCard(object);
        }
        for (Card card : _mafiaTable.drawPile()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(310, 275));
        }
    }

    private void updateDiscardPile(Compartment discardPile){
        for (CardObject object : gui.getCardObjectsInCompartment(discardPile)){
            gui.removeCard(object);
        }
        for (Card card : _mafiaTable.discardPile()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(630, 275)).flip();
        }
    }

    private void updateTreasury(Compartment treasury){
        for (CardObject object : gui.getCardObjectsInCompartment(treasury)){
            gui.removeCard(object);
        }
        HumanPlayer player = _mafiaTable.getHumanPlayers().get(0);
        for (Card card : player.getTreasury()){
            gui.addCard(card.getCardType().get_libraryCardType(),new Coordinate(25, 430));
        }
    }
}
