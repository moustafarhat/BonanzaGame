package Extensions.Mafia.Core.Tables;

import Extensions.Mafia.Core.AbstractLayer.Table;
import Extensions.Mafia.Core.BossPlayers.BossPlayerAlCabohne;
import Extensions.Mafia.Core.BossPlayers.BossPlayerDonCorlebohne;

public class TableDuo extends Table {

    public TableDuo(){
        players.add(new BossPlayerAlCabohne());
        players.add(new BossPlayerDonCorlebohne());
    }
}
