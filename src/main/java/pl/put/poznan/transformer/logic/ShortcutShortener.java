package pl.put.poznan.transformer.logic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShortcutShortener {

    private static final Map<String, String> dic;
    static {
        HashMap<String, String> hmap = new HashMap<>();
        hmap.put("profesor", "prof.");
        hmap.put("Profesor", "Prof.");
        hmap.put("PROFESOR", "PROF.");
        hmap.put("doktor", "dr");
        hmap.put("Doktor", "Dr");
        hmap.put("DOKTOR", "DR");
        hmap.put("na przykład", "np.");
        hmap.put("Na przykład", "Np.");
        hmap.put("NA PRZYKŁAD", "NP.");
        hmap.put("i tym podobne", "itd.");
        hmap.put("I tym podobne", "Itd.");
        hmap.put("I TYM PODOBNE", "ITD.");
        dic = Collections.unmodifiableMap(hmap);
    }

    public static String Transform(String text)
    {
        for ( String key : dic.keySet() ) {
            text = text.replaceAll(key, dic.get(key));
        }
        return text;
    }
}
