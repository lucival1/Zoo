/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctZoo.models.animals.abstracts;

import cctZoo.models.Model;
import cctZoo.models.employees.zooKeeper.ZooKeeper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbsrafa
 */
public abstract class Animal extends Model{
    
    private static int lastId;
    private String species, name, gender, DOB, dateOfArrival;
    private boolean offspring = false;
    private ZooKeeper keeper;
    private Offspring offsprings;
    
    public Animal(String species, String name, String gender) {
        super(++lastId);
        this.species = species;
        this.name = name;
        this.gender = gender;
    }
    
    public Animal(String species, String gender) {
        super(++lastId);
        this.species = species;
        this.gender = gender;
    }
    public Animal(String species, String gender, Animal offspring1, Animal offspring2) {
        super(++lastId);
        this.species = species;
        this.gender = gender;
        offsprings = new Offspring(offspring1, offspring2);
    }
    public Animal(String species, String gender, Animal offspring1) {
        super(++lastId);
        this.species = species;
        this.gender = gender;
        offsprings = new Offspring(offspring1);
    }
    public Animal(String species, String gender, boolean offspring) {
        super(++lastId);
        this.species = species;
        this.gender = gender;
        this.offspring = offspring;
        
    }

    @Override
    public String toString() {
        return "Animal\n" +
               "------\n" +
               "Id: " + this.getId() + "\n" +
               "Species: " + this.species + "\n" +
               "Name: " + this.name + "\n" +
               "Gender: " + this.gender + "\n"+
               "Offspring: " + this.offspring + "\n"+
               "Keeper: " + this.keeper.getName() + "\n";
        
    }

    public static int getLastId() { return lastId; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDOB() { return DOB; }
    public void setDOB(String DOB) { this.DOB = DOB; }

    public String getDateOfArrival() { return dateOfArrival; }
    public void setDateOfArrival(String dateOfArrival) { this.dateOfArrival = dateOfArrival; }

    public boolean isOffspring() { return offspring;}
    public void setOffspring(boolean offspring) { this.offspring = offspring;}

    public ZooKeeper getKeeper() { return keeper; }
    public void setKeeper(ZooKeeper keeper) { this.keeper = keeper; }

    public Offspring getOffsprings() { return offsprings; }
    public void setOffsprings(Offspring offsprings) { this.offsprings = offsprings; }
    
    
    
    
    private class Offspring{
        
       private List<Animal> offspringList;
        
        public Offspring(Animal offspring1, Animal offspring2){
            this.offspringList = new ArrayList<>();
            offspringList.add(offspring1);
            offspringList.add(offspring2);
            
        }
        
        public Offspring(Animal offspring1){
            this.offspringList = new ArrayList<>();
            offspringList.add(offspring1);
            
        }

        public List<Animal> getOffspringList() { 
            return offspringList;
        }

        public void setOffspringList(List<Animal> offspringList) {
            this.offspringList = offspringList;
        }
 
    }
 
}
