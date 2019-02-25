/*
 * File name: WordCounList.java
 * Created by: Yuling Shi, A15084246, cs8bwajd
 * Date: 01/16/2018
 * This program is used to count the number of words from a file. It can also
 * remove the commonly used words in a file and find the words which appear most
 * frequently in a file.
 * This class is based on WordCount class. It has member variables ArrayList of
 * WordCount objects.
 */

import java.util.*;
import java.io.*;

public class WordCountList {

   // The ArrayList to store the words and their associated counts
   ArrayList<WordCount> list;

   // construct the list
   public WordCountList() {
      list = new ArrayList<WordCount>();
   }

   public WordCountList(ArrayList<WordCount> list) {
      this.list = list;
   }

   /**This method will count what words are in the file and how many times they
    * have appeared in that file.
    * You can still use this method even through there is nothing in the file or
    * the file is null
    * @para filename the name of the file in which you want to coun the words
    */
   public void getWordsFromFile( String filename ) throws IOException {
      //short circuit protects null access
      if( filename == null || filename.length() == 0){
         System.out.println("Illigal filename");
         return;
      }
      //Create a scanner to read the file
      Scanner scanner = new Scanner(new File(filename));
      //Create an array to contain words in the file
      ArrayList<WordCount> wordList = new  ArrayList<>();
      //add the first word to the arraylist
      String word = "";
      if(scanner.hasNext()){
         word = scanner.next();
         WordCount newWord = new WordCount(word);
         wordList.add(newWord);
      }
      //caculate the word count
      while( scanner.hasNext()){
         word = scanner.next();
         //set the word to low case for comparing 
         int x = 0;
         for(int i = 0; i < wordList.size(); i++){
            WordCount wordCount = wordList.get(i);
            String wordInList = wordCount.getWord();
            if( word.equalsIgnoreCase(wordInList)){
               //inrease the word's count if it exists
               wordCount.increment();
               x = 1;
            }
         }
         if( x == 0){
            WordCount newWord = new WordCount(word);
            wordList.add(newWord);
         }
      }
      scanner.close();
      this.list = wordList;
   }


   // An accessor method for the tester file 
   public ArrayList<WordCount> getList(){
      return list;
   }

   /**This method will remove any commonly used words from
    * the list. 
    * @omitFilename the name of the file in which you want to delete the commonly
    *               used words
    */ 
   public void removeCommon( String omitFilename ) throws IOException {
      //short circuit protects null access
      if( omitFilename == null || omitFilename.length() == 0){
         System.out.println("Illigal filename");
         return;
      }
      //load the common words file
      Scanner scanner = new Scanner(new File(omitFilename));
      while(scanner.hasNext()){
         String commonWord = scanner.next();
         int i = 0;
         while( i < this.list.size()){
            WordCount wordCount = this.list.get(i);
            if(commonWord.equalsIgnoreCase(wordCount.getWord())){
               this.list.remove(wordCount);
            }else{
               i++;
            }
         }
      }
   }






   /**This method finds the top n occurring words in the list if the length of
    * the arraylist is bigger than n and returns the whole arraylist when the
    * length of the arraylist is less or equal to n
    * @para n the number of the words that appear most frequently
    * @return list the arraylist which contains n words that appear most
    *         frequently
    */         
   public ArrayList<WordCount> topNWords(int n) {
      ArrayList<WordCount> list = this.getList();
      ArrayList<WordCount> newList = new ArrayList<WordCount>();
      //check the size of the arraylsit
      //if it is smaller than n, directly return itself
      if(list.size() < n){
         return list;
      }
      //find the most top n words and set their count to negative
      for( int i = 0; i < n; i++){
         //keep track of the index of the top words
         int top = 0;     
         int max = 0;
         for( int j = 0; j < list.size(); j++){
            int count = list.get(j).getCount();
            if(count > max){
               max = count;
               top = j;
            }
         }
         int originalCount = list.get(top).getCount();
         list.get(top).setCount(-originalCount);
         WordCount topWord = new WordCount(list.get(top).getWord());
         topWord.setCount(originalCount);
         //add it to the list
         newList.add(topWord);
      }
      //reverse the change
      for(int i = 0; i < list.size(); i++){
         WordCount wc = list.get(i);
         if( wc.getCount()<0){
            wc.setCount(-wc.getCount());
         }
      }
      return newList;
   }

   /**This method takes the WordCounts and outputs the words and their
    * counts as a String.
    * @return s the string that has the words and their counts
    */ 

   public String toString(){
      String s = new String();
      //short circuit protects null access
      if( this.list == null || this.list.size() == 0){
         System.out.println("Its list is null");
         return null;
      }

      for( int i = 0; i < this.list.size(); i++){
         WordCount word = this.list.get(i);
         s = s + word.getWord()+"("+word.getCount()+")"+" ";
      }
      return s;
   }

   /**This method takes in an ArrayList of WordCounts and a boolean
    * printToFile. If printToFile is true, it output the arraylist of wordpair
    * with their counts to a file named myOutput.out . If printToFile is false,
    * it print the arraylist. 
    * @para printTofile the boolean type true or false
    */
   public void outputWords(boolean printToFile) throws IOException{
      //when printToFile is false, print the calling object
      if(printToFile == false){
         System.out.println(this.toString());
      }else{
         //wehn printToFIle is true, output to file "myOutput.out"
         File file = new File("myOutput.out");
         PrintWriter output = new PrintWriter(file);
         output.print(this.toString()+"\n");
         output.close();
      }
   }


}
