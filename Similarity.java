/*
 * File name: Similarity
 * Created by: Yuling Shi, A15084246, cs8bwajd
 * Date: 01/26/2017
 * This program is used to determine how similar two texts are in order to check
 * plagiarism.
 * This class do not have any member variables, constructor, set() and get()
 * methods. Most of objects are based on the class WordCount.java and
 * WordCountList.java.
 */

import java.io.*;
import java.util.*;

public class Similarity{

    /**This method is a helper method for finMax. It find the bigger value of the
    * count of a wordCount object and another wordCount object in the
    * wordCountList
    * @para wc1 the wordCountobject we want to compare
    *       wcList the wordCountList we want to compare
    * @return an wordCountobject which has the same word as the inputed
    *         wordCount object's and has the bigger value of the count
    */

   public static WordCount findMaxOne( WordCount wc1, WordCountList wcList){
      String s1 = wc1.getWord();//the word contained in inputed wordCount
      int max = wc1.getCount();//the bigger value of the count
      ArrayList<WordCount> list = wcList.getList();
      for(int i = 0; i < list.size(); i++){
         WordCount wc2 = list.get(i);
         String s2 = wc2.getWord();//the word contained in the wordCountList
         //find the same word in the wordCountList
         if(s1.equalsIgnoreCase(s2)){
            int count2 = wc2.getCount();
            //compare the value and set max to the bigger one
            if( count2 > max ){
               max = count2;
            }
         }
      }
      WordCount newWord = new WordCount(s1);
      newWord.setCount(max);
      return newWord;
     }



   /**This method checks that whether the wordcountlist contians a certain word
    * or not. If not contain, then add it.
    * @para wc WordCount which we want to check whether it is contained in the
    *          wordcountlist
    *       wcList the wcList which we want to check whether it contains the
    *              wordcount or not
    * @return a wordcountlist which contains the wordcout now
    */
   public static WordCountList containAdd(WordCount wc, WordCountList wcList){
      int x = 0;
      String s1 = wc.getWord();
      ArrayList<WordCount> list = wcList.getList();
      for( int i = 0; i < list.size(); i++){
         String s2 = list.get(i).getWord();
         if(s2.equalsIgnoreCase(s1)){
            x = 1;
            }
      }
      if( x == 0){
         list.add(wc);
         }
      return wcList;
      }




   /**This method checks that whether the wordcountlist contians a certain word
    * or not.
    * @para wcList1   we want to check whether it is contained in the 
    *                 wordcountlist2
    *       wcList the wcList which we want to check whether it contains the
    *              wordcountlist1 or not
    * @return if contains, return true. Otherwise, return false.
    */
   public static boolean contain(WordCountList wcList1,
                                          WordCountList wcList2){
      int x = 0;
      ArrayList<WordCount> list1 = wcList1.getList();
      ArrayList<WordCount> list2 = wcList2.getList();
      for( int i = 0; i < list1.size(); i++){
         String s1 = list1.get(i).getWord();
         for( int j = 0; j < list2.size(); j++){
            String s2 = list2.get(j).getWord();
            if(s2.equalsIgnoreCase(s1)){
            x++;
            }
         }
      }
      //when every word can be found in b, return true
      if( x == list1.size()){
         return true;
         }
      return false;
      }


   
   /**This method should find the maximum value of occurrences of each word
    * @para a the file we want to compare
    *       b anther file to compare
    * @return a WordCountList which contains the words with maximum count
    */

   public static WordCountList findMax(WordCountList a, WordCountList b){
      //create a wordCountList to contain the words with maximum count
      WordCountList maxWCList = new WordCountList();
      ArrayList<WordCount> list = maxWCList.getList();
      ArrayList<WordCount> listA = a.getList();
      for( int i = 0; i < a.getList().size(); i++){
         WordCount wordCountA = listA.get(i);
         WordCount max = Similarity.findMaxOne(wordCountA,b);
         list.add(max);
      }
      ArrayList<WordCount> listB = b.getList();
      for( int i = 0; i < b.getList().size(); i++){
         WordCount wordCountB = listB.get(i);
         maxWCList  = Similarity.containAdd(wordCountB, maxWCList);
      }
      return maxWCList;
   }


