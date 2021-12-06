// base code file

#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/ioctl.h>
#include <termios.h>

using namespace std;

void gotoxy(int x, int y)
{
    printf("%c[%d;%df", 0x1B, y, x);
}

int random(int r) // generates a random number between 0 and r inclusive
{
    return rand() % r + 1;
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

int main()
{
    //srand(time(NULL)); 
    // write code here
    //gotoxy(20,50);
    system("clear"); 
    cout<<"yeah we are starting c++";
    for(int x = 0; x < 10; x++) {
        gotoxy((x + 1) * 2, (x + 1));
        cout << "*";
    }
    char t = getch();
    cout << "You chose the character " << t << endl;
    return 1; // leave the following line in all programs
}


