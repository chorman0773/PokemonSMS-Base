package github.chorman0773.pokemonsms.common.pokemon.move;

import github.chorman0773.pokemonsms.common.pokemon.Registries;
import github.chorman0773.pokemonsms.common.util.ResourceLocation;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

import github.chorman0773.pokemonsms.common.pokemon.DescriptorObject;
import github.chorman0773.pokemonsms.common.pokemon.MoveCategory;
import github.chorman0773.pokemonsms.common.pokemon.Type;
import github.chorman0773.pokemonsms.common.util.lua.LuaDelegate;

import java.util.Set;
import java.util.TreeSet;

public class Move extends DescriptorObject<Move> {
	private final ResourceLocation type;
	private final MoveCategory cat;
	private final Set<String> traits;
	private final int ppval;
	private final double accuracy;
	private final int power;
	private Type resolvedType;
	public Move(LuaValue table) {
		super(table);
		type = new ResourceLocation(table.get("type").checkjstring());
		cat = (MoveCategory)table.get("category").checkuserdata(MoveCategory.class);
		traits = new TreeSet<>();
		LuaTable val = table.get("traits").checktable();
		for(int i = 0;i<val.length();i++)
		    traits.add(val.get(i+1).checkjstring());
		this.ppval = table.get("pp").checkint();
		this.accuracy = table.get("accuracy").optdouble(1.0);
		this.power = table.get("power").optint(0);
	}

	public int getMaxPP(int ppups){
	    if(ppval==0)
	        return 1;
	    else
	        return ppval*(5+ppups);
    }

    public MoveCategory getCategory(){
	    return cat;
    }

    public Type getType(){
	    if(resolvedType!=null)
	        return resolvedType;
	    else
	        return resolvedType = Registries.Types.getByName(type);
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
