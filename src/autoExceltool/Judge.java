package autoExceltool;


// �жε�Ԫ�����ƺ��Ƿ�ΪӢ�ĵ���
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
			 text1 = Integer.parseInt(text);				//flag=1;"��Ԫ��1,2,3,4�����"
		}
		catch(NumberFormatException e)
		{
			try
			{
				if(text.length()==1)                         //flag=2;"��Ԫ��A,B,C,D�����"
				{
					flag = 2;
					text1 = text.hashCode();
				}
				else 
				{
					flag = 3;								 //flag=3;"��Ԫ��A1,A2,A3,A4"
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
	public int judgeNumber(String text)						//���ƺű�����ֺ�Ӣ��
	{	
		int text2;
		try													//�����ǿ��ת����int���������֣����ܾͽ���һѭ��
		{
			flag1 = 1;
			text2 = Integer.parseInt(text);
		}
		catch (NumberFormatException e_2)					//����ת������Ӣ����ĸ����ת�������ִ���ȥ
		{
			flag1 = 2;
			text2 = text.hashCode();
		}
		return text2;
	}
}
