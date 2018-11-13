package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/**
 * Contains a Transform() method to replace occurences of supported shortcuts with their full meaning.
 */
public class ShortcutExtender extends TransformerDecorator {

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

    public ShortcutExtender(Transformer transformer) {
        super(transformer);
    }

    /**
     * Replaces all occurences of supported shortcuts with their full meaning, respecting capitalization.
     *
     * @return text string after transformation
     */
    @Override
    public String transform()
    {
        String text = super.transform();
        for ( String key : dic.keySet() ) {
            text = text.replaceAll("^"+key+"\\s" , dic.get(key)+" ");
            text = text.replaceAll("\\s"+key+"$", " "+dic.get(key));
            text = text.replaceAll("\\s"+key+"\\s", " "+dic.get(key)+" ");
        }
        return text;
    }
}
