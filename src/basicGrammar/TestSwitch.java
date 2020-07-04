package basicGrammar;
/**
 * 
 * @author qizidog
 *
 */

public class TestSwitch {
	public static void main(String[] args) {
		int month = (int)(1+12*Math.random());
		System.out.println("月份："+month);
		
		switch(month) {
		case 1:
			System.out.println("January");
			break;
		case 2:
			System.out.println("Feburary");
			break;
		case 3:
			System.out.println("March");
			break;
		case 4:
			System.out.println("April");
			break;
		case 5:
			System.out.println("May");
			break;
		case 6:
			System.out.println("June");
			break;
		default:
			System.out.println("Other");
			break;
		}
			
		System.out.println("#################################");
		
		
		char c = 'a';
        int rand = (int) (26 * Math.random());
        char c2 = (char) (c + rand);
        System.out.print(c2 + ": ");
        switch (c2) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            System.out.println("元音");
            break;
        case 'y':
        case 'w':
            System.out.println("半元音");
            break;
        default:
            System.out.println("辅音");
		}
        
        
        System.out.println("#################################");
		
        int rand3 = (int) (26 * Math.random());
        char c3 = (char) (c + rand);
        System.out.print(c2 + ": ");
        switch (c3) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            System.out.println("元音");
            break;
        case 'y':
        case 'w':
            System.out.println("半元音");
            break;
        default:
            System.out.println("辅音");
		}
        
	}
}
