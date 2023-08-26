package hearth.stone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Player implements Serializable {

    private String name;
    private final int id;
    private Hashtable<String , Integer> cards;
    private Hashtable<String , ArrayList<String>> decks;


    public Player(String name){
        this.name = name;
        this.id = 0;
    }


    public Set<String> getDecksName(){
        return this.decks.keySet();
    }

    public void addDeck(String name, ArrayList<String> deck){
        this.decks.put(name, deck);
    }

    public ArrayList<String> getDeck(String name){
        return this.decks.get(name);
    }

    public void deleteCard(String name){
        int count = this.cards.get(name);

        if (count == 1)
            this.cards.remove(name);
        else
            this.cards.put(name, --count);
    }

    public void addCard(String name){
        if (this.cards.get(name) == null)
            this.cards.put(name, 1);
        else{
            int count = this.cards.get(name);
            this.cards.put(name, ++count);
        }
    }

    public String[] getCardsName(){
        return this.cards.keySet().toArray(new String[0]);
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
