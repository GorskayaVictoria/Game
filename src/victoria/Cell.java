package victoria;

/**
 * Created by Prog_1 on 11.12.2016.
 */
public class Cell {
    private int value;

    public Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;

        Cell cell = (Cell) o;

        return getValue() == cell.getValue();

    }

    @Override
    public int hashCode() {
        return getValue();
    }

}
