public abstract class ColorfulCard extends Card {

    public enum Color {
        BLUE   { public String toString() { return "BLUE"; }},
        RED    { public String toString() { return "RED"; }},
        GREEN  { public String toString() { return "GREEN"; }},
        YELLOW { public String toString() { return "YELLOW"; }}
    }

    public enum Value {

        // Colorful Card
        SKIP    { public String toString() { return "SKIP";}},
        REVERSE { public String toString() { return "REVERSE";}},
        DRAWTWO { public String toString() { return "DRAW+2";}},


        // Numerical Card
        ZERO    { public String toString() { return "0";}},
        ONE     { public String toString() { return "1";}},
        TWO     { public String toString() { return "2";}},
        THREE   { public String toString() { return "3";}},
        FOUR    { public String toString() { return "4";}},
        FIVE    { public String toString() { return "5";}},
        SIX     { public String toString() { return "6";}},
        SEVEN   { public String toString() { return "7";}},
        EIGHT   { public String toString() { return "8";}},
        NINE    { public String toString() { return "9";}}
    }


    private final Color color;
    private final Value value;

    public ColorfulCard(final Color color, final Value value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public abstract String getColor();

    @Override
    public abstract String getValue();

    public void show(Value value, Color color){

        String ANSI_COLOR;
        switch (color) {
            case RED:
                final String ANSI_RED = "\u001B[31m";
                ANSI_COLOR = ANSI_RED;
                break;
            case BLUE:
                final String ANSI_BLUE = "\u001B[34m";
                ANSI_COLOR = ANSI_BLUE;
                break;
            case GREEN:
                final String ANSI_GREEN = "\u001B[32m";
                ANSI_COLOR = ANSI_GREEN;
                break;
            case YELLOW:
                final String ANSI_YELLOW = "\u001B[33m";
                ANSI_COLOR = ANSI_YELLOW;
                break;
            default:
                final String ANSI_WHITE = "\u001B[37m";
                ANSI_COLOR = ANSI_WHITE;
                break;
        }
        final String ANSI_RESET = "\u001B[0m";

        String str = value.toString();
        int space1 = 7+str.length()/2;
        int space2 = 9-str.length()/2;
        System.out.printf(ANSI_COLOR+"|$$$$$$$$$$$$$$$|\n");
        System.out.printf("|%" + 17 + "s","|\n");
        System.out.printf("|%"+ space1 + "s" + "%"+ space2 + "s\n",str,"|");
        System.out.printf("|%" + 17 + "s","|\n");
        System.out.printf("|$$$$$$$$$$$$$$$|\n"+ANSI_RESET);
    }

    @Override
    public abstract boolean match(Card card);

}
