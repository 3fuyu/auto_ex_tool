package autoExceltool;

//import java.util.Scanner;

/******************************************************
 *************                  ***********************
 *************     ��ȡ��������             ***********************
 *************                  ***********************
 ******************************************************/
public class Read 
{
/*	public apartment readData(int judge)       		// �ڿ���̨��ȡ��������
	{
		apartment apt = new apartment();
		Scanner na = new Scanner(System.in);		// ����С�����ƣ��������������������С������
		System.out.print("����С�����ƣ�");
		apt.setName(na.nextLine());
		Scanner fl = new Scanner(System.in); 
		System.out.println("����С��¥���ţ��ö��Ÿ�����");  // ����С��¥���ţ��ö��Ÿ�����
		String num = fl.nextLine();
		String ff[] = num.split(",");				// ת������������
		String floor[] = new String[ff.length];
		for (int i = 0; i < ff.length; i++) {
			  floor[i] = ff[i];
		//	  System.out.println(floor[i]);
		}
		apt.setFf_length(floor.length);
		apt.setFloor(floor);
	
		//	Scanner ut = new Scanner(System.in);	    // ����С����Ԫ��
		System.out.println("����С����Ԫ����");
		int un = na.nextInt();
		int unit[] = new int[un];
		for (int i = 0; i < un; i++) {
			int temp = i;
			unit[i] = ++temp;
		}  
		apt.setUn_length(unit.length);
		apt.setUnit(unit);
		
		System.out.println("ÿ��Ԫ�м��㣺");			// ÿ��Ԫ�м���
		int story = na.nextInt();
		apt.setStory(story);
		
		System.out.println("ÿ���м�����");				// ÿ���м���
		int outdoor = na.nextInt();
		apt.setOutdoor(outdoor);
		return apt;
	}*/
	//��ȡjava swing�е�����
	public apartment readData()
	{
		apartment apt = new apartment();
		AutoExceltool na = new AutoExceltool();
		
	//	System.out.println("Read���name="+name);
		apt.setName(na.text1);
		
		String num = na.text2;
		String ff[] = num.split(",");				// ת������������
		String floor[] = new String[ff.length];
		for (int i = 0; i < ff.length; i++) {
			  floor[i] = ff[i];
		//	  System.out.println(floor[i]);
		}
		apt.setFf_length(floor.length);
		apt.setFloor(floor);
		
		Judge jd = new Judge();
		int un = jd.judgeUnit(na.text3);
		if(jd.flag == 1)											//flag=1  ��������������
		{
			int unit[] = new int[un];
			for (int i = 0; i < un; i++) {
				int temp = i;
				unit[i] = ++temp;
			}
			apt.setUn_length(unit.length);
			apt.setUnit(unit);
		}
		if (jd.flag == 2)											//flag=2  ��������ĸ����
		{
			int unit[] = new int[un-64];
			for (int i = 0; i < un-64; i++) {
				unit[i] = i+65;
			}
			apt.setUn_length(unit.length);
			apt.setUnit(unit);
		}
		if(jd.flag == 3)										//flag=3    ֻ������������λ����ĸ��λֱ�������
		{
			Judge number = new Judge();
			int unit[] = new int[Integer.parseInt(number.num)];
			for (int i = 0;i<Integer.parseInt(number.num); i++) 
			{
				unit[i] =i+1;
			}
			apt.setUn_length(unit.length);
			apt.setUnit(unit);
		}
		
		int story = na.text4;						// ÿ��Ԫ�м���
		apt.setStory(story);
		
		int un1 = jd.judgeNumber(na.text5);           // ÿ���м���
 
			apt.setOutdoor(un1);

		return apt;
	}
	
	//��ȡjava swing�е�����
//		public apartment readData(String text1,String text2,String text3,int text4,String text5)
//		{
//			apartment apt = new apartment();
//			
//			
//		//	System.out.println("Read���name="+name);
//			apt.setName(text1);
//			
//			String num = text2;
//			String ff[] = num.split(",");				// ת������������
//			String floor[] = new String[ff.length];
//			for (int i = 0; i < ff.length; i++) {
//				  floor[i] = ff[i];
//			//	  System.out.println(floor[i]);
//			}
//			apt.setFf_length(floor.length);
//			apt.setFloor(floor);
//			
//			Judge jd = new Judge();
//			int un = jd.judgeUnit(text3);
//			if(jd.flag == 1)											//flag=1  ��������������
//			{
//				int unit[] = new int[un];
//				for (int i = 0; i < un; i++) {
//					int temp = i;
//					unit[i] = ++temp;
//				}
//				apt.setUn_length(unit.length);
//				apt.setUnit(unit);
//			}
//			if (jd.flag == 2)											//flag=2  ��������ĸ����
//			{
//				int unit[] = new int[un-64];
//				for (int i = 0; i < un-64; i++) {
//					unit[i] = i+65;
//				}
//				apt.setUn_length(unit.length);
//				apt.setUnit(unit);
//			}
//			if(jd.flag == 3)										//flag=3    ֻ������������λ����ĸ��λֱ�������
//			{
//				Judge number = new Judge();
//				int unit[] = new int[Integer.parseInt(number.num)];
//				for (int i = 0;i<Integer.parseInt(number.num); i++) 
//				{
//					unit[i] =i+1;
//				}
//				apt.setUn_length(unit.length);
//				apt.setUnit(unit);
//			}
//			
//			int story = text4;						// ÿ��Ԫ�м���
//			apt.setStory(story);
//			
//			int un1 = jd.judgeNumber(text5);           // ÿ���м���
//	 
//				apt.setOutdoor(un1);
//
//			return apt;
//		}
}
