package model.gokstrategie;

/** @Authors Yenthe, Cisse, Lennert*/

public enum Gokstrategie {
    ELKEWORPEVEN("Het aantal ogen is bij elke worp een even getal", 4, true),
    SOMIS21("De som van de ogen van alle worpen samen is 21", 5, true),
    ELKEWORPHOGERDANVORIGE("Het aantal ogen is bij elke worp hoger dan bij de vorige worp", 10, true),
    ALTIJDWINST("je wint altijd", 2, true),
    ALTIJDVERLOREN("Je verliest altijd", 100, true);

    private String volledigeUitleg;
    private double winstfactor;
    private boolean actief;

    Gokstrategie(String volledigeUitleg, double winstfactor, boolean actief) {
        setVolledigeUitleg(volledigeUitleg);
        setWinstfactor(winstfactor);
        setActief(actief);
    }

    public void setVolledigeUitleg(String volledigeUitleg) {
        this.volledigeUitleg = volledigeUitleg;
    }

    public void setWinstfactor(double winstfactor) {
        this.winstfactor= winstfactor;
    }

    public String getVolledigUitleg() {
        return volledigeUitleg;
    }

    public double getWinstfactor() {
        return winstfactor;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }

    public boolean getActief() {
        return this.actief;
    }
}
