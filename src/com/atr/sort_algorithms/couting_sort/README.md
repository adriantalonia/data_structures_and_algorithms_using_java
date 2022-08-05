## Counting Sort

Counting sort is a sorting technique based on keys between a specific range. It works by counting the number of objects
having distinct key values (kind of hashing). Then do some arithmetic to calculate the position of each object in the
output sequence.

Let's suppose we're going to sort an input array with values in the [0, 5] range

![image](https://www.baeldung.com/wp-content/uploads/2019/09/To-Sort-Array.png)

First, we should count the occurrence of each number in the input array. If we represent the countings with array C,
then C[i] represents the frequency of number i in the input array:

![image](https://www.baeldung.com/wp-content/uploads/2019/09/counts.png)

(https://youtu.be/7zuGmKfUt7s)
