package autoExceltool;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.util.ArrayList;

/******************************************************
 *************                  ***********************
 *************      ������ȡ����          ***********************
 *************                  ***********************
 ******************************************************/
public class Oparation 
{
	ArrayList<String> list = new ArrayList<String>();   //���ֵΪ�̶����ͣ���Ҫ��ArrayList��Ϊ����
	Judge ju = new Judge();
	public void operation(String a, int b, int c, int d, String floor[], int e,int unit[]) {
		
			for (int f = 0; f < d; f++) {							//¥��ѭ��
				for (int u = 0; u < e; u++) {						//��Ԫѭ��
					for (int i = 0; i < b; i++) {					//ѭ�����
						if (ju.flag1==1)
						{
							for (int j = 101; j < 101 + c; j++) {       //���ƺ�
									
									list.add(a);
									
									if(ju.flag==1)										//ȷ���������ĸ��������
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
												//���ArrayList�е�ֵ
									String result = j + 100 * i + "";
									list.add(result);
							}
						}
						if(ju.flag1==2)
						{
							for (int j = 65; j <c+1; j++) {       //���ƺ�
								
								list.add(a);
								
								if(ju.flag==1)										//ȷ���������ĸ��������
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
											//���ArrayList�е�ֵ
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
 *************   ���д�õ�list    ***********************
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
			// ������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ
			WritableSheet sheet = book.createSheet("��һҳ", 0);	
			// ��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0)
						
			// ������õĵ�Ԫ����ӵ���������
			sheet.addCell(new Label(0, 0, "С����"));
			sheet.addCell(new Label(1, 0, "��Ԫ��"));
			sheet.addCell(new Label(2, 0, "���ƺ�"));
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
		//  д�����ݲ��ر��ļ�
			book.write();
			book.close();
		} catch (Exception error) {
			 System.out.println(error);
		  }
	 }
}
