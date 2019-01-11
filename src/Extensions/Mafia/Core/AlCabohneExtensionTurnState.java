package Extensions.Mafia.Core;

import BonanzaGame.Core.Interfaces.IGameManager;

abstract public class AlCabohneExtensionTurnState {

    /*
    Phase 1: Use beans from previous turn
    Phase 2: Give beans to the Bean-Mafia
    Phase 3: Plant beans from hand
    Phase 4: Reveal beans from draw pile
    Phase 5: Cultivate beans
    Phase 6: Draw new bean-cards
    */


    IGameManager manager;

    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     */
    AlCabohneExtensionTurnState(IGameManager manager) {
        this.manager = manager;
    }

    public abstract void useBeansFromPreviousTurn();
    public abstract void giveBeansToMafia();
    public abstract void plantBeansFromHand();
    public abstract void revealBeansFromDrawPile();
    public abstract void cultivateBeans();
    public abstract void drawNewBeans();

    /*
    public abstract void onLock();
    public abstract void onPlay();
    public abstract void onNext();
    public abstract void onPrevious();
     */

}
