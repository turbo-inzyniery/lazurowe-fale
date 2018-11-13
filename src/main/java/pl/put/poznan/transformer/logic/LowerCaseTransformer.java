package pl.put.poznan.transformer.logic;

/**
 * LowerCaseTransformer is responsible for decorating Transformer with lower case operation
 */
public class LowerCaseTransformer extends TransformerDecorator {
    public LowerCaseTransformer(Transformer transformer) {
        super(transformer);
    }

    /**
     * Makes text returned from decorated Transformer lower case
     * @return text after lower case operation
     */
    @Override
    public String transform() {
        return super.transform().toLowerCase();
    }
}
