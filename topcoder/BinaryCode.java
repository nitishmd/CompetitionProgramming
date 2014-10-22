/*
 * Author: Nitish
 * Description: TopCoder SRM
 */
public class BinaryCode
{
	public static String[] decode(String message)
	{
		int msgLength = message.length();
		int[] P = new int[msgLength];
		int[] Q = new int[msgLength];

		for (int i = 0 ; i < msgLength ; i++)
		{
			Q[i] = Character.digit(message.charAt(i), 10);
		}

		String[] str = new String[2];
		str[0] = "0";
		str[1] = "1";
		int k = 0;
		/* Boundary Check */
		if (msgLength < 1 || msgLength > 50 || (msgLength == 1 && Q[0] > 1))
		{
			str[0] = "NONE";
			str[1] = "NONE";
			return str;
		}

		while (k < 2)
		{
			System.out.println("Iteration: "+k+"\n");
			P[0] = k;
			for (int i = 0 ; i < msgLength - 1; i++)
			{
				if (Q[i] < 0 || Q[i] > 3)
				{
					System.out.println("Q out of range\n"+Q[i]);
					str[0] = "NONE";      
					str[1] = "NONE";
					return str;
				}

				if ((i - 1) < 0)
				{
					P[i+1] = Q[i] - P[i];
				}
				else
				{
					P[i+1] = Q[i] - P[i] - P[i-1];  
				}

				if ((P[i+1] == 0 || P[i+1] == 1))
				{
					str[k] = str[k] + P[i+1];
					System.out.println(str[k]+"\n");
				}
				else
				{
					str[k] = "NONE";
					break;
				}
				if (i == msgLength - 2)
				{  
					if (!((Q[msgLength - 1] - P[msgLength - 2]) == P[msgLength - 1]))
					{
						str[k] = "NONE";
					}
				}
			}
			k++;
		}

		return str;
	}

	public static void main(String[] args)
	{
		String s = "3";
		String[] res = decode(s);

		System.out.println("a : "+ res[0] + " b : "+res[1]);
	}
}
