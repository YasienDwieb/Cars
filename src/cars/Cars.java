package cars;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Yasien
 * @version 1.0 This is the app that I made in the competeion.
 *This is the <i><b>Main</b></i> class.
 */
public class Cars {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// main shape appers to the used
		NewCars.read_new();
		UsedCars.read_used();
		JOptionPane.showMessageDialog(null, "Welcome to Cars app.");
		while (true) {
			String input1 = "";
			int choice1 = 0;
			String input2 = "";
			int choice2 = 0;
			String input3 = "";
			int choice3 = 0;
			boolean check = false;
			while (!check) {
				try {
					input1 = JOptionPane
							.showInputDialog("What type of cars are you looking for (1)New (2)Used");
					choice1 = Integer.parseInt(input1);
					check = true;
				} catch (NumberFormatException e) {

				}
			}
			switch (choice1) {
			// new methods
			case 1: {
				check = false;
				while (!check) {
					try {

						input2 = JOptionPane
								.showInputDialog("Please choose an option :\n\t\t (1)Add a car. (2)Seacrh for a car. (3)View cars sortd by price.");
						choice2 = Integer.parseInt(input2);
						check = true;
					} catch (NumberFormatException e) {
					}
				}
				switch (choice2) {
				case 1:
					NewCars.add_new();
					NewCars.save_new();
					break;
				case 2: {
					check = false;
					while (!check) {
						try {

							input3 = JOptionPane
									.showInputDialog("Search by :\n\t 1-Brand. 2-Barnd and model. 3-Price.");
							choice3 = Integer.parseInt(input3);
							check = true;
						} catch (NumberFormatException e) {

						}
					}
					switch (choice3) {
					case 1:
						NewCars.serach_brand_new();
						break;
					case 2:
						NewCars.serach_brand_model_new();
						break;
					case 3:
						NewCars.search_price_new();
						break;
					default:
						JOptionPane.showMessageDialog(null,
								"Please try a valid choice.");
					}
				}
					break;
				// view sortd list by price
				case 3: {
					NewCars.sort_price_new();
					NewCars.print(NewCars.price_new);
					break;
				}
				default:
					JOptionPane.showMessageDialog(null,
							"Please try a valid choice.");
					break;
				}
				break;
			}
			// used methods
			case 2: {
				check = false;
				while (!check) {
					try {
						input2 = JOptionPane
								.showInputDialog("What type of cars are you looking for (1)New (2)Used");
						choice2 = Integer.parseInt(input1);
						check = true;
					} catch (NumberFormatException e) {

					}
				}
				switch (choice2) {
				case 1:
					UsedCars.add_used();
					UsedCars.save_used();
					break;
				case 2: {
					check = false;
					while (!check) {
						try {
							input3 = JOptionPane
									.showInputDialog("What type of cars are you looking for (1)New (2)Used");
							choice3 = Integer.parseInt(input1);
							check = true;
						} catch (NumberFormatException e) {

						}
					}
					switch (choice3) {
					case 1:
						UsedCars.serach_brand_used();
						break;
					case 2:
						// serach_brand_model_new();
						break;
					case 3:
						UsedCars.search_price_used();
						break;
					default:
						JOptionPane.showMessageDialog(null,
								"Please try a valid choice.");
					}
				}
					break;
				// view sortd list by price
				case 3: {
					UsedCars.sort_price_used();
					break;
				}
				default:
					JOptionPane.showMessageDialog(null,
							"Please try a valid choice.");
					break;
				}
			}
			}
			int check2 = JOptionPane.showConfirmDialog(null,
					"Any more operations ?", "Confirm",
					JOptionPane.OK_CANCEL_OPTION);
			final ImageIcon icon = new ImageIcon(
					"C:\\Users\\Yasien\\Documents\\NetBeansProjects\\Cars\\smile.png");
			if (check2 != JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(null, "Thanks. visit us again.",
						"Good Bye", JOptionPane.INFORMATION_MESSAGE, icon);
				break;
			}
		}

	}

}
