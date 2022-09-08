public class Variable {
    public static void main(String[] args) {
        String name;
        name = "Arif Saputra";
        int age = 18;
        String city = "Semarang";
        System.out.println(name);
        System.out.println(age);
        System.out.println(city);

        city = "Pati";
        System.out.println(city);

        // Variable var
        // var myName // Error
        var myName = "Arif Saputra";
        System.out.println(myName);

        // Kata Kunci final
        final String myNames = "Arif Saputra";
        System.out.println(myNames);
        // myNames = "Ganti Nama"; // Error
    }
}
