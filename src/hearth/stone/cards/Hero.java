package hearth.stone.cards;

enum Heroes{
    VALEERA_SANGUINAR("Valeera Sanguinar", "Rogue", "EDVIN_VAN_CLEEF"),
    GARROSH_HELL_SCREM("Garrosh Hellscream", "Warrior", "ROT_FACE"),
    JAINE_PROUD_MOORE("Jaina Proudmoore", "Mage", "JAINA_PROUD_MORE"),
    TYRANDE_WHISPER_WIND("Tyrande Whisperwind", "Priest", "HIGH_PRIEST_AMET"),
    PRINCE_ARTHAS("Prince Arthas", "Paladin", "GNOMISH_ARMY_KNIFE");

    private final String[] values;

    Heroes(String name, String cardCls, String minionName){
        this.values = new String[]{name, cardCls, minionName};
    }

    public String getName(){return this.values[0];}

    public String getCardClass(){return this.values[1];}

    public String getMinionName(){return this.values[2];}

}


public class Hero implements damageAble{

    private final int id;
    private int health = 30;
    private final Heroes card;
    private final HeroPower heroPower;
    private final Minion minion;
    private Weapon weapon;


    public Hero(String name){
        this.id =1;
        this.card = Heroes.valueOf(name);
        this.heroPower = new HeroPower(name);
        this.minion = new Minion(card.getMinionName());
    }


    @Override
    public int attack(damageAble target){
        try {
            this.weapon.changeDurability(-1);
            if (target instanceof Minion)
                this.changeHealth(-((Minion) target).getDamage());
            if (this.weapon.getDurability() <= 0)
                this.setWeapon(null);
            return target.changeHealth(-this.weapon.getDamage());
        }
        catch (NullPointerException e){
            return target.getHealth();
        }
    }


    public Minion getMinion() {
        return minion;
    }

    public int getHealth() {
        return this.health;
    }

    @Override
    public int changeHealth(int change){
        this.health += change;
        return this.health;
    }

    public HeroPower getHeroPower() {
        return this.heroPower;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Heroes getCard() {
        return this.card;
    }

    public int getId() {
        return this.id;
    }
}
