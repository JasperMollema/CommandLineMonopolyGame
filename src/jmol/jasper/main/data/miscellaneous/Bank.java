package jmol.jasper.main.data.miscellaneous;

import jmol.jasper.main.data.boardspaces.Property;
import jmol.jasper.main.data.boardspaces.Station;
import jmol.jasper.main.data.boardspaces.Street;
import jmol.jasper.main.data.boardspaces.Utility;
import jmol.jasper.main.logic.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  Bank {
    private static boolean isInitialized;
    private static int nrOfHouses;
    private static int nrOfHotels;
    private static final int NR_OF_HOUSES = 32;
    private static final int NR_OF_HOTELS = 12;
    private static List<Street> onsDorp;
    private static List<Street> arnhem;
    private static List<Street> haarlem;
    private static List<Street> utrecht;
    private static List<Street> groningen;
    private static List<Street> denHaag;
    private static List<Street> rotterdam;
    private static List<Street> amsterdam;
    private static List<Utility> nutsBedrijven;
    private static List<Station> stations;
    private static List<Property> bankProperties;
    private static Map<Player, List<Station>> playerStationMap;
    private static Map<Player, List<Property>> playerPropertyMap;
    private static Map<Player, Map<MonopolyBoardData.BoardspaceType, Boolean>> playerOwnsAllTypes;

    public Bank() {
        if (!isInitialized) {
            initialize();
            isInitialized = true;
        }
    }

    private void initialize() {
        nrOfHouses = NR_OF_HOUSES;
        nrOfHotels = NR_OF_HOTELS;
        onsDorp = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_DORP);
        arnhem = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_ARNHEM);
        haarlem = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_HAARLEM);
        utrecht = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_UTRECHT);
        groningen = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_GRONINGEN);
        denHaag = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_DEN_HAAG);
        rotterdam = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_ROTTERDAM);
        amsterdam = new Board<Street>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STREET_AMSTERDAM);
        nutsBedrijven = new Board<Utility>().getBoardspaceList(MonopolyBoardData.BoardspaceType.UTILITY);
        stations = new Board<Station>().getBoardspaceList(MonopolyBoardData.BoardspaceType.STATION);
        bankProperties = new ArrayList<>();
        bankProperties.addAll(onsDorp);
        bankProperties.addAll(arnhem);
        bankProperties.addAll(haarlem);
        bankProperties.addAll(utrecht);
        bankProperties.addAll(groningen);
        bankProperties.addAll(denHaag);
        bankProperties.addAll(rotterdam);
        bankProperties.addAll(amsterdam);
        bankProperties.addAll(stations);
        bankProperties.addAll(nutsBedrijven);
        playerOwnsAllTypes = new HashMap<>();
        playerStationMap = new HashMap<>();
    }

    public void buyPropertyFromBank(Player player, Property property) {
        playerPropertyMap.get(player).add(property);
        bankProperties.remove(property);
        MonopolyBoardData.BoardspaceType boardspaceType = property.getBoardspaceType();
        addPropertyToOwnedTypes(player, boardspaceType);
        if (stations.contains(property)) {
            buyStation((Station) property, player);
        }
    }

    /**
     * Gets all streets of which the player ownes the whole city.
     * @param player
     * @return List with all te streets owned by the player.
     */
    public List<Street> getOwnedStreetsOfCity(Player player) {
        List<Street> ownedStreets = new ArrayList<>();
        for (Property property : playerPropertyMap.get(player)) {
            if (isStreet(property) && ownesAllTypes(player, property)) {
                ownedStreets.add((Street) property);
            }
        }
        return ownedStreets;
    }

    /**
     * Gets all the owned streets of a particular owned BoardspaceTypeCity.
     * @param player
     * @param boardspaceType
     * @return
     */
    public List<Street> getOwnedStreetsOfCity(Player player, MonopolyBoardData.BoardspaceType boardspaceType) {
        List<Street> streets = new ArrayList<>();
        if (playerPropertyMap.get(player) == null || !boardspaceType.getIsCity()) {
            return null;
        }
        for (Property property : playerPropertyMap.get(player)) {
            if (property.getBoardspaceType().equals(boardspaceType)) {
                streets.add((Street)property);
            }
        }
        return streets;
    }

    public List<MonopolyBoardData.BoardspaceType> getOwnedCitiesBoardSpaceTypes (Player player) {
        List<MonopolyBoardData.BoardspaceType> boardspaceTypeList = new ArrayList<>();
        if (playerOwnsAllTypes.get(player) == null) {
            return null;
        }
        Map<MonopolyBoardData.BoardspaceType, Boolean> ownedBoardSpaceTypes = playerOwnsAllTypes.get(player);
        for (MonopolyBoardData.BoardspaceType boardspaceType : ownedBoardSpaceTypes.keySet()) {
            if (playerOwnsAllTypes.get(player).get(boardspaceType) && boardspaceType.getIsCity()) {
                boardspaceTypeList.add(boardspaceType);
            }
        }
        return boardspaceTypeList;
    }

    public void fillPlayerlistMap(List<Player> playerList) {
        playerPropertyMap = new HashMap<>();
        for (Player player : playerList) {
            List<Property> propertyList = new ArrayList<>();
            playerPropertyMap.put(player, propertyList);
        }
    }

    public void buyHouses(int amount) {
        nrOfHouses -= amount;
    }

    public void buyHotel(int amount) { nrOfHotels -= amount;}

    public void sellHouses(int amount) {
        nrOfHouses += amount;
    }

    public void sellHotel() {
        nrOfHotels--;
    }

    private static boolean isStreet(Property property) {
        return !(stations.contains(property) || nutsBedrijven.contains(property));
    }

    private static void buyStation(Station station, Player player) {
        List<Station> ownedStations = playerStationMap.get(player);
        if (ownedStations == null) {
            ownedStations = new ArrayList<>();
        }
        ownedStations.add(station);
        playerStationMap.put(player, ownedStations);
    }

    private static boolean ownesAllTypes(Player player, Property property) {
        if (playerOwnsAllTypes.get(player) == null) {
            return false;
        }
        return playerOwnsAllTypes.get(player).get(property.getBoardspaceType());
    }

    private static void addPropertyToOwnedTypes(Player player, MonopolyBoardData.BoardspaceType boardspaceType) {
        if (playerOwnsAllTypes.get(player) == null) {
            playerOwnsAllTypes.put(player, new HashMap<>());
        }
        int nrOfBoardspaceTypes = boardspaceType.getNrOfTypes();
        int ownedTypes = 0;
        for (Property property : playerPropertyMap.get(player)) {
            if (property.getBoardspaceType().equals(boardspaceType)) {
                ownedTypes++;
            }
        }
        Boolean ownesAllTypes = nrOfBoardspaceTypes == ownedTypes;
        playerOwnsAllTypes.get(player).put(boardspaceType, ownesAllTypes);
    }

    public int getNrOfHouses() {
        return nrOfHouses;
    }

    public int getNrOfHotels() {
        return nrOfHotels;
    }

    public boolean getOwnesAllTypes(Property property, Player player) {
        if ((playerOwnsAllTypes.get(player) == null)) {
            return false;
        }
        Boolean ownesAllTypes = playerOwnsAllTypes.get(player).get(property);
        if (ownesAllTypes == null) {
            return false;
        }
        return ownesAllTypes;
    }

    public int getNrOFStationsOwned(Player player) {
        if (playerStationMap.get(player) == null) {
            return 0;
        }
        else return playerStationMap.get(player).size();
    }
}
