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
import java.util.ArrayList;;
/**
 *
 * @author benka
 */
public class HTMLReader {
    public String name;
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
    
    public static String removeTags(String HTML, String name)
    {
        
       //HTML = HTML.replaceAll(">"," ");
         //HTML = HTML.replaceAll("<"," ");
         //HTML = HTML.replaceAll("ol"," ");
          //HTML = HTML.replaceAll("li"," ");
        //String zero = HTML.replaceAll("<", " ");
        //String first = zero.replaceAll("<.*?>", " ");
       // String second = zero.replaceAll("&quot","\"");
        
        //String third = second.replaceAll("\\<.*?>"," ");
        
          HTML = HTML.replaceAll("<a"," ");
         HTML = HTML.replaceAll(">"," ");
         HTML = HTML.replaceAll("<"," ");
        String[] finalOne = HTML.split(" "); 
        String result = "";
        for (int i = 0; i < finalOne.length; i++)
        {
            if (!(Dictionary.check(finalOne[i], name)))
                finalOne[i] = "";
            result += finalOne[i] + " ";
            if (result.length() > 1 && result.substring(result.length()-2).equals(" ."))
                result+= " ";
        }
        //System.out.println("Removed Tags: " + result);
        
       
        return result;
    }
     
    
    
    
   public static ArrayList<String> findRedFlag(String HTML, String name)
    {   
        
        ArrayList<String> result = new ArrayList<String>();
        HTML = removeTags(HTML, name);
        HTML = HTML.toLowerCase();
        ArrayList<String> keywords = new ArrayList<String>();
        keywords.add("grant us");  
        keywords.add("give us"); 
        keywords.add("give " + name);
        keywords.add("grant " + name);
        keywords.add("allow us"); 
        keywords.add("allow " + name);
        keywords.add("credit card"); 
        keywords.add("social security");
        keywords.add("location"); 
        keywords.add("contact");
        keywords.add("information");
        keywords.add("pay");
        keywords.add("collect");
        keywords.add("intellectual property");
        
        
        
        for (String currentWord: keywords)
        {
            
            if (HTML.contains(currentWord))
            {
                 int start, end;
                start = HTML.indexOf(currentWord);
                end = (HTML.indexOf(currentWord) + currentWord.length());
                int i = 0;
                boolean notTags = true;
                String current = HTML.substring(start,end);
                try{
                while (notTags)
                {
                    String letter = HTML.substring(start-1,start);
                    String letterTwo = HTML.substring(start-2,start);
                    if(letter.equals(">") || letter.equals("<") || letter.equals("."))
                    {
                            break;      
                    }
                     // if (letterTwo.equals("ol") || letterTwo.equals("li") || letterTwo.equals("br") )
                    //{
                      //  break;
                    //}
                     
                    else
                    
                    {     current = letter+current;
                        start--;
                     //System.out.println(current);
                    }
                }
                
               // System.out.println();
                }
            catch(Exception e){}
                notTags = true;
                i = 0;
                while (notTags)
                {
                    String letter = HTML.substring(end,end+1);
                    String letterTwo = HTML.substring(end,end+2);
                    if (letter.equals(".") || letter.equals("  "))
                    {
                           break;      
                    }
                    else if (letterTwo.equals("ol") || letterTwo.equals("li") || letterTwo.equals("br") )
                    {
                        break;
                    }
                  else
                    {
                        current = current + letter;
                        end++;
                    }       
                    // System.out.println(current);
                    
                }
                try{
                    boolean matches =false;
                    for (String a: result)
                    {
                        if (current.substring(0,10).equals(a.substring(0,10)))
                            matches = true;
                    }
                    if (!matches)
                        result.add(current);
                }
                catch (Exception e){result.add(current);}
                
            
            }
        }
        
        
        return result;
    }
}

