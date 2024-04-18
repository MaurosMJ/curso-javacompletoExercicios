package entities;

public class Student {

	private String nome;
	private double nota1;
	private double nota2;
	private double nota3;

	public Student(String nome, double nota1, double nota2, double nota3) {

		this.setNome(nome);
		this.setNota1(nota1);
		this.setNota2(nota2);
		this.setNota3(nota3);

	}

	private double sum() {
		return this.nota1 + this.nota2 + this.nota3;
	}

	public String toString() {

		if (this.sum() >= 60) {
			return "FINAL GRADE = "+this.sum()+"\nPASS";
		} else {
			return "FINAL GRADE = "+this.sum()+"\nFAILED\n" + "MISSING " + this.failedSum() + " POINTS";
		}

	}

	private double failedSum() {
		return 60 - this.sum();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

}
