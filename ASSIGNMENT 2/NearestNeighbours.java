public class NearestNeighbours {
    public static int findNearest(int[] arr) {
        if (arr == null || arr.length < 2) {
            // If array is null or has less than 2 elements, there are no neighboring numbers
            return -1; // Return -1 to indicate no valid result
        }

        int minDistance = Integer.MAX_VALUE;
        int nearestIndex = -1;

        for (int i = 0; i < arr.length - 1; i++) {
            // Calculate the absolute difference between adjacent numbers
            int distance = Math.abs(arr[i] - arr[i + 1]);

            // Update nearest index and minimum distance if the current pair has a smaller distance
            if (distance < minDistance) {
                minDistance = distance;
                nearestIndex = i;
            }
        }

        return nearestIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 10, 13};
        int nearestIndex = findNearest(arr);

        if (nearestIndex != -1) {
            System.out.println("Nearest neighbors are at indices: " + nearestIndex + " and " + (nearestIndex + 1));
        } else {
            System.out.println("Array has less than 2 elements or is null.");
        }
    }
}
