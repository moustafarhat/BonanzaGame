package Extensions.Mafia.Core;

import BonanzaGame.Core.AbstractTable;

import java.util.List;

public abstract class AlCabohneExtensionTable extends AbstractTable {

    AlCabohneExtensionTable() {
        maxPlayerCount = 4;
    }
    protected List<AbstractBossPlayer> bossPlayerList;

    public List<AbstractBossPlayer> getBossPlayerList() {
        return bossPlayerList;
    }
}
