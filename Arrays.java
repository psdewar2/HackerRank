import java.util.*;

public class Arrays {
	public static void main(String[] args) {
		
	}

	static int dynArray() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int numQueries = input.nextInt();
		List<List<Integer>> seqs = new ArrayList<List<Integer>>();
		int lastAns = 0;
		for (int i = 0; i < n; i++) {
			seqs.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < numQueries; i++) {
			int a = input.nextInt();
			int x = input.nextInt();
			int y = input.nextInt();
			x = (x ^ lastAns) % n;
			if (a == 1) {
				seqs.get(x).add(y);
			} else if (a == 2) {
				int index = y % seqs.get(x).size();
				lastAns = seqs.get(x).get(index);
				System.out.println(lastAns);
			}
		}
	}

	static int queryCount(String[] strArray, String str) {
		int count = 0;
		for (String currentStr : strArray) {
			if (str.equals(currentStr)) count++;
		}
		return count;
	}

	static int hourglass(int[][] array) {
        int row = array.length;
        int col = array[0].length; //asumption is # of rows = # of cols
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row - 2; i++) {
        	for (int j = 0; j < col - 2; j++) {
	        	int sum = 0;
	            sum +=  array[i][j] +
	                    array[i][j+1] +
	                    array[i][j+2] +
	                    array[i+1][j+1] + 
	                    array[i+2][j] +
	                    array[i+2][j+1] +
	                    array[i+2][j+2];
	            max = Math.max(max, sum);
        	}
        	
        }
        return max;
    }

	static String[] saySee(String[] input_strings) {
		String[] array = new String[input_strings.length];
		for (int x = 0; x < input_strings.length; x++) {
			array[x] = "";
            String input = input_strings[x];
            for (int i = 0; i < input.length(); i++) {
                int value = Character.getNumericValue(input.charAt(i));
                int count = 1;
                while (i < input.length() - 1 && input.charAt(i) == input.charAt(i+1)) {
                    count++;
                    i++;
                }
                array[x] += String.valueOf(count) + String.valueOf(value);
            }
        }
        return array;
	}
}