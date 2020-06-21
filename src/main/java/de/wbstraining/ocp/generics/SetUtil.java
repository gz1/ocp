package de.wbstraining.ocp.generics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class SetUtil {

	// wir schreiben die methode count(). sie zählt, wie viele elemente
	// eines sets eine gegebene eigenschaft haben.

	public static <T> long count(Set<T> set, Predicate<? super T> predicate) {
		long anzahl = 0;
		for (T t : set) {
			if (predicate.test(t)) {
				anzahl++;
			}
		}
		return anzahl;
	}

	// wir schreiben die methode allMatch(). sie ermittelt, ob alle elemente
	// eines sets eine gegebene eigenschaft haben.

	public static <T> boolean allMatch(Set<T> set, Predicate<? super T> predicate) {
		boolean result = true;
		for (T t : set) {
			if (!predicate.test(t)) {
				result = false;
				break;
			}
		}
		return result;
	}

//	  wir schreiben die methode pairBuilder(). sie liefert ein Set von paaren.
//	  die elemente eines paares "passen zueinander".
//	  
//	  bsp.: ein set von paaren von stellensuchenden und stellenangeboten (die
//	  zueinander passen...)
//	  
//	  bsp.: ein set von paaren von partnersuchenden (die zueinander passen...).
//	
//	  wir testen in PairBuilderDemo

	public static <F, S> Set<Pair<F, S>> pairBuilder(Set<F> set1, Set<S> set2,
			BiPredicate<? super F, ? super S> biPredicate) {
		Set<Pair<F, S>> result = new HashSet<>();
		for (F f : set1) {
			for (S s : set2) {
				if (biPredicate.test(f, s)) {
					result.add(new Pair<>(f, s));
				}
			}
		}
		return result;
	}

	// wir berechnen den durchschnitt aller noten einer bausteinprüfung.
	// wir ermitteln das durchschnittsalter aller einwohner esslingens.
	// wir ermitteln die durchschnittliche leistung aller 2019
	// neu zugelassenen pkws.

	// methodenname: average()

	// den return-typ werden wir später noch ändern zu OptionalDouble...
	public static <T> double average(Set<T> set, ToDoubleFunction<T> function) {
		double summe = 0;
		for (T t : set) {
			summe += function.applyAsDouble(t);
		}
		return set.size() == 0 ? 0 : summe / set.size();
	}

	// wir zerlegen eine menge von zahlen in 2 gruppen, die geraden und die
	// ungeraden.
	// wir zerlegen die einwohner einer stadt in 2 gruppen, die volljährigen
	// und die minderjährigen.

	// methodenname: partitioningBy()
	public static <T> Map<Boolean, Set<T>> partitioningBy(Set<T> set, Predicate<? super T> predicate) {

		Set<T> trueValues = new HashSet<T>();
		Set<T> falseValues = new HashSet<T>();
		Map<Boolean, Set<T>> map = new HashMap<>();
		for (T t : set) {
			if (predicate.test(t)) {
				trueValues.add(t);
			} else {
				falseValues.add(t);
			}
		}
		map.put(true, trueValues);
		map.put(false, falseValues);
		return map;

//		Map<Boolean, Set<T>> map = new HashMap<>();
//		map.put(true, new HashSet<>());
//		map.put(false, new HashSet<>());
//		for(T t : set) {
//			map.get(predicate.test(t)).add(t);
//		}
//		return map;

	}

	// wir ordnen alle abgordneten des bundestages in gruppen.
	// alle abgeordneten einer gruppe gehören zur selben partei.

	// wir ordnen alle wahlberechtigten eines bundeslandes in gruppen.
	// alle wahlberechtigten einer gruppe gehören zum selben wahlkreis.

	// wir ordnen alle zahlen zwischen 100 und 200 in gruppen.
	// alle zahlen in derselben gruppe haben dieselbe quersumme.

	// methodenname: groupingBy()

	// wir testen in GroupingByDemo

	// T: typ (abgeordneter, wahlberechtigter, Integer)
	// P: property (partei, wahlkreis, Integer)
	
	// hauptlogik
	// iteriere über alle elemente von set
	// bilde das aktuelle element auf seine property ab und verwende dazu function.apply()
	// prüfe, ob die gefundene property bereits ein key in der map ist
	// falls nein: erzeuge ein neues set und einen neuen eintrag in der map
	// falls ja: füge das neue element in das bereits bestehende set ein
	// füge das aktuelle element ins subset ein

	public static <T, P> Map<P, Set<T>> groupingBy(Set<T> set, Function<T, P> function) {
		Map<P, Set<T>> result = new HashMap<P, Set<T>>();
		P property;
		Set<T> subset;
		for(T t : set) {
			property = function.apply(t);
			subset = result.get(property);
			if(subset == null) {
				subset = new HashSet<T>();
				result.put(property, subset);
			}
			subset.add(t);
		}
		return result;
	}

}
