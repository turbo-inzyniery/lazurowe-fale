package pl.put.poznan.transformer.logic;

public class TransformerFactory {

    public Transformer CreateBaseTransformer(String text)
    {
        return new BaseTransformer(text);
    }

    public Transformer CreateCapitalizer(Transformer transformer)
    {
        return new Capitalizer(transformer);
    }

    public Transformer CreateUpperCaseTransformer(Transformer transformer)
    {
        return new UpperCaseTransformer(transformer);
    }

    public Transformer CreateLowerCaseTransformer(Transformer transformer)
    {
        return new LowerCaseTransformer(transformer);
    }

    public Transformer CreateInverser(Transformer transformer)
    {
        return new Inverser(transformer);
    }

    public Transformer CreateShortcutExtender(Transformer transformer)
    {
        return new ShortcutExtender(transformer);
    }

    public Transformer CreateShortcutShortener(Transformer transformer)
    {
        return new ShortcutShortener(transformer);
    }

    public Transformer CreateNumberToWord(Transformer transformer)
    {
        return new NumberToWord(transformer);
    }

    public Transformer CreateSentenceInverser(Transformer transformer)
    {
        return new SentenceInverser(transformer);
    }

    public Transformer CreateLatexTransformer(Transformer transformer)
    {
        return new LatexTransformer(transformer);
    }

    public Transformer CreatePokemonTransformer(Transformer transformer)
    {
        return new PokemonTransformer(transformer);
    }

    public Transformer CreateUnicode(Transformer transformer)
    {
        return new Unicode(transformer);
    }

    public Transformer CreateReplicRemoval(Transformer transformer)
    {
        return new ReplicRemoval(transformer);
    }
}
