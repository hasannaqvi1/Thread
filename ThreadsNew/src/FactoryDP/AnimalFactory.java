package FactoryDP;

public class AnimalFactory {


   public Animal getAnimalType(String type){
        switch(type){
            case "Dog":
                return new Dog();
            case "Cat":
                return new Cat();

        }
        return null;

   }

    public static void main(String[] args) {
    AnimalFactory aF = new AnimalFactory();
    Animal animal = aF.getAnimalType("Dog");
    animal.speak();
    }

}
