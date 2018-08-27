package frogmodaiGame;

import com.artemis.ComponentMapper;
import com.artemis.World;

import frogmodaiGame.components.*;

public class ItemBuilder {
	ComponentMapper<Char> mChar;
	ComponentMapper<Position> mPosition;
	ComponentMapper<ChunkAddress> mChunkAddress;
	ComponentMapper<Description> mDescription;
	
	ItemBuilder(World world) {
		world.inject(this);
	}
	
	public int createTest(Chunk chunk, int x, int y) {
		int item = FFMain.worldManager.world.create(ArchetypeBuilders.Item.archetype);
		Position pos = mPosition.create(item);
		pos.x = x;
		pos.y = y;
		Char character = mChar.create(item);
		character.character = ')';
		character.fgc = 7;
		character.bold = false;
		ChunkAddress chunkAddress = mChunkAddress.create(item);
		chunkAddress.worldID = chunk.worldID;
		Description desc = mDescription.create(item);
		desc.name = "Test Item";
		return item;
	}
}
