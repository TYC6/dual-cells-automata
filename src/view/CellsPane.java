package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Grids;

public class CellsPane {
    private Canvas canvas;
    private GraphicsContext gc;
    public static final int CELL_SIZE = 16;
    public static final int CELL_PADDING = 1;
    private static int SCALE = (Grids.N + 2) * CELL_SIZE + CELL_PADDING * (Grids.N - 1);

    private static CellsPane cellsPane = null;

    public static CellsPane getCellsPane() {
        if(cellsPane == null){
            cellsPane = new CellsPane();
        }
        return cellsPane;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    private CellsPane(){
        canvas = new Canvas(SCALE, SCALE);
        gc = canvas.getGraphicsContext2D();
        init();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    // generate the grids
    private void init(){
        gc.setLineWidth(CELL_PADDING);
        gc.setFill(Color.BLACK);
        for(int i = 1; i< Grids.N+2; ++i){
            gc.strokeLine(CELL_SIZE, i*CELL_SIZE + (i - 1)*CELL_PADDING, SCALE - CELL_SIZE, i*CELL_SIZE + (i - 1)*CELL_PADDING);
            gc.strokeLine(i*CELL_SIZE + (i - 1)*CELL_PADDING, CELL_SIZE, i*CELL_SIZE + (i - 1)*CELL_PADDING, SCALE - CELL_SIZE);
        }
    }
}
