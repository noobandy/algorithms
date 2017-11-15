import java.util.Random;

public class Sampling {
	private static final Random randGen = new Random();

	public static void suffle(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int j = randGen.nextInt(i + 1);

			swap(arr, i, j);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int[] randomSample(int[] population, int sampleSize) {

		int[] sample = new int[sampleSize];

		for(int i = 0; i < sampleSize; i++) {
			int next = randGen.nextInt(population.length);
			sample[i] = population[next];
		}

		return sample;
	}

	public static void simulateRandomSampling() {
		int lion = 0;
		int turtle = 1;
		int rabbit = 3;

		int[] population = new int[100];

		for(int i = 0; i < 60; i++) {
			population[i] = lion;
		}

		for(int i = 60; i < 90; i++) {
			population[i] = turtle;
		}

		for(int i = 90; i < 100; i++) {
			population[i] = rabbit;
		}

		suffle(population);

		int[] sample = randomSample(population, 10);

		int sampledLions = 0;
		int sampledTurtles = 0;
		int sampledRabbits = 0;

		for(int i = 0; i < 10; i++) {
			switch(sample[i]) {
				case 0: sampledLions++;
				break;
				case 1: sampledTurtles++;
				break;
				case 2: sampledRabbits++;
				break;
			}
		}

		System.out.format("lions: %d, turtles: %d, rabbits: %d%n", sampledLions, sampledTurtles, sampledRabbits);
	}

	public static void main(String[] args) {
		Sampling.simulateRandomSampling();	
	}
}