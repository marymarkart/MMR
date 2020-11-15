public class CamelModifier extends Camel {
//    Camel camel = new Camel();
    int hydration;
    int stamina;

    public CamelModifier() {
        this.stamina = stamina;
        this.hydration = hydration;
    }


    public void findOasis(Camel camel) {
        System.out.print("You found an oasis");
        camel.hydrate();
    }


    public void sandstormHydrate(Camel camel) {
        System.out.println("You got caught in a sandstorm");
        camel.hydration = camel.getHydration()/2;
    }

    public void sandstormStamina(Camel camel) {
        camel.stamina = camel.getStamina()/2;
    }

    public void cactusFlower(Camel camel) {
        System.out.println("You found a special cactus flower");
        camel.rest();
    }
}
