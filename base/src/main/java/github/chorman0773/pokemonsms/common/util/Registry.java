package github.chorman0773.pokemonsms.common.util;


import java.util.*;
import java.util.stream.Stream;

public class Registry<E extends RegistryEntry<E>> implements Iterable<E>, RegistryEntry<Registry<?>> {
	private final Map<ResourceLocation,E> backing;
	private final Set<E> entries;
	private final ResourceLocation location;
	public Registry(ResourceLocation name) {
		backing = new TreeMap<>();
		entries = new TreeSet<>(Comparator.comparing(E::getName));
		this.location = name;
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

	public RegistryObject<E> getObject(ResourceLocation loc){
	    return new RegistryObject<>(this,loc);
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

	@Override
	public ResourceLocation getName() {
		return location;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Class<Registry<?>> getRegistryType() {
		return (Class<Registry<?>>)(Class<? extends Registry>)Registry.class;
	}
}
