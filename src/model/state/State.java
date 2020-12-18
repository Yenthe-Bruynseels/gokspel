package model.state;

import model.Dobbelsteen;
import model.gokstrategie.GokstrategieStrategy;

public interface State {

    default int werpDobbelsteen(Dobbelsteen dobbie) {
        throw new IllegalArgumentException("Kan dobbelsteen niet werpen.");
    }

    default boolean evalueerWorp(int worp, GokstrategieStrategy gokstrategie) {
        throw new IllegalArgumentException("Kan worp niet evalueren.");
    }

    default void bevestigKeuze(){
        throw new IllegalArgumentException("Kan keuze niet bevestigen.");
    }

    default void startSpel() {
        throw new IllegalArgumentException("Kan spel niet starten nu.");
    }

    default void vraagVerhoog(){
        throw new IllegalArgumentException("Kan niet verhogen.");
    }

    default void verhoogInzet(){
        throw new IllegalArgumentException("Kan inzet niet verhogen.");
    }

    default void vermeerderSaldo(double winstfactor, double ingezetBedrag) {
        throw new IllegalArgumentException("Kan saldo niet vermeerderen.");
    }

    default void verminderSaldo(double ingezetBedrag){
        throw new IllegalArgumentException("Kan saldo niet verminderen.");
    }
}
