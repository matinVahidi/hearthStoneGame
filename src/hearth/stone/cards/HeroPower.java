package hearth.stone.cards;


enum HeroPowers{
    VALEERA_SANGUINAR("Dagger Mastery", "Hero Power\nEquip a 1/2 Dagger."),
    GARROSH_HELL_SCREM("Armor Up!", "Hero Power\nGain 2 Armor."),
    JAINE_PROUD_MOORE("Fireblast",  "Hero Power\nDeal 1 damage."),
    INCE_ARTHAS("The Silver Hand", "Hero Power\nSummon two 1/1 Recruits."),
    TYRANDE_WHISPER_WINDPR("Heal", "Hero Power\nRestore 4 Health.");

    private final String[] values;

    HeroPowers(String name, String effectDis){
        this.values = new String[]{name, effectDis};
    }

    public String getEffectDisc(){return this.values[2];}
}



public class HeroPower implements effective{

    private int mana = 2;
    private final HeroPowers card;


    public HeroPower(String name){
        this.card = HeroPowers.valueOf(name);
        this.mana = this.card.getMana();
    }


    @Override
    public void doEffect(){
        switch (this.getCard().getName()){
            default:
        }
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public HeroPowers getCard() {
        return this.card;
    }
}
