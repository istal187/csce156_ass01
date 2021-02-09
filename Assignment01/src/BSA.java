/**
 * This program calculates a peson's body surface area from command line
 * arguments of height in centimeters and weight in kilograms Returns the
 * average BSA from the three methods.
 * 
 * @author istal
 *
 */
public class BSA {

	public static void main(String args[]) {

		// Initialize the input variables
		double height = Double.parseDouble(args[0]);
		double weight = Double.parseDouble(args[1]);

		// Calculate the body surface area with each formula and find the average
		double duBois = Math.pow(((height * weight) / 3600), 0.5);
		double haycock = 0.024265 * Math.pow(height, 0.3964) * Math.pow(weight, 0.5378);
		double boyd = 0.0333 * Math.pow(height, 0.3) * Math.pow(weight, (0.6157 - (0.00816474 * Math.log(weight))));
		double avg = (duBois + haycock + boyd) / 3;

		// Output the results in a brief table
		System.out.println("  Patient:");
		System.out.println("    Weight: " + weight + " kg");
		System.out.println("    Height: " + height + " cm");
		System.out.println("  Formula      BSA (m^2)");
		System.out.println("  ---------    ---------");
		System.out.printf("  %-13s%.6f\n", "Du Bois", duBois);
		System.out.printf("  %-13s%.6f\n", "Haycock", haycock);
		System.out.printf("  %-13s%.6f\n", "Boyd", boyd);
		System.out.printf("  %-13s%.6f\n", "Average", avg);

	}

}