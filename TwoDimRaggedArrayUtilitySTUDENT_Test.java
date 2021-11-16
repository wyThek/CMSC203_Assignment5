

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSet = {{700.20,2.50,996.30},{555.9,65.90},{84.1,100.7,34.3},{110.6,65.9,744.3,23.7},{-499.2,72.3,-53.9,222.6}};

	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSet = null;
		inputFile = outputFile = null;
	}
	/**
	 * Test getTotal method
	 * Returns the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(3226.20,TwoDimRaggedArrayUtility.getTotal(dataSet),.001);
	}

	/**
	 * Test getAverage method
	 * Returns the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(201.6375,TwoDimRaggedArrayUtility.getAverage(dataSet),.001);
	}

	
	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(1699,TwoDimRaggedArrayUtility.getRowTotal(dataSet,0),.001);
		assertEquals(621.80,TwoDimRaggedArrayUtility.getRowTotal(dataSet,1),.001);
		assertEquals(219.10,TwoDimRaggedArrayUtility.getRowTotal(dataSet,2),.001);
		assertEquals(944.50,TwoDimRaggedArrayUtility.getRowTotal(dataSet,3),.001);
		assertEquals(-258.20,TwoDimRaggedArrayUtility.getRowTotal(dataSet,4),.001);
	}
	

	/**
	 * Test getColumnTotal method
	 * Returns the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(951.60,TwoDimRaggedArrayUtility.getColumnTotal(dataSet,0),.001);
		assertEquals(307.30,TwoDimRaggedArrayUtility.getColumnTotal(dataSet,1),.001);
		assertEquals(1721,TwoDimRaggedArrayUtility.getColumnTotal(dataSet,2),.001);
		assertEquals(246.30,TwoDimRaggedArrayUtility.getColumnTotal(dataSet,3),.001);
	}
	

	/**
	 * Test getHighestInRow method
	 * Returns the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRow() {
		assertEquals(996.30,TwoDimRaggedArrayUtility.getHighestInRow(dataSet,0),.001);
		assertEquals(555.9,TwoDimRaggedArrayUtility.getHighestInRow(dataSet,1),.001);
		assertEquals(100.7,TwoDimRaggedArrayUtility.getHighestInRow(dataSet,2),.001);
		assertEquals(744.3,TwoDimRaggedArrayUtility.getHighestInRow(dataSet,3),.001);
	}
	/**
	 * Test getHighestInRowIndex method
	 * Returns the index of the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet,0));
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet,1));
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet,2));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet,3));
	}
	
	/**
	 * Test getLowestInRowIndex method
	 * Returns the index of the smallest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet,0));
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet,1));
		assertEquals(2,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet,2));
		assertEquals(3,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet,3));
	}

	/**
	 * Test getLowestInRow method
	 * Returns the smallest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetLowestInRow() {
		assertEquals(2.50,TwoDimRaggedArrayUtility.getLowestInRow(dataSet,0),.001);
		assertEquals(65.90,TwoDimRaggedArrayUtility.getLowestInRow(dataSet,1),.001);
		assertEquals(34.3,TwoDimRaggedArrayUtility.getLowestInRow(dataSet,2),.001);
		assertEquals(23.7,TwoDimRaggedArrayUtility.getLowestInRow(dataSet,3),.001);
	}

	/**
	 * Test getHighestInColumn method
	 * Returns the largest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetHighestInColumn() {
		assertEquals(700.20,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet,0),.001);
		assertEquals(100.7,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet,1),.001);
		assertEquals(996.30,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet,2),.001);
		assertEquals(222.6,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet,3),.001);
	}
	/**
	 * Test getHighestInColumn method
	 * Returns the index of the largest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet,0));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet,1));
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet,2));
		assertEquals(4,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet,3));
	}
	/**
	 * Test getLowestInColumn method
	 * Returns the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumn() {
		assertEquals(-499.2,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet,0),.001);
		assertEquals(2.50,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet,1),.001);
		assertEquals(-53.9,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet,2),.001);
		assertEquals(23.7,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet,3),.001);
	}
	/**
	 * Test getLowestInColumnIndex method
	 * Returns the index of the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(4,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet,0));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet,1));
		assertEquals(4,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet,2));
		assertEquals(3,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet,3));
	}
	/**
	 * Test getHighestInArray method
	 * Returns the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(996.30,TwoDimRaggedArrayUtility.getHighestInArray(dataSet),.001);
	}

	/**
	 * Test getLowestInArray method
	 * Returns the smallest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetLowestInArray() {
		assertEquals(-499.2,TwoDimRaggedArrayUtility.getLowestInArray(dataSet),.001);
	}

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSet, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(700.20, array[0][0],.001);
		assertEquals(2.50, array[0][1],.001);
		assertEquals(996.30, array[0][2],.001);
		assertEquals(555.90, array[1][0],.001);
		assertEquals(65.90, array[1][1],.001);
		assertEquals(84.10, array[2][0],.001);
		assertEquals(100.70, array[2][1],.001);
		assertEquals(34.30, array[2][2],.001);
		assertEquals(110.60, array[3][0],.001);
		assertEquals(65.90, array[3][1],.001);
		assertEquals(744.30, array[3][2],.001);
		assertEquals(23.70, array[3][3],.001);
		assertEquals(-499.2, array[4][0],.001);
		assertEquals(72.3, array[4][1],.001);
		assertEquals(-53.9, array[4][2],.001);
		assertEquals(222.6, array[4][3],.001);
	}
	
	/**
	 * Test the readFile method
	 * reads from a file and then test that the returned two dimensional array of doubles
	 * is ragged.
	 */
	@Test
	public void testReadFile() {
		double[][] array=null;
		try {
			inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("700.20 2.50 996.30\n" +
					"555.90 65.90\n" +
					"84.10 100.70 34.30\n" +
					"110.60 65.90 744.30 23.70\n"+
					"-499.2 72.3 -53.9 222.6");
			inFile.close();
			array = TwoDimRaggedArrayUtility.readFile(inputFile);
			assertEquals(700.20, array[0][0],.001);
			assertEquals(2.50, array[0][1],.001);
			assertEquals(996.30, array[0][2],.001);
			assertEquals(555.90, array[1][0],.001);
			assertEquals(65.90, array[1][1],.001);
			assertEquals(84.10, array[2][0],.001);
			assertEquals(100.70, array[2][1],.001);
			assertEquals(34.30, array[2][2],.001);
			assertEquals(110.60, array[3][0],.001);
			assertEquals(65.90, array[3][1],.001);
			assertEquals(744.30, array[3][2],.001);
			assertEquals(23.70, array[3][3],.001);
			assertEquals(-499.2, array[4][0],.001);
			assertEquals(72.3, array[4][1],.001);
			assertEquals(-53.9, array[4][2],.001);
			assertEquals(222.6, array[4][3],.001);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an FileNotFoundException");
		}

		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[1][2],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}

		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[5][5],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}
	}
	
	
}