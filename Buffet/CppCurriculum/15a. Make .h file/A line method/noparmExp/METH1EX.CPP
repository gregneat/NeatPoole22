// This file shows you how to make a method with no input parameters
// or return parameters.  You probably don't know what either of those
// are, so don't worry.
// There are 3 steps to making a method:
//		1) defining a prototype
//		2) defining the method itself
// 	3) using the method
// The method demostrated here write the message "Weekends are great" to
// the screen.

#include<iostream.h>
#include<conio.h>

// here is step 1)
// Note that we are outside of the main method.

void writeMessage();

main()
{
// here is step 3)
	writeMessage();
	cout << endl;
	writeMessage();
	cout << endl;
	writeMessage();
	cout << endl;
	cout << "hit a key and you will see alot more...." << endl;
	getch();
// the method could be put in a loop...

	for(int i=0;i< 90;i++)
	{
		writeMessage();
	}
}

// here is step 2)

void writeMessage()
{
	cout << "Weekends are Great";
}
