package hearth.stone;

import hearth.stone.cards.CardTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.stream.Stream;

public class Player implements Serializable {

    private String name;
    private final int id;
    private Hashtable<CardTemplate, Integer> cards;
    private Hashtable<String , ArrayList<CardTemplate>> decks;


    public Player(String name){
        this.name = name;
        this.id = 0;
    }


    public Set<String> getDecksName(){
        return this.decks.keySet();
    }

    public void addDeck(String name, ArrayList<CardTemplate> deck){
        this.decks.put(name, deck);
    }

    public ArrayList<CardTemplate> getDeck(String name){
        return this.decks.get(name);
    }

    public void deleteCard(CardTemplate card){
        int count = this.cards.get(card);

        if (count == 1)
            this.cards.remove(card);
        else
            this.cards.put(card, --count);
    }

    public void addCard(CardTemplate card){
        if (this.cards.get(card) == null)
            this.cards.put(card, 1);
        else{
            int count = this.cards.get(card);
            this.cards.put(card, ++count);
        }
    }

    public Stream<CardTemplate> getCards(){
        return this.cards.keySet().stream();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getId() {
        return id;
    }
}
