package learnIO.Decorate;
/**
 * 实现放大器对声音的放大功能
 * @author qizidog
 *
 */
public class TestDecorate01 {
	public static void main(String[] args) {
		Person p = new Person();
		p.say();
		
		Amplifier amp = new Amplifier(p);
		amp.say();
	}
}


interface Say{
	void say();
}

class Person implements Say{
	private int voice = 10;
	private int scale = 20;
	public void say(){
		System.out.println("人的声音为："+this.getVoice()*this.scale);
	}
	
	public int getVoice() {
		return voice;
	}
	
	public void setVoice(int voice) {
		this.voice = voice;
	}

}


class Amplifier implements Say{
	private Person p;
	
	Amplifier(Person p) {
		this.p = p;
	}
	
	@Override
	public void say() {
		System.out.println("人的声音为："+this.p.getVoice());
	}
	
}
