package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Inverser is responsible for decorating Transformer with inverse operation
 */
public class Inverser extends TransformerDecorator {
    public Inverser(Transformer transformer) {
        super(transformer);
    }

    /**
     * Inverses text keeping upper cases at original position
     *
     * @return text string after inverse
     */
    @Override
    public String transform() {
        String text = super.transform();

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
