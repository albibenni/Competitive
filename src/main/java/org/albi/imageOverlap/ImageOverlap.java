package org.albi.imageOverlap;

import lombok.Builder;

@Builder
public class ImageOverlap {
//    public int largestOverlap(int[][] img1, int[][] img2) {
//        int countImg2 = countValues(img2);
//        int countImg1 = countValues(img1);
//        if (countImg2 > countImg1) return countImg1;
//        return countImg2;
//
//    }
//    private int countValues(int[][] img){
//        int countImg = 0;
//        for (int i = 0; i < img.length; i++) {
//            for (int j = 0; j < img.length; j++) {
//                if (img[i][j] == 1) countImg++;
//            }
//
//        } return countImg;
//    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int row1 = img1.length;
        int row2 = img2.length;
        int column1 = img1[0].length;
        int column2 = img2[0].length;
        int max = Integer.MIN_VALUE;

        //Slide one image on other image.
        for(int row=0; row<row1+row2-1; row++){
            //index to iterate on the two images rows
            int i = row1-1 + Math.min(0, row2-1-row);
            int x = row + Math.min(0, row2-1-row);
            for(int column=0; column<column1+column2-1;  column++){
                //index to iterate on the two images columns
                int j = column1-1 + Math.min( 0 ,  column2-1-column);
                int y = column + Math.min(0 , column2-1-column);
                max = Math.max(max, overlap(img1,img2,i,j,x,y));
            }
        }
        return max;
    }

    //Compares two matrices from give coordinates to LEFT-TOP
    int overlap(int[][] img1, int[][] img2, int i1,int j1, int i2, int j2){
        int count = 0;
        //double for loop to check 2 images
        for(int i=i1,x=i2; i>=0 && x>=0; i--,x--){
            for(int j=j1, y=j2; j >=0 && y>=0 ; j--,y--){
                if(img1[i][j] == img2[x][y]){
                    if(img1[i][j]==1)
                        count++;
                }
            }
        }
        //System.out.println("[" + i1+" , "+j1+"]    ["+ i2 + " , "+j2+" ]" + "===" + count);
        return count;
    }


    public static void main(String[] args) {
        int[][] img1 = {{1,1,0}, {0, 1, 0}, {0, 1, 0}};
        int[][] img = {{0,0,0}, {0, 1, 1}, {0, 0, 1}};
        ImageOverlap imageOverlap = ImageOverlap.builder().build();
        int overlap = imageOverlap.largestOverlap(img1, img);
        System.out.println(overlap);
    }
}

//36ms run
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            int row = 0;
            for (int j = 0; j < n ; j++) {
                row = (row << 1) + img1[i][j];
            }
            arr1[i] = row;
        }

        for (int i = 0; i < n; i++) {
            int row = 0;
            for (int j = 0; j < n ; j++) {
                row = (row << 1) + img2[i][j];
            }
            arr2[i] = row;
        }

        int ans = 0;
        for (int i = 1-n; i <= n-1; i++) { //shift horizontally, negative means left, positive means right
            for (int j = 1-n; j <= n-1; j++) { //shift vertically, negative means up, positive means down
                //if scroll 0, row 0 - n-1
                //if scroll up by n-1, row n-1, if j , then abs(j) - n-1
                //if scroll down by n-1, row 0 - j, then 0 - n-j
                int count = 0;
                if (j <= 0) { // go up
                    if (i <= 0) {
                        //arr1 [abs(j)~n-1] & arr2 [abs(j)~n-1] and count(1)
                        for (int k = -j ; k < n; k++) {
                            count +=Integer.bitCount((arr1[k] << (-i)) & arr2[k+j]);
                        }
                    }
                    else {
                        for (int k = -j ; k < n; k++) {
                            count +=Integer.bitCount((arr1[k] >> i) & arr2[k+j]);
                        }
                    }
                }
                else { //go down
                    if (i <= 0) {
                        //arr1 [abs(j)~n-1] & arr2 [abs(j)~n-1] and count(1)
                        for (int k = 0 ; k < n-j; k++) {
                            count +=Integer.bitCount((arr1[k] << (-i)) & arr2[j+k]);
                        }
                    }
                    else {
                        for (int k = 0 ; k < n-j; k++) {
                            count +=Integer.bitCount((arr1[k] >> i) & arr2[j+k]);
                        }
                    }
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
