public class DogArrayDemo {
	/**Demo the use of array in instance*/
	public static void main(String[] args){
		Dog[] dogs = new Dog[2];
		dogs[0] = new Dog(15);
	    dogs[1] = new Dog(50);
	    dogs[0].makeNoise();
	    dogs[1].makeNoise();
		Dog.maxDog(dogs[0], dogs[1]).makeNoise();
		dogs[0].maxDogSelf(dogs[1]).makeNoise();
		//Dog.maxDog(dogs[0], dogs[1]).makeNoise();
	}
}