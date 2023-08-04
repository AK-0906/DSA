public class Merge_Sort {
    public static void divide(int arr[], int si, int ei) {
        if (si >= ei - 1) {
            return;
        }
        int mid = (ei + si) / 2;
        divide(arr, si, mid);
        divide(arr, mid, ei);
        conquer(arr, si, mid, ei);
    }

    public static void conquer(int arr[], int si, int mid, int ei) {
        int[] temp = new int[ei - si];
        int idxs = si;
        int idxe = mid;
        int idxl = 0;
        
        while (idxs < mid && idxe < ei) {
            if (arr[idxs] <= arr[idxe]) {
                temp[idxl] = arr[idxs];
                idxs++;
                idxl++;
            } else {
                temp[idxl] = arr[idxe];
                idxe++;
                idxl++;
            }
        }
        while (idxs < mid) {
            temp[idxl] = arr[idxs];
            idxs++;
            idxl++;
        }

        while (idxe < ei) {
            temp[idxl] = arr[idxe];
            idxe++;
            idxl++;
        }

        for (int i = 0; i < temp.length; i++) {
            arr[si + i] = temp[i];
        }
    }
    public static void print_arr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");     
        }
        System.out.println();
        
    }

    public static void main(String args[]) {
        int[] arr = { 1, 9, 8, 2, 5, 6, 4 };
        int n = arr.length;
        divide(arr, 0, n);
        print_arr(arr);
    }
}
