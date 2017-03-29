//package hrTest;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import cn.wonhigh.retail.uc.common.api.model.AuthorityUser;
//import cn.wonhigh.retail.uc.common.api.service.AuthorityUserApi;
//
//import com.topsports.weixin.dao2.CommonUtilMapper;
//import com.topsports.weixin.dao2.HrCandidateBaseMapper;
//import com.yougou.logistics.base.common.exception.RpcException;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:META-INF/applicationContext.xml",
//"classpath:META-INF/spring-service.xml"})
//@Service
//public class HrTest {
//
//	@Autowired
//	private HrCandidateBaseMapper hrCandidateBaseMapper;
//	@Autowired
//	private CommonUtilMapper commonUtilMapper;
//
//	
////	@Test
//	public void getCandidateID(){
//		int ret=-1;
////		Map<String,Object> map=new HashMap<String,Object>();
////		map.put("as_code", "CANDIDATE_ID");
////		map.put("as_segid", null);
////		map.put("as_raise", "N");
////		map.put("as_errorCode", 1);
////		map.put("as_errorText", "");
////		commonUtilMapper.getGenCode(map);
////		System.out.println(map.get("as_errorCode"));
////		System.out.println(map.get("as_errorText"));
//		
//	}
//	
//	//@Test
//	public void getUrl(){
//		String text="jkj你好在的放到fj#url1##url2#fd放到akfdadf#url3#fd";
////		int index=text.indexOf(ch);
////		while(index){
////			
////		}
////			int lastIndex=text.indexOf("#", index);
////			index=lastIndex;
////		}
//	}
//}
