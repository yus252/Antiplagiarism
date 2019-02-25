/*
 * File name: WordCountListTester
 * Created by: Yuling Shi, A15084246, cs8bwajd
 * Date: 01/26/2017
 * This program is used to test the methods in WordCountList.java.
 * The WordCountListerTester class does not contain member variables,
 * constructors,get() and set() methods. It contains few  methods used to
 * test the methods in WordCountList class. Thus, this class is specific. It may
 * not be used to test methods in other class.
 */


import java.io.*;
import java.util.*;

public class WordCountListTester {

    /** Methods: */

    /* main method
        NOTE: If you plan on throw Exceptions, you need to change "IOException" 
        to "Exception"
        IOExceptions are a specific set of Exceptions.
        */
    public static void main(String[] args) throws IOException {
        WordCountListTester wct = new WordCountListTester();


        //This tester uses the command line. That's why the args are passed to 
        //the method

        wct.providedTester(args);


        /** Unit Test Call */
        testA1();
        testA2();
        testB1();
        testB2();
        testC1();
        testC2();
        testD1(); 
        testD2();
        testD3();
        

 
    } // End Main Method

    /** This method tests the correctness of getWordFromFile method's output 
     * in WordCountList.java.The txt here is "hello hello hello a a a cs8b cs8b
     * cs8b"
     */ 
    public static void testA1() throws IOException{
       WordCountList wcList = new WordCountList();
       wcList.getWordsFromFile("tester.txt");
       //get words in the list
       ArrayList<WordCount> list = wcList.getList();
       String word1 = list.get(0).getWord();
       String word2 = list.get(1).getWord();
       String word3 = list.get(2).getWord();
       String word4 = list.get(3).getWord();
       System.out.println(list.toString());
       if(word1.equals("cs8b")&&list.get(0).getCount()==3
          &&word2.equals("a")&&list.get(1).getCount()==2
          &&word3.equals("hello")&&list.get(2).getCount()==1
          &&word4.equals("Paul")&&list.get(3).getCount()==4){
          System.out.println("TEST 1 FOR A PASSED!!!"+"\n");
       }else{
          System.out.println("TEST 1 FOR A FAILED!!!"+"\n");
          }
      }


      /**This method tests the NullPointException of getWordFromFile method in
       * WordCountList.java.
       */
      public static void testA2() throws IOException{
       WordCountList wcList = new WordCountList();
       wcList.getWordsFromFile("");
       ArrayList<WordCount> list = wcList.getList();
       System.out.println(list.toString());
       if(list.size() == 0){
          System.out.println("TEST 2 FOR A PASSED!!!"+"\n");
       }else{
          System.out.println("TEST 2  FOR A FAILED!!!"+"\n");
          }
      }


    /**This method tests the correctness of removeCommon method's output
     * in WordCountList.java
     */
    public static void testB1() throws IOException{
       WordCountList wcList= new WordCountList();
       wcList.getWordsFromFile("tester.txt");
       wcList.removeCommon("commonWords.txt");
       ArrayList<WordCount> list = wcList.getList();
       String word1 = list.get(0).getWord();
       String word2 = list.get(1).getWord();
       System.out.println(list.toString());
       if(word1.equals("cs8b")&&list.get(0).getCount()==3
          &&word2.equals("Paul")&&list.get(1).getCount()==4){
          System.out.println("TEST 1 FOR B PASSED!!!"+"\n");
       }else{
          System.out.println("TEST 1 FOR B FAILED!!!"+"\n");
          }
       }
   

      /**This method tests the NullPointException of method removeCommon in
       * WordCountList.java.
       */
      public static void testB2() throws IOException{
       WordCountList wcList = new WordCountList();
       wcList.getWordsFromFile("tester.txt");
       wcList.removeCommon("");
        ArrayList<WordCount> list = wcList.getList();
       String word1 = list.get(0).getWord();
       String word2 = list.get(1).getWord();
       String word3 = list.get(2).getWord();
       String word4 = list.get(3).getWord();
       System.out.println(list.toString());
       if(word1.equals("cs8b")&&list.get(0).getCount()==3
          &&word2.equals("a")&&list.get(1).getCount()==2
          &&word3.equals("hello")&&list.get(2).getCount()==1
          &&word4.equals("Paul")&&list.get(3).getCount()==4){
          System.out.println("TEST 2 FOR B PASSED!!!"+"\n");
       }else{
          System.out.println("TEST 2  FOR B FAILED!!!"+"\n");
          }
      }


