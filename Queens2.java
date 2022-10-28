import java.io.FileReader;
import java.lang.Math;
import java.util.*;
import java.util.Arrays;

/* Done by: Negib Sherif
 * Assignment 4
 * Due date: Nov 11, 2022
 * Course: COMP3201
 */
public class Queens2
{
    private static int boardSize = 12;

    /**  
    * Gets index of maximum number in an array
    * @param Integer array that will be iterated through to find the maximum number
    * @return the index of the maximum number in the array
    */ 
    private static int getMaxIndex (Integer[] array)
    {
        // the maximum value in the array to be calculated
        int max = 0;

        // the index value in the array to be calculated
        int index = 0;

        // Iterate through array to find the maximum element
        for (int i = 0; i < array.length; i++){
            // Check if current element in array is the maximum seen so far. 
            // Update max and index values if element is the maximum seen so far.  
            if (array[i] > max){
                max = array[i];
                index = i;
            }
        }
        return index; 
    }

    /**  
    * Gets hamming distance between two members of a population
    * @param Integer array containing all the genes of the fittest member
    * @param Integer array containing all the genes of the a member in the population
    * @return the hamming distance which is total number of differences between corresponding genes values.
    */ 
    private static int getHammingDistance (Integer[] member, Integer[] fittest_member)
    {
        // the hamming distance to be calculated
        int hamming_distance = 0;

        // Iterate through all the elements in a member of the population
        for (int i = 0; i < member.length; i++){
            // Increment hamming distance if corresponding gene values are different
            if (member[i] != fittest_member[i]){
                hamming_distance +=1;
            }
        }
        return hamming_distance; 
    }
    
    // ************************************************************************
    // ************ A. GENETIC DIVERSITY - CALCULATE MEAN HAMMING DISTANCE ****
    // ************************************************************************
    
    /* calculates a measure of genetic diversity
     * useful as a termination criterion (low diversity means convergence)
     * (see the pseudocode in the assignment module for how to calculate)
     * 
     * this method will take a population of genotypes as input and:
     *	a) identify the genotype with the highest fitness, then
     *  b) calculate the mean hamming distance to all other individuals
     *     in the population
     *  c) return that distance as a double
     *
     * in the event of there being two or more genotypes with the highest fitness,
     * you can choose any of those genotypes as the "fittest member"
     */
    public static double meanHamming(Integer[][] population)
    {
        int population_size = population.length;
        double cumulative_hamming_distance = 0;

    	// the mean hamming distance to be calculated
    	double distance = 0.0;

        // getting the fitness of each member in the population
    	Integer[] fitnesses = getFitnesses(population);
        
        // getting the index of the fittest member in the population
        int fittnest_member_index = getMaxIndex(fitnesses);
    	
        // iterate through all the members in the population
        for (int i = 0; i < population.length; i++){
            if (i!=fittnest_member_index){
                cumulative_hamming_distance += getHammingDistance(population[i], population[fittnest_member_index]);
            }
        }
        
        distance = cumulative_hamming_distance / (population_size -1);

        return distance;
    }
    
    
    // ************************************************************************
    // ************ B. TOURNAMENT PARENT SELECTION PART ONE *******************
    // ************    CHOOSING A RANDOM SET OF UNIQUE COMPETITORS ************
    // ************************************************************************
    
    /* a worker method for tournament parent selection
     * randomly chooses a set of t members from the population
     * 
     * @input: the size of the population
     * @output: a size t array of *unique* random integers from the interval
     *          [0, population size]
     *
     * Example: if populationSize = 10 and t = 3 then typical output is: 5,2,7
     */
    public static Integer[] chooseCompetitors(int populationSize, int tournamentSize)
    {
    	Integer[] competitors = new Integer[tournamentSize];
    	
    	// YOUR CODE GOES HERE
        // DUMMY CODE TO REMOVE:
        for (int index = 0; index < tournamentSize; index ++)
        {
        	competitors[index] = -1;
        }
        // END OF YOUR CODE
        
        return competitors;
    }
    
    
	// ************************************************************************
    // ************ C. TOURNAMENT PARENT SELECTION PART TWO *******************
    // ************    SELECTING THE BEST FROM A SET OF COMPETITORS ***********
    // ************************************************************************
    
    /* a worker method for tournament parent selection
     * chooses the fittest member from a set of t competitors
     * 
     * @input: a list of indices of competitors (see B above)
     * @input: the *entire* population of genotypes (so fitnesses can be
     *         measured)
     * @output: the population index of the fittest *competitor*
     *
     * Example: suppose a population of size 10
     *          suppose that five chosen competitors are at indices 1,4,5,3,6
     *          suppose their respective fitnesses are 60,42,56,62,38
     *          then the genotype at index 3 has best fitness (=62)
     *          so the method will return 3
     *
     * in the event of two or more competitors tying for highest fitness,
     * this method will randomly choose one of those competitors
     */
    public static int selectParent(Integer[] competitors, Integer[][] population)
    {
    	int bestCompetitor = 0;
    	
    	// YOUR CODE GOES HERE
    	
    	//DUMMY CODE
    	bestCompetitor = -1;
    	
        // END OF YOUR CODE
    	
    	return bestCompetitor;
    }
    
    
    // ************************************************************************
    // ************ D. (μ, λ) SURVIVOR SELECTION ******************************
    // ************************************************************************
    
    /* creates a new population through (μ, λ) survivor selection
     * given a required population of size n, and a set of children of size 2n,
     * this method will return the n fittest children as the new population
     * (see class slides & course text)
     */
    public static Integer[][] survivorSelection(Integer[][] children, int n)
    {
        Integer [][] newPopulation = new Integer [n][boardSize];
        
        // YOUR CODE GOES HERE
        // DUMMY CODE TO REMOVE:
        newPopulation [0] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        newPopulation [1] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        newPopulation [2] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        newPopulation [3] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        newPopulation [4] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        newPopulation [5] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        newPopulation [6] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        newPopulation [7] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        newPopulation [8] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        newPopulation [9] = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        // END OF YOUR CODE
        
        return newPopulation;
    }
    
    // ************************************************************************
    // ************ E.  SCRAMBLE MUTATION ************************************
    // ************************************************************************
    
    /* scrambles the order of a series of genes in the genotype
     * (see class slides & course text)
     */
    public static Integer[] scrambleMutate(Integer[] genotype, double p)
    {
    	// YOUR CODE GOES HERE
    	
        // END OF YOUR CODE
    	
        return genotype;
    }
    
    // ************ DO NOT EDIT OR DELETE THE METHOD BELOW! *******************
    
    // ************************************************************************
    // ************ GET THE FITNESS VALUES OF A POPULATION ********************
    // ************************************************************************
    
    // returns an array of fitnesses for a population
    private static Integer[] getFitnesses(Integer [][] population)
    {
        int popSize = population.length;
        Integer [] fitnesses = new Integer [popSize];
        
        for (int index = 0; index < popSize; index ++)
        {
            fitnesses[index] = Queens.fitness(population[index]);
        }
        
        return fitnesses;
    }
}