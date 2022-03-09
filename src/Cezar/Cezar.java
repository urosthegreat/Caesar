package Cezar;

import java.util.Scanner;

public class Cezar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int slucaj = 0;

        do {
            System.out.println("1: Sifruj \n2: Desifruj\n3: Izadji");

            slucaj = s.nextInt();

            switch (slucaj) {
                case 1:

                    Scanner tekst = new Scanner(System.in);
                    System.out.println("Unesite tekst za sifrovanje ");
                    String otvorenaPoruka = tekst.nextLine();

                    Scanner pomeraj = new Scanner(System.in);
                    System.out.println("Unesite kljuc ");
                    int kljuc = pomeraj.nextInt();

                    System.out.println("Otvoreni tekst je: " + otvorenaPoruka);
                    System.out.println("Pomeraj / Kljuc je: " + kljuc);

                    String sifrat = encrypt(otvorenaPoruka, kljuc).toString();
                    System.out.println("Sifrat je: " + sifrat);
                break;
                case 2:

                    Scanner tekst2 = new Scanner(System.in);
                    System.out.println("Unesite tekst za desifrovanje ");
                    String zatvorenaPoruka = tekst2.nextLine();

                    Scanner pomeraj2 = new Scanner(System.in);
                    System.out.println("Unesite kljuc ");
                    kljuc = pomeraj2.nextInt();

                    System.out.println("Sifrat je: " + zatvorenaPoruka);
                    System.out.println("Pomeraj / Kljuc je: " + kljuc);

                    String desifrovanaPoruka = decrypt(zatvorenaPoruka, kljuc).toString();
                    System.out.println("Desifrovana poruka je: " + desifrovanaPoruka);
                    break;

            }
        }
        while (slucaj != 3);
    }


    public static StringBuffer encrypt(String poruka, int pomeraj) {

        StringBuffer rezultat = new StringBuffer();

        for (int i = 0; i < poruka.length(); i++) {
            if (Character.isUpperCase(poruka.charAt(i))) {

                char slovo = (char) (((int) poruka.charAt(i) + pomeraj + 65) % 26 - 65);
                rezultat.append(slovo);
            } else {
                char slovo = (char) (((int) poruka.charAt(i) + pomeraj + 97) % 26 - 97);
                rezultat.append(slovo);
            }
        }
        return rezultat;
    }

    public static StringBuffer decrypt(String poruka, int pomeraj) {
        StringBuffer rezultat = new StringBuffer();

        for (int i = 0; i < poruka.length(); i++) {
            if (Character.isUpperCase(poruka.charAt(i))) {

                char slovo = (char) (((int) poruka.charAt(i) - pomeraj + 65) % 26 - 65);
                rezultat.append(slovo);
            } else {
                char slovo = (char) (((int) poruka.charAt(i) - pomeraj + 97) % 26 - 97);
                rezultat.append(slovo);
            }
        }

        return rezultat;
    }
}

