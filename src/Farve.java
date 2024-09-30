public class Farve {
    private int r;
    private int g;
    private int b;

    // Default constructor (sets color to black)
    public Farve() {
        this.r = 0;
        this.g = 0;
        this.b = 0;
    }

    // Set constructor (sets color based on given RGB)
    public Farve(int r, int g, int b) {
        set(r, g, b);
    }

    // Copy constructor (copies color from another Farve instance)
    public Farve(Farve farve) {
        this.r = farve.r;
        this.g = farve.g;
        this.b = farve.b;
    }

    // toString method, returns a string based on RGB values
    @Override
    public String toString() {
        if (equals(new Farve(255, 0, 0))) {
            return "[Rød]";
        } else if (equals(new Farve(0, 255, 0))) {
            return "[Grøn]";
        } else if (equals(new Farve(0, 0, 255))) {
            return "[Blå]";
        } else if (equals(new Farve(0, 0, 0))) {
            return "[Sort]";
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
    public boolean equals(Farve farve) {
        return this.r == farve.r && this.g == farve.g && this.b == farve.b;
    }

    // Main method to test the class
    public static void main(String[] args) {
        Farve farve1 = new Farve(255, 0, 0);
        Farve farve2 = new Farve(0, 255, 0);
        Farve farve3 = new Farve(0, 0, 255);
        Farve farve4 = new Farve(153, 102, 51);

        System.out.println(farve1); // [Rød]
        System.out.println(farve2); // [Grøn]
        System.out.println(farve3); // [Blå]
        System.out.println(farve4); // [153, 102, 51]

        Farve farve5 = new Farve(farve1);
        System.out.println(farve5.equals(farve1)); // true
    }
}