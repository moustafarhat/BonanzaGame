package BonanzaCore.Core;

import BonanzaCore.Core.AbstractLayer.Gui.GuiManager;
import BonanzaCore.Core.Interface.IGameStarter;
import Extension.Mafia.Core.View.MafiaGuiManager;
import io.bitbucket.plt.sdp.bohnanza.gui.Color;
import io.bitbucket.plt.sdp.bohnanza.gui.GUI;
import io.bitbucket.plt.sdp.bohnanza.gui.Size;

public class GameStarter implements IGameStarter {
    @Override
    public boolean startNewGame() {
        GUI gui = new GUI(
                new Size(1015, 850),
                new Size(80, 100),
                new Color(50,50,50),
                new Color(255,255,255));
        try {
            GuiManager mafiaGuiManager= new MafiaGuiManager(gui);
            new Thread(mafiaGuiManager).start();
            gui.start();

            return true;
        }

        catch (Exception ex)
        {
            System.out.println(ex);

            return false;
        }
    }
}
