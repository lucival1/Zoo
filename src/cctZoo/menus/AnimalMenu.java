package cctZoo.menus;

import cctZoo.controllers.AnimalsController;
import cctZoo.models.animals.AquaticAvian;
import cctZoo.models.animals.AquaticMammal;
import cctZoo.models.animals.AquaticReptile;
import cctZoo.models.animals.AvianMammal;

import cctZoo.models.animals.GenericAquatic;
import cctZoo.models.animals.GenericAvian;
import cctZoo.models.animals.GenericInsect;
import cctZoo.models.animals.GenericMammal;
import cctZoo.models.animals.GenericReptile;
import cctZoo.models.animals.abstracts.Animal;
import cctZoo.models.animals.interfaces.Avian;
import cctZoo.models.employees.zooKeeper.Qualification;
import cctZoo.views.AnimalView;
import cctZoo.zooData.DataFactory;
import cctZoo.zooData.ZooData;
import java.util.ArrayList;
import java.util.List;

/**
 * Animal Menu class
 * @author rbsrafa
 */
public class AnimalMenu extends Menu{
    private AnimalsController animals;
    DataFactory data;
    
    /**
     * Basic AnimalMenu constructor
     * @param zooData 
     */
    public AnimalMenu(ZooData zooData){
        super(zooData);
        this.animals = new AnimalsController(this.zooData.getAnimals(), new AnimalView());
        String[] options = {"Show Animals", "Add Animal", "Medicate Animal",
                            "Search Options", "Return to Main Menu", "Exit Program"};
        this.data = new DataFactory(zooData);
        this.setOptions(options);
        this.setTitle("Animal Menu");
        this.startMenu();
        
    }

    /**
     * This method is responsible for linking the menu options with their
     * respective actions.
     */
    @Override
    public void optionSelector() {
        System.out.println("\nPlease select an option:");
        int option = this.validate.checkForInt(in);
        switch(option){
            case 1: this.animals.display();
                break;
            case 2: this.addAnimal();
                break;
            case 3: this.medicateAnimal();
                break;
            case 4: new AnimalSearchMenu(this.zooData);
                break;
            case 5: new MainMenu(this.zooData);
                break;
            case 6: System.exit(0);
                break;
        }
    }
    
    /**
     * This method sets the animal medication to true;
     */
    public void medicateAnimal(){
        System.out.println("Please type the ID of the animal to medicate");
        Animal a = this.animals.findAnimal(this.validate.checkForInt(in));
        a.setMedicated(true);
        System.out.println("\nAnimal has been medicated.\n");
    }
    
    /**
     * Method to add an Animal to the table.
     */
    public void addAnimal(){
        List<Qualification> animalTypes = Qualification.getQualifications();
        
        Animal a = null;
        System.out.println("Type here animal informataion: ");
        System.out.println("-----------------------------");
        System.out.println("Enter Animal Specie: ");
        String specie = this.in.next();
        System.out.println("Enter Animal Name: ");
        String name = this.in.next();
        System.out.println("Enter Animal Gender");
        String gender = this.in.next();
        System.out.println("Enter date of arrival");
        String date = this.in.next();
        System.out.println("Enter date of birth");
        String dob = this.in.next();
        System.out.println("");
        List<Qualification> selectedTypes = this.chooseAnimalType();
        System.out.println("");
        a = createAnimal(specie, name, gender, date, dob, selectedTypes);
        data.assignKeeper(a);
        data.generateRandomlyVaccines(a);
        data.setMedication(a);
        this.animals.add(a);
  
        System.out.println("");
        System.out.println("Does this animal have offspring? (Y/N)");
        System.out.println("");      
        boolean answer = validate.checkForYes(in);
            System.out.println(a.getAnimalTypes());
            this.addOffSpring(a); 
            System.out.println(a);
        
        
    }
    
    /**
     * This method chooses the type of Animal, if it has one or two types.
     * @return 
     */
    private List chooseAnimalType(){
        List<Qualification> types = Qualification.getQualifications();
        List<Qualification> chosen = new ArrayList<>();
        for (int x = 0; x < 2; x++){
            System.out.println("Select a type:");
            chosen.add(types.remove(this.chooseOption(types)));
            if (x < 1){
                System.out.println("Would you like to add another one? (Y/N)");
                if(!validate.checkForYes(in)){
                    break;
                }               
            }
        }
        return chosen;
    }
    
    public Animal checkForOffSpring(boolean answer){
        Animal a = null;
        String gender = "Female";
        String specie = null;
        int offsprings = 0;
        //check if female will have offsprings
        //when offsprings > 0, creates offsprings(max 2) 
        //and then creates the mother  
        if(gender.equals("Female")){
            offsprings = data.hasOffsprings();
            for(int i=0; i<offsprings; i++){
                a = this.data.generateAnimal(specie, gender, -1);
                zooData.getAnimals().add(a);
            }
            this.data.generateAnimal(specie, gender, offsprings);
        }
        return a;
    }
    
