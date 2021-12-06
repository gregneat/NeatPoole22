// base code file

#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <termios.h>
#include "Gaby.h"

using namespace std;

// gotoxy, random, kbhit & getch are included in Gaby.h

int main()
{
    //srand(time(NULL)); 
    // write code here
    //gotoxy(20,50);
    system("clear"); 
    gotoxy(10,10);
    framedbox(12,12,5,8,'&');
    drawbox(2,2,4,8,'^');
    drawline(10,3,10,'$');
    cout<<"This works!";
    return 1; // leave the following line in all programs
}


