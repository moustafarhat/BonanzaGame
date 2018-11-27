package BonanzaGame.Entities;

public class Reward
{
    private int cardsCount;
    private int coins;

    public Reward(int cardsCount, int coins) {
        this.cardsCount = cardsCount;
        this.coins = coins;
    }

    public int getCardsCount() {
        return cardsCount;
    }

    public void setCardsCount(int cardsCount) {
        this.cardsCount = cardsCount;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
