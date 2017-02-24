package engine.map;

import engine.window.Camera;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

/**
 * Created by sasha_zubkov on 20.02.17.
 */
public class Map {

    private ArrayList<Chunk> chunks = new ArrayList<>();
    private int leftID;
    private int rightID;

    public int getChunksSize(){
        return chunks.size();
    }
    public Map() {
        Chunk startChunk = new Chunk(0, 70, Generation.MOUNTAIN, Generation.MOUNTAIN);
        startChunk.fillBlocks();
        chunks.add(startChunk);

        leftID = 0;
        rightID = 0;
    }

    public Map(String path){

    }

    public void drawChunks(Graphics g, Camera camera){
        for(Chunk x : chunks){
            if(camera.getX()/32/32 > x.getId() + 1 || camera.getX()/32/32 < x.getId() - 2) continue;
            int[][] arr = x.getFrontBlocks();
            int shift = 32 * Chunk.WIDTH_OF_CHUNK * x.getId();

            for(int i = 0; i < Chunk.HEIGHT_OF_CHUNK; i++) {

                for (int j = 0; j < Chunk.WIDTH_OF_CHUNK; j++){
                    if(arr[i][j] == 1){
                        g.drawRect(shift + j * 32, i * 32, 32, 32);
                    }
                }

            }
        }
    }



    public void checkEndChunks(Camera camera){
        if(camera.getX()/32/32 > rightID - 1 ){
            Chunk newChunk;
            int startlen = 70;
            for(Chunk x : chunks) if(x.getId() == rightID) startlen = x.getHeights()[x.getHeights().length - 1];

            newChunk = new Chunk(++rightID, startlen, Generation.PLAIN, Generation.PLAIN);

            System.out.println("RigthID : " + rightID);

            newChunk.fillBlocks();
            chunks.add(newChunk);
        }
        if(camera.getX()/32/32 < leftID + 1){
            Chunk newChunk;
            int startlen = 70;
            for(Chunk x : chunks) if(x.getId() == leftID) startlen = x.getHeights()[0];


            newChunk = new Chunk(--leftID, startlen, Generation.PLAIN, Generation.PLAIN);

            System.out.println("LeftID : " + leftID);

            newChunk.fillBlocks();
            chunks.add(newChunk);
        }


    }
}
