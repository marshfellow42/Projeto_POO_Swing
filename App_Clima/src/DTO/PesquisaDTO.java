package DTO;

public class PesquisaDTO {

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isHistorico() {
        return historico;
    }

    public void setHistorico(boolean historico) {
        this.historico = historico;
    }

    public PesquisaDTO(String texto, boolean historico) {
        this.texto = texto;
        this.historico = historico;
    }

    public PesquisaDTO() {
    }
    
    private String texto;
    private boolean historico;
}
