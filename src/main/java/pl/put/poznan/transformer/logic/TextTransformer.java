package pl.put.poznan.transformer.logic;

/**
 * Can apply tranforms to given text
 */
public class TextTransformer {

    private final String[] transforms;

    /**
     * Creates instance with transforms to apply
     * @param transforms array of transforms to apply on text
     */
    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    /**
     * Applies transforms given in constructor to text
     * @param text text to transform
     * @return text after transforms
     */
    public String applyTransformations(String text){
        for(String operation : this.transforms){
            switch(operation){
                case "upper":   text = text.toUpperCase();
                                break;
                case "lower":   text = text.toLowerCase();
                                break;
                case "capitalize":
                                text = Functions.Capitalize(text);
                                break;
                case "inverse": text = Functions.inverse(text);
                                break;
                case "letter":
                                break;
                case "short":
                                break;
                case "long":
                                break;
            }
        }
        return text;
    }
}
