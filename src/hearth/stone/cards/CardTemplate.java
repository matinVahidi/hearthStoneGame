package hearth.stone.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public interface CardTemplate {

    String getName();

    String getCardClass();

    String getKind();

    int getManaInt();

    int getDust();

    String getMana();


    static ArrayList<CardTemplate> values(){
        List merged = new ArrayList<CardTemplate>(Arrays.asList(NeutralCardTemplate.values()));
        List list = new ArrayList<CardTemplate>(Arrays.asList(Heroes.values()));

        merged.add(list);

        return (ArrayList<CardTemplate>) merged;
    }


    class nameSort implements Comparator<CardTemplate> {

        @Override
        public int compare(CardTemplate card_1, CardTemplate card_2) {
            return card_1.getName().compareTo(card_2.getName());
        }
    }

    class manaSort implements Comparator<CardTemplate>{

        @Override
        public int compare(CardTemplate card_1, CardTemplate card_2) {
            return card_1.getManaInt() - card_2.getManaInt();
        }
    }

    class classNameSort implements Comparator<CardTemplate>{

        @Override
        public int compare(CardTemplate card_1, CardTemplate card_2) {
            return card_1.getCardClass().compareTo(card_2.getCardClass());
        }
    }
}
