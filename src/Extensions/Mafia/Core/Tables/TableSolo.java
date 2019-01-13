package Extensions.Mafia.Core.Tables;

import Extensions.Mafia.Core.AbstractLayer.Table;
import Extensions.Mafia.Core.BossPlayers.BossPlayerAlCabohne;
import Extensions.Mafia.Core.BossPlayers.BossPlayerDonCorlebohne;
import Extensions.Mafia.Core.BossPlayers.BossPlayerJoeBohnano;

import java.util.ArrayList;

public class TableSolo extends Table {

    public TableSolo(){
        bossPlayerList.add(new BossPlayerAlCabohne());
        bossPlayerList.add(new BossPlayerDonCorlebohne());
        bossPlayerList.add(new BossPlayerJoeBohnano());
        this.deck = generateCards();
        this.players = new ArrayList<>();
        this.discardedCards = new ArrayList<>();
        this.humanPlayers = new ArrayList<>();
    }
}
