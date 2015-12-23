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
 * This is the <b><I>"UsedCars"</i></b> Class.
 *
 */
public class UsedCars {
	
	/**
	 * This is the fields of the UsedCars class.
	 */
	static String[] brand_used = new String[100];
	static String[] model_used = new String[100];
	static int[] price_used = new int[100];
	static int[] year_used = new int[100];
	static String[] contact_used = new String[100];
	static int count_used = 0;
	static boolean check = false;

	// used methods
	
	/**
	 * Use this to add new items of "UsedCars".
	 */
	public static void add_used() {
		brand_used[count_used] = JOptionPane
				.showInputDialog("Enter the brand :");
		model_used[count_used] = JOptionPane
				.showInputDialog("Enter the model :");

		while (!check) {
			try {
				price_used[count_used] = Integer.parseInt(JOptionPane
						.showInputDialog("Enter the price :"));
				check = true;
			} catch (NumberFormatException e) {
			}
		}
		while (!check) {
			try {
				year_used[count_used] = Integer.parseInt(JOptionPane
						.showInputDialog("Enter the price :"));
				check = true;
			} catch (NumberFormatException e) {
			}
		}
		contact_used[count_used] = JOptionPane
				.showInputDialog("Enter the Owner's Contact :");
		count_used++;
	}

	/*
	 * //sort used by price public static void sort_price_used() { int[] temp =
	 * new int[price_used.length]; merge(price_new, temp, 0, price_used.length -
	 * 1); }
	 * 
	 * //sort used by year public static void sort_year_used() { int[] temp =
	 * new int[price_used.length]; merge(year_used, temp, 0, year_used.length -
	 * 1);
	 * 
	 * }
	 */

	/**
	 * Use this method to sort <b>UsedCars</b> by price. 
	 */
	public static void sort_price_used() {
		for (int i = 0; i < count_used; i++) {
			for (int j = 1; j < count_used - i; j++) {
				if (price_used[j - 1] > price_used[j]) {
					swap(price_used, j - 1, j);
					swap(brand_used, j - 1, j);
					swap(model_used, j - 1, j);
					swap(year_used, j - 1, j);
					swap(contact_used, j - 1, j);
				}
			}
		}
	}

	/**
	 * Use this method to sort UsedCars by thr year of production.
	 */
	public static void sort_year_used() {
		for (int i = 0; i < count_used; i++) {
			for (int j = 1; j < count_used - i; j++) {
				if (year_used[j - 1] > year_used[j]) {
					swap(year_used, j - 1, j);
					swap(price_used, j - 1, j);
					swap(brand_used, j - 1, j);
					swap(model_used, j - 1, j);
					swap(contact_used, j - 1, j);
				}
			}
		}
	}

	/**
	 * Use this to search "UsedCars" by brand only.
	 */
	public static void serach_brand_used() {
		String keyWord = JOptionPane.showInputDialog("Enter the brand :")
				.toLowerCase();
		int[] arrayOfindex = new int[count_used];
		int count = 0;
		for (int i = 0; i < count_used; i++) {
			if (brand_used[i].equalsIgnoreCase(keyWord)) {
				arrayOfindex[count] = i;
				count++;
			}
		}
		if (count == 1) {
			JOptionPane.showMessageDialog(null, "Car Brand : "
					+ brand_used[arrayOfindex[0]] + "\nCar Model : "
					+ model_used[arrayOfindex[0]] + "\nCar Price : "
					+ price_used[arrayOfindex[0]] + "\nCar year : "
					+ year_used[arrayOfindex[0]] + "\nContact Of Owner : "
					+ contact_used[arrayOfindex[0]]);

		} else if (count > 1) {
			String output = "Brand\t\tCar Model \t\t Car Price \t\t Year \t\t Contact\n";
			for (int i = 0; i < count; i++) {
				output += brand_used[arrayOfindex[i]]
						+ model_used[arrayOfindex[i]]
						+ price_used[arrayOfindex[i]]
						+ year_used[arrayOfindex[i]]
						+ contact_used[arrayOfindex[i]] + "\n";
			}
			JOptionPane.showMessageDialog(null, output);
		} // car not found
		else {
			JOptionPane.showMessageDialog(null,
					"Sorry ,This Brand is not found.");
		}
	}

