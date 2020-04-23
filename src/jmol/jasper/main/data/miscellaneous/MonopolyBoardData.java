package jmol.jasper.main.data.miscellaneous;

import jmol.jasper.main.data.boardspaces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonopolyBoardData {
     /**
     * The names of the boardspaces.
     */
    public static final String START = "Start";
    public static final String DORPSSTRAAT = "Dorpsstraat";
    public static final String BRINK = "Brink";
    public static final String INKOMSTENBELASTING = "Inkomstenbelasting";
    public static final String STATION_ZUID = "Station Zuid";
    public static final String STEENSTRAAT = "Steenstraat";
    public static final String KETELSTRAAT = "Ketelstraat";
    public static final String VELPERPLEIN = "Velperplein";
    public static final String GEVANGENIS = "Gevangenis";
    public static final String BARTELJORISSTRAAT = "Barteljorisstraat";
    public static final String ELEKTRICITEITSBEDRIJF = "Elektriciteitsbedrijf";
    public static final String ZIJLWEG = "Zijlweg";
    public static final String GROTE_HOUTSTRAAT = "Grote Houtstraat";
    public static final String STATION_WEST = "Station West";
    public static final String NEUDE = "Neude";
    public static final String BILTSTRAAT = "Biltstraat";
    public static final String VREEBURG = "Vreeburg";
    public static final String VRIJ_PARKEREN = "Vrij parkeren";
    public static final String A_KERKHOF = "A Kerkhof";
    public static final String GROTE_MARKT = "Grote Markt";
    public static final String HEERESTRAAT = "Heerestraat";
    public static final String STATION_NOORD = "Station Noord";
    public static final String SPUI = "Spui";
    public static final String PLEIN = "Plein";
    public static final String WATERLEIDING = "Waterleiding";
    public static final String LANGE_POTEN = "Lange Poten";
    public static final String GA_NAAR_DE_GEVANGENIS = "Ga naar de gevangenis";
    public static final String HOFPLEIN = "Hofplein";
    public static final String BLAAK = "Blaak";
    public static final String COOLSINGEL = "Coolsingel";
    public static final String STATION_OOST = "Station Oost";
    public static final String LEIDSE_PLEIN = "Leidse Plein";
    public static final String LUXE_BELASTING = "Luxe belasting";
    public static final String KALVERSTRAAT = "Kalverstraat";
    public static final String KANS = "Kans";
    public static final String ALGEMEEN_FONDS = "Algemeen Fonds";

    /**
     * The indexes of the boardspaces.
     */
    public static final int SPACENR_START = 0;
    public static final int SPACENR_DORPSSTRAAT = 1;
    public static final int SPACENR_ALGEMEEN_FONDS_1 = 2;
    public static final int SPACENR_BRINK = 3;
    public static final int SPACENR_INKOMSTENBELASTING = 4;
    public static final int SPACENR_STATION_ZUID = 5;
    public static final int SPACENR_STEENSTRAAT = 6;
    public static final int SPACENR_KANS_1 = 7;
    public static final int SPACENR_KETELSTRAAT = 8;
    public static final int SPACENR_VELPERPLEIN = 9;
    public static final int SPACENR_GEVANGENIS = 10;
    public static final int SPACENR_BARTELJORISSTRAAT = 11;
    public static final int SPACENR_ELEKTRICITEITSBEDRIJF = 12;
    public static final int SPACENR_ZIJLWEG = 13;
    public static final int SPACENR_GROTE_HOUTSTRAAT = 14;
    public static final int SPACENR_STATION_WEST = 15;
    public static final int SPACENR_NEUDE = 16;
    public static final int SPACENR_ALGEMEEN_FONDS_2 = 17;
    public static final int SPACENR_BILTSTRAAT = 18;
    public static final int SPACENR_VREEBURG = 19;
    public static final int SPACENR_VRIJ_PARKEREN = 20;
    public static final int SPACENR_A_KERKHOF = 21;
    public static final int SPACENR_KANS_2 = 22;
    public static final int SPACENR_GROTE_MARKT = 23;
    public static final int SPACENR_HEERESTRAAT = 24;
    public static final int SPACENR_STATION_NOORD = 25;
    public static final int SPACENR_SPUI = 26;
    public static final int SPACENR_PLEIN = 27;
    public static final int SPACENR_WATERLEIDING = 28;
    public static final int SPACENR_LANGE_POTEN = 29;
    public static final int SPACENR_GA_NAAR_DE_GEVANGENIS = 30;
    public static final int SPACENR_HOFPLEIN = 31;
    public static final int SPACENR_BLAAK = 32;
    public static final int SPACENR_ALGEMEEN_FONDS_3 = 33;
    public static final int SPACENR_COOLSINGEL = 34;
    public static final int SPACENR_STATION_OOST = 35;
    public static final int SPACENR_KANS_3 = 36;
    public static final int SPACENR_LEIDSE_PLEIN = 37;
    public static final int SPACENR_LUXE_BELASTING = 38;
    public static final int SPACENR_KALVERSTRAAT = 39;
    public static final int MAX_BOARDSPACE_NR = 39;

    /**
     * De nextBoardspace types.
     */
    public enum BoardspaceType {
        STATION(4, "Station", false),
        UTILITY(2, "NutsBedrijf", false),
        STREET_DORP(2, "Dorp", true),
        STREET_ARNHEM(3, "Arhnem", true),
        STREET_HAARLEM(3, "Haarlem", true),
        STREET_UTRECHT(3, "Utrecht", true),
        STREET_GRONINGEN(3, "Groningen", true),
        STREET_DEN_HAAG(3, "Den Haag", true),
        STREET_ROTTERDAM(3, "Rotterdam", true),
        STREET_AMSTERDAM(2, "Amsterdam", true),
        START(1, "Start", false),
        CARD(6, "KaartVak", false),
        GO_TO_JAIL(1, "Ga naar de gevangenis", false),
        JAIL(1, "Gevangenis", false),
        FREE_PARKING(1, "Vrij parkeren", false),
        TAX(2, "Belasting", false);

        private int nrOfTypes;
        private String name;
        private boolean isCity;

        private BoardspaceType(int nrOfTypes, String name, boolean isCity) {
            this.nrOfTypes = nrOfTypes;
            this.name = name;
            this.isCity = isCity;
        }

        public int getNrOfTypes() {
            return nrOfTypes;
        }

        public String getName() {
            return name;
        }

        public boolean getIsCity() {
            return isCity;
        }
    }

    /**
     * The rent for zero to five houses.
     */
    public static final int[] DORP_HUUR_NORMAAL = new int[]{2, 10, 30, 90, 160, 250};
    public static final int[] DORP_HUUR_DUUR = new int[]{4, 20 ,60, 180, 320, 450};
    public static final int[] ARNHEM_HUUR_NORMAAL = new int[]{6, 30, 90, 270, 400, 550};
    public static final int[] ARNHEM_HUUR_DUUR = new int[]{8, 40, 120, 360, 450, 600};
    public static final int[] HAARLEM_HUUR_NORMAAL = new int[]{10, 50, 150, 450, 625, 750};
    public static final int[] HAARLEM_HUUR_DUUR = new int[]{12, 60, 180, 500, 700, 900};
    public static final int[] UTRECHT_HUUR_NORMAAL = new int[]{14, 70, 200, 550, 750, 950};
    public static final int[] UTRECHT_HUUR_DUUR = new int[]{16, 80, 220, 600, 800, 1000};
    public static final int[] GRONINGEN_HUUR_NORMAAL = new int[]{18, 90, 250, 700, 875, 1050};
    public static final int[] GRONINGEN_HUUR_DUUR = new int[]{20, 100, 300, 750, 925, 1100};
    public static final int[] DEN_HAAG_HUUR_NORMAAL = new int[]{22, 110, 330, 800, 975, 1150};
    public static final int[] DEN_HAAG_HUUR_DUUR = new int[]{24, 120, 360, 850, 1025, 1200};
    public static final int[] ROTTERDAM_HUUR_NORMAAL = new int[]{26, 130, 390, 900, 1100, 1275};
    public static final int[] ROTTERDAM_HUUR_DUUR = new int[]{28, 150, 450, 1000, 1200, 1400};
    public static final int[] AMSTERDAM_HUUR_NORMAAL = new int[]{35, 175, 500, 1100, 1300, 1500};
    public static final int[] AMSTERDAM_HUUR_DUUR = new int[]{50, 200, 600, 1400, 1700, 2000};

    /**
     * The houseprices.
     */
    public static final int DORP_ARHNEM_HUISPRIJS = 50;
    public static final int HAARLEM_UTRECHT_HUISPRIJS = 100;
    public static final int GRONINGEN_DEN_HAAG_HUISPRIJS = 150;
    public static final int ROTTERDAM_AMSTERDAM_HUISPRIJS = 200;

    /**
     * The values of the property.
     */
    public static final int DORP_WAARDE_NORMAAL = 60;
    public static final int DORP_WAARDE_DUUR = 60;
    public static final int ARNHEM_WAARDE_NORMAAL = 100;
    public static final int ARNHEM_WAARDE_DUUR = 120;
    public static final int HAARLEM_WAARDE_NORMAAL = 140;
    public static final int HAARLEM_WAARDE_DUUR = 160;
    public static final int UTRECHT_WAARDE_NORMAAL = 180;
    public static final int UTRECHT_WAARDE_DUUR = 200;
    public static final int GRONINGEN_WAARDE_NORMAAL = 220;
    public static final int GRONINGEN_WAARDE_DUUR = 240;
    public static final int DEN_HAAG_WAARDE_NORMAAL = 260;
    public static final int DEN_HAAG_WAARDE_DUUR = 280;
    public static final int ROTTERDAM_WAARDE_NORMAAL = 300;
    public static final int ROTTERDAM_WAARDE_DUUR = 320;
    public static final int AMSTERDAM_WAARDE_NORMAAL = 350;
    public static final int AMSTERDAM_WAARDE_DUUR = 400;
    public static final int STATION_WAARDE = 200;
    public static final int NUTS_WAARDE = 150;

    /**
     * Taxation values.
     */
    public static final int BEDRAG_INKOMENSBELASTING = 200;
    public static final int BEDRAG_LUXE_BELASTING = 100;

    /**
    * The Monopoly board.
    */
    public static final Boardspace[] MONOPOLYBOARD = new Boardspace[]{
           new Start(START, SPACENR_START, BoardspaceType.START),
           new Street(DORPSSTRAAT, SPACENR_DORPSSTRAAT, BoardspaceType.STREET_DORP, DORP_WAARDE_NORMAAL, DORP_ARHNEM_HUISPRIJS, DORP_HUUR_NORMAAL),
           new CommunityChest(ALGEMEEN_FONDS, SPACENR_ALGEMEEN_FONDS_1, BoardspaceType.CARD),
           new Street(BRINK, SPACENR_BRINK, BoardspaceType.STREET_DORP, DORP_WAARDE_DUUR, DORP_ARHNEM_HUISPRIJS, DORP_HUUR_DUUR),
           new Taxation(INKOMSTENBELASTING, SPACENR_INKOMSTENBELASTING, BoardspaceType.TAX, BEDRAG_INKOMENSBELASTING),
           new Station(STATION_ZUID, SPACENR_STATION_ZUID, BoardspaceType.STATION, STATION_WAARDE),
           new Street(STEENSTRAAT, SPACENR_STEENSTRAAT, BoardspaceType.STREET_ARNHEM, ARNHEM_WAARDE_NORMAAL, DORP_ARHNEM_HUISPRIJS, ARNHEM_HUUR_NORMAAL),
           new Chance(KANS, SPACENR_KANS_1, BoardspaceType.CARD),
           new Street(KETELSTRAAT, SPACENR_KETELSTRAAT, BoardspaceType.STREET_ARNHEM, ARNHEM_WAARDE_NORMAAL, DORP_ARHNEM_HUISPRIJS, ARNHEM_HUUR_NORMAAL),
           new Street(VELPERPLEIN, SPACENR_VELPERPLEIN, BoardspaceType.STREET_ARNHEM, ARNHEM_WAARDE_DUUR, DORP_ARHNEM_HUISPRIJS, ARNHEM_HUUR_DUUR),
           new Jail(GEVANGENIS, SPACENR_GEVANGENIS, BoardspaceType.JAIL),
           new Street(BARTELJORISSTRAAT, SPACENR_BARTELJORISSTRAAT, BoardspaceType.STREET_HAARLEM, HAARLEM_WAARDE_NORMAAL, HAARLEM_UTRECHT_HUISPRIJS, HAARLEM_HUUR_NORMAAL),
           new Utility(ELEKTRICITEITSBEDRIJF, SPACENR_ELEKTRICITEITSBEDRIJF, BoardspaceType.UTILITY, NUTS_WAARDE),
           new Street(ZIJLWEG, SPACENR_ZIJLWEG, BoardspaceType.STREET_HAARLEM, HAARLEM_WAARDE_NORMAAL, HAARLEM_UTRECHT_HUISPRIJS, HAARLEM_HUUR_NORMAAL),
           new Street(GROTE_HOUTSTRAAT, SPACENR_GROTE_HOUTSTRAAT, BoardspaceType.STREET_HAARLEM, HAARLEM_WAARDE_DUUR, HAARLEM_UTRECHT_HUISPRIJS, HAARLEM_HUUR_DUUR),
           new Station(STATION_WEST, SPACENR_STATION_WEST, BoardspaceType.STATION, STATION_WAARDE),
           new Street(NEUDE, SPACENR_NEUDE, BoardspaceType.STREET_UTRECHT, UTRECHT_WAARDE_NORMAAL, HAARLEM_UTRECHT_HUISPRIJS, UTRECHT_HUUR_NORMAAL),
           new CommunityChest(ALGEMEEN_FONDS, SPACENR_ALGEMEEN_FONDS_2, BoardspaceType.CARD),
           new Street(BILTSTRAAT, SPACENR_BILTSTRAAT, BoardspaceType.STREET_UTRECHT, UTRECHT_WAARDE_NORMAAL, HAARLEM_UTRECHT_HUISPRIJS, UTRECHT_HUUR_NORMAAL),
           new Street(VREEBURG, SPACENR_VREEBURG, BoardspaceType.STREET_UTRECHT, UTRECHT_WAARDE_DUUR, HAARLEM_UTRECHT_HUISPRIJS, UTRECHT_HUUR_DUUR),
           new Freeparking(VRIJ_PARKEREN, SPACENR_VRIJ_PARKEREN, BoardspaceType.FREE_PARKING),
           new Street(A_KERKHOF, SPACENR_A_KERKHOF, BoardspaceType.STREET_GRONINGEN, GRONINGEN_WAARDE_NORMAAL, GRONINGEN_DEN_HAAG_HUISPRIJS, GRONINGEN_HUUR_NORMAAL),
           new Chance(KANS, SPACENR_KANS_2, BoardspaceType.CARD),
           new Street(GROTE_MARKT, SPACENR_GROTE_MARKT, BoardspaceType.STREET_GRONINGEN, GRONINGEN_WAARDE_NORMAAL, GRONINGEN_DEN_HAAG_HUISPRIJS, GRONINGEN_HUUR_NORMAAL),
           new Street(HEERESTRAAT, SPACENR_HEERESTRAAT, BoardspaceType.STREET_GRONINGEN, GRONINGEN_WAARDE_DUUR, GRONINGEN_DEN_HAAG_HUISPRIJS, GRONINGEN_HUUR_DUUR),
           new Station(STATION_NOORD, SPACENR_STATION_NOORD, BoardspaceType.STATION, STATION_WAARDE),
           new Street(SPUI, SPACENR_SPUI, BoardspaceType.STREET_DEN_HAAG, DEN_HAAG_WAARDE_NORMAAL, GRONINGEN_DEN_HAAG_HUISPRIJS, DEN_HAAG_HUUR_NORMAAL),
           new Street(PLEIN, SPACENR_PLEIN, BoardspaceType.STREET_DEN_HAAG, DEN_HAAG_WAARDE_NORMAAL, GRONINGEN_DEN_HAAG_HUISPRIJS, DEN_HAAG_HUUR_NORMAAL),
           new Utility(WATERLEIDING, SPACENR_WATERLEIDING, BoardspaceType.UTILITY, NUTS_WAARDE),
           new Street(LANGE_POTEN, SPACENR_LANGE_POTEN, BoardspaceType.STREET_DEN_HAAG, DEN_HAAG_WAARDE_DUUR, GRONINGEN_DEN_HAAG_HUISPRIJS, DEN_HAAG_HUUR_DUUR),
           new GoToJail(GA_NAAR_DE_GEVANGENIS, SPACENR_GA_NAAR_DE_GEVANGENIS, BoardspaceType.GO_TO_JAIL),
           new Street(HOFPLEIN, SPACENR_HOFPLEIN, BoardspaceType.STREET_ROTTERDAM, ROTTERDAM_WAARDE_NORMAAL, ROTTERDAM_AMSTERDAM_HUISPRIJS, ROTTERDAM_HUUR_NORMAAL),
           new Street(BLAAK, SPACENR_BLAAK, BoardspaceType.STREET_ROTTERDAM, ROTTERDAM_WAARDE_NORMAAL, ROTTERDAM_AMSTERDAM_HUISPRIJS, ROTTERDAM_HUUR_NORMAAL),
           new CommunityChest(ALGEMEEN_FONDS, SPACENR_ALGEMEEN_FONDS_3, BoardspaceType.CARD),
           new Street(COOLSINGEL, SPACENR_COOLSINGEL, BoardspaceType.STREET_ROTTERDAM, ROTTERDAM_WAARDE_DUUR, ROTTERDAM_AMSTERDAM_HUISPRIJS, ROTTERDAM_HUUR_DUUR),
           new Station(STATION_OOST, SPACENR_STATION_OOST, BoardspaceType.STATION, STATION_WAARDE),
           new Chance(KANS, SPACENR_KANS_3, BoardspaceType.CARD),
           new Street(LEIDSE_PLEIN, SPACENR_LEIDSE_PLEIN, BoardspaceType.STREET_AMSTERDAM, AMSTERDAM_WAARDE_NORMAAL, ROTTERDAM_AMSTERDAM_HUISPRIJS, AMSTERDAM_HUUR_NORMAAL),
           new Taxation(LUXE_BELASTING, SPACENR_LUXE_BELASTING, BoardspaceType.TAX, BEDRAG_LUXE_BELASTING),
           new Street(KALVERSTRAAT, SPACENR_KALVERSTRAAT, BoardspaceType.STREET_AMSTERDAM, AMSTERDAM_WAARDE_DUUR, ROTTERDAM_AMSTERDAM_HUISPRIJS, AMSTERDAM_HUUR_DUUR)
        };

        public static Boardspace getBoardspace(int boardspaceNr) {
            if (boardspaceNr > MONOPOLYBOARD.length -1) {
                return null;
            }
            return MONOPOLYBOARD[boardspaceNr];
        }

        public static List<Street> getCity(Street street) {
            List<Street> city = new ArrayList<>();
            Arrays.asList(MONOPOLYBOARD).stream()
                    .filter(a -> a.getBoardspaceType().equals(street.getBoardspaceType()))
                    .forEach(a -> city.add((Street)a));
            return city;
        }
    }
