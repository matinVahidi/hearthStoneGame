package hearth.stone.cards;

enum Minions {
    SOUL_STEALER(5, 5),
    WIDOW_BLOOM_SEEDS_MAN2(2, 3),
    KOBOLD_LIBRARIAN(1, 2),
    EDVIN_VAN_CLEEF(2, 2),
    RIGHTEOUS_PROTECTOR(1, 1),
    ROT_FACE(6, 4),
    NORGANNON(8, 3),
    HIGH_PRIEST_AMET(7, 2),
    CURIO_COLLECTOR(4,4),
    SECURITY_ROVER(2, 6),
    TOMB_WARDEN(6, 3),
    SATHROVARR(5, 5),
    LOUCST(1, 1);


    private final int[] values;

    Minions(int health, int damage){
        this.values = new int[]{health, damage};
    }

    public int getHealth(){return this.values[0];}

    public int getDamage(){return this.values[1];}

}


public class Minion extends neutralCard implements damageAble{

    private int damage;
    private int health;



    public Minion(String name) {
        super(name);
        Minions minion = Minions.valueOf(name);
        this.damage = minion.getDamage();
        this.health = minion.getHealth();
    }


    @Override
    public int attack(damageAble target) {
        if (target instanceof Minion)
             this.changeHealth(-this.getDamage());
        return target.changeHealth(-this.getDamage());
    }

    public int getHealth(){return this.health;}


    @Override
    public int changeHealth(int change){
        this.health += change;
        return this.health;
    }

    public int getDamage(){return this.health;}

    public int changeDamage(int change){
        this.damage += change;
        return this.damage;
    }
}
