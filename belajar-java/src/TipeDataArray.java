public class TipeDataArray {
    public static void main(String[] args) {
        String[] arrayString;
        arrayString = new String[3];
        arrayString[0] = "Arif";
        arrayString[1] = "Saputra";
        arrayString[2] = "Dewa";
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayString[i]);
        }

        // Array Initializer
        int[] arrayInt = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        System.out.println(arrayInt[2]);
        long[] arrayLong = {
                10L, 20L, 30L
        };
        System.out.println(arrayLong[1]);
        // mencari panjang array
        System.out.println(arrayLong.length);

        // Array didalam Array
        String[][] members = {
                {"Arif", "Saputra"},
                {"Tiara", "Malsa"},
                {"Khoirul", "Nasid", "Furqon"}
        };
        System.out.println(members[0][1]);
        System.out.println(members[1][0]);
        System.out.println(members[2][2]);
    }
}
