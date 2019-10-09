package github.chorman0773.pokemonsms.common.util;


import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Registry<E extends RegistryEntry<E>>{
	private final Map<ResourceLocation,E> backing;
	private final Set<E> entries;
	public Registry() {
		backing = new TreeMap<>();
		entries = new TreeSet<>(Comparator.comparing(E::getName));
	}
	
	public Set<ResourceLocation> keySet(){
		return backing.keySet();
	}
	public void register(E entry) {
		if(backing.putIfAbsent(entry.getName(), entry)!=null)
			throw new IllegalArgumentException(entry.getName()+" is already mapped to an entry");
		entries.add(entry);
	}

	
	
	

}
