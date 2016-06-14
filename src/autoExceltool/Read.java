package autoExceltool;

//import java.util.Scanner;

/******************************************************
 *************                  ***********************
 *************     读取各个参数             ***********************
 *************                  ***********************
 ******************************************************/
public class Read 
{
/*	public apartment readData(int judge)       		// 在控制台读取键盘数据
	{
		apartment apt = new apartment();
		Scanner na = new Scanner(System.in);		// 输入小区名称，如果继续输入则不用输入小区名称
		System.out.print("输入小区名称：");
		apt.setName(na.nextLine());
		Scanner fl = new Scanner(System.in); 
		System.out.println("输入小区楼栋号，用逗号隔开：");  // 输入小区楼栋号，用逗号隔开：
		String num = fl.nextLine();
		String ff[] = num.split(",");				// 转换成整形数组
		String floor[] = new String[ff.length];
		for (int i = 0; i < ff.length; i++) {
			  floor[i] = ff[i];
		//	  System.out.println(floor[i]);
		}
		apt.setFf_length(floor.length);
		apt.setFloor(floor);
	
		//	Scanner ut = new Scanner(System.in);	    // 输入小区单元数
		System.out.println("输入小区单元数：");
		int un = na.nextInt();
		int unit[] = new int[un];
		for (int i = 0; i < un; i++) {
			int temp = i;
			unit[i] = ++temp;
		}  
		apt.setUn_length(unit.length);
		apt.setUnit(unit);
		
		System.out.println("每单元有几层：");			// 每单元有几层
		int story = na.nextInt();
		apt.setStory(story);
		
		System.out.println("每层有几户：");				// 每层有几户
		int outdoor = na.nextInt();
		apt.setOutdoor(outdoor);
		return apt;
	}*/
	//读取java swing中的数据
	public apartment readData()
	{
		apartment apt = new apartment();
		AutoExceltool na = new AutoExceltool();
		
	//	System.out.println("Read里的name="+name);
		apt.setName(na.text1);
		
		String num = na.text2;
		String ff[] = num.split(",");				// 转换成整形数组
		String floor[] = new String[ff.length];
		for (int i = 0; i < ff.length; i++) {
			  floor[i] = ff[i];
		//	  System.out.println(floor[i]);
		}
		apt.setFf_length(floor.length);
		apt.setFloor(floor);
		
		Judge jd = new Judge();
		int un = jd.judgeUnit(na.text3);
		if(jd.flag == 1)											//flag=1  处理了数字自增
		{
			int unit[] = new int[un];
			for (int i = 0; i < un; i++) {
				int temp = i;
				unit[i] = ++temp;
			}
			apt.setUn_length(unit.length);
			apt.setUnit(unit);
		}
		if (jd.flag == 2)											//flag=2  处理了字母自增
		{
			int unit[] = new int[un-64];
			for (int i = 0; i < un-64; i++) {
				unit[i] = i+65;
			}
			apt.setUn_length(unit.length);
			apt.setUnit(unit);
		}
		if(jd.flag == 3)										//flag=3    只处理了数字那位，字母那位直接输出的
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
		
		int story = na.text4;						// 每单元有几层
		apt.setStory(story);
		
		int un1 = jd.judgeNumber(na.text5);           // 每层有几户
 
			apt.setOutdoor(un1);

		return apt;
	}
	
	//读取java swing中的数据
//		public apartment readData(String text1,String text2,String text3,int text4,String text5)
//		{
//			apartment apt = new apartment();
//			
//			
//		//	System.out.println("Read里的name="+name);
//			apt.setName(text1);
//			
//			String num = text2;
//			String ff[] = num.split(",");				// 转换成整形数组
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
//			if(jd.flag == 1)											//flag=1  处理了数字自增
//			{
//				int unit[] = new int[un];
//				for (int i = 0; i < un; i++) {
//					int temp = i;
//					unit[i] = ++temp;
//				}
//				apt.setUn_length(unit.length);
//				apt.setUnit(unit);
//			}
//			if (jd.flag == 2)											//flag=2  处理了字母自增
//			{
//				int unit[] = new int[un-64];
//				for (int i = 0; i < un-64; i++) {
//					unit[i] = i+65;
//				}
//				apt.setUn_length(unit.length);
//				apt.setUnit(unit);
//			}
//			if(jd.flag == 3)										//flag=3    只处理了数字那位，字母那位直接输出的
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
//			int story = text4;						// 每单元有几层
//			apt.setStory(story);
//			
//			int un1 = jd.judgeNumber(text5);           // 每层有几户
//	 
//				apt.setOutdoor(un1);
//
//			return apt;
//		}
}
