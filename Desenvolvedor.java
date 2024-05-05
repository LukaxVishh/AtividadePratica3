import java.util.ArrayList;

import interfaces.trabalhavel;

class Desenvolvedor extends Funcionario implements trabalhavel {
    private ArrayList<String> tecnologias;
    private int nivelExperiencia; 
    private double salarioBase; 

    public Desenvolvedor(String nome, int matricula, double salarioBase, int nivelExperiencia) {
        super(nome, matricula);
        this.tecnologias = new ArrayList<>();
        this.salarioBase = salarioBase;
        this.nivelExperiencia = nivelExperiencia;
    }

    public void adicionarTecnologia(String tecnologia) {
        tecnologias.add(tecnologia);
    }

    @Override
    public double calcularSalario() {

        double bonusExperiencia = 0;
        switch (nivelExperiencia) {
            case 1:
                bonusExperiencia = 10000; 
                break;
            case 2:
                bonusExperiencia = 15000; 
                break;
            case 3:
                bonusExperiencia = 20000; 
                break;
            default:
                bonusExperiencia = 0; 
        }

        return salarioBase + bonusExperiencia;
    }

    public void trabalhar() {
        System.out.println("Desenvolvedor " + nome + " esta codificando.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Desenvolvedor " + nome + " esta relatando o progresso do desenvolvimento.");
    }

    public ArrayList<String> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(ArrayList<String> tecnologias) {
        this.tecnologias = tecnologias;
    }

    
    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}