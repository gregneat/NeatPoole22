#include <iostream.h>
#include <fstream.h>

main()
{
	ofstream greg;
	char neat;
	int counter=0;
	greg.open("text.txt", ios::out);

	for(counter =0; counter < 1000; counter++)
	{
		greg << counter <<endl;
	}
}