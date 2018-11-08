package pl.put.poznan.transformer.logic;

import org.apache.tomcat.util.buf.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberToWord {

    private static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private static String toNum(String str){

        List<String> result = new ArrayList<String>();

        int pos=0;

         for(int x = 0; x<=str.length()-1; x++){

         pos = (str.length()-1) - x;
         char a = str.charAt(pos);

           switch(x){
               /* ******************* */
               case 3:

                   result.add("tysiąc");

                   break;
               /* ******************* */
               case 2:

                   switch(a){
                       case '1': result.add("sto") ; break;
                       case '2': result.add("dwieście") ; break;
                       case '3': result.add("trzysta") ; break;
                       case '4': result.add("czterysta") ; break;
                       case '5': result.add("pięćset") ; break;
                       case '6': result.add("sześćset") ; break;
                       case '7': result.add("siedemset") ; break;
                       case '8': result.add("osiemset") ; break;
                       case '9': result.add("dziewięćset") ; break;
                   }

                   break;
               /* ******************* */
               case 1:
                   switch(a){

                       case '2': result.add("dwadzieścia") ; break;
                       case '3': result.add("trzydzieści") ; break;
                       case '4': result.add("czterdzieści") ; break;
                       case '5': result.add("pięćdziesiąt") ; break;
                       case '6': result.add("sześćdziesiąt"); break;
                       case '7': result.add("siedemdziesiąt"); break;
                       case '8': result.add("osiemdziesiąt") ; break;
                       case '9': result.add("dziewięćdziesiąt") ; break;
                   }

                   break;
               /* ******************* */
               case 0:

                   if(str.length()!=1){

                       char b = str.charAt(pos-1);

                           if(b == '1'){
                               switch(a){
                                   case '0': result.add("dziesięć") ; break;
                                   case '1': result.add("jedenaście") ; break;
                                   case '2': result.add("dwanaście"); break;
                                   case '3': result.add("trzynaście") ; break;
                                   case '4': result.add("czternaście") ; break;
                                   case '5': result.add("piętnaście") ; break;
                                   case '6': result.add("szesnaście") ; break;
                                   case '7': result.add("siedemnaście") ; break;
                                   case '8': result.add("osiemnaście") ; break;
                                   case '9': result.add("dziewiętnaście") ; break;
                               }
                               x++;
                               break;
                           }
                   }

                   switch(a){
                           case '1': result.add("jeden"); break;
                           case '2': result.add("dwa") ; break;
                           case '3': result.add("trzy") ; break;
                           case '4': result.add("cztery") ; break;
                           case '5': result.add("pięć") ; break;
                           case '6': result.add("sześć") ; break;
                           case '7': result.add("siedem") ; break;
                           case '8': result.add("osiem") ; break;
                           case '9': result.add("dziewięć") ; break;
                   }

                   break;
               /* ******************* */
           }
        }

        Collections.reverse(result);
        return String.join(" ", result);
    }


    public static String transform(String text){

        /* find numbers */

        String[] parts = text.split(" ");

        text = "";

        for(int i = 0; i<=parts.length-1; i++){

            String[] subparts = parts[i].split("\\.");

            System.out.println(subparts.length);

            if (subparts.length == 2 && isNumeric(subparts[0]) && isNumeric(subparts[1])) {

                  boolean fl = false;

                  if(parts[i].charAt(parts[i].length()-1) == '.')
                  fl = true;

                  parts[i] = "";
                  parts[i]+=toNum(subparts[0]);
                  parts[i]+=" i ";
                  parts[i]+=toNum(subparts[1]);

                  if(fl == true)
                      parts[i]+='.';
            }
            if (isNumeric(parts[i])) {
                parts[i] = toNum(parts[i]);
            }

            if(i == parts.length-1) text += parts[i];
            else text += parts[i] + " ";
        }

    return text;
    }


}
