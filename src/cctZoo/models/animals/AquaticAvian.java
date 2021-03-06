package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;
import cctZoo.models.animals.interfaces.Avian;

/**
 * Concrete Aquatic Avian class.
 * @author rbsrafa
 * @author lucival1
 */
public class AquaticAvian extends Animal implements Aquatic, Avian{
    private boolean canFly = false;
    /**
     * Aquatic Avian constructor.
     * @param species
     * @param name
     * @param gender 
     */
    public AquaticAvian(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    /**
     * Aquatic Avian constructor
     * @param species
     * @param gender 
     */
    public AquaticAvian(String species, String gender) {
        super(species, gender);
    }
    
    /**
     * Aquatic Avian constructor
     * @param species
     * @param gender
     * @param offspring1
     * @param offspring2 
     */
    public AquaticAvian(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    /**
     * Aquatic Avian constructor
     * @param species
     * @param gender
     * @param offspring1 
     */
    public AquaticAvian(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    /**
     * Aquatic Avian constructor
     * @param species
     * @param gender
     * @param isOffspring 
     */
    public AquaticAvian(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }
    
    /**
     * Aquatic Avian constructor
     * @param species
     * @param name
     * @param gender
     * @param doa
     * @param DOB 
     */
    public AquaticAvian(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }
    
    /**
     * Aquatic Avian constructor
     * @param species
     * @param name
     * @param gender
     * @param DOB 
     */
    public AquaticAvian(String species, String name, String gender,String DOB){
        super(species, name, gender,DOB);
    }

    @Override
    public boolean canFly() {
        return this.canFly;
    }

    @Override
    public void setFly(boolean b){
        this.canFly = b;
    }
    
    /**
     * This method displays a single animal on CLI.
     * @return 
     */
    @Override
    public String toString() {
        return "Animal\n------\n" +
               "ID: " + this.getId() + "\n" +
               "Species: " + this.getSpecies() + "\n" +
               "Name: " + this.getName() + "\n" +
               "Gender: " + this.getGender() + "\n" +
               "Date of Arrival: " + this.getDateOfArrival() +"\n" +
               "Date of Birth: " + this.getDOB() + "\n" +
               "Vaccine:" +this.vaccines.toString()+ "\n" +
               "Medicated: " + this.isMedicated() + "\n" +
               "Offspring: " + this.getNumberOfOffspring() + "\n" +
               "Keeper: " + "ID - " + this.keeper.getId() + " " + this.keeper.getName() + "\n";     
    }
}
