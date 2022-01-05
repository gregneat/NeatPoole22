# example code to help read from a file

#Call me
from random import *
##from graphics import *
##window = GraphWin("Canvas",250,250);

    
words=0
mobydick=[]
ishmael = open('test.txt','r')
# w is an array with each element being one line of the text file
w = ishmael.readlines()
# el is each element of w (each line of the file)
for el in w:
   print("line: ",el)
# word is each word in each el
# el.split() is an array of words from each line of text file
   for word in el.split():
       print("word: ",word)
# z is each letter in each word
       for z in word:
            print("letter:",z)


            
##for line in ishmael:
##    print(line)
##    for word in line.split():
##        mobydick.append(word)
##        words=words+1
##x=randint(0,words-1)
##print(words)
##print(mobydick[x])

##window.getMouse()




