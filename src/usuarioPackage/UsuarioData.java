package usuarioPackage;

public class UsuarioData {

    private int idUsuario;
    private String CPF;
    private String nomeUsuario;
    private String emailUsuario;
    private String cidadeUsuario;
    private String telefone;

    public UsuarioData(int idUsuario, String CPF, String nomeUsuario, String emailUsuario, String cidadeUsuario, String telefone) {
        this.idUsuario = idUsuario;
        this.CPF = CPF;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.cidadeUsuario = cidadeUsuario;
        this.telefone = telefone;
    }

    public static class ConfirmadoInfo {
        private int idUsuario;
        private String nomeUsuario;

        public ConfirmadoInfo(int idUsuario, String nomeUsuario) {
            this.idUsuario = idUsuario;
            this.nomeUsuario = nomeUsuario;
        }

        public int getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        public String getNomeUsuario() {
            return nomeUsuario;
        }

        public void setNomeUsuario(String nomeUsuario) {
            this.nomeUsuario = nomeUsuario;
        }
    }
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getCidadeUsuario() {
        return cidadeUsuario;
    }

    public void setCidadeUsuario(String cidadeUsuario) {
        this.cidadeUsuario = cidadeUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "UsuarioData{" +
                "idUsuario=" + idUsuario +
                ", CPF='" + CPF + '\'' +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", emailUsuario='" + emailUsuario + '\'' +
                ", cidadeUsuario='" + cidadeUsuario + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }



    public UsuarioData() {
    }
}
