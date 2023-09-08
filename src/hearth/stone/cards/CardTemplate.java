package hearth.stone.cards;

import java.util.Comparator;

/**
 * currently game don't know which name is blong to which card class
 */
public enum CardTemplate{
    /**
     * Weapons
     */
    ARCANITE_RIPPER("Arcanite Ripper", "3", "", "Rare", "", "demonHunter", "Deathrattle:" +
            " Summon a 1/1 Lifesteal Undead. (Change your Health on your turn while equipped to improve!)", "true"),
    ALUNETH("Aluneth", "6", "", "Legendary", "", "mage",
            "At the end of your turn, draw 3 cards.", "true"),
    ALDRACHI_WARBLADES("Aldrachi Warblades", "3", "", "Common", "", "demonHunter",
            "Lifesteal", "true"),
    WICKED_KNIFE("Blood Fury", "3", "", "", "", "rouge",
            "", "false"),
    BLOOD_FURY("Blood Fury", "3", "", "", "", "warlock",
            "", "false"),
    MIRAGE_BLADE("Mirage Blade", "2", "", "", "", "rouge",
            "Your hero is Immune while attacking.", "false"),

    /**
     * Quests
     */
    BAZAAR_BURGLARY("Bazaar Burglary", "1", "", "Legendary", "", "rouge", "Quest" +
            " Add 4 cards from other classes to your hand. Reward: Ancient Blades.", "true"),
    AWAKEN_THE_MAKERS("Awaken the Makers", "1", "", "Legendary", "", "priest", "Quest" +
            " Summon 7 Deathrattle minions. Reward: Amara, Warden of Hope.", "true"),
    ACTIVATE_THE_OBELISK("Activate the Obelisk", "", "", "Legendary", "", "priest", "Quest:" +
            "Restore 15 Health. Reward: Obelisk's Eye.", "true"),
    LEARN_DRAONIC("Learn Draconic", "1", "", "Common", "", "mage", "Quest" +
            "Spend 8 Mana on spells. Reward: Summon a 6/6 Dragon.", "true"),
    STRENGTH_IN_NUMBER("Strength in Numbers", "1", "", "Common", "", "druid", "Quest" +
            " Spend 10 Mana on minions. Reward: Summon a minion from your deck.", "true"),


    /**
     * Minions
     */
    SOUL_STEALER("Soulstealer", "8", "", "Epic", "", "demonHunter",
            "Battlecry: Destroy all other minions. Gain 1 Corpse for each enemy destroyed.", "true"),
    WIDOW_BLOOM_SEEDS_MAN("Widowbloom Seedsman", "4", "", "Epic", "", "druid",
            "Battlecry: Draw a Nature spell. Gain an empty Mana Crystal.", "true"),
    KOBOLD_LIBRARIAN("Kobold Librarian", "1", "", "Common", "", "warlock",
            "Battlecry: Draw a card. Deal 2 damage to your hero.", "true"),
    RIGHTEOUS_PROTECTOR("Righteous Protector", "1", "", "Common", "", "paladin",
            "Taunt Divine Shield", "true"),
    EDVIN_VAN_CLEEF("Edwin VanCleef", "3", "", "Legendary", "", "rouge",
            "Combo: Gain +2/+2 for each card played earlier this turn.", "true"),
    ROT_FACE("Rotface", "8", "", "Legendary", "", "warrior",
            "After this minion survives damage, summon a random Legendary minion.", "true"),
    NORGANNON("Norgannon", "6", "", "Legendary", "", "mage", "Titan\n" +
                    "After this uses an ability, double the power of the other abilities.", "true"),
    HIGH_PRIEST_AMET("High Priest Amet", "4", "", "Legendary", "Pries", "priest",
            "Whenever you summon a minion, set its Health equal to this minion's.", "true"),
    CURIO_COLLECTOR("Curio Collector", "5", "", "Rare", "", "mage",
            "Whenever you draw a card, gain +1/+1.", "true"),
    SECURITY_ROVER("Security ROVER", "6", "", "Rare", "Mech", "warrior",
            "Whenever this minion takes damage, summon a 2/3 Mech with Taunt.", "true"),
    TOMB_WARDEN("Tomb Warden", "8", "", "Rare", "Mech", "warrior", "Taunt\n" +
            "Battlecry: Summon a copy of this minion.", "true"),
    SATHROVARR("Sathrovarr", "9", "", "Legendary", "Demon", "neutral",
            "Battlecry: Choose a friendly minion. Add a copy of it to your hand, deck, and battlefield.", "true"),
    LOUCST("Locust", "1", "", "Free", "Beast", "neutral", "Rush", "false"),


    /**
     * Spells
     */
    SAP("Sap", "2", "", "Free", "", "rouge",
            "Return an enemy minion to your opponent's hand.", "true"),
    DRAGONFIRE_POTION("Dragonfire Potion", "2", "", "Epic", "Fire", "priest",
            "Deal 5 damage to all minions except Dragons.", "true"),
    REFRESHING_SPRING_WATER("Refreshing Spring Water", "5", "", "Common", "", "mage",
            "Draw 2 cards. Refresh 2 Mana Crystals for each spell drawn.", "true"),
    SCALDING_GEYSER("Scalding Geyser", "1", "", "Common", "Fire", "shaman",
            "Deal 2 damage. Dredge.", "true"),
    GNOMISH_ARMY_KNIFE("Gnomish Army Knife", "5", "", "Legendary", "", "paladin",
            "Give a minion Rush, Windfury, Divine Shield, Lifesteal, Poisonous, Taunt, and Stealth.", "true"),
    BOOK_OF_SPECTERS("Book of Specters", "2", "", "Epic", "Shadow", "mage",
            "Draw 3 cards. Discard any spells drawn.", "true"),
    PHAROH_S_BLESSING("Pharaoh’s Blessing", "6", "", "Rare", "Holy", "paladin",
            "Give a minion +4/+4, Divine Shield, and Taunt.", "true"),
    SWARM_OF_LOUCSTS("Swarm of Locusts", "6", "", "Rare", "", "hunter",
            "Summon seven 1/1 Locusts with Rush", "true"),
    SPRINT("Sprint", "5", "", "Free", "", "rouge", "Draw 4 cards.", "true");


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

    public class nameSort implements Comparator<CardTemplate>{

        @Override
        public int compare(CardTemplate card_1, CardTemplate card_2) {
            return card_1.getName().compareTo(card_2.getName());
        }
    }

    public class manaSort implements Comparator<CardTemplate>{

        @Override
        public int compare(CardTemplate card_1, CardTemplate card_2) {
            return card_1.getMana() - card_2.getMana();
        }
    }

    public class classNameSort implements Comparator<CardTemplate>{

        @Override
        public int compare(CardTemplate card_1, CardTemplate card_2) {
            return card_1.getCardClass().compareTo(card_2.getCardClass());
        }
    }
}
