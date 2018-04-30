package cctZoo.models.animals;

import cctZoo.models.animals.abstracts.AbstractAnimal;
import cctZoo.models.animals.interfaces.Animal;
import cctZoo.zooData.FileRW;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author rbsrafa
 */
public class AnimalFactory {
    private FileRW rw;
    
    /**
     * Default constructor
     */
    public AnimalFactory(){
        rw = new FileRW();
    }
    
    /**
     * This method returns a random animal.
     * @return 
     */
    public Animal getRandomAnimal(){
        Animal a = this.generateRandomAnimal();
        return a;
    }
    
    /**
     * This method generates and return a list of animals. 
     * The amount of animals is specified as an int argument.
     * @param amount
     * @return 
     */
    public List<Animal> getRandomAnimals(int amount){
        List<Animal> animals = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            animals.add(this.generateRandomAnimal());
        }
        return animals;
    }
    
    /**
     * This method generates a return a random Animal.
     * @return 
     */
    private Animal generateRandomAnimal(){
        Animal a = null;
        Random rand = new Random();
        String[] gender = {"Male", "Female"};
        String[] species = {"Dolphin", "Whale", "Crocodile", "Penguin", "Dragonfly",
                            "Beetle", "Tiger", "Zebra", "Lion", "Snake", "Komodo Dragon",
                            "Seagull", "Owl", "Bat", "Shark", "Octopus", "Ant"};
        
        String specie = species[rand.nextInt(species.length)];
        
        if(specie.equals("Dolphin") || specie.equals("Whale")){
            a = new AquaticMammal(specie, gender[rand.nextInt(gender.length)]);
            
        }else if(specie.equals("Crocodile")){
            a = new AquaticReptile(specie, gender[rand.nextInt(gender.length)]);
            
        }else if(specie.equals("Penguin")){
            a = new AquaticAvian(specie, gender[rand.nextInt(gender.length)]);
            
        }else if(specie.equals("Dragonfly") || specie.equals("Beetle") || specie.equals("Ant")){
            a = new GenericInsect(specie, gender[rand.nextInt(gender.length)]);
            
        }else if(specie.equals("Tiger") || specie.equals("Zebra") || specie.equals("Lion")){
            a = new GenericMammal(specie, gender[rand.nextInt(gender.length)]);
            
        }else if(specie.equals("Snake") || specie.equals("Komodo Dragon")){
            a = new GenericReptile(specie, gender[rand.nextInt(gender.length)]);
            
        }else if(specie.equals("Seagull") || specie.equals("Owl")){
            a = new GenericAvian(specie, gender[rand.nextInt(gender.length)]);
            
        }else if(specie.equals("Bat")){
            a = new AvianMammal(specie, gender[rand.nextInt(gender.length)]);
            
        }else if(specie.equals("Shark") || specie.equals("Octopus")){
            a = new GenericAquatic(specie, gender[rand.nextInt(gender.length)]);
        }
              
        ((AbstractAnimal)a).setName(rw.getRandomName(((AbstractAnimal)a).getGender()));       
        
        return a;
    }
    
}