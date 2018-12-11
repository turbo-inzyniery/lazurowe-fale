package pl.put.poznan.transformer.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberToWordTest {
    static Transformer transformer;
    static String text;

    @Test
    public void transformNumber1() {
        transformer = new BaseTransformer("121");
        transformer = new NumberToWord(transformer);
        text = transformer.transform();
        assertEquals("sto dwadzieścia jeden", text );
    }

    @Test
    public void transformNumber2() {
        transformer = new BaseTransformer("999");
        transformer = new NumberToWord(transformer);
        text = transformer.transform();
        assertEquals("dziewięćset dziewięćdziesiąt dziewięć", text );
    }

    @Test
    public void transformNumber3() {
        transformer = new BaseTransformer("8");
        transformer = new NumberToWord(transformer);
        text = transformer.transform();
        assertEquals("osiem", text );
    }

    @Test
    public void transformNumber4() {
        transformer = new BaseTransformer("120");
        transformer = new NumberToWord(transformer);
        text = transformer.transform();
        assertEquals("sto dwadzieścia", text );
    }

    @Test
    public void transformNumber5() {
        transformer = new BaseTransformer("33");
        transformer = new NumberToWord(transformer);
        text = transformer.transform();
        assertEquals("trzydzieści trzy", text );
    }
}