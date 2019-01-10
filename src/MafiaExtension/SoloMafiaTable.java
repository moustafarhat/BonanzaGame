package MafiaExtension;

public class SoloMafiaTable extends MafiaTable {
    BossType[] bosses = BossType.values();

    @Override
    public void addPlayer(String name, int position) {
        if (super.playerList().size() > 1){
            return;
        }
        super.addPlayer(name, position);
    }
}
