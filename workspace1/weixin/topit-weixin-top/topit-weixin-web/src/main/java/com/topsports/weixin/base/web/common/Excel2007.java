package com.topsports.weixin.base.web.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.topsports.weixin.base.common.utils.BeanUtilsCommon;

public class Excel2007 {
	public static final int columnWidth = 13;

	public static ArrayList<ArrayList<String>> readFromExcel2007(String filePath) {
		File excelFile = null;// Excel文件对象  
		InputStream is = null;// 输入流对象  
		String cellStr = null;// 单元格，最终按字符串处理
		ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();//返回的数据
		try {
			excelFile = new File(filePath);
			is = new FileInputStream(excelFile);// 获取文件输入流  
			XSSFWorkbook workbook2007 = new XSSFWorkbook(is);// 创建Excel2007文件对象 
			XSSFSheet sheet = workbook2007.getSheetAt(0);// 取出第一个工作表，索引是0  

			// 开始循环遍历行，表头不处理，从1开始  
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				ArrayList<String> list = new ArrayList<String>();
				XSSFRow row = sheet.getRow(i);// 获取行对象  
				if (row == null) {// 如果为空，不处理  
					continue;
				}
				// 循环遍历单元格  
				for (int j = 0; j < row.getLastCellNum(); j++) {
					XSSFCell cell = row.getCell(j);// 获取单元格对象  
					if (cell == null) {// 单元格为空设置cellStr为空串  
						cellStr = "";
					} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {// 对布尔值的处理  
						cellStr = String.valueOf(cell.getBooleanCellValue());
					} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {// 对数字值的处理  
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

	/**
	 * @Title: exportToExcel2007
	 */
	@SafeVarargs
	public static XSSFWorkbook exportToExcel2007(List<String> sheets, List<ArrayList<Object>> titles,
			List<ArrayList<Object>>... lists) {

		XSSFWorkbook wb = new XSSFWorkbook();
		if (sheets != null && sheets.size() > 0) {
			for (int i = 0; i < sheets.size(); i++) {
				XSSFSheet sheet = wb.createSheet(sheets.get(i));
				sheet.setDefaultColumnWidth(columnWidth);
				writeRowObject2007(titles.get(i), sheet.createRow((int) 0));
				if (lists[i] != null) {
					writeRowsObject2007(false, lists[i], sheet);
				}

			}

		}

		return wb;
	}

	/**
	 * @Title: exportToExcel2007
	 */
	public static XSSFWorkbook exportToExcel2007(List<String> sheets, List<ArrayList<Object>> titles,
			List<ArrayList<Object>> lists, List<String> MergedRegion) {

		XSSFWorkbook wb = new XSSFWorkbook();
		if (sheets != null && sheets.size() > 0) {
			for (int i = 0; i < sheets.size(); i++) {
				XSSFSheet sheet = wb.createSheet(sheets.get(i));
				sheet.setDefaultColumnWidth(columnWidth);
				writeRowObject2007(titles.get(i), sheet.createRow((int) 0));
				if (lists != null) {
					writeRowsObject2007(false, lists, sheet);
				}

				if (MergedRegion != null && MergedRegion.size() > 0) {
					for (int intMergedRegion = 0; intMergedRegion < MergedRegion.size(); intMergedRegion++) {
						String[] strRegion = MergedRegion.get(intMergedRegion).split(",", -1);
						sheet.addMergedRegion(new CellRangeAddress(BeanUtilsCommon.parseInteger(strRegion[0]),
								BeanUtilsCommon.parseInteger(strRegion[1]), BeanUtilsCommon.parseInteger(strRegion[2]),
								BeanUtilsCommon.parseInteger(strRegion[3])));
					}
				}
			}

		}

		return wb;
	}

	public static XSSFWorkbook exportToExcel2007(boolean hasImg, List<String> sheets, List<ArrayList<Object>> titles,
			List<ArrayList<Object>>... lists) {

		XSSFWorkbook wb = new XSSFWorkbook();

		if (sheets != null && sheets.size() > 0) {
			for (int i = 0; i < sheets.size(); i++) {
				XSSFSheet sheet = wb.createSheet(sheets.get(i));
				sheet.setDefaultColumnWidth(columnWidth);
				writeRowObject2007(titles.get(i), sheet.createRow((int) 0));
				writeRowsObject2007(hasImg, lists[i], sheet);
			}

		}

		return wb;
	}

	private static void writeRowObject2007(List<Object> data, XSSFRow row) {

		if (data == null || data.size() == 0) {
			return;
		}
		Iterator<Object> it = data.iterator();
		int i = 0;
		while (it.hasNext()) {
			XSSFCell cell = row.createCell(i);
			Object object = it.next();
			if (object == null || "".equals(object)) {
				cell.setCellValue("");
			} else {
				if (object instanceof Integer) {
					cell.setCellValue(Integer.parseInt(object.toString()));
				} else {
					cell.setCellValue(object.toString());
				}
			}
			i++;
		}
	}

	private static void writeRowsObject2007(boolean hasImg, List<ArrayList<Object>> list, XSSFSheet sheet) {
		writeRowsObject2007(hasImg, list, sheet, 1);
	}

	private static void writeRowsObject2007(boolean hasImg, List<ArrayList<Object>> data, XSSFSheet sheet, int offset) {

		if (data == null || data.isEmpty()) {
			return;
		}
		for (int i = 0; i < data.size(); i++) {
			XSSFRow row = sheet.createRow(offset + i);
			if (hasImg) {
				row.setHeight((short) 1500);
			}
			writeRowObject2007(data.get(i), row);
		}

	}

	public static XSSFWorkbook exportToExcel3Title2007(List<String> sheets, List<List<ArrayList<Object>>> titles,
			List<ArrayList<Object>>... lists) {

		XSSFWorkbook wb = new XSSFWorkbook();

		if (sheets != null && sheets.size() > 0) {
			for (int i = 0; i < sheets.size(); i++) {
				XSSFSheet sheet = wb.createSheet(sheets.get(i));
				sheet.setDefaultColumnWidth(columnWidth);
				writeRowObject2007(titles.get(0).get(i), sheet.createRow((int) 0));
				writeRowObject2007(titles.get(1).get(i), sheet.createRow((int) 0));
				writeRowObject2007(titles.get(2).get(i), sheet.createRow((int) 0));
				writeRowsObject2007(false, lists[i], sheet);
			}

		}

		return wb;
	}

	public static XSSFWorkbook exportToExcel3Title2007(boolean hasImg, List<String> sheets,
			List<ArrayList<ArrayList<Object>>> titles, List<ArrayList<Object>>... lists) {

		XSSFWorkbook wb = new XSSFWorkbook();

		if (sheets != null && sheets.size() > 0) {
			for (int i = 0; i < sheets.size(); i++) {
				XSSFSheet sheet = wb.createSheet(sheets.get(i));
				sheet.setDefaultColumnWidth(columnWidth);
				writeRowObject2007(titles.get(0).get(i), sheet.createRow((int) 0));
				writeRowObject2007(titles.get(1).get(i), sheet.createRow((int) 0));
				writeRowObject2007(titles.get(2).get(i), sheet.createRow((int) 0));
				writeRowsObject2007(hasImg, lists[i], sheet);
			}

		}

		return wb;
	}

	// -----------------------------------------------------------------------------
	@SafeVarargs
	public static XSSFWorkbook exportToExcel2007RowHasImg(List<String> sheets, List<ArrayList<Object>> titles,
			List<ArrayList<Object>>... lists) throws Exception {

		XSSFWorkbook wb = new XSSFWorkbook();
		if (sheets != null && sheets.size() > 0) {
			for (int i = 0; i < sheets.size(); i++) {
				XSSFSheet sheet = wb.createSheet(sheets.get(i));
				sheet.setDefaultColumnWidth(columnWidth);
				writeRowObject2007(titles.get(i), sheet.createRow((int) 0));
				if (lists[i] != null) {
					writeRowsObject2007HasImg(wb, sheet, lists[i], 1);
				}
			}

		}

		return wb;
	}

	private static void writeRowsObject2007HasImg(XSSFWorkbook wb, XSSFSheet sheet, List<ArrayList<Object>> data,
			int offset) throws Exception {

		if (data == null || data.isEmpty()) {
			return;
		}
		for (int i = 0; i < data.size(); i++) {
			XSSFRow row = sheet.createRow(offset + i);
			row.setHeight((short) 1500);
			writeRowObject2007HasImg(wb, sheet, data.get(i), row, i);
		}

	}

	@SuppressWarnings("static-access")
	private static void writeRowObject2007HasImg(XSSFWorkbook wb, XSSFSheet sheet, List<Object> data, XSSFRow row,
			int rowIndex) throws Exception {
		if (data == null || data.size() == 0) {
			return;
		}
		Iterator<Object> it = data.iterator();
		int i = 0;
		while (it.hasNext()) {
			XSSFCell cell = row.createCell(i);
			Object object = it.next();
			if (object == null || "".equals(object)) {
				cell.setCellValue("");
			} else if (
			//object.toString().length() > "img_Path:".length() && 
			object.toString().startsWith("img_Path:")) {
				cell.setCellValue(" ");
				try {

					String filePath = object.toString().replaceFirst("img_Path:", "");
					File file = new File(filePath);
					if (file.exists()) {
						InputStream is = new FileInputStream(filePath);
						byte[] bytes = IOUtils.toByteArray(is);
						int pictureIdx = wb.addPicture(bytes, wb.PICTURE_TYPE_PNG);

						CreationHelper helper = wb.getCreationHelper();
						Drawing drawing = sheet.createDrawingPatriarch();
						ClientAnchor anchor = helper.createClientAnchor();
						// 图片插入坐标  
						anchor.setCol1(i);
						anchor.setRow1(rowIndex + 1);
						// 插入图片  
						Picture pict = drawing.createPicture(anchor, pictureIdx);
						pict.resize(1, 1);
						is.close();
					}
				} catch (Exception e) {
				}
			} else {
				cell.setCellValue(object.toString());
			}
			i++;
		}
	}

	// ----------------------------------------------------------------------------------------------------------------

	public static ArrayList<ArrayList<String>> readFromExcel2003(String filePath) {
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

	/**
	 * @Title: exportToExcel2003
	 */
	public static HSSFWorkbook exportToExcel2003(List<String> sheets, List<ArrayList<Object>> titles,
			List<ArrayList<Object>>... lists) {

		HSSFWorkbook wb = new HSSFWorkbook();

		if (sheets != null && sheets.size() > 0) {
			for (int i = 0; i < sheets.size(); i++) {
				HSSFSheet sheet = wb.createSheet(sheets.get(i));
				sheet.setDefaultColumnWidth(columnWidth);
				writeRowObject2003(titles.get(i), sheet.createRow((int) 0));
				writeRowsObject2003(false, lists[i], sheet);
			}

		}

		return wb;
	}

	public static HSSFWorkbook exportToExcel2003(boolean hasImg, List<String> sheets, List<ArrayList<Object>> titles,
			List<ArrayList<Object>>... lists) {

		HSSFWorkbook wb = new HSSFWorkbook();

		if (sheets != null && sheets.size() > 0) {
			for (int i = 0; i < sheets.size(); i++) {
				HSSFSheet sheet = wb.createSheet(sheets.get(i));
				sheet.setDefaultColumnWidth(columnWidth);
				writeRowObject2003(titles.get(i), sheet.createRow((int) 0));
				writeRowsObject2003(hasImg, lists[i], sheet);
			}

		}

		return wb;
	}

	private static void writeRowObject2003(List<Object> data, HSSFRow row) {

		if (data == null || data.size() == 0) {
			return;
		}
		Iterator<Object> it = data.iterator();
		int i = 0;
		while (it.hasNext()) {
			HSSFCell cell = row.createCell(i);
			Object object = it.next();
			if (object == null || "".equals(object)) {
				cell.setCellValue("");
			} else {
				cell.setCellValue(object.toString());
			}
			i++;
		}

	}

	private static void writeRowsObject2003(boolean hasImg, List<ArrayList<Object>> list, HSSFSheet sheet) {
		writeRowsObject2003(hasImg, list, sheet, 1);
	}

	private static void writeRowsObject2003(boolean hasImg, List<ArrayList<Object>> data, HSSFSheet sheet, int offset) {

		if (data == null || data.isEmpty()) {
			return;
		}
		for (int i = 0; i < data.size(); i++) {
			HSSFRow row = sheet.createRow(offset + i);
			if (hasImg)
				row.setHeight((short) 1500);
			writeRowObject2003(data.get(i), row);
		}

	}

	//	public static int getAnchorX(int px, int colWidth) {
	//		return (int) Math.round(((double) 701 * 16000.0 / 301) * ((double) 1 / colWidth) * px);
	//	}
	//
	//	public static int getAnchorY(int px, int rowHeight) {
	//		return (int) Math.round(((double) 144 * 8000 / 301) * ((double) 1 / rowHeight) * px);
	//	}
	//
	//	public static int getRowHeight(int px) {
	//		return (int) Math.round(((double) 4480 / 300) * px);
	//	}
	//
	//	public static int getColWidth(int px) {
	//		return (int) Math.round(((double) 10971 / 300) * px);
	//	}
	//
	//	public void test() {
	//
	//	}

}