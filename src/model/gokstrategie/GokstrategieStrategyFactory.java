package model.gokstrategie;

import model.database.DbException;

public class GokstrategieStrategyFactory {
    private static GokstrategieStrategyFactory uniqueFactory;

    private GokstrategieStrategyFactory(){}

    public static GokstrategieStrategyFactory getInstance() {
        if (uniqueFactory == null) {
            uniqueFactory = new GokstrategieStrategyFactory();
        }
        return uniqueFactory;
    }

    public GokstrategieStrategy getStrategy(String keuze) {
        String gekozenStrategie = "";
        switch (keuze) {
            case "EVEN":
                gekozenStrategie = "ElkeWorpEven";
                break;
            case "HOGER":
                gekozenStrategie = "ElkeWorpHogerDanVorige";
                break;
            case "altijd":
                gekozenStrategie = "AltijdWinst";
                break;
            case "21":
                gekozenStrategie = "SomIs21";
                break;
            default:
                System.out.println("manne de code is fout");
                gekozenStrategie = "losers";
        }
        GokstrategieStrategy gokstrategieStrategy = null;
        if (!gekozenStrategie.equals("losers")) {
            try {
                Class gokstrategieStrategyClass = Class.forName("model.gokstrategie." + gekozenStrategie);
                Object gokstrategieStrategyObject = gokstrategieStrategyClass.newInstance();
                gokstrategieStrategy = (GokstrategieStrategy) gokstrategieStrategyObject;
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                throw new DbException(e.getMessage());
            }
        }
        return gokstrategieStrategy;
    }
}
