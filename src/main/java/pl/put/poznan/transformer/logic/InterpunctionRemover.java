package pl.put.poznan.transformer.logic;

/**
 * InterpunctionRemover is responsible for decorating Transformer with the interpunction removal operation
 */
public class InterpunctionRemover extends TransformerDecorator {
    public InterpunctionRemover(Transformer transformer) {
        super(transformer);
    }

    /**
     * Capitalizes text
     *
     * @return text string after capitalization
     */
    @Override
    public String transform() {
        String text = super.transform();

        text = text.replace(",","");
        text = text.replace(".","");
        text = text.replace("!", "");
        text = text.replace(":", "");
        text = text.replace("?", "");
        text = text.replace("\"", "");
        text = text.replace(";", "");

        return text;
    }
}
