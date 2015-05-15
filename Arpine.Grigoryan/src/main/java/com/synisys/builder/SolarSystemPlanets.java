package com.synisys.builder;

import com.synisys.builder.util.PlanetType;

import java.util.Date;
import java.util.Objects;

/**
 * Created by arpine on 5/14/15.
 */
public class SolarSystemPlanets {
	private int number;
	private  double mass;
	private  double radius;
	private  double rotationTime;
	private  String name;
	private  String composition;
	private Date dateOfDiscovery;
	private PlanetType planetType;


	public static class PlanetBuilder {

		private int number;
		private  double mass;
		private  double radius;
		private  double rotationTime;
		private  String name;
		private  String composition;
		private Date dateOfDiscovery;
		private PlanetType planetType = PlanetType.TERRESTRIAL;
//
//		default constructor for PlanetBuilder
//		public PlanetBuilder(String name, int number) {
//			this.name = name;
//			this.number = number;
//		}

		public PlanetBuilder number(int number) {
			this.number = number;
			return this;
		}

		public PlanetBuilder mass(double mass) {
			this.mass = mass;
			return  this;
		}

		public PlanetBuilder radius(double radius) {
			this.radius = radius;
			return  this;
		}

		public PlanetBuilder rotationTime(double rotationTime) {
			this.rotationTime = rotationTime;
			return  this;
		}

		public PlanetBuilder name(String name) {
			this.name = name;
			return  this;
		}

		public PlanetBuilder composition(String composition) {
			this.composition = composition;
			return  this;
		}

		public PlanetBuilder planetType(PlanetType planetType) {
			this.planetType = planetType;
			return  this;
		}

		public PlanetBuilder dateOfDiscovery(Date getDateOfDiscovery) {
			this.dateOfDiscovery = getDateOfDiscovery;
			return this;
		}


		public SolarSystemPlanets createPlanet(){
			return new SolarSystemPlanets(this);
		}
	}

	public SolarSystemPlanets(PlanetBuilder builder) {
		this.name = builder.name;
		this.mass = builder.mass;
		this.radius = builder.radius;
		this.rotationTime = builder.rotationTime;
		this.number = builder.number;
		this.composition = builder.composition;
		this.dateOfDiscovery = builder.dateOfDiscovery;
		this.planetType = builder.planetType;
	}

	@Override
	public String toString() {
		return "SolarSystemPlanets{" +
				"number=" + Objects.toString(number)  +
				", mass=" + mass +
				", radius=" + radius +
				", rotationTime=" + rotationTime +
				", name='" + Objects.toString(name,"") + '\'' +
				", composition='" + Objects.toString(composition, "") + '\'' +
				", dateOfDiscovery=" + Objects.toString(dateOfDiscovery,"") +
				", planetType=" + planetType +
				'}';

	}

}
