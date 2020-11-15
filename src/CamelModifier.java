public class CamelModifier extends Camel{
//    Camel camel = new Camel();
    int hydration;
    int stamina;

    public CamelModifier(int hydration, int stamina) {
        this.stamina = stamina;
        this.hydration = hydration;
    }


    public void findOasis() {
        System.out.print("You found an oasis");
        super.hydrate();
    }


    public int sandstormHydrate() {
        System.out.println("You got caught in a sandstorm");
        return super.getHydration()/2;
    }

    public int sandstormStamina() {
        return super.getStamina()/2;
    }

    public void cactusFlower() {
        System.out.println("You found a special cactus flower");
        super.rest();
    }
}
