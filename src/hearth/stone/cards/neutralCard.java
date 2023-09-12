package hearth.stone.cards;


public abstract class neutralCard implements effective {

    private final int id;
    private final NeutralCardTemplate card;


    public neutralCard(String name){
        this.id = 1;
        this.card = NeutralCardTemplate.valueOf(name);
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
