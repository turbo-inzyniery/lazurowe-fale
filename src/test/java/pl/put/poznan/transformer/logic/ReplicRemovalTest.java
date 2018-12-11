package pl.put.poznan.transformer.logic;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplicRemovalTest {
    static Transformer transformer;
    static String text;

    @Test
    public void transformReplicRemoval1() {
        transformer = new BaseTransformer("do do do do do do");
        transformer = new ReplicRemoval(transformer);
        text = transformer.transform();
        assertEquals("do", text );
    }

    @Test
    public void transformReplicRemoval2() {
        transformer = new BaseTransformer("do do");
        transformer = new ReplicRemoval(transformer);
        text = transformer.transform();
        assertEquals("do", text );
    }

    @Test
    public void transformReplicRemoval3() {
        transformer = new BaseTransformer("123456789 123456789 123456789");
        transformer = new ReplicRemoval(transformer);
        text = transformer.transform();
        assertEquals("123456789", text );
    }

    @Test
    public void transformReplicRemoval4() {
        transformer = new BaseTransformer("2 2 2 2 2 2 2");
        transformer = new ReplicRemoval(transformer);
        text = transformer.transform();
        assertEquals("2", text );
    }

    @Test
    public void transformReplicRemoval5() {
        transformer = new BaseTransformer("#$% #$%");
        transformer = new ReplicRemoval(transformer);
        text = transformer.transform();
        assertEquals("#$%", text );
    }
}