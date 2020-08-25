// Main Class File:  Main.java
// File:             LoanApprover.java
// Semester:         CS TA Training Fall 2020
//
// Author:           Taylor Mehmen tmehmen@wisc.edu
// CS Login:         tmehmen
// Lecturer's Name:  none
// Lab Section:      none
package cs245.mehmen;

import java.util.ArrayList;
import java.util.Scanner;

/**
 The application program, LoanApprover, processes user commands and maintains the list of unique, approved loan applicants.

 The main method of the LoanApprover class prompts the user to enter command options and processes them until the user types q for quit.
 *
 * <p>Bugs: Only accepts one word names
 *
 * @author Taylor Mehmen
 */
public class LoanApprover {
    private ArrayList<LoanApplicant> approvedApplicants;


    /**
     Constructor for LoanApprover object
     *
     * @param approvedApplicants ArrayList of LoanApplicants
     */
    public LoanApprover()
    {
        approvedApplicants = new ArrayList<LoanApplicant>();
    }



    /**
     creates a loop asking for commands until it gets a "q" command. Takes command "a" followed by
     name credit score and ratio. Also takes command "d" to display the list of Unique Approved applicants.
     *
     * @param command scanner for input
     * @param fullCommand used to hold entirety of the command
       @param startCommand first letter of the command used for if statements
     @param arrOfStr array of the split full command to get each separate string
     @param testApplicant current LoanApplicant object being tested to see if it will be added to list
     @param inList boolean value holding whether an applicant is in the list for the loop
     *
     * @return no return just print statements
     */
    public void main() {
        Scanner command = new Scanner(System.in); //get user input
        String fullCommand;
        String startCommand;
        do { //initiate loop
            System.out.println("Enter Your Command:");
            fullCommand = command.nextLine();
            String[] arrOfStr = fullCommand.split(" ", 0); //split input into array
            startCommand = arrOfStr[0].trim().toLowerCase();
            if (startCommand.equals("q")){ //check for quit input
                System.out.println("You are now quitting the program.");
            }
            else if (startCommand.equals("a")) //check for addition input
            {
                boolean inList = false;
                String name = arrOfStr[1]; //assign variables and convert to correct type
                int creditScore = Integer.parseInt(arrOfStr[2].trim());
                double ratio = Double.parseDouble(arrOfStr[3].trim());
                LoanApplicant testApplicant = new LoanApplicant(name,creditScore,ratio); //create new LoanApplicant with input
                if (testApplicant.getRate().equals("not approved")) //check for not approved
                {
                    System.out.println("The applicant is not approved");
                }
                else //loop to check for duplicate name
                {
                    for (int i = 0; i < approvedApplicants.size(); i++)
                    {
                        if (approvedApplicants.get(i).getName().equals(name))
                        {
                            inList=true;
                            System.out.println("That applicant is already on the list");
                        }

                    }
                    if (!inList) //check if in list
                    {
                        approvedApplicants.add(testApplicant); //add applicant
                        System.out.println("Applicant Added");
                    }
                }

            }
            else if (startCommand.equals("d")) //check for d value
            {
                for (int i = 0; i < approvedApplicants.size(); i++) //iterate through list and print name and rate line by line
                {
                    String name = approvedApplicants.get(i).getName();
                    String rate = approvedApplicants.get(i).getRate();
                    System.out.println("Name: "+name+" ,Rate: "+rate);
                }
            }
            else
            {
                System.out.println("You must enter a valid command: \"a\",\"d\", or \"q\""); //statement for invalid input
            }

        }
        while(!startCommand.equals("q")); //check for q
    }
}
