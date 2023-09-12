package hearth.stone.cards;

public enum Heroes implements CardTemplate {
    VALEERA_SANGUINAR("Valeera Sanguinar", "rogue", "EDVIN_VAN_CLEEF", ""),
    GARROSH_HELL_SCREM("Garrosh Hellscream", "warrior", "ROT_FACE", ""),
    JAINE_PROUD_MOORE("Jaina Proudmoore", "mage", "JAINA_PROUD_MORE", ""),
    TYRANDE_WHISPER_WIND("Tyrande Whisperwind", "priest", "HIGH_PRIEST_AMET", ""),
    PRINCE_ARTHAS("Prince Arthas", "paladin", "GNOMISH_ARMY_KNIFE", "");

    private final String[] values;

    Heroes(String name, String cardCls, String minionName, String dust) {
        this.values = new String[]{name, cardCls, minionName, dust};
    }

    @Override
    public String getName() {
        return this.values[0];
    }

    @Override
    public String getCardClass() {
        return this.values[1];
    }

    public String getMinionName() {
        return this.values[2];
    }

    @Override
    public int getDust() {
        return Integer.parseInt(this.values[3]);
    }

    @Override
    public String getKind() {
        return "Hero";
    }

    @Override
    public int getManaInt() {
        return -1;
    }

    @Override
    public String getMana() {
        return "-1";
    }

}
