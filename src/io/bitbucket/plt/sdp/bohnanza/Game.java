package io.bitbucket.plt.sdp.bohnanza;

import io.bitbucket.plt.sdp.bohnanza.gui.Button;
import io.bitbucket.plt.sdp.bohnanza.gui.ButtonHandler;
import io.bitbucket.plt.sdp.bohnanza.gui.CardDnDHandler;
import io.bitbucket.plt.sdp.bohnanza.gui.CardObject;
import io.bitbucket.plt.sdp.bohnanza.gui.CardType;
import io.bitbucket.plt.sdp.bohnanza.gui.Compartment;
import io.bitbucket.plt.sdp.bohnanza.gui.Coordinate;
import io.bitbucket.plt.sdp.bohnanza.gui.GUI;
import io.bitbucket.plt.sdp.bohnanza.gui.Label;
import io.bitbucket.plt.sdp.bohnanza.gui.Size;

public class Game implements Runnable {
    
    private final GUI gui;
    @SuppressWarnings("unused")
    private final String[] args;

    public Game(GUI gui, String[] args) {
        super();
        this.gui = gui;
        this.args = args;
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
        
        Compartment vDistCompartment = gui.addCompartment(new Coordinate(0, 500), new Size(250, 300), "Player1");
        gui.addButton("arrange", new Coordinate(0, 500), new Size(99, 25), new ButtonHandler() {
            
            @Override
            public void buttonPressed(Button button) {
                vDistCompartment.distributeVertical(gui.getCardObjectsInCompartment(vDistCompartment));
            }
        });
        
        Compartment hDistCompartment = gui.addCompartment(new Coordinate(250, 500), new Size(250, 300), "Player2");
        gui.addButton("arrange", new Coordinate(250, 500), new Size(99, 25), new ButtonHandler() {
            
            @Override
            public void buttonPressed(Button button) {
                hDistCompartment.distributeHorizontal(gui.getCardObjectsInCompartment(hDistCompartment));
            }
        });
        
        Compartment vCentCompartment = gui.addCompartment(new Coordinate(500, 500), new Size(250, 300), "Player3");
        gui.addButton("arrange", new Coordinate(500, 500), new Size(99, 25), new ButtonHandler() {
            
            @Override
            public void buttonPressed(Button button) {
                vCentCompartment.centerVertical(gui.getCardObjectsInCompartment(vCentCompartment));
            }
        });

        Compartment hCentCompartment = gui.addCompartment(new Coordinate(750, 500), new Size(250, 300), "Player4");
        gui.addButton("arrange", new Coordinate(750, 500), new Size(99, 25), new ButtonHandler() {
            
            @Override
            public void buttonPressed(Button button) {
                hCentCompartment.centerHorizontal(gui.getCardObjectsInCompartment(hCentCompartment));

            }
        });

        gui.addCard(CardType.AUGEN_BOHNE,new Coordinate(400,300));

        final Label label = gui.addLabel(new Coordinate(500, 0), "<none>");

        gui.addCompartment(new Coordinate(1, 1), new Size(140, 140), "Handkarten");
        
        gui.addCompartment(new Coordinate(1, 200), new Size(300, 200), "Bohnenfelder", "BOHNENFELD_ALLE");

        gui.addButton("exit", new Coordinate(500, 20), new Size(80, 25), new ButtonHandler() {
            
            @Override
            public void buttonPressed(Button button) {
                gui.stop();
            }
        });
        
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
