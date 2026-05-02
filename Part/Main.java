package Part;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("=== Test Case 1: Wizard Actions ===");
        Wizard myWizard = new Wizard("Merlin", 10, 100, 500);
        myWizard.castSpell();
        myWizard.attack();
        myWizard.fly();
        myWizard.teleport(15, 30);
        myWizard.land();

        System.out.println("\n=== Test Case 2: Mermaid Actions ===");
        Mermaid myMermaid = new Mermaid("Ariel", 5, 80, 120);
        myMermaid.sing();
        myMermaid.swim();
        myMermaid.defend();
        myMermaid.stopSwimming();

        System.out.println("\n=== Test Case 3: Superhero Actions ===");
        Superhero myHero = new Superhero("Clark", 99, 1000, "Flight and Strength");
        myHero.saveTheDay();
        myHero.attack();
        myHero.fly();
        myHero.teleport(100, 500);
        myHero.land();
        myHero.swim();
        myHero.stopSwimming();

        System.out.println("\n=== Test Case 4: Polymorphism & Interface Application ===");
        performCharacterActions(myWizard);
        performCharacterActions(myMermaid);
        performCharacterActions(myHero);
    

    }


    public static void performCharacterActions(GameCharacter character) {
        System.out.println("\n--- Testing abilities for: " + character.getName() + " ---");
        
        character.attack();
        character.defend();

        if (character instanceof Flyable) {
            Flyable flyer = (Flyable) character;
            flyer.fly();
            flyer.land();
        }

        if (character instanceof Swimmable) {
            Swimmable swimmer = (Swimmable) character;
            swimmer.swim();
            swimmer.stopSwimming();
        }

        if (character instanceof Teleportable) {
            Teleportable teleporter = (Teleportable) character;
            teleporter.teleport(50, 50);
        }
    }

}