package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text) {
        // of course normally it would to something based on transforms
        return text.toUpperCase();
    }

    public String choose_transformation(String text){
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
