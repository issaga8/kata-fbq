package kata.foo.bar.qix;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

/**
 * Class implements the IFooBarQix Interface
 */
public class FooBarQixImpl implements IFooBarQix {

    public static final String FOO = "Foo";
    public static final String BAR = "Bar";
    public static final String QIX = "Qix";
    public static final int MAX_SIZE_REPLACE = 1;

    @Override
    public void CalculateFooBarQix(String... numbers) {
        Stream.of(numbers).filter(s -> (Integer.parseInt(s) < 100))
                .forEach(n -> getStringConsumer(n));

    }

    /**
     * Return the effective String by remplacing
     *      * 3-->"Foo"
     *      * 5-->"Bar"
     *      * 7-->"Qix"
     *      or the number itSelf
     * @param number
     * @return StringBuilder
     */
    @Override
    public StringBuilder getStringConsumer(String number) {
        String chaine_vide = "Chaine de String vide";
        StringBuilder result = new StringBuilder();

        try {
            result.append(constructStringByOrderApperence(number));

        } catch (NumberFormatException nfe) {
            System.out.println(chaine_vide + nfe.getMessage());
            result.append(chaine_vide);
        }
        return result;

    }

    /**
     * Retourne une chaine en tenant compte de l'ordre des priorité de la division
     * @param number
     * @return
     */
    private StringBuilder constructStringByOrderApperence(String number) {
        ArrayList<Character> numberStringAsArray = number.chars().mapToObj(x -> (char) x).collect(toCollection(ArrayList::new));

        String repeatedString;
        StringBuilder result = new StringBuilder();
        int countMatch_3 = StringUtils.countMatches(number, "3");
        int countMatch_5 = StringUtils.countMatches(number, "5");
        int countMatch_7 = StringUtils.countMatches(number, "7");
        if(numberStringAsArray.isEmpty()){
            throw  new NumberFormatException();
        }
        if (isDivisibleBy_3(number)){
            addToStringBuilder(result, FOO, 1);

        }
        if (isDivisibleBy_5(number)){
            addToStringBuilder(result, BAR, 1);

        }
        replacebyCaracter(number, numberStringAsArray, result, countMatch_3, countMatch_5, countMatch_7);
        return result;

    }

    /**
     * Construit une nouvelle chaine en remplace
     * 3-->"Foo"
     * 5-->"Bar"
     * 7-->"Qix"
     * @param number
     * @param numberStringAsArray
     * @param result
     * @param countMatch_3
     * @param countMatch_5
     * @param countMatch_7
     */
    private void replacebyCaracter(String number, ArrayList<Character> numberStringAsArray, StringBuilder result, int countMatch_3, int countMatch_5, int countMatch_7) {
        for (Character subNumberChar : numberStringAsArray) {
            String subNumberString = String.valueOf(subNumberChar);
            switch (subNumberString) {

                case "3": {
                    if (countMatch_3 > 0) {
                        addToStringBuilder(result, FOO, MAX_SIZE_REPLACE);
                    }
                    break;
                }
                case "5": {

                    if ( countMatch_5 > 0) {
                        addToStringBuilder(result, BAR, MAX_SIZE_REPLACE);
                    }
                    break;
                }
                case "7": {
                    if (countMatch_7 > 0) {
                        addToStringBuilder(result, QIX, MAX_SIZE_REPLACE);
                    }
                }
                break;

                default: {
                        if(result == null) {
                            result.append(subNumberString);
                        }
                }
            }

        }
    }

    /**
     * adding Foo or Bar, or Qix in a String
     * @param result
     * @param forBarQix
     * @param i
     */
    private void addToStringBuilder(StringBuilder result, String forBarQix, int i) {
        String repeatedString;
        repeatedString = Stream.generate(() -> forBarQix).limit(i).collect(joining());
        result.append(repeatedString);
    }

    /**
     * Return true if number is divible per 3
     * @param number
     * @return
     */
    private boolean isDivisibleBy_3(String number) {
        return  Integer.parseInt(number) % 3 == 0 ;
    }
    /**
     * Return true if number is divible per 5
     * @param number
     * @return
     */
    private boolean isDivisibleBy_5(String number) {
        return  Integer.parseInt(number) % 5 == 0 ;
    }


}

