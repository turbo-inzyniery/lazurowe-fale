package pl.put.poznan.transformer.logic;

import java.lang.reflect.Array;

public class PokemonTransformer extends TransformerDecorator {
    public PokemonTransformer(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform() {
        String text = super.transform();
        String[] words = text.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word:
             words) {
            char[] chars = word.toCharArray();
            boolean upper = Character.isUpperCase(chars[0]);

            for (char character:
                 chars) {
                switch (character){
                    case 'a':
                    case 'A':
                        stringBuilder.append("4");
                        break;
                    case 's':
                    case 'S':
                        stringBuilder.append("$");
                        break;
                    case 'e':
                    case 'E':
                        stringBuilder.append("3");
                        break;
                    case 'i':
                    case 'I':
                        stringBuilder.append("!");
                        break;
                    case 'o':
                    case 'O':
                        stringBuilder.append("0");
                        break;
                    case 'z':
                    case 'Z':
                        stringBuilder.append("2");
                        break;
                    default:
                        if(upper){
                            stringBuilder.append(Character.toUpperCase(character));
                        } else {
                            stringBuilder.append(Character.toLowerCase(character));
                        }
                }
                upper = !upper;
            }
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
