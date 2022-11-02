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
            //index to iterate on the two images
            int i = row1-1 + Math.min(0, row2-1-row);
            int x = row + Math.min(0, row2-1-row);
            for(int c=0; c<column1+column2-1;  c++){
                int j = column1-1 + Math.min( 0 ,  column2-1-c);
                int y = c + Math.min(0 , column2-1-c);
                max = Math.max(max, overlap(img1,img2,i,j,x,y));
            }
        }
        return max;
    }

    //Compares two matrices from give coordinates to LEFT-TOP
    int overlap(int[][] img1, int[][] img2, int i1,int j1, int i2, int j2){
        int count = 0;
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
