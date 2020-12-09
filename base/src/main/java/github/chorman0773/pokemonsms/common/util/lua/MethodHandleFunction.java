package github.chorman0773.pokemonsms.common.util.lua;

import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.CoerceLuaToJava;

import java.lang.invoke.MethodHandle;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MethodHandleFunction extends LuaFunction {
    private final MethodHandle handle;

    public MethodHandleFunction(MethodHandle handle){
        this.handle = handle;
    }

    @Override
    public Varargs invoke(Varargs args) {
        try {
            return CoerceJavaToLua.coerce(handle.invokeWithArguments(LuaStreams.varargsStream(args)
                    .map(v->CoerceLuaToJava.coerce(v,Object.class))
                    .collect(Collectors.toCollection(ArrayList::new))));
        }catch(RuntimeException|Error er){
            throw er;
        }catch(Throwable t){
            return LuaValue.error("Java Error");
        }
    }
}
