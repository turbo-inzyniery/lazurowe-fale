package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SentenceInverserTest {
    static Transformer transformer;
    static String text;

    @Test
    public void transformInverser1() {
        transformer = new BaseTransformer("123 456");
        transformer = new SentenceInverser(transformer);
        text = transformer.transform();
        assertEquals("456 123", text );
    }

    @Test
    public void transformInverser2() {
        transformer = new BaseTransformer("123 456 789");
        transformer = new SentenceInverser(transformer);
        text = transformer.transform();
        assertEquals("789 456 123", text );
    }

    @Test
    public void transformInverser3() {
        transformer = new BaseTransformer("123");
        transformer = new SentenceInverser(transformer);
        text = transformer.transform();
        assertEquals("123", text );
    }

    @Test
    public void transformInverser4() {
        transformer = new BaseTransformer("abcdedsfjgndsgsjd sfmdoijfissdfhseufhafhushfushdfuohs hfoeisahfoehs bagwiahoiff");
        transformer = new SentenceInverser(transformer);
        text = transformer.transform();
        assertEquals("bagwiahoiff hfoeisahfoehs sfmdoijfissdfhseufhafhushfushdfuohs abcdedsfjgndsgsjd", text );
    }

    @Test
    public void transformInverser5() {
        transformer = new BaseTransformer("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh d k l m n o p");
        transformer = new SentenceInverser(transformer);
        text = transformer.transform();
        assertEquals("p o n m l k d hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh", text );
    }
}