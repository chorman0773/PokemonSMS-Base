package github.chorman0773.pokemonsms.common.util.lua;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.luaj.vm2.LuaNumber;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

import github.chorman0773.pokemonsms.common.siding.EnumSide;
import github.chorman0773.pokemonsms.common.util.IEventBus;

public final class LuaEventBus extends LuaValue implements IEventBus {
	private Map<String,LuaValue> handlers;
	public LuaEventBus() {
		this.handlers = new TreeMap<>();
	}
	
	private static LuaValue convertToLua(Object o) {
		if(o instanceof LuaValue)
			return (LuaValue)o;
		else if(o instanceof Number)
			return LuaValue.valueOf(((Number) o).doubleValue());
		else if(o instanceof Boolean)
			return o.equals(Boolean.TRUE)?LuaValue.TRUE:LuaValue.FALSE;
		else if(o instanceof BindableObject<?>)
			return ((BindableObject<?>) o).getDelegate();
		else if(o instanceof String)
			return LuaValue.valueOf((String)o);
		else
			return LuaValue.error("Cannot Convert from this type of object.");
	}
	
	private static Varargs convertToVarargs(Object[] obj) {
		return LuaValue.varargsOf(Arrays.stream(obj).map(LuaEventBus::convertToLua).toArray(LuaValue[]::new));
	}

	@Override
	public void handleEvent(String event, Object... content) {
		handlers.get(event).invoke(convertToVarargs(content));
	}

	@Override
	public int type() {
		// TODO Auto-generated method stub
		return LuaValue.TUSERDATA;
	}

	@Override
	public String typename() {
		// TODO Auto-generated method stub
		return "EventBus";
	}
	
	private void register(String key,LuaValue predicate,LuaValue handler) {
		
	}

	@Override
	public Varargs invokemethod(String name, Varargs args) {
		switch(name) {
		case "register":
			register(args.tojstring(1),args.arg(2),args.arg(3));
		break;
		case "registerClient":
			if(EnumSide.side()==EnumSide.CLIENT)
				register(args.tojstring(1),args.arg(2),args.arg(3));
		break;
		case "registerServer":
			if(EnumSide.side()==EnumSide.SERVER)
				register(args.tojstring(1),args.arg(2),args.arg(3));
		break;
		}
		return super.invokemethod(name, args);
	}

	@Override
	public Varargs invokemethod(LuaValue name, Varargs args) {
		if(name.isstring())
			return invokemethod(name.checkjstring(),args);
		else
			return super.invokemethod(name, args);
	}

}
