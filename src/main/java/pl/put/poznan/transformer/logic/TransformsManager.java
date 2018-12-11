package pl.put.poznan.transformer.logic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Can apply tranforms to given text
 */
public class TransformsManager {

    private static final Logger logger = LoggerFactory.getLogger(TransformsManager.class);
    private final String[] transforms;
    private TransformerFactory factory;

    /**
     * Creates instance with transforms to apply
     * @param transforms array of transforms to apply on text
     */
    public TransformsManager(String[] transforms, TransformerFactory factory){
        this.transforms = transforms;
        this.factory = factory;
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

        Transformer transformer = factory.CreateBaseTransformer(text);
        for(String operation : this.transforms){
            switch(operation){
                case "upper":
                    transformer = factory.CreateUpperCaseTransformer(transformer);
                    break;
                case "lower":
                    transformer = factory.CreateLowerCaseTransformer(transformer);
                    break;
                case "capitalize":
                    transformer = factory.CreateCapitalizer(transformer);
                    break;
                case "inverse":
                    transformer = factory.CreateInverser(transformer);
                    break;
                case "extend":
                    transformer = factory.CreateShortcutExtender(transformer);
                    break;
                case "shorten":
                    transformer = factory.CreateShortcutShortener(transformer);
                    break;
                case "numberToWord":
                    transformer = factory.CreateNumberToWord(transformer);
                    break;
                case "inverseSentence":
                    transformer = factory.CreateSentenceInverser(transformer);
                    break;
                case "latexTransformer":
                    transformer = factory.CreateLatexTransformer(transformer);
                    break;
                case "pokemon":
                    transformer = factory.CreatePokemonTransformer(transformer);
                    break;
                case "unicode":
                    transformer = factory.CreateUnicode(transformer);
                    break;
                case "removeReplic":
                    transformer = factory.CreateReplicRemoval(transformer);
                    break;
            }
            logger.debug("Text after transform '"+operation+"': "+text);
        }
        text = transformer.transform();
        logger.info("Returned text after transforms: "+text);
        return text;
    }
}
