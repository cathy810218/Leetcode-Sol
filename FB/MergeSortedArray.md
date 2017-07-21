# 88. Merge Sorted Array

Given two sorted integer arrays `nums1` and `nums2`, merge `nums2` into `nums1` as one sorted array.

### Java

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int totalSize = m + n - 1;
    int index1 = m - 1, index2 = n - 1; // last index of both arrays

    while (index1 >= 0 && index2 >= 0) {
        if (nums1[index1] > nums2[index2]) {
            nums1[totalSize] = nums1[index1];
            totalSize--;
            index1--;
        } else {
            nums1[totalSize] = nums2[index2];
            totalSize--;
            index2--;
        }
    }
    // add the rest of nums2 to the front of num1
    while(index2 >= 0) {
        nums1[totalSize] = nums2[index2];
        totalSize--;
        index2--;
    }
}
```
