#include<iostream.h>
#include<fstream.h>
#include<apstring.h>

main()
{
	ifstream f_in;
   apstring joe;
	f_in.open("myfile.txt",ios::in);
	while(f_in >> joe)
	{
		cout << joe;
      cout << ' ';
	}
}
