package AlCabohneExtension;

import BonanzaGame.Core.Player;
import BonanzaGame.Entities.Card;

import java.util.List;

public class AlCabohneExtensionTableDuo extends AlCabohneExtensionTable {

    public AlCabohneExtensionTableDuo(){
        players.add(new BossPlayerAlCabohne());
        players.add(new BossPlayerDonCorlebohne());
    }

}
