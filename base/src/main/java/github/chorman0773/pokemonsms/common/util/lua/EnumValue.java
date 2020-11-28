package github.chorman0773.pokemonsms.common.util.lua;

import org.luaj.vm2.LuaUserdata;

public class EnumValue<E extends Enum<E>> extends LuaUserdata {
	private final Class<?> cl;
	private EnumValue(E obj,Class<?> cl) {
		super(obj);
		this.cl = cl;
	}
	
	public static <E extends Enum<E>> EnumValue<E> valueOf(E value){
		return new EnumValue<E>(value,value.getDeclaringClass());
	}

	@SuppressWarnings("unchecked")
	@Override
	public E checkuserdata() {
		// TODO Auto-generated method stub
		return (E)super.checkuserdata();
	}

	@Override
	public String tojstring() {
		// TODO Auto-generated method stub
		return checkuserdata().name();
	}

	@Override
	public String typename() {
		// TODO Auto-generated method stub
		return cl.getSimpleName();
	}
	

}
