public class KonversiNumber {
    public static void main(String[] args) {
        // Widening Casting (otomatis) = byte > short > int > long > float > double
        byte iniByte = 10;
        short iniShort = iniByte;
        int iniInt = iniShort;
        long iniLong = iniInt;
        float iniFloat = iniLong;
        double iniDouble = iniFloat;

        // Narrowing Casting (manual) = double > float > long > int > short > byte
        double iniDouble2 = 10.10;
        float iniFloat2 = (float) iniDouble2;
        long iniLong2 = (long) iniFloat2;
        int iniInt2 = (int) iniLong2;
        short iniShort2 = (short) iniInt2;
        byte iniByte2 = (byte) iniShort2;
        System.out.println(iniDouble2);
        System.out.println(iniFloat2);
        System.out.println(iniLong2);
        System.out.println(iniInt2);
        System.out.println(iniShort2);
        System.out.println(iniByte2);
    }
}
