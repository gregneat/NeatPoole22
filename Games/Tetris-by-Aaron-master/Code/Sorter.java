
public class Sorter{
	private static int getMax(int arr[])
	{
		int mx = arr[0];
		for(int i = 1; i<arr.length; i++)
		{
			if(arr[i]>mx)
				mx = arr[i];
		}
		return mx;
	}
	private static void countSort(int arr[], String[] strings, int exp)
	{
		int[] output = new int[arr.length];
		String[] outputStrings = new String[strings.length];
		int i;
		int[] count = new int[10];
	 
		for (i = 0; i < arr.length; i++)
			count[(arr[i] / exp) % 10]++;
	 
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
	 
		for (i = arr.length - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			outputStrings[count[(arr[i] / exp) % 10] - 1] = strings[i];
			count[(arr[i] / exp) % 10]--;
		}
	 
		for (i = 0; i < arr.length; i++)
			arr[i] = output[i];
		for (i = 0; i < strings.length; i++)
			strings[i] = outputStrings[i];
	}
	public static void radixsort(int arr[], String strings[])
	{
		int m = getMax(arr);
	 
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, strings, exp);
	}
}