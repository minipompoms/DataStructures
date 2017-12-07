
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocabulary;
/**
 *
 * @author Paige Kohn
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Paige
 */
public class VocabularyCount
{
     /**
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String [] args) throws IOException 
    {
   
  
    String fname = "src/vocabulary/ACM.txt";     // input file of text
    String word= null;                           // current word
 
   
    FileReader fin = new FileReader(fname);      // Set up file reading
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