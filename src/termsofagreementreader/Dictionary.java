/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termsofagreementreader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author benka
 */
public class Dictionary {
    
    public static boolean check(String word, String name) {
        word = word.toLowerCase();
        name = name.toLowerCase();
        if (word.indexOf(name) != -1)
            return true;
        if (word.equals("ol") || word.equals("li") || word.equals("br") )
            return false;
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    "/usr/share/dict/american-english"));
            String str;
            while ((str = in.readLine()) != null) {
                if (word.indexOf(".") != -1 || word.indexOf(",") != -1 || word.indexOf(";") != -1 || word.indexOf(":") != -1)
                {
                   
                        word = word.substring(0,word.length()-1);
                        
                                }
                
                
                if (str.indexOf(word) != -1 ) {
                    return true;
                }
            }
            in.close();
        } catch (IOException e) {
        }
        
        
        return false;
    }

     public static void main(String[] args)
     {
         System.out.println(check("href","la"));
     }
}
