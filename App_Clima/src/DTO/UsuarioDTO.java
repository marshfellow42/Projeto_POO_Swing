package DTO;

public class UsuarioDTO {
    private int id_usuario;
    private String nome_usuario, senha_usuario;
    private String criar_nome_usuario, criar_senha_usuario;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public String getCriar_nome_usuario() {
        return criar_nome_usuario;
    }

    public void setCriar_nome_usuario(String criar_nome_usuario) {
        this.criar_nome_usuario = criar_nome_usuario;
    }

    public String getCriar_senha_usuario() {
        return criar_senha_usuario;
    }

    public void setCriar_senha_usuario(String criar_senha_usuario) {
        this.criar_senha_usuario = criar_senha_usuario;
    }
    
}
