import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("\nВыберите операцию и введите её номер:\n" +
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать ситему налогооблажения");

            String input = scanner.nextLine();

            if ("end".equals(input)) {
                System.out.println("\nПрограмма завершена!");
                break;
            } else {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода : ");
                        String moneyStr = scanner.nextLine();
                        int money = Integer.parseInt(moneyStr);
                        earnings += money;
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода : ");
                        String moneyStr1 = scanner.nextLine();
                        int money1 = Integer.parseInt(moneyStr1);
                        spendings += money1;
                        break;
                    case 3:
                        int tax1 = taxEarnings(earnings);
                        int tax2 = taxEarningsMinusSpendings(earnings, spendings);
                        int diff = Math.abs(tax1 - tax2);
                        if (tax1 < tax2) {
                            System.out.println("\nМы советуем вам УСН доходы\n" +
                                    "Ваш налог составит: " + tax1 + "\n" +
                                    "Налог на другой ситеме: " + tax2 + "\n" +
                                    "Экономия: " + diff);
                        } else {
                            System.out.println("\nМы советуем вам УСН доходы минус расходы\n" +
                                    "Ваш налог составит: " + tax2 + "\n" +
                                    "Налог на другой ситеме: " + tax1 + "\n" +
                                    "Экономия: " + diff);
                        }
                        break;
                    default:
                        System.out.println("Такой операции нет!");
                }

            }
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

}

