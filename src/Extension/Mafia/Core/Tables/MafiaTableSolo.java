package Extension.Mafia.Core.Tables;

import Extension.Mafia.Core.AbstractLayer.MafiaTable;
import Extension.Mafia.Core.BossPlayers.BossPlayerFactory;
import Extension.Mafia.Enum.BossPlayers;

import java.util.ArrayList;

public class MafiaTableSolo extends MafiaTable {

    public MafiaTableSolo(){
        bossPlayerList.add(BossPlayerFactory.CreateBossPlayer(BossPlayers.ALCABOHNE));
        bossPlayerList.add(BossPlayerFactory.CreateBossPlayer(BossPlayers.DONCORLEBOHNE));
        bossPlayerList.add(BossPlayerFactory.CreateBossPlayer(BossPlayers.JOEBAHNANO));
        this.deck = generateCards();
        this.players = new ArrayList<>();
        this.discardedCards = new ArrayList<>();
        this.humanPlayers = new ArrayList<>();
    }
}
