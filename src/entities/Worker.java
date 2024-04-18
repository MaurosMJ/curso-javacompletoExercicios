package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private double baseSalary;
	private Department department = new Department();
	private List<HourContract> contracts = new ArrayList<>();

	public Worker(String dept_p, String name, WorkerLevel level, Double salary) {
		this.department.setName(dept_p);
		this.name = name;
		this.level = level;
		this.baseSalary = salary;
	}

    public double income(int year, int month) {
        double totalIncome = 0f;
        for (HourContract contract : contracts) {
            Date date = contract.getDate();
            @SuppressWarnings("deprecation")
            int contractYear = date.getYear() + 1900;
            @SuppressWarnings("deprecation")
            int contractMonth = date.getMonth() + 1;
            if (contractYear == (year+1900) && contractMonth == (month+1)) {
                totalIncome += contract.totalValue();
            }
        }
        return totalIncome+baseSalary;
    }

	public void addContract(HourContract contracts) {
		this.contracts.add(contracts);
	}

	public void removeContract(HourContract contracts) {
		this.contracts.remove(contracts);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

}
