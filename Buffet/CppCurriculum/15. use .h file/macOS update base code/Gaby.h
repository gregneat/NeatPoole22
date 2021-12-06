
#ifndef _GABY_H_
#define	_GABY_H_


#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sstream>
#include <fstream>
#include <sys/ioctl.h>
#include <termios.h>

using namespace std;
void gotoxy(int x, int y)
{
    printf("%c[%d;%df", 0x1B, y, x);
}

int kbhit()
{
    termios term;
    tcgetattr(0, &term);

    termios term2 = term;
    term2.c_lflag &= ~ICANON;
    tcsetattr(0, TCSANOW, &term2);

    int byteswaiting;
    ioctl(0, FIONREAD, &byteswaiting);

    tcsetattr(0, TCSANOW, &term);

    return byteswaiting;
}

char getch(void) {
    char buf = 0;
    struct termios old = {0};
    fflush(stdout);
    if(tcgetattr(0, &old) < 0)
        perror("tcsetattr()");
    old.c_lflag &= ~ICANON;
    old.c_lflag &= ~ECHO;
    old.c_cc[VMIN] = 1;
    old.c_cc[VTIME] = 0;
    if(tcsetattr(0, TCSANOW, &old) < 0)
        perror("tcsetattr ICANON");
    if(read(0, &buf, 1) < 0)
        perror("read()");
    old.c_lflag |= ICANON;
    old.c_lflag |= ECHO;
    if(tcsetattr(0, TCSADRAIN, &old) < 0)
        perror("tcsetattr ~ICANON");
    // printf("%c\n", buf);
    return buf;
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
int random(int r)
{
    return rand()% r + 1;
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


