package Lesson02;

public class MyArraySizeException extends RuntimeException{
    private int numOfRows;
    private int minNumOfColumns;
    private int maxNumOfColumns;
    private int sum;

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getMinNumOfColumns() {
        return minNumOfColumns;
    }

    public int getMaxNumOfColumns() {
        return maxNumOfColumns;
    }

    public MyArraySizeException(String message, int numOfRows, int minNumOfColumns, int maxNumOfColumns) {
        super(message);
        this.numOfRows = numOfRows;
        this.minNumOfColumns = minNumOfColumns;
        this.maxNumOfColumns = maxNumOfColumns;
    }
}
