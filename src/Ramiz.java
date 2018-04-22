import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ramiz {

    public static void main(String[] args) throws FileNotFoundException{




        int[][][] board = new int[4][4][4];

        while (!isFinished(board)) {

            printBoard(board);

            String pieceWeGive = arrayToString(givePiece(board));
            System.out.println(pieceWeGive);
            //printPotential(board, givePiece(board));

            int[] coordinates = takeCoordinates();

            int x = coordinates[0];
            int y = coordinates[1];

            putPiece(board, x, y, pieceWeGive);
            printBoard(board);

            if (isFinished(board)) {
                System.out.println("you win");
                break;
            }

            String pieceWeTake = takePiece();

            playPiece(board, pieceWeTake);

            if (isFinished(board)) {
                printBoard(board);
                System.out.println("i win");
            }
        }
    }

    //This method is for taking pieces from the user
    public static String takePiece() {

        Scanner console = new Scanner(System.in);
        String piece;

        boolean flag;
        int cnt = 0;

        do {
            if (cnt > 0) {
                System.out.println("The piece you have entered is not identified. Please try again.");
            }

            System.out.println("Please enter a piece");

            piece = console.next();
            flag = false;

            if (piece.length() != 4) {
                flag = true;
            } else if (!(piece.substring(0, 1).equalsIgnoreCase("b") ||
                    piece.substring(0, 1).equalsIgnoreCase("w"))) {
                flag = true;
            } else if (!(piece.substring(1, 2).equalsIgnoreCase("t") ||
                    piece.substring(1, 2).equalsIgnoreCase("s"))) {
                flag = true;
            } else if (!(piece.substring(2, 3).equalsIgnoreCase("s") ||
                    piece.substring(2, 3).equalsIgnoreCase("r"))) {
                flag = true;
            } else if (!(piece.substring(3).equalsIgnoreCase("h") ||
                    piece.substring(3).equalsIgnoreCase("s"))) {
                flag = true;
            }

            cnt++;

        } while (flag);

        return piece;
    }

    //This method is for taking coordinates from the user
    public static int[] takeCoordinates() {

        Scanner console = new Scanner(System.in);

        int x = -1;
        int y = -1;
        int cnt = 0;

        do {
            if (cnt > 0) {
                System.out.println("The numbers you have entered are not identified in coordinate plane. " +
                        "Please enter two number lies in [0,3].");
            }

            System.out.println("x y = ");

            String first = console.next();
            String second = console.next();

            if (first.length() == 1) {

                if (first.charAt(0) == '0') {
                    x = 0;
                } else if (first.charAt(0) == '1') {
                    x = 1;
                } else if (first.charAt(0) == '2') {
                    x = 2;
                } else if (first.charAt(0) == '3') {
                    x = 3;
                }
            }

            if (second.length() == 1) {

                if (second.charAt(0) == '0') {
                    y = 0;
                } else if (second.charAt(0) == '1') {
                    y = 1;
                } else if (second.charAt(0) == '2') {
                    y = 2;
                } else if (second.charAt(0) == '3') {
                    y = 3;
                }
            }

            cnt++;

        } while (x == -1 || y == -1);

        int[] numbers = {x, y};

        return numbers;
    }

    public static void printBoard(int[][][] board) {

        int[] piece = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    piece[k] = board[i][j][k];
                }
                System.out.print(arrayToString(piece));
            }
            System.out.println();
        }
    }

    public static void printPotential(int[][][] board, int[] piece) {

        double[][] potential = potential(board, piece);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(potential[i][j] + " ");
            }
            System.out.println();
        }
    }

