package Extension.Mafia.Core.BossPlayers;

import Extension.Mafia.Core.AbstractLayer.BossPlayer;
import Extension.Mafia.Enum.BossPlayers;

public class BossPlayerFactory
{
    public static BossPlayer CreateBossPlayer(BossPlayers player)
    {
        if (player==BossPlayers.ALCABOHNE)
            return new BossPlayerAlCabohne();
        if (player==BossPlayers.DONCORLEBOHNE)
            return new BossPlayerDonCorlebohne();
        if (player==BossPlayers.JOEBAHNANO)
            return new BossPlayerJoeBohnano();
        return null;
    }
}
