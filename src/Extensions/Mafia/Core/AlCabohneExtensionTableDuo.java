package Extensions.Mafia.Core;

import Extensions.Mafia.Core.AlCabohneExtensionTable;
import Extensions.Mafia.Core.BossPlayerAlCabohne;
import Extensions.Mafia.Core.BossPlayerDonCorlebohne;

public class AlCabohneExtensionTableDuo extends AlCabohneExtensionTable {

    public AlCabohneExtensionTableDuo(){
        players.add(new BossPlayerAlCabohne());
        players.add(new BossPlayerDonCorlebohne());
    }

}