//    public static int[][][] getBoard() throws FileNotFoundException {
//
//        Scanner input = new Scanner(new File("input.txt"));
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                input.txt
//            }
//
//        int[][][] board = new int[4][4][4];
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                board[i][j] = stringToArray(boardString[i][j]);
//            }
//        }
//
//        return board;
//    }

    public static boolean isFinished(int[][][] board) {

        int cnt1;
        int cnt2;
        int cnt3;
        int cnt4;
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 4; i++) {
                cnt1 = 0;
                cnt2 = 0;
                cnt3 = 0;
                cnt4 = 0;
                for (int j = 0; j < 4; j++) {
                    if (board[i][j][k] == board[i][0][k] && board[i][0][k] != 0) {
                        cnt1++;
                    }
                    if (cnt1 == 4) {
                        return true;
                    }

                    if (board[j][i][k] == board[0][i][k] && board[0][i][k] != 0) {
                        cnt2++;
                    }
                    if (cnt2 == 4) {
                        return true;
                    }

                    if (board[j][j][k] == board[0][0][k] && board[0][0][k] != 0){
                        cnt3++;
                    }
                    if (cnt3 == 4) {
                        return true;
                    }

                    if (board[j][3 - j][k] == board[0][3][k] && board[0][3][k] != 0){
                        cnt4++;
                    }
                    if (cnt4 == 4) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static int[][][] playPiece(int[][][] board, String pieceString) {

        int[] piece;
        piece = stringToArray(pieceString);

        double potential[][];
        potential = potential(board, piece);

        double oldMax = -99999;
        int a = -1;
        int b = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (potential[i][j] > oldMax) {
                    a = i;
                    b = j;
                    oldMax = potential[i][j];
                }
            }
        }

        for (int k = 0; k < 4; k++) {
            board[a][b][k] = piece[k];
        }

        return board;
    }

    public static int[][][] putPiece(int[][][] board, int a, int b, String pieceString) {

        int[] piece = stringToArray(pieceString);

        for (int k = 0; k < 4; k++) {
            board[a][b][k] = piece[k];
        }

        return board;
    }


    public static int[] givePiece(int[][][] board) {

        int[] piece = new int[4];
        int[] willBeGivenPiece = new int[4];

        double minOfOldMax = 999999999;

        for (int a = 1; a < 3; a++) {
            piece[0] = a;
            for (int b = 1; b < 3; b++) {
                piece[1] = b;
                for (int c = 1; c < 3; c++) {
                    piece[2] = c;
                    for (int d = 1; d < 3; d++) {
                        piece[3] = d;
                        if (isPieceNotGiven(board, piece)) {

                            double potential[][];
                            potential = potential(board, piece);

                            double oldMax = -99999;
                            for (int i = 0; i < 4; i++) {
                                for (int j = 0; j < 4; j++) {
                                    if (potential[i][j] > oldMax) {
                                        oldMax = potential[i][j];
                                    }
                                }
                            }

                            if (oldMax < minOfOldMax) {
                                minOfOldMax = oldMax;
                                for (int k = 0; k < 4; k++) {
                                    willBeGivenPiece[k] = piece[k];
                                }
                            }
                        }
                    }
                }
            }
        }

        return willBeGivenPiece;
    }

    public static int[] stringToArray(String pieceString) {

        int[] piece = new int[4];
        
        if(pieceString.equalsIgnoreCase("E")) {
        	return piece;
        }

        if (pieceString.charAt(0) == 'B' || pieceString.charAt(0) == 'b') {
            piece[0] = 1;
        } else {
            piece[0] = 2;
        }

        if (pieceString.charAt(1) == 'T' || pieceString.charAt(1) == 't') {
            piece[1] = 1;
        } else {
            piece[1] = 2;
        }

        if (pieceString.charAt(2) == 'S' || pieceString.charAt(2) == 's') {
            piece[2] = 1;
        } else {
            piece[2] = 2;
        }

        if (pieceString.charAt(3) == 'H' || pieceString.charAt(3) == 'h') {
            piece[3] = 1;
        } else {
            piece[3] = 2;
        }

        return piece;
    }

    public static String arrayToString(int[] piece) {

        String pieceString = "";

        if (piece[0] == 0) {
            pieceString = "E    ";
        } else {
             if (piece[0] == 1) {
                pieceString += "B";
            } else {
                pieceString += "W";
            }

            if (piece[1] == 1) {
                pieceString += "T";
            } else {
                pieceString += "S";
            }

            if (piece[2] == 1) {
                pieceString += "S";
            } else {
                pieceString += "R";
            }

            if (piece[3] == 1) {
                pieceString += "H ";
            } else {
                pieceString += "S ";
            }
        }

        return pieceString;
    }

    public static double[][] potential(int[][][] board, int[] piece) {

        double [][][] verticalPotential = new double[4][4][4];
        double [][][] horizontalPotential = new double[4][4][4];
        double [][][] diagonalPotential = new double[4][4][4];
        double [][] potential = new double[4][4];


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {

                    if (board[i][j][k] != 0) {

                        for (int d = 0; d < 4; d++) {
                            diagonalPotential[i][j][d] = -2;
                            horizontalPotential[i][j][d] = -2;
                            verticalPotential[i][j][d] = -2;
                        }

                    } else if (i == j) {

                        for (int n = 0; n < 4; n++) {
                            if (piece[k] != board[n][j][k] && board[n][j][k] != 0) {
                                verticalPotential[i][j][k] = -1;
                                break;
                            } else if (piece[k] == board[n][j][k]) {
                                verticalPotential[i][j][k]++;
                            }
                        }

                        for (int m = 0; m < 4; m++) {
                            if (piece[k] != board[i][m][k] && board[i][m][k] != 0) {
                                horizontalPotential[i][j][k] = -1;
                                break;
                            } else if (piece[k] == board[i][m][k]) {
                                horizontalPotential[i][j][k]++;
                            }
                        }

                        for (int d = 0; d < 4; d++) {
                            if (piece[k] != board[d][d][k] && board[d][d][k] != 0) {
                                diagonalPotential[i][j][k] = -1;
                                break;
                            } else if (piece[k] == board[d][d][k]) {
                                diagonalPotential[i][j][k]++;
                            }
                        }

                    } else if (i + j == 3) {

                        for (int n = 0; n < 4; n++) {
                            if (piece[k] != board[n][j][k] && board[n][j][k] != 0) {
                                verticalPotential[i][j][k] = -1;
                                break;
                            } else if (piece[k] == board[n][j][k]) {
                                verticalPotential[i][j][k]++;
                            }
                        }

                        for (int m = 0; m < 4; m++) {
                            if (piece[k] != board[i][m][k] && board[i][m][k] != 0) {
                                horizontalPotential[i][j][k] = -1;
                                break;
                            } else if (piece[k] == board[i][m][k]) {
                                horizontalPotential[i][j][k]++;
                            }
                        }

                        for (int d = 0; d < 4; d++) {
                            if (piece[k] != board[d][3 - d][k] && board[d][3 - d][k] != 0) {
                                diagonalPotential[i][j][k] = -1;
                                break;
                            } else if (piece[k] == board[d][3 - d][k]) {
                                diagonalPotential[i][j][k]++;
                            }
                        }

                    } else {

                        for (int n = 0; n < 4; n++) {
                            if (piece[k] != board[n][j][k] && board[n][j][k] != 0) {
                                verticalPotential[i][j][k] = -1;
                                break;
                            } else if (piece[k] == board[n][j][k]) {
                                verticalPotential[i][j][k]++;
                            }
                        }

                        for (int m = 0; m < 4; m++) {
                            if (piece[k] != board[i][m][k] && board[i][m][k] != 0) {
                                horizontalPotential[i][j][k] = -1;
                                break;
                            } else if (piece[k] == board[i][m][k]) {
                                horizontalPotential[i][j][k]++;
                            }
                        }

                        for (int d = 0; d < 4; d++) {
                            diagonalPotential[i][j][d] = -1;
                        }
                    }

                    potential[i][j] += fn(verticalPotential[i][j][k]) +
                                       fn(horizontalPotential[i][j][k]) +
                                       fn(diagonalPotential[i][j][k]);
                }
            }
        }

        return potential;
    }

    //This is a function for potential calculations
    public static double fn(double b) {

        if (b == -2) return -999999;
        if (b == -1) return 0;
        if (b == 0) return -1;
        if (b == 1) return Math.E;
        if (b == 2) return -1 * (Math.E * Math.E);
        if (b == 3) return 999999;
        return 9999999999999999999.0;
    }

    public static boolean isPieceNotGiven(int[][][] board, int[] piece) {

        int cnt;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cnt = 0;
                for (int k = 0; k < 4; k++) {

                    if (board[i][j][0] == 0) {
                        break;
                    }

                    if (board[i][j][k] == piece[k]) {
                        cnt++;
                    } else {
                        break;
                    }

                    if (cnt == 4) return false;
                }
            }
        }

        return true;
    }
}