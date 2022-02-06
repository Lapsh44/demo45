package spring.demo.demo.web;

class Programm {
    public static void main(String[] args) {
        double rubles;
        double rateUSD;

        rubles = 30000.0;
        rateUSD=78.5;
        double dollars = rubles / rateUSD;
        System.out.print("«У вас на счету "+ rubles +" рублей. В долларах это "+dollars +" долларов. Так держать!».");

    }
}