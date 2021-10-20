#ifndef _GABY_H_
#define	_GABY_H_


#include <iostream>
#include <windows.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>
#include <sstream>
#include <fstream>

using namespace std;
void gotoxy(short x, short y) {
	COORD pos = {x, y};
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);
	}




void drawbox(int x, int y,int width, int height, char sym);
//This makes a filled box
void drawbox(int x, int y,int width, int height, char sym)
{
	for(int j=0;j<width;j++)
	{
		for(int i=0;i<height;i++)
		{
                gotoxy(x+j,y+i);
			cout<<sym;
		}
	}
}

void framedbox(int xcoord, int ycoord, int width, int height, char symbol);
//This makes a framed box
void framedbox(int xcoord, int ycoord, int width, int height, char symbol)
{
     for(int zz = 0; zz<height; zz++)
              {
                   for(int aa = 0; aa<width; aa++)
                   {
                           gotoxy(zz +xcoord, ycoord +aa);
                           cout<<symbol;
                   } 
              }
      for(int ff = 1; ff<height-1; ff++)
              {
                   for(int ss = 1; ss<width-1; ss++)
                   {
                           gotoxy(xcoord +ff, ycoord +ss);
                           cout<<' ';
                   }
                   }
}

void drawline(int length, int xcoord, int ycoord, char sym);
//This makes a line
void drawline(int length, int xcoord, int ycoord, char sym)
{
     for(int aa = 0; aa<length; aa++)
     {
             gotoxy(xcoord +aa, ycoord);
             cout<<sym;
             }
}
     
#endif


