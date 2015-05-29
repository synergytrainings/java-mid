package com.synisys.builder;

import com.synisys.builder.util.PlanetType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by arpine on 5/14/15.
 */
public class main {
	static final double G = 6.67384 * Math.pow(10, -11);

	public static void  main(String[] args){
		System.out.println("----BUILDER PATTERN---");
		SolarSystemPlanets mercuri = new SolarSystemPlanets.PlanetBuilder().name("Mercuri").createPlanet();
		SolarSystemPlanets jupiter = new SolarSystemPlanets.PlanetBuilder().name("Jupiter").planetType(PlanetType.JOVIAN).createPlanet();

		System.out.println(mercuri.toString());
		System.out.println(jupiter.toString());


		System.out.println("----INNER CLASSES---");
		Planet planetMercuri = new Planet("Mercuri", 3.30E23,2440);

		System.out.println("____InnerClass____");
		System.out.println("The surface gravity for given Planet is " + planetMercuri.new Gravity().calculateSurfaceGravity(G));


		//Local Inner Class
		System.out.println("____LocalInnerClass____");
		System.out.println(planetMercuri.printDiameter());



		//static inner class
		System.out.println("_____StaticInnerClass____");
		System.out.println(Planet.calculateCurrentPlanetLocation(0, 0));


		Planet planetVenus = new Planet("Venus", 4.869E24,6051.8);

		List<Planet> planetList = new ArrayList<Planet>();

		planetList.add(planetVenus);
		planetList.add(planetMercuri);

		// Anonymous inner class
		//sort by surface gravity
		System.out.println("____AnonymousInnerClass____");
		System.out.println("--before using comparator class--");
		for (Planet p : planetList) {
			System.out.println(p);
		}
		Collections.sort(planetList, new Comparator<Planet>() {

			@Override
			public int compare(Planet o1, Planet o2) {
				Double o1Gravity = o1.new Gravity().calculateSurfaceGravity(G);
				Double o2Gravity = o2.new Gravity().calculateSurfaceGravity(G);
				return o1Gravity.compareTo(o2Gravity);
			}

		});
		System.out.println("--after using comparator class--");
		for (Planet p : planetList) {
			System.out.println(p);
		}

	}
}
