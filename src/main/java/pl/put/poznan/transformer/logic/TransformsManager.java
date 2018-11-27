package pl.put.poznan.transformer.logic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Can apply tranforms to given text
 */
public class TransformsManager {

    private static final Logger logger = LoggerFactory.getLogger(TransformsManager.class);
    private final String[] transforms;

    /**
     * Creates instance with transforms to apply
     * @param transforms array of transforms to apply on text
     */
    public TransformsManager(String[] transforms){
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

        Transformer transformer = new BaseTransformer(text);
        for(String operation : this.transforms){
            switch(operation){
                case "upper":
                    transformer = new UpperCaseTransformer(transformer);
                    break;
                case "lower":
                    transformer = new LowerCaseTransformer(transformer);
                    break;
                case "capitalize":
                    transformer = new Capitalizer(transformer);
                    break;
                case "inverse":
                    transformer = new Inverser(transformer);
                    break;
                case "extend":
                    transformer = new ShortcutExtender(transformer);
                    break;
                case "shorten":
                    transformer = new ShortcutShortener(transformer);
                    break;
                case "numberToWord":
                    transformer = new NumberToWord(transformer);
                case "removeInterpunction":
                    transformer = new InterpunctionRemover(transformer);
            }
            logger.debug("Text after transform '"+operation+"': "+text);
        }
        text = transformer.transform();
        logger.info("Returned text after transforms: "+text);
        return text;
    }
}
