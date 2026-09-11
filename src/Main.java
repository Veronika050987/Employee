import java.util.Scanner;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество сотрудников (N): ");
        int n = scanner.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nВвод данных для сотрудника #" + (i + 1) + ":");
            System.out.print("Имя: ");
            String name = scanner.next();

            System.out.print("Базовая зарплата: ");
            double baseSalary = scanner.nextDouble();

            System.out.print("Тип ('M' - Manager, 'D' - Developer): ");
            char type = scanner.next().toUpperCase().charAt(0);

            switch (type) {
                case 'M':
                    employees[i] = new Manager(name, baseSalary);
                    break;
                case 'D':
                    employees[i] = new Developper(name, baseSalary);
                    break;
                default:
                    System.out.println("Неизвестный тип. Создан обычный сотрудник.");
                    employees[i] = new Employee(name, baseSalary);
                    break;
            }
            }
        System.out.println("\n--- ИТОГОВАЯ ВЕДОМОСТЬ ---");
        double totalPayout = 0;

        for (Employee emp : employees) {
            double pay = emp.calculatePay();
            totalPayout += pay;

            System.out.printf("Сотрудник: %s | Базовая: %.2f | К выплате: %.2f\n",
                    emp.getName(), emp.getSalary(), pay);
        }

        System.out.printf("\nОбщая сумма выплат по компании: %.2f\n", totalPayout);

        scanner.close();
    }