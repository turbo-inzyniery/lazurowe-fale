package pl.put.poznan.transformer.logic;

/**
 * Capitalizer is responsible for decorating Transformer with capitalize operation
 */
public class Capitalizer extends TransformerDecorator {
    public Capitalizer(Transformer transformer) {
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
        String[] string_tab= text.split(" ");
        text = "";
        for(String text_fragment : string_tab){
            if (text_fragment.length() > 0) {
                text_fragment = text_fragment.substring(0, 1).toUpperCase() + text_fragment.substring(1);
                text += text_fragment + " ";
            }
        }
        return text;
    }
}
