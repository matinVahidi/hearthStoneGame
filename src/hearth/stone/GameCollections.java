package hearth.stone;

import hearth.stone.cards.CardTemplate;

import java.util.*;


public class GameCollections extends Game{

    private ArrayList<CardTemplate> cardsShown;


    public GameCollections(){
        this.cardsShown = allCards();
    }


    public boolean addDeck(String name,ArrayList<CardTemplate> cards){
        if (isDeckNameValid(name) == false)
            return false;

        player.addDeck(name, cards);
        return true;
    }

    private boolean isDeckNameValid(String name){
        if (player.getDecksName().contains(name))
            return false;
        return true;
    }


    public ArrayList<CardTemplate> allCards(){
        this.cardsShown = CardTemplate.values();
        return this.cardsShown;
    }


    public ArrayList<CardTemplate> playerCards(){
        this.cardsShown = player.getCards();
        return this.cardsShown;
    }


    public ArrayList<CardTemplate> notPlayerCards(){
        allCards();
        ArrayList<CardTemplate> playerCards = player.getCards();

         this.cardsShown.removeAll(playerCards);

        return this.cardsShown;
    }


    public ArrayList<CardTemplate> manaFilter(int mana){
        this.cardsShown = null;

        if (mana == 7){
            for (CardTemplate card: CardTemplate.values()){
                if (card.getMana() >=  mana)
                    this.cardsShown.add(card);
            }
        }
        else{
            for (CardTemplate card: CardTemplate.values()){
                if (card.getMana() == mana)
                    this.cardsShown.add(card);
            }
        }

        return this.cardsShown;
    }


    public ArrayList<CardTemplate> classFilter(String className){
        this.cardsShown = null;

        for (CardTemplate card: CardTemplate.values()){
            if (card.getCardClass().equals(className))
                this.cardsShown.add(card);
        }

        return this.cardsShown;
    }


    public ArrayList<CardTemplate> search(String key){
        this.cardsShown = null;

        for (CardTemplate card: CardTemplate.values()){
            if (card.getName().contains(key))
                this.cardsShown.add(card);
        }

        return this.cardsShown;
    }


    public ArrayList<CardTemplate> sort(String key){
        try {
            Comparator<CardTemplate> sortKey = (Comparator<CardTemplate>) Class.forName(key).newInstance();
            this.cardsShown.sort(sortKey);
            return this.cardsShown;
        }catch (Exception e){
            return null;
        }
    }
}
