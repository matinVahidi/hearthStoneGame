package hearth.stone;

import hearth.stone.cards.CardTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;


public class GameCollections extends Game{

    private Stream<CardTemplate> cardsShown;


    public GameCollections(){
        this.cardsShown = allCards();
    }


    public boolean addDeck(String name, ArrayList<CardTemplate> cards){
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


    public Stream<CardTemplate> allCards(){
        this.cardsShown = CardTemplate.values().sorted();
        return this.cardsShown;
    }


    public Stream<CardTemplate> playerCards(){
        this.cardsShown = player.getCards().sorted();
        return this.cardsShown;
    }


    public Stream<CardTemplate> notPlayerCards(){
        this.cardsShown = allCards()
                .filter(card -> playerCards().noneMatch(cardTemp -> cardTemp.equals(card))).sorted();

        return this.cardsShown;
    }


    public Stream<CardTemplate> manaFilter(int mana){
        if (mana == 7)
            this.cardsShown = allCards()
                    .filter(card -> card.getManaInt() >=  mana);
        else
            this.cardsShown = allCards()
                    .filter(card -> card.getManaInt() ==  mana);

        return this.cardsShown.sorted();
    }


    public Stream<CardTemplate> classFilter(String className){
        this.cardsShown = allCards()
                .filter(card -> card.getCardClass() == className).sorted();

        return this.cardsShown;
    }


    public Stream<CardTemplate> search(String key){
        this.cardsShown = allCards()
                .filter(card -> card.getName() == key).sorted();

        return this.cardsShown;
    }


    public Stream<CardTemplate> sort(String key){
        try {
            Comparator<CardTemplate> sortKey = (Comparator<CardTemplate>) Class.forName(key).newInstance();
            this.cardsShown.sorted(sortKey);
            return this.cardsShown;
        }catch (Exception e){
            return null;
        }
    }
}
