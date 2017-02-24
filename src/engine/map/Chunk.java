package engine.map;

/**
 * Created by USER on 24.02.2017.
 */
public class Chunk {
    /**
     * id - number of chunk relatively 0.
     * heights -
     */
    public static final int WIDTH_OF_CHUNK = 32;
    public static final int HEIGHT_OF_CHUNK = 256;

    private int DOWN_GENERATION;
    private int UP_GENERATION;

    private int startheight;

    public int getStartheight() {
        return startheight;
    }
       public void setStartheight(int startheight) {
        this.startheight = startheight;
    }

    private int id;
    private int[] heights;
    private int[][] frontBlocks;
    private int[][] backBlocks;
    private boolean isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getHeights() {
        return heights;
    }

    public void setHeights(int[] heights) {
        this.heights = heights;
    }

    public int[][] getFrontBlocks() {
        return frontBlocks;
    }

    public void setFrontBlocks(int[][] frontBlocks) {
        this.frontBlocks = frontBlocks;
    }

    public int[][] getBackBlocks() {
        return backBlocks;
    }

    public void setBackBlocks(int[][] backBlocks) {
        this.backBlocks = backBlocks;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Chunk( int id, int startheight, int DOWN_GENERATION, int UP_GENERATION) {
        this.DOWN_GENERATION = DOWN_GENERATION;
        this.UP_GENERATION = UP_GENERATION;
        this.startheight = startheight;
        this.id = id;

        frontBlocks = new int[HEIGHT_OF_CHUNK][WIDTH_OF_CHUNK];
        backBlocks = new int[HEIGHT_OF_CHUNK][WIDTH_OF_CHUNK];
    }

    public Chunk(int id, int[] heights, int[][] frontBlocks, int[][] backBlocks, boolean isActive) {
        this.id = id;
        this.heights = heights;
        this.frontBlocks = frontBlocks;
        this.backBlocks = backBlocks;
        this.isActive = isActive;
    }

    /**
     * Generating environment of chunk
     *
     */
    public void fillBlocks(){

        if(id >= 0) heights = Generation.getRandomRight(WIDTH_OF_CHUNK, startheight, HEIGHT_OF_CHUNK, DOWN_GENERATION, UP_GENERATION);
        else heights = Generation.getRandomRight(WIDTH_OF_CHUNK, startheight, HEIGHT_OF_CHUNK, DOWN_GENERATION, UP_GENERATION);
        //for(int x : heights) System.out.println(x);
        for(int i = 0; i < HEIGHT_OF_CHUNK; i++){
            for(int j = 0; j < WIDTH_OF_CHUNK; j++){
                if(i < HEIGHT_OF_CHUNK - heights[j]) frontBlocks[i][j] = 0;
                else frontBlocks[i][j] = 1;
            }
        }
    }













}
