package view;

/**
 * Classe (camada de visão - DTO: Data Transfer Object) com atributos da autenticacao.
 *
 */
public class AutenticacaoDTO {

    private int            idAutenticacao;
    private String         usuario;
    private String         senha;
    private FuncionarioDTO funcionario;
    private String         incDH;
    private String         altDH;

    /**
     * Construtor da classe {@link AutenticacaoDTO}.
     */
    public AutenticacaoDTO( ) {
        setIdAutenticacao( 0  );
        setUsuario       ( "" );
        setSenha         ( "" );
    }

    /**
     * Construtor da classe {@link AutenticacaoDTO} sem o id.
     * 
     * @param usuario usuario
     * @param senha senha
     * @param funcionario {@link FuncionarioDTO}
     */
    public AutenticacaoDTO( String usuario, String senha, FuncionarioDTO funcionario ) {
        super();
        setUsuario    ( usuario     );
        setSenha      ( senha       );
        setFuncionario( funcionario );
    }

    /**
     * Construtor da classe {@link AutenticacaoDTO} com TODOS os atributos da classe.
     * 
     * @param idAutenticacao id da autenticacao
     * @param usuario usuario
     * @param senha senha
     * @param funcionario {@link FuncionarioDTO}
     */
    public AutenticacaoDTO( int idAutenticacao, String usuario, String senha, FuncionarioDTO funcionario ) {
        super();
        setIdAutenticacao( idAutenticacao );
        setUsuario       ( usuario        );
        setSenha         ( senha          );
        setFuncionario   ( funcionario    );
    }

    /**
     * Coleta Id da autenticacaoo.
     * 
     * @return Id da autenticacao.
     */
    public int getIdAutenticacao( ) {
        return idAutenticacao;
    }

    /**
     * Configura Id da autenticacao.
     * 
     * @param idAutenticacao id da autenticacao.
     */
    public void setIdAutenticacao( int idAutenticacao ) {
        this.idAutenticacao = idAutenticacao;
    }

    /**
     * Coleta o usuario.
     * 
     * @return usuario
     */
    public String getUsuario( ) {
        return usuario;
    }

    /**
     * Configura o usuario.
     * 
     * @param usuario usuario
     */
    public void setUsuario( String usuario ) {
        this.usuario = usuario;
    }

    /**
     * Coleta a senha.
     * 
     * @return senha
     */
    public String getSenha( ) {
        return senha;
    }

    /**
     * Configura a senha.
     * 
     * @param senha senha
     */
    public void setSenha( String senha ) {
        this.senha = senha;
    }

    /**
     * Coleta o funcionario a quem a autenticacao pertence.
     * 
     * @return {@link FuncionarioDTO}
     */
    public FuncionarioDTO getFuncionario( ) {
        return funcionario;
    }

    /**
     * Configura o funcionario a quem a autenticacao pertence.
     * 
     * @param funcionario {@link FuncionarioDTO}
     */
    public void setFuncionario( FuncionarioDTO funcionario ) {
        this.funcionario = funcionario;
    }

    /**
     * Coleta a data e a hora da inclusao da autenticacao
     * 
     * @return data e a hora da inclusao da autenticacao
     */
    public String getIncDH( ) {
        return incDH;
    }

    /**
     * Configura a data e a hora da inclusao da autenticao.
     * 
     * @param incDH data e a hora da inclusao da autenticacao
     */
    public void setIncDH( String incDH ) {
        this.incDH = incDH;
    }

    /**
     * Coleta a data e a hora da alteracao da autenticacao
     * 
     * @return data e a hora da alteracao da autenticacao
     */
    public String getAltDH( ) {
        return altDH;
    }

    /**
     * Configura data e hora da alteracao da autenticacao
     * 
     * @param altDH data e hora da alteracao da autenticacao
     */
    public void setAltDH( String altDH ) {
        this.altDH = altDH;
    }
}