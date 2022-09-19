public class SwitchStatement {
    public static void main(String[] args) {
        var nilai="A";

        // switch case biasa
        switch (nilai) {
            case "A":
                System.out.println("Anda lulus dengan baik");
                break;
            case "B":
                System.out.println("Nilai anda baik");
                break;
            case "C":
                System.out.println("Nilai anda cukup");
                break;
            case "D":
                System.out.println("Anda tidak lulus");
                break;
            case "E":
                System.out.println("Anda salah jurusan");
                break;
        };

        // switch case lambda
        nilai = "B";
        switch (nilai) {
            case "A" -> System.out.println("Anda lulus dengan baik");
            case "B", "C" -> System.out.println("Anda lulus");
            case "D" -> System.out.println("Anda tidak lulus");
            default ->  {
                System.out.println("Mungkin anda salah jurusan");
            }
        };

        // switch case biasa
        nilai = "C";
        String ucapan;
        switch (nilai) {
            case "A" -> ucapan = "Anda lulus dengan baik";
            case "B", "C" -> ucapan = "Anda lulus";
            case "D" -> ucapan = "Anda tidak lulus";
            default ->  {
                ucapan = "Mungkin anda salah jurusan";
            }
        };
        System.out.println(ucapan);

        // switch case yield
        nilai = "D";
        ucapan = switch (nilai) {
            case "A":
                yield  "Anda lulus dengan baik";
            case "B", "C":
                yield "Anda lulus";
            case "D":
                yield "Anda tidak lulus";
            default:
                yield "Mungkin anda salah jurusan";
        };
        System.out.println(ucapan);
    }
}
