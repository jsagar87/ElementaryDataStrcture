package sort.sample.clients;

public class QuickSort {

    public static void printarr(int[] arr) {
        System.out.print("[");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("]");
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void quicksort(int[] arr, int i, int j, int p){
        if (i >= p) return;
//        printarr(arr);
        int start = i;
        int end = p;
        while (j<=end) {
            if (arr[j] < arr[p]) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        swap(arr,i,p);
//        printarr(arr);
        quicksort(arr, start, start, i-1);
        quicksort(arr, i+1, i+1, end);

    }
    public static void main(String[] args) {
        int[] arr = new int[] {5,3,9,21,1,6,4,7,2,0};
        int p = arr.length-1;
        int i = 0; // for smaller element
        int j = 0 ;// for larger scan
        quicksort(arr,i,j,p);
        printarr(arr);
    }
}
