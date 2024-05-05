import java.util.ArrayList;

import interfaces.trabalhavel;

class Gerente extends Funcionario implements trabalhavel{
    private double bonusAnual;
    private ArrayList<Funcionario> equipe;
    private double salarioBase;

    public Gerente(String nome, int matricula, double bonusAnual) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
        this.equipe = new ArrayList<>();
    }

    public void adicionarMembroEquipe(Funcionario funcionario) {
        equipe.add(funcionario);
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bonusAnual;
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente " + nome + " esta gerenciando sua equipe.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Gerente " + nome + " esta relatando o progresso do projeto.");
    }

    public double getBonusAnual() {
        return bonusAnual;
    }

    public void setBonusAnual(double bonusAnual) {
        this.bonusAnual = bonusAnual;
    }

    public ArrayList<Funcionario> getEquipe() {
        return equipe;
    }

    public void setEquipe(ArrayList<Funcionario> equipe) {
        this.equipe = equipe;
    }
}
