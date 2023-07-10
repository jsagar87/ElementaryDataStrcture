package leet.quickselectKthelem;

public class QuickSelect {

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
    public static void quickselect(int[] arr, int start, int pivot, int idxExpected){
        int i = start, j = start;
        int p = pivot;
        if (i >= p) return;
        int end = p;
        while (j<=end) {
            if (arr[j] < arr[p]) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        swap(arr,i,p);

        quickselect(arr, start, i-1, idxExpected);
        quickselect(arr, i+1, end, idxExpected);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,3,9,21,1,6,4,7,2,0};
        int p = arr.length-1;
        int i = 0;
        int j = 0;
        quickselect(arr,i,j,p);
        printarr(arr);
    }
}