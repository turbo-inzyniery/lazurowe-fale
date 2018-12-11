package pl.put.poznan.transformer.logic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LatexTransformerTest {
    static Transformer transformer;
    static String text;

    @Before
    public void setUp(){
        transformer = new BaseTransformer(" \\& \\& ");
        transformer = new LatexTransformer(transformer);
        text = transformer.transform();
    }

    @Test
    public void transform1() {
        assertEquals(" & & ", text );
    }
}