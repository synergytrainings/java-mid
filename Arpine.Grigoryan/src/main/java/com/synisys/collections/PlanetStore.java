package com.synisys.collections;

import com.synisys.builder.Planet;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by arpine on 6/5/15.
 */
public class PlanetStore {

	private WeakHashMap<String, Planet> planets_W = new WeakHashMap<String, Planet>();;
	private HashMap<String, Planet> planets = new HashMap<String, Planet>();;

	public void addPlanet(String name,Planet planet) {
		if (!this.planets.containsKey(name)) {
			this.planets.put(name, planet);
		}
	}

	public void addPlanet_W(String name,Planet planet) {
		if (! this.planets_W.containsKey(name)) {
			this.planets_W.put(name, planet);
		}
	}

	public WeakHashMap<String, Planet> getPlanets_W() {
		return planets_W;
	}

}
