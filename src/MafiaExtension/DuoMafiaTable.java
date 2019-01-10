package MafiaExtension;

public class DuoMafiaTable extends MafiaTable{

    BossType[] bosses = new BossType[]{BossType.AL_CABOHNE, BossType.DON_CORLEBOHNE};

    @Override
    public void addPlayer(String name, int position) {
        if (super.playerList().size() > 2){
            return;
        }
        super.addPlayer(name, position);
    }

}
