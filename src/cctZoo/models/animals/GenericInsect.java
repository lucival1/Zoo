package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Insect;

/**
 * Concrete Insect animal.
 * @author rbsrafa
 */
public class GenericInsect extends Animal implements Insect{
    
    /**
     * Insect animal class.
     * @param species
     * @param name
     * @param gender 
     */
    public GenericInsect(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    /**
     * Avian animal constructor.
     * @param species
     * @param gender 
     */
    public GenericInsect(String species, String gender) {
        super(species, gender);
    }
    
    /**
     * Avian animal constructor.
     * @param species
     * @param name
     * @param gender
     * @param doa
     * @param DOB 
     */
    public GenericInsect(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }

}
