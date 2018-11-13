package pl.put.poznan.transformer.logic;

public class BaseTransformer implements Transformer {
    private String text;

    public BaseTransformer(String text){
        this.text = text;
    }

    @Override
    public String transform() {
        return text;
    }
}
