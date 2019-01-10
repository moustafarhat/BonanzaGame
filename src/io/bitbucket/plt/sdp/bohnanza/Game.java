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
            gui.addCard(cardType, new Coordinate(x, y)).flip();

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
        
        Compartment vDistCompartment = gui.addCompartment(new Coordinate(0, 800), new Size(250, 300), "vert. distr.");
        gui.addButton("arrange", new Coordinate(150, 805), new Size(99, 25), new ButtonHandler() {
            
            @Override
            public void buttonPressed(Button button) {
                vDistCompartment.distributeVertical(gui.getCardObjectsInCompartment(vDistCompartment));
            }
        });
        
        Compartment hDistCompartment = gui.addCompartment(new Coordinate(250, 800), new Size(250, 300), "hor. dist.");
        gui.addButton("arrange", new Coordinate(400, 805), new Size(99, 25), new ButtonHandler() {
            
            @Override
            public void buttonPressed(Button button) {
                hDistCompartment.distributeHorizontal(gui.getCardObjectsInCompartment(hDistCompartment));
            }
        });
        
        Compartment vCentCompartment = gui.addCompartment(new Coordinate(500, 800), new Size(250, 300), "vert. center");
        gui.addButton("arrange", new Coordinate(650, 805), new Size(99, 25), new ButtonHandler() {
            
            @Override
            public void buttonPressed(Button button) {
                vCentCompartment.centerVertical(gui.getCardObjectsInCompartment(vCentCompartment));
            }
        });

        Compartment hCentCompartment = gui.addCompartment(new Coordinate(750, 800), new Size(250, 300), "hor. center");
        gui.addButton("arrange", new Coordinate(900, 805), new Size(99, 25), new ButtonHandler() {
            
            @Override
            public void buttonPressed(Button button) {
                hCentCompartment.centerHorizontal(gui.getCardObjectsInCompartment(hCentCompartment));
            }
        });
        
        final Label label = gui.addLabel(new Coordinate(10, 100), "<none>");

        gui.addCompartment(new Coordinate(1, 1), new Size(140, 140), "Handkarten");
        
        gui.addCompartment(new Coordinate(1, 200), new Size(300, 200), "Bohnenfelder", "BOHNENFELD_ALLE");

        gui.addButton("exit", new Coordinate(100, 200), new Size(80, 25), new ButtonHandler() {
            
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
