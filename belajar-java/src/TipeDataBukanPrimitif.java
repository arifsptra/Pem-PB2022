public class TipeDataBukanPrimitif {
    public static void main(String[] args) {
        Integer iniInteger = 100;
        Long iniLong = 100000L;
        Byte iniByte = null;
        iniByte = 10;

        // Konevrsi ke tipe data primitif
        int iniIntegerPrimitif = iniInteger.intValue();
        short iniShortPrimitif = iniInteger.shortValue();
        long iniLongPrimitif = iniInteger.longValue();
        float iniFloatPrimitif = iniInteger.floatValue();
    }
}
