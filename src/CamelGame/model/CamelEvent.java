package CamelGame.model;

/**
 * Interface that follows Strategy Pattern implemented by Flower, Genie, Oasis, and Sandstorm event classes
 * @author MMR
 *
 */
public interface CamelEvent {
    /**
     * Abstract method for implementing classes
     * @param camel
     */
	public void event(Camel camel);
}
