public class QuickSort {

  static int[] numbers = {3,6,5,7,8,67,5,6,7,6,4,3,3, 20, 45};

  public static void main(String[] args) {
    QuickSort.quicksort(numbers, 0, numbers.length-1);
    for (int i = 0; i < numbers.length; i++) {
      if (i != numbers.length -1) {
        System.out.print(numbers[i] + ", ");
      }
      else {
        System.out.print(numbers[i]);
      }
    }
  }


  public static void quicksort(int[] list, int low, int high) {
    if (low < high) {
      int mid = partition(list,low,high);
      quicksort(list, low, mid-1);
      quicksort(list, mid+1, high);
    }
  }

  public static int partition(int[] list, int low, int high) {
    // The pivot point is the median of the first, last and middle
    // value of the list.
    int mid = (low+high) /2;

    // Set pivot to median of first, middle and last element.
    int pivot = QuickSort.getMedian(list[low], list[mid], list[high]);


// Loop through the array. Move items up or down the array so that they
// are in the proper spot with regard to the pivot point.
    do {
// can we find a number smaller than the pivot point? keep
// moving the ''high'' marker down the array until we find
// this, or until high=low
      while (low < high && list[high] >= pivot) {
        high--;
      }
      if (low < high) {
// found a smaller number; swap it into position
        swap(list, low, high);
// now look for a number larger than the pivot point
        while (low < high && list[low] <= pivot) {
          low++;
        }
        if (low < high) {
// found one! move it into position
          swap(list, high, low);
        }
      }
    } while (low < high);
// move the pivot back into the array and return its index
    list[low] = pivot;
    return low;
  }
  public static void swap(int[] list, int firstIndex, int secondIndex) {
    int temp = list[firstIndex];
    list[firstIndex] = list[secondIndex];
    list[secondIndex] = temp;
  }


  /* Returns the median between 3 numbers.*/
  public static int getMedian(int num1, int num2, int num3) {

    int median;
    if (num1 > num2) {
      if (num1 < num3) {median = num1;}
      else if (num2 > num3) {median = num2;}
      else {median = num3;}
    }
    else {
      if (num1 > num3) {median = num2;}
      else if (num2 < num3) {median = num1;}
      else {median = num3;}
    }
    return median;
  }

}
