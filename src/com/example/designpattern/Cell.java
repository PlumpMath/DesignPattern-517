package com.example.designpattern;

/**
 * Created by laveen on 15/5/15.
 */
public class Cell {
    private Type type;
    private int row;
    private int column;

    public Cell(int row,int column) {
        this.row = row;
        this.column = column;
        type = Type.EMPTY;
    }


    @Deprecated
    public Type getType(int rowIndex, int columnIndex) {
       return type;
    }

    public void setCellType(Type type) {
       // row = rowIndex;
       // column = columnIndex;
        this.type = type;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isEmpty() {
        if (type == Type.EMPTY)
            return true;
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Cell)obj).type == this.type;
    }

    public boolean isUserCell() {
        if (this.type == Type.USER)
            return true;
        return false;
    }

    public boolean isComputerCell() {
        if (this.type == Type.COMPUTER)
            return true;
        return false;
    }

    public String getCellData() {
        if (type == Type.USER)
            return " U ";
        else if (type == Type.COMPUTER)
            return " C ";
        return "   ";
    }
}
