package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains methods to capitalize and inverse string
 */
public class Functions {

    /**
     * Capitalizes text
     *
     * @param text text string to capitalize
     * @return text string after capitalize
     */
    public static String Capitalize(String text){
        String[] string_tab= text.split(" ");
        text = "";
        for(String text_fragment : string_tab){
            if (text_fragment.length() > 0) {
                text_fragment = text_fragment.substring(0, 1).toUpperCase() + text_fragment.substring(1);
                text += text_fragment + " ";
            }
        }
        return text;
    }

    /**
     * Inverses text keeping upper cases at original position
     *
     * @param text text string to inverse
     * @return text string after inverse
     */
    public static String inverse(String text){
        List<Integer> codePoints = new ArrayList<>();
        text.codePoints().forEach(point -> codePoints.add(point));

        List<char[]> charPairs = new ArrayList<>();
        codePoints.forEach(point -> charPairs.add(Character.toChars(point)));

        boolean [] isUpper = new boolean[charPairs.size()];
        for (int i = 0; i < charPairs.size(); i++){
            if(charPairs.get(i).length != 1){
                isUpper[i] = false;
                continue;
            }
            isUpper[i] = Character.isUpperCase(charPairs.get(i)[0]);
        }

        StringBuilder textBuilder = new StringBuilder();
        for (int i = 0, j = charPairs.size()-1; i < isUpper.length; i++, j--){
            if(charPairs.get(j).length == 1){
                if(isUpper[i]){
                    textBuilder.append(Character.toUpperCase(charPairs.get(j)[0]));
                }else {
                    textBuilder.append(Character.toLowerCase(charPairs.get(j)[0]));
                }
            }else {
                textBuilder.append(new String(charPairs.get(j)));
            }
        }

        return textBuilder.toString();
    }
}
