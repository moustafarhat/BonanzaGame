package Extension.Mafia.Core.Tables;

import Extension.Mafia.Core.AbstractLayer.MafiaTable;
import Extension.Mafia.Enum.BossPlayers;
import Extension.Mafia.Core.BossPlayers.BossPlayerFactory;

public class MafiaTableDuo extends MafiaTable {

    public MafiaTableDuo(){
        players.add(BossPlayerFactory.CreateBossPlayer(BossPlayers.ALCABOHNE));
        players.add(BossPlayerFactory.CreateBossPlayer(BossPlayers.DONCORLEBOHNE));
    }
}
