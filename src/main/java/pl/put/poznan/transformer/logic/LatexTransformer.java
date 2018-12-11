package pl.put.poznan.transformer.logic;

public class LatexTransformer extends TransformerDecorator  {
    public LatexTransformer(Transformer transformer) { super(transformer); }

    @Override
    public String transform() {
        String text = super.transform();
        char[] splitedTextToChar = text.toCharArray();
        StringBuilder finalText = new StringBuilder();
        for (int i = 0 ;  i < splitedTextToChar.length; i++){
            if(splitedTextToChar[i] == '\\') {
                int j = i + 1;
                if (j < splitedTextToChar.length) {
                    if (splitedTextToChar[j] == '&' || splitedTextToChar[j] == '$') {
                        i = j;
                    }
                }
            }
            finalText.append(splitedTextToChar[i]);
        }
        return finalText.toString();
    }
}
