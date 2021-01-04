package github.chorman0773.pokemonsms.common.pokemon;

import github.chorman0773.pokemonsms.common.util.IEventBus;
import github.chorman0773.pokemonsms.common.util.RegistryObject;
import github.chorman0773.pokemonsms.common.util.ResourceLocation;
import github.chorman0773.pokemonsms.common.util.lua.LuaDelegate;
import github.chorman0773.pokemonsms.common.util.lua.LuaStreams;
import github.chorman0773.sentry.text.TextComponent;
import org.luaj.vm2.LuaValue;


public class Species extends DescriptorObject<Species>{





    public Species(LuaValue table) {
        super(table);

    }

    protected Species(ResourceLocation name, IEventBus bus, TextComponent unname) {
        super(name, bus, unname);

    }

    @Override
    public Class<Species> getRegistryType() {
        return Species.class;
    }

    @Override
    public LuaDelegate<Species> getDelegate() {
        return null;
    }


}
