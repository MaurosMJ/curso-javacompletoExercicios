import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import Utils.CurrencyConverter;
import entities.Account;
import entities.Account1;
import entities.Circle;
import entities.Client;
import entities.Comment;
import entities.Employee;
import entities.Employee2;
import entities.Employee3;
import entities.HourContract;
import entities.ImportedProduct;
import entities.LegalPerson;
import entities.Logs;
import entities.NaturalPerson;
import entities.Order;
import entities.OrderItem;
import entities.OutsourcedEmployee;
import entities.Person;
import entities.Pessoa;
import entities.Post;
import entities.Product;
import entities.Product1;
import entities.Product2;
import entities.Rectangle;
import entities.Rectangle1;
import entities.Shape;
import entities.Student;
import entities.Student2;
import entities.UsedProduct;
import entities.Worker;
import entities.enums.Color;
import entities.enums.OrderStatus;
import entities.enums.WorkerLevel;
import entities.exception.NotBalanceException;
import entities.exception.WithdrawLimitException;
import model.service.BrazilTaxService;
import model.service.ContractService;
import model.service.PaypalService;
import model.service.RentalService;
import models.entities.CarRental;
import models.entities.Contract;
import models.entities.Vehicle;

public class Program {

	private static Scanner input = new Scanner(System.in).useLocale(Locale.US);
	private static Rectangle rec;
	private static Employee emp;
	private static Student stu;
	private static Account acc;

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		ex27();
	}

	private static void ex1() {
		System.out.println("Enter rectangle width and height:");
		double w = input.nextDouble();
		double h = input.nextDouble();
		rec = new Rectangle(w, h);
		System.out.println(rec.toString());
	}

	private static void ex2() {
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Gross salary: ");
		double GrossSalary = input.nextDouble();
		System.out.print("Tax: ");
		double Tax = input.nextDouble();
		emp = new Employee(name, GrossSalary, Tax);
		System.out.println("Employee: " + name + ", $ " + String.format("%.2f", emp.NetSalary()));
		System.out.print("Which percentage to increase salary? ");
		emp.IncreaseSalary(input.nextDouble());
	}

	private static void ex3() {
		String name = input.nextLine();
		double nota1 = input.nextDouble();
		double nota2 = input.nextDouble();
		double nota3 = input.nextDouble();
		stu = new Student(name, nota1, nota2, nota3);
		System.out.println(stu.toString());
	}

	private static void ex4() {
		System.out.println(String.format("%.2f", CurrencyConverter.dolBRL(3.10, 200.00)));
	}

	private static void ex5() {
		System.out.print("Enter account number: ");
		int accountNum = input.nextInt();
		input.nextLine();
		System.out.print("Enter account holder: ");
		String accountHolder = input.nextLine();
		String option;

		do {
			System.out.print("Is there an initial deposit: ");
			option = input.next().toLowerCase();

			if (option.charAt(0) == 'y') {
				System.out.print("Enter initial deposit value: ");
				double accountBalance = input.nextDouble();
				acc = new Account(accountNum, accountHolder, accountBalance);
			} else if (option.charAt(0) == 'n') {
				acc = new Account(accountNum, accountHolder);
			} else {
				System.out.println("Invalid command.");
			}

		} while (option.charAt(0) != 'y' && option.charAt(0) != 'n');

		System.out.println("\nAccount data:");
		System.out.println(acc.toString());

		System.out.print("\nEnter a deposit value: ");
		acc.addBalance(input.nextDouble());
		System.out.println("Updated account data:");
		System.out.println(acc.toString());

		System.out.print("\nEnter a withdraw value: ");
		acc.withdraw(input.nextDouble());
		System.out.println("Updated account data:");
		System.out.print(acc.toString());

	}

	private static void ex6() {

		System.out.print("Quantos numeros voce vai digitar? ");
		int qtd = input.nextInt();

		if (qtd > 10) {
			qtd = 10;
		} else if (qtd < 0) {
			qtd = 1;
		}

		int[] vetor = new int[qtd];

		for (int i = 0; i < vetor.length; i++) {
			System.out.print("Digite um numero: ");
			vetor[i] = input.nextInt();
		}

		System.out.println("NUMEROS NEGATIVOS:");

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] < 0) {
				System.out.println(vetor[i]);
			}
		}

	}

	private static void ex7() {

		System.out.print("Quantos numeros voce vai digitar? ");
		int qtd = input.nextInt();

		if (qtd > 10) {
			qtd = 10;
		} else if (qtd < 0) {
			qtd = 1;
		}

		double[] vetor = new double[qtd];

		for (int i = 0; i < vetor.length; i++) {
			System.out.print("Digite um numero: ");
			vetor[i] = input.nextDouble();
		}

		String saida = "";
		double soma = 0;

		for (int i = 0; i < vetor.length; i++) {
			saida += vetor[i] + " ";
			soma += vetor[i];
		}

		System.out.println("Valores = " + saida);
		System.out.println("Soma = " + soma);
		System.out.println("Media = " + soma / vetor.length + 1);

	}

	private static void ex8() {

		int qtd_m16y = 0;
		double media = 0;
		String nome_m16y = "";

		System.out.print("Quantas pessoas serao digitas? ");
		int qtd = input.nextInt();

		if (qtd > 10) {
			qtd = 10;
		} else if (qtd < 0) {
			qtd = 1;
		}

		Pessoa[] vetor = new Pessoa[qtd];

		for (int i = 0; i < vetor.length; i++) {

			Pessoa pes = new Pessoa();

			System.out.println("Dados da " + (i + 1) + "a pessoa:");
			System.out.print("Nome: ");
			pes.setNome(input.next());

			System.out.print("Idade: ");
			pes.setIdade(input.nextInt());
			System.out.print("Altura: ");
			pes.setAltura(input.nextDouble());

			vetor[i] = pes;

		}

		for (int i = 0; i < vetor.length; i++) {

			if (vetor[i].getIdade() < 16) {
				qtd_m16y++;
				nome_m16y += vetor[i].getNome() + "\n";
			}
			media += vetor[i].getAltura();
		}

		System.out.println("Altura media = " + media / vetor.length);
		System.out.println("Pessoas com menos de 16 anos: " + (100 * qtd_m16y) / qtd + "%");
		System.out.println(nome_m16y);

	}

	private static void ex9() {

		String numPar = "";
		int qtd_numPar = 0;
		System.out.print("Quantos numeros voce vai digitar? ");
		int qtd = input.nextInt();

		if (qtd > 10) {
			qtd = 10;
		} else if (qtd < 0) {
			qtd = 1;
		}

		int[] vetor = new int[qtd];

		for (int i = 0; i < vetor.length; i++) {

			System.out.println("Digite um numero: ");
			vetor[i] = input.nextInt();
		}

		for (int i = 0; i < vetor.length; i++) {

			if (vetor[i] % 2 == 0) {
				numPar += vetor[i] + " ";
				qtd_numPar++;
			}

		}

		System.out.println("NUMEROS PARES:");
		System.out.println(numPar);
		System.out.println("QUANTIDADE DE PARES = " + qtd_numPar);

	}

	private static void ex10() {

		double higherNum = 0;
		int pos = 0;

		System.out.print("Quantos numeros voce vai digitar? ");
		int qtd = input.nextInt();

		if (qtd > 10) {
			qtd = 10;
		} else if (qtd < 0) {
			qtd = 1;
		}

		double[] vetor = new double[qtd];

		for (int i = 0; i < vetor.length; i++) {

			System.out.print("Digite um numero: ");
			vetor[i] = input.nextInt();
		}

		for (int i = 0; i < vetor.length; i++) {

			if (vetor[i] > higherNum) {
				higherNum = vetor[i];
				pos = i;
			}

		}

		System.out.println("MAIOR VALOR = " + higherNum);
		System.out.println("POSICAO DO MAIOR VALOR = " + pos);

	}

	private static void ex11() {

		System.out.print("How many rooms will be rented? ");
		int qtd = input.nextInt();

		if (qtd > 10) {
			qtd = 10;
		} else if (qtd < 0) {
			qtd = 1;
		}

		Student2[] vetor = new Student2[10];

		for (int i = 0; i < qtd; i++) {
			Student2 stu = new Student2();

			System.out.println("Rent #" + (i + 1) + ":");
			System.out.print("Name: ");
			input.nextLine();
			stu.setName(input.nextLine());
			System.out.print("Email: ");
			stu.setEmail(input.nextLine());
			System.out.print("Room: ");
			int pos = input.nextInt();
			vetor[pos] = stu;
		}

		System.out.println("Busy rooms:");

		for (int i = 0; i < vetor.length; i++) {

			if (vetor[i] != null) {
				System.out.println(i + ": " + vetor[i].getName() + ", " + vetor[i].getEmail());
			}

		}

	}

	private static void ex12() {

		System.out.print("How many employees will be registered? ");
		int qtd = input.nextInt();

		List<Employee2> list = new ArrayList<Employee2>();

		for (int c = 0; c < qtd; c++) { // QUESTIONA AO USUARIO
			Employee2 emp = new Employee2();
			System.out.println("Employee #" + (c + 1) + ":");
			System.out.print("ID: ");
			emp.setID(input.nextInt());
			input.nextLine();
			System.out.print("Name: ");
			emp.setName(input.nextLine());

			System.out.print("Salary: ");
			emp.setSalary(input.nextDouble());
			list.add(emp);
		}

		System.out.print("Enter the employee id that will have salary increase: ");
		int id = input.nextInt();
		System.out.print("Enter the percentage: ");
		int percent = input.nextInt();
		boolean exists = false;

		for (Employee2 x : list) { // REALIZA A BUSCA E SUBSTITUI VALOR
			if (x.getID() == id) {
				x.setSalary(x.getSalary() + (x.getSalary() * (percent / 100f)));
				exists = true;
			}
		}

		if (!exists) {
			System.out.println("This id does not exists!");
		}

		System.out.println("List of employees: ");
		for (Employee2 x : list) { // EXIBE LISTA DE FUNCIONARIOS
			System.out.println(x.getID() + "," + " " + x.getName() + ", " + String.format("%.2f", x.getSalary()));
		}

	}

	private static void ex13() {

		int lin = input.nextInt();
		int col = input.nextInt();
		int[][] mat = new int[lin][col];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = input.nextInt();
			}
		}

		int pos = input.nextInt();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == pos) {
					System.out.println("Position " + i + "," + j + ":");

					try {
						System.out.println("Left: " + mat[i][j - 1]);
					} catch (ArrayIndexOutOfBoundsException ex) {
					}
					try {
						System.out.println("Right: " + mat[i][j + 1]);
					} catch (ArrayIndexOutOfBoundsException ex) {
					}
					try {
						System.out.println("Up: " + mat[i - 1][j]);
					} catch (ArrayIndexOutOfBoundsException ex) {
					}
					try {
						System.out.println("Down: " + mat[i + 1][j]);
					} catch (ArrayIndexOutOfBoundsException ex) {
					}

				}
			}
		}

	}

	private static void ex14() {
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html

		LocalDate atual = LocalDate.now();
		LocalDateTime atual1 = LocalDateTime.now();
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

		LocalDateTime proximo = atual1.plusDays(3);

		Duration t1 = Duration.between(atual1, proximo);
		System.out.println(t1.toDays());
		System.out.println(t1.toHours());
		System.out.println(t1.getSeconds());
	}

	private static void ex15() throws ParseException {

		Date data;
		Date data1;
		String incomeDate;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter1 = new SimpleDateFormat("MM/yyyy");

		System.out.print("Enter department's name: ");
		String dept = input.next();
		System.out.println("Enter Worker data: ");
		System.out.print("Name: ");
		String name = input.next();
		System.out.print("Level: ");
		String work = input.next();
		System.out.print("Base salary: ");
		Double salary = input.nextDouble();
		Worker worker = new Worker(dept, name, WorkerLevel.valueOf(work), salary);
		System.out.print("How many contracts to this worker?: ");
		int cont = input.nextInt();

		for (int i = 0; i < cont; i++) {

			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			data = formatter.parse(input.next());
			System.out.print("Value per hour: ");
			double value = input.nextDouble();
			System.out.print("Duration (hours): ");
			int duration = input.nextInt();
			worker.addContract(new HourContract(data, value, duration));
		}

		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		incomeDate = input.next();
		data1 = formatter1.parse(incomeDate);
		System.out.println("Name: " + name);
		System.out.println("Department: " + dept);
		System.out.println("Income for " + incomeDate + ": " + worker.income(data1.getYear(), data1.getMonth()));
	}

	private static void ex16() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		Post post1 = new Post(LocalDateTime.parse("21/06/2018 13:05:44", formatter), "Traveling to New Zealand",
				"I'm going to visit this wonderful country!", 12);
		post1.addComment(new Comment("Have a nice trip"));
		post1.addComment(new Comment("Wow that's awesome!"));
		Post post2 = new Post(LocalDateTime.parse("28/07/2018 23:14:19", formatter), "Good night guys",
				"See you tomorrow", 5);
		post2.addComment(new Comment("Good night"));
		post2.addComment(new Comment("May the Force be with you"));

		System.out.println(post1);
		System.out.println(post2);
	}

	private static void ex17() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter Cliente data:");
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Email: ");
		String email = input.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String data = input.nextLine();
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = input.nextLine();
		System.out.print("How many items to this order? ");
		int itens = input.nextInt();
		Order ordem = new Order(LocalDateTime.now(), OrderStatus.valueOf(status),
				new Client(name, email, LocalDate.parse(data, formatter)));

		for (int c = 0; c < itens; c++) {
			System.out.println("Enter #" + (c + 1) + " item data:");
			System.out.print("Product name: ");
			input.nextLine();
			String productName = input.nextLine();
			System.out.print("Product price: ");
			double productPrice = input.nextDouble();
			System.out.print("Quantity: ");
			int qtd = input.nextInt();
			ordem.addItem(new OrderItem(qtd, productPrice, new Product(productName, productPrice)));
		}

		System.out.println(ordem);

	}

	private static void ex18() {
		StringBuilder str = new StringBuilder();
		List<Employee3> list = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int empNum = input.nextInt();

		for (int c = 0; c < empNum; c++) {
			System.out.println("Employee #" + (c + 1) + " data:");
			System.out.print("Outsourced (y/n)? ");
			String outSourced = String.valueOf(input.next().charAt(0)).toLowerCase();
			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Hours: ");
			int hours = input.nextInt();
			System.out.print("Value per hour: ");
			double value = input.nextDouble();
			if ("y".equals(outSourced)) {
				System.out.print("Additional Charge: ");
				double addtionalValue = input.nextDouble();
				Employee3 emp = new OutsourcedEmployee(name, hours, value, addtionalValue);
				list.add(emp);
			} else {
				Employee3 emp = new Employee3(name, hours, value);
				list.add(emp);
			}

		}

		str.append("PAYMENTS:\n");

		for (Employee3 c : list) {
			str.append(c.getName() + " - $ " + c.payment() + "\n");
		}

		System.out.println(str.toString());

	}

	private static void ex19() {

		List<Product1> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int empNum = input.nextInt();
		input.nextLine();

		for (int c = 0; c < empNum; c++) {
			System.out.println("Product #" + (c + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			String type = input.nextLine().trim().toLowerCase();
			System.out.print("Name: ");
			String name = input.nextLine();
			System.out.print("Price: ");
			double price = input.nextDouble();
			input.nextLine();

			if ("i".equals(type)) {
				System.out.print("Customs fee: ");
				double customFee = input.nextDouble();
				input.nextLine();
				list.add(new ImportedProduct(name, price, customFee));
			} else if ("c".equals(type)) {
				list.add(new Product1(name, price));
			} else if ("u".equals(type)) {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String dateString = input.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse(dateString, formatter);
				list.add(new UsedProduct(name, price, date));
			}
		}

		for (Product1 c : list) {
			System.out.println(c.priceTag());
		}

	}

	private static void ex20() {

		List<Person> list = new ArrayList<>();
		double totalAmount = 0;
		int taxPayers;

		System.out.print("Enter the number of tax payers: ");
		taxPayers = input.nextInt();
		input.nextLine();
		for (int c = 0; c < taxPayers; c++) {
			System.out.println("Tax payer #" + (c + 1) + " data:");
			String person;
			do {
				System.out.print("Individual or company (i/c)? ");
				person = input.next().toLowerCase();
			} while (!person.equals("i") && !person.equals("c"));

			if (person.equals("i")) {
				System.out.print("Name: ");
				input.nextLine();
				String name = input.nextLine();
				System.out.print("Anual income: ");
				double anualIncome = input.nextDouble();
				System.out.print("Health Expenditures: ");
				double healthExp = input.nextDouble();
				list.add(new NaturalPerson(name, anualIncome, healthExp));

			} else {
				System.out.print("Name: ");
				input.nextLine();
				String name = input.nextLine();
				System.out.print("Anual income: ");
				double anualIncome = input.nextDouble();
				System.out.print("Health Expenditures: ");
				int employeeNum = input.nextInt();
				list.add(new LegalPerson(name, anualIncome, employeeNum));
			}

		}

		System.out.println("TAXES PAID:");

		for (Person c : list) {

			System.out.println(c.toString());
			totalAmount += c.calcTaxes();
		}

		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", totalAmount));

	}

	private static void ex21() {

		List<Shape> list = new ArrayList<>();

		System.out.print("Enter the number of shapes: ");
		int cont = input.nextInt();

		for (int c = 0; c < cont; c++) {
			System.out.println("Shape " + "#" + (c + 1) + " data:");
			System.out.print("Rectangle or Circle (r\\c)? ");
			String str = String.valueOf(input.next());

			System.out.print("Color (BLACK\\BLUE\\RED): ");
			String color = input.next();
			input.nextLine();

			if ("r".equals(str)) {
				System.out.print("Width: ");
				double width = input.nextDouble();
				System.out.print("Height: ");
				double height = input.nextDouble();
				list.add(new Rectangle1(Color.valueOf(color), width, height));
			} else {
				System.out.print("Radius: ");
				double radius = input.nextDouble();
				list.add(new Circle(Color.valueOf(color), radius));
			}
		}

		System.out.println("SHAPE AREAS: ");

		for (Shape c : list) {
			System.out.println(String.format("%.2f", c.area()));
		}
	}

	private static void ex22() {

		System.out.println("Enter account data:");
		System.out.print("Number: ");
		int num = input.nextInt();
		System.out.print("Holder: ");
		input.nextLine();
		String holder = input.nextLine();
		System.out.print("Initial balance: ");
		double balance = input.nextDouble();
		System.out.print("Withdraw limit: ");
		double limit = input.nextDouble();
		Account1 acc = new Account1(num, holder, balance, limit);
		System.out.print("Enter amount for withdraw: ");
		double withdraw = input.nextDouble();

		try {
			acc.withdraw(withdraw);
			System.out.println(acc);
		} catch (WithdrawLimitException e) {
			System.out.println(e.getMessage());
		} catch (NotBalanceException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void ex23() {

		String inPath = "C:\\Users\\Mauros\\Documents\\in\\source.csv";
		String outPath = "C:\\Users\\Mauros\\Documents\\out\\out.csv";
		String word;
		List<Product2> lista = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(inPath))) {

			word = br.readLine();

			while (word != null) {

				String[] field = word.split(",");
				lista.add(new Product2(field[0], Double.parseDouble(field[1]), Integer.parseInt(field[2])));
				word = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {

			for (Product2 c : lista) {
				bw.write(c.toString());
				bw.newLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void ex24() {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do carro: ");
		String model = input.nextLine();
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(input.nextLine(), fmt);
		System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(input.nextLine(), fmt);
		System.out.print("Entre com o preço por hora: ");
		double priceHour = input.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		double priceDay = input.nextDouble();
		System.out.println("FATURA:");

		CarRental carrental = new CarRental(start, finish, new Vehicle(model));
		RentalService service = new RentalService(priceHour, priceDay, new BrazilTaxService());
		service.processInvoice(carrental);

		System.out.println("Pagamento Básico: " + String.format("%.2f", carrental.getInvoice().getBasicPayment()));
		System.out.println("Imposto: " + String.format("%.2f", carrental.getInvoice().getTax()));
		System.out.println("Pagamento Total: " + String.format("%.2f", carrental.getInvoice().totalPayment()));
	}

	private static void ex25() throws ParseException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int num = input.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(input.next(), formatter);
		System.out.print("Valor do contrato: ");
		double contractValue = input.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		int installments = input.nextInt();

		System.out.println("Parcelas:");
		ContractService service = new ContractService();
		Contract Obj = new Contract(num, data, contractValue);
		service.processContract(Obj, installments, new PaypalService());

		System.out.println(Obj.toString());

	}

	private static void ex26() {
		
		// C:\\Users\\Mauros\\Documents\\in\\outputLog.txt
		System.out.print("Enter file full path: ");
		String inPath = input.next();
		String word;
		Set<Logs> lista = new LinkedHashSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader(inPath))) {

			word = br.readLine();

			while (word != null) {

				String[] field = word.split(" ");
				lista.add(new Logs(field[0], field[1]));
				word = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("Total Users: " + lista.size());
	}
	
	private static void ex27() {
		char c = 'D';
		System.out.println((char) (c+1));
	}
}