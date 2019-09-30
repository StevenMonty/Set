package A1;

public class SetTest {

    public static void main(String[] args) throws NullPointerException, SetFullException {

        String[] start = { "Let's", "get", "this", "bread", "this", "king", "get" };
        Set<String> set1 = new Set<String>(5); // better to define this as a
        // setInterface?

        Set<Integer> set2 = new Set<Integer>();

        set2.add(45);
        set2.add(15);
        set2.add(3);

        Object[] intArr = set2.toArray();
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }

        System.out.println(set1.getSize());
        Object[] newArr = set1.toArray();
        for (int i = 0; i < set1.getSize(); i++) {
            System.out.println(newArr[i]);
        }
        System.out.println("Is the set empty: " + set1.isEmpty());

        System.out.println();

        set1.add("Puppy");
        set1.add("Human");
        set1.add("Breakfast");
        set1.add("Friends");
        System.out.println("Is the set empty: " + set1.isEmpty());
        System.out.println();

        System.out.println(set1.getSize());
        System.out.println("The result of adding Puppy again was " + set1.add("Puppy"));
        newArr = set1.toArray();
        for (int i = 0; i < set1.getSize(); i++) {
            System.out.println(newArr[i]);
        }

        System.out.println();
        String removed = set1.remove("Puppy");
        System.out.println(removed + " was removed");
        System.out.println("the result of removing toaster which was not in the set is " + set1.remove("toaster"));

        System.out.println();
        System.out.println(set1.getSize());
        newArr = set1.toArray();

        for (int i = 0; i < set1.getSize(); i++) {
            System.out.println(newArr[i]);
        }
        System.out.println();

        System.out.println("The following were removed: ");
        System.out.println(set1.remove());
        System.out.println(set1.remove());
        System.out.println(set1.remove());
        System.out.println(set1.remove());
        System.out.println(set1.remove());

        System.out.println();
        System.out.println("Here is the new set: ");

        newArr = set1.toArray();

        for (int i = 0; i < set1.getSize(); i++) {
            System.out.println(newArr[i]);
        }
        System.out.println();

        set1.add("1");
        set1.add("5");
        set1.add("9");
        set1.add("8");
        set1.add("23");
        set1.add("11");
        set1.add("55");
        set1.add("99");
        set1.add("88");
        set1.add("230");
        set1.add("10");
        set1.add("50");
        set1.add("90");
        set1.add("80");
        set1.add("2300");
        set1.add("13");
        set1.add("53");
        set1.add("93");
        set1.add("83");
        set1.add("233");
        set1.add("14");
        set1.add("54");
        set1.add("94");
        set1.add("84");
        set1.add("234");
        set1.add("15");
        set1.add("57");
        set1.add("97");
        set1.add("87");
        set1.add("238");

        newArr = set1.toArray();

        System.out.println("This is the new size after adding a lot: " + set1.getSize());
        System.out.println("Here is the new set: ");

        newArr = set1.toArray();
        for (int i = 0; i < set1.getSize(); i++) {
            System.out.println(newArr[i]);
        }
        System.out.println();

        System.out.println("Does the set contain 59: " + set1.contains("59"));
        System.out.println("Does the set contain 5: " + set1.contains("5"));

        set1.clear();
        System.out.println("The result of calling is empty is " + set1.isEmpty());

        newArr = set1.toArray();

        System.out.println("Set has been cleared what is the new size: " + set1.getSize());
        System.out.println("Now print out the set array: ");

        newArr = set1.toArray();
        for (int i = 0; i < set1.getSize(); i++) {
            System.out.println(newArr[i]);
        }
        System.out.println();

        set1.clear();

        System.out.println("Does the set contain 45: " + set1.contains("45"));
        System.out.println();
        System.out.println("Check to see if the set is empty: " + set1.isEmpty());

        set1.remove(null);
        System.out.println(set1.contains(null));

    }

}