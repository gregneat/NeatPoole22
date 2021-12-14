// Made by Kirk Luther 12/15/2016

#include <iostream>
#include <windows.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>
#include <sstream>
#include <fstream>
#include <cstdlib>
#include <ctime>
using namespace std;

void gotoxy(short x, short y) {
	COORD pos = {x, y};
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);
}

class FilledBox {
	public:
  int 
    w,h, // width and height
    x,y; // coordinates

  char
    frame;

  FilledBox (int wa, int ha, char framea) 
  {
    w = wa;
    h = ha;
    frame = framea;
  }

  void gotoxy(int x, int y) 
  {
	COORD pos = {x, y};
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);
	}
  
  void draw(int x, int y)
  {
    gotoxy(x,y);
    for (int kl = 0; kl < h; kl++)
    {
    	for (int kjl = 0; kjl < w; kjl++)
    	{
    		cout << frame;
		}
		gotoxy(x,y+kl);
	}
    gotoxy(x,y+h);
  }
};

class FilledTriangle
{
		public:
  int 
    w,h, // width and height
    x,y; // coordinates

  char
    frame;

  FilledTriangle (int sa, char framea) 
  {
    w = sa;
    frame = framea;
  }

  void gotoxy(int x, int y) 
  {
	COORD pos = {x, y};
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);
	}
  
  void draw(int x, int y)
  {
    int s = w;
    int k;
    for (int j = 0; j < w; j++)
    {
    	for(int i = 0; i < s; i++)
	    {
	    	gotoxy(x+i+j+j,y-i);
	    	cout << frame;
		}
		s -= 1;
	}
	s = w-1;
	for (int j = 0; j < w; j++)
    {
    	for(int i = 0; i < s; i++)
	    {
	    	gotoxy(x+i+j+j+1,y-i);
	    	cout << frame;
		}
		s -= 1;
	}
  }
};

void SetColor(int value){
    SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE),  value);
}

void ctree(int x,int y)
{
	SetColor(2);
	FilledTriangle base(8,'*');
	FilledTriangle base1(7,'*');
	FilledTriangle base2(6,'*');
	base2.draw(x+2,y-6);
	base1.draw(x+1,y-3);
	base.draw(x,y);
	SetColor(4);
	FilledBox tree(3,5,'*');
	tree.draw(x+6,y+1);
	SetColor(7);
}

void cltree(int x, int y)
{
	SetColor(2);
	FilledTriangle lbase(8,'*');
	FilledTriangle lbase1(7,'*');
	FilledTriangle lbase2(6,'*');
	lbase2.draw(x+2,y-6);
	lbase1.draw(x+1,y-3);
	lbase.draw(x,y);
	SetColor(4);
	FilledBox ltree(3,5,'*');
	ltree.draw(x+6,y+1);
	int lights [3] = {10,11,12};
	int m = rand()% 3;
	int n, o;
	if (m == 0)
	{
		n = 1;
		o = 2;
	}
	if (m == 1)
	{
		n = 2;
		o = 0;
	}
	if (m == 2)
	{
		n = 0;
		o = 1;
	}
	
	SetColor(lights [m]);
	gotoxy(x+2, y-1);
	cout << "*";
	SetColor(lights [n]);
	gotoxy(x+5, y-2);
	cout << "*";
	SetColor(lights [o]);
	gotoxy(x+8, y-3);
	cout << "*";
	SetColor(lights [m]);
	gotoxy(x+11, y-4);
	cout << "*";
	SetColor(lights [n]);
	gotoxy(x+3, y-4);
	cout << "*";
	SetColor(lights [o]);
	gotoxy(x+6, y-5);
	cout << "*";
	SetColor(lights [m]);
	gotoxy(x+9, y-6);
	cout << "*";
	SetColor(lights [n]);
	gotoxy(x+4, y-7);
	cout << "*";
	SetColor(lights [o]);
	gotoxy(x+6, y-8);
	cout << "*";
	SetColor(lights [m]);
	gotoxy(x+8, y-9);
	cout << "*";
	SetColor(14);
	gotoxy(x+7, y-12);
	cout << "*";
	SetColor(7);
}

void present(int x, int y)
{
	SetColor(12);
	gotoxy(x,y);
	cout << "*";
	gotoxy(x+2,y);
	cout << "*";
	gotoxy(x,y+2);
	cout << "*";
	gotoxy(x+2,y+2);
	cout << "*";
	gotoxy(x+2,y+2);
	SetColor(7);
	gotoxy(x+1,y);
	cout << "*";
	gotoxy(x,y+1);
	cout << "*";
	gotoxy(x+1,y+1);
	cout << "*";
	gotoxy(x+1,y+2);
	cout << "*";
	gotoxy(x+2,y+1);
	cout << "*";
	SetColor(7);
}

void Sleigh (int x, int y)
{
	SetColor(7);
	gotoxy(x,y);
	cout << " ************ ";
	gotoxy(x,y-1);
	cout << " *  ** **   * ";
	gotoxy(x,y-2);
	cout << "    ** **     ";
	SetColor(12);
	gotoxy(x,y-3);
	cout << "  **********  ";
	gotoxy(x,y-4);
	cout << " ************ ";
	gotoxy(x,y-5);
	cout << " ****     *** ";
	gotoxy(x,y-6);
	cout << " ***    * *** ";
	gotoxy(x,y-7);
	cout << " ***    ***** ";
	gotoxy(x,y-8);
	cout << " ***     ***  ";
	gotoxy(x,y-9);
	cout << " ***          ";
	gotoxy(x,y-10);
	cout << " **";
	
}
