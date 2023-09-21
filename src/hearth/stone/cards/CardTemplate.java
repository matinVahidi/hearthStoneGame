package hearth.stone.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public interface CardTemplate {

    String getName();

    String getCardClass();

    String getKind();

    int getManaInt();

    int getDust();

    String getMana();


    static Stream<CardTemplate> values(){
        Stream<CardTemplate> stream_1 = Arrays.stream(NeutralCardTemplate.values());
        Stream<CardTemplate> stream_2 = Arrays.stream(NeutralCardTemplate.values());

        return Stream.concat(stream_1, stream_2);
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
