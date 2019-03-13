import java.util.*;
public class Quick{
  private static void swapper(int[] data, int A, int B) {
    int t = data[A];
    data[A] = data[B];
    data[B] = t;
  }
  //partition  improvement a:
  private static int partition(int[]data, int start, int end) {
    if (start == end) return end; //nothing to do here
    // ----------finding the median value ----------------//
    int[] c = new int[] {data[start], data[data.length/2], data[end]};
    Arrays.sort(c);
    int pVal = c[1]; //1 would be the median value after being sorted.
    int pIX = data.length/2; //this is one of the 3 possibilities of the index of pVal;
    if (data[end] == pVal) pIX = end; //1 possibility for where p is.
    if (data[start] == pVal) pIX = start; //the other

    //same as last time but now rewritten!
    System.out.println("value @ pIX: " + data[pIX]);
    System.out.println("pivot value " + pVal); //these should be the same;
    swapper(data, start, pIX);
    start++;

    Random r = new Random();
    while (start != end) {
      if (data[start] > pVal ||
         (data[start] == pVal && r.nextInt() %2 == 0)) {
         //the 50/50 shot of landing on the righ tor left as discussed in class when equal to the pivoter
         swapper(data, start, end);
         end--; //same as last time, converge inwards
       }
       else start ++;
    }
    //the rest is still the same;
    if (data[start] < pVal) {
      swapper(data, start, pIX);
      return start; //should now be the index of pivot
    }
    else {
      swapper(data, start -1, pIX);
      return start -1;
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
 public static void quicksort(int[] data) {
   quicksortH(data, 0, data.length -1);
 }
 private static void quicksortH(int[] d, int s, int e){
 }

 public static void main(String[] args) {
   /*int[] array = new int[] {0,999,999,999,4,1,0,3,2,999,999,999};
     for (int i = 0; i < array.length -1; i++){
       System.out.println("term " + i + ": "+ quickselect(array, i));
     }*/
   //quicksort(array); //0,0,1, 2, 3, 4, 999x6
   //System.out.println(array);
   int[] ary = new int[] { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
   System.out.println(Arrays.toString(ary));
   //---------------- testing new and improved partition -----------//
   System.out.println(partition(ary, 0, ary.length -1));
   System.out.println(partition(ary, 0, ary.length -1));
   System.out.println(partition(ary, 0, ary.length -1));
   /*System.out.println(quickselect( ary , 0 )); //would return 0
   System.out.println(quickselect( ary , 1 )); // would return 2
   System.out.println(quickselect( ary , 2 )); // would return 5
   System.out.println(quickselect( ary , 3 )); // would return 10
   System.out.println(quickselect( ary , 4 )); // would return 15
   System.out.println(quickselect( ary , 5 )); // would return 23
   //quicksort(ary);
   //System.out.println(ary);*/
}
}
