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
            System.out.println("ERROR");
        }
        catch (IOException me){
            System.out.println("ERROR");
        }
        return result;
    }
}
