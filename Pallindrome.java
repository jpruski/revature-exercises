class Pallindrome {
	
	static boolean palindromedescendant(int n) throws Exception
	{
		try {
			return palindromedescendant(n, new StringBuilder(), 0);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	static boolean palindromedescendant(int n, StringBuilder outputString, int depth) throws Exception
	{
		outputString.append("\n");
		for (int i = 0; i < depth; i++)
			 outputString.append("\t");
		int temp = n;
		if (n < 10) {
			outputString.append("not a pallindrome");
			System.out.println(outputString.toString());
			return false;
		} else {
			int places = (int) Math.ceil(Math.log10(n));
			int[] digits = new int[places];
			for (int i = 0; i < places; i++) {
				digits[places-1-i] = n%10;
				n = Math.floorDiv(n, 10);
			}
			for (int i = Math.floorDiv(places, 2); i >= 0; i--) {
				if (digits[i]==digits[places-i-1]) {
					continue;
				} else {
					outputString.append("rejected: ");
					outputString.append(temp);
					int nxt = 0;
					int place = (digits.length/2 - 1);
					if (digits.length%2==1) {
						outputString.append("\nodd number of digits in base ten: ");
						outputString.append("\n");
						for (int value : digits)
							outputString.append(value);
						outputString.append("\n");
						System.out.println(outputString.toString());
						throw new Exception();
					}
					for (int digit = 0; digit < digits.length; digit+=2) {
						nxt += Math.pow(10,place--)*(digits[digit]+digits[digit+1]);
					}
					return palindromedescendant(nxt, outputString, depth+1);
				}
			}
			outputString.append("pallindrome at:");
			outputString.append(temp);
			System.out.println(outputString.toString());
			return true;
		}
	}
	public static void main(String[] args)
	{
		try {
			System.out.println(palindromedescendant(123312));
		} catch (Exception e) {
			System.out.println("EXCEPTION! odd number of digits in recursive call");
		}
		try {
			System.out.println(palindromedescendant(11211230));
		} catch (Exception e) {
			System.out.println("EXCEPTION! odd number of digits in recursive call");
		}
		try {
			System.out.println(palindromedescendant(13001120));
		} catch (Exception e) {
			System.out.println("EXCEPTION! odd number of digits in recursive call");
		}
		try {
			System.out.println(palindromedescendant(23336014));
		} catch (Exception e) {
			System.out.println("EXCEPTION! odd number of digits in recursive call");
		}
		try {
			System.out.println(palindromedescendant(11));
		} catch (Exception e) {
			System.out.println("EXCEPTION! odd number of digits in recursive call");
		}
	}
}