package exercise.sort.mergesort;

class MergeSort {
    void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        splitArr(arr, tmp, 0, arr.length - 1);
    }

    void splitArr(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            splitArr(arr, tmp, start, mid);
            splitArr(arr, tmp, mid + 1, end);
            sortAndMergeArr(arr, tmp, start, mid, end);
        }
    }

    private void sortAndMergeArr(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] < tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }

        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }

    void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}

public class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 7, 6, 3, 2, 5, 8, 10};

        MergeSort mergeSort = new MergeSort();
        mergeSort.printArr(arr);
        mergeSort.mergeSort(arr);
        mergeSort.printArr(arr);
    }
}
