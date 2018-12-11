package pl.put.poznan.transformer.logic;

import org.junit.Before;

public class LatexTransformerTest {
    static Transformer transformer;
    static String text;

    @Before
    public void setUp(){
        transformer = new BaseTransformer(" \\& \\& ");
        transformer = new LatexTransformer(transformer);
        text = transformer.transform();
    }

}