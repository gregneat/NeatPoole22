void quickSort (int[] list, int first, int last)
{
  int g = first, h = last;

  int midIndex = (first + last) / 2;
  int dividingValue = list[midIndex];
  do
  {
    while (list[g] < dividingValue)
      g++;
    while (list[h] > dividingValue)
      h--;
    if (g <= h)
    {
      //swap(list[g], list[h]);
      int temp = list[g];
      list[g] = list[h];
      list[h] = temp;
      g++;
      h--;
    }
  }
  while (g < h);
  if (h > first)
    quickSort (list,first,h);
  if (g < last)
    quickSort (list,g,last);
}

