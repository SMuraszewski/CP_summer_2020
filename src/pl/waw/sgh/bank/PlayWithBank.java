package pl.waw.sgh.bank;

public class PlayWithBank {

    public static void main(String[] args) {
        Bank myBank = new Bank();
        Customer c1 = myBank.newCustomer("Pawel", "Rubach", "pawel.rubach@sgh.waw.pl");
        Customer c2 = myBank.newCustomer("Anna", "Smith", "anna.smith@sgh.waw.pl");

        Account a1 = myBank.newDebitAccount("EUR", c1);
        a1.deposit(150d);

        a1.charge(40d);
        Account a2 = myBank.newSavingsAccount("EUR", c2);

        myBank.transfer(4, 7, 60d);

        //myBank.transfer(a1.getId(), a2.getId(), 60d);
        System.out.println(myBank);
        //System.exit(100);
    }
}
