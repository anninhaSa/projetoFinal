package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe com atributos da telefone.
 */
@Entity
@SequenceGenerator(name = "seq_telefone", sequenceName = "seq_telefone")
public class Telefone {
    public static final transient int s_nTpCelular     = 1;
    public static final transient int s_nTpResidencial = 2;
    public static final transient int s_nTpComercial   = 3;

    @Id
    @GeneratedValue(generator = "seq_telefone")
    private Integer idTelefone;

    @Column(length = 2)
    private String ddd;

    @Column(length = 9)
    private String telefone;

    @Column(name = "tipo")
    private Integer tipo;

    @ManyToOne
    @JoinColumn(name = "id_contato")
    private Contato contato;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date incDH;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date altDH;

    public Telefone() {
        setIdTelefone(0 );
        setDDD       ("");
        setTelefone  ("");
        setTipo      (0 );
    }

    /**
     * Construtor da classe {@link Telefone}.
     * 
     * @param intIdTelefone Codigo identificador do Telefone
     * @param strDDD DDD
     * @param strTelefone Telefone
     * @param intTipo Tipo do telefone: 
     * <div style="margin-left: 35px">
     * <ul>
     * <li>1 - Celular</li>
     * <li>2 - Residencial</li>
     * <li>3 - Comercial</li>
     * </ul>
     * </div>
     */
    public Telefone(Integer intIdTelefone, String strDDD, String strTelefone, Integer intTipo) {
        setIdTelefone(intIdTelefone);
        setDDD       (strDDD       );
        setTelefone  (strTelefone  );
        setTipo      (intTipo      );
        setContato   (new Contato());
    }

    /**
     * Construtor da classe {@link Telefone}.
     * 
     * @param idTelefone Codigo identificador do Telefone
     * @param ddd DDD
     * @param telefone Telefone
     * @param tipo Tipo do telefone: 
     * <div style="margin-left: 35px">
     * <ul>
     * <li>1 - Celular</li>
     * <li>2 - Residencial</li>
     * <li>3 - Comercial</li>
     * </ul>
     * </div>
     * @param contato {@link Contato}
     */
    public Telefone(Integer idTelefone, String ddd, String telefone, Integer tipo, Contato contato) {
        setIdTelefone(idTelefone);
        setDDD       (ddd       );
        setTelefone  (telefone  );
        setTipo      (tipo      );
        setContato   (contato   );
    }

    /**
     * Construtor da classe {@link Telefone}.
     * 
     * @param strDDD DDD
     * @param strTelefone Telefone
     * @param intTipo Tipo do telefone: 
     * <div style="margin-left: 35px">
     * <ul>
     * <li>1 - Celular</li>
     * <li>2 - Residencial</li>
     * <li>3 - Comercial</li>
     * </ul>
     * </div>
     */
    public Telefone(String strDDD, String strTelefone, Integer intTipo) {
        setDDD     (strDDD     );
        setTelefone(strTelefone);
        setTipo    (intTipo    );
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString( ) {
        return "Telefone [idTelefone=" + idTelefone + ", ddd=" + ddd + ", telefone=" + telefone + ", tipo=" + tipo + "]";
    }

    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getDDD() {
        return ddd;
    }

    public void setDDD(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Coleta tipo de telefone.
     * 
     * @return <b>1</b> caso o tipo do telefone seja <i>Celular</i>, <b>2</b> caso seja <i>Residencial</i> e <b>3</b> caso seja
     * <i>Comercial</i>
     */
    public Integer getTipo() {
        return tipo;
    }

    /**
     * Configura tipo do telefone.
     * <ul>
     * <li>1 - Celular</li>
     * <li>2 - Residencial</li>
     * <li>3 - Comercial</li>
     * </ul>
     * 
     * @param tipo
     */
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    /**
     * Coleta a data e a hora da inclusão do telefone
     * 
     * @return {@link Date} com a data e a hora da inclusão do telefone
     */
    public Date getIncDH() {
        return incDH;
    }

    /**
     * Configura a data e a hora da inclusão do telefone.
     * 
     * @param incDH {@link Date} com a data e a hora da inclusão do telefone
     */
    public void setIncDH(Date incDH) {
        this.incDH = incDH;
    }

    /**
     * Coleta a data e a hora da alteração do telefone
     * 
     * @return {@link Date} com a data e a hora da alteração do telefone
     */
    public Date getAltDH() {
        return altDH;
    }

    /**
     * Configura data e hora da alteração do telefone
     * 
     * @param altDH {@link Date} com a data e hora da alteração do telefone
     */
    public void setAltDH(Date altDH) {
        this.altDH = altDH;
    }
    
    public String toView() {
        return "(" + this.getDDD() + ")" + this.getTelefone().substring(0, 4) + "-" +this.getTelefone().substring(4);
    }
}