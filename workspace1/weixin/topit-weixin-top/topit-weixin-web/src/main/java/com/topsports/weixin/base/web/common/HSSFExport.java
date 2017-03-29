package com.topsports.weixin.base.web.common;


import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.Region;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.ls.LSInput;

public final class HSSFExport {
	
	/**
	 * 宸ュ叿绫婚槻姝㈢敤鎴穘ew鍑哄疄渚�
	 */
	private HSSFExport(){}

	/**
	 * 瀵煎嚭鏁版嵁鍒癊xcel,鑷姩鑾峰彇easyui鐨勮〃澶翠俊鎭� 涓� 鏌ヨ鏉′欢  鏆傛椂涓嶆敮鎸佸悎骞剁殑琛ㄥご  绾垫í杞崲鐨勮〃澶存槸鍗曠嫭鍐欑殑
	 * @param fileName
	 * @param ColumnsMapList
	 * @param dataMapList
	 * @param response
	 * @param rowAccessWindowSize 瀵煎嚭excel杩囩▼涓紝濡傛灉闇�瑕佽闂鐨勭鍑犺鏁版嵁锛屽垯锛岄渶瑕佺粰瀹氳繖涓弬鏁颁负璁块棶鐨別xcel琛屾暟锛涘浼犻�掔殑涓虹┖锛屽垯榛樿鍊间负1琛岋紝
	 * 鎺ㄨ崘浣跨敤榛樿鍊笺�� 渚嬪锛氬鏋滄兂鍦ㄧ▼搴忎腑鍙栧緱鏈�鍚�100琛岀殑鏁版嵁锛岄偅涔堣鍙傛暟=100锛� 鍚﹀垯灏辨寜鐓ч粯璁ゅ�煎鍑恒��
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void commonExportData(String fileName, List<Map> ColumnsMapList, List<Map> dataMapList,
			HttpServletResponse response, Integer rowAccessWindowSize) throws Exception {

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

		String fileName2 = new String(fileName.getBytes("gb2312"), "iso-8859-1");
		//鏂囦欢鍚�
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName2 + ".xlsx");
		response.setHeader("Pragma", "no-cache");

		if (rowAccessWindowSize == null) {

			rowAccessWindowSize = 1;
		}

		@SuppressWarnings("resource")
		SXSSFWorkbook wb = new SXSSFWorkbook(rowAccessWindowSize.intValue());
		Sheet sheet1 = wb.createSheet();
		wb.setSheetName(0, fileName);
		sheet1.setDefaultRowHeightInPoints(20);
		sheet1.setDefaultColumnWidth((short) 18);
		//璁剧疆椤佃剼
		Footer footer = sheet1.getFooter();
		footer.setRight("Page " + HSSFFooter.page() + " of " + HSSFFooter.numPages());

		//璁剧疆鏍峰紡 琛ㄥご
		CellStyle style1 = wb.createCellStyle();
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		Font font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 13);
		font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style1.setFont(font1);
		//璁剧疆鏍峰紡 琛ㄥご
		CellStyle style2 = wb.createCellStyle();
		style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style2.setWrapText(true);
		//鍚堝苟
		CellRangeAddress rg1 = new CellRangeAddress(0, (short) 0, 0, (short) (ColumnsMapList.size() - 1));
		sheet1.addMergedRegion(rg1);
		//璁剧疆鏍峰紡 琛ㄥご
		CellStyle style3 = wb.createCellStyle();
		style3.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		Font font3 = wb.createFont();
		font3.setFontHeightInPoints((short) 18);
		font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style3.setFont(font3);
		style3.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style3.setFillPattern(CellStyle.SOLID_FOREGROUND);
		Row row0 = sheet1.createRow(0);
		row0.setHeightInPoints(35);
		//绗竴琛� 鎻愮ず闀�
		Cell cell0 = row0.createCell((short) 0);
		cell0.setCellValue(fileName.toString());
		cell0.setCellStyle(style3);

		//璁剧疆琛ㄥご
		Row row1 = sheet1.createRow(1);
		row1.setHeightInPoints(20);
		for (int i = 0; i < ColumnsMapList.size(); i++) {
			Cell cell1 = row1.createCell(i);
			cell1.setCellType(HSSFCell.ENCODING_UTF_16);
			cell1.setCellValue(ColumnsMapList.get(i).get("title").toString());
			cell1.setCellStyle(style1);
		}

		//濉厖鏁版嵁
		for (int j = 0; j < dataMapList.size(); j++) {
			Row row2 = sheet1.createRow((j + 2)); // 绗笁琛屽紑濮嬪～鍏呮暟鎹� 
			Map cellDataMap = dataMapList.get(j);
			for (int i = 0; i < ColumnsMapList.size(); i++) {
				Cell cell = row2.createCell(i);
				String cellValue = StringUtils.EMPTY;
				if (ColumnsMapList.get(i).get("field") != null) {
					String fieldString = String.valueOf(ColumnsMapList.get(i).get("field"));
					cellValue = String.valueOf(cellDataMap.get(fieldString)==null?"":cellDataMap.get(fieldString));
				}
				cell.setCellValue(cellValue);
				cell.setCellStyle(style2);
			}

		}

		wb.write(response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		wb.dispose();
	}
	
	
	public void exportExcel(Collection<T> dataset, OutputStream out)  
    {  
        exportExcel("测试POI导出EXCEL文档", null, dataset, out, "yyyy-MM-dd");  
    }  
  
    public void exportExcel(String[] headers, Collection<T> dataset,  
            OutputStream out)  
    {  
        exportExcel("测试POI导出EXCEL文档", headers, dataset, out, "yyyy-MM-dd");  
    }  
  
    public void exportExcel(String[] headers, Collection<T> dataset,  
            OutputStream out, String pattern)  
    {  
        exportExcel("测试POI导出EXCEL文档", headers, dataset, out, pattern);  
    }  
  
    /** 
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上 
     *  
     * @param title 
     *            表格标题名 
     * @param headers 
     *            表格属性列名数组 
     * @param dataset 
     *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的 
     *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据) 
     * @param out 
     *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中 
     * @param pattern 
     *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd" 
     */  
    @SuppressWarnings("unchecked")  
    public static void exportExcel(String title, String[] headers,  
            Collection<T> dataset, OutputStream out, String pattern)  
    {  
        // 声明一个工作薄  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        // 生成一个表格  
        HSSFSheet sheet = workbook.createSheet(title);  
        // 设置表格默认列宽度为15个字节  
        sheet.setDefaultColumnWidth((short) 15);  
        // 生成一个样式  
        HSSFCellStyle style = workbook.createCellStyle();  
        // 设置这些样式  
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        // 生成一个字体  
        HSSFFont font = workbook.createFont();  
        font.setColor(HSSFColor.VIOLET.index);  
        font.setFontHeightInPoints((short) 12);  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        // 把字体应用到当前的样式  
        style.setFont(font);  
        // 生成并设置另一个样式  
        HSSFCellStyle style2 = workbook.createCellStyle();  
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);  
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
        // 生成另一个字体  
        HSSFFont font2 = workbook.createFont();  
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
        // 把字体应用到当前的样式  
        style2.setFont(font2);
        
