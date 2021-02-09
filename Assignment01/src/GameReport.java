import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GameReport {

	public static void main(String args[]) {

		String fileName = args[0];
		HashMap<String, ArrayList> publishers = new HashMap<>();
		HashMap<String, ArrayList> games = new HashMap<>();

		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
			while (s.hasNextLine()) {
				String line = s.nextLine();
				ArrayList<String> row = new ArrayList<String>();
				String[] items = line.split(",");
				for (int k = 0; k < items.length; k++) {
					row.add(items[k]);
				}

				// Map an array of each publisher's games into the publisher map
				if (!publishers.containsKey(row.get(1))) {
					ArrayList<String> gameList = new ArrayList<String>();
					publishers.put(row.get(1), gameList);
				}
				ArrayList<String> gameList = publishers.get(row.get(1));
				if (!gameList.contains(row.get(0)) && row.get(0).length() > 0) {
					gameList.add(row.get(0));
				}
				publishers.replace(row.get(1), gameList);

				// Map an array of each game's consoles to the games map
				int longestGame = 0;
				if (!games.containsKey(row.get(0)) && row.get(0).length() > 0) {
					ArrayList<String> consoleList = new ArrayList<>();
					games.put(row.get(0), consoleList);
					if (row.get(0).length() > longestGame) {
						longestGame = row.get(0).length();
					}
				}
				ArrayList<String> consoleList = games.get(row.get(0));
				if (row.size() > 2 && row.get(3).length() > 0) {
					consoleList.add(row.get(3));
				}
				games.replace(row.get(0), consoleList);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Print the number of games for each publisher 
		String sp = "    ";
		System.out.println(sp + "Publisher Game Counts");
		ArrayList<String> sortedPubs = new ArrayList<>(publishers.keySet());
		Collections.sort(sortedPubs);
		int longestPub = 0;
		for (String key : sortedPubs) {
			if (key.length() > longestPub) {
				longestPub = key.length();
			}
		}
		String equals = "";
		for (int h = 0; h < longestPub + 2; h++) {equals += "=";}
		System.out.println(sp + equals);
		int numGames = 0;
		for (String item : sortedPubs) {
			if (publishers.get(item).size() == 1) {
				if (publishers.get(item).get(0).toString().length() > 0) {
					numGames = publishers.get(item).size();
				}
			} else {
				numGames = publishers.get(item).size();
			}
			System.out.printf(sp + "%-" + (longestPub + 1) + "s%d\n", item, numGames);
		}
		
		// Print the number of consoles for each game
		System.out.println("\n" + sp + "Game Platform Counts");
		ArrayList<String> sortedGames = new ArrayList<>(games.keySet());
		Collections.sort(sortedGames);
		int longestGame = 0;
		for (String key : sortedGames) {
			if (key.length() > longestGame) {
				longestGame = key.length();
			}
		}
		equals = "";
		for (int h = 0; h < longestGame + 2; h++) {equals += "=";}
		System.out.println(sp + equals);
		int numConsoles = 0;
		for (String item : sortedGames) {
			if(games.get(item).size() == 1) {
				if(games.get(item).get(0).toString().length() > 0) {
					numConsoles = games.get(item).size();
				}
			}else {
				numConsoles = games.get(item).size();
			}
			System.out.printf(sp + "%-" + (longestGame + 1) + "s%d\n", item, numConsoles);
		}

	}

}