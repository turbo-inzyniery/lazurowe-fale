package pl.put.poznan.transformer.logic;

public class Unicode extends TransformerDecorator {
    public Unicode(Transformer transformer) { super(transformer); }

    @Override
    public String transform() {
        String text = super.transform();
        char[] splitedTextToChar = text.toCharArray();
        StringBuilder finalText = new StringBuilder();
        int unicodeSmile =  0x1f600;
        int unicodexD = 0x1f606;
        int unicodeKiss = 0x1F618;
        int unicodeP = 0x1F60B;
        int unicodeSad = 0x2639;
        int unicodeHeart = 0x2764;
        int unicodeLeftArrow = 0x2B05;
        int unicodeRightArrow = 0x27A1;
        for (int i = 0 ; i < splitedTextToChar.length ; i++){
            if(splitedTextToChar[i] == ':'){
                int j = i + 1;
                if(j < splitedTextToChar.length){
                    if(splitedTextToChar[j] == ')'){
                        finalText.append(Character.toChars(unicodeSmile));
                        i = j;
                    }
                    else if(splitedTextToChar[j] == '('){
                        finalText.append(Character.toChars(unicodeSad));
                        i = j;
                    }
                    else if(splitedTextToChar[j] == 'P') {
                        finalText.append(Character.toChars(unicodeP));
                        i = j;
                    }
                    else if(splitedTextToChar[j] == '*'){
                        finalText.append(Character.toChars(unicodeKiss));
                        i = j;
                    }
                    else{
                        finalText.append(splitedTextToChar[i]);
                    }
                }
                else{
                    finalText.append(splitedTextToChar[i]);
                }
            }
            else if(splitedTextToChar[i] == 'x'){
                int j = i + 1;
                if(j < splitedTextToChar.length){
                    if(splitedTextToChar[j] == 'D'){
                        finalText.append(Character.toChars(unicodexD));
                        i = j;
                    }
                    else {
                        finalText.append(splitedTextToChar[i]);
                    }
                }
                else {
                    finalText.append(splitedTextToChar[i]);
                }
            }
            else if(splitedTextToChar[i] == '<'){
                int j = i + 1;
                if(j < splitedTextToChar.length){
                    if(splitedTextToChar[j] == '3'){
                        finalText.append(Character.toChars(unicodeHeart));
                        i = j;
                    }
                    else if(splitedTextToChar[j] == '-'){
                        finalText.append(Character.toChars(unicodeLeftArrow));
                        i = j;
                    }
                    else{
                        finalText.append(splitedTextToChar[i]);
                    }
                }
                else {
                    finalText.append(splitedTextToChar[i]);
                }
            }
            else if(splitedTextToChar[i] == '-'){
                int j = i + 1;
                if(j < splitedTextToChar.length){
                    if(splitedTextToChar[j] == '>'){
                        finalText.append(Character.toChars(unicodeRightArrow));
                        i = j;
                    }
                    else {
                        finalText.append(splitedTextToChar[i]);
                    }
                }
                else {
                    finalText.append(splitedTextToChar[i]);
                }
            }
            else{
                finalText.append(splitedTextToChar[i]);
            }
        }
        return finalText.toString();
    }
}
