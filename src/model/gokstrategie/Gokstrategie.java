package model.gokstrategie;

public enum Gokstrategie {
    ELKEWORPEVEN("Het aantal ogen is bij elke worp een even getal", 4),
    SOMIS21("De som van de ogen van alle worpen samen is 21", 5),
    ELKEWORPHOGERDANVORIGE("Het aantal ogen is bij elke worp hoger dan bij de vorige worp", 10),
    ALTIJDWINST("je wint altijd", 2);

    private String volledigeUitleg;
    private double rendement;

    Gokstrategie(String volledigeUitleg, double rendement) {
        setVolledigeUitleg(volledigeUitleg);
        setRendement(rendement);
    }

    public void setVolledigeUitleg(String volledigeUitleg) {
        this.volledigeUitleg = volledigeUitleg;
    }

    public void setRendement(double rendement) {
        this.rendement = rendement;
    }

    public String getVolledigUitleg() {
        return volledigeUitleg;
    }

    public double getRendement() {
        return rendement;
    }
}
