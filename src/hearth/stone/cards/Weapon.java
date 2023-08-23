package hearth.stone.cards;

 enum Weapons{
     ARCANITE_RIPPER(3, 2),
     ALUNETH(0, 3),
     ALDRACHI_WARBLADES(2, 2),
     WICKED_KNIFE(1, 2),
     BLOOD_FURY(3, 8),
     MIRAGE_BLADE(3, 2);

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
