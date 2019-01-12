package Extensions.Mafia.Core;

import Extensions.Mafia.Core.AlCabohneExtensionTable;
import Extensions.Mafia.Core.BossPlayerAlCabohne;
import Extensions.Mafia.Core.BossPlayerDonCorlebohne;
import Extensions.Mafia.Core.BossPlayerJoeBohnano;

import java.util.ArrayList;

public class AlCabohneExtensionTableSolo extends AlCabohneExtensionTable {

    public AlCabohneExtensionTableSolo(){
        bossPlayerList.add(new BossPlayerAlCabohne());
        bossPlayerList.add(new BossPlayerDonCorlebohne());
        bossPlayerList.add(new BossPlayerJoeBohnano());
        this.deck = generateCards();
        this.players = new ArrayList<>();
        this.discardedCards = new ArrayList<>();
        this.humanPlayers = new ArrayList<>();
    }

}
