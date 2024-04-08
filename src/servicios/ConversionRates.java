package servicios;

import java.lang.reflect.Field;

public class ConversionRates {
    private double MXN;
    private double CLP;
    private double USD;
    private double ANG;


    public double getMXN() {
        return MXN;
    }

    public void setMXN(double MXN) {
        this.MXN = MXN;
    }

    public double getCLP() {
        return CLP;
    }

    public void setCLP(double CLP) {
        this.CLP = CLP;
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double getANG() {
        return ANG;
    }

    public void setANG(double ANG) {
        this.ANG = ANG;
    }

    public double getValorCampo(String moneda) {
        try {
            Field field = ConversionRates.class.getDeclaredField(moneda);
            return field.getDouble(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Error al obtener el valor "+ e);
            return 0.0; // O algún valor por defecto
        }
    }

    @Override
    public String toString() {
        return "ConversionRates{" +
                "MXN=" + MXN +
                ", CLP=" + CLP +
                ", USD=" + USD +
                ", ANG=" + ANG +
                '}';
    }
}