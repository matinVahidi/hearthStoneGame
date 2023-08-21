package hearth.stone.cards;

/**currently game don't know which nme is blong to which card class*/
public enum Cards{
    /**Quests*/
    LEARN_DRAONIC("Learn Draconic", "1", "", "Mage", "", "Common", "Sidequest:" +
            "Spend 8 Mana on spells. Reward: Summon a 6/6 Dragon.", "true"),
    STRENGTH_IN_NUMBER("Strength in Numbers", "1", "", "Common", "", "Druid", "Sidequest:" +
            " Spend 10 Mana on minions. Reward: Summon a minion from your deck.", "true"),


    /**Minions*/
    CURIO_COLLECTOR("Curio Collector", "5", "", "Rare", "", "Mage",
            "Whenever you draw a card, gain +1/+1.", "true"),
    SECURITY_ROVER("Security ROVER", "6", "", "Rare", "Mech", "Warrior",
            "Whenever this minion takes damage, summon a 2/3 Mech with Taunt.", "true"),
    TOMB_WARDEN("Tomb Warden", "8", "", "Rare", "Mech", "Warrior", "Taunt\n" +
                    "Battlecry: Summon a copy of this minion.", "true"),
    SATHROVARR("Sathrovarr", "9", "", "Legendary", "Demon", "Neutral",
            "Battlecry: Choose a friendly minion. Add a copy of it to your hand, deck, and battlefield.", "true"),
    LOUCST("Locust", "1", "", "Free", "Beast", "Neutral", "Rush", "false"),


    /**Spells*/
    BOOK_OF_SPECTERS("Book of Specters", "2", "", "Epic", "Shadow", "Mage",
            "Draw 3 cards. Discard any spells drawn.", "true"),
    PHAROH_S_BLESSING("Pharaoh’s Blessing", "6", "", "Rare", "Holy", "Paladin",
            "Give a minion +4/+4, Divine Shield, and Taunt.", "true"),
    SWARM_OF_LOUCSTS("Swarm of Locusts", "6", "", "Rare", "", "Hunter",
            "Summon seven 1/1 Locusts with Rush", "true"),
    SPRINT("Sprint", "5", "", "Free", "", "Rogue", "Draw 4 cards.", "true");


    private final String[] values;

    Cards(String name, String mana, String dust, String rarity, String tribe, String cardCls, String effectDis, String collectAble){
        this.values = new String[]{name, mana, dust, rarity, tribe, cardCls, effectDis, collectAble};
    }

    public String getName(){return this.values[0];}

    public int getMana(){return Integer.parseInt(this.values[1]);}

    public int getDust(){return Integer.parseInt(this.values[2])}

    public String getRarity(){return this.values[3];}

    public String getTribe(){return this.values[4];}

    public String getCardClass(){return this.values[5];}

    public String getEffectDisc(){return this.values[6];}

    public boolean getCollectAble(){return Boolean.parseBoolean(this.values[7]);}
}


public abstract class neutralCard implements effective {

    private final int id;
    private final Cards card;


    public neutralCard(String name){
        this.id = 1;
        this.card = Cards.valueOf(name);
    }


    public void doEffect(){
        switch (this.getCard().getName()){
            default:
        }
    }


    public int getId(){return this.id;}


    /**GameCollections GameStatus GameShop and GameInterface can use this function*/
    public Cards getCard(){return this.card;}
}
