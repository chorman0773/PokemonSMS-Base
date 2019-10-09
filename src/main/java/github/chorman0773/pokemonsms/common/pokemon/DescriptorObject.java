package github.chorman0773.pokemonsms.common.pokemon;

import javax.annotation.ParametersAreNonnullByDefault;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import github.chorman0773.pokemonsms.common.util.IEventBus;
import github.chorman0773.pokemonsms.common.util.RegistryEntry;
import github.chorman0773.pokemonsms.common.util.ResourceLocation;
import github.chorman0773.pokemonsms.common.util.lua.BindableObject;
import github.chorman0773.pokemonsms.common.util.lua.LuaEventBus;
import github.chorman0773.sentry.text.TextComponent;

@ParametersAreNonnullByDefault
public abstract class DescriptorObject<T extends DescriptorObject<T>> implements RegistryEntry<T>, BindableObject<T> {
	
	private TextComponent unname;
	private IEventBus bus;
	private ResourceLocation name;
	
	private static JsonElement toJson(LuaValue val) {
		switch(val.type()) {
		case LuaValue.TNIL:
		case LuaValue.TNONE:
			return JsonNull.INSTANCE;
		case LuaValue.TNUMBER:
		case LuaValue.TINT:
			return new JsonPrimitive(val.checkdouble());
		case LuaValue.TSTRING:
			return new JsonPrimitive(val.checkjstring());
		case LuaValue.TTABLE:
			JsonObject ret = new JsonObject();
			for(LuaValue v:((LuaTable)val).keys()) 
				ret.add(v.checkjstring(), toJson(val.get(v)));
			return ret;
		}
		return JsonNull.INSTANCE;
	}
	
	public DescriptorObject(LuaValue table) {
		this.name = new ResourceLocation(table.get("loc").checkjstring());
		this.bus = (LuaEventBus)table.get("bus").checkuserdata(LuaEventBus.class);
		this.unname = TextComponent.fromJson((JsonObject)toJson(table.get("name").checktable()));
	}

	protected DescriptorObject(ResourceLocation name,IEventBus bus,TextComponent unname){
		this.name = name;
		this.bus = bus;
		this.unname = unname;
	}

	@Override
	public ResourceLocation getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public TextComponent getUnlocalizedName() {
		return unname;
	}
	
	public IEventBus getEventBus() {
		return bus;
	}

	

}
