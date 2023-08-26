package hearth.stone;

import hearth.stone.cards.CardTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class GameCollections extends Game{

//    private static ArrayList<String> notPlayerCards;
    private static Hashtable<Integer, ArrayList<String>> manaCards;
    private static Hashtable<String, ArrayList<String>> classCards;


    public boolean addDeck(String name, String[] cards){
        if (isDeckNameValid(name) == false)
            return false;

        ArrayList<String> deck = new ArrayList<>(List.of(cards));
        player.addDeck(name, deck);
        return true;
    }

    private boolean isDeckNameValid(String name){
        if (player.getDecksName().contains(name))
            return false;
        return true;
    }


    public String[] allCards(){
        return allCardsName;
    }


    public String[] playerCards(){
        return player.getCardsName();
    }


    public String[] notPlayerCards(){
        ArrayList<String> notPlayerCards = new ArrayList<>(Arrays.asList(allCardsName));
        ArrayList<String> playerCards = new ArrayList<>(Arrays.asList(player.getCardsName()));

        notPlayerCards.removeAll(playerCards);

        return notPlayerCards.toArray(new String[0]);
    }


//    public String[] notPlayerCards(){
//        if (notPlayerCards == null)
//            setNotPlayerCards();
//        return notPlayerCards.toArray(new String[0]);
//    }
//
//
//    private void setNotPlayerCards(){
//        ArrayList<String> notPlayerCardsList = new ArrayList<>(Arrays.asList(allCardsName));
//        ArrayList<String> playerCards = new ArrayList<>(Arrays.asList(player.getCardsName()));
//
//        notPlayerCardsList.removeAll(playerCards);
//
//        notPlayerCards = notPlayerCardsList;
//    }


    public String[] manaFilter(int mana){
        if (manaCards.get(mana) == null)
            return setManaCards(mana).toArray(new String[0]);

        return manaCards.get(mana).toArray(new String[0]);
    }


    private ArrayList<String> setManaCards(int mana){
        ArrayList<String> cardsWithMana = null;

        for (String cardName: allCardsName){
            if (CardTemplate.valueOf(cardName).getMana() == mana)
                cardsWithMana.add(cardName);
        }

        manaCards.put(mana, cardsWithMana);

        return cardsWithMana;
    }


    public String[] classFilter(String className){
        if (classCards.get(className) == null)
            return setClassCards(className).toArray(new String[0]);

        return classCards.get(className).toArray(new String[0]);
    }


    private ArrayList<String> setClassCards(String className){
        ArrayList<String> cardsWithClass = null;

        for (String cardName: allCardsName){
            if (CardTemplate.valueOf(cardName).getCardClass().equals(className))
                cardsWithClass.add(cardName);
        }

        return cardsWithClass;
    }


    public String[] search(String name){
        ArrayList<String> result = null;

        for (String cardName: allCardsName){
            if (CardTemplate.valueOf(cardName).getName().startsWith(name))
                result.add(cardName);
        }

        return result.toArray(new String[0]);
    }
}
