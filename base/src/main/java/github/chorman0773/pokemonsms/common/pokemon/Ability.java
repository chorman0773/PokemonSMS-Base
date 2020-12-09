package github.chorman0773.pokemonsms.common.pokemon;

import github.chorman0773.pokemonsms.common.util.*;
import github.chorman0773.pokemonsms.common.util.lua.LuaDelegate;
import github.chorman0773.sentry.text.TextComponent;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class Ability extends DescriptorObject<Ability> implements IEventBus {
    private final Set<RegistryObject<Ability>> lifetimeTiedAbilities;
    public Ability(LuaValue table) {
        super(table);
        this.lifetimeTiedAbilities = new TreeSet<>(Comparator.comparing(RegistryObject::getName));
        LuaValue tied = table.get("lifetimeTiedAbilities");
        if(tied.istable()){
            LuaTable tiedTable = tied.checktable();
            for(int i = 1;i<=tiedTable.length();i++)
                this.lifetimeTiedAbilities.add(Registries.Abilities.getObject(ResourceLocation.valueOf(tiedTable.get(i).checkjstring())));
        }
    }

    protected Ability(ResourceLocation name, IEventBus bus, TextComponent unname,Set<RegistryObject<Ability>> lifetimeTied) {
        super(name, bus, unname);
        this.lifetimeTiedAbilities = new TreeSet<>(Comparator.comparing(RegistryObject::getName));
        this.lifetimeTiedAbilities.retainAll(lifetimeTied);
    }

    @Override
    public Class<Ability> getRegistryType() {
        return Ability.class;
    }


    @Override
    public LuaDelegate<Ability> getDelegate() {
        return new LuaDelegate<>(this,Ability.class){};
    }

    @Override
    public void handleEvent(EventKey event, Object... content) {
        if(event instanceof Events.Battle.Ability.Lifetime)
            this.lifetimeTiedAbilities.stream().map(RegistryObject::get)
                    .flatMap(Optional::stream).map(Ability::getEventBus)
                    .forEach(b->b.handleEvent(event,content));
        this.getEventBus().handleEvent(event,content);
    }
}
