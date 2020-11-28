package github.chorman0773.pokemonsms.common.util.lua;

import org.luaj.vm2.LuaUserdata;

public abstract class LuaDelegate<D> extends LuaUserdata {
	private final Class<? extends D> cl;
	public LuaDelegate(D obj,Class<? extends D> cl) {
		super(obj);
		this.cl = cl;
	}

	public static <D extends BindableObject<D>> LuaDelegate<D> empty(Class<? extends D> cl){
		return new LuaDelegate<D>(null,cl){};
	}

	@SuppressWarnings("unchecked")
	@Override
	public D checkuserdata() {
		// TODO Auto-generated method stub
		return (D)super.checkuserdata();
	}
	
	@SuppressWarnings("unchecked")
    public D checkuserdata(Class cl) {
	    if(cl.isAssignableFrom(this.cl))
		    return (D)cl.cast(checkuserdata());
        else
            throw new ClassCastException("Invalid Cast");
	}

}
