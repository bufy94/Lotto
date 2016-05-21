import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {

    public static void main(String[] args) {
        Integer[] agencyNumbers = chooseNumbers();
        int howManyToWin = 3;
        Integer[] myTicket = chooseNumbers();

        int tries = 1;
        while (howManyMatch(agencyNumbers, myTicket) < howManyToWin) {
            tries++;
            myTicket = chooseNumbers();
        }

        System.out.println("Salut, Pentru a castiga " + howManyToWin + " numere am jucat " + tries + " variante simple");
    }

    private static Integer[] chooseNumbers() {
        Random lottoMachine = new Random();

        Set<Integer> setOfSix = new HashSet<Integer>();
        int counter = 0;
        do {
            int chosenNumber = lottoMachine.nextInt(49) + 1;
            if (setOfSix.add(chosenNumber)) {
                counter++;
                System.out.print(chosenNumber + ":");
            }
        } while (counter < 6);
        System.out.println();

        return setOfSix.toArray(new Integer[6]);
    }

    private static int howManyMatch(Integer[] agencyNumbers, Integer[] myTicket) {
        int maches = 0;
        for (Integer agencyNumber : agencyNumbers) {
            for (Integer myTicketNumber : myTicket) {
                if (agencyNumber == myTicketNumber) {
                    maches++;
                    break;
                }
            }
        }

        return maches;
    }
}
