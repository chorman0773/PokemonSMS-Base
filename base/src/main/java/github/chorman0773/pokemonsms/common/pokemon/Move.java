package github.chorman0773.pokemonsms.common.pokemon;

import github.chorman0773.pokemonsms.common.util.IEventBus;
import github.chorman0773.pokemonsms.common.util.ResourceLocation;
import github.chorman0773.pokemonsms.common.util.lua.EnumValue;
import github.chorman0773.sentry.text.TextComponent;
import org.luaj.vm2.*;

import github.chorman0773.pokemonsms.common.util.lua.LuaDelegate;

import java.util.OptionalDouble;
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
		this.accuracy = table.get("accuracy").optdouble(-1.0);
		this.power = table.get("power").optint(0);
	}

    public Move(ResourceLocation name, IEventBus bus, TextComponent unname, ResourceLocation type, MoveCategory cat, Set<String> traits, int ppval, double accuracy, int power) {
        super(name, bus, unname);
        this.type = type;
        this.cat = cat;
        this.traits = traits;
        this.ppval = ppval;
        this.accuracy = accuracy;
        this.power = power;
    }

    private class MoveDelegate extends LuaDelegate<Move>{

        public MoveDelegate() {
            super(Move.this, Move.class);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public LuaValue invokemethod(String name, Varargs args) {
            return switch (name) {
                case "getType" -> Move.this.getType().getDelegate();
                case "getCategory" -> EnumValue.valueOf(Move.this.cat);
                case "getMaxPP" -> LuaInteger.valueOf(Move.this.getMaxPP(args.checkint(1)));
                case "hasTrait" -> LuaBoolean.valueOf(Move.this.traits.contains(args.checkjstring(1)));
                case "getAccuracy" -> LuaDouble.valueOf(Move.this.accuracy);
                case "getPower" -> LuaInteger.valueOf(Move.this.power);
                default -> error("Bad function call.");
            };
        }
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

    public double getAccuracy(){
	    return this.accuracy;
    }

    public int getPower(){
	    return this.power;
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
		return new MoveDelegate();
	}

}
