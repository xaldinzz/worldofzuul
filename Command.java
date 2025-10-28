/**
 * Class Command - merepresentasikan satu perintah yang dimasukkan
 * oleh pemain.
 */
public class Command {
    private String commandWord;
    private String secondWord;

    /**
     * Membuat objek command.
     * @param commandWord Kata perintah pertama.
     * @param secondWord Kata kedua dari perintah (bisa null).
     */
    public Command(String commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * Mengembalikan kata perintah (kata pertama).
     * @return String kata perintah.
     */
    public String getCommandWord() {
        return commandWord;
    }

    /**
     * Mengembalikan kata kedua dari perintah.
     * @return String kata kedua, atau null jika tidak ada.
     */
    public String getSecondWord() {
        return secondWord;
    }

    /**
     * Memeriksa apakah perintah ini tidak diketahui.
     * @return true jika perintah tidak diketahui (commandWord adalah null).
     */
    public boolean isUnknown() {
        return (commandWord == null);
    }

    /**
     * Memeriksa apakah perintah memiliki kata kedua.
     * @return true jika ada kata kedua.
     */
    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}