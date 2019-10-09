package github.chorman0773.pokemonsms.common.pokemon.move;

import org.luaj.vm2.LuaValue;

import github.chorman0773.pokemonsms.common.pokemon.DescriptorObject;
import github.chorman0773.pokemonsms.common.pokemon.MoveCategory;
import github.chorman0773.pokemonsms.common.pokemon.Type;
import github.chorman0773.pokemonsms.common.util.lua.LuaDelegate;

public class Move extends DescriptorObject<Move> {
	private Type type;
	private MoveCategory cat;
	public Move(LuaValue table) {
		super(table);
		type = (Type)table.get("type").checkuserdata(Type.class);
	}

	@Override
	public Class<Move> getRegistryType() {
		// TODO Auto-generated method stub
		return Move.class;
	}

	@Override
	public LuaDelegate<Move> getDelegate() {
		// TODO Auto-generated method stub
		return null;
	}

}
