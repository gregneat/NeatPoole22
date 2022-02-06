class psvm {
        public static void main(String args[])
        {
			String[] a;
			String b;
			EasyReader e = new EasyReader("words.txt");
			int counter = 0;
			while(!e.eof()){
				b = e.readLine();
				counter++;
			}
			e.close();
			e = new EasyReader("words.txt");
			a = new String[counter];
			counter = 0;
			while(!e.eof()){
				a[counter] = e.readLine().toUpperCase();
				counter++;
			}
			Wordle joe = new Wordle(a);
			joe.play();
		}
}