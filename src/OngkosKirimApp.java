/**
 * @author RAMAHAN & Revaldo Ramadana
 * @version 1.0
 * Aplikasi Ongkos Kirim
 *
 * Program ini memungkinkan pengguna untuk membuat, membaca, memperbarui, dan menghapus informasi paket pengiriman.
 * Pengguna juga dapat melihat gambar paket dengan memberikan jalur file yang valid.
 *
 * Fitur utama:
 * - Buat paket dengan detail seperti deskripsi, berat, tujuan, dan gambar.
 * - Lihat daftar semua paket yang tersimpan.
 * - Perbarui detail paket yang ada.
 * - Hapus paket berdasarkan ID.
 * - Lihat gambar paket melalui jalur file yang disediakan.
 */
import java.util.*;
import java.io.*;
import java.awt.Desktop;

/**
 * Custom Exception untuk input yang tidak valid.
 */
class InvalidInputException extends Exception {
    /**
     * Konstruktor untuk InvalidInputException.
     *
     * @param message Pesan kesalahan yang akan ditampilkan.
     */
    public InvalidInputException(String message) {
        super(message);
    }
}

/**
 * Representasi dari sebuah paket pengiriman.
 */
class Package {
    private int id;
    private String description;
    private double weight; // dalam kilogram
    private String destination;
    private double cost;
    private String imagePath;

    /**
     * Konstruktor untuk membuat objek Package.
     *
     * @param id ID unik untuk paket.
     * @param description Deskripsi paket.
     * @param weight Berat paket dalam kilogram.
     * @param destination Tujuan pengiriman paket.
     * @param cost Biaya pengiriman paket.
     * @param imagePath Jalur file gambar paket.
     */
    public Package(int id, String description, double weight, String destination, double cost, String imagePath) {
        this.id = id;
        this.description = description;
        this.weight = weight;
        this.destination = destination;
        this.cost = cost;
        this.imagePath = imagePath;
    }

    // Getter dan setter untuk atribut kelas
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "ID Package : " + id + ", Deskripsi : " + description + ", Berat: " + weight + " kg, Tujuan : " + destination + ", ongkos : Rp." + cost + ", Foto: " + imagePath;
    }
}

/**
 * Kelas utama untuk aplikasi Ongkos Kirim.
 */
