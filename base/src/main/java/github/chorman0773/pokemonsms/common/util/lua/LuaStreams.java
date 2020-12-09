package github.chorman0773.pokemonsms.common.util.lua;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;


import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface LuaStreams {
    public static Stream<LuaValue> varargsStream(Varargs v){
        return IntStream.iterate(0, i->i<v.narg(), i->i+1).mapToObj(v::checkvalue);
    }

    public static Stream<Map.Entry<LuaValue,LuaValue>> stream(Varargs v){
        var next = v.arg1();
        var tbl = v.arg(2);
        var k_v = next.call(v.arg(3));
        return Stream.iterate(Map.entry(k_v.arg1(),k_v.arg(2)),e->!e.getKey().isnil(),e->{
            var _k_v = next.call(e.getKey());
            return Map.entry(_k_v.arg1(),_k_v.arg(2));
        });
    }
}
