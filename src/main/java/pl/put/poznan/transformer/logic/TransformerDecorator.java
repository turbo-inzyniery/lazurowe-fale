package pl.put.poznan.transformer.logic;

public class TransformerDecorator implements Transformer {
    private Transformer transformer;

    public TransformerDecorator(Transformer transformer){
        this.transformer = transformer;
    }

    @Override
    public String transform() {
        return this.transformer.transform();
    }
}
