package eventoPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventoData {
    private String nomeEvento;
    private String localEvento;
    private String categoriaEvento;

    private String descricaoEvento;

    private String emailProducao;

    private String telefoneProducao;

    private LocalDateTime horarioEvento;

    private int idUsuario;




    public EventoData(String nomeEvento, String localEvento, String categoriaEvento, String descricaoEvento, String emailProducao, String telefoneProducao, LocalDateTime horarioEvento, int idUsuario) {

        this.nomeEvento = nomeEvento;
        this.localEvento = localEvento;
        this.categoriaEvento = categoriaEvento;
        this.descricaoEvento = descricaoEvento;
        this.emailProducao = emailProducao;
        this.telefoneProducao = telefoneProducao;
        this.horarioEvento = horarioEvento;
        this.idUsuario = idUsuario;
    }


    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDate = horarioEvento.format(formatter);
        return
                " nomeEvento: " + nomeEvento + "\n" +
                " localEvento: " + localEvento + "\n" +
                " categoriaEvento: " + categoriaEvento + "\n" +
                " descricaoEvento: " + descricaoEvento + "\n" +
                " emailProducao: " + emailProducao + "\n" +
                " telefoneProducao: " + telefoneProducao + "\n" +
                        //passando o valor da data formatada
                " horarioEvento: " + formattedDate + "\n"
                ;
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

    public String getTelefoneProducao() {
        return telefoneProducao;
    }

    public void setTelefoneProducao(String telefoneProducao) {
        this.telefoneProducao = telefoneProducao;
    }

    public LocalDateTime getHorarioEvento() {
        return horarioEvento;
    }

    public void setHorarioEvento(LocalDateTime horarioEvento) {
        this.horarioEvento = horarioEvento;
    }

    public int getIdUsuario() {return idUsuario;}

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

