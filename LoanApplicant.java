// Main Class File:  Main.java
// File:             LoanApplication.java
// Semester:         CS TA Training Fall 2020
//
// Author:           Taylor Mehmen tmehmen@wisc.edu
// CS Login:         tmehmen
// Lecturer's Name:  none
// Lab Section:      none
package cs245.mehmen;

/**
 LoanApplicant is an object to hold data of different applicants as well as calculate their rate based on their data
 *
 * <p>Bugs: (a list of bugs and other problems)
 *
 * @author Taylor Mehmen
 */
public class LoanApplicant {
    private String name;
    private int score;
    private double ratio;

    /**
     constructor method for the LoanApplicant class which throws an exception if bad values are used
     *
     * @param name name of applicant String
     * @param score credit score of applicant int
     * @param ratio credit ratio of applicant double
     */

    public LoanApplicant(String name, int score, double ratio) throws IllegalArgumentException
    {
        if (ratio >= 0.0 && ratio <= 1.0 && score >= 300 && score <= 900) //check for bad values
        {
            this.name = name;
            this.score = score;
            this.ratio = ratio;
        }
        else
        {
            throw new IllegalArgumentException();
        }

    }

    /**
    returns name value
     *
     * @param name name of applicant
     * @return name
     */
    public String getName(){
      return name;
    }

    /**
     returns credit score value
     *
     * @param score  credit score of applicant
     * @return score
     */
    public int getCreditScore(){
        return score;
    }

    /**
     returns ratio value
     *
     * @param ratio credit ratio of applicant
     * @return ratio
     */
    public double getRatio(){
        return ratio;
    }

    /**
     returns the interest rate the applicant would receive based on credit score and credit ratio
     *
     * @param score score of applicant
     @param ratio ratio of applicant
     * @return name
     */
    public String getRate(){
        if (ratio < 0.3)
        {
            if (score < 620)
                return "not approved";
            else if (score < 680)
                return "5.0%";
            else if (score < 750)
                return "4.75%";
            else
                return "4.5%";

        }
        else if (ratio >= 0.3  && ratio <= 0.4)
        {
            if (score < 650)
                return "not approved";
            else if (score < 750)
                return "5.25%";
            else
                return "5.0%";
        }
        else
            {
                return "not approved";
            }
    }
}
