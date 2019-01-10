package BonanzaGame.Core.Enums;
import io.bitbucket.plt.sdp.bohnanza.gui.CardType;

import BonanzaGame.Entities.Reward;

import java.util.Arrays;
import java.util.List;

/**
 * The enumeration 'CardTypes' describes a datatype for all avaiable card types in the game
 * Each CardType has a varying maximum number of instances in the card deck described by the maxCardCount variable,
 * a name which specifies the toString output and specific Rewards depending on the CardType
 * @version 1
 * @author Arthur K
 */
public enum CardTypes
{
	 
    BLUEBEAN (20, "Blue Bean", Arrays.asList(
            new Reward(4, 1),
            new Reward(6, 2),
            new Reward(8, 3),
            new Reward(10, 4)),
    		CardType.BLAUE_BOHNE),
    CHILIBEAN (18, "Chili Bean", Arrays.asList(
            new Reward(3, 1),
            new Reward(6, 2),
            new Reward(8, 3),
            new Reward(9, 4)),
    		CardType.FEUER_BOHNE),
    STINKBEAN (16, "Stink Bean", Arrays.asList(
            new Reward(3, 1),
            new Reward(5, 2),
            new Reward(7, 3),
            new Reward(8, 4)),
            CardType.SAU_BOHNE),
    GREENBEAN (14, "Green Bean" , Arrays.asList(
            new Reward(3, 1),
            new Reward(5, 2),
            new Reward(6, 3),
            new Reward(7, 4)),
            CardType.BRECH_BOHNE),
    SOYBEAN (12, "Soy Bean" , Arrays.asList(
            new Reward(2, 1),
            new Reward(4, 2),
            new Reward(6, 3),
            new Reward(7, 4)),
            CardType.SOJA_BOHNE),
    BLACKEYEDBEAN (10, "Black Eyed Bean" , Arrays.asList(
            new Reward(2, 1),
            new Reward(4, 2),
            new Reward(5, 3),
            new Reward(6, 4)),
            CardType.AUGEN_BOHNE),
    REDBEAN (8, "Red Bean" , Arrays.asList(
            new Reward(2, 1),
            new Reward(3, 2),
            new Reward(4, 3),
            new Reward(5, 4)),
            CardType.ROTE_BOHNE),
    GARDENBEAN (6, "Garden Bean" , Arrays.asList(
            new Reward(2, 2),
            new Reward(3, 3)),
            CardType.GARTEN_BOHNE),
    ;

    private List<Reward> rewards;
    private int maxCardCount;
    private String name;
    private CardType _libraryCardType;
    
    /**
     * Constructor for a CardType
     * Each enumeration object of CardType contains variables which depend on the specific CardType
     * @param maxCardCount describes the amount of occurrences of a given CardType in the game deck
     * @param name describes a card name and its toString implementation of a given CardType
     * @param rewards describes the list of coin rewards of a given CardType
     */
    CardTypes(int maxCardCount, String name, List<Reward> rewards, CardType libraryCardType) {
    	this._libraryCardType=libraryCardType;
        this.maxCardCount = maxCardCount;
        this.name = name;
        this.rewards = rewards;
        
    }

    public CardType get_libraryCardType(){
        return this._libraryCardType;
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
