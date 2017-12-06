
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
import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class VocabularyCount
{
     /**
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String [] args) throws IOException 
    {
   
    final int CAPACITY = 100000;  // capacity of collection
    String fname = "src/vocabulary/ACM.txt";     // input file of text
    String word= null;                 // current word
    int numWords = 0;            // total number of words
    int uniqWords;               // number of unique words
    double density;              // vocabulary density
   
    //CollectionInterface<String> words = new ArrayCollection<String>(CAPACITY);
    Collection <String> words = new ArrayList<>();
    HashMap map = new HashMap(); 

    // Set up file reading
    FileReader fin = new FileReader(fname);
    Scanner wordsIn = new Scanner(fin);
    wordsIn.useDelimiter("[^a-zA-Z'']+");  // delimiters are nonletters,'
    
  
 
    while(wordsIn.hasNext())
    {
        word = wordsIn.next().toLowerCase();
        words.add(word); 
         
      if(map.containsKey(word))
      {
        // if we have already seen this word before
        // increment its count by one
        Integer freq = (Integer)map.get(word);
        map.put(word, freq + 1);
      } 
      else 
      {
        // we haven't seen this word, so add it with count of 1
        map.put(word, 1);
      }
    }
        
          ArrayList arraylist = new ArrayList(map.keySet());
          Collections.sort(arraylist);
           
    for (int ix = 0; ix < arraylist.size(); ix++) 
    {
      String key = (String)arraylist.get(ix);
      Integer count = (Integer)map.get(key);
      System.out.println("\t\t"+String.format("%-20s", key)+ count);
   
    }

    while (wordsIn.hasNext())      // while more words to process
    {
        
      word = wordsIn.next();          
      word = word.toLowerCase();
       
     
        words.add(word);
      numWords++;
        
    }

    density = (double)numWords/words.size();
    System.out.println("Analyzed file " + fname);
    System.out.println("\n\tTotal words:  " + numWords);
     
     
        
    if (words.size() == CAPACITY)
        
      System.out.println("\tUnique words: at least " + words.size());
  
    else
    {
       
      System.out.println("\tUnique words: " + words.size());
      System.out.printf("\n\tVocabulary density: %.2f", density);
      
    }

  
    }
   
   
}