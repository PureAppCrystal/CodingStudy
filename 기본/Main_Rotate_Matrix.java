package 기본;
public class Main_Rotate_Matrix {
    public static void main(String[] args) {
        int[][] image = {
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        printImage(image);
        rotateImage(image);
        printImage(image);
        rotateImage(image);
        printImage(image);
        rotateImage(image);
        printImage(image);
        rotateImage(image);
        printImage(image);
        rotateImage(image);

    }

    private static int[][] rotateImage(int[][] image) {
        int tmp;
        // s 가로윗변 1의자리: 시작점 증가 // e 가로아랫변 1의자리: 마지막점 감소
        for(int s = 0, e = image.length-1; s<e; s++, e-- ) {
            // i는 시작하는 점 // j는 끝나는 점
            for(int i=s, j=e; i<e; i++, j--) {
                tmp = image[s][i];
                image[s][i] = image[i][e];
                image[i][e] = image[e][j];
                image[e][j] = image[j][s];
                image[j][s] = tmp;
            }
        }
        return image;
    }

    private static void printImage(int[][] image) {
        for(int i=0; i<image.length; i++) {
            for(int j=0; j<image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}