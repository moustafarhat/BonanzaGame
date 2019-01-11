package Extensions.Mafia.Core;

import Extensions.Mafia.Core.AlCabohneExtensionTable;
import Extensions.Mafia.Core.BossPlayerAlCabohne;
import Extensions.Mafia.Core.BossPlayerDonCorlebohne;
import Extensions.Mafia.Core.BossPlayerJoeBohnano;

public class AlCabohneExtensionTableSolo extends AlCabohneExtensionTable {

    public AlCabohneExtensionTableSolo(){
        players.add(new BossPlayerAlCabohne());
        players.add(new BossPlayerDonCorlebohne());
        players.add(new BossPlayerJoeBohnano());
    }

}