public class OngkosKirimApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, Package> packages = new HashMap<>();
    private static int currentId = 1;

    /**
     * Titik masuk utama untuk aplikasi.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        while (true) {
            try {
                showMenu();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        createPackage();
                        break;
                    case 2:
                        readPackages();
                        break;
                    case 3:
                        updatePackage();
                        break;
                    case 4:
                        deletePackage();
                        break;
                    case 5:
                        viewImage();
                        break;
                    case 6:
                        System.out.println("Terimakasih!");
                        return;
                    default:
                        System.out.println("Pilihan invalid. silahkan coba lagi.");
                }
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: silahkan masukan nomor yang valid.");
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    /**
     * Menampilkan menu utama aplikasi.
     */
    private static void showMenu() {
        System.out.println("\n=== Aplikasi Ongkos Kirim ===");
        System.out.println("1. Buat Package");
        System.out.println("2. Lihat semua Packages");
        System.out.println("3. Update Package");
        System.out.println("4. Hapus Package");
        System.out.println("5. Lihat Gambar Package");
        System.out.println("6. Keluar");
        System.out.print("Masukan pilihan anda : ");
    }

    /**
     * Membuat paket baru dan menyimpannya ke dalam koleksi.
     *
     * @throws InvalidInputException Jika input tidak valid.
     * @throws IOException Jika jalur gambar tidak valid.
     */
    private static void createPackage() throws InvalidInputException, IOException {
        System.out.println("\n=== Masukan Package ===");
        System.out.print("Masukan deskripsi : ");
        String description = scanner.nextLine();

        System.out.print("Masukan berat(kg): ");
        double weight = Double.parseDouble(scanner.nextLine());
        if (weight <= 0) {
            throw new InvalidInputException("Weight must be greater than 0.");
        }

        System.out.print("Masukan tujuan: ");
        String destination = scanner.nextLine();

        System.out.print("Masukan path untuk foto package: ");
        String imagePath = scanner.nextLine();
        validateImagePath(imagePath);

        double cost = calculateCost(weight);
        Package pkg = new Package(currentId++, description, weight, destination, cost, imagePath);
        packages.put(pkg.getId(), pkg);

        System.out.println("Package berhasil dibuat: " + pkg);
    }

    /**
     * Menghitung biaya pengiriman berdasarkan berat paket.
     *
     * @param weight Berat paket dalam kilogram.
     * @return Biaya pengiriman.
     */
    private static double calculateCost(double weight) {
        return weight * 10; // Asumsi Rp10 per kg
    }

    /**
     * Menampilkan semua paket yang tersimpan.
     */
    private static void readPackages() {
        System.out.println("\n=== Lihat semua Packages ===");
        if (packages.isEmpty()) {
            System.out.println("Packages tidak ditemukan.");
            return;
        }

        for (Package pkg : packages.values()) {
            System.out.println(pkg);
        }
    }

    /**
     * Memperbarui informasi paket berdasarkan ID.
     *
     * @throws InvalidInputException Jika ID paket tidak ditemukan atau input tidak valid.
     * @throws IOException Jika jalur gambar tidak valid.
     */
    private static void updatePackage() throws InvalidInputException, IOException {
        System.out.println("\n=== Update Package ===");
        System.out.print("Masukan ID package: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (!packages.containsKey(id)) {
            throw new InvalidInputException("ID Package tidak ditemukan.");
        }

        Package pkg = packages.get(id);

        System.out.print("Masukan deskripsi baru(atau tekan Enter agar tidak berubah): ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            pkg.setDescription(description);
        }

        System.out.print("Masukan berat baru kg(atau tekan Enter agar tidak berubah): ");
        String weightInput = scanner.nextLine();
        if (!weightInput.isEmpty()) {
            double weight = Double.parseDouble(weightInput);
            if (weight <= 0) {
                throw new InvalidInputException("Weight must be greater than 0.");
            }
            pkg.setWeight(weight);
            pkg.setCost(calculateCost(weight));
        }

        System.out.print("Masukan tujuan baru(atau tekan Enter agar tidak berubah): ");
        String destination = scanner.nextLine();
        if (!destination.isEmpty()) {
            pkg.setDestination(destination);
        }

        System.out.print("Masukan path baru untuk foto package (atau tekan Enter agar tidak berubah): ");
        String imagePath = scanner.nextLine();
        if (!imagePath.isEmpty()) {
            validateImagePath(imagePath);
            pkg.setImagePath(imagePath);
        }

        System.out.println("Package berhasil diupdate: " + pkg);
    }

    /**
     * Menghapus paket berdasarkan ID.
     *
     * @throws InvalidInputException Jika ID paket tidak ditemukan.
     */
    private static void deletePackage() throws InvalidInputException {
        System.out.println("\n=== Hapus Package ===");
        System.out.print("Masukan ID package: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (!packages.containsKey(id)) {
            throw new InvalidInputException("ID Package tidak ditemukan.");
        }

        packages.remove(id);
        System.out.println("Package berhasil dihapus.");
    }

    /**
     * Membuka gambar paket berdasarkan jalur file.
     *
     * @throws InvalidInputException Jika ID paket tidak ditemukan.
     * @throws IOException Jika gambar tidak ditemukan atau tidak bisa dibuka.
     */
    private static void viewImage() throws InvalidInputException, IOException {
        System.out.println("\n=== Lihat Gambar Package ===");
        System.out.print("Masukan ID package: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (!packages.containsKey(id)) {
            throw new InvalidInputException("ID Package tidak ditemukan.");
        }

        Package pkg = packages.get(id);
        String imagePath = pkg.getImagePath();

        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            throw new IOException("Gambar tidak ditemukan di path: " + imagePath);
        }

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(imageFile);
            System.out.println("Gambar berhasil dibuka: " + imagePath);
        } else {
            System.out.println("Desktop tidak mendukung membuka file.");
        }
    }

    /**
     * Memvalidasi jalur file gambar.
     *
     * @param imagePath Jalur file gambar.
     * @throws IOException Jika jalur tidak valid atau file tidak ditemukan.
     */
    private static void validateImagePath(String imagePath) throws IOException {
        File file = new File(imagePath);
        if (!file.exists() || !file.isFile()) {
            throw new IOException("Path gambar tidak valid: " + imagePath);
        }
    }
}
