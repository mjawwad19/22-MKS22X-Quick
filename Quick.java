import java.util.*;
public class Quick{
  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
  private static int partition ( int [] data, int start, int end){
    int index = (int) (Math.random() * (end - start + 1) + start);
    // choose a random index that is not start nor end (or attempt not to, as discussed in class)
    int pivot = data[index];
    System.out.println("pivot : " + pivot);
    //pivot is what we will use the separate the data that is less or greater. We temporarily store since swapping is involved for constant time!
    swapper(data, index, 0);
    //System.out.println(Arrays.toString(data));
    start++; //we will not include pivot till later.

    while (start != end) {
      if (data[start] > pivot)  {
        swapper(data, start, end);
        end--;
        //swap the data that's greater than pivot to the right of pivot but then also converge inwards from end
      }
      else start++; //do nothing otherwise because it's less than so right place currently
      //System.out.println(Arrays.toString(data));
    }
    if (data[start] < pivot) {
      swapper(data, 0, start);
      //now start is the index of pivot
      //System.out.println(Arrays.toString(data));
      //this should show that if this was a sorted array, pivot is in the right place!
      return start;
    }
    else {
      swapper(data, start -1, 0);
      //pivot and start-1 need to swap
      //System.out.println("pivot : " + pivot);
      //System.out.println(Arrays.toString(data));
      return start -1;
    }

    //System.out.println(Arrays.toString(data));
  }

  private static void swapper(int[] data, int A, int B) {
    int t = data[A];
    data[A] = data[B];
    data[B] = t;



  }

  /*
  return the value that is the kth smallest value of the array. k=0 is the smallest
 */
 public static int quickselect(int[] data, int k) {
   int piv0;
   piv0 = partition(data, 0, data.length -1); //partition once;
   while (piv0 != k-1) {
     if (k-1 > piv0) {
       partition(data, piv0, data.length -1);
     }
     if (k -1 < piv0) {
       partition(data, 0, piv0);
     }
   }
   return data[piv0];
 }

 /*
 Modify the array to be in increasing order.
 */
 public static void quicksort(int[] data) {}


}
