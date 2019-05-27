package dunzo;

import java.util.ArrayList;

public class TextJustification {

	public ArrayList<String> getJustifiedText(String[] arr, int width) {
		if(arr == null || arr.length == 0)
			return null;
		
		ArrayList<String> result = new ArrayList<String>();
		
		String lineToBeJustified = "";
		for (int i = 0; i < arr.length; i++) {			
			if (width > lineToBeJustified.length() + arr[i].length())
				lineToBeJustified = lineToBeJustified.trim() + " " + arr[i];
			else {
				result.add(lineToBeJustified);
				lineToBeJustified = arr[i];
			}									
		}
		result.add(lineToBeJustified);
		
		// Apply rules for all lines except last
		for (int i = 0; i < result.size() - 1; i++) {
			String str = result.get(i);			
			int numSpacesInRight = width - str.length();
			
			int indexToReplace = 0;
			int after = 0;
			String strToSearch = " ";
			while (numSpacesInRight > 0) {
				
				indexToReplace = str.indexOf(strToSearch, after);
				after = indexToReplace + 2;
				str = str.substring(0, indexToReplace + 1) + " " + str.substring(indexToReplace + 1, str.length());
				
				numSpacesInRight--;
			}
			
			result.set(i, str);
		}
		
		return result;
	}
	
	public int getSpaceCount(String str) {
		int count = 0;
		str = str.trim();
		
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == ' ') {
				count++;
			}
		
		return count;
	}
	
	public static void main(String[] args) {
		TextJustification t = new TextJustification();
		String[] arr = {"This", "is", "a", "text", "justification"};
		System.out.println(t.getJustifiedText(arr, 16));
	}

}
