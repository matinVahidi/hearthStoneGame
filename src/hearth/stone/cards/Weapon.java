package hearth.stone.cards;

public class Weapon extends neutralCard{

     private int durability;
    private int damage;


    public Weapon(String name) {
        super(name);
        NeutralCardTemplate weapon = NeutralCardTemplate.valueOf(name);
        this.damage = Integer.parseInt(weapon.getDamage());
        this.durability = Integer.parseInt(weapon.getHealth());
    }


    public int getDurability(){return this.durability;}

    public int changeDurability(int change){
        this.durability += change;
        return this.durability;
    }

    public int getDamage(){return this.damage;}

    public int changeDamage(int change){
        this.damage += change;
        return this.damage;
    }


}
