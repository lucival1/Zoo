/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Aquatic;

/**
 *
 * @author rbsrafa
 */
public class GenericAquatic extends Animal implements Aquatic{
    
    public GenericAquatic(String species, String name, String gender) {
        super(species, name, gender);
    }
    
    public GenericAquatic(String species, String gender) {
        super(species, gender);
    }
    
    public GenericAquatic(String species, String gender, Animal offspring1, Animal offspring2) {
        super(species, gender, offspring1, offspring2);
    }
    
    public GenericAquatic(String species, String gender, Animal offspring1) {
        super(species, gender, offspring1);
    }
    
    public GenericAquatic(String species, String gender, boolean isOffspring) {
        super(species, gender, isOffspring);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
