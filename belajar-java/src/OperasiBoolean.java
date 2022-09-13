public class OperasiBoolean {
    public static void main(String[] args) {
        // operasi boolean
        // && = and
        // || = or
        // ! = not
        var absen = 74;
        var nilaiAkhir = 88;

        var lulusAbsen = absen >= 75;
        var lulusNilai = nilaiAkhir >= 75;

        var lulus = lulusAbsen && lulusNilai;
        System.out.println(lulus);
        lulus = lulusAbsen || lulusNilai;
        System.out.println(lulus);
    }
}
