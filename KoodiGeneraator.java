package Ryhmatoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KoodiGeneraator {
    private static int randomSuurT2ht() {
        return 65 + (int) (Math.random() * ((90-65) + 1)) ;
    }

    private static int randomV2ikeT2ht() {
        return 97 + (int) (Math.random() * ((122-97) + 1));
    }

    private static int randomNumber() {
        return 48 + (int) (Math.random() * ((57-48) + 1));
    }

    public static String generaator() {

        List<String> elemendid = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            elemendid.add(Character.toString(randomSuurT2ht()));
        }
        for (int i = 6; i < 11; i++) {
            elemendid.add(Character.toString(randomV2ikeT2ht()));
        }

        for (int i = 11; i < 16; i++) {
            elemendid.add(Character.toString(randomNumber()));
        }

        Collections.shuffle(elemendid);

        StringBuilder sb = new StringBuilder();

        for(String el : elemendid) {
            sb.append(el);
        }



        return sb.toString();
    }
}
