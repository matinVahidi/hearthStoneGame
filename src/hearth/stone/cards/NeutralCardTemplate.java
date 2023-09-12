package hearth.stone.cards;

/**
 * currently game don't know which name is blong to which card class
 */
public enum NeutralCardTemplate implements CardTemplate{
    /**
     * Weapons
     */
    ARCANITE_RIPPER("Arcanite Ripper", "3", "", "Rare", "", "demonHunter", "Deathrattle:" +
            " Summon a 1/1 Lifesteal Undead. (Change your Health on your turn while equipped to improve!)", "true", "Weapon", "3", "2"),
    ALUNETH("Aluneth", "6", "", "Legendary", "", "mage",
            "At the end of your turn, draw 3 cards.", "true", "Weapon", "0", "3"),
    ALDRACHI_WARBLADES("Aldrachi Warblades", "3", "", "Common", "", "demonHunter",
            "Lifesteal", "true", "Weapon", "2", "2"),
    WICKED_KNIFE("Blood Fury", "3", "", "", "", "rouge",
            "", "false", "Weapon", "1", "2"),
    BLOOD_FURY("Blood Fury", "3", "", "", "", "warlock",
            "", "false", "Weapon", "3", "8"),
    MIRAGE_BLADE("Mirage Blade", "2", "", "", "", "rouge",
            "Your hero is Immune while attacking.", "false", "Weapon", "3", "2"),

    /**
     * Quests
     */
    BAZAAR_BURGLARY("Bazaar Burglary", "1", "", "Legendary", "", "rouge", "Quest" +
            " Add 4 cards from other classes to your hand. Reward: Ancient Blades.", "true", "Spell", "0", "0"),
    AWAKEN_THE_MAKERS("Awaken the Makers", "1", "", "Legendary", "", "priest", "Quest" +
            " Summon 7 Deathrattle minions. Reward: Amara, Warden of Hope.", "true", "Spell", "0", "0"),
    ACTIVATE_THE_OBELISK("Activate the Obelisk", "", "", "Legendary", "", "priest", "Quest:" +
            "Restore 15 Health. Reward: Obelisk's Eye.", "true", "Spell", "0", "0"),
    LEARN_DRAONIC("Learn Draconic", "1", "", "Common", "", "mage", "Quest" +
            "Spend 8 Mana on Spells. Reward: Summon a 6/6 Dragon.", "true", "Spell", "0", "0"),
    STRENGTH_IN_NUMBER("Strength in Numbers", "1", "", "Common", "", "druid", "Quest" +
            " Spend 10 Mana on minions. Reward: Summon a minion from your deck.", "true", "Spell", "0", "0"),


    /**
     * Minions
     */
    SOUL_STEALER("Soulstealer", "8", "", "Epic", "", "demonHunter",
            "Battlecry: Destroy all other minions. Gain 1 Corpse for each enemy destroyed.", "true",
            "Minion", "5", "5"),
    WIDOW_BLOOM_SEEDS_MAN("Widowbloom Seedsman", "4", "", "Epic", "", "druid",
            "Battlecry: Draw a Nature Spell. Gain an empty Mana Crystal.", "true",
            "Minion", "2", "3"),
    KOBOLD_LIBRARIAN("Kobold Librarian", "1", "", "Common", "", "warlock",
            "Battlecry: Draw a card. Deal 2 damage to your hero.", "true", "Minion", "1", "2"),
    RIGHTEOUS_PROTECTOR("Righteous Protector", "1", "", "Common", "", "paladin",
            "Taunt Divine Shield", "true", "Minion", "2", "2"),
    EDVIN_VAN_CLEEF("Edwin VanCleef", "3", "", "Legendary", "", "rouge",
            "Combo: Gain +2/+2 for each card played earlier this turn.", "true", "Minion", "1", "1"),
    ROT_FACE("Rotface", "8", "", "Legendary", "", "warrior",
            "After this minion survives damage, summon a random Legendary minion.", "true",
            "Minion", "6", "4"),
    NORGANNON("Norgannon", "6", "", "Legendary", "", "mage", "Titan\n" +
                    "After this uses an ability, double the power of the other abilities.", "true",
            "Minion", "8", "3"),
    HIGH_PRIEST_AMET("High Priest Amet", "4", "", "Legendary", "Pries", "priest",
            "Whenever you summon a minion, set its Health equal to this minion's.", "true",
            "Minion", "7", "2"),
    CURIO_COLLECTOR("Curio Collector", "5", "", "Rare", "", "mage",
            "Whenever you draw a card, gain +1/+1.", "true", "Minion", "4", "4"),
    SECURITY_ROVER("Security ROVER", "6", "", "Rare", "Mech", "warrior",
            "Whenever this minion takes damage, summon a 2/3 Mech with Taunt.", "true",
            "Minion", "2", "6"),
    TOMB_WARDEN("Tomb Warden", "8", "", "Rare", "Mech", "warrior", "Taunt\n" +
            "Battlecry: Summon a copy of this minion.", "true", "Minion", "6", "3"),
    SATHROVARR("Sathrovarr", "9", "", "Legendary", "Demon", "neutral",
            "Battlecry: Choose a friendly minion. Add a copy of it to your hand, deck, and battlefield.", "true",
            "Minion", "5", "5"),
    LOUCST("Locust", "1", "", "Free", "Beast", "neutral", "Rush", "false",
            "Minion", "1", "1"),


