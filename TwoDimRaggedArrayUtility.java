/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: A program calculate bonuses for retail stores in the Retail District#5. 
 * Due: 11/15/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Yei Thek Wang
*/

import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	public TwoDimRaggedArrayUtility() {

	}

	/**
	 * Reads from a file and returns a double 2D array. The maximum rows is 10 and
	 * the maximum columns for each row is 10.
	 * 
	 * @param file - the file to read from
	 * @return a 2D ragged (depending on data) array of doubles if the file is not
	 *         empty, returns a null if file is empty
	 * @throws java.io.FileNotFoundException
	 */
	public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException {

		String[][] strArray = new String[10][10];
		int rows = 0;

		Scanner fs = new Scanner(file);
		while (fs.hasNext()) {
			strArray[rows] = fs.nextLine().split("\\s");
			rows++;
		}
		fs.close();

		double[][] doubleArray = new double[rows][];

		for (int row = 0; row < rows; row++) {
			int cols = strArray[row].length;
			doubleArray[row] = new double[cols];
			for (int col = 0; col < cols; col++) {
				doubleArray[row][col] = Double.parseDouble(strArray[row][col]);
			}
		}
		return doubleArray;
	}

	/**
	 * Writes the ragged array of doubles into the file.
	 * 
	 * @param data       - the 2D array
	 * @param outputFile - the file to write to
	 * @throws java.io.FileNotFoundException - if outputFile is not valid
	 */
	public static void writeToFile(double[][] data, java.io.File outputFile) throws java.io.FileNotFoundException {
		PrintWriter wf = new PrintWriter(outputFile);

		for (int row = 0; row < data.length; row++) {
			String nextLine = "";
			for (int col = 0; col < data[row].length; col++) {
				nextLine += data[row][col] + " ";
			}
			wf.println(nextLine);
		}
		wf.close();

	}

	/**
	 * Returns the total of all the elements of the 2D array
	 * 
	 * @param data - the 2D array
	 * @return the sum of all the elements in the 2D array
	 */
	public static double getTotal(double[][] data) {
		double total = 0.0;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
		}
		return total;
	}

	/**
	 * Returns the average of the elements in the 2D array
	 * 
	 * @param data - the 2D array
	 * @return the average of the elements in the 2D array (total of elements/num of
	 *         elements)
	 */
	public static double getAverage(double[][] data) {
		double total = 0.0;
		int num = 0;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
				num++;
			}
		}
		return total / num;
	}

	/**
	 * Returns the total of the selected row in the 2D array index 0 refers to the
	 * first row.
	 * 
	 * @param data - the 2D array
	 * @param row  - the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;

		for (int col = 0; col < data[row].length; col++) {
			total += data[row][col];
		}

		return total;
	}

	/**
	 * Returns the total of the selected column in the 2D array index 0 refers to
	 * the first column. If a row in the 2D array doesn't have this column index, it
	 * is not an error, it doesn't participate in this method.
	 * 
	 * @param data - the 2D array
	 * @param col  - the column index to take the total of (0 refers to the first
	 *             column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0.0;

		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				total += data[row][col];
			}
		}

		return total;
	}

	/**
	 * Returns the largest element of the selected row in the 2D array index 0
	 * refers to the first row.
	 * 
	 * @param data - the 2D array
	 * @param row  - the row index to find the largest element.
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highestRowVal = 0.0;

		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] > highestRowVal) {
				highestRowVal = data[row][col];
			}
		}

		return highestRowVal;
	}

	/**
	 * Returns the largest element of the selected row in the 2D array index 0
	 * refers to the first row.
	 * 
	 * @param data - the 2D array
	 * @param row  - the row index to find the largest element.
	 * @return the index of the largest element of the row.
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highestRowVal = 0.0;
		int highestRowIdx = 0;

		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] > highestRowVal) {
				highestRowVal = data[row][col];
				highestRowIdx = col;
			}
		}

		return highestRowIdx;
	}

	/**
	 * Returns the smallest element of the selected row in the 2D array index 0
	 * refers to the first row.
	 * 
	 * @param data - the 2D array
	 * @param row  - the row index to find the smallest element.
	 * @return the smallest element of the row.
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowestRowVal = Double.MAX_VALUE;

		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] < lowestRowVal) {
				lowestRowVal = data[row][col];
			}
		}
		return lowestRowVal;
	}

	/**
	 * Returns the index of the smallest element of the selected row in the two
	 * dimensional array index 0 refers to the first row.
	 * 
	 * @param data - the 2D array
	 * @param row  - the row index to find the smallest element.
	 * @return the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowestRowVal = Double.MAX_VALUE;
		int lowestRowIdx = 0;

		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] < lowestRowVal) {
				lowestRowVal = data[row][col];
				lowestRowIdx = col;
			}
		}
		return lowestRowIdx;
	}

	/**
	 * Returns the largest element of the selected column in the 2D array index 0
	 * refers to the first column. If a row in the 2D array doesn't have this column
	 * index, it is not an error, it just does not take part in this approach.
	 * 
	 * @param data - the 2D array
	 * @param col  - the column index to find the largest element.
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highestColVal = 0.0;

		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] > highestColVal) {
					highestColVal = data[row][col];
				}
			}
		}
		return highestColVal;
	}

	/**
	 * Returns index of the largest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it just does not take part in this approach.
	 * 
	 * @param data - the 2D array
	 * @param col  - the column index to find the largest element.
	 * @return the index of the largest element of the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highestColVal = 0.0;
		int highestColIdx = 0;

		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] > highestColVal) {
					highestColVal = data[row][col];
					highestColIdx = row;
				}
			}
		}
		return highestColIdx;
	}

	/**
	 * Returns the smallest element of the selected column in the 2D array index 0
	 * refers to the first column. If a row in the 2D array doesn't have this column
	 * index, it is not an error, it just does not take part in this approach.
	 * 
	 * @param data - the 2D array
	 * @param col  - the column index to find the smallest element.
	 * @return the smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowestColVal = Double.MAX_VALUE;

		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] < lowestColVal) {
					lowestColVal = data[row][col];
				}
			}
		}
		return lowestColVal;
	}

	/**
	 * Returns the index of the smallest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it just does not take part in this approach.
	 * 
	 * @param data - the 2D array
	 * @param col  - the column index to find the smallest element.
	 * @return the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowestColVal = Double.MAX_VALUE;
		int lowestColIdx = 0;

		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] < lowestColVal) {
					lowestColVal = data[row][col];
					lowestColIdx = row;
				}
			}
		}
		return lowestColIdx;
	}

	/**
	 * Returns the largest element in the 2D array
	 * 
	 * @param data - the 2D array
	 * @return the largest element in the 2D array
	 */
	public static double getHighestInArray(double[][] data) {
		double highestVal = 0.0;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] > highestVal) {
					highestVal = data[row][col];
				}
			}
		}
		return highestVal;
	}

	/**
	 * Returns the smallest element in the 2D array.
	 * 
	 * @param data - the 2D array
	 * @return the smallest element in the 2D array.
	 */
	public static double getLowestInArray(double[][] data) {
		double lowestVal = Double.MAX_VALUE;

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] < lowestVal) {
					lowestVal = data[row][col];
				}
			}
		}
		return lowestVal;
	}
}