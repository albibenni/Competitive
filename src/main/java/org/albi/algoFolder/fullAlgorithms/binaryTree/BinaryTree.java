package org.albi.algoFolder.fullAlgorithms.binaryTree;

public class BinaryTree {
    private BinaryTree() {

    }

    public static int binarySearch(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    boolean bitonicArraySearch(int[] a, int value) {
        int[] asc = new int[a.length / 2];
        int[] desc = new int[a.length / 2];
        for (int i = 0; i < a.length / 2; i++) asc[i] = a[i];
        if (a.length % 2 != 0) {
            if (a[(a.length / 2)] == value) return true;
            for (int i = (a.length / 2) + 1; i < a.length; i++) {
                desc = new int[(a.length / 2) - 1];
                desc[i] = a[i];
            }
        } else {
            for (int i = a.length / 2; i < a.length; i++) {
                desc[i] = a[i];
            }
        }
        if (binarySearch(asc, value) != -1) return true;
        if (binarySearch(desc, value) != -1) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(200 % 2 == 0);
        System.out.println(3 / 2);
    }
}