   /**This method test the correctness of the output of method findMax
    */
   public static void testfindMax() throws IOException{
      WordCountList wc1 = new WordCountList();
      wc1.getWordsFromFile("SimilarityTest1.txt");
      WordCountList wc2 = new WordCountList();
      wc2.getWordsFromFile("SimilarityTest2.txt");
      WordCountList maxWCL = findMax(wc1,wc2);
      ArrayList<WordCount> list = maxWCL.getList();
      System.out.print(maxWCL.toString());
      if(list.get(0).getWord().equals("a")&&list.get(0).getCount()==3
         &&list.get(1).getWord().equals("b")&&list.get(1).getCount()==4
         &&list.get(2).getWord().equals("c")&&list.get(2).getCount()==5
         &&list.get(3).getWord().equals("e")&&list.get(3).getCount()==3){
         System.out.println("TEST FOR finMax PASSED!!!"+"\n");
      }else{
         System.out.println("TEST  FOR finMax FAILED!!!"+"\n");
         }
   }



   /**This method is a helper method for finMin. It find the smaller value of 
    * the count of a wordCount object and another wordCount object in the
    * wordCountList
    * @para wc1 the wordCountobject we want to compare
    *       wcList the wordCountList we want to compare
    * @return an wordCountobject which has the same word as the inputed
    *         wordCount object's and has the smaller value of the count
    */

   public static WordCount findMinOne( WordCount wc1, WordCountList wcList){
      String s1 = wc1.getWord();//the word contained in inputed wordCount
      int min = 0;
      int count1 = wc1.getCount();//the smaller value of the count
      ArrayList<WordCount> list = wcList.getList();
      for(int i = 0; i < list.size(); i++){
         WordCount wc2 = list.get(i);
         String s2 = wc2.getWord();//the word contained in the wordCountList
         //find the same word in the wordCountList
         if(s1.equalsIgnoreCase(s2)){
            int count2 = wc2.getCount();
            //compare the value and set min to smaller one
            if( count2 < count1 ){
               min = count2;
            }else{
               min = count1;
            }
         }
      }
      WordCount newWord = new WordCount(s1);
      newWord.setCount(min);
      return newWord;
   }


   /**This method should find the minimum value of occurrences of each word
    * @para a the file we want to compare
    *       b anther file to compare
    * @return a WordCountList which contains the words with minimum count
    */

   public static WordCountList findMin(WordCountList a, WordCountList b) 
                                           throws IOException{
      //create a wordCountList to contain the words with maximum count
      WordCountList minWCList = new WordCountList();
      ArrayList<WordCount> list = minWCList.getList();
      ArrayList<WordCount> listA = a.getList();
      for( int i = 0; i < a.getList().size(); i++){
         WordCount wordCountA = listA.get(i);
         WordCount min  = Similarity.findMinOne(wordCountA,b);
         list.add(min);
      }   
      return minWCList;
   }




   /**This method test the correctness of the output of method findMin
    */
   public static void testfindMin() throws IOException{
      WordCountList wc1 = new WordCountList();
      wc1.getWordsFromFile("SimilarityTest1.txt");
      WordCountList wc2 = new WordCountList();
      wc2.getWordsFromFile("SimilarityTest2.txt");
      WordCountList minWCL = findMin(wc1,wc2);
      ArrayList<WordCount> list = minWCL.getList();
      if(list.get(0).getWord().equals("a")&&list.get(0).getCount()==1
         &&list.get(1).getWord().equals("b")&&list.get(1).getCount()==2
         &&list.get(2).getWord().equals("c")&&list.get(2).getCount()==1
         &&list.get(3).getWord().equals("e")&&list.get(3).getCount()==0){
         System.out.println("TEST FOR finMin PASSED!!!"+"\n");
      }else{
         System.out.println("TEST  FOR finMin FAILED!!!"+"\n");
         }
    }



/**This method calcualte the sum of the counts of the wordCount objects in a
    * WordCounList
    * @para wcList the wordCountList we want to calculate
    * @return the sum of the counts
    */
   public static int sum(WordCountList wcList) throws IOException{
      int sum = 0;
      //get the arraylist of wordcounts
      ArrayList<WordCount> list = wcList.getList();
      for( int i = 0; i < list.size(); i++){
         WordCount wc = list.get(i);
         int count = wc.getCount();
         sum = sum + count;
      }
      return sum;
   }


