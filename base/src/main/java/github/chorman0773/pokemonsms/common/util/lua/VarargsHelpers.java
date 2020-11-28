package github.chorman0773.pokemonsms.common.util.lua;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;


import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface VarargsHelpers {
    public static Stream<LuaValue> varargsStream(Varargs v){
        return IntStream.iterate(0, i->i<v.narg(), i->i+1).mapToObj(v::checkvalue);
    }
}
