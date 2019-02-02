package Extension.Mafia.Core.Tables;

import Extension.Mafia.Core.AbstractLayer.MafiaTable;
import Extension.Mafia.Enum.Tables;

public class MafiaTableFactory
{
    public static MafiaTable CreateTable(Tables table)
    {
        if (table==Tables.SOLO)
        {
            return new MafiaTableSolo();
        }
        if (table==Tables.DUO)
            return new MafiaTableDuo();

        return null;
    }
}
