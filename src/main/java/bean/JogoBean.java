package bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
    
    public void exibirMaiorNumeroValores(Jogo jogo) {
        int maior = Math.max(jogo.getV1(), Math.max(jogo.getV2(), Math.max(jogo.getV3(), Math.max(jogo.getV4(), jogo.getV5()))));
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "O maior número entre esses valores é: " + maior, ""));
    }

	public void verificarNumeroSorteado(Jogo jogo) {
		boolean contem = jogo.getV1().equals(jogo.getNumeroSorteado()) || jogo.getV2().equals(jogo.getNumeroSorteado())
				|| jogo.getV3().equals(jogo.getNumeroSorteado()) || jogo.getV4().equals(jogo.getNumeroSorteado())
				|| jogo.getV5().equals(jogo.getNumeroSorteado());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Contem o numero Sorteado?", (contem ? "Sim" : "Não")));
	}
	
	public void exibirMaiorNumeroSorteado(Jogo jogo) {
		int maiorNumeroSorteado = JogoDAO.obterMaiorNumeroSorteado(jogo);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "O maior numero Sorteado é: " + maiorNumeroSorteado, ""));
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