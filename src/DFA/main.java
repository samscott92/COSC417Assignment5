package DFA;
import java.util.*;
/**
 * authors
 * Samuel Scott
 * Jathmel Gordon
 **/
public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] trans;
		int next;
		int x;
		int numStates;
		int[] accept;
		String lang;
		// gets the total amout of states in the dfa
		do{
		System.out.println("Enter amount of states at most 20");
		x = in.nextInt();
		}while(x>=20);
		trans = new int[2][x];
		// puts in the transitions for the states for 0's and 1's 
		for(int i = 0; i < x; i++){
			System.out.println("trans from state " + i +" with 0 ");
			next = in.nextInt();
			trans[0][i] = next;
			System.out.println("trans from state " + i +" with 1 ");
			next = in.nextInt();
			trans[1][i] = next;
		}
		System.out.println("how many accepting states are there");
		numStates = in.nextInt();
		System.out.println("Enter accepting states");
		accept = new int[numStates];
		for(int i = 0; i < numStates; i++){
			accept[i] = in.nextInt();
		}
		System.out.println("Enter the binary language");
		lang = in.next();
		
		if(compare(lang, trans, accept)){
			System.out.println("In the Lang.");
		}else
			System.out.println("not in Lang.");
	}
	private static boolean compare(String lang, int[][] trans, int[] accept){
		char next;
		int current = 0;
		int nextPos;
		int i;
		int[] postion = new int[20];
		//goes though the trans list and grabs the nextPos in the Dfa for the grammer
		for(i = 0; i < lang.length(); i++){
			next = lang.charAt(i);
			if(next == 0){
				nextPos = trans[0][current];
				postion[i] = nextPos;
				current = nextPos;
			}
			else{
				nextPos = trans[1][current];
				postion[i] = nextPos;
				current = nextPos;
			}
		}
		for(int j =0; j< accept.length; j++){
			if(postion[i] == accept[j]){
				return true;
			}
		}
		return false;
	}
	

}
