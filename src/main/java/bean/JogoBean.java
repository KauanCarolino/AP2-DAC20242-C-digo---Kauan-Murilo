package bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.faces.bean.*;

import dao.JogoDAO;
import entidade.Jogo;

@ManagedBean
@ViewScoped
public class JogoBean {
    private Jogo jogo = new Jogo();
    private List<Jogo> jogos;

    public void salvar() {
        jogo.setDataCadastro(new Date());
        jogo.setNumeroSorteado(new Random().nextInt(10)+1);
        JogoDAO.salvar(jogo);
        jogo = new Jogo();
    }

    public List<Jogo> getJogos(){
        if (jogos == null){
            jogos = JogoDAO.Listar();
        }
        return jogos;
    }

    public void excluir(Jogo jogo) {
        JogoDAO.Excluir(jogo);
        jogos = JogoDAO.Listar();
    }

    public void editar(Jogo jogo) {
        System.out.println("Editing Jogo: " + jogo);
        JogoDAO.editar(jogo);
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }


}