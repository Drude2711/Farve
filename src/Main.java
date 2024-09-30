public class Main {
    private int r;
    private int g;
    private int b;

    // Default constructor (black color)
    public Main() {
        this.r = 0;
        this.g = 0;
        this.b = 0;
    }

    // Set constructor (sets color based on given RGB)
    public Main(int r, int g, int b) {
        set(r, g, b);
    }

    // Copy constructor (copies color from another Main instance)
    public Main(Main main) {
        this.r = main.r;
        this.g = main.g;
        this.b = main.b;
    }

    // toString method, returns a string based on RGB values
    @Override
    public String toString() {
        if (equals(new Main(255, 0, 0))) {
            return "[Red]";
        } else if (equals(new Main(0, 255, 0))) {
            return "[Green]";
        } else if (equals(new Main(0, 0, 255))) {
            return "[Blue]";
        } else if (equals(new Main(0, 0, 0))) {
            return "[Black]";
        } else {
            return String.format("[%d, %d, %d]", r, g, b);
        }
    }

    // set method, sets RGB values with validation
    public void set(int r, int g, int b) {
        this.r = normalize(r);
        this.g = normalize(g);
        this.b = normalize(b);
    }

    // Service method to normalize RGB values
    private int normalize(int value) {
        if (value < 0) {
            return 0;
        } else if (value > 255) {
            return 255;
        } else {
            return value;
        }
    }

    // equals method, checks if two colors are the same
    public boolean equals(Main main) {
        return this.r == main.r && this.g == main.g && this.b == main.b;
    }

    // Main method to run the application
    public static void main(String[] args) {
        Main m = new Main(255, 0, 0);
        System.out.println(m);
    }
}
//*Default-konstruktor: Sætter farven til sort (RGB: 0, 0, 0).
//Set-konstruktor: Modtager tre parametre (r, g, b) og bruger set() metoden til at validere og sætte værdierne.
//Copy-konstruktor: Tager en anden Farve som parameter og kopierer dens RGB-værdier.
//toString: Returnerer en streng baseret på RGB-værdierne. Hvis farven er rød, grøn, blå eller sort, returneres det tilsvarende navn.
//set: Indstiller RGB-værdier med validering, så værdier holdes indenfor intervallet [0, 255].
//normalize: Hjælper med at sikre, at RGB-værdier ikke går uden for det tilladte område.
//equals: Sammenligner to Farve objekter og returnerer true, hvis RGB-værdierne er ens.
//
