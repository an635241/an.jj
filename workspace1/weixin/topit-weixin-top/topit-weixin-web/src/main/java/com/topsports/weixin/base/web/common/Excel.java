package com.topsports.weixin.base.web.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;


@SuppressWarnings("hiding")
public class Excel<T> {
	public static final int columnWidth = 13;
	
	
	public static ArrayList<ArrayList<String>> readFromXLS2003(String filePath){
		File excelFile = null;// Excel文件对象  
        InputStream is = null;// 输入流对象  
        String cellStr = null;// 单元格，最终按字符串处理
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();//返回的数据
        try {  
            excelFile = new File(filePath);  
            is = new FileInputStream(excelFile);// 获取文件输入流  
            HSSFWorkbook workbook2003 = new HSSFWorkbook(is);// 创建Excel2003文件对象  
            HSSFSheet sheet = workbook2003.getSheetAt(0);// 取出第一个工作表，索引是0  
            
            // 开始循环遍历行，表头不处理，从1开始  
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
            	ArrayList<String> list = new ArrayList<String>();
                HSSFRow row = sheet.getRow(i);// 获取行对象  
                if (row == null) {// 如果为空，不处理  
                    continue;  
                }  
                // 循环遍历单元格  
                for (int j = 0; j < row.getLastCellNum(); j++) {  
                    HSSFCell cell = row.getCell(j);// 获取单元格对象  
                    if (cell == null) {// 单元格为空设置cellStr为空串  
                        cellStr = "";  
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {// 对布尔值的处理  
                        cellStr = String.valueOf(cell.getBooleanCellValue());  
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {// 对数字值的处理  
                        cellStr = cell.getNumericCellValue() + "";  
                    } else {// 其余按照字符串处理  
                        cellStr = cell.getStringCellValue();  
                    }  
                    
                    list.add(cellStr);
                }  
                lists.add(list);
            }  
	} catch (IOException e) {  
            e.printStackTrace();  
        } finally {// 关闭文件流  
            if (is != null) {  
                try {  
                    is.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return lists;
	}
	
	
	
	public HSSFWorkbook exportToXLS2003(String[] excelHeader, List<T> excelList) {
        return exportToXLS2003(excelHeader, excelList,"yyyy-MM-dd");
    }
	/**
	 * @Title: exportToXLS2003
	 * @Description: 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符合一定条件的数据以EXCEL 的形式输出到指定IO设备上
	 * @param title 表格标题名 
	 * @param excelHeader 表格属性列名数组
	 * @param excelList 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的javabean属性的数据类型有基本数据类型及String,Date
	 * @param pattern 如果有时间数据，设定输出格式。默认为"yyyy-MM-dd"
	 * @return HSSFWorkbook    返回类型
	 * @throws
	 */
	@SuppressWarnings("deprecation")
	public HSSFWorkbook exportToXLS2003(String[] excelHeader, List<T> excelList, String pattern){
		HSSFWorkbook wb = new HSSFWorkbook();    
        HSSFSheet sheet = wb.createSheet("Sheet1");    
        sheet.setDefaultColumnWidth(columnWidth);
        HSSFRow row = sheet.createRow((int) 0);

        // 产生表格标题行
        for (int i = 0; i < excelHeader.length; i++) {    
            HSSFCell cell = row.createCell(i);    
            cell.setCellValue(excelHeader[i]);    
            //第一个参数代表列数 第二个参数代表宽度 每一个字节长度的256倍为宽度
            if(excelHeader[i].getBytes().length * 2 > columnWidth)
            	sheet.setColumnWidth(i,excelHeader[i].getBytes().length * 256 * 2);
        }    

        // 产生表格数据
        Iterator<T> itList = excelList.iterator();
        int index = 0;
        while (itList.hasNext()) {
        	index++;
        	row = sheet.createRow(index);
        	T t = (T) itList.next();
        	// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
            	HSSFCell cell = row.createCell(i);
            	Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                	Class<? extends Object> tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } else if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else {
                        // 其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                            cell.setCellValue(richString);
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    // 清理资源	
                }
                
            }
        }
		return wb;
        
	}
	
	
}