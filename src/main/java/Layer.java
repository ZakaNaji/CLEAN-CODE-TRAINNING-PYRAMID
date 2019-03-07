import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Character> blocks;
    private int numberOfSolideBlocks;

    public Layer(){
        blocks = new ArrayList<Character>();
    }

    public void addBlock(char block){
        blocks.add(block);
    }

    public char getBlock(int index){
        return blocks.get(index);
    }

    public String printLayer(){
        StringBuilder builder = new StringBuilder(blocks.size());
        for (Character character : blocks){
            builder.append(character);
        }
        return builder.toString();
    }

    public int size(){
        return blocks.size();
    }

    public void incriseNumberOfSolideBlocks(){
        numberOfSolideBlocks++;
    }

    public int getNumberOfSolideBlocks(){
        return numberOfSolideBlocks;
    }
}
