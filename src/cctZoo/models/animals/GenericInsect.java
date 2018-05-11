package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Insect;

/**
 *
 * @author rbsrafa
 */
public class GenericInsect extends Animal implements Insect{
    
    public GenericInsect(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    public GenericInsect(String species, String gender) {
        super(species, gender);
    }
    
    public GenericInsect(String species, String name, String gender, String doa, String DOB){
        super(species, name, gender, doa, DOB);
    }

}
