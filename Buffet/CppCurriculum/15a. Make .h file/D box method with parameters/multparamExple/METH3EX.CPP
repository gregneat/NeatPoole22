// This file shows you how to make a method with multiple input
// parameters (two in this case).

#include<iostream.h>
#include<conio.h>

void writeMessageAgainAgain(int,char);

main()
{
		writeMessageAgainAgain(3,'$');
		writeMessageAgainAgain(5, '%');
		writeMessageAgainAgain(3, '&');
      writeMessageAgainAgain(5, '+');
}


void writeMessageAgainAgain(int num, char sym)
{
	for(int i =0; i < num; i++)
	{
		cout << sym << "  Weekends are Great  " << sym << endl;
	}
}
