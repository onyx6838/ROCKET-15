package com.vti.utils;

import java.util.Arrays;

public final class MathUtils {
    public static void countFreq(float arr[], int n, int freq) {
        boolean visited[] = new boolean[n];

        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            if (visited[i] == true)
                continue;
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            switch (freq) {
                case -1:
                    System.out.println(arr[i] + " appear " + count);
                    break;
                case 1:
                case 2:
                    if (count == freq) System.out.println(freq + " appear : " + arr[i]);
                    break;
            }
        }
    }

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;  // sum+= last digit
            n /= 10;   // remove last digit
        }
        return sum;
    }

    public static void primeFactor(int n) {
        int i = 2;
        while (n > 0) {
            if (n == 1 || n == 2) System.out.println(n);
            else if (n % i == 0) {
                System.out.print(i + "*");
                n = n / i;
            } else i++;
            if ((n == i) && (n != 2)) {
                System.out.print(n);
                break;
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public static int USCLN(int a, int b) {
        if (b == 0) return a;
        return USCLN(b, a % b);
    }

    public static int BSCNN(int a, int b) {
        return (a * b) / USCLN(a, b);
    }

    // O(n^2)
    public static int fib(int n) {
        return n <= 2 ? 1 : fib(n - 1) + fib(n - 2);
    }

    // O(n)
    public static long fibo(int n) {
        long[] F = new long[n + 5];
        F[0] = 0;
        F[1] = F[2] = 1;
        for (int i = 3; i <= n; i++) F[i] = F[i - 1] + F[i - 2];
        return F[n];
    }

    public static boolean checkRevNum(int n) {
        long dao = 0;
        long m = n;
        while (m > 0) { // reverse
            dao = dao * 10 + m % 10;
            m /= 10;
        }
        return dao == n ? true : false;
    }

    public static void Permutation(int k, int n) {
        int[] Bool = new int[n + 1];//Đánh dấu chưa có phần tử nào sử dụng hết
        Arrays.fill(Bool, 0);

        int A[] = new int[n + 1];//Lưu hoán vị vào mảng A
        for (int i = 1; i <= n; i++) {
            //Kiểm tra nếu phần tử chưa được chọn thì sẽ đánh dấu
            if (Bool[i] == 0) {
                A[k] = i; // Lưu một phần tử vào hoán vị
                Bool[i] = 1;//Đánh dấu đã dùng
                if (k == n)//Kiểm tra nếu đã chứa một hoán vị thì xuất
                {
                    for (int j = 1; j <= n; j++)
                        System.out.println(A[j] + " ");
                }
                //xuat();
                else
                    Permutation(k + 1, n);
                Bool[i] = 0;
            }
        }
    }

    private static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void mergeArrays(int[] arr1, int[] arr2, int n1,
                                   int n2, int[] arr3) {
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i < n1 && j < n2) {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < n1)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < n2)
            arr3[k++] = arr2[j++];
    }
}
