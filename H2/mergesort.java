import java.util.Random;
public class mergesort {
    public static void main(String[] args) {
        int len = 100;
        int max = 101;
        // int min = -100;
        int[] arr = CreateArray(len, -100, max);
        System.out.println("Исходный массив");
        PrintArray(arr);
        int[] tmp = new int[len];
        int[] res = MergeSort(arr, tmp, 0, len - 1);
        System.out.println("Массив отсортированный с помощью алгоритма сортировки слиянием");
        PrintArray(res);
    }

    public static int[] MergeSort(int[] arr, int[] buff, int left, int right) {
        if (left == right) {
            buff[left] = arr[left];
            return buff;
        }

        int middle = left + (right - left) / 2;
        int[] lBuff = MergeSort(arr, buff, left, middle);
        int[] rBuff = MergeSort(arr, buff, middle + 1, right);
        int[] result = lBuff == arr ? buff : arr;

        int lCurrent = left;
        int rCurrent = middle + 1;
        for (int i = left; i <= right; i++) {
            if (lCurrent <= middle && rCurrent <= right) {
                if (lBuff[lCurrent] < rBuff[rCurrent]) {
                    result[i] = lBuff[lCurrent];
                    lCurrent++;
                } else {
                    result[i] = rBuff[rCurrent];
                    rCurrent++;
                }
            } else if (lCurrent <= middle) {
                result[i] = lBuff[lCurrent];
                lCurrent++;
            } else {
                result[i] = rBuff[rCurrent];
                rCurrent++;
            }
        }
        return result;
    }

    public static int[] CreateArray(int len, int min, int max) {
        int[] arr = new int[len];
        Random rnd = new Random();
        for (int i = 0; i < len; i++) {
            arr[i] = rnd.nextInt();
        }
        return arr;
    }

    public static void PrintArray(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            System.out.printf("%5d ", array[i]);
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}   