    /**
     * This method tests the correctness of toString method's output 
     * in class WordCountList
     */ 
    public static void testC1() throws IOException{
       WordCountList wcList = new WordCountList();
       wcList.getWordsFromFile("tester.txt");
       System.out.println(wcList.toString());
       if(wcList.toString().equals("cs8b(3) a(2) hello(1) Paul(4) ")){
          System.out.println("TEST 1 FOR C PASSED!!!"+"\n");
       }else{
          System.out.println("TEST 1 FOR C FAILED!!!"+"\n");
          }
       }

      /**This method tests the NullPointException of method removeCommon in
       * WordCountList.java.
       */
      public static void testC2() throws IOException{
       WordCountList wcList = new WordCountList();
       ArrayList<WordCount> list = wcList.getList();
       System.out.println(list.toString());
       if(list.size() == 0){
          System.out.println("TEST 2 FOR C PASSED!!!"+"\n");
       }else{
          System.out.println("TEST 2  FOR C FAILED!!!"+"\n");
          }
      }



    /**
     * This method tests the correctness of topNWords method's output
     * in file WordCountList.java
     */
    public static void testD1() throws IOException{
       WordCountList wcList = new WordCountList();
       wcList.getWordsFromFile("tester.txt");
       ArrayList<WordCount> list = wcList.getList();
       list = wcList.topNWords(2);
       System.out.println(list.toString());
       if(list.get(0).getWord().equals("Paul")&&list.get(0).getCount()==4
          &&list.get(1).getWord().equals("cs8b")&&list.get(1).getCount()==3){
        System.out.println("TEST 1 FOR D PASSED!!!"+"\n");
     }else{
        System.out.println("TEST 1 FOR D FAILED!!!"+"\n");        
        }
     }

    /**
     * This method tests the edge case of topNWords method's output
     * in file WordCountList.java when n is bigger than the length of arraylist
     */
    public static void testD2() throws IOException{
       WordCountList wcList = new WordCountList();
       wcList.getWordsFromFile("tester.txt");
       ArrayList<WordCount> list = wcList.getList();
       list = wcList.topNWords(4);
       System.out.println(list.toString());
       if(list.get(0).getWord().equals("Paul")&&list.get(0).getCount()==4
          && list.get(1).getWord().equals("cs8b")&&list.get(1).getCount()==3
          &&list.get(2).getWord().equals("a")&&list.get(2).getCount()==2
          &&list.get(3).getWord().equals("hello")&&list.get(3).getCount()==1){
        System.out.println("TEST 2 FOR D PASSED!!!"+"\n");
     }else{
        System.out.println("TEST 2 FOR D FAILED!!!"+"\n");        
        }
     }
  
    /**
     * This method tests the correctness of topNWords method's output
     * in file WordCountList.java
     */
    public static void testD3() throws IOException{
       WordCountList wcList = new WordCountList();
       wcList.getWordsFromFile("harry_potter.txt");
       wcList.removeCommon("commonWords.txt");
       ArrayList<WordCount> list = wcList.getList();
       list = wcList.topNWords(3);
       System.out.println(list.toString());
        if(list.get(0).getWord().equals("Dursley")&&list.get(0).getCount()==37
          && list.get(1).getWord().equals("Mr.")&&list.get(1).getCount()==29
          &&list.get(2).getWord().equals("Mrs.")&&list.get(2).getCount()==19){
        System.out.println("TEST 3 FOR D PASSED!!!"+"\n");
     }else{
        System.out.println("TEST 3 FOR D FAILED!!!"+"\n");        
        }
     }







    /** Write more unit tests above this provided tester */ 
    public static void providedTester(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println(
                   "Skipping provided tester because no arguments were given!");
            return;
        }
        
        // Command line usage:
        // java WordCloudTester nameOfInputFile.txt numberOfTopNWords 
        // {console|file} {length|char} {value}

        // init the word clound
        WordCountList w = new WordCountList();
        System.out.println("Reading in File: " + args[0]); 
        w.getWordsFromFile(args[0]);

        System.out.println("Removing common words");
        w.removeCommon("inputFiles_DoNotSubmit/commonWords.txt");

        // get the input number of words you want
        int numberOfTopNWords = Integer.parseInt(args[1]);
        
        // condition ? a : b => if (condition == true) then a else b
        // parse the second argument to check if it is printToFile or not
        boolean printToFile = args[2].charAt(0) == 'f' ? true : false;
        // parse the third argument to check if it is filter by lengh or not
        
        System.out.println("Printing the top " + numberOfTopNWords + " words " 
                            + (printToFile == true ?
                          " in file a named myOutput.out" : " on console"));
        
        
        WordCountList w2 = new WordCountList(w.topNWords(numberOfTopNWords));
        w2.outputWords(printToFile);

    }
}
