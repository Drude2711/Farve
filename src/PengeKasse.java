public class PengeKasse {
    private int tyvere;
    private int tiere;
    private int femmere;
    private int toere;
    private int enere;

    // Default constructor (sets PengeKassen to be empty)
    public PengeKasse() {
        this.tyvere = 0;
        this.tiere = 0;
        this.femmere = 0;
        this.toere = 0;
        this.enere = 0;
    }

    // Copy constructor (copies the content of another PengeKasse)
    public PengeKasse(PengeKasse kassen) {
        this.tyvere = kassen.tyvere;
        this.tiere = kassen.tiere;
        this.femmere = kassen.femmere;
        this.toere = kassen.toere;
        this.enere = kassen.enere;
    }

    // toString method, returns a string describing the content of the PengeKasse
    @Override
    public String toString() {
        return String.format("[20:%d][10:%d][5:%d][2:%d][1:%d]", tyvere, tiere, femmere, toere, enere);
    }

    // set method, sets the number of coins of a given denomination
    public void set(int pålydende, int antal) {
        switch (pålydende) {
            case 20:
                this.tyvere = antal;
                break;
            case 10:
                this.tiere = antal;
                break;
            case 5:
                this.femmere = antal;
                break;
            case 2:
                this.toere = antal;
                break;
            case 1:
                this.enere = antal;
                break;
            default:
                throw new IllegalArgumentException("Ugyldig mønttype: " + pålydende);
        }
    }

    // sum method, returns the total amount in the PengeKasse
    public int sum() {
        return (20 * tyvere) + (10 * tiere) + (5 * femmere) + (2 * toere) + enere;
    }

    // equals method, checks if two PengeKasser have the same content
    public boolean equals(PengeKasse kassen) {
        return this.tyvere == kassen.tyvere &&
               this.tiere == kassen.tiere &&
               this.femmere == kassen.femmere &&
               this.toere == kassen.toere &&
               this.enere == kassen.enere;
    }

    // get method, returns the number of coins of a given denomination
    public int get(int pålydende) {
        switch (pålydende) {
            case 20:
                return tyvere;
            case 10:
                return tiere;
            case 5:
                return femmere;
            case 2:
                return toere;
            case 1:
                return enere;
            default:
                throw new IllegalArgumentException("Ugyldig mønttype: " + pålydende);
        }
    }

    // add method, adds the coins from another PengeKasse to this one
    public void add(PengeKasse kassen) {
        this.tyvere += kassen.tyvere;
        this.tiere += kassen.tiere;
        this.femmere += kassen.femmere;
        this.toere += kassen.toere;
        this.enere += kassen.enere;

        kassen.tyvere = 0;
        kassen.tiere = 0;
        kassen.femmere = 0;
        kassen.toere = 0;
        kassen.enere = 0;
    }

    // givTilbage method, returns a PengeKasse with the coins needed to make up the given amount
    public PengeKasse givTilbage(int beløb) {
        PengeKasse tilbage = new PengeKasse();
        int[] møntTyper = {20, 10, 5, 2, 1};
        for (int mønt : møntTyper) {
            int antal = Math.min(beløb / mønt, get(mønt));
            tilbage.set(mønt, antal);
            set(mønt, get(mønt) - antal);
            beløb -= mønt * antal;
        }
        return tilbage;
    }

    // Main method to test the class
    public static void main(String[] args) {
        PengeKasse kasse1 = new PengeKasse();
        kasse1.set(20, 1);
        kasse1.set(10, 2);
        kasse1.set(5, 0);
        kasse1.set(2, 1);
        kasse1.set(1, 0);

        System.out.println(kasse1); // [20:1][10:2][5:0][2:1][1:0]
        System.out.println("Sum: " + kasse1.sum()); // Sum: 42

        PengeKasse kasse2 = new PengeKasse(kasse1);
        System.out.println(kasse2.equals(kasse1)); // true

        PengeKasse kasse3 = kasse1.givTilbage(22);
        System.out.println(kasse3); // [20:1][10:0][5:0][2:1][1:0]
        System.out.println(kasse1); // [20:0][10:2][5:0][2:0][1:0]
    }
}