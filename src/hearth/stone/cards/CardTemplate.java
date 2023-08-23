package hearth.stone.cards;

/**
 * currently game don't know which name is blong to which card class
 */
public enum CardTemplate {
    /**
     * Weapons
     */
    ARCANITE_RIPPER("Arcanite Ripper", "3", "", "Rare", "", "Death Knight", "Deathrattle:" +
            " Summon a 1/1 Lifesteal Undead. (Change your Health on your turn while equipped to improve!)", "true"),
    ALUNETH("Aluneth", "6", "", "Legendary", "", "Mage",
            "At the end of your turn, draw 3 cards.", "true"),
    ALDRACHI_WARBLADES("Aldrachi Warblades", "3", "", "Common", "", "Demon Hunter",
            "Lifesteal", "true"),
    WICKED_KNIFE("Blood Fury", "3", "", "", "", "Rogue",
            "", "false"),
    BLOOD_FURY("Blood Fury", "3", "", "", "", "Warlock",
            "", "false"),
    MIRAGE_BLADE("Mirage Blade", "2", "", "", "", "Rogue",
            "Your hero is Immune while attacking.", "false"),

    /**
     * Quests
     */
    BAZAAR_BURGLARY("Bazaar Burglary", "1", "", "Legendary", "", "Rogue", "Quest" +
            " Add 4 cards from other classes to your hand. Reward: Ancient Blades.", "true"),
    AWAKEN_THE_MAKERS("Awaken the Makers", "1", "", "Legendary", "", "Priest", "Quest" +
            " Summon 7 Deathrattle minions. Reward: Amara, Warden of Hope.", "true"),
    ACTIVATE_THE_OBELISK("Activate the Obelisk", "", "", "Legendary", "", "Priest", "Quest:" +
            "Restore 15 Health. Reward: Obelisk's Eye.", "true"),
    LEARN_DRAONIC("Learn Draconic", "1", "", "Common", "", "Mage", "Quest" +
            "Spend 8 Mana on spells. Reward: Summon a 6/6 Dragon.", "true"),
    STRENGTH_IN_NUMBER("Strength in Numbers", "1", "", "Common", "", "Druid", "Quest" +
            " Spend 10 Mana on minions. Reward: Summon a minion from your deck.", "true"),


    /**
     * Minions
     */
    SOUL_STEALER("Soulstealer", "8", "", "Epic", "", "Death Knight",
            "Battlecry: Destroy all other minions. Gain 1 Corpse for each enemy destroyed.", "true"),
    WIDOW_BLOOM_SEEDS_MAN("Widowbloom Seedsman", "4", "", "Epic", "", "Druid",
            "Battlecry: Draw a Nature spell. Gain an empty Mana Crystal.", "true"),
    KOBOLD_LIBRARIAN("Kobold Librarian", "1", "", "Common", "", "Warlock",
            "Battlecry: Draw a card. Deal 2 damage to your hero.", "true"),
    RIGHTEOUS_PROTECTOR("Righteous Protector", "1", "", "Common", "", "Paladin",
            "Taunt Divine Shield", "true"),
    EDVIN_VAN_CLEEF("Edwin VanCleef", "3", "", "Legendary", "", "Rogue",
            "Combo: Gain +2/+2 for each card played earlier this turn.", "true"),
    ROT_FACE("Rotface", "8", "", "Legendary", "", "Warrior",
            "After this minion survives damage, summon a random Legendary minion.", "true"),
    NORGANNON("Norgannon", "6", "", "Legendary", "", "Mage", "Titan\n" +
                    "After this uses an ability, double the power of the other abilities.", "true"),
    HIGH_PRIEST_AMET("High Priest Amet", "4", "", "Legendary", "Pries", "Priest",
            "Whenever you summon a minion, set its Health equal to this minion's.", "true"),
    CURIO_COLLECTOR("Curio Collector", "5", "", "Rare", "", "Mage",
            "Whenever you draw a card, gain +1/+1.", "true"),
    SECURITY_ROVER("Security ROVER", "6", "", "Rare", "Mech", "Warrior",
            "Whenever this minion takes damage, summon a 2/3 Mech with Taunt.", "true"),
    TOMB_WARDEN("Tomb Warden", "8", "", "Rare", "Mech", "Warrior", "Taunt\n" +
            "Battlecry: Summon a copy of this minion.", "true"),
    SATHROVARR("Sathrovarr", "9", "", "Legendary", "Demon", "Neutral",
            "Battlecry: Choose a friendly minion. Add a copy of it to your hand, deck, and battlefield.", "true"),
    LOUCST("Locust", "1", "", "Free", "Beast", "Neutral", "Rush", "false"),


    /**
     * Spells
     */
    SAP("Sap", "2", "", "Free", "", "Rogue",
            "Return an enemy minion to your opponent's hand.", "true"),
    DRAGONFIRE_POTION("Dragonfire Potion", "2", "", "Epic", "Fire", "Priest",
            "Deal 5 damage to all minions except Dragons.", "true"),
    REFRESHING_SPRING_WATER("Refreshing Spring Water", "5", "", "Common", "", "Mage",
            "Draw 2 cards. Refresh 2 Mana Crystals for each spell drawn.", "true"),
    SCALDING_GEYSER("Scalding Geyser", "1", "", "Common", "Fire", "Shaman",
            "Deal 2 damage. Dredge.", "true"),
    GNOMISH_ARMY_KNIFE("Gnomish Army Knife", "5", "", "Legendary", "", "Paladin",
            "Give a minion Rush, Windfury, Divine Shield, Lifesteal, Poisonous, Taunt, and Stealth.", "true"),
    BOOK_OF_SPECTERS("Book of Specters", "2", "", "Epic", "Shadow", "Mage",
            "Draw 3 cards. Discard any spells drawn.", "true"),
    PHAROH_S_BLESSING("Pharaoh’s Blessing", "6", "", "Rare", "Holy", "Paladin",
            "Give a minion +4/+4, Divine Shield, and Taunt.", "true"),
    SWARM_OF_LOUCSTS("Swarm of Locusts", "6", "", "Rare", "", "Hunter",
            "Summon seven 1/1 Locusts with Rush", "true"),
    SPRINT("Sprint", "5", "", "Free", "", "Rogue", "Draw 4 cards.", "true");


    private final String[] values;

    CardTemplate(String name, String mana, String dust, String rarity, String tribe, String cardCls, String effectDis, String collectAble) {
        this.values = new String[]{name, mana, dust, rarity, tribe, cardCls, effectDis, collectAble};
    }

    public String getName() {
        return this.values[0];
    }

    public int getMana() {
        return Integer.parseInt(this.values[1]);
    }

    public int getDust() {
        return Integer.parseInt(this.values[2]);
    }

    public String getRarity() {
        return this.values[3];
    }

    public String getTribe() {
        return this.values[4];
    }

    public String getCardClass() {
        return this.values[5];
    }

    public String getEffectDisc() {
        return this.values[6];
    }

    public boolean getCollectAble() {
        return Boolean.parseBoolean(this.values[7]);
    }
}
