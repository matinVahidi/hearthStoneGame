package hearth.stone.cards;


public abstract class neutralCard implements effective {

    private final int id;
    private final CardTemplate card;


    public neutralCard(String name){
        this.id = 1;
        this.card = CardTemplate.valueOf(name);
        this.card.raiseCount();
    }


    public void doEffect(){
        switch (this.getCard().getName()){
            default:
        }
    }


    public int getId(){return this.id;}


    /**GameCollections GameStatus GameShop and GameInterface can use this function*/
    public CardTemplate getCard(){return this.card;}
}
