package edu.udistrital.nomina.nominavaquiro.model;
import java.io.Serializable;


public class Nomina implements Serializable{


    private static final long serialVersionUID = 1L;

    private String idnomina; 
    private Cliente cliente;
    private double inversion;
    private int plazoDias;
    private double tasaInteresesAnual;
    
    	
    private transient double gananciaBruta;
    private transient double retencionFuente;
    private transient double gananciaNeta;
    private transient double valorTotal;

    public Nomina() {
    }

    public Nomina(String idCdt, Cliente cliente, double inversion, int plazoDias, double tasaInteresesAnual) {
        this.idnomina = idCdt;
        this.cliente = cliente;
        this.inversion = inversion;
        this.plazoDias = plazoDias;
        this.tasaInteresesAnual = tasaInteresesAnual;
        calcularnomina();
    }

    public void calcularnomina() {
        this.gananciaBruta = calcularGananciaBruta();
        this.retencionFuente = calcularRetencionFuente();
        this.gananciaNeta = calcularGananciaNeta();
        this.valorTotal = calcularValorTotal();
    }

    public double calcularGananciaBruta() {
        return (inversion * (tasaInteresesAnual / 100)) * (plazoDias / 365.0);
    }

    public double calcularRetencionFuente() {
        return gananciaBruta * 0.04; 
    }

    public double calcularGananciaNeta() {
        return gananciaBruta - retencionFuente;
    }

    public double calcularValorTotal() {
        return inversion + gananciaNeta;
    }

	public String getIdnomina() {
		return idnomina;
	}

	public void setIdnomina(String idnomina) {
		this.idnomina = idnomina;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getInversion() {
		return inversion;
	}

	public void setInversion(double inversion) {
		this.inversion = inversion;
	}

	public int getPlazoDias() {
		return plazoDias;
	}

	public void setPlazoDias(int plazoDias) {
		this.plazoDias = plazoDias;
	}

	public double getTasaInteresesAnual() {
		return tasaInteresesAnual;
	}

	public void setTasaInteresesAnual(double tasaInteresesAnual) {
		this.tasaInteresesAnual = tasaInteresesAnual;
	}

	public double getGananciaBruta() {
		return gananciaBruta;
	}

	public void setGananciaBruta(double gananciaBruta) {
		this.gananciaBruta = gananciaBruta;
	}

	public double getRetencionFuente() {
		return retencionFuente;
	}

	public void setRetencionFuente(double retencionFuente) {
		this.retencionFuente = retencionFuente;
	}

	public double getGananciaNeta() {
		return gananciaNeta;
	}

	public void setGananciaNeta(double gananciaNeta) {
		this.gananciaNeta = gananciaNeta;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

    
}