public class Main {
    public static void main(String[] args) {
        Player pikachu = new Player (25, "Pikachu", 10);
        Player garchomp = new Player (445, "Garchomp", 10);
        Player regigigas = new Player (486, "Regigigas", 10);
        Player kyogre = new Player (382, "Kyogre", 10);
        Player gigalith = new Player (526, "Gigalith", 10);
        Player metagross = new Player (376, "Metagross", 10);

        System.out.println();
        System.out.print("Showing Current Pokemon in PC...");
        SimpleHashTable hashTable = new SimpleHashTable();


        hashTable.put(pikachu.getUserName(), pikachu);
        hashTable.put(garchomp.getUserName(), garchomp);
        hashTable.put(regigigas.getUserName(), regigigas);
        hashTable.put(kyogre.getUserName(), kyogre);
        hashTable.put(gigalith.getUserName(), gigalith);
        hashTable.put(metagross.getUserName(), metagross);

        System.out.println("\n");

        hashTable.printHashtable();
        System.out.println();
        System.out.println("Value for " + pikachu.getUserName() + " is " + hashTable.get(pikachu.getUserName()));

        //Removes Selected Key
        System.out.println();
        System.out.println("Removing Pokemon from PC...");
        hashTable.remove("Pikachu");
        hashTable.printHashtable();
    }
}
