package com.yujiu.base.web.controller;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yujiu.base.common.annotation.InitpowerInterceptors;
import com.yujiu.base.common.enums.CommonOperatorEnum;
import com.yujiu.base.common.exception.ServiceException;
import com.yujiu.base.common.util.BeanUtilsCommon;
import com.yujiu.base.common.util.CustomDateEditorBase;
import com.yujiu.base.common.util.SimplePage;
import com.yujiu.base.service.BaseCurdService;
import com.yujiu.base.web.common.HSSFExport;
import com.yujiu.model.Logs;
import com.yujiu.model.Users;
import com.yujiu.service.LogsService;


public abstract class BaseCurdController<ModelType> {

	protected final static String WITH_MODEL_TYPE="withModelType";
	
	private BaseCurdService service;
	
	@Autowired
	private LogsService logsService;

	private CrudInfo crudInfo;

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	Logger logger = Logger.getLogger(BaseCurdController.class);
	
	@PostConstruct
	protected void initConfig() {		
		this.crudInfo = this.init();
		this.service = crudInfo.getManager();
	}

	protected abstract CrudInfo init();
	
	protected String getUserId(){
		String username=request.getSession().getAttribute("userIDFromUC").toString();
		if(username==null||"".equals(username.trim())){
			username="unknown";
		}
		return username;
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditorBase(
                dateFormat, false));
    }

	@RequestMapping(value = "/list.json")
	@ResponseBody
	public  Map<String, Object> queryList(HttpServletRequest req, Model model) throws ServiceException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		int pageNo = StringUtils.isEmpty(req.getParameter("page")) ? 1 : Integer.parseInt(req.getParameter("page"));
		int pageSize = StringUtils.isEmpty(req.getParameter("rows")) ? 10 : Integer.parseInt(req.getParameter("rows"));
		String sortColumn = StringUtils.isEmpty(req.getParameter("sort")) ? "" : String.valueOf(req.getParameter("sort"));
		String sortOrder = StringUtils.isEmpty(req.getParameter("order")) ? "" : String.valueOf(req.getParameter("order"));
		Map<String, Object> params = builderParams(req, model);
		int total = this.service.findCount(params);
		SimplePage page = new SimplePage(pageNo, pageSize, (int) total);
		List<ModelType> list = this.service.findByPage(page, sortColumn, sortOrder, params);
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("total", total);
		obj.put("rows", list);
		return obj;
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public String add(ModelType modelType,String loginfo,String userid,String username){
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			Logs log = new Logs();
			log.setLogInfo(loginfo);
			log.setInsertTime(new Date());
			log.setInsertUser(Integer.parseInt(userid));
			log.setUsername(username);
			logsService.add(log);
			return service.add(modelType)+"";
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";
	}
	@RequestMapping(value="/update")
	@ResponseBody
	public String update(ModelType modelType,String loginfo,String userid,String username){
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			Logs log = new Logs();
			log.setLogInfo(loginfo);
			log.setInsertTime(new Date());
			log.setInsertUser(Integer.parseInt(userid));
			log.setUsername(username);
			logsService.add(log);
			return service.modifyById(modelType)+"";
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";
	}
	@RequestMapping(value="/remove")
	@ResponseBody
	public String remove(ModelType modelType,String loginfo,String userid,String username){
		response.setHeader("Access-Control-Allow-Origin", "*");
		try {
			Logs log = new Logs();
			log.setLogInfo(loginfo);
			log.setInsertTime(new Date());
			log.setInsertUser(Integer.parseInt(userid));
			log.setUsername(username);
			logsService.add(log);
			return service.deleteById(modelType)+"";
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";
	}
	
	public Map<String, Object> builderParams(HttpServletRequest req,
			Model model) {
		Map<String, Object> retParams = new HashMap<String,Object>(req.getParameterMap().size());
		Map<String, String[]> params = req.getParameterMap();
		if (null != params && params.size() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (Entry<String, String[]> p : params.entrySet()) {
				if (null == p.getValue() || p.getValue().length==0)
					continue;
				// 鍙浆鎹竴涓弬鏁帮紝澶氫釜鍙傛暟涓嶈浆鎹�?
				String values[] = (String[]) p.getValue();
				String match = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
				if (values[0].matches(match)) {
					try {
						retParams.put(p.getKey(), sdf.parse(values[0]));
					} catch (ParseException e) {
						retParams.put(p.getKey(), values);
						e.printStackTrace();
					}
				}else if(p.getKey().equals("queryCondition")&&model.asMap().containsKey("queryCondition")){
					retParams.put(p.getKey(), model.asMap().get("queryCondition"));
				} else {
					retParams.put(p.getKey(), values[0]);
				}
			}
		}
		
		//企业号ID
		if(req.getSession().getAttribute("wechatNo")!=null){
			retParams.put("wechatNo", req.getSession().getAttribute("wechatNo").toString());
		}
		return retParams;
	}
	
	@RequestMapping(value = "/count.json",method=RequestMethod.GET)
	public ResponseEntity<Integer> getCount(HttpServletRequest req,Model model)throws ServiceException{
		Map<String, Object> params = builderParams(req, model);
		int total= this.service.findCount(params);
		return new ResponseEntity<Integer>(total, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/list")
	@InitpowerInterceptors
	public String list() {
		return crudInfo.ftlFolder + "list";
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<ModelType> get(ModelType modelType,HttpServletRequest req) throws ServiceException {
		ModelType type = service.findById(modelType);
		return new ResponseEntity<ModelType>(type, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/biz")
	@ResponseBody
	public List<ModelType> getBiz(ModelType modelType,HttpServletRequest req,Model model,String loginfo,String userid,String username)throws ServiceException{
		response.setHeader("Access-Control-Allow-Origin", "*");
		if(loginfo!=null){
			Logs log = new Logs();
			log.setLogInfo(loginfo);
			log.setInsertTime(new Date());
			log.setInsertUser(Integer.parseInt(userid));
			log.setUsername(username);
			logsService.add(log);
		}
		Map<String,Object> params=builderParams(req, model);
		return this.service.findByBiz(modelType, params);
	}

	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> post(ModelType type,HttpServletRequest req) throws ServiceException {
		service.add(type);
		if(new Boolean(req.getParameter(BaseCurdController.WITH_MODEL_TYPE))){
			return new ResponseEntity<Object>(type, HttpStatus.OK);
		}else{
			return new ResponseEntity<Object>("", HttpStatus.OK);
		}
	}
		
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<String> put(ModelType type,HttpServletRequest req) throws ServiceException {
		service.modifyById(type);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/save",method=RequestMethod.POST)
	public ResponseEntity<Map<String, Boolean>> save(HttpServletRequest req) throws JsonParseException, JsonMappingException, IOException,
	ServiceException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Boolean> flag = new HashMap<String, Boolean>();

		String deletedList = StringUtils.isEmpty(req.getParameter("deleted")) ? "" : req.getParameter("deleted");
		String upadtedList = StringUtils.isEmpty(req.getParameter("updated")) ? "" : req.getParameter("updated");
		String insertedList = StringUtils.isEmpty(req.getParameter("inserted")) ? "" : req.getParameter("inserted");
		ObjectMapper mapper = new ObjectMapper();
		Map<CommonOperatorEnum, List<ModelType>> params = new HashMap<CommonOperatorEnum, List<ModelType>>();
		if (StringUtils.isNotEmpty(deletedList)) {
			List<Map> list = mapper.readValue(deletedList, new TypeReference<List<Map>>(){});
			List<ModelType> oList=convertListWithTypeReference(mapper,list);
			params.put(CommonOperatorEnum.DELETED, oList);
		}
		if (StringUtils.isNotEmpty(upadtedList)) {
			List<Map> list = mapper.readValue(upadtedList, new TypeReference<List<Map>>(){});
			List<ModelType> oList=convertListWithTypeReference(mapper,list);
			params.put(CommonOperatorEnum.UPDATED, oList);
		}
		if (StringUtils.isNotEmpty(insertedList)) {
			List<Map> list = mapper.readValue(insertedList, new TypeReference<List<Map>>(){});
			List<ModelType> oList=convertListWithTypeReference(mapper,list);
			params.put(CommonOperatorEnum.INSERTED, oList);
		}
		if (params.size() > 0) {
			service.save(params);
		}
		flag.put("success", true);
		return new ResponseEntity<Map<String, Boolean>>(flag, HttpStatus.OK);
	}
	
	/**
	 * 杞崲鎴愭硾鍨嬪垪琛�?
	 * @param mapper
	 * @param list
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<ModelType> convertListWithTypeReference(ObjectMapper mapper,List<Map> list) throws JsonParseException, JsonMappingException, JsonGenerationException, IOException{
		Class<ModelType> entityClass = (Class<ModelType>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
		List<ModelType> tl=new ArrayList<ModelType>(list.size());
		for (int i = 0; i < list.size(); i++) {
			ModelType type=mapper.readValue(mapper.writeValueAsString(list.get(i)),entityClass);
			tl.add(type);
		}
		return tl;
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/do_export",method=RequestMethod.POST)
	public void doExport(ModelType modelType,HttpServletRequest req,Model model,HttpServletResponse response)throws ServiceException{
		 Map<String,Object> params=builderParams(req, model);
         String exportColumns=(String) params.get( "exportColumns");
         String fileName=(String)params.get( "fileName");
         String checkFlag=(String)params.get("checkFlag");
         //澧炲姞鍙傛暟锛岃鍙傛暟鍙互涓嶆寚瀹氾紝浣跨敤榛樿鍊�?
         String rowAccessWindowSizeStr=(String)params.get("rowAccessWindowSize");
         String reduceColnumName=StringUtils.isEmpty(req.getParameter("reduceColnumName"))?"":req.getParameter("reduceColnumName");
         if(!StringUtils.isNotEmpty(checkFlag)){
        	 checkFlag="0";
         }
         ObjectMapper mapper = new ObjectMapper();
          if (StringUtils.isNotEmpty(exportColumns)){
                try {
                     exportColumns=exportColumns.replace( "[" ,"" );
                     exportColumns=exportColumns.replace( "]" ,"" );
                     exportColumns= "[" +exportColumns+"]" ;
                     
                      //瀛楁鍚嶅垪琛�
                     List<Map> ColumnsList=mapper.readValue(exportColumns, new TypeReference<List<Map>>(){});
                     if(ColumnsList!=null&&ColumnsList.size()>0){
                    	  if(StringUtils.isNotEmpty(checkFlag)&&checkFlag.equals("1")){
                    		  ColumnsList.remove(0);
                    	  }
                    	  if(StringUtils.isNotEmpty(reduceColnumName)){
                    		  for(int i=0;i<ColumnsList.size();i++){
                    			  if(ColumnsList.get(i)!=null){
                        			  if(ColumnsList.get(i).get("field")!=null&&reduceColnumName.equals(ColumnsList.get(i).get("field"))){
                        				  ColumnsList.remove(i);
                        				  break;
                        			  }
                    			  }
                    		  }
                    	  }
                     }
                     
                     //List<ModelType> list= this .manager .findByBiz(modelType, params);
                     int total = this.service.findCount(params);
             		SimplePage page = new SimplePage(1, total, (int) total);
             		List<ModelType> list = this.service.findByPage(page, "", "", params);
                     List<Map> listArrayList= new ArrayList< Map>();
                      if (list!= null&&list.size()>0){
                         for (ModelType vo:list){
                            Map map= new HashMap();
                               BeanUtilsCommon.object2MapWithoutNull(vo,map);
                               listArrayList.add(map);
                                 
                         }
                         
                        Integer rowAccessWindowSize = getRowAccessWindowSizeValue(rowAccessWindowSizeStr);
                         
                        HSSFExport.commonExportData(StringUtils.isNotEmpty(fileName) ? fileName : "瀵煎嚭淇℃伅", ColumnsList,
							listArrayList, response, rowAccessWindowSize);
                     }
               } catch (Exception e) {
                     e.printStackTrace();
               }
               

         } else {
                
         }
		
	}
	
	/**
	 * 杞崲鎴愭暣鍨�
	 * @param rowAccessWindowSizeStr
	 * @return
	 */
	private Integer getRowAccessWindowSizeValue(String rowAccessWindowSizeStr) {

		Integer rowAccessWindowSize = 1;

		if (!StringUtils.isEmpty(rowAccessWindowSizeStr)) {

			try {

				rowAccessWindowSize = Integer.parseInt(rowAccessWindowSizeStr);
			} catch (NumberFormatException e) {

				rowAccessWindowSize = 1;
			}
		}

		return rowAccessWindowSize;
	}
	

	public class CrudInfo {

		public CrudInfo(String ftlFolder, BaseCurdService service) {
			super();
			this.ftlFolder = ftlFolder;
			this.service = service;
		}

		private String ftlFolder;

		private BaseCurdService service;

		public String getFtlFolder() {
			return ftlFolder;
		}

		public void setFtlFolder(String ftlFolder) {
			this.ftlFolder = ftlFolder;
		}

		public BaseCurdService getManager() {
			return service;
		}

		public void setManager(BaseCurdService service) {
			this.service = service;
		}
	}
}
