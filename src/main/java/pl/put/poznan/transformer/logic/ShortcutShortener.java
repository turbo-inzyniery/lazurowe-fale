package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class ShortcutExtender extends ShortcutTransform {

    public static String Transform(String text)
    {
        for ( String key : dic.keySet() ) {
            text = text.replaceAll(key, dic.get(key));
        }
        return text;
    }
}
