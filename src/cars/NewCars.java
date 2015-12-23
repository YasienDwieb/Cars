package cars;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


/**
 * @author Yasien
 * This is the <i><b>"NewCars"</b></i> Class.
 */
public class NewCars {
	/**
	 *The fields of the class 
	 */
	static String[] brand_new = new String[100];
	static String[] model_new = new String[100];
	static int[] price_new = new int[100];
	static int count_new = 0;

	/**
	 * Use this to add new items of "NewCars".
	 */
	public static void add_new() {		
		brand_new[count_new] = JOptionPane.showInputDialog("Enter the brand :");
		model_new[count_new] = JOptionPane.showInputDialog("Enter the model :");
		boolean check = false;
		while (!check) {
			try {
				price_new[count_new] = Integer.parseInt(JOptionPane
						.showInputDialog("Enter the price :"));
				check = true;
			} catch (NumberFormatException e) {

			}
		}
		count_new++;
	}

	/**
	 * Use this to search "NewCars" by brand only.
	 */
	public static void serach_brand_new() {
		String keyWord = JOptionPane.showInputDialog("Enter the brand :")
				.toLowerCase();
		String result = "";
		int[] arrayOfindex = new int[count_new];
		int count = 0;
		for (int i = 0; i < count_new; i++) {
			if (brand_new[i].equalsIgnoreCase(keyWord)) {
				arrayOfindex[count] = i;
				count++;
			}
		}
		if (count == 1) {
			JOptionPane.showMessageDialog(null, "CarBrand : "
					+ brand_new[arrayOfindex[0]] + "\nCar Model : "
					+ model_new[arrayOfindex[0]] + "\nCar Price : "
					+ price_new[arrayOfindex[0]]);

		} else if (count > 1) {
			String output = "Brand\t\tCarModel \t\t Car Price\n";
			for (int i = 0; i < count; i++) {
				output += brand_new[arrayOfindex[i]]
						+ model_new[arrayOfindex[i]]
						+ price_new[arrayOfindex[i]] + "\n";
			}
			JOptionPane.showMessageDialog(null, output);
		} // car not found
		else {
			JOptionPane.showMessageDialog(null,
					"Sorry ,This Brand is not found.");
		}
	}

	/**
	 * Use this to search "NewCars" by brand and model.
	 */
	public static void serach_brand_model_new() {
		String keyWord = JOptionPane.showInputDialog("Enter the brand :")
				.toLowerCase();
		String keyWord2 = JOptionPane.showInputDialog("Enter the model :")
				.toLowerCase();
		int[] arrayOfindex = new int[count_new];
		int[] temp = new int[count_new];
		int count = 0;
		int count2 = 0;
		for (int i = 0; i < count_new; i++) {
			if (brand_new[i] == keyWord) {
				temp[count] = i;
				count++;
				for (int j = 0; j < count; j++) {
					if (model_new[j] == keyWord2) {
						arrayOfindex[count2] = j;
						count2++;
					}
				}
			}
		}
		if (arrayOfindex.length == 1) {
			JOptionPane.showMessageDialog(null, "Car Brand : "
					+ brand_new[arrayOfindex[0]] + "\nCar Model : "
					+ model_new[arrayOfindex[0]] + "\nCar Price : "
					+ price_new[arrayOfindex[0]]);

		} else if (arrayOfindex.length > 1) {
			String output = "Brand\t\tCar Model \t\t Car Price\n";
			for (int i = 0; i < arrayOfindex.length; i++) {
				output += brand_new[arrayOfindex[i]]
						+ model_new[arrayOfindex[i]]
						+ price_new[arrayOfindex[i]] + "\n";
			}
			JOptionPane.showMessageDialog(null, output);
		} // car not found
		else {
			JOptionPane.showMessageDialog(null,
					"Sorry ,This Brand is not found.");
		}
	}

	/**
	 * Use this to search "NewCars" by price only.
	 */
	public static void search_price_new() {
		sort_price_new();
		String keyWord = JOptionPane.showInputDialog("Enter the UpperPrice :")
				.toLowerCase();
		String keyWord2 = JOptionPane.showInputDialog("Enter the LowerPrice :")
				.toLowerCase();
		int upper = Integer.parseInt(keyWord);
		int lower = Integer.parseInt(keyWord2);
		int[] temp = new int[2];
		int count = 0;
		int k = 0;
		for (; k < count_new; k++) {
			if (price_new[k] == upper) {
				temp[count] = k;
				count++;
				break;
			}
		}
		for (; k < count_new; k++) {
			if (price_new[k] == lower) {
				temp[count] = k;
				count++;
				break;
			}
		}
		int numberOfElements = temp[1] - temp[0] + 1;
		int[] arrayOfindex = new int[numberOfElements];
		for (int j = 0; j < numberOfElements; j++) {
			arrayOfindex[j] = temp[0] + j;
		}
		if (arrayOfindex.length == 1) {
			JOptionPane.showMessageDialog(null, "Car Brand : "
					+ brand_new[arrayOfindex[0]] + "\nCar Model : "
					+ model_new[arrayOfindex[0]] + "\nCar Price : "
					+ price_new[arrayOfindex[0]]);

		} else if (arrayOfindex.length > 1) {
			String output = "Brand\t\tCar Model \t\t Car Price\n";
			for (int i = 0; i < arrayOfindex.length; i++) {
				output += brand_new[arrayOfindex[i]]
						+ model_new[arrayOfindex[i]]
						+ price_new[arrayOfindex[i]] + "\n";
			}
			JOptionPane.showMessageDialog(null, output);
		} // car not found
		else {
			JOptionPane.showMessageDialog(null,
					"Sorry ,This Brand is not found.");
		}
	}