    /**
     * Spells
     */
    SAP("Sap", "2", "", "Free", "", "rouge",
            "Return an enemy minion to your opponent's hand.", "true", "Spell", "0", "0"),
    DRAGONFIRE_POTION("Dragonfire Potion", "2", "", "Epic", "Fire", "priest",
            "Deal 5 damage to all minions except Dragons.", "true", "Spell", "0", "0"),
    REFRESHING_SPRING_WATER("Refreshing Spring Water", "5", "", "Common", "", "mage",
            "Draw 2 cards. Refresh 2 Mana Crystals for each Spell drawn.", "true", "Spell", "0", "0"),
    SCALDING_GEYSER("Scalding Geyser", "1", "", "Common", "Fire", "shaman",
            "Deal 2 damage. Dredge.", "true", "Spell", "0", "0"),
    GNOMISH_ARMY_KNIFE("Gnomish Army Knife", "5", "", "Legendary", "", "paladin",
            "Give a minion Rush, Windfury, Divine Shield, Lifesteal, Poisonous, Taunt, and Stealth.", "true", "Spell"
            , "0", "0"),
    BOOK_OF_SPECTERS("Book of Specters", "2", "", "Epic", "Shadow", "mage",
            "Draw 3 cards. Discard any Spells drawn.", "true", "Spell", "0", "0"),
    PHAROH_S_BLESSING("Pharaoh’s Blessing", "6", "", "Rare", "Holy", "paladin",
            "Give a minion +4/+4, Divine Shield, and Taunt.", "true", "Spell", "0", "0"),
    SWARM_OF_LOUCSTS("Swarm of Locusts", "6", "", "Rare", "", "hunter",
            "Summon seven 1/1 Locusts with Rush", "true", "Spell", "0", "0"),
    SPRINT("Sprint", "5", "", "Free", "", "rouge", "Draw 4 cards.", "true",
            "Spell", "0", "0");


    private final String[] values;

    NeutralCardTemplate(String... args) {
        this.values = args;
    }

    @Override
    public String getName() {
        return this.values[0];
    }

    @Override
    public String getMana() {
        return this.values[1];
    }

    @Override
    public int getManaInt() {
        return Integer.parseInt(this.values[1]);
    }

    @Override
    public int getDust() {
        return Integer.parseInt(this.values[2]);
    }

    public String getRarity() {
        return this.values[3];
    }

    public String getTribe() {
        return this.values[4];
    }

    @Override
    public String getCardClass() {
        return this.values[5];
    }

    public String getEffectDisc() {
        return this.values[6];
    }

    public boolean getCollectAble() {
        return Boolean.parseBoolean(this.values[7]);
    }

    @Override
    public String getKind() {
        return this.values[8];
    }


    public String getHealth(){return this.values[9];}

    public String getDamage(){return this.values[10];}
}