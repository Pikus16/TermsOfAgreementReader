/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termsofagreementreader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
/**
 *
 * @author benka
 */
public class HTMLReader {
    
    public static String getHTML(String url)
    {
        String result = "";
        try {
            URL currentURL = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(currentURL.openStream()));
            String inputLine;
            
            while ((inputLine = in.readLine()) != null)
            {
                result += inputLine + "\n";
            }
            in.close();
            
            
        }
        catch (MalformedURLException me){
            System.out.println("ERROR1");
        }
        catch (IOException me){
            System.out.println("ERROR");
        }
        return result;
    }
    
   public static ArrayList<ArrayList<Integer>> findRedFlag(String HTML)
    { 
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       
        HTML = HTML.toLowerCase();
        ArrayList<String> keywords = new ArrayList<String>();
        keywords.add("grant us");  
        keywords.add("$");
        keywords.add("may pay");
        keywords.add("collect");
        keywords.add("");
        for (String currentWord: keywords)
        {
             ArrayList<Integer> inner = new ArrayList<Integer>();
            if (HTML.contains(currentWord))
            {
                inner.add(HTML.indexOf(currentWord));
                inner.add(HTML.indexOf(currentWord) + currentWord.length());
                result.add(inner);
            }
            
        }
        return result;
    }
}
