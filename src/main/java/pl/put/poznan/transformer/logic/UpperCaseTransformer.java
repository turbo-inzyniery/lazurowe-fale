package pl.put.poznan.transformer.logic;

/**
 * UpperCaseTransformer is responsible for decorating Transformer with upper case operation
 */
public class UpperCaseTransformer extends TransformerDecorator {
    public UpperCaseTransformer(Transformer transformer) {
        super(transformer);
    }

    /**
     * Makes text returned from decorated Transformer upper case
     * @return text after upper case operation
     */
    @Override
    public String transform() {
        return super.transform().toUpperCase();
    }
}
