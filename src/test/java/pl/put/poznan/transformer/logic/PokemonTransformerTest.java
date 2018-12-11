package pl.put.poznan.transformer.logic;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonTransformerTest {
    static Transformer transformer;
    static String text;

    @Test
    public void transformPokemon1() {
        transformer = new BaseTransformer("witam");
        transformer = new PokemonTransformer(transformer);
        text = transformer.transform();
        assertEquals("w!t4m", text );
    }

    @Test
    public void transformPokemon2() {
        transformer = new BaseTransformer("Hello Worldz");
        transformer = new PokemonTransformer(transformer);
        text = transformer.transform();
        assertEquals("H3Ll0 W0RlD2", text );
    }

    @Test
    public void transformPokemon3() {
        transformer = new BaseTransformer("ASEIOZ");
        transformer = new PokemonTransformer(transformer);
        text = transformer.transform();
        assertEquals("4$3!02", text );
    }

    @Test
    public void transformPokemon4() {
        transformer = new BaseTransformer("plmkjugh");
        transformer = new PokemonTransformer(transformer);
        text = transformer.transform();
        assertEquals("pLmKjUgH", text );
    }

    @Test
    public void transformPokemon5() {
        transformer = new BaseTransformer("nowy tekst IO");
        transformer = new PokemonTransformer(transformer);
        text = transformer.transform();
        assertEquals("n0wY t3k$t !0", text );
    }
}