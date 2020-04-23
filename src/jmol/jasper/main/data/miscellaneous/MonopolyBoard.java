package jmol.jasper.main.data.miscellaneous;

import java.util.List;

public interface MonopolyBoard <T> {
    List<T> getBoardspaceList(MonopolyBoardData.BoardspaceType boardspaceType);
}
