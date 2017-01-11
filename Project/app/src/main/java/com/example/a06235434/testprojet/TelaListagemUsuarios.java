package usuario.app.sistemadecadastro;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class TelaListagemUsuarios {
    MainActivity act;
    TelaPrincipal tela_principal;
    Button btanterior, btproximo, btfechar;
    TextView txtnome, txtmedia, txtfrequencia, txtstatus, txtnota1, txtnota2, txtaulas, txtfaltas;
    int index;
    public TelaListagemUsuarios(MainActivity act,TelaPrincipal
            tela_principal) {
        this.act = act;
        this.tela_principal = tela_principal;
        index = 0;
    }

    public void CarregarTela()
    {
//Antes de carregar a tela, verifica se existe registros
//inseridos
        if(act.getRegistros().size() == 0)
        {
            (new AlertDialog.Builder(act))
                    .setTitle("Aviso")
                    .setMessage("Não existe nenhum registro cadastrado.")
                    .setNeutralButton("OK", null)
                    .show();
            return;
        }
        act.setContentView(R.layout.listagem_usuarios_cadastrados);
        btanterior = (Button) act.findViewById(R.id.btanterior);
        btproximo = (Button) act.findViewById(R.id.btproximo);
        btfechar = (Button) act.findViewById(R.id.btfechar);
        txtnome = (TextView) act.findViewById(R.id.txtnome);
        txtnota1 = (TextView) act.findViewById(R.id.txtnota1);
        txtnota2 = (TextView) act.findViewById(R.id.txtnota2);
        txtaulas = (TextView) act.findViewById(R.id.textaulas);
        txtfaltas = (TextView) act.findViewById(R.id.textfaltas);
        txtmedia = (TextView) act.findViewById(R.id.textmedia);
        txtfrequencia = (TextView) act.findViewById(R.id.txtfrequencia);
        txtstatus = (TextView) act.findViewById(R.id.txtstatus);
        PreencheCampos(index);
        AtualizaStatus(index);
        btanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index > 0)
                {
                    index--;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });
        btproximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index < act.getRegistros().size() - 1)
                {
                    index++;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }

            }
        });
        btfechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela_principal.CarregarTela();
            }
        });
    }
    private void PreencheCampos(int idx)
    {
        txtnome.setText(act.getRegistros().get(idx).getNome());
        txtnota1.setText(act.getRegistros().get(idx).getNota1()+"");
        txtnota2.setText(act.getRegistros().get(idx).getNota2()+"");
        txtaulas.setText(act.getRegistros().get(idx).getAulas()+"");
        txtfaltas.setText(act.getRegistros().get(idx).getFaltas()+"");
        txtmedia.setText(act.getRegistros().get(idx).calcularMedia()+"");
        txtfrequencia.setText(act.getRegistros().get(idx).calcularFrequencia()+"");
    }
    private void AtualizaStatus(int idx)
    {
        int total = act.getRegistros().size();
        txtstatus.setText("Registros : " + (idx+1) + "/" + total);
    }
}