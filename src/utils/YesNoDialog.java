package utils;

public class YesNoDialog {

    private String title;

    public YesNoDialog(String title) {
        assert title != null;
        this.title = title;
    }

    public boolean read() {
        char again;
        IO io = new IO();
        boolean ok;
        do {
            again = io.readChar(title + "? (s/n): ");
            ok = again == 's' || again == 'S' || again == 'n'
                    || again == 'N';
            if (!ok) {
                io.writeln("El valor debe ser 's' ó 'n'");
            }
        } while (!ok);
        return again == 's' || again == 'S';
    }
}
