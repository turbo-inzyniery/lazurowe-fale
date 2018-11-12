package pl.put.poznan.transformer.logic;

/**
 * Contains methods to capitalize and inverse string
 */
public class Functions {

    /**
     * Capitalizes text
     *
     * @param text text string to capitalize
     * @return text string after capitalize
     */
    public static String Capitalize(String text){
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

    /**
     * Inverses text
     *
     * @param text text string to inverse
     * @return text string after inverse
     */
    public static String inverse(String text){
        char[] char_array = text.toCharArray();
        boolean [] upper_signature;
        upper_signature = new boolean[text.length()];
        int i = 0;
        int text_length = text.length();
        text = "";

        for(i = 0; i < text_length; i++){
            if(Character.isUpperCase(char_array[i])){
                upper_signature[i] = true;
            }
            else{
                upper_signature[i] = false;
            }
        }

        for(i = i - 1 ; i >= 0; i--){
            if(upper_signature[text_length - (i + 1)]){
                text += Character.toUpperCase(char_array[i]);
            }
            else {
                text += Character.toLowerCase(char_array[i]);
            }
        }
        return text;
    }
}
