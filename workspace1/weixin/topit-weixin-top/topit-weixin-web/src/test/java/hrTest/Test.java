//package hrTest;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.RenderingHints;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.apache.poi.hslf.*;
//import org.apache.poi.hslf.model.Line;
//import org.apache.poi.hslf.model.Picture;
//import org.apache.poi.hslf.model.Slide;
//import org.apache.poi.hslf.model.Table;
//import org.apache.poi.hslf.model.TableCell;
//import org.apache.poi.hslf.model.TextBox;
//import org.apache.poi.hslf.model.TextRun;
//import org.apache.poi.hslf.usermodel.RichTextRun;
//import org.apache.poi.hslf.usermodel.SlideShow;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.CategoryAxis;
//import org.jfree.chart.axis.ValueAxis;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.title.LegendTitle;
//import org.jfree.chart.title.TextTitle;
//import org.jfree.data.category.DefaultCategoryDataset;
//
//public class Test {
//	@org.junit.Test
//	public void test() throws FileNotFoundException, IOException{
//		File file = new File("F://1.ppt");
//		if(file.exists()){
//			//System.out.print("1111111");
//		}
//		//SlideShow ppt = new SlideShow();
////		Slide[] slides = ppt.getSlides();
////		 FileOutputStream out = new FileOutputStream("F://1.ppt");
////		ppt.write(out);
////		out.close();
//		SlideShow ppt = new SlideShow(new HSLFSlideShow(new FileInputStream(file)));
//		Slide[] slides = ppt.getSlides();//提取文本信息   
//		for (Slide each : slides) {
//			    TextRun[] textRuns = each.getTextRuns();each.getShapes()[0].getShapeType();
//			    for (int i=0 ;i< textRuns.length; i++ ) {
//			        RichTextRun[] richTextRuns = textRuns[i].getRichTextRuns();
//			        for (int j = 0; j < richTextRuns.length; j++) {
//			        	if(richTextRuns[j].getText().indexOf("${0}")!=-1){
//			        		richTextRuns[j].setText(richTextRuns[j].getText().replace("${0}", "2015-10-10"));
//				    	}
//				    	else if(richTextRuns[j].getText().indexOf("${1}")!=-1){
//				    		richTextRuns[j].setText(richTextRuns[j].getText().replace("${1}", "上海AD店"));
//				    	}
//			        }
//			    	
//			    }
//			    
//		}//提取所有JPEG图片
////		if(slides[1].getShapes()[1] instanceof Table){
////	    	Table table = (Table)(slides[1].getShapes()[1]);
////	    	for(int i=1;i<table.getNumberOfColumns();i++){
////	    		for(int j=1;j<table.getNumberOfRows();j++){
////	    			TableCell cell = table.getCell(j, i);
////	    			String sm = cell.getText();
////	    			String ss = cell.getTextRun().getRichTextRuns()[0].getText();
////	    			cell.setText(i+"-"+j);
////	    			String s = cell.getText();
////	    			String sss = cell.getTextRun().getRichTextRuns()[0].getText();
////	    			s = cell.getText();
////	    		}
////	    	}
////	    	slides[0].addShape(table);
////	    }
//		//String sm = cell.getText();
//		Table table = new Table(3, 3);
//		for(int i=0;i<3;i++){
//			for(int j=0;j<3;j++){
//				TableCell cell = table.getCell(i, j);
//				RichTextRun rt = cell.getTextRun().getRichTextRuns()[0];
//		        rt.setFontName("宋体");
//		        rt.setFontSize(12); 
//		        cell.setVerticalAlignment(TextBox.AnchorMiddle);
//		        cell.setHorizontalAlignment(TextBox.AlignCenter);
//		        cell.setText("0");
//		        cell.setFillColor(Color.white);
//		        rt.setFontColor(Color.black);
//			}
//		}
//		Line border = table.createBorder();
//		border.setLineColor(Color.black);
//		border.setLineWidth(2.0);
//		table.setAllBorders(border);
//		slides[1].addShape(table);
//		List<String> list = new ArrayList<String>(4);list.add("20");list.add("40");list.add("60");list.add("80");
//		//Map<String, Map<String, Object>> maps = new HashMap<String, Map<String,Object>>();
//		//Map<String,Object> map = new HashMap<String, Object>();
//		//map.put("", value)
//		final String series1="First";
//		final String series2="Second";
//
//        // column keys...
//        final String category1="一";
//        final String category2="二";
//        final String category3="三";
//        final String category4="四";
//        final String category5="五";
//        final String category6="六";
//
//        // create the dataset...
//        final DefaultCategoryDataset dataset=new DefaultCategoryDataset();
//
//        dataset.addValue(100, series1, category1);
//        dataset.addValue(100, series1, category2);
//        dataset.addValue(100, series1, category3);
//        dataset.addValue(100, series1, category4);
//        dataset.addValue(100, series1, category5);
//        dataset.addValue(100, series1, category6);
//        
//       // dataset.addValue(50, series2, category1);
//       // dataset.addValue(70, series2, category2);
//       // dataset.addValue(90, series2, category3);
//        //dataset.addValue(5.0, series1, category4);
//        //dataset.addValue(5.0, series1, category5);
//		
//        CalibrationSpiderWebPlot plot = new CalibrationSpiderWebPlot(dataset);  
//        plot.setDrawRing(true);plot.setForegroundAlpha(1);
//	    JFreeChart chart = new JFreeChart("", plot);
//	    chart.setBackgroundPaint(java.awt.Color.black); 
//	    chart.getLegend().setVisible(false);
//	    chart.setBorderVisible(false);  
//	    chart.setBackgroundPaint(null);  
//	    chart.setBackgroundImageAlpha(0.0f);  
//	    chart.getRenderingHints().put (RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
//	    //chart.set
//	    ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        ChartUtilities.writeChartAsJPEG(byteArrayOutputStream, chart, 500, 300);
//        
//        int picIndex = ppt.addPicture(byteArrayOutputStream.toByteArray(), Picture.JPEG);
//		Picture jpg = new Picture(picIndex); //set image position in the slide
//		jpg.setAnchor(new java.awt.Rectangle(100, 50, 350, 200)); 
//		slides[0].addShape(jpg);
//	    
//		int picIndex0 = ppt.addPicture(genBarJPG().toByteArray(), Picture.JPEG);
//				Picture jpg0 = new Picture(picIndex0); //set image position in the slide
//				jpg0.setAnchor(new java.awt.Rectangle(100, 50, 350, 200)); 
//				slides[1].addShape(jpg0);
//		
//		//table.moveTo(160, 100); 
//		FileOutputStream output=new FileOutputStream("F:\\test2.ppt");
//		ppt.write(output);
//		output.close();
////		PictureData[] picDatas = ppt.getPictureData();
////		for (int i=0;i<picDatas.length;i++) {
////			    if(picDatas[i].getType() == Picture.JPEG){
////			        FileOutputStream out = new FileOutputStream("F://jpg_" + i + ".jpg");
////			        ppt.write(out);
////			        out.close();
////			    }}
////			XMLSlideShow  ppt = new XMLSlideShow (new FileInputStream(file));
////			// for (XSLFSlide slide : ppt.getSlides()) {
////				System.out.print(ppt.getSlides()[0].createTextBox().getText());
////			 //}
//	}
//	private  ByteArrayOutputStream  genBarJPG() throws IOException {
//        // row keys...
//        final String series1="First";
//
//        // column keys...
//        final String category1="Category 1";
//        final String category2="Category 2";
//        final String category3="Category 3";
//        final String category4="Category 4";
//        final String category5="Category 5";
//
//        // create the dataset...
//        final DefaultCategoryDataset dataset=new DefaultCategoryDataset();
//
//        dataset.addValue(1.0, series1, category1);
//        dataset.addValue(4.0, series1, category2);
//        dataset.addValue(3.0, series1, category3);
//        dataset.addValue(5.0, series1, category4);
//        dataset.addValue(5.0, series1, category5);
//        
//        final JFreeChart chart=ChartFactory.createBarChart(new String("中文"), // chart title
//            "类别", // domain axis label
//            "四圣兽", // range axis label
//            dataset, // data
//            PlotOrientation.VERTICAL, // orientation
//            false, // include legend
//            false, // tooltips?
//            false // URLs?
//            );
////        TextTitle textTitle = chart.getTitle();  
////        textTitle.setFont(new Font("宋体", Font.BOLD, 20));  
////        LegendTitle legend = chart.getLegend();  
////        if (legend != null) {  
////            legend.setItemFont(new Font("宋体", Font.BOLD, 20));  
////        }  
//       // CategoryPlot xyplot = (CategoryPlot)chart.getPlot(); //获得 plot : XYPlot!!  
//        
//        //ChartUtils.setLegendEmptyBorder(chart);
//        ChartUtils.setAntiAlias(chart);
//        ChartUtils.setChartTheme();
//        ChartUtils.setBarRenderer(chart.getCategoryPlot(),false);
//        ChartUtils.setXAixs(chart.getCategoryPlot());
//        ChartUtils.setYAixs(chart.getCategoryPlot());
//        
//        
////        CategoryAxis domainAxis=xyplot.getDomainAxis();  
////        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,20));//设置x轴坐标上的字体  
////        domainAxis.setLabelFont(new Font("宋体",Font.BOLD,20));//设置x轴坐标上的标题的字体  
////        ValueAxis rangeAxis=xyplot.getRangeAxis();  
////        rangeAxis.setTickLabelFont(new Font("宋体",Font.BOLD,20));//设置y轴坐标上的字体  
////        rangeAxis.setLabelFont(new Font("宋体",Font.BOLD,20));//设置y轴坐标上的标题的字体  
//
//        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        ChartUtilities.writeChartAsJPEG(byteArrayOutputStream, chart, 500, 300);
//        return byteArrayOutputStream;
//
////        FileOutputStream file=new FileOutputStream("d:/a.jpg");
////        file.write(byteArrayOutputStream.toByteArray());
////        file.close();
//}
//    private DefaultCategoryDataset createDataSet2(Map<String, Map<String, Object>> resultMap, List<String> dimNameList) {  
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();//创建默认的种类数据类型就可以了，蜘蛛图的每个维度可以看成一种类型  
//        Set<String> keySet = resultMap.keySet();  
//        for(String key : keySet){  
//     Map<String,Object> infoMap = resultMap.get(key);  
//     String vendorCode = key.split("&")[0];  
//     String vendorName = key.split("&")[1];  
//     for(String dimName : dimNameList){  
//             if(infoMap.get(dimName)==null){  
//         continue;  
//             }  
//            double score = (Double) infoMap.get(dimName);  
//           dataset.addValue(score, vendorName.trim()      +"("+vendorCode.trim()+")", dimName);  
//     }  
//         }  
//         return dataset;  
// }  
//}
