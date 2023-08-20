package hearth.stone.cards;

public enum Cards{
    TOMB_WARDEN("Tomb Warden", "")

    private final String[] values;

    Cards(String name, String mana, String dust, String rarity, String tribe, String cardCls, String effectDis){
        this.values = new String[]{name, mana, dust, rarity, tribe, cardCls, effectDis};
    }

    public String getName(){return this.values[0];}

    public int getMana(){return Integer.parseInt(this.values[1]);}

    public int getDust(){return Integer.parseInt(this.values[2])}

    public String getRarity(){return this.values[3];}

    public String getTribe(){return this.values[4];}

    public String getCardClass(){return this.values[5];}

    public String getEffectDisc(){return this.values[6];}
}


public abstract class Card {

    private final int id;
    private final Cards card;


    public Card(String name){
        this.id = 1;
        this.card = Cards.valueOf(name);
    }


    public void doEffect(){
        switch (this.getCard().getName()){
            default:
        }
    }


    public int getId(){return this.id;}

    public Cards getCard(){return this.card;}
}
