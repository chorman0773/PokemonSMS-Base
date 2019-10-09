package github.chorman0773.pokemonsms.common.pokemon;

import github.chorman0773.pokemonsms.common.util.IEventBus;
import github.chorman0773.pokemonsms.common.util.ResourceLocation;
import github.chorman0773.pokemonsms.common.util.lua.LuaDelegate;
import github.chorman0773.sentry.text.TextComponent;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

import java.util.Set;
import java.util.TreeSet;

public class Type extends DescriptorObject<Type> {

    private static final LuaDelegate<Type> delegate = LuaDelegate.empty(Type.class);

    private Set<ResourceLocation> weeknesses;
    private Set<ResourceLocation> resistances;
    private Set<ResourceLocation> immunities;

    public Type(LuaValue table) {
        super(table);

        this.weeknesses = new TreeSet<>();
        LuaTable values = table.get("weak").checktable();
        for(int i = 0;i<values.length();i++)
            this.weeknesses.add(new ResourceLocation(values.get(i).checkjstring()));
        this.resistances = new TreeSet<>();
        values = table.get("resist").checktable();
        for(int i = 0;i<values.length();i++)
            this.resistances.add(new ResourceLocation(values.get(i).checkjstring()));
        this.immunities = new TreeSet<>();
        values = table.get("immune").checktable();
        for(int i = 0;i<values.length();i++)
            this.immunities.add(new ResourceLocation(values.get(i).checkjstring()));
    }

    public Type(ResourceLocation name, IEventBus bus, TextComponent unname, Set<ResourceLocation> weeknesses, Set<ResourceLocation> resistances, Set<ResourceLocation> immunities) {
        super(name, bus, unname);
        this.weeknesses = weeknesses;
        this.resistances = resistances;
        this.immunities = immunities;
    }

    public double getModifier(Type t){
        if(weeknesses.contains(t.getName()))
            return 2.0;
        else if(resistances.contains(t.getName()))
            return 0.5;
        else
            return 1;
    }

    public boolean isImmuneTo(Type t){
        return immunities.contains(t.getName());
    }

    @Override
    public Class<Type> getRegistryType() {
        return Type.class;
    }

    @Override
    public LuaDelegate<Type> getDelegate() {
        return delegate;
    }
}
