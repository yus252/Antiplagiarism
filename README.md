To use WordCountListTester, run a line like:
java WordCountListTester nameOfInputFile.txt numberOfTopNWords {file|console} 
EX:> java WordCountListTester inputFiles_DoNotSubmit/harry_potter.txt 10 console
> java WordCountListTester inputFiles_DoNotSubmit/harry_potter.txt 10 file
Similarity Checker :
java Similarity odyssey_shortened.txt odyssey_original.txt


About WordCountList:
I have learned some information about this program from the discussion. However,
when I approached this program by myself, I found that it is much more
difficult. First, the program read the every word in the file that I choose. At
the same time, I need to check whether the file has next word or not. If it does
not have more word, then stop reading. Second, I add the first word to an array.
You can think of it as a line of boxes. You can store some stuff or some objects
in those boxes. When the line of boxes are not enough for you to store stuff.
You can add a new boxes at the end of the array. Here, you can image that every
word in the fiel is an object and I put word into the box of the array. At the 
beginning, I put the first word of the file into the first box of thearray. 
Then, I take next word out from the file. Since the lowercase of a word and an
upper case of a word is the same word, I change both the word from the file and
the word in the array into lowercase and then let the program compare them. The
program will hold the word from the file and then open every box of the array to
check whether they are equal or not. If they are same, then I increase the times
that the word appears. If the word from the file is not same as any word in the
boxes, I add a new box to the array and put this "new" word in that box. By
doing so, I can new that how many "kinds" of words have appear in the file and
how many times they have apprear in that file. 

When it comes to remove a given set of common words from my program, it becomes
much easier. All I need to do is just repeating the actions above and then open
the boxes one by one. When I found the word in the box belongs to common word,
such as "a" and "be", I delete that word. Now since I have delete one word, the
next word which is the (i+1)th word orginally becomes the ith word in the array,
I stil start from the ith box and then check one by one. Finally, I can get an
array without common words.

There is a special tool called PrintWriter. You can image it as a pen. Of
course, I cannot write on the paper just by myself. I need a pen. Thus, in the
third part of my program, I borrowed a tool PrinWriter to write what I have in
the boxes and how many words do I have in every box in the file.

The last part of my program is to find n words which appear most frequently in
the file. My method is arrange the value of times that every word appears and
then find the n largest value. Then, I hide those words by setting their count
to negative so you cannot find them. I delete those words which you can find and
in fact they do not apear frequently. After that, I take those hidden words out
and set their count back to positive. Now, you can know what are the n top words
who appear frequently and how many times they have appeared.

All the things above is just theory. To check whether I am right or not, I have
written a file called WordCountListTester.java. In this file, I have created a
very simple txt which contains 1 "hello", 2 "a", and 3"cs8b". Thus, I can easily
predict the right out put. I use the methods that I have described above to try
to find the right output and then compare the result that I get to the result
that I predict. If the real result is same as I predict result, then my way is
correct. On the contrary, it is false. By showing the result on the screen, if
there is something wrong, it is easier for me guess which part may have problem
and then I can immediately fix that. After using my own simple txt, I began to
use the long and complex txt provided by the proffessor and then compare my
result to the result provided. I think the simple txt I have written helped me a
lot because it hepls me to set the program step by step.
