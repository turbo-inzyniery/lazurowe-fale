package pl.put.poznan.transformer.logic;

public class Functions {
    public static String Capitalize(String text){
        String[] string_tab= text.split(" ");
        text = "";
        System.out.println(string_tab);
        for(String text_fragment : string_tab){
            if (text_fragment.length() > 0) {
                text_fragment = text_fragment.substring(0, 1).toUpperCase() + text_fragment.substring(1);
                text += text_fragment + " ";
                System.out.println(text);
            }
        }
        return text;
    }
}
