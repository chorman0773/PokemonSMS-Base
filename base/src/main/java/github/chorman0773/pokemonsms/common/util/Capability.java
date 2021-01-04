package github.chorman0773.pokemonsms.common.util;

import java.util.function.Supplier;

public interface Capability<T> extends Supplier<T> {
    public String getName();
    public Class<? extends T> getType();
}
