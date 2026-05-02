package Part;

public class Mermaid extends GameCharacter implements Swimmable {
    private int finLength;

    public Mermaid(String name, int level, int health, int finLength) {
        super(name, level, health); 
        this.finLength = finLength;
    }

    public void sing() {
        System.out.println(getName() + " is singing");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming");
    }

    @Override
    public void stopSwimming() {
        System.out.println(getName() + " has stopped swimming");
    }
}