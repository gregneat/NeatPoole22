#include <iostream>
#include <windows.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>
#include <sstream>
#include <fstream>
using namespace std;
void gotoxy(short x, short y) 
{
	COORD pos = {x, y};
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);
}
int random(int r)
{
    return rand()% r + 1;
}  
// This program reads the contents of the file text.txt
// and writes them to the screen, char by char.

int main()
{
	ifstream f("text.txt");
	char neat;
	
	while(f >> neat)
	{
		cout << neat<<endl;
	}

}
