package com.yujiu.controller;

import gnu.io.SerialPort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TooManyListenersException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yujiu.base.common.exception.ServiceException;
import com.yujiu.common.serialportutils.SerialListener;
import com.yujiu.common.serialportutils.SerialReader;
import com.yujiu.common.serialportutils.SerialReaderTool;
import com.yujiu.common.serialportutils.SerialTool;
import com.yujiu.common.serialportutils.serialException.NoSuchPort;
import com.yujiu.common.serialportutils.serialException.NotASerialPort;
import com.yujiu.common.serialportutils.serialException.PortInUse;
import com.yujiu.common.serialportutils.serialException.SerialPortParameterFailure;
import com.yujiu.model.Devices;
import com.yujiu.service.DevicesService;

@Controller
@RequestMapping(value = "/base")
public class BaseController {

	private SerialTool serialTool;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private DevicesService sevicesService;

	/*private List<SerialPort> portlist = new ArrayList<SerialPort>();*/

	private List<SerialReaderTool> readerlist = new ArrayList<SerialReaderTool>();

	/*
	 * @RequestMapping(value="/openmonitor")
	 * 
	 * @ResponseBody public String openmonitor(){
	 * response.setHeader("Access-Control-Allow-Origin", "*"); try {
	 * List<Devices> list = sevicesService.findByBiz(new Devices(), null);
	 * for(int i=0;i<list.size();i++){ try { SerialPort port =
	 * serialTool.openPort(list.get(i).getSerialPort(),
	 * Integer.parseInt(list.get(i).getSerialParam())); portlist.add(port); try
	 * { port.addEventListener(new SerialListener(port)); } catch
	 * (TooManyListenersException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } catch (NumberFormatException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (SerialPortParameterFailure e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (NotASerialPort e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } catch (NoSuchPort e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (PortInUse e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } } } catch
	 * (ServiceException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return ""; }
	 * 
	 * @RequestMapping(value="/offmonitor")
	 * 
	 * @ResponseBody public String offmonitor(){
	 * response.setHeader("Access-Control-Allow-Origin", "*"); for(int
	 * i=0;i<portlist.size();i++){ serialTool.closePort(portlist.get(i)); }
	 * return ""; }
	 */
	@RequestMapping(value = "/openmonitor")
	@ResponseBody
	public String openmonitor() {
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			List<Devices> list = sevicesService.findByBiz(new Devices(), null);
			for (int i = 0; i < list.size(); i++) {
				SerialReaderTool reader = new SerialReaderTool();
				readerlist.add(reader);
				HashMap<String, Comparable> params = new HashMap<String, Comparable>();
				String port = list.get(i).getSerialPort();
				String rate = list.get(i).getSerialParam();
				String dataBit = "" + SerialPort.DATABITS_8;
				String stopBit = "" + SerialPort.STOPBITS_1;
				String parity = "" + SerialPort.PARITY_NONE;
				int parityInt = SerialPort.PARITY_NONE;
				params.put(SerialReader.PARAMS_PORT, port); // 端口名称
				params.put(SerialReader.PARAMS_RATE, rate); // 波特率
				params.put(SerialReader.PARAMS_DATABITS, dataBit); // 数据位
				params.put(SerialReader.PARAMS_STOPBITS, stopBit); // 停止位
				params.put(SerialReader.PARAMS_PARITY, parityInt); // 无奇偶校验
				params.put(SerialReader.PARAMS_TIMEOUT, 100); // 设备超时时间 1秒
				params.put(SerialReader.PARAMS_DELAY, 100); // 端口数据准备时间 1秒
				try {
					reader.openSerialPort(params);
					// if(message!=null&&message.length()!=0)
					// {
					// reader.start();
					// reader.run(message);
					// }
				} catch (Exception e) {
					
				}
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@RequestMapping(value = "/offmonitor")
	@ResponseBody
	public String offmonitor() {
		response.setHeader("Access-Control-Allow-Origin", "*");
		for (int i = 0; i < readerlist.size(); i++) {
			readerlist.get(i).close();
		}
		return "";
	}

}
