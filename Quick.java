import java.util.*;
public class Quick{
  private static void swapper(int[] data, int A, int B) {
    int t = data[A];
    data[A] = data[B];
    data[B] = t;
  }
  public static int partition (int [] data, int start, int end) {
    int s = start;
    int e = end;
    int index = (int)(Math.random() * (end - start + 1) + start);
    swapper(data, index, s);
    start++;
    while (start != end) {
      if (data[start] > data[s]) {
        swapper(data, start, end);
        end--;
      }
      else {
        start++;
      }
    }
    if (data[start] < data[s]) {
      swapper(data, start, s);
      return start;
    }
    else {
      swapper(data, start -1, s);
      return start-1;
    }
  }
  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the index element.
 *3. all elements in range that are smaller than the index element are placed before the index element.
 *4. all elements in range that are larger than the index element are placed after the index element.
 *@return the index of the final position of the index element.
 */
  /*
  return the value that is the kth smallest value of the array. k=0 is the smallest
 */
 public static int quickselect(int[] data, int k) {
   int piv0;
   System.out.println(Arrays.toString(data));
   System.out.println("find the " + k + " smallest element");
   piv0 = partition(data, 0, data.length -1); //partition once;
   while (k != piv0) {
     if (k < piv0) piv0 = partition(data, 0, piv0); //k is between 0 and piv0
     else piv0 = partition(data, piv0, data.length -1);
   }
   return data[k]; //eventually as the looping continues, we will get a smaller range till eventually just 1 left.
 }

 /*
 Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data) {}

 public static void main(String[] args) {
   int[] array = new int[] {0,999,999,999,4,1,0,3,2,999,999,999};
     for (int i = 0; i < array.length; i++){
       System.out.println("term " + i + ": "+ quickselect(array, i));
     }
 int[] ary = new int[] { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23
  System.out.println(quickselect( ary , 0 )); //would return 0
  System.out.println(quickselect( ary , 1 )); // would return 2
  System.out.println(quickselect( ary , 2 )); // would return 5
  System.out.println(quickselect( ary , 3 )); // would return 10
  System.out.println(quickselect( ary , 4 )); // would return 15
  System.out.println(quickselect( ary , 5 )); // would return 23
}
}
