package sia5;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxCreationTests {

	@Test
	public void createAFlux_just() {
		Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");

		fruitFlux.subscribe(
				f -> System.out.println("Here's some fruit: " + f));

		StepVerifier.create(fruitFlux)
			.expectNext("Apple")
			.expectNext("Orange")
			.expectNext("Grape")
			.expectNext("Banana")
			.expectNext("Strawberry")
			.verifyComplete();
	}

	@Test
	public void createAFlux_fromArray() {
		String[] fruits = new String[] {
			"Apple", "Orange", "Grape", "Banana", "Strawberry" };
	  
		Flux<String> fruitFlux = Flux.fromArray(fruits);
	  
		fruitFlux.subscribe(
				f -> System.out.println("Fruit from array: " + f));

		StepVerifier.create(fruitFlux)
			.expectNext("Apple")
			.expectNext("Orange")
			.expectNext("Grape")
			.expectNext("Banana")
			.expectNext("Strawberry")
			.verifyComplete();
	  	
	}
	
	@Test
	public void createAFlux_fromIterable() {
		List<String> fruitList = Arrays.asList(
				"Apple", "Orange", "Grape", "Banana", "Strawberry");
		
		Flux<String> fruitFlux = Flux.fromIterable(fruitList);
		
		fruitFlux.subscribe(
				f -> System.out.println("Fruit from iterable: " + f));

		StepVerifier.create(fruitFlux)
			.expectNext("Apple")
			.expectNext("Orange")
			.expectNext("Grape")
			.expectNext("Banana")
			.expectNext("Strawberry")
			.verifyComplete();		
	}
	
	@Test
	public void createAFlux_fromStream() {
		Stream<String> fruitStream = 
				Stream.of("Apple", "Orange", "Grape", "Banana", "Strawberry");
		
		Flux<String> fruitFlux = Flux.fromStream(fruitStream);
		
//		fruitFlux.subscribe(
//				f -> System.out.println("Fruit from stream: " + f));

		StepVerifier.create(fruitFlux)
			.expectNext("Apple")
			.expectNext("Orange")
			.expectNext("Grape")
			.expectNext("Banana")
			.expectNext("Strawberry")
			.verifyComplete();			
	}
	
	@Test
	public void createAFlux_range() {
		Flux<Integer> intervalFlux =
				Flux.range(1, 5);
		
		StepVerifier.create(intervalFlux)
		.expectNext(1)
		.expectNext(2)
		.expectNext(3)
		.expectNext(4)
		.expectNext(5)
		.verifyComplete();			
	}
	
	@Test
	public void createAFlux_interval() {
		Flux<Long> intervalFlux =
			Flux.interval(Duration.ofSeconds(1))
				.take(5);
	  
	  StepVerifier.create(intervalFlux)
	      .expectNext(0L)
	      .expectNext(1L)
	      .expectNext(2L)
	      .expectNext(3L)
	      .expectNext(4L)
	      .verifyComplete();
	}
}
