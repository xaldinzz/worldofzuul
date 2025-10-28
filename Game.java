/**
 * Class Game - kelas utama untuk game "World of Zuul".
 */
public class Game {
    private Parser parser; // Asumsi Anda sudah punya kelas Parser
    private Room currentRoom;

    /**
     * Membuat game dan menginisialisasi peta internal.
     */
    public Game() {
        createRooms();
        parser = new Parser(); // Asumsi Anda punya kelas Parser
    }

    /**
     * Membuat semua ruangan dan menghubungkan pintu-pintu keluarnya.
     */
    private void createRooms() {
        Room outside, theatre, pub, lab, office;

        // Membuat objek ruangan
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // Mengatur pintu keluar (exits)
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // Game dimulai di luar
    }

    /**
     * Memulai game loop utama.
     */
    public void play() {
        printWelcome();

        // Game loop utama. Terus berjalan sampai pemain 'quit'.
        boolean finished = false;
        while (!finished) {
            // Asumsi parser.getCommand() mengembalikan objek Command
            Command command = parser.getCommand(); 
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Mencetak pesan selamat datang.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Memproses perintah yang diberikan pemain.
     * @param command Perintah yang akan diproses.
     * @return true jika game harus berakhir, false sebaliknya.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // --- Implementasi perintah ---

    /**
     * Mencetak pesan bantuan.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        // Asumsi Anda punya kelas CommandWords
        // parser.showCommands(); 
        parser.showCommands();
    }

    /**
     * Implementasi perintah "go".
     */
    private void goRoom(Command command) {
        if(!command.hasSecondWord()) {
            // jika tidak ada kata kedua (arah)
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Mencoba pindah ke ruangan lain
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /**
     * Implementasi perintah "quit".
     */
    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // Sinyal untuk mengakhiri game
        }
    }
}