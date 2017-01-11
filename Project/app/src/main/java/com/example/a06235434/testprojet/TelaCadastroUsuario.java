package usuario.app.sistemadecadastro;
import android.app.*;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class TelaCadastroUsuario {
    MainActivity act;
    EditText ednome,nota1, nota2, aulas, faltas;
    Button btcadastrar, btcancelar_cadastro;
    TelaPrincipal tela_principal;
    public TelaCadastroUsuario(MainActivity act, TelaPrincipal
            tela_principal)
    {
        this.act = act;
        this.tela_principal = tela_principal;
    }
    public void CarregarTela()
    {
        act.setContentView(R.layout.cadastro_de_usuarios);
        ednome = (EditText) act.findViewById(R.id.ednome);
        nota1 = (EditText) act.findViewById(R.id.ednota1);
        nota2 = (EditText) act.findViewById(R.id.edtnota2);
        aulas = (EditText) act.findViewById(R.id.edaula);
        faltas = (EditText) act.findViewById(R.id.edtfalta);

        btcadastrar = (Button) act.findViewById(R.id.btcadastrar);
        btcancelar_cadastro = (Button)
                act.findViewById(R.id.btcancelar_cadastro);
        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new
                        AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar Aluno ?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                String nome =
                                        ednome.getText().toString();
                                double n1 = Double.parseDouble(
                                        nota1.getText().toString());
                                double n2 = Double.parseDouble(
                                        nota2.getText().toString());
                                double aulas1 = Double.parseDouble(
                                        aulas.getText().toString());
                                double faltas1 = Double.parseDouble(
                                        faltas.getText().toString());
                                act.getRegistros().add(new
                                        Registro(nome,n1,n2,aulas1,faltas1));

                                act.ExibirMensagem("Cadastro do aluno efetuado com sucesso.");
                                        tela_principal.CarregarTela();
                            }
                        });
                dialogo.show();
            }
        });
        btcancelar_cadastro.setOnClickListener(new
                                                       View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {
                                                               AlertDialog.Builder dialogo = new
                                                                       AlertDialog.Builder(act);
                                                               dialogo.setTitle("Aviso");
                                                               dialogo.setMessage("Sair do cadastro do aluno ?");
                                                               dialogo.setNegativeButton("Não", null);

                                                               dialogo.setPositiveButton("Sim", new
                                                                       DialogInterface.OnClickListener() {
                                                                           @Override
                                                                           public void onClick(DialogInterface dialog,
                                                                                               int which) {
                                                                               tela_principal.CarregarTela();
                                                                           }
                                                                       });
                                                               dialogo.show();
                                                           }
                                                       });
    }
}