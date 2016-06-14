package autoExceltool;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.util.ArrayList;

/******************************************************
 *************                  ***********************
 *************      操作读取的数          ***********************
 *************                  ***********************
 ******************************************************/
public class Oparation 
{
	ArrayList<String> list = new ArrayList<String>();   //如果值为固定类型，则要把ArrayList变为泛型
	Judge ju = new Judge();
	public void operation(String a, int b, int c, int d, String floor[], int e,int unit[]) {
		
			for (int f = 0; f < d; f++) {							//楼层循环
				for (int u = 0; u < e; u++) {						//单元循环
					for (int i = 0; i < b; i++) {					//循环输出
						if (ju.flag1==1)
						{
							for (int j = 101; j < 101 + c; j++) {       //门牌号
									
									list.add(a);
									
									if(ju.flag==1)										//确定输出是字母还是数字
									{
										String fu = ((floor[f]) + "-" + (unit[u]));
										list.add(fu);
									}
									if(ju.flag==2)
									{
										String fu = ((floor[f])+"-"+((char)unit[u]));
										list.add(fu);
									}
									if(ju.flag==3)
									{
										Judge letter1 = new Judge();
										String fu = ((floor[f])+"-"+(letter1.letter+unit[u]));
										list.add(fu);
									}
												//添加ArrayList中的值
									String result = j + 100 * i + "";
									list.add(result);
							}
						}
						if(ju.flag1==2)
						{
							for (int j = 65; j <c+1; j++) {       //门牌号
								
								list.add(a);
								
								if(ju.flag==1)										//确定输出是字母还是数字
								{
									String fu = ((floor[f]) + "-" + (unit[u]));
									list.add(fu);
								}
								if(ju.flag==2)
								{
									String fu = ((floor[f])+"-"+((char)unit[u]));
									list.add(fu);
								}
								if(ju.flag==3)
								{
									Judge letter1 = new Judge();
									String fu = ((floor[f])+"-"+(letter1.letter+unit[u]));
									list.add(fu);
								}
											//添加ArrayList中的值
								String result = (char)j + "";
								String result1 = i+1 + result;
								list.add(result1);
							}
						}
					}
			    }
			}
	}	
/******************************************************
 *************                  ***********************
 *************   输出写好的list    ***********************
 *************                  ***********************
 ******************************************************/
	public void output(){
		try 
		{
			String e_name = null;
			String e_unit = null;
			String e_number = null;
			int l = 1;
			WritableWorkbook book = Workbook.createWorkbook(new File("F:\\MyDbank\\test2.xls"));
			// 生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("第一页", 0);	
			// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
						
			// 将定义好的单元格添加到工作表中
			sheet.addCell(new Label(0, 0, "小区名"));
			sheet.addCell(new Label(1, 0, "单元号"));
			sheet.addCell(new Label(2, 0, "门牌号"));
			for(int x=0;x<list.size();x++){
				if((x+1)%3 == 1){
					e_name = (String) list.get(x);
					sheet.addCell(new Label(0, l, e_name));
				}
				if((x+1)%3 == 2){
					e_unit = (String) list.get(x);
					sheet.addCell(new Label(1, l, e_unit));
				}
				if((x+1)%3 == 0){
					e_number = (String) list.get(x);
					sheet.addCell(new Label(2, l, e_number));
					l++;
				}
			}
		//	System.out.println(list);
		//  写入数据并关闭文件
			book.write();
			book.close();
		} catch (Exception error) {
			 System.out.println(error);
		  }
	 }
}
