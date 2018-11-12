package pl.put.poznan.transformer.logic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Can apply tranforms to given text
 */
public class TextTransformer {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformer.class);
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
        logger.debug("Text to transform: "+text);
        logger.debug("Transforms to apply:");
        for (String transform:
             transforms) {
            logger.debug(transform);
        }
        for(String operation : this.transforms){
            switch(operation){
                case "upper":
                    text = text.toUpperCase();
                    break;
                case "lower":
                    text = text.toLowerCase();
                    break;
                case "capitalize":
                    text = Functions.Capitalize(text);
                    break;
                case "inverse":
                    text = Functions.inverse(text);
                    break;
                case "extend":
                    text = ShortcutExtender.Transform(text);
                    break;
                case "shorten":
                    text = ShortcutShortener.Transform(text);
                    break;
                case "numberToWord":
                    text = NumberToWord.transform(text);
                    break;
            }
            logger.debug("Text after transform '"+operation+"': "+text);
        }
        logger.info("Returned text after transforms: "+text);
        return text;
    }
}
