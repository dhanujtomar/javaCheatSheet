import java.util.Scanner;

abstract class Account {
    Scanner input = new Scanner(System.in);

    abstract double calculateintrest();
};

class FDAccount extends Account {
    double amount, Genral, Senoir, interestRate, total;
    int noOfDays;
    int ageOfHolder;

    double calculateintrest() {
        System.out.println("Enter FD Amount: ");
        this.amount = input.nextDouble();
        System.out.println("Enter FD number of days: ");
        this.noOfDays = input.nextInt();
        System.out.println("Enter Your Age: ");
        this.ageOfHolder = input.nextInt();
        if (noOfDays < 0) {
            System.out.println("Invalid Days");
            System.exit(0);
        }
        if (ageOfHolder < 0) {
            System.out.println("Invalid age");
            System.exit(0);
        }
        ;
        if (amount < 10000000) {
            if ((noOfDays >= 7) && (noOfDays <= 14)) {
                Genral = 4.50;
                Senoir = 5.00;
            } else if ((noOfDays >= 15) && (noOfDays <= 29)) {
                Genral = 4.75;
                Senoir = 5.25;
            } else if ((noOfDays >= 30) && (noOfDays <= 45)) {
                Genral = 5.50;
                Senoir = 6.00;
            } else if ((noOfDays >= 46) && (noOfDays <= 60)) {
                Genral = 7;
                Senoir = 7.50;
            } else if ((noOfDays >= 61) && (noOfDays <= 184)) {
                Genral = 7.50;
                Senoir = 8.00;
            } else if ((noOfDays >= 185) && (noOfDays <= 365)) {
                Genral = 8.00;
                Senoir = 8.50;
            }
            interestRate = ((ageOfHolder < 50) ? Genral : Senoir);
        } else {
            if ((noOfDays >= 7) && (noOfDays <= 14)) {
                interestRate = 6.50;
            } else if ((noOfDays >= 15) && (noOfDays <= 29)) {
                interestRate = 6.75;
            } else if ((noOfDays >= 30) && (noOfDays <= 45)) {
                interestRate = 6.75;
            } else if ((noOfDays >= 46) && (noOfDays <= 60)) {
                interestRate = 8;
            } else if ((noOfDays >= 61) && (noOfDays <= 184)) {
                interestRate = 8.50;
            } else if ((noOfDays >= 185) && (noOfDays <= 365)) {
                interestRate = 10.00;
            }
        }
        total = ((amount * (interestRate) / 100));
        return total;
    }
}

class SBAccount extends Account {
    double interestRate, amount, Genral, Senoir, total;
    int choice;

    double calculateintrest() {
        System.out.println("Enter Amouont: ");
        this.amount = input.nextDouble();
        System.out.println("1.Nri account: ");
        System.out.println("2. Normal account: ");
        choice = input.nextInt();
        if (choice == 1) {
            interestRate = 0.06;
        } else if (choice == 2) {
            interestRate = 0.04;
        } else if (choice < 0 || choice > 2) {
            System.out.println("Worng Input ! ");
            System.exit(0);
        }
        return amount * interestRate;
    }
}

class RDAccount extends Account {
    double interestRate, amount, Genral, Senoir, total;
    int noofMonths;
    int ageOfHolder;

    double calculateintrest() {
        System.out.println("Enter RD Amount: ");
        this.amount = input.nextDouble();
        System.out.println("Enter RD Months: ");
        this.noofMonths = input.nextInt();
        System.out.println("Enter Your Age: ");
        this.ageOfHolder = input.nextInt();
        if (noofMonths < 0) {
            System.out.println("Invalid Months");
            return 0;
        }
        if (ageOfHolder < 0) {
            System.out.println("Invalid age");
            return 0;
        }
        if (noofMonths <= 6) {
            Genral = 7.50;
            Senoir = 8.00;
        } else if (noofMonths <= 9) {
            Genral = 7.55;
            Senoir = 8.25;
        } else if (noofMonths <= 12) {
            Genral = 8.00;
            Senoir = 8.50;
        } else if (noofMonths <= 15) {
            Genral = 8.25;
            Senoir = 8.75;
        } else if (noofMonths < 18) {
            Genral = 8.50;
            Senoir = 9.00;
        } else if (noofMonths < 21) {
            Genral = 8.75;
            Senoir = 9.25;
        }
        interestRate = ((ageOfHolder < 50) ? Genral : Senoir);
        total = ((amount * (interestRate) / 100));
        return total;
    }
}

public class acc {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Select the option: ");
            System.out.println("1. Interest Calculator SB: ");
            System.out.println("2. Interest Calculator FD: ");
            System.out.println("3. Interest Calculator RD: ");
            System.out.println("4. Exit");
            int choice;
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    SBAccount sb = new SBAccount();
                    System.out.println(sb.calculateintrest());
                    break;
                case 2:
                    FDAccount fb = new FDAccount();
                    System.out.println(fb.calculateintrest());
                    break;
                case 3:
                    RDAccount rd = new RDAccount();
                    rd.calculateintrest();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
