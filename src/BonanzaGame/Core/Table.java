package BonanzaGame.Core;

import BonanzaGame.Core.Enums.CardTypes;
import BonanzaGame.Entities.Card;

import java.util.ArrayList;
import java.util.List;


public class Table extends AbstractTable {

    public Table()
    {
        maxPlayerCount = 5;
    }

    @Override
    public String toString() {
        return "Table Class";
    }
}