   /**This method is used to find the percent similarity between two documents
    * by dividing the sum of all minimum counts by the sum of all maximum counts
    * and multiplying by 100
    * @para max the WordCountList containing maxmum counts
    *       min the WordCountList contianing minmum counts
    * @return the percentage of the similiarity bewtween files
    */

    public static double getSimilarity(WordCountList a, WordCountList b)
                                                     throws IOException{
       WordCountList minList = Similarity.findMin(a,b);
       WordCountList maxList = Similarity.findMax(a,b);
       double minSum = Similarity.sum(minList);
       double maxSum = Similarity.sum(maxList);
       if(maxSum == 0){
          System.out.println("The Nominator is 0");
          return -1;
       }
       double percentage = minSum/maxSum*100.0;
       return percentage;
   }


   /**This method will determine if every word in the calling object appears in
    * otherDocument, but in the same or a less quantity. 
    * @para a the file we want to compare
    *       b anther file to compare
    * @return if document A is a subset of document B, this will return True
    *         Otherwise it will return falso
    */
    public static boolean isStrictSubset(WordCountList a, WordCountList b){
       ArrayList<WordCount> list1 = a.getList();
       ArrayList<WordCount> list2 = b.getList();
       ArrayList<WordCount> newList =  new ArrayList<WordCount>();
       //Check whether every word in a is also in b
       boolean contain = Similarity.contain(a,b);
       //check the word count of every word in a is smaller than that of the 
       //word count in b
       boolean quantity = false;
       for( int i = 0; i < list2.size(); i++){
          WordCount wordCountB  = list2.get(i);
          WordCount newWC = Similarity.findMaxOne(wordCountB, a);
          newList.add(newWC);
       }
       //the order of words in same in maxlist and b
       //check whether the word counts in are smaller in b
       int x = 0; 
       for( int i = 0; i < list2.size(); i++){
          WordCount wordCountB = list2.get(i);
          int countB = wordCountB.getCount();
          int max = newList.get(i).getCount();
          //if the maximum word count is not belonged to b 
          //set the x = 1 which presents false
          if( countB != max){
             x = 1;
             }
          }

       if( x == 0 ){
         quantity = true;
       }
       //if every word in a is in b and word count of a is smaller than that of
       // b, then reuturn true. Otherwirse, turn false
       if( quantity == true && contain == true){
          System.out.println(
             "The first file is a subset of the second file!");
          return true;
       }else{
          System.out.println(
          "The first file isn't a subset of the second file!");
        }
        return false;
     }


   /** main method*/
   public static void main(String[] args) throws IOException{
    testfindMax();
    testfindMin();
    //test getSimilarity
    WordCountList wc1 = new WordCountList();
    wc1.getWordsFromFile("starwars.txt");
    wc1.removeCommon("commonWords.txt");
    WordCountList wc2 = new WordCountList();
    wc2.getWordsFromFile("harry_potter.txt");
    wc2.removeCommon("commonWords.txt");
    double similarity = Similarity.getSimilarity(wc1,wc2);
    System.out.println("The similarity is " + similarity);
    boolean subset = Similarity.isStrictSubset(wc1,wc2);
    System.out.println(subset);
   }





}//end of this class
