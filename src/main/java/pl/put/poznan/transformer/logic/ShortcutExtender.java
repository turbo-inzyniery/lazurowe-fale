package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/**
 * Contains a Transform() method to replace occurences of supported shortcuts with their full meaning.
 */
public class ShortcutExtender {

    private static final Map<String, String> dic;
    static {
        HashMap<String, String> hmap = new HashMap<>();
        hmap.put("prof.", "profesor");
        hmap.put("Prof.", "Profesor");
        hmap.put("PROF.", "PROFESOR");
        hmap.put("dr", "doktor");
        hmap.put("Dr", "Doktor");
        hmap.put("DR", "DOKTOR");
        hmap.put("np.", "na przykład");
        hmap.put("Np.", "Na przykład");
        hmap.put("NP.", "NA PRZYKŁAD");
        hmap.put("itd.", "i tym podobne");
        hmap.put("Itd.", "I tym podobne");
        hmap.put("ITD.", "I TYM PODOBNE");
        dic = Collections.unmodifiableMap(hmap);
    }

    /**
     * Replaces all occurences of supported shortcuts with their full meaning, respecting capitalization.
     *
     * @param text text string to replace
     * @return            text string after transformation
     */
    public static String Transform(String text)
    {
        for ( String key : dic.keySet() ) {
            text = text.replaceAll(key, dic.get(key));
        }
        return text;
    }
}
