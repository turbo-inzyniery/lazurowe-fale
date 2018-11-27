package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;

public class SentenceInverser extends TransformerDecorator {
    public SentenceInverser(Transformer transformer) { super(transformer); }

    @Override
    public String transform() {
        String text = super.transform();
        String[] cutedText = text.split(" ");
        List<String> reversedArray = new ArrayList<>();
        StringBuilder finalText = new StringBuilder();
        for (int i = (cutedText.length - 1); i >= 0; i-- ){
            reversedArray.add(cutedText[i]);
        }
        for (String part : reversedArray){
            finalText.append(part);
            finalText.append(" ");
        }
        if (finalText.length() > 0) {
            finalText.setLength(finalText.length() - 1);
        }
        return finalText.toString();
    }
}
