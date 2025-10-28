import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - sebuah ruangan dalam game petualangan.
 *
 * Ruangan ini memiliki deskripsi dan menyimpan referensi ke
 * ruangan lain melalui pintu keluar (exits).
 */
public class Room {
    private String description;
    // Menyimpan pintu keluar untuk ruangan ini.
    // Key = arah (String), Value = ruangan (Room)
    private HashMap<String, Room> exits;

    /**
     * Membuat sebuah ruangan dengan deskripsi "description".
     * Awalnya, ruangan ini tidak memiliki pintu keluar.
     * @param description Deskripsi ruangan.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    /**
     * Mendefinisikan pintu keluar dari ruangan ini.
     * @param direction Arah pintu keluar (misal "north", "east").
     * @param neighbor Ruangan tujuan jika melewati pintu itu.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * @return Deskripsi dari ruangan.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mengembalikan ruangan yang akan dicapai jika kita pergi ke "direction".
     * Jika tidak ada ruangan ke arah itu, akan mengembalikan null.
     * @param direction Arah yang ingin dituju.
     * @return Ruangan di arah tersebut, atau null.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }
    
    /**
     * Mengembalikan string yang mendeskripsikan pintu keluar ruangan.
     * Contoh: "Exits: north west"
     * @return String berisi daftar pintu keluar.
     */
    public String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    /**
     * Mengembalikan deskripsi lengkap lokasi saat ini,
     * termasuk deskripsi ruangan dan pintu keluarnya.
     * @return Deskripsi ruangan dan pintu keluarnya.
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }
}