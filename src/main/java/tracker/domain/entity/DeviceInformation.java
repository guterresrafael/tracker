package tracker.domain.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matheus Xavier
 */
@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@Entity
//@Table(name="deviceInformation")
public class DeviceInformation implements Serializable {
    
    //@Id
    private Long id;
    private String modelo;
    private String nome;
    private String password;
    private String padraoComandos;
    private String numeroChip1;
    private String numeroChip2;
    private String operadora;
    
    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "device")
    private Device device;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPadraoComandos() {
        return padraoComandos;
    }

    public void setPadraoComandos(String padraoComandos) {
        this.padraoComandos = padraoComandos;
    }

    public String getNumeroChip1() {
        return numeroChip1;
    }

    public void setNumeroChip1(String numeroChip1) {
        this.numeroChip1 = numeroChip1;
    }

    public String getNumeroChip2() {
        return numeroChip2;
    }

    public void setNumeroChip2(String numeroChip2) {
        this.numeroChip2 = numeroChip2;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
    
    

}
