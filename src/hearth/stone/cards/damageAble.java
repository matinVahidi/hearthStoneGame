package hearth.stone.cards;

public interface damageAble {

    int attack(damageAble target);

    int changeHealth(int change);

    int getHealth();
}
