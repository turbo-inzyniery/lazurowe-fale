package pl.put.poznan.transformer.logic;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LatexTransformerTest {
    static Transformer transformer;
    static String text;

    @Test
    public void transform1() {
        transformer = new BaseTransformer(" \\& \\& ");
        transformer = new LatexTransformer(transformer);
        text = transformer.transform();
        assertEquals(" & & ", text );
    }

    @Test
    public void transform2() {
        transformer = new BaseTransformer("\\& dsfbskfdsjgss\\$\\");
        transformer = new LatexTransformer(transformer);
        text = transformer.transform();
        assertEquals("& dsfbskfdsjgss$\\", text );
    }

    @Test
    public void transform3() {
        transformer = new BaseTransformer("\\$ \\& dansjdaf\\$sadfs\\& ");
        transformer = new LatexTransformer(transformer);
        text = transformer.transform();
        assertEquals( "$ & dansjdaf$sadfs& ", text );
    }

    @Test
    public void transform4() {
        transformer = new BaseTransformer("\\&\\$\\&\\$");
        transformer = new LatexTransformer(transformer);
        text = transformer.transform();
        assertEquals("&$&$", text );
    }
    @Test
    public void transform5() {
        transformer = new BaseTransformer("123\\&321\\&\\$\\$");
        transformer = new LatexTransformer(transformer);
        text = transformer.transform();
        assertEquals("123&321&$$", text );
    }

}