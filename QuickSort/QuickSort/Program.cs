using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace QuickSort
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            int[] numbers = {10, 2, 4, 12, 5, 8, 9};
            //MyHeapSort(numbers, 0, numbers.Length - 1);
            Console.WriteLine();
            foreach (int x in numbers)
              //  Debug.Write(x + " ");

            numbers = new int[9]{10, 9 , 8 , 7, 1 , 2, 5, 5, 5};
            int key = 2;
            Debug.Write("\n" + "Finding " + key + " : " + Search(numbers, 0, numbers.Length - 1, key) + "\n");
            key = 11;
            Debug.Write("\n" + "Finding " + key + " : " + Search(numbers, 0, numbers.Length - 1, key) + "\n");
        }

        private static void MyQuickSort(int[] A, int start, int end)
        {
            if (start < end)
            {
                int p = Partition(A, start, end);
                MyQuickSort(A, start, p - 1);
                MyQuickSort(A, p + 1, end);
            }
        }

        private static void SelectionSort(int[] A, int start, int end)
        {
            if (start < end)
            {
                int minSoFar = int.MaxValue;
                int minIndex = 0;
                for (int i = start; i <= end; i++)
                {
                    if (A[i] < minSoFar)
                    {
                        minSoFar = A[i];
                        minIndex = i;
                    }
                }
                Swap(A, start, minIndex);
                SelectionSort(A, start + 1, end);
            }
        }

        private static void BubbleSort(int[] A, int start, int end)
        {
            if (start < end)
            {
                for (int i = start; i <= end - 1; i++)
                {
                    if (A[i] > A[i + 1])
                        Swap(A, i, i + 1);
                }
                BubbleSort(A, start, end - 1);
            }
        }


        private static int Partition(int[] A, int start, int end)
        {
            int key = A[end];
            int partitionIndex = start;

            for (int i = start; i <= end - 1; i++)
            {
                if (A[i] < key)
                    // this element needs to be pushed to the partitionIndex
                {
                    Swap(A, partitionIndex, i);
                    partitionIndex++;
                }
            }
            Swap(A, partitionIndex, end);
            return partitionIndex;
        }

        private static void Swap(int[] array, int a, int b)
        {
            int store = array[a];
            array[a] = array[b];
            array[b] = store;
        }

        private static void MyHeapSort(int[] A, int start, int end)
        {
            BuildMaxHeap(A, start, end);
            int heapsize = A.Length;
            for (int i = A.Length - 1; i > 0; i--)
            {
                Swap(A, start, i);
                heapsize--;
                MaxHeapify(A, start, heapsize);
            }
        }

        
        private static void BuildMaxHeap(int[] A, int start, int end)
        {
            for (int i = (end - start)/2; i >= start; i--)
            {
                MaxHeapify(A, i, A.Length);
            }
        }

        private static void MaxHeapify(int[] A, int i, int heapsize)
        {
            int lIndex = Left(i);
            int rIndex = Right(i);
            int largest = 0;
            if (lIndex < heapsize && A[i] < A[lIndex])
                largest = lIndex;
            else
            {
                largest = i;
            }
            if (rIndex < heapsize && A[largest] < A[rIndex])
                largest = rIndex;
            
            if (i != largest)
            {
                Swap(A, i, largest);
                MaxHeapify(A, largest, heapsize);
            }
        }

        private static int Left(int i)
        {
            return 2*i;
        }

        private static int Right(int i)
        {
            return 2*i + 1;
        }

        private static int BinarySearch(int[] A, int start, int end, int key)
        {
            if (start > end)
                return -1;
            int mid = (start + end)/2;
            if (key == A[mid])
                return mid;
            else if (key < A[mid])
                return BinarySearch(A, start, mid - 1, key);
            else
                return BinarySearch(A, mid + 1, end, key);
        }

        private static int Search(int[] A, int start, int end, int key)
        {
            if (start <= end)
            {
                int mid = (start + end) / 2;
                if (A[mid] == key)
                    return mid;

                if (A[mid] < A[end]) // latter half is sorted
                {
                    if (A[mid] <= key && A[end] >= key)
                        return Search(A, mid + 1, end, key);
                    else
                        return Search(A, start, mid - 1, key);
                }
                else if (A[mid] > A[end])
                {
                    if (A[mid] >= key && A[start] <= key)
                        return Search(A, start, mid - 1, key);
                    else
                        return Search(A, mid + 1, end, key);
                }
                else if (A[mid] == A[end])
                {
                    if (A[start] != A[mid])
                        return Search(A, start, mid - 1, key);
                    else
                    {
                        int result = Search(A, start, mid - 1, key);
                        if (result == -1)
                            return Search(A, mid + 1, end, key);
                        else return result;
                    }
                }

            }
            return -1;
        }

    }
}