    /**
     * Method to add the offspring to the Animal list
     * @param a 
     */
    public void addOffSpring(Animal a){
        //List<Qualification> animalTypes = Qualification.getQualifications();
        System.out.println(a.getAnimalTypes());
        System.out.println("Type here animal information: ");
        System.out.println("-----------------------------"); 
        System.out.println("Enter Animal Name: ");
        String name = this.in.next();
        System.out.println("Enter Animal Gender");
        String gender = this.in.next();
        System.out.println("Enter date of birth");
        String dob = this.in.next();
        Animal offspring = this.createOffspring(name, gender, dob, a);
        System.out.println(offspring);
        this.data.assignKeeper(offspring);
        List<Animal> list = new ArrayList<>();
        list.add(offspring);
        a.setOffSpring(list);      
    }
    
    /**
     * This method creates new animal after receiving the information given
     * @param specie
     * @param name
     * @param gender
     * @param doa
     * @param dob
     * @param selectedTypes
     * @return 
     */
    public Animal createAnimal(String specie, String name, String gender, String doa, String dob, List<Qualification> selectedTypes ){
        Animal a = null;
        List<String> types = new ArrayList<>();
        for(Enum e: selectedTypes){
            types.add(e.toString());
        }
        
        System.out.println("PRINT TYPES" + types);
        if(types.size() == 1){
            String type = types.get(1);
            if(type.equalsIgnoreCase("mammal")){
              a = new GenericMammal(specie, name, gender, doa, dob);
            }else if(type.equalsIgnoreCase("reptile")){
              a = new GenericReptile(specie, name, gender, doa, dob);
            }else if(type.equalsIgnoreCase("avian")){
              a = new GenericAvian(specie, name, gender, doa, dob);
              if(a instanceof AvianMammal){
                  ((AvianMammal) a).canFly();
              }
              if(a instanceof GenericAvian){
                  ((GenericAvian) a).canFly();
              }
            }else if(type.equalsIgnoreCase("aquatic")){
              a = new GenericAquatic(specie, name, gender, doa, dob);
            }else if(type.equalsIgnoreCase("insect")){
              a = new GenericInsect(specie, name, gender, doa, dob);
            }
        }if(selectedTypes.size() == 2){
            String type = selectedTypes.get(1).toString();
            if(type.equalsIgnoreCase("Aquatic") || type.equalsIgnoreCase("Avian")){
              a = new AquaticAvian(specie, name, gender, doa, dob);
            }else if(type.equalsIgnoreCase("Aquatic") || type.equalsIgnoreCase("Mammal")){
              a = new AquaticMammal(specie, name, gender, doa, dob);
            }else if(type.equalsIgnoreCase("Aquatic") || type.equalsIgnoreCase("Reptile")){
              a = new AquaticReptile(specie, name, gender, doa, dob);
            }else if(type.equalsIgnoreCase("Avian") || type.equalsIgnoreCase("Mammal")){
              a = new AvianMammal(specie, name, gender, doa, dob);
            } 
        }  
        return a;    
    }
 
    
    //TO DO, please.
    /**
     * Method to create a offspring on animals after the new animal is created
     * @param name
     * @param gender
     * @param dob
     * @param a
     * @return 
     */
    public Animal createOffspring(String name, String gender,String dob, Animal a){
        List<String> types = new ArrayList<>();
        types = this.animals.getAnimalTypes(a);
        System.out.println("Types" + types);
        Animal offspring = this.data.generateAnimal(a.getSpecies(), gender, 0);

        if(types.size() == 1){
            for(String s: types){
                if(s.equalsIgnoreCase("Mammal")){
                    offspring = new GenericMammal(a.getSpecies(), name, gender,dob);
                }else if(s.equalsIgnoreCase("Reptile")){
                    offspring = new GenericReptile(a.getSpecies(), name, gender,dob);
                }else if(s.equalsIgnoreCase("Aquatic")){
                    offspring = new GenericAquatic(a.getSpecies(), name, gender,dob);
                }else if(s.equalsIgnoreCase("Avian")){
                    offspring = new GenericAvian(a.getSpecies(), name, gender,dob);
                    if(offspring instanceof Avian) {
                        ((Avian) offspring).canFly();
                    }
                }else if(s.equalsIgnoreCase("Insect")){
                    offspring = new GenericInsect(a.getSpecies(), name, gender,dob);
                }
            }     
        }
        else if(types.size() == 2){
            for(String s: types){
                if(s.equals("Avian") && s.equals("Mammal")){
                    offspring = new AvianMammal(a.getSpecies(), name, gender, dob);
                }else if(s.equals("Aquatic") && s.equals("Avian")){
                    offspring = new AquaticAvian(a.getSpecies(), name, gender, dob);
                }else if(s.equals("Aquatic") && s.equals("Reptile")){
                    offspring = new AquaticReptile(a.getSpecies(), name, gender, dob);
                }else if(s.equals("Aquatic") && s.equals("Mammal")){
                    offspring = new AquaticMammal(a.getSpecies(), name, gender, dob);
                }
            }
        }    
        return offspring;
    }   
}
