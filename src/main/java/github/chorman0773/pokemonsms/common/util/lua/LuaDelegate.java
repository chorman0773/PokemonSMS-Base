package github.chorman0773.pokemonsms.common.util.lua;

import org.luaj.vm2.LuaUserdata;

public abstract class LuaDelegate<D> extends LuaUserdata {
	private Class<? extends D> cl;
	@SuppressWarnings("unchecked")
	public LuaDelegate(D obj,Class<? extends D> cl) {
		super(obj);
		this.cl = cl;
	}

	public static final <D extends BindableObject<D>> LuaDelegate<D> empty(Class<? extends D> cl){
		return new LuaDelegate<D>(null,cl){};
	}

	@SuppressWarnings("unchecked")
	@Override
	public D checkuserdata() {
		// TODO Auto-generated method stub
		return (D)super.checkuserdata();
	}
	
	public D checkuserdata(Class cl) {
		return (D)cl.cast(checkuserdata());
	}

}
