package eventoPackage;

public class EventoData {
    private int idEvento;
    private String nomeEvento;
    private String localEvento;
    private String categoriaEvento;

    private String descricaoEvento;

    private String emailProducao;

    private int telefoneProducao;

    private int horarioEvento;

    public EventoData(int idEvento, String nomeEvento, String localEvento, String categoriaEvento, String descricaoEvento, String emailProducao, int telefoneProducao, int horarioEvento) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.localEvento = localEvento;
        this.categoriaEvento = categoriaEvento;
        this.descricaoEvento = descricaoEvento;
        this.emailProducao = emailProducao;
        this.telefoneProducao = telefoneProducao;
        this.horarioEvento = horarioEvento;
    }

    public String toString() {
        return "eventoPackage.eventoData{" +
                "idEvento=" + idEvento +
                ", nomeEvento='" + nomeEvento + '\'' +
                ", localEvento='" + localEvento + '\'' +
                ", categoriaEvento='" + categoriaEvento + '\'' +
                ", descricaoEvento='" + descricaoEvento + '\'' +
                ", emailProducao='" + emailProducao + '\'' +
                ", telefoneProducao=" + telefoneProducao +
                ", horarioEvento=" + horarioEvento +
                '}';
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public String getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(String categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getEmailProducao() {
        return emailProducao;
    }

    public void setEmailProducao(String emailProducao) {
        this.emailProducao = emailProducao;
    }

    public int getTelefoneProducao() {
        return telefoneProducao;
    }

    public void setTelefoneProducao(int telefoneProducao) {
        this.telefoneProducao = telefoneProducao;
    }

    public int getHorarioEvento() {
        return horarioEvento;
    }

    public void setHorarioEvento(int horarioEvento) {
        this.horarioEvento = horarioEvento;
    }
}
