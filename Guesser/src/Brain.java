import java.util.*;

/*
 * @author Tom 
 * @version 1.0
 * 
 */
//we need to play the game by hand to help with the logic.

public class Brain {
	public static int questions; 
	public static int numberrange;
	public static int max;
	public static int min=0;
	public static int median;
	public static String YN;
	public static String checkOdd;
	public static boolean isOdd;
	
	public static int getQuestions(){
		//gets the number of questions
		System.out.println("Input the number of questions:");
		Scanner in = new Scanner(System.in);
		try { 
			questions = in.nextInt();
		
		}
		catch(Exception ex){
			questions=-1;
		}
		return questions;
	}
	
	public static void main(String[] args) {
		getQuestions();
		while(questions<1){
			System.out.println("input an integer bigger than or equal to 1");
			getQuestions();
		}
		// creates number range
		numberrange = (int)Math.pow(2, questions);
		max = numberrange-1;
		median = (max+min)/2; // median = numberrange/2;
		// gets whether the number is odd
		System.out.println("Pick a number between 0 and " + (numberrange-1));
		Scanner inString = new Scanner(System.in);
		System.out.println("Is your number odd?");
		checkOdd = inString.nextLine();
		//replace the following condition with
		//isOdd = (checkOdd.equals("y") || checkOdd.equals("Y");
		if(checkOdd.equals("y") || checkOdd.equals("Y")){
			isOdd=true;
		}
		else{
			isOdd=false;
			median+=1;
		}
		// finds the number and outputs it in the end
		for(int i=0;i<questions;i++){
			System.out.println("Is your number greater than " + median + "?");
			YN=inString.nextLine();
			if(YN.equals("y")){
				min=median+1;
				median=(max+min)/2;
				// in case if odd is true and number in median currently isn't odd or odd is false and number is median currently is odd
				//This correction will be simpliar if done after the for loop finishes
				if(isOdd && median%2 == 0){  //removed the ==true as not needed for boolean value
					median+=1;
				}
				else if( !isOdd && median%2 != 0){ //removed ==false
					median +=1;
				}
			}
			else if(YN.equals("n")){
				max=median-1;
				median=(max+min)/2;
				if(isOdd==true && median%2 == 0){
					median+=1;
				}
				else if(isOdd==false&& median%2 != 0){
					median +=1;
				}
			}
			// outputs the number
			if(i==questions-1){
				System.out.println("Is your number " + median + "?");
			}
		}
		
	}

}