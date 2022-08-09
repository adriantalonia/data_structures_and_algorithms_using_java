## Radix Sort

Radix sort is a sorting algorithm that sorts the elements by first grouping the individual digits of the same place
value. Then, sort the elements according to their increasing/decreasing order.

![image](https://cdn.programiz.com/cdn/farfuture/GKQPB3dxbVfvYT3qiSZtTQDI5UOENnLr-oTPlCbYKaM/mtime:1582112622/sites/tutorial2program/files/Radix-sort-0_0.png)

### Working of Radix Sort

1. Find the largest element in the array, i.e. max. Let X be the number of digits in max. X is calculated because we
   have to go through all the significant places of all elements.

   In this array [121, 432, 564, 23, 1, 45, 788], we have the largest number 788. It has 3 digits. Therefore, the loop
   should go up to hundreds place (3 times).

2. Now, go through each significant place one by one.
   Use any stable sorting technique to sort the digits at each significant place. We have used counting sort for this.
   Sort the elements based on the unit place digits (X=0).

![image](https://cdn.programiz.com/cdn/farfuture/uCNpqDxCh0fa6L5HIYKbmYCbiZHlGhzXXBsxKVpItSs/mtime:1591330108/sites/tutorial2program/files/Radix-sort-one.png)

3. Now, sort the elements based on digits at tens place.
   ![image](https://cdn.programiz.com/cdn/farfuture/k2d_8gQeDKJ5pafc96mpZMqZvEqOOrh9eBCVmKRTBsg/mtime:1591330113/sites/tutorial2program/files/Radix-sort-ten.png)

4. Finally, sort the elements based on the digits at hundreds place.
   ![image](https://cdn.programiz.com/cdn/farfuture/CvIF-W6hxb0-kwt-hn9Gb3IWlpTVxR3PK7X4TQimROc/mtime:1591330096/sites/tutorial2program/files/Radix-sort-hundred.png)

```
radixSort(array)
  d <- maximum number of digits in the largest element
  create d buckets of size 0-9
  for i <- 0 to d
    sort the elements according to ith place digits using countingSort

countingSort(array, d)
  max <- find largest element among dth place elements
  initialize count array with all zeros
  for j <- 0 to size
    find the total count of each unique digit in dth place of elements and
    store the count at jth index in count array
  for i <- 1 to max
    find the cumulative sum and store it in count array itself
  for j <- size down to 1
    restore the elements to array
    decrease count of each element restored by 1
```

```java
// Radix Sort in Java Programming

import java.util.Arrays;

class RadixSort {

    // Using counting sort to sort the elements in the basis of significant places
    void countingSort(int array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            array[i] = output[i];
    }

    // Function to get the largest element from an array
    int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    // Main function to implement radix sort
    void radixSort(int array[], int size) {
        // Get maximum element
        int max = getMax(array, size);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(array, size, place);
    }

    // Driver code
    public static void main(String args[]) {
        int[] data = {121, 432, 564, 23, 1, 45, 788};
        int size = data.length;
        RadixSort rs = new RadixSort();
        rs.radixSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
```

### Radix Sort Complexity

| Time Complexity  ||
|------------------|-----|
| Best             | O(n+k)    |
| Worst            | O(n+k)    |
| Average          |  O(n+k)   |
| Space Complexity |O(max)     |
| Stability        |Yes     |
