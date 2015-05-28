package com.example.designpattern;

import java.io.*;
import java.util.Scanner;

/**
 * Created by laveen on 22/11/14.
 */
public class Home {
    Cell[][] tictactoe = new Cell[3][3];
    private int playerMoveCounter;
    Cell currentUserCell;
    Cell currentComputerCell;

    public static void main(String[] args) {
        Home home = new Home();
        home.startGame();


    }

    public void clearCell() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                tictactoe[row][column] = new Cell(row, column);
            }
        }
    }

    public void showCells() {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("|");
                System.out.print(tictactoe[i][j].getCellData());

            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-------------");
    }

    boolean stopGame = false;

    public void gameloop() {
        int end;
        Scanner in = new Scanner(System.in);
        do {
            int row;
            int column = 0;
            currentUserCell = null;
            do {
                System.out.println("Enter Cell row:");
                row = in.nextInt();
                if (row > 2)
                    break;

                System.out.println("Enter Cell Column:");
                column = in.nextInt();
                if (column > 2)
                    break;
                currentUserCell = tictactoe[row][column];
                if (!currentUserCell.isEmpty()) {
                    System.out.println("****************DATA PRESENT IN THE CELL*****************");
                }
            } while (!currentUserCell.isEmpty());

            //User has entered invalid value to quit so terminate the program
            if (currentUserCell == null)
                break;

            currentUserCell.setCellType(Type.USER);

            playerMoveCounter++;

            playComputer(currentUserCell);

            showCells();
        } while (!stopGame);
    }

    private void playComputer(Cell currentCell) {
        if (playerMoveCounter == 1) {
            currentComputerCell = getDiagonalCell(currentCell);
        } else {
            if (playerMoveCounter > 2) {//To check computer can finish the game
                if (canPlaceNextToThisCellRow(currentComputerCell, Type.COMPUTER) ||
                        canPlaceNextToThisCellColumn(currentComputerCell, Type.COMPUTER) ||
                        canPlaceNextToThisCellDiagonally(currentComputerCell, Type.COMPUTER)) {

                    System.out.println("\rCOMPUTER WON!!!");
                    stopGame = true;
                    return;
                }
                //can complete computer moves
            }
            if (canPlaceNextToThisCellRow(currentUserCell, Type.COMPUTER) ||
                    canPlaceNextToThisCellColumn(currentUserCell, Type.COMPUTER) ||
                    canPlaceNextToThisCellDiagonally(currentComputerCell, Type.COMPUTER)||
                    canPlaceNextToThisCellDiagonally(currentUserCell,Type.COMPUTER)) {

            }
        }
    }

    private boolean canPlaceNextToThisCellDiagonally(Cell currentUserCell, Type typeOfCellToBePlaced) {
        boolean canPlaceCell = false;
        int emptyRow = 0, emptyColumn = 0;
        for (int row = 0; row < 3; row++) {

            if (row != currentUserCell.getRow()) {
                for (int column = 0; column < 3; column++) {

                    if (column != currentUserCell.getColumn()) {

                        Cell cell = null;
                        if (row == column) {
                            cell = tictactoe[row][column];
                        }

                        if (row + column == 2) {
                            cell = tictactoe[row][column];
                        }

                        if (cell != null) {
                            if (cell.isEmpty()) {
                                emptyRow = row;
                                emptyColumn = column;
                            } else if (cell.equals(currentUserCell)) {
                                canPlaceCell = true;
                            } else {//
                                canPlaceCell = false;
                                break;
                            }
                        }
                    }

                   /* if (!canPlaceCell) {
                        break;
                    }*/
                }
            }
        }
        if (canPlaceCell) {
            currentComputerCell = tictactoe[emptyRow][emptyColumn];
            currentComputerCell.setCellType(typeOfCellToBePlaced);
            return true;
        }
        return false;
    }


    private boolean canPlaceNextToThisCellRow(Cell currentUserCell, Type typeOfCellToBePlaced) {
        int row = currentUserCell.getRow();
        boolean canPlaceCell = false;
        int emptyRow = 0, emptyColumn = 0;
        for (int column = 0; column < 3; column++) {

            if (column == currentUserCell.getColumn())
                continue;

            if (tictactoe[row][column].isEmpty()) {
                emptyRow = row;
                emptyColumn = column;
            } else if (tictactoe[row][column].equals(currentUserCell)) {
                canPlaceCell = true;
            } else {//if any computer found in the path then stop moving
                canPlaceCell = false;
                break;
            }

        }
        if (canPlaceCell) {
            currentComputerCell = tictactoe[emptyRow][emptyColumn];
            currentComputerCell.setCellType(typeOfCellToBePlaced);
            return true;
        }
        return false;
    }

    private boolean canPlaceNextToThisCellColumn(Cell currentUserCell, Type typeOfCellToBePlaced) {
        int column = currentUserCell.getColumn();
        boolean canPlaceCell = false;
        int emptyRow = 0, emptyColumn = 0;
        for (int row = 0; row < 3; row++) {

            if (row == currentUserCell.getRow())
                continue;

            if (tictactoe[row][column].isEmpty()) {
                emptyRow = row;
                emptyColumn = column;
            } else if (tictactoe[row][column].equals(currentUserCell)) {
                canPlaceCell = true;
            } else {//
                canPlaceCell = false;
                break;
            }

        }
        if (canPlaceCell) {
            currentComputerCell = tictactoe[emptyRow][emptyColumn];
            currentComputerCell.setCellType(typeOfCellToBePlaced);
            return true;
        }
        return false;
    }

    private Cell getDiagonalCell(Cell currentCell) {
        int row = 1;
        int column = 1;
        Cell cell = null;
        if ((currentCell.getRow() != row) || (currentCell.getColumn() != column)) {
            cell = tictactoe[row][column];
            cell.setCellType(Type.COMPUTER);
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) {
                        cell = tictactoe[i][j];
                        if (cell.isEmpty()) {
                            cell.setCellType(Type.COMPUTER);
                            return cell;
                        }
                    } else if (i + j == 2) {
                        cell = tictactoe[i][j];
                        if (cell.isEmpty()) {
                            cell.setCellType(Type.COMPUTER);
                            return cell;
                        }
                    }
                }
            }
        }
        return cell;
    }

    public void startGame() {
        clearCell();
        showCells();
        gameloop();
    }
}

