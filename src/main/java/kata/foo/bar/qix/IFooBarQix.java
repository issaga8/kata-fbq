package kata.foo.bar.qix;

/**
 * Interface
 */
public interface IFooBarQix {
    /**
     * Retourne pour une nombre soit : "Foo","Bar","Qix" sinon nombre
     * @param number
     * @return StringBuilder
     */
    public StringBuilder getStringConsumer(String number);

    /**
     * Afficher les element du tableau de string
     * @param numbers
     */
    public void CalculateFooBarQix(String... numbers);

}
