package hearth.stone.cards;

 enum Weapons{


     private int[] values;

     Weapons(int durability, int damage){
         this.values = new int[]{durability, damage};
     }

     public int getDurability(){return this.values[0];}

     public int getDamage(){return this.values[1];}
}

public class Weapon extends neutralCard{

     private int durability;
    private int damage;


    public Weapon(String name) {
        super(name);
        Weapons weapon = Weapons.valueOf(name);
        this.damage = weapon.getDamage();
        this.durability = weapon.getDurability();
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
