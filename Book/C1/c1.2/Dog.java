public class Dog {
	public int weightInPounds;
	public Dog(int w){
		weightInPounds = w;
	}
	
	public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weightInPounds > d2.weightInPounds) {
            return d1;
        }
        return d2;
    }
	
/* 	public static Dog maxDogV2(Dog d1, Dog d2) {
		if (weightInPounds > d2.weightInPounds) {
			return this;
		}
		return d2;
	} */
	
	public Dog maxDogSelf(Dog d3){
		if (this.weightInPounds > d3.weightInPounds) {
            return this;
        }
        return d3;
	}
	public void makeNoise() {
		if(weightInPounds < 10){
			System.out.println("yipyipyip!");
		}else if(weightInPounds < 30){
			System.out.println("bark. bark.");
		}else{
			System.out.println("woof!");
		}
	}
}