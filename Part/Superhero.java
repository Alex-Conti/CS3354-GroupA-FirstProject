package Part;

public class Superhero extends GameCharacter implements Flyable, Swimmable, Teleportable {
    private String superPower;

    public Superhero(String name, int level, int health, String superPower) {
        super(name, level, health);
        this.superPower = superPower;
    }

    public void saveTheDay() {
        System.out.println(getName() + " uses their " + superPower + " to save the day");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " leaps into the air and flies");
    }

    @Override
    public void land() {
        System.out.println(getName() + " touches down on the ground");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " dives in and swims");
    }

    @Override
    public void stopSwimming() {
        System.out.println(getName() + " emerges from the water");
    }

    @Override
    public void teleport(int x, int y) {
        System.out.println(getName() + " teleports to (" + x + ", " + y + ").");
    }
}