	/**
	 * Use this to search "UsedCars" by price only.
	 */
	public static void search_price_used() {
		sort_price_used();
		String keyWord = JOptionPane.showInputDialog("Enter the UpperPrice :")
				.toLowerCase();
		String keyWord2 = JOptionPane.showInputDialog("Enter the LowerPrice :")
				.toLowerCase();
		int upper = Integer.parseInt(keyWord);
		int lower = Integer.parseInt(keyWord2);
		int[] temp = new int[count_used];
		int count = 0;
		int k = 0;
		int[] arrayOfindex = new int[count_used];
		for (; k < count_used; k++) {
			if (price_used[k] == lower) {
				temp[count] = k;
				count++;
				break;
			}
		}
		for (; k < count_used; k++) {
			if (price_used[k] == upper) {
				temp[count] = k;
				count++;
				break;
			}
		}
		for (int j = 0; j < temp.length; j++) {
			arrayOfindex[j] = temp[0] + j;
		}
		if (count == 1) {
			JOptionPane.showMessageDialog(null, "Car Brand : "
					+ brand_used[arrayOfindex[0]] + "\nCar Model : "
					+ model_used[arrayOfindex[0]] + "\nCar Price : "
					+ price_used[arrayOfindex[0]] + "\nCar year : "
					+ year_used[arrayOfindex[0]] + "\nContact Of Owner : "
					+ contact_used[arrayOfindex[0]]);

		} else if (count > 1) {
			String output = "Brand\t\tCar Model \t\t Car Price \t\t Year \t\t Contact\n";
			for (int i = 0; i < count; i++) {
				output += brand_used[arrayOfindex[i]]
						+ model_used[arrayOfindex[i]]
						+ price_used[arrayOfindex[i]] + "\n";
			}
			JOptionPane.showMessageDialog(null, output);
		} // car not found
		else {
			JOptionPane.showMessageDialog(null,
					"Sorry ,This Brand is not found.");
		}
	}

	/**
	 * We use this method to retrieve data from database we created.
	 */
	static void read_used() {
		BufferedReader dataIn;
        try {
            dataIn = new BufferedReader(new FileReader("usedCars.txt"));
            String read;
            int k = 0;

            while ((read = dataIn.readLine()) != null) {
                StringTokenizer yd = new StringTokenizer(read, "+++++", false);
                int j = 1;
                while (yd.hasMoreTokens()) {
                    switch (j) {
					case 1:
						brand_used[k] = yd.nextToken();
					case 2:
						model_used[k] = yd.nextToken();
					case 3:
						price_used[k] = Integer.parseInt(yd.nextToken());
					case 4:
						year_used[k] = Integer.parseInt(yd.nextToken());
					case 5:
						contact_used[k] = yd.nextToken();
                        //default :JOptionPane.showMessageDialog(null,"There is an error in the imported data!!!","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    j++;
                }
                k++;
            }
            count_used = k;
        } catch (FileNotFoundException e) {
            int check2 = JOptionPane.showConfirmDialog(null, "Can't reach usedcars database \n\t Create one ???", "Error", JOptionPane.OK_CANCEL_OPTION);
            if (check2 == JOptionPane.OK_OPTION) {
                File file = new File("usedCars.txt");
            }
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(null, "Error", "Error", JOptionPane.OK_OPTION);
        }
    }

	/**
	 * We use this method to save data outside to a database.
	 */
	static void save_used() {
		File file = new File("usedCars.txt");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(file, false));
			if (count_used == 0) {

			} else {
				for (int users = 0; users < count_used; users++) {
					writer.printf("%s%s%s%s%s", brand_used[users] + "+++++",
							model_used[users] + "+++++", price_used[users]
									+ "+++++", year_used[users] + "+++++",
							contact_used[users]);
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
}
