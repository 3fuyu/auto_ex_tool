package autoExceltool;


// 判段单元号门牌号是否为英文的类
public class Judge 
{
	int text1;
	public static String letter;
	public static String num;
	public static int flag;
	public static int flag1;
	public int judgeUnit(String text)
	{
		try
		{
			 flag = 1;
			 text1 = Integer.parseInt(text);				//flag=1;"单元号1,2,3,4的情况"
		}
		catch(NumberFormatException e)
		{
			try
			{
				if(text.length()==1)                         //flag=2;"单元号A,B,C,D的情况"
				{
					flag = 2;
					text1 = text.hashCode();
				}
				else 
				{
					flag = 3;								 //flag=3;"单元号A1,A2,A3,A4"
					letter = text.substring(0,1);
					num = text.substring(1);
					text1 = letter.hashCode()+Integer.parseInt(num);
				}
			}
			catch(NumberFormatException e_1)
			{
				System.out.println("error");
			}
		}
		return text1;
	}
	public int judgeNumber(String text)						//门牌号辨别数字和英文
	{	
		int text2;
		try													//如果能强制转换成int，则是数字，不能就进下一循环
		{
			flag1 = 1;
			text2 = Integer.parseInt(text);
		}
		catch (NumberFormatException e_2)					//不能转换就是英文字母，就转换成数字传回去
		{
			flag1 = 2;
			text2 = text.hashCode();
		}
		return text2;
	}
}
