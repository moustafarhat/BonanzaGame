package BonanzaGame.Core.Enums;

import BonanzaGame.Entities.Reward;

import java.util.Arrays;
import java.util.List;

public enum CardTypes
{
    BLUEBEAN (20, "Blue Bean", Arrays.asList(
            new Reward(4, 1),
            new Reward(6, 2),
            new Reward(8, 3),
            new Reward(10, 4))),
    CHILIBEAN (18, "Chili Bean", Arrays.asList(
            new Reward(3, 1),
            new Reward(6, 2),
            new Reward(8, 3),
            new Reward(9, 4))),
    STINKBEAN (16, "Stink Bean", Arrays.asList(
            new Reward(3, 1),
            new Reward(5, 2),
            new Reward(7, 3),
            new Reward(8, 4))),
    GREENBEAN (14, "Green Bean" , Arrays.asList(
            new Reward(3, 1),
            new Reward(5, 2),
            new Reward(6, 3),
            new Reward(7, 4))),
    SOYBEAN (12, "Soy Bean" , Arrays.asList(
            new Reward(2, 1),
            new Reward(4, 2),
            new Reward(6, 3),
            new Reward(7, 4))),
    BLACKEYEDBEAN (10, "Black Eyed Bean" , Arrays.asList(
            new Reward(2, 1),
            new Reward(4, 2),
            new Reward(5, 3),
            new Reward(6, 4))),
    REDBEAN (8, "Red Bean" , Arrays.asList(
            new Reward(2, 1),
            new Reward(3, 2),
            new Reward(4, 3),
            new Reward(5, 4))),
    GARDENBEAN (6, "Garden Bean" , Arrays.asList(
            new Reward(2, 2),
            new Reward(3, 3)))
    ;

    private List<Reward> rewards;
    private int maxCardCount;
    private String name;

    CardTypes(int maxCardCount, String name, List<Reward> rewards) {
        this.maxCardCount = maxCardCount;
        this.name = name;
        this.rewards = rewards;
    }

    public int getMaxCardCount(){
        return this.maxCardCount;
    }

    public List<Reward> getRewards(){
        return this.rewards;
    }

    public String toString() {
        return this.name;
    }

}
