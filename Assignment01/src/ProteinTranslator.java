
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This code takes an input .txt file containing an 
 * RNA sequence and returns the amino acid codons.  
 * 
 * @author istal
 *
 */

public class ProteinTranslator {
	
	public static void main(String args[]) {
		
		// Load up the input file and get its DNA sequence
		String fileName = args[0];
		String dnaString = loadDna(fileName);
		dnaString.replace(" ", "");
		Map<String, Character> proteins = proteinMap;
		
		// Work through the DNA converting the trigrams into codons
		String aminos = "";
		int iterations = Math.floorDiv(dnaString.length(),3);
		for (int k=1; k < iterations; k++){
			String trigram = dnaString.substring(3*(k-1), 3*k);
			char codon = proteins.get(trigram);
			aminos += codon;
		}
		
		System.out.println(aminos);
		
	}
	
	// Load in the file to be converted from DNA to codons
	public static String loadDna(String name) {
		
		Scanner s = null;
		try {
			s = new Scanner(new File(name));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		String dna = s.nextLine();
		
		return dna;
	}

	// DNA trigrams mapped to the amino acid codons 
	public static final Map<String, Character> proteinMap = new HashMap<>();

	static {

		proteinMap.put("AAA", 'K');
		proteinMap.put("AAC", 'N');
		proteinMap.put("AAG", 'K');
		proteinMap.put("AAU", 'N');
		proteinMap.put("ACA", 'T');
		proteinMap.put("ACC", 'T');
		proteinMap.put("ACG", 'T');
		proteinMap.put("ACU", 'T');
		proteinMap.put("AGA", 'R');
		proteinMap.put("AGC", 'S');
		proteinMap.put("AGG", 'R');
		proteinMap.put("AGU", 'S');
		proteinMap.put("AUA", 'I');
		proteinMap.put("AUC", 'I');
		proteinMap.put("AUG", 'M');
		proteinMap.put("AUU", 'I');
		proteinMap.put("CAA", 'Q');
		proteinMap.put("CAC", 'H');
		proteinMap.put("CAG", 'Q');
		proteinMap.put("CAU", 'H');
		proteinMap.put("CCA", 'P');
		proteinMap.put("CCC", 'P');
		proteinMap.put("CCG", 'P');
		proteinMap.put("CCU", 'P');
		proteinMap.put("CGA", 'R');
		proteinMap.put("CGC", 'R');
		proteinMap.put("CGG", 'R');
		proteinMap.put("CGU", 'R');
		proteinMap.put("CUA", 'L');
		proteinMap.put("CUC", 'L');
		proteinMap.put("CUG", 'L');
		proteinMap.put("CUU", 'L');
		proteinMap.put("GAA", 'E');
		proteinMap.put("GAC", 'D');
		proteinMap.put("GAG", 'E');
		proteinMap.put("GAU", 'D');
		proteinMap.put("GCA", 'A');
		proteinMap.put("GCC", 'A');
		proteinMap.put("GCG", 'A');
		proteinMap.put("GCU", 'A');
		proteinMap.put("GGA", 'G');
		proteinMap.put("GGC", 'G');
		proteinMap.put("GGG", 'G');
		proteinMap.put("GGU", 'G');
		proteinMap.put("GUA", 'V');
		proteinMap.put("GUC", 'V');
		proteinMap.put("GUG", 'V');
		proteinMap.put("GUU", 'V');
		proteinMap.put("UAA", 'x');
		proteinMap.put("UAC", 'Y');
		proteinMap.put("UAG", 'x');
		proteinMap.put("UAU", 'Y');
		proteinMap.put("UCA", 'S');
		proteinMap.put("UCC", 'S');
		proteinMap.put("UCG", 'S');
		proteinMap.put("UCU", 'S');
		proteinMap.put("UGA", 'x');
		proteinMap.put("UGC", 'C');
		proteinMap.put("UGG", 'W');
		proteinMap.put("UGU", 'C');
		proteinMap.put("UUA", 'L');
		proteinMap.put("UUC", 'F');
		proteinMap.put("UUG", 'L');
		proteinMap.put("UUU", 'F');
	}

}
