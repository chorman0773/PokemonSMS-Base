package github.chorman0773.pokemonsms.common.util;


import java.util.*;
import java.util.stream.Stream;

public class Registry<E extends RegistryEntry<E>> implements Iterable<E>{
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

	public E getByName(ResourceLocation loc){
		return backing.get(loc);
	}

	public Stream<E> entries(){
		return entries.stream();
	}


	@Override
	public Iterator<E> iterator() {
		return entries.iterator();
	}

	@Override
	public Spliterator<E> spliterator() {
		return entries.spliterator();
	}
}
