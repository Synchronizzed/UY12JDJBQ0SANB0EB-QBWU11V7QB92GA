package core.components.foundore;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class CountBlocks {
	
	private Set<Block> blocksSeen = new HashSet<>();
	private int blockCount;
	private Material type;
	
	public CountBlocks(Block block){
		this.type = block.getType();
		this.throughBlocks(block);
		this.blocksSeen.forEach(e -> FoundOre.blocks.add(e));
	}
	
	public int getLength(){
		return this.blockCount;
	}
	
	private Set<Block> neighbouring(Block block){
		
		Set<Block> setOfBlocks = new HashSet<>();
		
		for(int x = -1; x<=1; x++){
			for(int y = -1; y<=1; y++){
				for(int z = -1; z<=1; z++){
					setOfBlocks.add(block.getRelative(x, y, z));
				}
			}
		}
		return setOfBlocks;
	}
	
	private void throughBlocks(Block block){
		
		blocksSeen.add(block);
		blockCount++;
		Set<Block> setOfBlocks = this.neighbouring(block);
		Block[] blocks = setOfBlocks
		.stream()
		.filter(e -> e.getType() == this.type)
		.filter(e -> !this.blocksSeen.contains(e))
		.filter(e -> !FoundOre.blocks.contains(e))
		.toArray(size -> new Block[size]);
		
		for(Block blockToCheck: blocks){
			if(this.blocksSeen.contains(blockToCheck)){
				continue;
			}
			this.throughBlocks(blockToCheck);
		}
	}
	
	

}
