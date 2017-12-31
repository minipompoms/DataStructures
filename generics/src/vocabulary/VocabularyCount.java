
package vocabulary;
/**
 *
 * @author pkohn
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VocabularyCount
{
     /**
     *
     * @param args
     */
    public static void main(String [] args) 
    {
   
  
    String fname = args[0];     // input file of text
    String word;                // current word
 
   
    FileReader fin = null;
        try {
            fin = new FileReader(fname); // Set up file reading
        } catch (FileNotFoundException ex) {
            System.out.println("Exception: file not found " + ex);
        }
    Scanner wordsIn = new Scanner(fin);
    wordsIn.useDelimiter("[^a-zA-Z'']+");        // delimiters are nonletters
    
    Collection <String> words = new ArrayList<>();   //list containing words
    HashMap map = new HashMap();                     //used to count frequency
 
    while(wordsIn.hasNext())                         //read words from file
    {
        word = wordsIn.next().toLowerCase();        
        words.add(word);                             // add words to list
         
        if(map.containsKey(word))                    // if file contains word
        {
            Integer freq = (Integer)map.get(word);   //freq will hold count
            map.put(word, freq + 1);                 // increment the frequency count 
        } 
        else            //if word has not been added yet
        {       
            map.put(word, 1);  //add, & frequency is 1
        }
    }
        
   
    ArrayList list = new ArrayList(map.keySet());  //arraylist with map holding the frequency
 
    Collections.sort(list); 
           
    for (int ix = 0; ix < list.size(); ix++)      //loop iterates and prints word occurrances 
    {
        String key = (String)list.get(ix);
        Integer count = (Integer)map.get(key);
        System.out.println("\t\t"+String.format("%-20s", key)+ count);
   
    }

  } 
}