        HSSFFont font3 = workbook.createFont();  
        font3.setColor(HSSFColor.BLUE.index); 
  
        // 声明一个画图的顶级管理器  
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();  
        // 定义注释的大小和位置,详见文档  
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,  
                0, 0, 0, (short) 4, 2, (short) 6, 5));  
        // 设置注释内容  
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));  
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.  
        comment.setAuthor("leno");  
  
        // 产生表格标题行  
        HSSFRow row = sheet.createRow(0);  
        for (short i = 0; i < headers.length; i++)  
        {  
            HSSFCell cell = row.createCell(i);  
            cell.setCellStyle(style);  
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);  
            cell.setCellValue(text);  
        }  
  
        // 遍历集合数据，产生数据行  
        Iterator<T> it = dataset.iterator();  
        int index = 0;  
        while (it.hasNext())  
        {  
            index++;  
            row = sheet.createRow(index);  
            T t = (T) it.next();  
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值  
            Field[] fields = t.getClass().getDeclaredFields();  
            for (short i = 0; i < fields.length; i++)  
            {  
                HSSFCell cell = row.createCell(i);  
                cell.setCellStyle(style2);  
                Field field = fields[i];  
                String fieldName = field.getName();  
                String getMethodName = "get"  
                        + fieldName.substring(0, 1).toUpperCase()  
                        + fieldName.substring(1);  
                try  
                {  
                    Class tCls = t.getClass();  
                    Method getMethod = tCls.getMethod(getMethodName,  
                            new Class[]  
                            {});  
                    Object value = getMethod.invoke(t, new Object[]  
                    {});  
                    // 判断值的类型后进行强制类型转换  
                    String textValue = null;  
                    // if (value instanceof Integer) {  
                    // int intValue = (Integer) value;  
                    // cell.setCellValue(intValue);  
                    // } else if (value instanceof Float) {  
                    // float fValue = (Float) value;  
                    // textValue = new HSSFRichTextString(  
                    // String.valueOf(fValue));  
                    // cell.setCellValue(textValue);  
                    // } else if (value instanceof Double) {  
                    // double dValue = (Double) value;  
                    // textValue = new HSSFRichTextString(  
                    // String.valueOf(dValue));  
                    // cell.setCellValue(textValue);  
                    // } else if (value instanceof Long) {  
                    // long longValue = (Long) value;  
                    // cell.setCellValue(longValue);  
                    // }  
                    if (value instanceof Boolean)  
                    {  
                        boolean bValue = (Boolean) value;  
                        textValue = "男";  
                        if (!bValue)  
                        {  
                            textValue = "女";  
                        }  
                    }  
                    else if (value instanceof Date)  
                    {  
                        Date date = (Date) value;  
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
                        textValue = sdf.format(date);  
                    }  
                    else if (value instanceof byte[])  
                    {  
                        // 有图片时，设置行高为60px;  
                        row.setHeightInPoints(60);  
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算  
                        sheet.setColumnWidth(i, (short) (35.7 * 80));  
                        // sheet.autoSizeColumn(i);  
                        byte[] bsValue = (byte[]) value;  
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,  
                                1023, 255, (short) 6, index, (short) 6, index);  
                        anchor.setAnchorType(2);  
                        patriarch.createPicture(anchor, workbook.addPicture(  
                                bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));  
                    }  
                    else  
                    {  
                        // 其它数据类型都当作字符串简单处理  
                        textValue = value.toString();  
                    }  
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成  
                    if (textValue != null)  
                    {  
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");  
                        Matcher matcher = p.matcher(textValue);  
                        if (matcher.matches())  
                        {  
                            // 是数字当作double处理  
                            cell.setCellValue(Double.parseDouble(textValue));  
                        }  
                        else  
                        {  
                            HSSFRichTextString richString = new HSSFRichTextString(  
                                    textValue);  
                            
                            richString.applyFont(font3);  
                            cell.setCellValue(richString);  
                        }  
                    }  
                }  
                catch (SecurityException e)  
                {  
                    e.printStackTrace();  
                }  
                catch (NoSuchMethodException e)  
                {  
                    e.printStackTrace();  
                }  
                catch (IllegalArgumentException e)  
                {  
                    e.printStackTrace();  
                }  
                catch (IllegalAccessException e)  
                {  
                    e.printStackTrace();  
                }  
                catch (InvocationTargetException e)  
                {  
                    e.printStackTrace();  
                }  
                finally  
                {  
                    // 清理资源  
                }  
            }  
        }  
        try  
        {  
            workbook.write(out);  
        }  
        catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
    } 
    @SuppressWarnings("unchecked")  
    public static void exportExcel1(String title,
            OutputStream outt, String pattern,List<HashMap> list,LinkedHashMap hearder) {  
        // 声明一个工作薄  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        // 生成一个表格  
        HSSFSheet sheet = workbook.createSheet(title);  
        // 设置表格默认列宽度为15个字节  
        sheet.setDefaultColumnWidth((short) 15);  
        // 生成一个样式  
        HSSFCellStyle style = workbook.createCellStyle();  
        // 设置这些样式  
        style.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);  
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        // 生成一个字体  
        HSSFFont font = workbook.createFont();  
        //font.setColor(HSSFColor.VIOLET.index);  
        font.setFontHeightInPoints((short) 12);  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        // 把字体应用到当前的样式  
        style.setFont(font);  
        // 生成并设置另一个样式  
        HSSFCellStyle style2 = workbook.createCellStyle();    
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 
        style2.setFillForegroundColor(HSSFColor.WHITE.index);  
        // 生成另一个字体  
        HSSFFont font2 = workbook.createFont();  
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
        font2.setColor(HSSFColor.BLACK.index);

        // 把字体应用到当前的样式  
        style2.setFont(font2);  
  
        // 声明一个画图的顶级管理器  
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();  
        // 定义注释的大小和位置,详见文档  
        HSSFComment comment = patriarch.createCellComment(new HSSFClientAnchor(0,  
                0, 0, 0, (short) 4, 2, (short) 6, 5));  
        // 设置注释内容  
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));  
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.  
        comment.setAuthor("leno");  
  
        // 产生表格标题行  
        HSSFRow row = sheet.createRow(0);  
        Iterator keys = hearder.entrySet().iterator();
        String[] columns = new String[hearder.size()];
        int j=0;
        while (keys.hasNext()) {
        HSSFCell cell = row.createCell(j);  
        cell.setCellStyle(style);  
        Map.Entry column =  (Map.Entry)keys.next();
        columns[j]=column.getKey().toString();
        HSSFRichTextString text = new HSSFRichTextString(column.getValue().toString());  
        cell.setCellValue(text);  
        j++;
        }
        
        for(int m=0;m<list.size();m++){
        	row = sheet.createRow(m+1);  
        	for (short i = 0; i < hearder.size(); i++)  
            {  
                HSSFCell cell = row.createCell((short)i);  
                cell.setCellStyle(style2);  
                Object value = list.get(m).get(columns[i]);
                if(value==null){
                	continue;	
                }
                else if (value instanceof Long)  
                {  
                	Date mydate = new Date();
                	mydate.setTime(Long.parseLong(value.toString()));
                	SimpleDateFormat sdf =   new SimpleDateFormat(pattern);
                    value = sdf.format(mydate).toString();  
                    
                }  
                	HSSFRichTextString richString = new HSSFRichTextString(value.toString()); 
                	/*HSSFFont font3 = workbook.createFont();  
                    font3.setColor(HSSFColor.BLACK.index);    
                    richString.applyFont(font3);  */
                    cell.setCellValue(richString);  
            }
        	/*if(m>0){
        		if(list.get(m).get("Name").equals(list.get(m-1).get("Name"))){
        			sheet.addMergedRegion(new Region(m, (short)1, m+1, (short)1));
        		}
        	}*/
        }
        try  
        {  
            workbook.write(outt);  
        }  
        catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
    }  
    @SuppressWarnings("unchecked")  
    public static void exportExcel11(String[] data,String pattern,String tablename,OutputStream outt,int numberx1,int numberx2) {  
    	ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        // 声明一个工作薄  
        HSSFWorkbook workbook = new HSSFWorkbook();  
        // 生成一个表格  
        HSSFSheet sheet = workbook.createSheet(tablename);  
        // 设置表格默认列宽度为15个字节  
        sheet.setDefaultColumnWidth((short) 15);  
        // 生成一个样式  
        HSSFCellStyle style = workbook.createCellStyle();  
        // 设置这些样式  
        style.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);  
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        HSSFCellStyle style1 = workbook.createCellStyle();  
        // 设置这些样式  
        style1.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);  
        style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style1.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style1.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style1.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
        style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成一个字体  
        HSSFFont font = workbook.createFont();  
        //font.setColor(HSSFColor.VIOLET.index);  
        font.setFontHeightInPoints((short) 12);  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        // 把字体应用到当前的样式  
        style.setFont(font);  
        // 生成并设置另一个样式  
        HSSFCellStyle style2 = workbook.createCellStyle();    
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style2.setFillForegroundColor(HSSFColor.WHITE.index);  
        // 生成另一个字体  
        HSSFFont font2 = workbook.createFont();  
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
        font2.setColor(HSSFColor.BLACK.index);

        // 把字体应用到当前的样式  
        style2.setFont(font2); 
        style1.setFont(font2);
        
        HSSFFont font3 = workbook.createFont();  
        font3.setColor(HSSFColor.BLACK.index);    
  
        // 声明一个画图的顶级管理器  
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档  
        HSSFComment comment = patriarch.createCellComment(new HSSFClientAnchor(0,  
                0, 0, 0, (short) 4, 2, (short) 6, 5));  
        // 设置注释内容  
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));  
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.  
        comment.setAuthor("leno");  
  
        // 产生表格标题行  
        HSSFRow row = sheet.createRow(0);  
        //Iterator keys = hearder.entrySet().iterator();
        String header = data[0].substring(1,data[0].length()-1);
        String[] columns = header.split(";");
        int j=0;
        ArrayList<String> list0=new ArrayList<String>();
        for(int i=0;i < columns.length;i++){
        	 HSSFCell cell = row.createCell(j);  
             cell.setCellStyle(style);  
             HSSFRichTextString text = new HSSFRichTextString(columns[i]);  
             cell.setCellValue(text);  
             j++;
             list0.add(columns[i]);
        }
        lists.add(list0);
        for(int m=1;m<data.length;m++){
        	row = sheet.createRow(m);
        	String datarow = data[m].substring(1,data[m].length()-1);
        	String[] rowdatas = datarow.split(";",-1);
        	list0=new ArrayList<String>();
        	Boolean back=false;
        	for (short i = 0; i < rowdatas.length; i++)  
            {  
                HSSFCell cell = row.createCell((short)i);
                
                String values = rowdatas[i];
                
                Object value = values;
                if(value==null){
                	value="";	
                }
                else if (value instanceof Long)  
                {  
                	Date mydate = new Date();
                	mydate.setTime(Long.parseLong(value.toString()));
                	SimpleDateFormat sdf =   new SimpleDateFormat(pattern);
                    value = sdf.format(mydate).toString();  
                    
                }  
                	HSSFRichTextString richString = new HSSFRichTextString(value.toString()); 
                	
                    richString.applyFont(font3); 
                    cell.setCellValue(richString);  
                    if(value.toString().indexOf("计")!=-1||value.toString().indexOf("总")!=-1){
                    	back=true;
                    }
                    if(back){
                    	cell.setCellStyle(style1);
                    }
                    else{
                    	cell.setCellStyle(style2);
                    }
                    list0.add(value.toString());
            }
        	
        	lists.add(list0);
        }
        String lastValue="";
        Pattern patter = Pattern.compile("^[-\\+]?[\\d]*$");
        for(int i=1;i<lists.size();i++){
			for(int x=numberx1;x>-1;x--){
				String value = lists.get(i).get(x);
				if(lists.get(i).get(x+1).equals(value)&&("".equals(value)||value==null)){
					sheet.addMergedRegion(new CellRangeAddress(i,  i,(short)x, (short)(x+1)));
				}else{
					if(value.indexOf("计")!=-1||value.indexOf("总")!=-1){
						sheet.addMergedRegion(new CellRangeAddress(i,  i,(short)x, (short)(x+1)));
						//sheet.getRow(i).setRowStyle(style1);
					}
				}
			}
			
		}
        for(int y=0;y<numberx2;y++){
			for(int i=2;i<lists.size();i++){
				if(lists.get(i).get(y).equals(lists.get(i-1).get(y))&&lists.get(i).get(y)!=""&&!patter.matcher(lists.get(i).get(y)).matches()){
					sheet.addMergedRegion(new CellRangeAddress(i-1,i, (short)y,  (short)y));
				}else{
					continue;
				}
			} 
		}
        
        try  
        {  
            workbook.write(outt);  
        }  
        catch (IOException e)  
        {  
            e.printStackTrace();  
        }
    }  
}
