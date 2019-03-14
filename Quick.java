import java.util.*;
public class Quick{
  private static void swapper(int[] data, int A, int B) {
    int t = data[A];
    data[A] = data[B];
    data[B] = t;
  }
  //partition  improvement a/b:
  private static int partition(int[]data, int start, int end) {
    if (start == end) return end; //nothing to do here
    // ----------finding the median value (a)----------------//
    int[] c = new int[] {data[start], data[data.length/2], data[end]};
    Arrays.sort(c);
    int pVal = c[1]; //1 would be the median value after being sorted.
    int pIX = data.length/2; //this is one of the 3 possibilities of the index of pVal;
    if (data[end] == pVal) pIX = end; //1 possibility for where p is.
    if (data[start] == pVal) pIX = start; //the other
    //swap to front;
    data[pIX] = data[start];
    data[start] = pVal;
    pIX = start;
    start++;

    Random r = new Random();
    while (start != end) {
      if (data[start] > pVal || //improvement b 50 50
         (data[start] == pVal && r.nextInt() %2 == 0)) {
         //the 50/50 shot of landing on the righ tor left as discussed in class when equal to the pivoter
         swapper(data, start, end);
         end--; //same as last time, converge inwards
       }
       else start ++;
    }
    //the rest is still the same;
    if (data[start] < pVal) {
      data[pIX] = data[start];
      data[start] = pVal;
      return start; //should now be the index of pivot
    }
    else {
      data[pIX] = data[start -1];
      data[start -1] = pVal;
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
   int s = 0;
   int e = data.length -1; //these are subject to change
   int piv =  partition(data, s, e); //partition once!
   while (piv!= k) {
     if (piv > k) e = piv -1; //this means that k exists between s and piv
     else s = piv + 1; //this means that k exists between piv and e
     piv = partition(data, s, e); //we should converge onto k sorted index.
   }
   return data[piv];
 }

 /*
 Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data) {
   quicksortH(data, 0, data.length -1);
 }

 private static void quicksortH(int[] d, int s, int e){
   if (s >= e) return;
   int pivot = partition(d, s, e);
   quicksortH(d, s, pivot -1); //sort below pivot
   quicksortH(d, pivot +1, e); //sort above pivot
 }

 //checks to see if partition did it's job
 /*private static boolean provePartition(int[] d, int s, int e, int pIX) {
   int piv = d[pIX];
   for (int i = s; i < e; i++) {
     if ((i < pIX && d[i] > piv) || (i > pIX && d[i] < piv)) { //aka if it's on the left and not less than or on the right but less than
        return false;
      }
   }
   return true;
 }*/
}
