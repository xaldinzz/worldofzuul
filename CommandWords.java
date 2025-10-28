/**
 * Class CommandWords - memegang daftar semua kata perintah yang valid
 * dalam game.
 */
public class CommandWords {
    // Array konstan yang menyimpan semua kata perintah valid
    private static final String[] validCommands = {
        "go", "quit", "help"
    };

    /**
     * Constructor - inisialisasi kata perintah.
     */
    public CommandWords() {
        // saat ini tidak ada yang perlu dilakukan
    }

    /**
     * Memeriksa apakah sebuah String adalah kata perintah yang valid.
     * @param aString String yang akan diperiksa.
     * @return true jika valid, false jika tidak.
     */
    public boolean isCommand(String aString) {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // jika kita sampai sini, string tidak ditemukan di daftar perintah
        return false;
    }

    /**
     * Mencetak semua perintah yang valid ke System.out.
     */
    public void showAll() {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}