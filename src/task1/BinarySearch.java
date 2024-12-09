package task1;

public class BinarySearch {
    /**
     * Performs a recursive binary search for a target integer in a sorted array
     * @param arr The sorted array to search in
     * @param target The value to search for
     * @return The index of the target if found, -1 otherwise
     * @throws IllegalArgumentException if the array is null
     */
    public static int binarySearchRecursive(int[] arr, int target) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchHelper(int[] arr, int target, int left, int right) {
        // Base case: search range is empty
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchHelper(arr, target, left, mid - 1);
        } else {
            return binarySearchHelper(arr, target, mid + 1, right);
        }
    }

    /**
     * Performs a recursive binary search for a target string in a sorted array
     * @param arr The sorted array to search in
     * @param target The string to search for
     * @return The index of the target if found, -1 otherwise
     * @throws IllegalArgumentException if the array or target is null
     */
    public static int binarySearchRecursive(String[] arr, String target) {
        if (arr == null || target == null) {
            throw new IllegalArgumentException("Array and target cannot be null");
        }
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchHelper(String[] arr, String target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        int comparison = arr[mid].compareTo(target);
        if (comparison == 0) {
            return mid;
        } else if (comparison > 0) {
            return binarySearchHelper(arr, target, left, mid - 1);
        } else {
            return binarySearchHelper(arr, target, mid + 1, right);
        }
    }

    /**
     * Finds all occurrences of a target value in a sorted array
     * @param arr The sorted array to search in
     * @param target The value to search for
     * @return Array containing all indices where target appears
     * @throws IllegalArgumentException if the array is null
     */
    public static int[] findAllOccurrences(int[] arr, int target) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        // First find one occurrence
        int index = binarySearchRecursive(arr, target);
        if (index == -1) {
            return new int[0];
        }

        // Find all occurrences by checking left and right
        int left = index;
        int right = index;

        // Check left side
        while (left > 0 && arr[left - 1] == target) {
            left--;
        }

        // Check right side
        while (right < arr.length - 1 && arr[right + 1] == target) {
            right++;
        }

        // Create result array
        int[] result = new int[right - left + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = left + i;
        }
        return result;
    }
}
