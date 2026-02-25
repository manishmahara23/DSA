static void insertionSortRecursive(int arr[], int n) {
    // Base case
    if (n <= 1)
        return;

    // Sort first n-1 elements
    insertionSortRecursive(arr, n - 1);

    // Insert last element at correct position
    insert(arr, n - 1);
}

static void insert(int arr[], int index) {
    // Base condition
    if (index <= 0 || arr[index] >= arr[index - 1])
        return;

    // Swap current element with previous
    int temp = arr[index];
    arr[index] = arr[index - 1];
    arr[index - 1] = temp;

    // Recursive call for previous index
    insert(arr, index - 1);
}