import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class LotteryNumber {
	
	public static boolean yesPrompt(String reply){
		reply  = reply.toLowerCase();
		return reply.equals("yes") || reply.equals("y")?true:false;
	}
	
	public static boolean checkAlphaInput(String Str) {
	      for (int i = 0; i < Str.length(); i++) {
	         char c = Str.charAt(i);
	         if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
	            return false;
	         }
	      }
	      return true;
	   }

	public static String petName(){
		 String petName = "";
		 Scanner scan = new Scanner(System.in);
		 System.out.println("What is the name of your favorite pet?");
		 petName = scan.next();
		 while(checkAlphaInput(petName) == false){
			 System.out.println("Enter valid name: ");
			 petName = scan.next();
		 }
		// scan.close();
	     return petName;
	}
	public static int getPetAge(){
		 int petAge = 0;
		 String check;
		 Scanner scan = new Scanner(System.in);
		 
		 do {
		    System.out.println("What is the age of your favorite pet?");
	        check = scan.nextLine();

	     } while (!(check.matches("[0-9]+") && check.length() > 0));
	     petAge = Integer.parseInt(check);
	  //   scan.close();
	    return petAge;
	} 
	public static int getLuckyNumber(){
		 int luckyNum = 0;
		 String check;
		 Scanner scan = new Scanner(System.in);
		 do {
			 System.out.println("What is your lucky number?");
		        check = scan.nextLine();

		     } while (!(check.matches("[0-9]+") && check.length() > 0));
		 luckyNum = Integer.parseInt(check);
		// scan.close();
	     return luckyNum;
	}
	public static int getJerseyNumber(){
		 int jerseyNum = 0;
		 String check;
		 Scanner scan = new Scanner(System.in);
		 do {
			    System.out.println("What is the jersey number of your favorite quarterback?");
		        check = scan.nextLine();

		     } while (!(check.matches("[0-9]+") && check.length() > 0));
		 jerseyNum = Integer.parseInt(check);
	//	 scan.close();
	     return jerseyNum;
	}
	
	public static int getCarModelYear(){
		 int modelYear = 0;
		 String check;
		 Scanner scan = new Scanner(System.in);
		 do {
			    System.out.println("What is two-digit model year of their car?");
		        check = scan.nextLine();

		     } while (!(check.matches("[0-9]+") && check.length() > 0));
		 modelYear = Integer.parseInt(check);
		// scan.close();
	     return modelYear;
	}
	
	public static String getActorName(){
		 String actorName = "";
		 Scanner scan = new Scanner(System.in);
		 System.out.println("What is the first name of your favorite actor or actress?");
		 actorName = scan.next();
		 while(checkAlphaInput(actorName) == false){
			 System.out.println("Enter valid name: ");
			 actorName = scan.next();
		 }
		// scan.close();
	     return actorName;
	    
	}
	
	public static int UserRandomNumber(){
		Scanner scan = new Scanner(System.in);
		String check;
		int randomNumber = 0;
		
		 do {
			 System.out.println("Enter a random number between 1 and 50: ");
		        check = scan.nextLine();

		     } while (!(check.matches("[0-9]+") && check.length() > 0));
		 randomNumber = Integer.parseInt(check);
	//	 scan.close();
	     return randomNumber;
	     
	}
	
	public static int getRandomNumber(){
		Random rand = new Random();
		int min = 1;
		int max = 100;
		int randomNumber = min+rand.nextInt(max);
	    return randomNumber;
	}
	
	public static ArrayList<Integer>checkDuplicates(ArrayList<Integer>lottoNumber,int ball){
		System.out.println("Checking Duplicate Number");
		System.out.println(lottoNumber);
		
		if (lottoNumber.contains(ball)){			
			
			while(true){
				
				if (lottoNumber.contains(ball)){
					System.out.println("Duplicate Number " +ball);
					ball = ball*getRandomNumber();
					ball = checkrange(ball,1);
					System.out.println("REPLACED WITH " +ball);
				}else
					
				{
				    lottoNumber.add(ball);	
					break;
				}
				}
			
		}else
		{
			lottoNumber.add(ball);	
		}  
			   
		return lottoNumber;
	}
	
	public static void letsPlay(){
		   int petAge = 0;
		   String pet = "";
		   int luckyN = 0;
		   int jersey = 0;
		   int carYear = 0;
		   String actor = "";
		   String response = "";
		   int randN = 0;
		   Scanner scan = new Scanner(System.in);
		   
		   int magicBall = 0;
		   ArrayList<Integer> lottoNumbers = new ArrayList<Integer>(5);
		   
		   pet = petName();
		   System.out.println(pet);
		  
		   petAge = getPetAge();
		   System.out.println(petAge);
		 
		  luckyN = getLuckyNumber();
		  System.out.println(luckyN);
		  
		  System.out.println("Do you have a favorite quarterback?");
		  response = scan.next();
		  System.out.println(response);
		  response = response.toLowerCase();
		   while (!response.matches("n") && !response.matches("no") && !response.matches("yes") && !response.matches("y")) {
			  
			   System.out.println("Enter either yes or y or no or n");
			   response = scan.next();
			   response = response.toLowerCase();
		   }
		  if(yesPrompt(response)){
			 jersey = getJerseyNumber();
			 System.out.println(jersey);
		  }
		 
		  
		  carYear = getCarModelYear();
		  System.out.println(carYear);
		  
		  actor = getActorName();
		  System.out.println(actor);
		  
		  randN = UserRandomNumber();
		  System.out.println(randN);
		  
		  magicBall = getMagicball(jersey,luckyN);
		  System.out.println("Magic Ball " +magicBall);
		  
		  lottoNumbers = generateNumbers(pet,petAge,jersey,carYear, luckyN, actor,randN);
		  System.out.println(lottoNumbers);
		  Collections.sort(lottoNumbers);
		  System.out.printf("LottoNumbers: %d,%d,%d,%d,%d, Magic ball: %d\n", lottoNumbers.get(0),lottoNumbers.get(1),lottoNumbers.get(2),lottoNumbers.get(3),lottoNumbers.get(4), magicBall);
		  
		//  scan.close();
	}
	public static ArrayList<Integer>generateNumbers(String pName,int pAge, int jNum,int carM, int luckyN, String actorN, int userRN){
		   int ball1 = 0;
		   int ball2 = 0;
		   int ball3 = 0;
		   int ball4 = 0;
		   int ball5 = 0;
		   ArrayList<Integer> lottoNumber = new ArrayList<Integer>(5);
		 
		   ball1 = getFirstBall(pName);
		   System.out.println("First Ball " +ball1);
		   lottoNumber = checkDuplicates(lottoNumber,checkrange(ball1,1));
		   
		
		   ball2 = getSecondBall(carM,luckyN);
		   System.out.println("Second Ball " +ball2);
		   lottoNumber = checkDuplicates(lottoNumber,checkrange(ball2,1));
		   
		   
		   ball3 = getThirdBall(actorN);
		   System.out.println("Third Ball " +ball3);
		   lottoNumber = checkDuplicates(lottoNumber,checkrange(ball3,1));
		   
		   
		   ball4 = getFourthBall(jNum,pAge,luckyN,userRN);
		   System.out.println("Fourth Ball " +ball4);
		   lottoNumber = checkDuplicates(lottoNumber,checkrange(ball4,1));
		   
		   
		   ball5 = getFifthBall(pAge,carM);
		   System.out.println("Fifth Ball " +ball5);
		   lottoNumber = checkDuplicates(lottoNumber,checkrange(ball5,1));
		  
		   
		   return lottoNumber;
	}
	
	public static int getFirstBall(String pet){
		  char[] chars = pet.toCharArray();
		  return (int)(chars[2]);
	}
	
	public static int getSecondBall(int carM, int luckyN){
		  
		  return (carM + luckyN);
	}
	
	public static int getThirdBall(String actorN){
		  char[] chars = actorN.toCharArray();
		  return (int)(chars[1]);
	}
	
	public static int getFourthBall(int jNum, int pAge,int luckyN,int userRN ){
		int ball4 = 0;
		if (jNum != 0){
		   ball4= jNum + luckyN + pAge;
		 }
		else{
		   ball4 = getRandomNumber()-userRN;
		}
		 return ball4;
	}
	
	
	public static int getFifthBall(int pAge, int carM){
		
		  return (pAge + carM);
	}
	
	public static int getMagicball(int j, int l){
		int flag = 2;
		int ball = 0;
		if(j != 0){
		 ball = checkrange(j*getRandomNumber(),flag);
		}else{
		 ball = checkrange(l*getRandomNumber(),flag);
		}
		return ball;
	}
	
	public static int checkrange(int ball,int flag){
		int genball = 0;
		Random random = new Random();
		if (flag == 2){
			if (ball >=1 && ball <= 75){
				genball = ball;
		    }
			
			if( ball < 1){
			   while(ball < 1)
	          {
	            ball += 75;
	          }
			   System.out.println("Out of range:");
			   genball = ball;
			   System.out.println("New number: " +genball);
			}
         
			if(ball > 75){
	        // And  is a trick to instantly fix the high range.
				  System.out.println("Out of range:");
	              genball= random.ints(1,75).findFirst().getAsInt();
	              System.out.println("New number: " +genball);
			}
		}
		if( flag == 1){
			if (ball >=1 && ball <= 65){
				genball = ball;
			}
			if( ball < 1){
				   while(ball < 1)
		          {
		            ball += 65;
		          }
				   System.out.println("Out of range:");
				   genball = ball;
				   System.out.println("New number: " +genball);
				}
	         
				if(ball > 65){
		        // And  is a trick to instantly fix the high range.
					  System.out.println("Out of range:");
		             genball= random.ints(1,65).findFirst().getAsInt();
		             System.out.println("New number: " +genball);
				}
			
		  }
				
		return genball;
}
	
	
   public static void main(String[] args){
	   String name = "";
	   String response = "";
	   Scanner scan = new Scanner(System.in);
	   System.out.println("Please enter your name: ");
	   name = scan.next();
	   System.out.println("Hello " + name);
	   System.out.println("Do you wish to continue to the interactive portion?");
	   response = scan.next();
	   response = response.toLowerCase();
	   while (!response.matches("n") && !response.matches("no") && !response.matches("yes") && !response.matches("y")) {
		  
		   System.out.println("Enter either yes or y or no or n");
		   response = scan.next();
		   response = response.toLowerCase();
	   }
	   if(!yesPrompt(response)){
		  System.out.println("Please return later to complete the survey.");
	   }else
	   {
		 while(yesPrompt(response)){
		  letsPlay();
		  System.out.println("Would like to answer questions to generate another set of numbers?");
		  response = scan.next();
		  response = response.toLowerCase();
		   while (!response.matches("n") && !response.matches("no") && !response.matches("yes") && !response.matches("y")) {
			  
			   System.out.println("Enter either yes or y or no or n");
			   response = scan.next();
			   response = response.toLowerCase();
		   }
		  
		 }
		 System.out.println("Thank you and good luck");
	   }
	 //   scan.close();
   }
}
