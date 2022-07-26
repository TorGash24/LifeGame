import java.util.ArrayList;

public class Cell {
    ArrayList<Cell> near;
    Status status;

    public Cell() {
        status = Status.NONE;
        near = new ArrayList<>();
    }

    public void step1() {
        int around = countNearCells();
        status = status.step1(around);
    }

    public void step2() {
        status = status.step2();
    }

    private int countNearCells() {
        return (int)near.stream().filter(cell -> cell.status.isCell()).count();
    }

    public void addNear(Cell cell) {
        near.add(cell);
    }


    public void turn() {
        for (Cell cell : near) {
            cell.status = cell.status.isCell() ? Status.NONE : Status.LIVE;
        }
    }
}
