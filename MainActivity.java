 package usuario.app.sistemadecadastro;
        import java.util.ArrayList;
        import android.os.Bundle;
        import android.app.Activity;
        import android.app.AlertDialog;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

 public class MainActivity extends Activity {
     EditText nota1,peso1, nota2, peso2;
     EditText aula,faltas;
     Button btsomar, btfrequencia;
    private ArrayList<Registro> aRegistro;
    TelaPrincipal tela_principal;
    TelaCadastroUsuario tela_cadastro;
    TelaListagemUsuarios tela_listagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aRegistro = new ArrayList<Registro>();
        tela_principal = new TelaPrincipal(this);
        tela_cadastro = new TelaCadastroUsuario(this, tela_principal);
        tela_listagem = new TelaListagemUsuarios(this, tela_principal);
        tela_principal.setTelaCadastro(tela_cadastro);
        tela_principal.setTelaListagem(tela_listagem);
        tela_principal.CarregarTela();
        nota1 = (EditText) findViewById(R.id.ednota1);
        nota2 = (EditText) findViewById(R.id.ednota2);
        peso1 = (EditText) findViewById(R.id.edpeso1);
        peso2 = (EditText) findViewById(R.id.edpeso2);
        aula = (EditText) findViewById(R.id.edaulas);
        faltas = (EditText) findViewById(R.id.edfaltas);
        btsomar = (Button) findViewById(R.id.btcalcular);
        btfrequencia = (Button) findViewById(R.id.btfrequencia);
        btsomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(
                        nota1.getText().toString());
                double n2 = Double.parseDouble(
                        nota2.getText().toString());
                double p1 = Double.parseDouble(
                        peso1.getText().toString());
                double p2 = Double.parseDouble(
                        peso2.getText().toString());
                double media = (n1 * p1 + n2 * p2) / (p1 + p2);
                AlertDialog.Builder dialogo = new
                        AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Resultado da Média");
                dialogo.setMessage("A Média é " + media);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }

        });

        btfrequencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aula1 = Double.parseDouble(
                        aula.getText().toString());
                double falta1 = Double.parseDouble(
                        faltas.getText().toString());
                double f = (falta1 / aula1) * 100;
                AlertDialog.Builder dialogo = new
                        AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Resultado da sua Frequencia");
                if ((falta1 / aula1) <= 0.25) {
                    dialogo.setMessage("Aprovado " + f + "% de faltas");
                } else {
                    dialogo.setMessage("Reprovado " + f + "% de faltas");
                }
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }

        });
    }
    public ArrayList<Registro> getRegistros() {
        return aRegistro;
    }

    public void ExibirMensagem(String msg) {
        AlertDialog.Builder d = new
                AlertDialog.Builder(MainActivity.this);
        d.setTitle("Aviso");
        d.setMessage(msg);
        d.setNeutralButton("OK", null);
        d.show();
    }
}