	/*
	 * //sort new by price public static void sort_price_new() { int[] temp =
	 * new int[price_new.length]; merge(price_new, temp, 0, price_new.length -
	 * 1); }
	 * 
	 * 
	 * static void merge(int[] a, int[] temp, int left, int right) {
	 * 
	 * if (left >= right) { return; } else { int mid = (left + right) / 2;
	 * merge(a, temp, left, mid); merge(a, temp, mid + 1, right); mergesort(a,
	 * temp, left, right); }
	 * 
	 * }
	 * 
	 * static void mergesort(int[] a, int[] temp, int left, int right) { int mid
	 * = (left + right) / 2; int count = right - left + 1;
	 * 
	 * int l = left; // counter indexes for L, R int r = mid + 1;
	 * 
	 * // main loop to copy the halves into the temp array for (int i = 0; i <
	 * count; i++) { if (r > right) { // finished right; use left temp[i] =
	 * a[l]; l++; } else if (l > mid) { // finished left; use right temp[i] =
	 * a[r]; r++; } else if (a[l] < a[r]) { // left is smaller (better) temp[i]
	 * = a[l]; l++; } else { // right is smaller (better) temp[i] = a[r]; r++; }
	 * }
	 * 
	 * // copy sorted temp array back into main array for (int i = 0; i < count;
	 * i++) { a[left + i] = temp[i]; } }
	 */
	
	/**
	 * This method is used for sorting prices in a descending order.
	 */
	public static void sort_price_new() {
		for (int i = 0; i < count_new; i++) {
			for (int j = 1; j < count_new - i; j++) {
				if (price_new[j - 1] < price_new[j]) {
					swap(price_new, j - 1, j);
					swap(brand_new, j - 1, j);
					swap(model_new, j - 1, j);
				}
			}
		}
	}

	/**
	 * We use this method to retrieve data from database we created.
	 */
	static void read_new() {
		BufferedReader dataIn;
		try {
			dataIn = new BufferedReader(new FileReader("newCars.txt"));
			String read;
			int k = 0;

			while ((read = dataIn.readLine()) != null) {
				StringTokenizer yd = new StringTokenizer(read, "+++++", false);
				int j = 1;
				while (yd.hasMoreTokens()) {
					switch (j) {
					case 1:
						brand_new[k] = yd.nextToken();
					case 2:
						model_new[k] = yd.nextToken();
					case 3:
						price_new[k] = Integer.parseInt(yd.nextToken());
						// default
						// :JOptionPane.showMessageDialog(null,"There is an error in the imported data!!!","Error",JOptionPane.ERROR_MESSAGE);
					}
					j++;
				}
				k++;
			}
			count_new = k;
		} catch (FileNotFoundException e) {
			int check2 = JOptionPane.showConfirmDialog(null,
					"Can't reach newcars database \n\t Create one ???",
					"Error", JOptionPane.OK_CANCEL_OPTION);
			if (check2 == JOptionPane.OK_OPTION) {
				File file = new File("newCars.txt");
			}
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(null, "Error", "Error",
					JOptionPane.OK_OPTION);
		}

	}

	/**
	 * We use this method to save data outside to a database.
	 */
	static void save_new() {
		File file = new File("newCars.txt");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(file, false));
			if (count_new == 0) {

			} else {
				for (int users = 0; users < count_new; users++) {
					writer.printf("%s%s%s", brand_new[users] + "+++++",
							model_new[users] + "+++++", price_new[users]);
					writer.println();
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			writer.close();
		}
	}

	/**
	 * @param a is the array to edit in and is a string array.
	 * @param x is the index to be edited in first.
	 * @param y whose value would be replaced in x index.
	 */
	static void swap(String[] a, int x, int y) {
		String temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	/**
	 * @param a is the array to edit in and is a int array.
	 * @param x is the index to be edited in first.
	 * @param y whose value would be replaced in x index.
	 */
	static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	/**
	 * @param a :here replace your array (integer).
	 * use this method to traverse an array and print its indexes values. 
	 */
	static void print(int[] a) {
		System.out.printf("{%d", a[0]);
		for (int i = 1; i < count_new; i++) {
			System.out.printf(", %d", a[i]);
		}
		System.out.println("}");
	}
}
