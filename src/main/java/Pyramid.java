
import java.util.ArrayList;
import java.util.List;

public class Pyramid {

    private static final char LOW_QUALITY_BLOCK = 'V';
    private static final char HIGH_QUALITY_BLOCK = 'X';
    private static final char EMPTY_BLOCK = ' ';
    private static final char SUPPORT_BLOCK = '_';
    private List<Layer> layers;


    public Pyramid(){
        layers = new ArrayList<Layer>();
    }

    public int getNumberOfBlocks(int numberOfSlaves){
        return numberOfSlaves/50;
    }

    public char getBlockQuality(int numberOfBlocks, int layerBudget){
        return (layerBudget/numberOfBlocks >= 2)? HIGH_QUALITY_BLOCK:LOW_QUALITY_BLOCK;
    }

    public void addLayer(String layerOrder){
        int layerNumberOfBlocks = getNumberOfBlocks(PyramidUtilities.getNumberOfSlaves(layerOrder));
        char layerBlocksQuality = getBlockQuality(layerNumberOfBlocks,PyramidUtilities.getLayerBudget(layerOrder));
        if(layers.isEmpty()){
            buildBaseLayer(layerNumberOfBlocks,layerBlocksQuality);
        }else{
            buildUpperLayer(layerNumberOfBlocks,layerBlocksQuality);
        }
    }

    private void buildBaseLayer(int layerNumberOfBlocks, char layerBlocksQuality) {
        Layer layerToAdd = new Layer();
        for (int i=0; i < layerNumberOfBlocks; i++){
            layerToAdd.addBlock(layerBlocksQuality);
            layerToAdd.incriseNumberOfSolideBlocks();
        }
        layers.add(layerToAdd);
    }

    private void buildUpperLayer(int layerNumberOfBlocks, char layerBlocksQuality) {
        Layer previouslayer = layers.get(layers.size() - 1);
        Layer layerToAdd = new Layer();
        for (int i=0; i<previouslayer.size(); i++){
            layerToAdd.addBlock(getAppropriateBlock(layerNumberOfBlocks,layerBlocksQuality,previouslayer.getBlock(i),i));
        }
        layers.add(layerToAdd);
    }

    private char getAppropriateBlock(int layerNumberOfBlocks, char layerBlocksQuality, char theBlockUnder, int blockIndex) {
        int layerStartingIndex = (5-layerNumberOfBlocks)/2;
        int layerEndingIndex = layerStartingIndex + layerNumberOfBlocks - 1;
        if(blockIndex < layerStartingIndex || blockIndex > layerEndingIndex){
            return compareWithTheBlockUnder(theBlockUnder);
        }
        return layerBlocksQuality;
    }

    private char compareWithTheBlockUnder(char theBlockUnder) {
        if(theBlockUnder == SUPPORT_BLOCK){
            return EMPTY_BLOCK;
        }
        return SUPPORT_BLOCK;
    }

    public String print(){
        String pyramidShape = "";
        for (int i = layers.size()-1; i >= 0; i--){
            pyramidShape += layers.get(i).printLayer();
            if (i > 0 ) pyramidShape += "\n";
        }
        return pyramidShape;
    }
}
/*for (int index = 0; index < layerNumberOfBlocks; index++){
            layerToAdd.addBlock(layerBlocksQuality);
        }
        layers.add(layerToAdd);*/