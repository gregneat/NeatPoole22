// This file shows you how to make a method with an input parameter.
// This allows the user of the method to set a value that
// will affect what the method does.
// This method will let the user pick how many times the message is
// written to the screen.

#include<iostream.h>
#include<conio.h>

void writeMessageAgain(int);

main()
{
// If we want to see the message 5 times we make this call..
	 writeMessageAgain(5);
// If we want to see the message 1000 times we make this call..
	 cout << "Hit any key to continue";
	 cout << endl;
	 getch();
	 writeMessageAgain(1000);
}

void writeMessageAgain(int val)
{
	for(int i=0;i < val; i++)
	{
		cout << "Weekends are Great";
	}
}
