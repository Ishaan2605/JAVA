import java.util.ArrayList;
import java.util.Arrays;

public class ArrayArrayListConversion {
    public static ArrayList<Integer> arrayToArrayList(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : arr) {
            arrayList.add(num);
        }
        return arrayList;
    }

    public static int[] arrayListToArray(ArrayList<Integer> arrayList) {
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {1, 2, 3, 4, 5};

        // Convert array to ArrayList
        ArrayList<Integer> arrayListFromArr = arrayToArrayList(arr);
        System.out.println("ArrayList from array: " + arrayListFromArr);

        // Convert ArrayList to array
        int[] arrFromArrayList = arrayListToArray(arrayListFromArr);
        System.out.println("Array from ArrayList: " + Arrays.toString(arrFromArrayList));
    }
}
