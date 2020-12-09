package github.chorman0773.pokemonsms.common.util;

import java.util.Optional;
import java.util.function.Supplier;

public class RegistryObject<E extends RegistryEntry<E>> implements Supplier<Optional<E>> {
    private E value;
    private final ResourceLocation loc;
    private final Registry<E> registry;

    RegistryObject(Registry<E> e,ResourceLocation name){
        this.registry = e;
        this.loc = name;
    }

    @Override
    public Optional<E> get() {
        if(value==null){
            value = registry.getByName(loc);
        }
        return Optional.ofNullable(value);
    }

    public ResourceLocation getName(){
        return this.loc;
    }
}
