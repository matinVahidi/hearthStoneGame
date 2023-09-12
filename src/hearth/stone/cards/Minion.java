package hearth.stone.cards;


public class Minion extends neutralCard implements damageAble{

    private int damage;
    private int health;



    public Minion(String name) {
        super(name);
        NeutralCardTemplate minion = NeutralCardTemplate.valueOf(name);
        this.damage = Integer.parseInt(minion.getDamage());
        this.health = Integer.parseInt(minion.getHealth());
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
