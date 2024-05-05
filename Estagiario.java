import interfaces.trabalhavel;

class Estagiario extends Funcionario implements trabalhavel {
    private int horasTrabalho;
    private String supervisor;
    private double taxaHora; 

    public Estagiario(String nome, int matricula, int horasTrabalho, String supervisor, double taxaHora) {
        super(nome, matricula);
        this.horasTrabalho = horasTrabalho;
        this.supervisor = supervisor;
        this.taxaHora = taxaHora;
    }

    @Override
    public void trabalhar() {
        System.out.println("Estagiario " + nome + " esta aprendendo e trabalhando nas tarefas designadas.");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Estagiario " + nome + " esta relatando seu progresso.");
    }

    @Override
    public double calcularSalario() {
       
        return horasTrabalho * taxaHora;
    }

    public int getHorasTrabalho() {
        return horasTrabalho;
    }

    public void setHorasTrabalho(int horasTrabalho) {
        this.horasTrabalho = horasTrabalho;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public double getTaxaHora() {
        return taxaHora;
    }

    public void setTaxaHora(double taxaHora) {
        this.taxaHora = taxaHora;
    }
}