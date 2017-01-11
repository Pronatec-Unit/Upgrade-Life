package usuario.app.sistemadecadastro;
public class Registro {
    private String nome;
    private double nota1, nota2;
    private double aulas, faltas;

    public Registro(String nome, double nota1, double nota2, double aulas,  double faltas)
    {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.aulas=aulas;
        this.faltas=faltas;
    }
    public String getNome() { return nome; }
    public double getNota1(){return nota1;}
    public double getNota2(){return nota2;}
    public double getAulas(){return aulas;}
    public double getFaltas(){return faltas;}
    public double calcularMedia(){return ((nota1*4+nota2*6)/10);}
    public String calcularFrequencia(){
        String n= null;
        double f= (this.faltas/this.aulas)*100;

        if ((faltas/aulas)<=0.25){
            n=("Aprovado " + f+"% de faltas");
        }else{
            n=("Reprovado " + f +"% de faltas");
        }
return n;
        }
}