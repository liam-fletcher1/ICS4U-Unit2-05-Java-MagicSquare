/*
 * The Magic Square Program
 *
 * @author  Liam Fletcher
 * @version 1.0
 * @since   2021-12-06
 */

public final class MagicSquare{
    private MagicSquare() {}
    /**
     * the number three.
     */
    public static final int THREE = 3;
    /**
     * the number four.
     */
    public static final int FOUR = 4;
    /**
     * the number five.
     */
    public static final int FIVE = 5;
    /**
     * the number six.
     */
    public static final int SIX = 6;
    /**
     * the number seven.
     */
    public static final int SEVEN = 7;
    /**
     * the number eight.
     */
    public static final int EIGHT = 8;
    /**
     * the number nine.
     */
    public static final int NINE = 9;
    /**
     * the number Fifteen.
     */
    public static final int FIFTEEN = 15;
    /**
     * This function prints a magic square 
     * @param printList
     */
    static void printSquare(final int[] printList) {
        for (int printCounter = 0; printCounter < printList.length; printCounter++) {
            System.out.print(printList[printCounter] + " ");
            if ((printCounter + 1) % THREE == 0) {
                System.out.println("");
            } else {
                continue;
            }
        }
        System.out.println("*****");
    }

    /**
     * This function finds and prints all 3 by 3 magic number sets 
     * @param numberList
     * @param indexList
     * @param index
     */
    static void solveSquares(final int[] numberList,
        final int[] indexList, final int index) {
        for (int counter = 0; counter < numberList.length; counter++) {
            if (indexList[counter] == 0) {
                numberList[counter] = index;
                indexList[counter] = 1;

                if (index < NINE) {
                    solveSquares(numberList, indexList, index + 1);
                } else {
                    if (isSquareMagic(numberList)) {
                        printSquare(numberList);
                    }
                }
                indexList[counter] = 0;
            }
        }
    }

    /**
     * This function determines whether or not a square is a magic square.
     * @param squareList
     * @return
     * returns list
     */
    static boolean isSquareMagic(final int[] squareList) {
        int firstRow = squareList[0] + squareList[1] + squareList[2];
        int secondRow = squareList[THREE] + squareList[FOUR] + squareList[FIVE];
        int thirdRow = squareList[SIX] + squareList[SEVEN] + squareList[EIGHT];
        int firstColumn = squareList[0] + squareList[THREE] + squareList[SIX];
        int secondColumn = squareList[1] + squareList[FOUR] + squareList[SEVEN];
        int thirdColumn = squareList[2] + squareList[FIVE] + squareList[EIGHT];
        int firstDiagonal = squareList[0] + squareList[FOUR] + squareList[EIGHT];
        int secondDiagonal = squareList[2] + squareList[FOUR] + squareList[SIX];

        return (firstRow == FIFTEEN && secondRow == FIFTEEN && thirdRow == FIFTEEN &&
            firstColumn == FIFTEEN && secondColumn == FIFTEEN &&
            thirdColumn == FIFTEEN &&
            firstDiagonal == FIFTEEN && secondDiagonal == FIFTEEN);
    }

    /**
     * This function passes variables into a function 
     * 3 by 3 magic number sets that add to 15.
     * @param args
     */
    public static void main(final String[] args) {
        int[] firstList = {
            1,
            2,
            THREE,
            FOUR,
            FIVE,
            SIX,
            SEVEN,
            EIGHT,
            NINE
        };
        int[] secondList = {
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0
        };


        System.out.println("*****");

        solveSquares(firstList, secondList, 1);
    }
}
