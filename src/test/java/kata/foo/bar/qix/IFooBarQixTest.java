package kata.foo.bar.qix;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class
 */
public class IFooBarQixTest {

    public String numbers [] = {"1","753", "200000"};

    FooBarQixImpl fooBarQix =  new FooBarQixImpl() ;

    /**
     * Méthode pour tester  l'exception est bien catchée si le tableau est vide
     */
    @Test
    public void testGetStringConsumer(){
        String  exceptedMessage = "Chaine de String vide";
        StringBuilder stringBuilder = new StringBuilder();

        try{
           stringBuilder.append(fooBarQix.getStringConsumer(""));

        }catch (NumberFormatException npe){
            System.out.println("npe.getMessage();" + npe.getMessage());
        }finally {
            Assert.assertEquals(stringBuilder.toString(),exceptedMessage);
        }
    }

    /**
     * Méthode pour le cas d'un tableau contenant 3 par ses elements
     */
    @Test
    public void testGetStringConsumer_Case_3(){
        String strNumberArray [] = {"3"};
        String strFoo = "FooFoo";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(fooBarQix.getStringConsumer(strNumberArray[0]));

        Assert.assertEquals(stringBuilder.toString(),strFoo);


    }

    /**
     * Méthode pour le cas d'un tableau contenant 33 par ses elements
     *      Result = "FooFoo"
     */
    @Test
    public void testGetStringConsumer_Case_33(){
        String strNumberArray [] = {"33","19","17"};
        String strFooFOO = "FooFooFoo";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(fooBarQix.getStringConsumer(strNumberArray[0]));

        Assert.assertEquals(stringBuilder.toString(),strFooFOO);


    }

    /**
     * Méthode pour le cas d'un tableau contenant 53 par ses elements
     * Result = "BarFoo"
     */
    @Test
    public void testGetStringConsumer_Case_53(){
        String strNumberArray [] = {"53","29","17"};
        String strBarFoo = "BarFoo";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(fooBarQix.getStringConsumer(strNumberArray[0]));

        Assert.assertEquals(stringBuilder.toString(),strBarFoo);


    }

    /**
     * Méthode pour le cas d'un tableau contenant 51 par ses elements
     * Result = "Bar1"
     */
    @Test
    public void testGetStringConsumer_Case_51(){
        String strNumberArray [] = {"53","29","17","51"};
        String strBarFoo = "FooBar";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(fooBarQix.getStringConsumer(strNumberArray[3]));

        Assert.assertEquals(stringBuilder.toString(),strBarFoo);


    }

    /**
     * Méthode pour le cas d'un tableau contenant 7 par ses elements
     * Result = "Qix"
     */
    @Test
    public void testGetStringConsumer_Case_7(){
        String strNumberArray [] = {"7","53","29","17","51"};
        String strBarFoo = "Qix";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(fooBarQix.getStringConsumer(strNumberArray[0]));

        Assert.assertEquals(stringBuilder.toString(),strBarFoo);


    }

    /**
     * Méthode pour le cas d'un tableau contenant 27 par ses elements
     * Result = "Qix"
     */
    @Test
    public void testGetStringConsumer_Case_27(){
        String strNumberArray [] = {"27","53","29","17","51"};
        String strBarFoo = "FooQix";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(fooBarQix.getStringConsumer(strNumberArray[0]));

        Assert.assertEquals(stringBuilder.toString(),strBarFoo);


    }
}