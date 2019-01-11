package AlCabohneExtension;

import BonanzaGame.Core.Enums.CardTypes;
import BonanzaGame.Core.Player;
import BonanzaGame.Entities.Card;

import java.util.ArrayList;
import java.util.List;

public class AlCabohneExtensionTableSolo extends AlCabohneExtensionTable {

    public AlCabohneExtensionTableSolo(){
        players.add(new BossPlayerAlCabohne());
        players.add(new BossPlayerDonCorlebohne());
        players.add(new BossPlayerJoeBohnano());
    }

}
