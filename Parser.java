import java.util.Scanner;

/**
 * Class Parser - membaca input dari pemain dan mengubahnya
 * menjadi objek Command.
 */
public class Parser {
    private CommandWords commands;  // referensi ke daftar perintah valid
    private Scanner reader;         // sumber input perintah

    /**
     * Membuat parser baru yang membaca dari terminal.
     */
    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Membaca input berikutnya dari pemain dan mengubahnya
     * menjadi objek Command.
     * @return Objek Command dari input pemain.
     */
    public Command getCommand() {
        String inputLine;   // akan menyimpan baris input lengkap
        String word1 = null;
        String word2 = null;

        System.out.print("> "); // cetak prompt

        inputLine = reader.nextLine();

        // Mencari sampai 2 kata dari baris input
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // ambil kata pertama
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // ambil kata kedua
                // Catatan: kita abaikan sisa kata di baris itu
            }
        }

        // Cek apakah kata pertama adalah perintah yang valid
        if(commands.isCommand(word1)) {
            // jika ya, buat Command berdasarkan itu
            return new Command(word1, word2);
        }
        else {
            // jika tidak, buat command "unknown"
            return new Command(null, word2);
        }
    }
    
    /**
     * Menampilkan daftar perintah yang valid.
     * (Dipanggil oleh Game saat pemain mengetik 'help')
     */
    public void showCommands() {
        commands.showAll();
    }
}